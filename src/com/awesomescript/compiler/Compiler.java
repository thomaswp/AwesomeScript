package com.awesomescript.compiler;

import static com.awesomescript.xml.XmlUtils.iterate;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.comments.BlockComment;
import japa.parser.ast.comments.LineComment;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.BinaryExpr.Operator;
import japa.parser.ast.expr.BooleanLiteralExpr;
import japa.parser.ast.expr.DoubleLiteralExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.MemberValuePair;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.NullLiteralExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.awesomescript.Script;
import com.awesomescript.importer.Action;
import com.awesomescript.importer.Condition;
import com.awesomescript.importer.Domain;
import com.awesomescript.importer.Enumeration;
import com.awesomescript.importer.Importer;
import com.awesomescript.importer.Method;
import com.awesomescript.importer.Parameter;
import com.awesomescript.xml.XmlUtils;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

public class Compiler {
	public final static String ENTRY_POINT = "onTick";
	
	private Domain domain;
	private HashMap<String, SequenceNode> methods = new HashMap<>();

	private boolean loadDomain() {
		if (domain != null) return true;
		try {
			domain = Importer.parseDomain(Importer.PATH);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void decompile(String name, InputStream is, File out) {
		try {
			loadDomain();
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();

			for (org.w3c.dom.Node rootElement : iterate(doc.getElementsByTagName("root"))) {
				RootNode root = new RootNode();
				org.w3c.dom.Node normals = XmlUtils.getChildWithTagName(rootElement, "normal");
				parseXmlNodes(normals, root.normals);
				decompile(name, root, out);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void parseXmlNodes(org.w3c.dom.Node parent, List<Node> list) {
		if (parent == null) return;
		for (org.w3c.dom.Node child : iterate(parent.getChildNodes())) {
			if (!(child instanceof Element)) continue;
			String childName = child.getNodeName();
			if (childName.equals("condition")) {
				ConditionNode node = new ConditionNode();
				list.add(node);
				String id = child.getAttributes().getNamedItem("id").getNodeValue();
				node.method = domain.conditions.get(id);
				if (node.method == null) throw new RuntimeException("No method for " + id);
				node.readXmlArgs(child);
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "normal"), node.normals);
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "else"), node.elses);
			} else if (childName.equals("action")) {
				ActionNode node = new ActionNode();
				list.add(node);
				String id = child.getAttributes().getNamedItem("id").getNodeValue();
				node.method = domain.actions.get(id);
				if (node.method == null) throw new RuntimeException("No method for " + id);
				node.readXmlArgs(child);
			} else if (childName.equals("orblock") || childName.equals("andblock")) {
				OpNode node = childName.equals("orblock") ? new OrNode() : new AndNode();
				list.add(node);
				List<Node> conds = new ArrayList<>();
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "or"), conds);
				for (Node n : conds) node.operands.add((ConditionNode) n);
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "normal"), node.normals);
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "else"), node.elses);
			} else if (childName.equals("sequence")) {
				SequenceNode node = new SequenceNode();
				list.add(node);
				node.readXmlArgs(child);
				parseXmlNodes(XmlUtils.getChildWithTagName(child, "normal"), node.normals);
			} else {
				throw new RuntimeException("Unknown tag: " + childName);
			}
		}
	}
	
	private void decompile(String name, RootNode root, File out) {
		loadDomain();
		
		try {
			JCodeModel model = new JCodeModel();
			JDefinedClass script = model._class(Domain.PACKAGE + "." + name);
			script._extends(Script.class);
			JMethod onTick = script.method(JMod.PUBLIC, void.class, Domain.ENTRY_POINT);
			root.writeJava(model, script, onTick.body());
			model.build(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compile(InputStream is, OutputStream os) {
		loadDomain();
		try {
			CompilationUnit cu = JavaParser.parse(is);
			
			final RootNode rootNode = new RootNode();
			
			new VoidVisitorAdapter<Object>() {
				@Override
		        public void visit(MethodDeclaration n, Object arg) {
		            if (!n.getName().equals(ENTRY_POINT)) {
		            	int mods = n.getModifiers();
		            	if (Modifier.isStatic(mods)) return;
		            	SequenceNode method = new SequenceNode();
		            	if (n.getAnnotations() != null) {
			            	for (AnnotationExpr annotation : n.getAnnotations()) {
			            		if (annotation.getName().getName().equals("Sequence")) {
			            			method.sequence = true;
			            			for (japa.parser.ast.Node node : annotation.getChildrenNodes()) {
			            				if (node instanceof MemberValuePair) {
			            					String name = ((MemberValuePair) node).getName();
			            					if (name.equalsIgnoreCase("blocking")) {
				            					Expression value = ((MemberValuePair) node).getValue();
				            					if (value instanceof BooleanLiteralExpr) {
				            						method.blocking = ((BooleanLiteralExpr) value).getValue();
				            					}
			            					}
			            				}
			            			}
			            		}
			            	}
		            	}
		            	methods.put(n.getName(), method);
		            	parseStatements(n.getBody(), method.normals);
		            }
		        }
			}.visit(cu, null);
			
			new VoidVisitorAdapter<Object>() {
				@Override
		        public void visit(MethodDeclaration n, Object arg) {
		            if (n.getName().equals(ENTRY_POINT)) {
		            	parseStatements(n.getBody(), rootNode.normals);
		            }
		        }
			}.visit(cu, null);
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element enemyNode = doc.createElement("enemy");
			doc.appendChild(enemyNode);
			
			Element behaviorNode = doc.createElement("behaviour");
			enemyNode.appendChild(behaviorNode);
			
			rootNode.writeXML(doc, behaviorNode);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(os);
	 
			transformer.transform(source, result);
			
			decompile("TestScript", rootNode, new File("./out"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void unknowType(Object o) {
		throw new RuntimeException("Unknow type: " + o.getClass());
	}
	
	private void parseStatements(BlockStmt statement, final List<Node> agg)  {
		
		new VoidVisitorAdapter<Object>() {

			String lastComment = null;
			
			private void addComment(String text) {
				if (text.contains("\n")) {
					String[] parts = text.split("\n");
					for (String part : parts) {
						addComment(part);
					}
					return;
				}
				text = text.trim();
				text = text.replace("\t", " ");
				if (text.replace(" ", "").length() == 0) return;
				if (text.startsWith("*")) text = text.substring(1);
				text = text.trim();
				if (lastComment != null && lastComment.length() > 0) {
					if (!text.startsWith(" ")) lastComment += " ";
					lastComment += text;
				} else {
					lastComment = text;
				}
			}
			
			private void add(Node node) {
				node.comment = lastComment;
				agg.add(node);
				lastComment = null;
			}
			
			@Override
			public void visit(BlockComment n, Object arg) {
				addComment(n.getContent());
			}

			@Override
			public void visit(LineComment n, Object arg) {
				addComment(n.getContent());
			}

			@Override
			public void visit(IfStmt n, Object arg) {
				add(parseIf(n));
			}

			@Override
			public void visit(MethodCallExpr n, Object arg) {
				SequenceNode method = methods.get(n.getName());
				if (method == null) {
					add(parseMethodCall(n));
				} else {
					if (method.sequence) {
						add(method);
					} else {
						for (Node node : method.normals) {
							add(node);
						}	
					}
				}
			}

			@Override
			public void visit(AssignExpr n, Object arg) {
				
			}

			@Override
			public void visit(VariableDeclarationExpr n,
					Object arg) {
				
			}

			@Override
			public void visit(VariableDeclarator n, Object arg) {
				
			}

			@Override
			public void visit(VariableDeclaratorId n, Object arg) {
				
			}
			
		}.visit(statement, null);
	}
	
	private ConditionNode parseIf(IfStmt n) {
		Expression exp = n.getCondition();
		
		ConditionNode condition = parseConditionalExpression(exp);
		
		if (n.getThenStmt() instanceof BlockStmt) {
			parseStatements((BlockStmt) n.getThenStmt(), condition.normals);
		} else {
			unknowType(n.getThenStmt());
		}
		
		Statement elseStmt = n.getElseStmt();
		if (elseStmt != null) {
			if (elseStmt instanceof IfStmt) {
				condition.elses.add(parseIf((IfStmt) elseStmt));
			} else if (elseStmt instanceof BlockStmt) {
				parseStatements((BlockStmt) elseStmt, condition.elses);
			} else {
				unknowType(elseStmt);
			}
		}
		
		return condition;
	}

	private ConditionNode parseConditionalExpression(Expression exp) {
		ConditionNode condition = null;
		if (exp instanceof MethodCallExpr) {
			condition = (ConditionNode) parseMethodCall((MethodCallExpr) exp);
		} else if (exp instanceof BinaryExpr) {
			BinaryExpr binExp = (BinaryExpr) exp;
			Operator op = binExp.getOperator();
			List<ConditionNode> children = new ArrayList<ConditionNode>();
			children.add(parseConditionalExpression(binExp.getLeft()));
			children.add(parseConditionalExpression(binExp.getRight()));
			OpNode opNode = null;
			if (op == Operator.and) {
				condition = opNode = new AndNode();
			} else if (op == Operator.or) {
				condition = opNode = new OrNode();
			} else {
				unknowType(op);
			}
			
			addOperatorChildren(children, opNode);
		} else {
			unknowType(exp);
		}
		return condition;
	}

	private void addOperatorChildren(List<ConditionNode> children, OpNode parent) {
		for (ConditionNode child : children) {
			if (child.getClass() == ConditionNode.class) {
				parent.operands.add(child);
			} else if (child.getClass() == parent.getClass()) {
				addOperatorChildren(((OpNode) child).operands, parent);
			} else {
				throw new RuntimeException("Cannot mix &&s and ||s");
			}
		}
	}
	
	private MethodNode parseMethodCall(MethodCallExpr n) {
		String name = n.getName();
		
		Method method = null;
		for (Action action : domain.actions.values()) {
			if (Method.getMethodName(action.name).equals(name)) {
				method = action;
			}
		}
		for (Condition condition : domain.conditions.values()) {
			if (Method.getMethodName(condition.name).equals(name)) {
				method = condition;
			}
		}
		
		MethodNode node;
		if (method instanceof Action) {
			node = new ActionNode();
		} else {
			node = new ConditionNode();
		}
		node.method = method;
		
		int i = 0;
		for (Expression exp : n.getArgs()) {
			Parameter param = method.parameters.get(i++);
			if (exp instanceof StringLiteralExpr) {
				String value = ((StringLiteralExpr) exp).getValue();
				if (exp instanceof DoubleLiteralExpr) value = value.replace("f", "");
				node.arguments.add(value);
			} else if (exp instanceof FieldAccessExpr) {
				node.arguments.add(parseEnumValue(exp, param));
			} else if (exp instanceof NameExpr) { 
				unknowType(exp);
			} else if (exp instanceof MethodCallExpr) {
				MethodCallExpr methodExp = (MethodCallExpr) exp;
				String expName = methodExp.getName();
				Expression expScope = methodExp.getScope();
				if (expScope instanceof NameExpr) {
					String scopeName = ((NameExpr) expScope).getName();
					if (scopeName.equals("EnumSet") && expName.equals("of")) {
						List<Expression> args = methodExp.getArgs();
						List<String> checks = new ArrayList<String>();
						for (Expression arg : args) {
							if (arg instanceof FieldAccessExpr) {
								checks.add(parseEnumValue(arg, param));
							} else {
								unknowType(arg);
							}
						}
						String value = "";
						for (String check : checks) {
							value += check + ";;";
						}
						node.arguments.add(value);
					} else {
						unknowType(expScope);
					}
				} else {
					unknowType(expScope);
				}
			} else if (exp instanceof NullLiteralExpr) {
				node.arguments.add("");
			} else {
				unknowType(exp);
			}
		}
		
		return node;
	}

	private String parseEnumValue(Expression exp, Parameter param) {
		String field = ((FieldAccessExpr) exp).getField();
		Expression scope = ((FieldAccessExpr) exp).getScope();
		if (scope instanceof NameExpr) {
			String scopeName = ((NameExpr) scope).getName();
			if (Enumeration.getClassName(param.values.id).equals(scopeName)) {
				for (String value : param.values.values) {
					if (Enumeration.getClassName(value).equals(field)) {
						return value;
					}
				}
				unknowType(field);
			} else {
				throw new RuntimeException("Enumeration missmatch");
			}
		} else {
			unknowType(scope);
		}
		return null;
	}
}

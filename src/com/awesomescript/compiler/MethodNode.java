package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.awesomescript.importer.Enumeration;
import com.awesomescript.importer.Method;
import com.awesomescript.importer.Parameter;
import com.awesomescript.xml.XmlUtils;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;


public abstract class MethodNode extends Node {
	public Method method;
	public List<String> arguments = new ArrayList<>();

	@Override
	protected void addAttributes(Document doc, Element parent) {
		super.addAttributes(doc, parent);
		if (method != null) parent.setAttribute("id", method.name);
	}

	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		if (method != null) {
			for (int i = 0; i < method.parameters.size(); i++) {
				Parameter param = method.parameters.get(i);
				if (i >= arguments.size()) throw new RuntimeException("Not enough arguments for " + method.name);

				Element element = doc.createElement(param.type);
				parent.appendChild(element);
				element.setAttribute("id", param.name);
				if (param.values != null) element.setAttribute("values", param.values.id);
				if (param.multiselect) element.setAttribute("multiselect", "true");
				element.setTextContent(arguments.get(i));
			}
		}
	}

	@Override
	public void writeJava(JCodeModel model, JDefinedClass script, JBlock body) {
		super.writeJava(model, script, body);
		JInvocation call = body.invoke(Method.getMethodName(method.name));
		addArgs(model, call);
	}
	
	protected JExpression getJavaExpression(JCodeModel model) {
		JInvocation call = JExpr.invoke(Method.getMethodName(method.name));
		addArgs(model, call);
		return call;
	}

	protected final JExpression addArgs(JCodeModel model, JInvocation call) {
		for (int i = 0; i < method.parameters.size(); i++) {
			Parameter param = method.parameters.get(i);
			if (i >= arguments.size()) throw new RuntimeException("Not enough arguments for " + method.name);
			String arg = arguments.get(i);

			if (param.type.equals("string")) {
				if (param.values != null) {
					if (arg.length() == 0) {
						call.arg(JExpr._null());
					} else {
						JClass values = model.ref(Enumeration.getClassName(param.values.id));
						if (param.multiselect) {
							JClass set = model.ref(EnumSet.class);
							JInvocation setof = set.staticInvoke("of");
							String[] parts = arg.split(";;");
							for (String part : parts) {
								setof.arg(values.staticRef(Enumeration.getClassName(part)));
							}
							call.arg(setof);
						} else {
							call.arg(values.staticRef(Enumeration.getClassName(arg)));
						}
					}
				} else {
					call.arg(arg);
				}
			} else if (param.type.equals("float")) {
				call.arg(JExpr.lit(Double.parseDouble(arg)));
			}

		}
		return call;
	}


	public void readXmlArgs(org.w3c.dom.Node node) {
		super.readXmlArgs(node);
		String args[] = new String[method.parameters.size()];
		int successes = 0;
		for (org.w3c.dom.Node child : XmlUtils.iterate(node.getChildNodes())) {
			if (!(child instanceof Element)) continue;
			String name = child.getNodeName();
			if (name.equals("string") || name.equals("float")) {
				String id = child.getAttributes().getNamedItem("id").getNodeValue();
				for (int i = 0; i < args.length; i++) {
					if (method.parameters.get(i).name.equals(id)) {
						args[i] = child.getTextContent();
						successes++;
					}
				}
			}
		}
		if (successes < args.length) System.err.println("Not enough args for " + method.name + ": " + successes + " < " + args.length);
		for (String arg : args) arguments.add(arg == null ? "" : arg);
	}
}

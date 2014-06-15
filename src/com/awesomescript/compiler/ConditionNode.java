package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDefinedClass;

public class ConditionNode extends MethodNode {
	public List<Node> normals = new ArrayList<>();
	public List<Node> elses = new ArrayList<>();
	
	@Override
	protected String getTagName() {
		return "condition";
	}
	
	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		
		Element normalElement = doc.createElement("normal");
		parent.appendChild(normalElement);
		for (Node normal : normals) {
			normal.writeXML(doc, normalElement);
		}
		
		Element elseElement = doc.createElement("else");
		parent.appendChild(elseElement);
		for (Node or : elses) {
			or.writeXML(doc, elseElement);
		}
	}

	@Override
	public void writeJava(JCodeModel model, JDefinedClass script, JBlock body) {
		writeComment(body);
		JConditional conditional = body._if(getJavaExpression(model));
		for (Node node : normals) {
			node.writeJava(model, script, conditional._then());
		}
		for (Node node : elses) {
			node.writeJava(model, script, conditional._else());
		}
	}

}

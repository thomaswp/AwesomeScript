package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;


public class RootNode extends Node {
	public int x = 110, y = 40;
	public List<Node> normals = new ArrayList<>();
	
	@Override
	protected String getTagName() {
		return "root";
	}

	@Override
	protected void addAttributes(Document doc, Element parent) {
		super.addAttributes(doc, parent);
		parent.setAttribute("x", String.valueOf(x));
		parent.setAttribute("y", String.valueOf(y));
	}

	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		
		Element normal = doc.createElement("normal");
		parent.appendChild(normal);
		
		for (Node node : normals) {
			node.writeXML(doc, normal);
		}
	}

	@Override
	public void writeJava(JCodeModel model, JDefinedClass script, JBlock body) {
		super.writeJava(model, script, body);
		for (Node node : normals) {
			node.writeJava(model, script, body);
		}
	}

	
}

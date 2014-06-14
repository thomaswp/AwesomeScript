package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
			normal.write(doc, normalElement);
		}
		
		Element elseElement = doc.createElement("else");
		parent.appendChild(elseElement);
		for (Node or : elses) {
			or.write(doc, elseElement);
		}
	}

}

package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SequenceNode extends Node {

	public List<Node> normals = new ArrayList<>();
	public boolean sequence, blocking;
	
	@Override
	protected String getTagName() {
		return "sequence";
	}
	
	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		
		Element b = doc.createElement("string");
		parent.appendChild(b);
		b.setAttribute("name", "Is blocking");
		b.setTextContent(blocking ? "yes" : "no");
		
		Element normal = doc.createElement("normal");
		parent.appendChild(normal);
		for (Node node : normals) {
			node.write(doc, normal);
		}
	}

}

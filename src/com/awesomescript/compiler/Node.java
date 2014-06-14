package com.awesomescript.compiler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Node {
	
	public String comment;
	protected abstract String getTagName();
	
	protected void addAttributes(Document doc, Element parent) { }
	
	protected void addChildren(Document doc, Element parent) {
		if (comment != null) {
			Element comment = doc.createElement("string");
			parent.appendChild(comment);
			comment.setAttribute("id", "Comment");
			comment.setTextContent(this.comment);
		}
	}
	
	public void write(Document doc, Element parent) {
		Element element = doc.createElement(getTagName());
		parent.appendChild(element);
		addAttributes(doc, element);
		addChildren(doc, element);
	}
}

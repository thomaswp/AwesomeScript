package com.awesomescript.compiler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.awesomescript.xml.XmlUtils;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

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
	
	public void writeXML(Document doc, Element parent) {
		Element element = doc.createElement(getTagName());
		parent.appendChild(element);
		addAttributes(doc, element);
		addChildren(doc, element);
	}
	
	protected void writeComment(JBlock body) {
		if (comment != null) {
			body.directStatement("// " + comment);
		}
	}

	public void writeJava(JCodeModel model, JDefinedClass script, JBlock body) {
		writeComment(body);
	}
		
	public void readXmlArgs(org.w3c.dom.Node node) {
		iterateAttributes(node, new Reader() {
			@Override
			public void read(String id, String text) {
				if (id.equals("Comment")) comment = text;
			}
		});
	}
	
	protected void iterateAttributes(org.w3c.dom.Node node, Reader reader) { 
		for (org.w3c.dom.Node child : XmlUtils.iterate(node.getChildNodes())) {
			if (!(child instanceof Element)) continue;
			String name = child.getNodeName();
			if (name.equals("string") || name.equals("float")) {
				String id = child.getAttributes().getNamedItem("id").getNodeValue();
				reader.read(id, child.getTextContent());
			}
		}
	}
	
	protected interface Reader {
		void read(String id, String text);
	}
}

package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.awesomescript.Script.Sequence;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;

public class SequenceNode extends Node {

	public final static String DEFAULT_METHOD_NAME = "sequence";
	
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
			node.writeXML(doc, normal);
		}
	}

	@Override
	public void writeJava(JCodeModel model, JDefinedClass script, JBlock body) {
		super.writeJava(model, script, body);
		if (sequence) {
			int i = 0;
			for (JMethod method : script.methods()) {
				if (!method.name().equals(DEFAULT_METHOD_NAME + i)) {
					break;
				}
				i++;
			}
			JMethod method = script.method(JMod.NONE, void.class, DEFAULT_METHOD_NAME + i);
			JAnnotationUse annotation = method.annotate(Sequence.class);
			annotation.param("blocking", blocking);
			
			body.add(JExpr.invoke(method));
			
			body = method.body();
		}
		for (Node node : normals) {
			node.writeJava(model, script, body);
		}
	}

}

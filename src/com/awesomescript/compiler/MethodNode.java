package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.awesomescript.importer.Method;
import com.awesomescript.importer.Parameter;


public abstract class MethodNode extends Node {
	public Method method;
	public List<String> parameters = new ArrayList<>();

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
				if (i >= parameters.size()) throw new RuntimeException("Not enough parameters for " + method.name);
				
				Element element = doc.createElement(param.type);
				parent.appendChild(element);
				element.setAttribute("id", param.name);
				if (param.values != null) element.setAttribute("values", param.values.id);
				if (param.multiselect) element.setAttribute("multiselect", "true");
				element.setTextContent(parameters.get(i));
			}
		}
	}
	
	
}

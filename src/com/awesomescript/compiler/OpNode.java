package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OpNode extends ConditionNode {
	
	public List<ConditionNode> operands = new ArrayList<ConditionNode>();
	
	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		
		Element opElement = doc.createElement("or");
		parent.appendChild(opElement);
		for (Node op : operands) {
			op.write(doc, opElement);
		}
	}
	
}

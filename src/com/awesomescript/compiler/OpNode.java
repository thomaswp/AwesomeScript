package com.awesomescript.compiler;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;

public abstract class OpNode extends ConditionNode {
	
	public List<ConditionNode> operands = new ArrayList<ConditionNode>();
	
	protected abstract JExpression concat(JExpression a, JExpression b);
	
	@Override
	protected void addChildren(Document doc, Element parent) {
		super.addChildren(doc, parent);
		
		Element opElement = doc.createElement("or");
		parent.appendChild(opElement);
		for (Node op : operands) {
			op.writeXML(doc, opElement);
		}
	}
	
	@Override
	protected JExpression getJavaExpression(JCodeModel model) {
		if (operands.size() == 0) return JExpr.FALSE;
		JExpression exp = operands.get(0).getJavaExpression(model);
		for (int i = 1; i < operands.size(); i++) {
			exp = concat(exp, operands.get(i).getJavaExpression(model));
		}
		return exp;
	}
}

package com.awesomescript.compiler;

import com.sun.codemodel.JExpression;

public class OrNode extends OpNode {

	@Override
	protected String getTagName() {
		return "orblock";
	}

	@Override
	protected JExpression concat(JExpression a, JExpression b) {
		return a.cor(b);
	}
}

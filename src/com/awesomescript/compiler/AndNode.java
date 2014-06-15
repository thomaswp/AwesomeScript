package com.awesomescript.compiler;

import com.sun.codemodel.JExpression;

public class AndNode extends OpNode {

	@Override
	protected String getTagName() {
		return "andblock";
	}

	@Override
	protected JExpression concat(JExpression a, JExpression b) {
		return a.cand(b);
	}
}

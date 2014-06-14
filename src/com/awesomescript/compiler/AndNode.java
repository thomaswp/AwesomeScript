package com.awesomescript.compiler;

public class AndNode extends OrNode {

	@Override
	protected String getTagName() {
		return "andblock";
	}
}

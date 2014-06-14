package com.awesomescript.importer;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;


public abstract class Method {

	public String name;
	public List<Parameter> parameters = new ArrayList<>();

	protected abstract Class<?> getReturnType();

	public void write(JDefinedClass clazz, JCodeModel model) {
		try {
			JMethod method = clazz.method(JMod.PROTECTED, getReturnType(), getMethodName(name));
			for (Parameter parameter : parameters) {
				parameter.write(method, model);
			}
			method.body()._throw(JExpr._new(model.ref(UnsupportedOperationException.class)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getMethodName(String value) {
		String[] parts = value.split("[ \\-_]");
		String name = "";
		for (String part : parts) {
			if (name.length() == 0) {
				name += part.toLowerCase();
			} else if (part.length() > 0) {
				name += part.substring(0, 1).toUpperCase() + 
						part.substring(1).toLowerCase();
			}
		}
		if (name.equals("class")) name = "clazz";
		return name;
	}
}

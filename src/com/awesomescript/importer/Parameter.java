package com.awesomescript.importer;
import java.util.EnumSet;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JMethod;


public class Parameter {
	public String name;
	public String type;
	public Enumeration values;
	public boolean multiselect;
	
	public void write(JMethod method, JCodeModel model) {
		String name = getParameterName(this.name);
		if (type.equalsIgnoreCase("string")) {
			if (values != null) {
				if (multiselect) {
					JClass rawClass = model.ref(EnumSet.class);
					method.param(rawClass.narrow(values.type), name);
					
				} else {
					method.param(values.type, name);
				}
			} else {
				method.param(String.class, name);
			}
		} else if (type.equalsIgnoreCase("float")) {
			method.param(double.class, name);
		} else {
			throw new RuntimeException("Unknown parameter type: " + type);
		}
	}
	
	public static String getParameterName(String value) {
		return Method.getMethodName(value);
	}
}

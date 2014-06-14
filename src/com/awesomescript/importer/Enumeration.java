package com.awesomescript.importer;
import java.util.ArrayList;
import java.util.List;

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JType;


public class Enumeration {
	public String id;
	public List<String> values = new ArrayList<>();
	public transient JType type;
	
	public void write(JDefinedClass clazz) {
		try {
			JDefinedClass enumeration = clazz._enum(getClassName(id));
			type = enumeration;
			for (String value : values) {
				enumeration.enumConstant(getClassName(value));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getClassName(String value) {
		String[] parts = value.split("[ \\-]");
		String name = "";
		for (String part : parts) {
			name += part.substring(0, 1).toUpperCase() + 
					part.substring(1);
		}
		return name;
	}
}

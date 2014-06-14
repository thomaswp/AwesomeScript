package com.awesomescript.importer;

import java.io.FileInputStream;
import java.io.IOException;

import com.awesomescript.compiler.Compiler;

public class ScriptBase {
	protected void compile() {
		try {
			FileInputStream fis = new FileInputStream(getPath());
			new Compiler().compile(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getPath() {
		String path = getClass().getName();
		path = path.replace(".", "/");
		path = "src/" + path + ".java";
		return path;
	}
}

package com.awesomescript.importer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.awesomescript.compiler.Compiler;

public class ScriptBase {
	protected void compile(String outputPath) {
		try {
			FileInputStream fis = new FileInputStream(getPath());
			FileOutputStream fos = new FileOutputStream(outputPath);
			new Compiler().compile(fis, fos);
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

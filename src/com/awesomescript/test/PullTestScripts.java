package com.awesomescript.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.awesomescript.compiler.Compiler;

public class PullTestScripts {
	
	public final static String SCRIPT_ROOT = "E:/Program Files (x86)/Steam/SteamApps/common/Awesomenauts/Data/BehaviourCreator/ExampleAIs";
	
	public static void main(String[] args) throws FileNotFoundException {
		File out = new File("./samples");
		out.mkdirs();
		Compiler compiler = new Compiler();
		for (File file : new File(SCRIPT_ROOT).listFiles()) {
			String name = file.getName();
			name = name.replace(".xml", "");
			System.out.println("Parsing: " + name);
			try {
				compiler.decompile(name, new FileInputStream(file), out);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
}

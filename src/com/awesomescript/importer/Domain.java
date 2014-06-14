package com.awesomescript.importer;
import java.io.File;
import java.util.HashMap;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMod;


public class Domain {
	
	public final static String PACKAGE = "com.awesomescript";
	
	public HashMap<String, Enumeration> enumerations = new HashMap<>();
	public HashMap<String, Action> actions = new HashMap<>();
	public HashMap<String, Condition> conditions = new HashMap<>();
	
	public void write(File file) {
		try {
			file.mkdirs();
			
			JCodeModel model = new JCodeModel();
			
			JDefinedClass script = model._class(JMod.ABSTRACT | JMod.PUBLIC, PACKAGE +  ".Script", ClassType.CLASS);
			script._extends(ScriptBase.class);

			for (Enumeration e : enumerations.values()) {
				e.write(script);
			}
			
			for (Action action : actions.values()) {
				action.write(script, model);
			}
			
			for (Condition condition : conditions.values()) {
				condition.write(script, model);
			}
			
			script.method(JMod.ABSTRACT | JMod.PROTECTED, void.class, "onTick");
			
			JDefinedClass sequence = script._annotationTypeDeclaration("Sequence");
			sequence.method(JMod.NONE, boolean.class, "blocking");
			
			model.build(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

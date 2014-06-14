package com.awesomescript.test;

import java.util.EnumSet;

import com.awesomescript.Script;


public class MyScript extends Script {

	
	@Override
	protected void onTick() {
		//comment
		adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 12, Valueadjust.Set);
		/*
		 * block ><
		 * blocity
		 * block 
		 */
		adjustcounter("moo", "3", Valueadjust.Add);
		//c1
		
		isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), 
				Yesno.No, null, "name", 
				0, 0, 10, 10, Yesno.Yes, Yesno.No);
		
		things();
		
		if (aregoldcoinsinarea(5, Valuecompare.Less, 4, 10, 20, 20, Yesno.Yes) &&
				checkclass(Targetself.Self, "me") &&
				checkclass(Targetself.Target, "boo")) { //c2
			//c3
			log("Hello", "counter1", "bool1");
		} else if (checkcharacterflag(Characterflags.IsBlinded, Yesno.No, Targetself.Target)) {
			log("Hello2", "counter1", "bool1");
		} else {
			log("Hello", "counter1", "bool1");
		}
		
		things();
		
		blockingThings();
		
	}
	
	void things() {
		adjustcounter("a", "b", Valueadjust.Add);
	}
	
	@Sequence( blocking = true )
	void blockingThings() {
		adjustcounter("c", "d", Valueadjust.Add);
		adjustcounter("e", "f", Valueadjust.Add);
	}
	
	public static void main(String[] args) {
		new MyScript().compile();
	}

}

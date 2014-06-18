package com.awesomescript.test;

import java.util.EnumSet;

import com.awesomescript.Script;


public class MyScript extends Script {

	
	@Override
	protected void onTick() {
		
		//comment
		adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 12, Valueadjust.Set);
		/*
		 * block ><
		 * blocity
		 * block 
		 */
		adjustCounter("moo", "3", Valueadjust.Add);
		//c1
		
		isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), 
				Yesno.No, null, "name", 
				0, 0, 10, 10, Yesno.Yes, Yesno.No);
		
		things();
		
		if (areGoldCoinsInArea(5, Valuecompare.Less, 4, 10, 20, 20, Yesno.Yes) &&
				checkClass(Targetself.Self, "me") &&
				checkClass(Targetself.Target, "boo")) { //c2
			//c3
			log("Hello", "counter1", "bool1");
		} else if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.No, Targetself.Target)) {
			log("Hello2", "counter1", "bool1");
		} else {
			log("Hello", "counter1", "bool1");
		}
		
		things();
		
		blockingThings();
		
	}

	void things2() {
		adjustCounter("a1", "b2", Valueadjust.Add);
	}
	
	void things() {
		adjustCounter("a", "b", Valueadjust.Add);
		things2();
	}
	
	@Sequence( blocking = true )
	void blockingThings() {
		adjustCounter("c", "d", Valueadjust.Add);
		adjustCounter("e", "f", Valueadjust.Add);
	}
	
	public static void main(String[] args) {
		new MyScript().compile("MyScript.xml");
	}

}

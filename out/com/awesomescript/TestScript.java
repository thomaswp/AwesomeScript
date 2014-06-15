
package com.awesomescript;

import java.util.EnumSet;

public class TestScript
    extends Script
{


    public void onTick() {
        // comment
        adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 12.0D, Valueadjust.Set);
        // block >< blocity block
        adjustcounter("moo", "3", Valueadjust.Add);
        // c1
        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, null, "name", 0.0D, 0.0D, 10.0D, 10.0D, Yesno.Yes, Yesno.No)) {
        }
        adjustcounter("a", "b", Valueadjust.Add);
        adjustcounter("a1", "b2", Valueadjust.Add);
        if ((aregoldcoinsinarea(5.0D, Valuecompare.Less, 4.0D, 10.0D, 20.0D, 20.0D, Yesno.Yes)&&checkclass(Targetself.Self, "me"))&&checkclass(Targetself.Target, "boo")) {
            // c3
            log("Hello", "counter1", "bool1");
        } else {
            if (checkcharacterflag(Characterflags.IsBlinded, Yesno.No, Targetself.Target)) {
                log("Hello2", "counter1", "bool1");
            } else {
                log("Hello", "counter1", "bool1");
            }
        }
        adjustcounter("a", "b", Valueadjust.Add);
        adjustcounter("a1", "b2", Valueadjust.Add);
        sequence0();
    }

    @Script.Sequence(blocking = true)
    void sequence0() {
        adjustcounter("c", "d", Valueadjust.Add);
        adjustcounter("e", "f", Valueadjust.Add);
    }

}

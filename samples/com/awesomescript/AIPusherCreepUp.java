
package com.awesomescript;

import java.util.EnumSet;

public class AIPusherCreepUp
    extends Script
{


    public void onTick() {
        setBool("GoUp", Flagtoggle.Yes);
        executeBehaviourTree("AIPusherCreep");
        if (getBoolEquals("GoUp", Yesno.Yes)) {
            if (getBoolEquals("firstdownjump", Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "BOTDOWNJUMP", 0.0D, 0.0D, 0.01D, 0.01D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.DOWN, 1.0D);
                    sequence0();
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.2D);
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
        setBool("firstdownjump", Flagtoggle.Yes);
    }

}

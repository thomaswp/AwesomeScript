
package com.awesomescript;

import java.util.EnumSet;

public class AICreepCeilingShooter
    extends Script
{


    public void onTick() {
        if (getBoolEquals("RockReady", Yesno.Yes)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.35D, 0.15D, 0.7D, Yesno.No, Yesno.No)) {
                setBool("RockReady", Flagtoggle.No);
                pressStick(Directions.DOWN, 0.2D);
                pressButton(Buttons.FACE_LEFT, 0.1D);
                sequence0();
            }
        }
        if (timePassed(Timeunits.Seconds, 5.0D)) {
            if (once()) {
                setBool("RockReady", Flagtoggle.Yes);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(9.0D);
        setBool("RockReady", Flagtoggle.Yes);
    }

}

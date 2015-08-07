
package com.awesomescript;

import java.util.EnumSet;

public class AICritter
    extends Script
{


    public void onTick() {
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.0D, 0.19D, 0.02D, Yesno.No, Yesno.No)||isOnCreepTurner(Yesno.Yes, Forwardbackward.BACKWARD)) {
            pressStick(Directions.BACKWARD, 0.0D);
        } else {
            // check walls
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
            }
            pressStick(Directions.FORWARD, 0.1D);
        }
        executeBehaviourTree("StatusEffects");
    }

}

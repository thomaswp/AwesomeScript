
package com.awesomescript;

import java.util.EnumSet;

public class AIStarstormTurretCreep
    extends Script
{


    public void onTick() {
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.2D, 0.0D, 0.4D, 0.65D, Yesno.Yes, Yesno.No)) {
            aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
            sequence0();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.65D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

}


package com.awesomescript;

import java.util.EnumSet;

public class AIRangedCreepCocoon
    extends Script
{


    public void onTick() {
        if (once()) {
            enableUpgrade(Yesno.Yes, "CreepInCocoon");
            enableUpgrade(Yesno.Yes, "Butterfly");
            // Target the droid
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidMelee", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.02D, 0.02D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
            if (hasTarget(Yesno.Yes)) {
                sequence0();
            } else {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
            }
        }
        if (isUpgradeEnabled(Yesno.No, "CreepInCocoon")) {
            executeBehaviourTree("AIRangedCreep");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(2.0D);
        enableUpgrade(Yesno.No, "CreepInCocoon");
    }

}

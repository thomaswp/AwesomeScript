
package com.awesomescript;

import java.util.EnumSet;

public class FN_HealbotLogicMesp
    extends Script
{


    public void onTick() {
        if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
            // Is a healbot nearby?
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepHealTotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.1D, 0.0D, 0.6D, 0.2D, Yesno.Yes)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 20.0D, "1", 0.0D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                } else {
                    // Target the healbot
                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepHealTotem", Yesno.No, Yesno.No, 0.1D, 0.0D, 0.6D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                    // Confirm that I am targetting the healbot
                    if (checkClass(Targetself.Target, "CreepHealTotem")) {
                        setBool("MoveAwayFromTarget", Flagtoggle.No);
                        // Move towards the healbot
                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                    }
                }
            }
        }
    }

}

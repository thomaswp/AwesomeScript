
package com.awesomescript;

import java.util.EnumSet;

public class FN_FindAndTargetEnemiesShortRange
    extends Script
{


    public void onTick() {
        setBool("EnemyFound", Flagtoggle.No);
        if (getBoolEquals("IgnoreEnemies", Yesno.No)) {
            removeTarget();
            // Any Enemies?
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                // Priority 1: Summoner
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                if (hasTarget(Yesno.No)) {
                    // Priority 2: Players
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    if (hasTarget(Yesno.No)) {
                        // Priority 3: Creeps
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.Yes)) {
                            setBool("EnemyFound", Flagtoggle.Yes);
                            // chaseBattle (4)
                            adjustCounter("setState", "4", Valueadjust.Set);
                        }
                    } else {
                        setBool("EnemyFound", Flagtoggle.Yes);
                        // chaseBattle (4)
                        adjustCounter("setState", "4", Valueadjust.Set);
                    }
                } else {
                    setBool("EnemyFound", Flagtoggle.Yes);
                    // chaseBattle (4)
                    adjustCounter("setState", "4", Valueadjust.Set);
                }
            }
            if (hasTarget(Yesno.Yes)) {
                // chaseBattle(4)
                adjustCounter("setState", "4", Valueadjust.Set);
            }
        }
    }

}

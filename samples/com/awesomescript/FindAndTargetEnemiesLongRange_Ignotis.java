
package com.awesomescript;

import java.util.EnumSet;

public class FindAndTargetEnemiesLongRange_Ignotis
    extends Script
{


    public void onTick() {
        setBool("EnemyFound", Flagtoggle.No);
        if (getBoolEquals("IgnoreEnemies", Yesno.No)) {
            removeTarget();
            // Look Behind me
            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                // Any Enemies?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -2.0D, 0.0D, 6.0D, 1.0D, Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                        // Priority 1: Players
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Creeps
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
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
                        // Priority 1: Creeps
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Players
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
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
                    }
                }
            } else {
                // Any Enemies?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 2.0D, 0.0D, 6.0D, 1.0D, Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                        // Priority 1: Players
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Creeps
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
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
                        // Priority 1: Creeps
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Players
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 2.7D, 0.0D, 6.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
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
                    }
                }
            }
            if (hasTarget(Yesno.Yes)) {
                // chaseBattle(4)
                adjustCounter("setstate", "4", Valueadjust.Set);
            }
        }
    }

}

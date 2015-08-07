
package com.awesomescript;

import java.util.EnumSet;

public class VeankoFindAndTargetEnemiesShortRange_Ignotis
    extends Script
{


    public void onTick() {
        setBool("EnemyFound", Flagtoggle.No);
        if (getBoolEquals("IgnoreEnemies", Yesno.No)) {
            removeTarget();
            if (receivedMessage("FocusThisGuy")) {
            } else {
                // Any Enemies?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                        // Priority 1: Players
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                            if (hasTarget(Yesno.No)) {
                                // players hiding in brush
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
                                    if (getBoolEquals("targetHasDot", Yesno.No)&&getBoolEquals("targetHasCC", Yesno.No)) {
                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                            removeTarget();
                                        }
                                    }
                                }
                            } else {
                                setBool("EnemyFound", Flagtoggle.Yes);
                                // chaseBattle (4)
                                adjustCounter("setState", "4", Valueadjust.Set);
                            }
                        }
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Creeps
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
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
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.No)) {
                            // Priority 2: Players
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                if (hasTarget(Yesno.No)) {
                                    // players hiding in brush
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                                    if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
                                        if (getBoolEquals("targetHasDot", Yesno.No)&&getBoolEquals("targetHasCC", Yesno.No)) {
                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                removeTarget();
                                            }
                                        }
                                    }
                                } else {
                                    setBool("EnemyFound", Flagtoggle.Yes);
                                    // chaseBattle (4)
                                    adjustCounter("setState", "4", Valueadjust.Set);
                                }
                            }
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
                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
                    if (getBoolEquals("DetectedStealth", Yesno.Yes)) {
                        // chaseBattle(4)
                        adjustCounter("setState", "4", Valueadjust.Set);
                    } else {
                        if (getBoolEquals("targetHasDot", Yesno.No)&&getBoolEquals("targetHasCC", Yesno.No)) {
                            removeTarget();
                        } else {
                            // chaseBattle(4)
                            adjustCounter("setState", "4", Valueadjust.Set);
                        }
                    }
                } else {
                    // chaseBattle(4)
                    adjustCounter("setState", "4", Valueadjust.Set);
                }
            }
        }
    }

}

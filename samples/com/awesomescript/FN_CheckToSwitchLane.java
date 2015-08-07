
package com.awesomescript;

import java.util.EnumSet;

public class FN_CheckToSwitchLane
    extends Script
{


    public void onTick() {
        if (getBoolEquals("CheckToSwitchLane", Yesno.Yes)) {
            setBool("CheckToSwitchLane", Flagtoggle.No);
            if (checkCounter("state", "2", Valuecompare.Equal)) {
                if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                    log("CHECK TO SWITCH", "", "");
                    // I am on a lane
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.3D, Yesno.No, Yesno.No)) {
                        if (getBoolEquals("SupportMode", Yesno.Yes)) {
                            // Friendlies close?
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                    log("Switch Lane!", "", "");
                                    // Switch!
                                    if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                        adjustCounter("lane", "2", Valueadjust.Set);
                                    } else {
                                        adjustCounter("lane", "1", Valueadjust.Set);
                                    }
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                    setBool("IgnoreEnemies", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            if (getBoolEquals("PushMode", Yesno.Yes)) {
                                if (getBoolEquals("enemyTower1Lane1", Yesno.No)) {
                                    if (getBoolEquals("enemyTower1Lane2", Yesno.No)) {
                                        if (getBoolEquals("enemyTower2Lane2", Yesno.No)) {
                                            adjustCounter("lane", "2", Valueadjust.Set);
                                            // advanceToFrontline (3)
                                            adjustCounter("setState", "3", Valueadjust.Set);
                                        } else {
                                            if (getBoolEquals("enemyTower2Lane1", Yesno.No)) {
                                                adjustCounter("lane", "1", Valueadjust.Set);
                                                // advanceToFrontline (3)
                                                adjustCounter("setState", "3", Valueadjust.Set);
                                            }
                                        }
                                    } else {
                                        adjustCounter("lane", "1", Valueadjust.Set);
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                    }
                                } else {
                                    if (getBoolEquals("enemyTower1Lane2", Yesno.No)) {
                                        adjustCounter("lane", "2", Valueadjust.Set);
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                    } else {
                                        // Enemies close?
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                            } else {
                                                log("Switch Lane!", "", "");
                                                // Switch!
                                                if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                                    adjustCounter("lane", "2", Valueadjust.Set);
                                                } else {
                                                    adjustCounter("lane", "1", Valueadjust.Set);
                                                }
                                                // advanceToFrontline (3)
                                                adjustCounter("setState", "3", Valueadjust.Set);
                                                setBool("IgnoreEnemies", Flagtoggle.Yes);
                                            }
                                        }
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepPusher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepPusher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No)) {
                                            log("Switch Lane!", "", "");
                                            // Switch!
                                            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                                adjustCounter("lane", "2", Valueadjust.Set);
                                            } else {
                                                adjustCounter("lane", "1", Valueadjust.Set);
                                            }
                                            // advanceToFrontline (3)
                                            adjustCounter("setState", "3", Valueadjust.Set);
                                            setBool("IgnoreEnemies", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            } else {
                                // Enemies close?
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", -1.6D, 0.0D, 5.0D, 2.0D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 1.6D, 0.0D, 5.0D, 2.0D, Yesno.No)) {
                                        log("Switch Lane!", "", "");
                                        // Switch!
                                        if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                            adjustCounter("lane", "2", Valueadjust.Set);
                                        } else {
                                            adjustCounter("lane", "1", Valueadjust.Set);
                                        }
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                        setBool("IgnoreEnemies", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                        log("Switch Lane!", "", "");
                                        // Switch!
                                        if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                            adjustCounter("lane", "2", Valueadjust.Set);
                                        } else {
                                            adjustCounter("lane", "1", Valueadjust.Set);
                                        }
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                        setBool("IgnoreEnemies", Flagtoggle.Yes);
                                    } else {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -5.0D, 0.0D, 10.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                            if (hasTarget(Yesno.Yes)) {
                                                // chaseBattle (4)
                                                adjustCounter("setState", "4", Valueadjust.Set);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                setBool("IgnoreBases", Flagtoggle.No);
                // chaseBattle (4)
                if (checkCounter("state", "4", Valuecompare.Equal)) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        setBool("IgnoreBases", Flagtoggle.Yes);
                    }
                }
                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "5", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                    setBool("IgnoreBases", Flagtoggle.Yes);
                }
                if (getBoolEquals("IgnoreBases", Yesno.No)) {
                    if (checkCounter("TeamNo", "0", Valuecompare.Equal)) {
                        if (isInNamedArea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                setBool("IgnoreEnemies", Flagtoggle.No);
                                executeBehaviourTree("FN_FindAndTargetEnemiesShortRange");
                            } else {
                                // advanceToFrontline (3)
                                adjustCounter("State", "3", Valueadjust.Set);
                                log("DEFENDOR!", "", "");
                                selectDestWaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                setBool("IgnoreEnemies", Flagtoggle.Yes);
                            }
                        } else {
                            if (isInNamedArea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    setBool("IgnoreEnemies", Flagtoggle.No);
                                    executeBehaviourTree("FN_FindAndTargetEnemiesShortRange");
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("State", "3", Valueadjust.Set);
                                    log("ATTACKOR!", "", "");
                                    selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                    setBool("IgnoreEnemies", Flagtoggle.Yes);
                                    setBool("BaseCanBeReached", Flagtoggle.Yes);
                                }
                            }
                        }
                    } else {
                        if (checkCounter("TeamNo", "1", Valuecompare.Equal)) {
                            if (isInNamedArea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    setBool("IgnoreEnemies", Flagtoggle.No);
                                    executeBehaviourTree("FN_FindAndTargetEnemiesShortRange");
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("State", "3", Valueadjust.Set);
                                    log("DEFENDOR!", "", "");
                                    selectDestWaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                    setBool("IgnoreEnemies", Flagtoggle.Yes);
                                }
                            } else {
                                if (isInNamedArea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        setBool("IgnoreEnemies", Flagtoggle.No);
                                        executeBehaviourTree("FN_FindAndTargetEnemiesShortRange");
                                    } else {
                                        // advanceToFrontline (3)
                                        adjustCounter("State", "3", Valueadjust.Set);
                                        log("ATTACKOR!", "", "");
                                        selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                        setBool("IgnoreEnemies", Flagtoggle.Yes);
                                        setBool("BaseCanBeReached", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

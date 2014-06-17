
package com.awesomescript;

import java.util.EnumSet;

public class FN_CheckToSwitchLane
    extends Script
{


    public void onTick() {
        if (getboolequals("CheckToSwitchLane", Yesno.Yes)) {
            setbool("CheckToSwitchLane", Flagtoggle.No);
            if (checkcounter("state", "2", Valuecompare.Equal)) {
                if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                    log("CHECK TO SWITCH", "", "");
                    // I am on a lane
                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.3D, Yesno.No, Yesno.No)) {
                        if (getboolequals("SupportMode", Yesno.Yes)) {
                            // Friendlies close?
                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                            } else {
                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                    log("Switch Lane!", "", "");
                                    // Switch!
                                    if (checkcounter("lane", "1", Valuecompare.Equal)) {
                                        adjustcounter("lane", "2", Valueadjust.Set);
                                    } else {
                                        adjustcounter("lane", "1", Valueadjust.Set);
                                    }
                                    // advanceToFrontline (3)
                                    adjustcounter("setState", "3", Valueadjust.Set);
                                    setbool("IgnoreEnemies", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            if (getboolequals("PushMode", Yesno.Yes)) {
                                if (getboolequals("enemyTower1Lane1", Yesno.No)) {
                                    if (getboolequals("enemyTower1Lane2", Yesno.No)) {
                                        if (getboolequals("enemyTower2Lane2", Yesno.No)) {
                                            adjustcounter("lane", "2", Valueadjust.Set);
                                            // advanceToFrontline (3)
                                            adjustcounter("setState", "3", Valueadjust.Set);
                                        } else {
                                            if (getboolequals("enemyTower2Lane1", Yesno.No)) {
                                                adjustcounter("lane", "1", Valueadjust.Set);
                                                // advanceToFrontline (3)
                                                adjustcounter("setState", "3", Valueadjust.Set);
                                            }
                                        }
                                    } else {
                                        adjustcounter("lane", "1", Valueadjust.Set);
                                        // advanceToFrontline (3)
                                        adjustcounter("setState", "3", Valueadjust.Set);
                                    }
                                } else {
                                    if (getboolequals("enemyTower1Lane2", Yesno.No)) {
                                        adjustcounter("lane", "2", Valueadjust.Set);
                                        // advanceToFrontline (3)
                                        adjustcounter("setState", "3", Valueadjust.Set);
                                    } else {
                                        // Enemies close?
                                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                            } else {
                                                log("Switch Lane!", "", "");
                                                // Switch!
                                                if (checkcounter("lane", "1", Valuecompare.Equal)) {
                                                    adjustcounter("lane", "2", Valueadjust.Set);
                                                } else {
                                                    adjustcounter("lane", "1", Valueadjust.Set);
                                                }
                                                // advanceToFrontline (3)
                                                adjustcounter("setState", "3", Valueadjust.Set);
                                                setbool("IgnoreEnemies", Flagtoggle.Yes);
                                            }
                                        }
                                        if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepPusher", CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No)||ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepPusher", CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No)) {
                                            log("Switch Lane!", "", "");
                                            // Switch!
                                            if (checkcounter("lane", "1", Valuecompare.Equal)) {
                                                adjustcounter("lane", "2", Valueadjust.Set);
                                            } else {
                                                adjustcounter("lane", "1", Valueadjust.Set);
                                            }
                                            // advanceToFrontline (3)
                                            adjustcounter("setState", "3", Valueadjust.Set);
                                            setbool("IgnoreEnemies", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            } else {
                                // Enemies close?
                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.3D, Yesno.No, Yesno.No)) {
                                    if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", -1.6D, 0.0D, 5.0D, 2.0D, Yesno.No)||ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 1.6D, 0.0D, 5.0D, 2.0D, Yesno.No)) {
                                        log("Switch Lane!", "", "");
                                        // Switch!
                                        if (checkcounter("lane", "1", Valuecompare.Equal)) {
                                            adjustcounter("lane", "2", Valueadjust.Set);
                                        } else {
                                            adjustcounter("lane", "1", Valueadjust.Set);
                                        }
                                        // advanceToFrontline (3)
                                        adjustcounter("setState", "3", Valueadjust.Set);
                                        setbool("IgnoreEnemies", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 1.6D, 10.0D, 2.0D, Yesno.No, Yesno.No)) {
                                        log("Switch Lane!", "", "");
                                        // Switch!
                                        if (checkcounter("lane", "1", Valuecompare.Equal)) {
                                            adjustcounter("lane", "2", Valueadjust.Set);
                                        } else {
                                            adjustcounter("lane", "1", Valueadjust.Set);
                                        }
                                        // advanceToFrontline (3)
                                        adjustcounter("setState", "3", Valueadjust.Set);
                                        setbool("IgnoreEnemies", Flagtoggle.Yes);
                                    } else {
                                        if (directiontoenemybase(Forwardbackward.FORWARD)) {
                                            selecttarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, -5.0D, 0.0D, 10.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                            if (hastarget(Yesno.Yes)) {
                                                // chaseBattle (4)
                                                adjustcounter("setState", "4", Valueadjust.Set);
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
                setbool("IgnoreBases", Flagtoggle.No);
                // chaseBattle (4)
                if (checkcounter("state", "4", Valuecompare.Equal)) {
                    if (istargettype(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        setbool("IgnoreBases", Flagtoggle.Yes);
                    }
                }
                if ((checkcounter("state", "1", Valuecompare.Equal)||checkcounter("state", "5", Valuecompare.Equal))||checkcounter("state", "10", Valuecompare.Equal)) {
                    setbool("IgnoreBases", Flagtoggle.Yes);
                }
                if (getboolequals("IgnoreBases", Yesno.No)) {
                    if (checkcounter("TeamNo", "0", Valuecompare.Equal)) {
                        if (isinnamedarea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (isinnamedarea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                setbool("IgnoreEnemies", Flagtoggle.No);
                                executebehaviourtree("FN_FindAndTargetEnemiesShortRange");
                            } else {
                                // advanceToFrontline (3)
                                adjustcounter("State", "3", Valueadjust.Set);
                                log("DEFENDOR!", "", "");
                                selectdestwaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                setbool("IgnoreEnemies", Flagtoggle.Yes);
                            }
                        } else {
                            if (isinnamedarea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isinnamedarea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    setbool("IgnoreEnemies", Flagtoggle.No);
                                    executebehaviourtree("FN_FindAndTargetEnemiesShortRange");
                                } else {
                                    // advanceToFrontline (3)
                                    adjustcounter("State", "3", Valueadjust.Set);
                                    log("ATTACKOR!", "", "");
                                    selectdestwaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                    setbool("IgnoreEnemies", Flagtoggle.Yes);
                                    setbool("BaseCanBeReached", Flagtoggle.Yes);
                                }
                            }
                        }
                    } else {
                        if (checkcounter("TeamNo", "1", Valuecompare.Equal)) {
                            if (isinnamedarea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isinnamedarea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    setbool("IgnoreEnemies", Flagtoggle.No);
                                    executebehaviourtree("FN_FindAndTargetEnemiesShortRange");
                                } else {
                                    // advanceToFrontline (3)
                                    adjustcounter("State", "3", Valueadjust.Set);
                                    log("DEFENDOR!", "", "");
                                    selectdestwaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                    setbool("IgnoreEnemies", Flagtoggle.Yes);
                                }
                            } else {
                                if (isinnamedarea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    if (isinnamedarea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        setbool("IgnoreEnemies", Flagtoggle.No);
                                        executebehaviourtree("FN_FindAndTargetEnemiesShortRange");
                                    } else {
                                        // advanceToFrontline (3)
                                        adjustcounter("State", "3", Valueadjust.Set);
                                        log("ATTACKOR!", "", "");
                                        selectdestwaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                        setbool("IgnoreEnemies", Flagtoggle.Yes);
                                        setbool("BaseCanBeReached", Flagtoggle.Yes);
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

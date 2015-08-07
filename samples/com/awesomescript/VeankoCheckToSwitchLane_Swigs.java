
package com.awesomescript;

import java.util.EnumSet;

public class VeankoCheckToSwitchLane_Swigs
    extends Script
{


    public void onTick() {
        if (getBoolEquals("CheckToSwitchLane", Yesno.Yes)) {
            if (getBoolEquals("LetsSwitchLane", Yesno.No)) {
                setBool("CheckToSwitchLane", Flagtoggle.No);
                log("CHECK TO SWITCH", "", "");
                if (checkCounter("lane", "1", Valuecompare.Equal)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 1.8D, Yesno.No, Yesno.Yes)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.8D, 1.5D, Yesno.No, Yesno.No)) {
                    } else {
                        // Friendlies at bot lane?
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, -2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                            adjustCounter("lane", "2", Valueadjust.Set);
                            setBool("LetsSwitchLane", Flagtoggle.Yes);
                            log("Switch Lane!", "", "");
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                } else {
                    if (checkCounter("lane", "2", Valuecompare.Equal)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 1.8D, Yesno.No, Yesno.Yes)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.8D, 1.5D, Yesno.No, Yesno.No)) {
                        } else {
                            // Friendlies at top lane?
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                adjustCounter("lane", "1", Valueadjust.Set);
                                setBool("LetsSwitchLane", Flagtoggle.Yes);
                                log("Switch Lane!", "", "");
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        }
                    }
                }
                if (getBoolEquals("enemyTower1Lane1", Yesno.No)) {
                    if (getBoolEquals("enemyTower1Lane2", Yesno.No)) {
                        if (getBoolEquals("enemyTower2Lane2", Yesno.No)) {
                            adjustCounter("lane", "2", Valueadjust.Set);
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                            setBool("LetsSwitchLane", Flagtoggle.Yes);
                        } else {
                            if (getBoolEquals("enemyTower2Lane1", Yesno.No)) {
                                adjustCounter("lane", "1", Valueadjust.Set);
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                                setBool("LetsSwitchLane", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        adjustCounter("lane", "1", Valueadjust.Set);
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                        setBool("LetsSwitchLane", Flagtoggle.Yes);
                    }
                } else {
                    if (getBoolEquals("enemyTower1Lane2", Yesno.No)) {
                        adjustCounter("lane", "2", Valueadjust.Set);
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                        setBool("LetsSwitchLane", Flagtoggle.Yes);
                    } else {
                        // Enemies close?
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.2D, 0.7D, Yesno.No, Yesno.No)) {
                        } else {
                            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                // Enemys at bot lane?
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                    adjustCounter("lane", "2", Valueadjust.Set);
                                    setBool("LetsSwitchLane", Flagtoggle.Yes);
                                    log("Switch Lane!", "", "");
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            } else {
                                if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                    // Enemys at top lane?
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                        adjustCounter("lane", "1", Valueadjust.Set);
                                        setBool("LetsSwitchLane", Flagtoggle.Yes);
                                        log("Switch Lane!", "", "");
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                    }
                                }
                            }
                        }
                        if (checkCounter("lane", "1", Valuecompare.Equal)) {
                            // Ally Superdroid at bot lane?
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "CreepDroidSuper", 0.0D, -2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                adjustCounter("lane", "2", Valueadjust.Set);
                                setBool("LetsSwitchLane", Flagtoggle.Yes);
                                log("Switch Lane!", "", "");
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        } else {
                            if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                // Ally Superdroid at top lane?
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "CreepDroidSuper", 0.0D, 2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                    adjustCounter("lane", "2", Valueadjust.Set);
                                    setBool("LetsSwitchLane", Flagtoggle.Yes);
                                    log("Switch Lane!", "", "");
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
                // Enemies close?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.2D, 0.7D, Yesno.No, Yesno.No)) {
                } else {
                    if (checkCounter("lane", "1", Valuecompare.Equal)) {
                        // Enemys at bot lane?
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                            adjustCounter("lane", "2", Valueadjust.Set);
                            setBool("LetsSwitchLane", Flagtoggle.Yes);
                            log("Switch Lane!", "", "");
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    } else {
                        if (checkCounter("lane", "2", Valuecompare.Equal)) {
                            // Enemys at top lane?
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 2.0D, 10.0D, 4.0D, Yesno.No, Yesno.Yes)) {
                                adjustCounter("lane", "1", Valueadjust.Set);
                                setBool("LetsSwitchLane", Flagtoggle.Yes);
                                log("Switch Lane!", "", "");
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (checkCounter("TeamNo", "0", Valuecompare.Equal)) {
                    // is enemy base open?
                    if (isInNamedArea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        // am i at enemy base?
                        if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                            // no players around?
                            if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    // look for enemy base
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        if (getBoolEquals("Outnumbered", Yesno.No)) {
                                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                setBool("AttackingBase", Flagtoggle.No);
                                            } else {
                                                executeBehaviourTree("VeankoCheckIfEnemyInCombatRange");
                                                // attack enemy base
                                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 1.0D, 0.0D, 2.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                // push
                                                adjustCounter("setState", "8", Valueadjust.Set);
                                                if (getBoolEquals("EnemyIsInCombatRange", Yesno.No)) {
                                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                                }
                                                setBool("AttackingBase", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("AttackingBase", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("AttackingBase", Flagtoggle.No);
                                    }
                                } else {
                                    // look for enemy base
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        if (getBoolEquals("Outnumbered", Yesno.No)) {
                                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                setBool("AttackingBase", Flagtoggle.No);
                                            } else {
                                                executeBehaviourTree("VeankoCheckIfEnemyInCombatRange");
                                                // attack enemy base
                                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 1.0D, 0.0D, 2.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                // push
                                                adjustCounter("setState", "8", Valueadjust.Set);
                                                if (getBoolEquals("EnemyIsInCombatRange", Yesno.No)) {
                                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                                }
                                                setBool("AttackingBase", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("AttackingBase", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("AttackingBase", Flagtoggle.No);
                                    }
                                }
                            } else {
                                setBool("AttackingBase", Flagtoggle.No);
                            }
                        } else {
                            setBool("AttackingBase", Flagtoggle.No);
                        }
                    } else {
                        setBool("AttackingBase", Flagtoggle.No);
                    }
                } else {
                    // is enemy base open?
                    if (isInNamedArea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        // am i at enemy base?
                        if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                            // no players around?
                            if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    // look for enemy base
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        if (getBoolEquals("Outnumbered", Yesno.No)) {
                                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                setBool("AttackingBase", Flagtoggle.No);
                                            } else {
                                                executeBehaviourTree("VeankoCheckIfEnemyInCombatRange");
                                                // attack enemy base
                                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 1.0D, 0.0D, 2.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                // push
                                                adjustCounter("setState", "8", Valueadjust.Set);
                                                if (getBoolEquals("EnemyIsInCombatRange", Yesno.No)) {
                                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                                }
                                                setBool("AttackingBase", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("AttackingBase", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("AttackingBase", Flagtoggle.No);
                                    }
                                } else {
                                    // look for enemy base
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        if (getBoolEquals("Outnumbered", Yesno.No)) {
                                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                setBool("AttackingBase", Flagtoggle.No);
                                            } else {
                                                executeBehaviourTree("VeankoCheckIfEnemyInCombatRange");
                                                // attack enemy base
                                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 1.0D, 0.0D, 2.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                // push
                                                adjustCounter("setState", "8", Valueadjust.Set);
                                                if (getBoolEquals("EnemyIsInCombatRange", Yesno.No)) {
                                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                                }
                                                setBool("AttackingBase", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("AttackingBase", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("AttackingBase", Flagtoggle.No);
                                    }
                                }
                            } else {
                                setBool("AttackingBase", Flagtoggle.No);
                            }
                        } else {
                            setBool("AttackingBase", Flagtoggle.No);
                        }
                    } else {
                        setBool("AttackingBase", Flagtoggle.No);
                    }
                }
            } else {
                setBool("AttackingBase", Flagtoggle.No);
            }
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
                    if (getBoolEquals("AttackingBase", Yesno.No)) {
                        if (checkCounter("TeamNo", "0", Valuecompare.Equal)) {
                            if (isInNamedArea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    setBool("IgnoreEnemies", Flagtoggle.No);
                                    executeBehaviourTree("VeankoFindAndTargetEnemiesShortRange");
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
                                        executeBehaviourTree("VeankoFindAndTargetEnemiesShortRange");
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
                                        executeBehaviourTree("VeankoFindAndTargetEnemiesShortRange");
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
                                            executeBehaviourTree("VeankoFindAndTargetEnemiesShortRange");
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

}

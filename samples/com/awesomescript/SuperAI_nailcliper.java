
package com.awesomescript;

import java.util.EnumSet;

public class SuperAI_nailcliper
    extends Script
{


    public void onTick() {
        enableUpgrade(Yesno.No, "hold");
        if (receivedMessage("ImFreeingCreeps")) {
            adjustCounter("LastFreedCreeps", "30", Valueadjust.Set);
        } else {
            if (checkCounter("LastFreedCreeps", "0", Valuecompare.Greater)) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    adjustCounter("LastFreedCreeps", "-1", Valueadjust.Add);
                }
            }
        }
        if (checkCounter("MoveCheck", "20", Valuecompare.Greater)) {
            adjustCounter("MoveCheck", "0", Valueadjust.Set);
            if (isNextWaypointInArea(0.1D, 0.0D, 0.1D, 0.1D)) {
                pressStick(Directions.BACKWARD, 0.1D);
            } else {
                if (isNextWaypointInArea(0.1D, 0.0D, 0.1D, 0.1D)) {
                    pressStick(Directions.FORWARD, 0.1D);
                }
            }
            log("DONT KNOW WHERE TO GO", "", "");
            if (((getBoolEquals("Teleporting", Yesno.Yes)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "3", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal)) {
                if (checkCounter("state", "10", Valuecompare.Equal)) {
                    selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                }
                if (checkCounter("state", "3", Valuecompare.Equal)) {
                    log("DECIDED TO GO TO FRONT", "", "");
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
                if (getBoolEquals("Teleporting", Yesno.Yes)) {
                    if (isInNamedArea("AREA_HOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        setBool("Teleporting", Flagtoggle.No);
                    }
                }
            }
        } else {
            if (checkCounter("state", "2", Valuecompare.Equal)) {
            } else {
                if (getBoolEquals("HasMoved", Yesno.No)) {
                    adjustCounter("MoveCheck", "1", Valueadjust.Add);
                } else {
                    adjustCounter("MoveCheck", "0", Valueadjust.Set);
                }
            }
        }
        executeBehaviourTree("FN_Initialization");
        executeBehaviourTree("FN_LookingForHealthPacks");
        executeBehaviourTree("FN_CheckToSwitchLane");
        executeBehaviourTree("FN_RetreatingSkills_nailcliper");
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Greater, Targetself.Self)) {
            executeBehaviourTree("SuperFocusEnemy_nailcliper");
        }
        // Loop langs creep(voor final push)
        if (getBoolEquals("IgnoreEnemies", Yesno.Yes)) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                }
            }
            if (isAtDestWaypoint()) {
                setBool("IngoreEnemies", Flagtoggle.No);
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (checkCounter("state", "3", Valuecompare.Equal)) {
                    } else {
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                }
            }
        } else {
            // also free creeps
            if (isInNamedArea("AREAUPPER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (timer(Timeunits.Seconds, 8.0D, Yesno.No)) {
                    if (random("2")) {
                        // freecreeps (7)
                        adjustCounter("setState", "7", Valueadjust.Set);
                    }
                }
            }
        }
        if (getBoolEquals("notowerDive", Yesno.No)) {
            // is turret low on health?
            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.LessOrEqual, 250.0D, 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes)) {
                // dont dive if too low
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 65.0D, Valuecompare.Greater, Targetself.Self)) {
                    // dont dive if enemy players are nearby
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                        setBool("isTank", Flagtoggle.No);
                    } else {
                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            setBool("isTank", Flagtoggle.No);
                        } else {
                            // check for creeps
                            if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.3D, 0.0D, 0.5D, 1.0D, Yesno.Yes, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 3.0D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                // pushTower (8)
                                adjustCounter("setState", "8", Valueadjust.Set);
                                // TOWER DIVE!
                                setBool("isTank", Flagtoggle.Yes);
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                if (timer(Timeunits.Seconds, 2.0D, Yesno.Yes)) {
                                    log("TANKING TOWER", "", "isTank");
                                }
                            }
                        }
                    }
                } else {
                    setBool("isTank", Flagtoggle.No);
                }
            } else {
                setBool("isTank", Flagtoggle.No);
            }
        }
        if (getBoolEquals("neverOutnumbered", Yesno.No)) {
            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes)) {
                setBool("Outnumbered", Flagtoggle.No);
            } else {
                // Am i outnumbered?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "3", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                    // No Teammates?
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                        setBool("Outnumbered", Flagtoggle.No);
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            // I am outnumbered
                            setBool("Outnumbered", Flagtoggle.Yes);
                        }
                    }
                } else {
                    // Am i outnumbered?
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                        // No Teammates?
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                            setBool("Outnumbered", Flagtoggle.No);
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                // I am outnumbered
                                setBool("Outnumbered", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        setBool("Outnumbered", Flagtoggle.No);
                    }
                }
            }
        }
        if (getBoolEquals("notowerRetreat", Yesno.No)) {
            // Not already retreating?
            if (checkCounter("state", "6", Valuecompare.Equal)) {
            } else {
                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.2D, Yesno.No, Yesno.Yes)) {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (getBoolEquals("isTank", Yesno.No)) {
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))||getBoolEquals("nopushfix", Yesno.Yes)) {
                                // check for creeps
                                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.5D, 0.0D, 0.8D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    if (getBoolEquals("Chasemode", Yesno.No)) {
                                        // too close to turret -> move away
                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.4D, 1.0D, Yesno.Yes)) {
                                            // back off
                                            adjustCounter("setState", "6", Valueadjust.Set);
                                        }
                                    } else {
                                        // too close to turret -> move away
                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.6D, 1.0D, Yesno.Yes)) {
                                            // back off
                                            adjustCounter("setState", "6", Valueadjust.Set);
                                        }
                                    }
                                }
                            } else {
                                // not pushing
                                if (checkCounter("state", "8", Valuecompare.Equal)) {
                                } else {
                                    // check for creeps
                                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.4D, 0.0D, 0.8D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        // too close to turret -> move away
                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.4D, 1.0D, Yesno.Yes)) {
                                            // back off
                                            adjustCounter("setState", "6", Valueadjust.Set);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (getBoolEquals("dontattackBase", Yesno.No)) {
            // am i at enemy base?
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                // enemy base isnt a turret?
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes)) {
                } else {
                    // no players around?
                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                        if (getBoolEquals("Outnumbered", Yesno.No)) {
                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            } else {
                                // attack enemy base
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 3.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                // push
                                adjustCounter("setState", "8", Valueadjust.Set);
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
        }
        if (getBoolEquals("donthuntCreeps", Yesno.No)) {
            // am i in stealth
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    // hunt jungle creeps
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Less, Targetself.Self)) {
                        // find creeps
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 200.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                            // get em
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .Less, 20.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                            if ((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            } else {
                                adjustCounter("setState", "4", Valueadjust.Set);
                            }
                        }
                    } else {
                        if (checkClass(Targetself.Self, "Maw")) {
                            if (hasTarget(Yesno.No)) {
                                // find creeps
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 200.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                    // get em
                                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .Less, 20.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                    if ((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    } else {
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    }
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("willnotkillSolarBoss", Yesno.No)) {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        // Solar Boss
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                            if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            } else {
                                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
                                    if ((checkClass(Targetself.Self, "Vampire")||checkClass(Targetself.Self, "Tank"))||getBoolEquals("cankillSolarBoss", Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                        if ((hasTarget(Yesno.Yes)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS)))&&isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                                            emitMessageInArea("killSolarBoss", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes, Yesno.No);
                                        }
                                    }
                                }
                            }
                            if (receivedMessage("killSolarBoss")) {
                                // are there allys nearby
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes, Yesno.No)) {
                                    if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    } else {
                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    }
                                }
                            }
                            // Solar Boss
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
                                if (getBoolEquals("Exploding", Yesno.No)) {
                                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    } else {
                                        if (hasTarget(Yesno.Yes)) {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                                if (isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                                                    setBool("GoForward", Flagtoggle.Yes);
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
        if (getBoolEquals("dontjumpWall", Yesno.No)) {
            // its just a wall mate
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepShamanWall", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes)) {
                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            }
        }
        if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No, Yesno.No)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 65.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (receivedPing(Ping.ATTACK)) {
                adjustCounter("setState", "3", Valueadjust.Set);
            }
            if (receivedPing(Ping.HELP)) {
                selectPingWaypoint(Ping.HELP);
                log("PING HELP", "", "");
            }
            if (receivedPing(Ping.TURRET_UNDER_ATTACK)) {
                selectPingWaypoint(Ping.TURRET_UNDER_ATTACK);
                log("PING TURRET UNDER ATTACK", "", "");
            }
            if (receivedPing(Ping.TURRET_ALMOST_DESTROYED)) {
                selectPingWaypoint(Ping.TURRET_ALMOST_DESTROYED);
                log("PING TURRET ALMOST DESTROYED", "", "");
            }
            if (receivedPing(Ping.BASE_UNDER_ATTACK)) {
                selectPingWaypoint(Ping.BASE_UNDER_ATTACK);
                log("PING BASE UNDER ATTACK", "", "");
            }
            if (receivedPing(Ping.BASE_ALMOST_DESTROYED)) {
                selectPingWaypoint(Ping.BASE_ALMOST_DESTROYED);
                log("PING BASE ALMOST DESTROYED", "", "");
            }
        }
        // STATES
        if (getBoolEquals("false", Yesno.No)) {
            // retreatHP (1)
            if (checkCounter("state", "1", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if (isAtDestWaypoint()) {
                } else {
                    setBool("LookingForHealthPacks", Flagtoggle.Yes);
                    if (getBoolEquals("CantFindNextWaypoint", Yesno.Yes)) {
                        // returnToUpgrade (10)
                        adjustCounter("setState", "10", Valueadjust.Set);
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        }
                    }
                }
                // at regen area
                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("goingbacktobuyitems", Flagtoggle.No);
                    // returnToUpgrade (10)
                    adjustCounter("setState", "10", Valueadjust.Set);
                } else {
                    // re check everything
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        // retreatHP (1)
                        adjustCounter("setState", "1", Valueadjust.Set);
                    }
                    // a bit better is ok
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                    }
                    setBool("CheckToGoBack", Flagtoggle.Yes);
                }
                // a bit better is ok
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    // Advance to frontline (3)
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("AREAFIRST", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            // a bit better is ok
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (isFromTeam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
                                    if (getBoolEquals("AttackbaseRed_Warning", Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                        // chaseBattle(4)
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    }
                                } else {
                                    if (getBoolEquals("AttackbaseBlue_Warning", Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                        // chaseBattle(4)
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    }
                                }
                            }
                        }
                    }
                }
                if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    if (getBoolEquals("goingbacktobuyitems", Yesno.No)) {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.5D, 0.5D, Yesno.Yes)) {
                        } else {
                            if (getBoolEquals("Outnumbered", Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.Greater, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    } else {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 50.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                            if (random("4")) {
                                                adjustCounter("setState", "4", Valueadjust.Set);
                                            }
                                        }
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                            adjustCounter("setState", "4", Valueadjust.Set);
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                if (random("4")) {
                                                    adjustCounter("setState", "4", Valueadjust.Set);
                                                }
                                            }
                                        }
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.Greater, Targetself.Self)) {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 20.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                adjustCounter("setState", "4", Valueadjust.Set);
                                            } else {
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                    if (random("4")) {
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
                }
            }
            // standby (2)
            if (checkCounter("state", "2", Valuecompare.Equal)) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    setBool("CheckToSwitchLane", Flagtoggle.Yes);
                    executeBehaviourTree("FN_FindAndTargetEnemiesLongRange");
                }
                executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                if (getBoolEquals("Outnumbered", Yesno.Yes)) {
                    adjustCounter("setState", "11", Valueadjust.Set);
                }
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                }
                // turret spotted
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes)) {
                    selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    // friendly creeps
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                        // pushTower (8)
                        adjustCounter("setState", "8", Valueadjust.Set);
                    } else {
                        // is turret low on health?
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.LessOrEqual, 250.0D, 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes)) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                // pushTower (8)
                                adjustCounter("setState", "8", Valueadjust.Set);
                                // TOWER DIVE!
                                setBool("isTank", Flagtoggle.Yes);
                            }
                        }
                    }
                } else {
                    // am i at enemy base?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                        // attack enemy base
                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        // push
                        adjustCounter("setState", "8", Valueadjust.Set);
                    } else {
                        if (isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            // advanceToFrontline(3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                        if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                            setBool("GoBack", Flagtoggle.Yes);
                        } else {
                            setBool("GoForward", Flagtoggle.Yes);
                        }
                    }
                }
                // turn around if faceing wrong way
                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                    setBool("GoBack", Flagtoggle.Yes);
                }
                if (checkCounter("positionInLane", "3", Valuecompare.Equal)) {
                    selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.5D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    // pushTower (8)
                    adjustCounter("setState", "8", Valueadjust.Set);
                }
                // exit out of standby state if not targeting turret
                if (hasTarget(Yesno.Yes)) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                        if (isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                            adjustCounter("setState", "5", Valueadjust.Set);
                        }
                    }
                }
            }
            // advanceToFrontline (3)
            if (checkCounter("state", "3", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    executeBehaviourTree("FN_FindAndTargetEnemiesLongRange");
                }
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.Less, Targetself.Self)) {
                    executeBehaviourTree("SuperFindHealthPack_nailcliper");
                }
                if (getBoolEquals("Outnumbered", Yesno.Yes)) {
                    adjustCounter("setState", "11", Valueadjust.Set);
                }
                // crappy random om flying creeps eruit te halen
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    if (checkCounter("LastFreedCreeps", "0", Valuecompare.Equal)) {
                        if (isInNamedArea("AREAUPPER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (getBoolEquals("enemyTower1Lane1", Yesno.Yes)||getBoolEquals("enemyTower2Lane1", Yesno.Yes)) {
                                if (random("8")) {
                                    // freecreeps (7)
                                    adjustCounter("setState", "7", Valueadjust.Set);
                                    emitMessageInArea("ImFreeingCreeps", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
                                    adjustCounter("LastFreedCreeps", "30", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
                // at destination
                if (isAtDestWaypoint()) {
                    executeBehaviourTree("FN_SelectFrontlineWaypoint");
                    // made it to frontline?
                    if (isAtDestWaypoint()) {
                        // is there an enemy turret?
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes)) {
                            // target turret
                            selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            // friendly creeps
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 1.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                // pushTower (8)
                                adjustCounter("setState", "8", Valueadjust.Set);
                            } else {
                                // is turret low on health?
                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.LessOrEqual, 250.0D, 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        // pushTower (8)
                                        adjustCounter("setState", "8", Valueadjust.Set);
                                        // TOWER DIVE!
                                        setBool("isTank", Flagtoggle.Yes);
                                    }
                                } else {
                                    // standby (2)
                                    adjustCounter("setState", "2", Valueadjust.Set);
                                }
                            }
                        } else {
                            // am i at enemy base?
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                                // attack enemy base
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                                // push
                                adjustCounter("setState", "8", Valueadjust.Set);
                            } else {
                                // am i faceing wrong way?
                                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                    // turn around
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    log("TOWER DIED", "", "");
                                    // no -> set tower to dead
                                    if (checkCounter("positionInLane", "1", Valuecompare.Equal)) {
                                        // upper lane
                                        if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                            setBool("enemyTower1Lane1", Flagtoggle.No);
                                        } else {
                                            // bottom lane
                                            if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                                setBool("enemyTower1Lane2", Flagtoggle.No);
                                            }
                                        }
                                    } else {
                                        if (checkCounter("positionInLane", "2", Valuecompare.Equal)) {
                                            // upper lane
                                            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                                setBool("enemyTower2Lane1", Flagtoggle.No);
                                            } else {
                                                // bottom lane
                                                if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                                    setBool("enemyTower2Lane2", Flagtoggle.No);
                                                }
                                            }
                                        } else {
                                            // last tower
                                            if (checkCounter("positionInLane", "3", Valuecompare.Equal)) {
                                                setBool("enemyTower3", Flagtoggle.No);
                                            }
                                        }
                                    }
                                    // advanceTofrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            }
                        }
                    } else {
                        executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                        if (hasTarget(Yesno.No)) {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                }
                if (areGoldCoinsInArea(5.0D, Valuecompare.GreaterOrEqual, 0.2D, -0.05D, 0.4D, 0.15D, Yesno.Yes)||areGoldCoinsInArea(5.0D, Valuecompare.GreaterOrEqual, -0.2D, -0.05D, 0.4D, 0.15D, Yesno.Yes)) {
                    // DOSH! GRAB IT WHILE YOU CAN!
                    adjustCounter("setState", "9", Valueadjust.Set);
                }
            }
            // chaseBattle(4)
            if (checkCounter("state", "4", Valuecompare.Equal)) {
                if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)||hasTarget(Yesno.No)) {
                    // advanceToFrontline (3)
                    adjustCounter("setState", "3", Valueadjust.Set);
                    log("ENEMY DIED", "", "");
                } else {
                    selectTargetWaypoint();
                    if ((checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self))&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        setBool("Chasemode", Flagtoggle.Yes);
                    } else {
                        setBool("Chasemode", Flagtoggle.No);
                    }
                    // this logic makes the bot prioritize droids attacking the turret over players
                    if (getBoolEquals("Chasemode", Yesno.No)) {
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                            if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.3D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.3D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.3D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    }
                                }
                            }
                        }
                    }
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.3D, 1.3D, Yesno.Yes)) {
                        // creeps in front
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.8D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                        } else {
                            // fleeTurret (6)
                            adjustCounter("setState", "6", Valueadjust.Set);
                        }
                    }
                    // this logic makes the bot prioritize turrets over players
                    if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                        // is turret nearby
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.8D, 1.0D, Yesno.Yes)) {
                            // creeps in front
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.5D, 0.0D, 0.8D, 1.0D, Yesno.Yes, Yesno.No)) {
                                // attack turret
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                adjustCounter("setState", "8", Valueadjust.Set);
                            }
                        }
                    }
                    if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes, Yesno.No)) {
                        adjustCounter("Cantsee", "1", Valueadjust.Add);
                    }
                    if (getBoolEquals("CantFindNextWaypoint", Yesno.Yes)) {
                        adjustCounter("Cantsee", "15", Valueadjust.Add);
                    }
                    if (checkCounter("Cantsee", "50", Valuecompare.Less)) {
                    } else {
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                        adjustCounter("Cantsee", "0", Valueadjust.Set);
                        log("LOST ENEMY", "", "");
                    }
                }
                if (getBoolEquals("Outnumbered", Yesno.Yes)) {
                    adjustCounter("setState", "11", Valueadjust.Set);
                }
                // Switch To More Important Enemies
                if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                    // My Enemy is a player
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        // My target is pretty far
                        if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No, Yesno.No)) {
                            // Other Enemies are closer
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                                // Find closer Enemy
                                executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                            }
                        }
                    }
                    // Look for Summoner
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No)) {
                        // Target Summoner
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    }
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))||getBoolEquals("PushMode", Yesno.No)) {
                        if (timer(Timeunits.Seconds, 5.0D, Yesno.No)) {
                            // players are more important
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                // get em
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                // chaseBattle (4)
                                adjustCounter("setState", "4", Valueadjust.Set);
                            }
                        } else {
                            // players are more important
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.15D, 0.15D, Yesno.Yes, Yesno.No)) {
                                // get em
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.2D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                // chaseBattle (4)
                                adjustCounter("setState", "4", Valueadjust.Set);
                            }
                        }
                    }
                }
                // Combat
                if (getBoolEquals("Combat", Yesno.No)) {
                    // target is no longer that close
                    if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.34D, 0.7D, Yesno.No, Yesno.No)) {
                        setBool("backOff", Flagtoggle.No);
                        // reset
                        adjustCounter("timeTillUncomfortable", "3", Valueadjust.Set);
                    }
                    // Can I see enemy?
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 3.0D, 3.0D, Yesno.Yes, Yesno.No)) {
                        // not close
                        if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.55D, 0.55D, Yesno.Yes, Yesno.No)) {
                            // not close at all
                            if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.8D, 0.5D, Yesno.No, Yesno.No)) {
                                if (hasDestWaypoint()) {
                                    if (isAtDestWaypoint()) {
                                        selectTargetWaypoint();
                                    }
                                } else {
                                    selectTargetWaypoint();
                                }
                                if (hasDestWaypoint()) {
                                    setBool("ForceWaypointMovement", Flagtoggle.Yes);
                                }
                            } else {
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            }
                        } else {
                            executeBehaviourTree("SuperCheckIfEnemyTooClose_nailcliper");
                            if (getBoolEquals("EnemyIsTooClose", Yesno.Yes)||getBoolEquals("backOff", Yesno.Yes)) {
                                // awkward hugging
                                if (checkCounter("timeTillUncomfortable", "0", Valuecompare.LessOrEqual)) {
                                    if (getBoolEquals("backOff", Yesno.No)) {
                                        setBool("backOff", Flagtoggle.Yes);
                                    }
                                    setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                } else {
                                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                        adjustCounter("timeTillUncomfortable", "-1", Valueadjust.Add);
                                    }
                                }
                            } else {
                                executeBehaviourTree("SuperCheckIfEnemyInCombatRange_nailcliper");
                                if (getBoolEquals("EnemyIsInCombatRange", Yesno.No)) {
                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                }
                                // reset
                                adjustCounter("timeTillUncomfortable", "3", Valueadjust.Set);
                            }
                            // Jump after Enemy
                            if (getBoolEquals("jump", Yesno.No)) {
                                if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||isTargetInArea(Yesno.Yes, 0.0D, -0.25D, 0.06D, 0.4D, Yesno.Yes, Yesno.No)) {
                                    if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    } else {
                                        setBool("DownJump", Flagtoggle.Yes);
                                    }
                                }
                                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)||isTargetInArea(Yesno.Yes, 0.0D, 0.25D, 0.06D, 0.4D, Yesno.Yes, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    } else {
                        if (hasDestWaypoint()) {
                            if (isAtDestWaypoint()) {
                                selectTargetWaypoint();
                            }
                        } else {
                            selectTargetWaypoint();
                        }
                        setBool("ForceWaypointMovement", Flagtoggle.Yes);
                    }
                }
            } else {
                setBool("Chasemode", Flagtoggle.No);
            }
            // getNeutrals (5)
            if (checkCounter("state", "5", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if ((isAtDestWaypoint()||isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("JUNGLE", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 200.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 200.0D, "", -1.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                        // get em
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.0D, 1.0D, Valuecompare2 .Less, 20.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.Yes)) {
                            // chaseBattle (4)
                            adjustCounter("setState", "4", Valueadjust.Set);
                        } else {
                            // there is monay to be found
                            if (areGoldCoinsInArea(3.0D, Valuecompare.GreaterOrEqual, 0.0D, -0.05D, 0.8D, 0.15D, Yesno.Yes)) {
                                // collect MONAY (9)
                                adjustCounter("setState", "9", Valueadjust.Set);
                            }
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.Less, Targetself.Self)) {
                            // retreatHP(1)
                            adjustCounter("setState", "1", Valueadjust.Set);
                        } else {
                            // loook for plants
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                // get em
                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                // chaseBattle (4)
                                adjustCounter("setState", "4", Valueadjust.Set);
                            } else {
                                // there is monay to be found
                                if (areGoldCoinsInArea(3.0D, Valuecompare.GreaterOrEqual, 0.0D, -0.05D, 0.8D, 0.15D, Yesno.Yes)) {
                                    // collect MONAY (9)
                                    adjustCounter("setState", "9", Valueadjust.Set);
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("Outnumbered", Yesno.Yes)) {
                    adjustCounter("setState", "11", Valueadjust.Set);
                }
                if (((receivedPing(Ping.BASE_UNDER_ATTACK)||receivedPing(Ping.BASE_ALMOST_DESTROYED))||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.GreaterOrEqual, Targetself.Self))||timer(Timeunits.Seconds, 20.0D, Yesno.No)) {
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
            }
            // fleeTower (6)
            if (checkCounter("state", "6", Valuecompare.Equal)) {
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, -0.45D, 0.0D, 0.9D, 1.0D, Yesno.Yes)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                        if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                    setBool("GoForward", Flagtoggle.Yes);
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                } else {
                    setBool("GoBack", Flagtoggle.Yes);
                }
                // out of danger zone
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.5D, 1.0D, Yesno.Yes)) {
                } else {
                    // advanceToFrontline (3)
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    }
                }
                setBool("UseRetreatingSkills", Flagtoggle.Yes);
            }
            // freeCreeps (7)
            if (checkCounter("state", "7", Valuecompare.Equal)) {
                if (isNextWaypointInArea(0.0D, 0.0D, 0.08D, 0.08D)) {
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
                if (isAtDestWaypoint()) {
                    if (timer(Timeunits.Seconds, 3.5D, Yesno.No)) {
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                    }
                } else {
                    setBool("ForceWaypointMovement", Flagtoggle.Yes);
                }
                if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                    // Find closer Enemy
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepDroidFlying", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)||timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                    adjustCounter("LastFreedCreeps", "30", Valueadjust.Set);
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
            }
            // pushtower (8)
            if (checkCounter("state", "8", Valuecompare.Equal)) {
                if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 1.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    } else {
                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, -1.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    // creeps in front
                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.5D, 0.0D, 1.4D, 1.0D, Yesno.Yes, Yesno.No)) {
                        if (isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                        } else {
                            // if there is no turret, you are most likely in the enemy base
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes)) {
                                // avoid afking in lanes
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        }
                    }
                }
                if (getBoolEquals("Outnumbered", Yesno.Yes)) {
                    adjustCounter("setState", "11", Valueadjust.Set);
                }
                // Position myself
                if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                    setBool("GoBack", Flagtoggle.Yes);
                } else {
                    // attack
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                        if (checkClass(Targetself.Self, "Blazer")) {
                            sequence0();
                        } else {
                            // bullet distance +max collision width/2 + a little offset
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                    if (getBoolEquals("isTank", Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.6D, 0.0D, 0.8D, 1.0D, Yesno.Yes, Yesno.No)) {
                            executeBehaviourTree("SuperCheckIfEnemyInCombatRange_nailcliper");
                            // in range
                            if (getBoolEquals("EnemyIsInCombatRange", Yesno.Yes)) {
                                if (checkClass(Targetself.Self, "Blazer")) {
                                    sequence1();
                                } else {
                                    // bullet distance +max collision width/2 + a little offset
                                    pressButton(Buttons.FACE_LEFT, 0.0D);
                                }
                            } else {
                                executeBehaviourTree("SuperCheckIfEnemyTooClose_nailcliper");
                                if (getBoolEquals("EnemyIsTooClose", Yesno.Yes)) {
                                    sequence2();
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    } else {
                        // tell everyone there is a tank
                        emitMessageInArea("imaTankin", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.No);
                        // still friend close
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.65D, 0.4D, Yesno.Yes)) {
                            // in range (closer)
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.05D, 0.0D, 0.08D, 0.2D, Yesno.Yes, Yesno.No)) {
                                if (checkClass(Targetself.Self, "Blazer")) {
                                    sequence3();
                                } else {
                                    // bullet distance +max collision width/2 + a little offset
                                    pressButton(Buttons.FACE_LEFT, 0.0D);
                                }
                            } else {
                                setBool("GoForward", Flagtoggle.Yes);
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // retreatHP (1)
                    adjustCounter("setState", "1", Valueadjust.Set);
                }
                // turret dead
                if (hasTarget(Yesno.No)) {
                    // set tower to dead
                    if (checkCounter("positionInLane", "1", Valuecompare.Equal)) {
                        // upper lane
                        if (checkCounter("lane", "1", Valuecompare.Equal)) {
                            setBool("enemyTower1Lane1", Flagtoggle.No);
                        } else {
                            // bottom lane
                            if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                setBool("enemyTower1Lane2", Flagtoggle.No);
                            }
                        }
                    } else {
                        if (checkCounter("positionInLane", "2", Valuecompare.Equal)) {
                            // upper lane
                            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                                setBool("enemyTower2Lane1", Flagtoggle.No);
                            } else {
                                // bottom lane
                                if (checkCounter("lane", "2", Valuecompare.Equal)) {
                                    setBool("enemyTower2Lane2", Flagtoggle.No);
                                }
                            }
                        } else {
                            // last tower
                            if (checkCounter("positionInLane", "3", Valuecompare.Equal)) {
                                setBool("enemyTower3", Flagtoggle.No);
                            }
                        }
                    }
                    log("TURRET DIED", "", "");
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                    if (hasTarget(Yesno.No)) {
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                    }
                }
                // target is gone
                if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 2.5D, 1.1D, Yesno.Yes, Yesno.No)) {
                    // advanceToFrontline (3)
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
                // Lookout for Enemy creeps and players
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                }
            }
            // collect MONAY (9)
            if (checkCounter("state", "9", Valuecompare.Equal)) {
                if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                    // Find closer Enemy
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                }
                // front
                if (areGoldCoinsInArea(5.0D, Valuecompare.GreaterOrEqual, 0.2D, -0.05D, 0.4D, 0.15D, Yesno.Yes)) {
                    // check creeps & players
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.02D, Yesno.Yes, Yesno.No)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                    setBool("GoForward", Flagtoggle.Yes);
                } else {
                    // back
                    if (areGoldCoinsInArea(5.0D, Valuecompare.GreaterOrEqual, -0.2D, -0.05D, 0.4D, 0.15D, Yesno.Yes)) {
                        setBool("GoBack", Flagtoggle.Yes);
                    } else {
                        // advanceToFrontline (3)
                        adjustCounter("setState", "3", Valueadjust.Set);
                    }
                }
            }
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if (isAtDestWaypoint()) {
                    setBool("FirstRunDone", Flagtoggle.Yes);
                }
                if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                    setBool("LookingForHealthPacks", Flagtoggle.Yes);
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    }
                }
                if (getBoolEquals("AmSafe", Yesno.No)) {
                    setBool("Teleporting", Flagtoggle.No);
                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                } else {
                    if (getBoolEquals("FirstRunDone", Yesno.Yes)) {
                        // all better now
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Equal, Targetself.Self)) {
                            setBool("goingbacktobuyitems", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                if (random("2")) {
                                    adjustCounter("lane", "1", Valueadjust.Set);
                                } else {
                                    adjustCounter("lane", "2", Valueadjust.Set);
                                }
                            } else {
                                if (getBoolEquals("enemyTower2Lane1", Yesno.No)) {
                                    if (random("5")) {
                                        adjustCounter("lane", "2", Valueadjust.Set);
                                    } else {
                                        adjustCounter("lane", "1", Valueadjust.Set);
                                    }
                                }
                                if (getBoolEquals("enemyTower2Lane2", Yesno.No)) {
                                    if (random("5")) {
                                        adjustCounter("lane", "1", Valueadjust.Set);
                                    } else {
                                        adjustCounter("lane", "2", Valueadjust.Set);
                                    }
                                }
                            }
                            sequence4();
                        }
                    }
                    setBool("UseRetreatingSkills", Flagtoggle.No);
                    if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                        if ((isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self))||directionToEnemyBase(Forwardbackward.FORWARD)) {
                            setBool("Teleporting", Flagtoggle.No);
                        } else {
                            log("Teleporting!", "", "");
                            pressButton(Buttons.SHOULDER_RIGHT, 0.6D);
                        }
                    }
                }
                if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    if (getBoolEquals("goingbacktobuyitems", Yesno.No)) {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.5D, 0.5D, Yesno.Yes)) {
                        } else {
                            if (getBoolEquals("Outnumbered", Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.Greater, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                        adjustCounter("setState", "4", Valueadjust.Set);
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                            adjustCounter("setState", "4", Valueadjust.Set);
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 50.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                if (random("4")) {
                                                    adjustCounter("setState", "4", Valueadjust.Set);
                                                }
                                            }
                                        }
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                adjustCounter("setState", "4", Valueadjust.Set);
                                            } else {
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                    if (random("4")) {
                                                        adjustCounter("setState", "4", Valueadjust.Set);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.Greater, Targetself.Self)) {
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 20.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                    adjustCounter("setState", "4", Valueadjust.Set);
                                                } else {
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                        if (random("4")) {
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
                    }
                }
            } else {
                setBool("Teleporting", Flagtoggle.No);
            }
            // Defend towers (11)
            if (checkCounter("state", "11", Valuecompare.Equal)) {
                // check for turrets
                if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 25.0D, 0.0D, 0.0D, 3.0D, 0.2D, Yesno.No)) {
                    if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 25.0D, 0.8D, 0.0D, 1.4D, 1.0D, Yesno.No)&&directionToEnemyBase(Forwardbackward.FORWARD)) {
                        setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    } else {
                        // go to defend turrets
                        if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 25.0D, 0.0D, 0.0D, 0.05D, 0.2D, Yesno.No)) {
                        } else {
                            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    }
                } else {
                    // check for drill core
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 3.0D, 0.2D, Yesno.Yes, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.8D, 0.0D, 1.4D, 1.0D, Yesno.No, Yesno.No)&&directionToEnemyBase(Forwardbackward.FORWARD)) {
                            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        } else {
                            // go to defend base
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.No)) {
                            } else {
                                setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    } else {
                        setBool("ForceWaypointMovement", Flagtoggle.Yes);
                        selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                            // check for stuff
                            if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 3.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                // retreat
                                adjustCounter("setState", "1", Valueadjust.Set);
                            }
                        }
                    }
                }
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                }
                if (getBoolEquals("Outnumbered", Yesno.No)) {
                    adjustCounter("setState", "3", Valueadjust.Set);
                }
            }
            // fleeNauts (12)
            if (checkCounter("state", "12", Valuecompare.Equal)) {
                if (directionToEnemyBase(Forwardbackward.FORWARD)&&isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 25.0D, 0.2D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                    // Defend Towers (11)
                    adjustCounter("setState", "11", Valueadjust.Set);
                } else {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                        if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodthirstOn")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                    if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            } else {
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        } else {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                        if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.2D, 1.2D, Yesno.No)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                    if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            }
                        } else {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                        if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "SiegeModeOn")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                    if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            } else {
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        }
                    }
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy")) {
                        if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                    if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            } else {
                                // advanceToFrontline (3)
                                adjustCounter("setState", "3", Valueadjust.Set);
                            }
                        } else {
                            if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbShootOn")) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.Yes)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("GoBack", Flagtoggle.Yes);
                                    } else {
                                        setBool("GoForward", Flagtoggle.Yes);
                                    }
                                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                        if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            } else {
                                if (timer(Timeunits.Seconds, 1.5D, Yesno.Yes)) {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            }
                        }
                    }
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange3")) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 3.4D, 3.4D, Yesno.Yes)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("GoBack", Flagtoggle.Yes);
                                    } else {
                                        setBool("GoForward", Flagtoggle.Yes);
                                    }
                                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                        if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            } else {
                                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange2")) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 3.0D, 3.0D, Yesno.Yes)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                        }
                                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                        if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                            if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                        }
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    } else {
                                        // advanceToFrontline (3)
                                        adjustCounter("setState", "3", Valueadjust.Set);
                                    }
                                } else {
                                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange1")) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.6D, 2.6D, Yesno.Yes)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                            }
                                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                                if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                                    setBool("jump", Flagtoggle.Yes);
                                                }
                                            }
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                        } else {
                                            // advanceToFrontline (3)
                                            adjustCounter("setState", "3", Valueadjust.Set);
                                        }
                                    } else {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.2D, 2.2D, Yesno.Yes)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                            }
                                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                                if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                                    setBool("jump", Flagtoggle.Yes);
                                                }
                                            }
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                        } else {
                                            // advanceToFrontline (3)
                                            adjustCounter("setState", "3", Valueadjust.Set);
                                        }
                                    }
                                }
                            }
                        } else {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                        if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                            if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect")) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                    removeTarget();
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("goBack", Flagtoggle.Yes);
                                    } else {
                                        setBool("goForward", Flagtoggle.Yes);
                                    }
                                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                        if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            } else {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("goBack", Flagtoggle.Yes);
                                    } else {
                                        setBool("goForward", Flagtoggle.Yes);
                                    }
                                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                                        if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                } else {
                                    // advanceToFrontline (3)
                                    adjustCounter("setState", "3", Valueadjust.Set);
                                }
                            }
                        } else {
                            // advanceToFrontline (3)
                            adjustCounter("setState", "3", Valueadjust.Set);
                        }
                    }
                }
            }
        }
        // SETSTATES
        if (checkCounter("setState", "0", Valuecompare.Greater)) {
            // retreatHP (1)
            if (checkCounter("setState", "1", Valuecompare.Equal)) {
                // just once
                log("HP RETREAT", "", "");
                removeTarget();
                // already in retreat hp state
                if (checkCounter("state", "1", Valuecompare.Equal)) {
                    adjustCounter("LookingForHealth", "0", Valueadjust.Set);
                    setBool("HealthFound", Flagtoggle.No);
                }
                selectDestWaypoint("INVALID", Ownenemy.OWN_TEAM);
                adjustCounter("state", "1", Valueadjust.Set);
                executeBehaviourTree("SuperFindHealthPack_nailcliper");
                if (hasDestWaypoint()) {
                } else {
                    if (getBoolEquals("Summoner", Yesno.Yes)) {
                        if (isUpgradeEnabled(Yesno.Yes, "HealTotem")) {
                            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                pressButton(Buttons.FACE_TOP, 0.1D);
                            }
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepHealTotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 100.0D, "0", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                            } else {
                                selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                            }
                        } else {
                            adjustCounter("state", "10", Valueadjust.Set);
                            selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                        }
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 400.0D, "0", 0.0D, 0.0D, 0.8D, 0.5D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepHealTotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 200.0D, "0", 0.0D, 0.0D, 0.8D, 0.5D, Yesno.No)) {
                            log("Chase Summoner", "", "");
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.08D, 0.05D, Valuecompare2 .GreaterOrEqual, 40.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            selectTargetWaypoint();
                        } else {
                            if (isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)&&getBoolEquals("AmSafe", Yesno.Yes)) {
                                    // getNeutrals (5)
                                    adjustCounter("setState", "5", Valueadjust.Set);
                                } else {
                                    selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                                    adjustCounter("state", "10", Valueadjust.Set);
                                }
                            } else {
                                selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                                adjustCounter("state", "10", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
            // standby (2)
            if (checkCounter("setState", "2", Valuecompare.Equal)) {
                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    removeTarget();
                } else {
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                    if (hasTarget(Yesno.Yes)) {
                        selectTargetWaypoint();
                        if (hasDestWaypoint()) {
                        } else {
                            removeTarget();
                        }
                    }
                }
                if (getBoolEquals("IgnoreEnemies", Yesno.Yes)||hasTarget(Yesno.No)) {
                    log("STANDBY", "", "");
                    adjustCounter("TimeSpentInStandby", "0", Valueadjust.Set);
                    adjustCounter("state", "2", Valueadjust.Set);
                }
            }
            // advanceToFrontline (3)
            if (checkCounter("setState", "3", Valuecompare.Equal)) {
                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    removeTarget();
                    setBool("LookingForHealthPacks", Flagtoggle.No);
                } else {
                    executeBehaviourTree("SuperFindAndTargetEnemiesShortRange_nailcliper");
                    if (hasTarget(Yesno.Yes)) {
                        selectTargetWaypoint();
                        if (hasDestWaypoint()) {
                        } else {
                            removeTarget();
                        }
                    }
                }
                if (hasTarget(Yesno.No)||getBoolEquals("IgnoreEnemies", Yesno.Yes)) {
                    adjustCounter("state", "3", Valueadjust.Set);
                    log("ADVANCE!", "", "");
                    setBool("Teleporting", Flagtoggle.No);
                    // no lane -> choose one
                    if (checkCounter("lane", "0", Valuecompare.Equal)) {
                        // from middle, outward counting
                        adjustCounter("positionInLane", "1", Valueadjust.Set);
                        if (random("2")) {
                            adjustCounter("lane", "1", Valueadjust.Set);
                        } else {
                            adjustCounter("lane", "2", Valueadjust.Set);
                        }
                    }
                    if (getBoolEquals("AttackbaseRed_Warning", Yesno.Yes)||getBoolEquals("AttackbaseBlue_Warning", Yesno.Yes)) {
                        if (isFromTeam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
                            if (getBoolEquals("AttackbaseRed_Warning", Yesno.Yes)) {
                                if (getBoolEquals("AttackbaseBlue_Warning", Yesno.Yes)) {
                                    selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                    log("BEST DEFENSE IS OFFENSE", "", "");
                                } else {
                                    selectDestWaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                    log("DEFENSEN!", "", "");
                                }
                                setBool("PanicMode", Flagtoggle.Yes);
                            } else {
                                setBool("PanicMode", Flagtoggle.No);
                            }
                        } else {
                            if (getBoolEquals("AttackbaseBlue_Warning", Yesno.Yes)) {
                                if (getBoolEquals("AttackbaseRed_Warning", Yesno.Yes)) {
                                    selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                } else {
                                    selectDestWaypoint("FINALSTAND", Ownenemy.OWN_TEAM);
                                }
                                setBool("PanicMode", Flagtoggle.Yes);
                            } else {
                                setBool("PanicMode", Flagtoggle.No);
                            }
                        }
                    } else {
                        executeBehaviourTree("FN_SelectFrontlineWaypoint");
                    }
                }
            }
            // chaseBattle (4)
            if (checkCounter("setState", "4", Valuecompare.Equal)) {
                log("CHASE", "", "");
                selectTargetWaypoint();
                adjustCounter("state", "4", Valueadjust.Set);
            }
            // getNeutrals (5)
            if (checkCounter("setState", "5", Valuecompare.Equal)) {
                log("GET SUM NEUTRAOLS", "", "");
                removeTarget();
                setBool("Recentlyhuntedcreeps", Flagtoggle.Yes);
                if (random("4")) {
                    selectDestWaypoint("NEUTRALUPPERSPOT", Ownenemy.OWN_TEAM);
                } else {
                    if (random("2")) {
                        selectDestWaypoint("NEUTRALSIDESPOT", Ownenemy.OWN_TEAM);
                    } else {
                        selectDestWaypoint("NEUTRALCENTERSPOT", Ownenemy.OWN_TEAM);
                    }
                }
                if (getBoolEquals("Summoner", Yesno.No)||isUpgradeEnabled(Yesno.Yes, "")) {
                    adjustCounter("state", "5", Valueadjust.Set);
                }
            }
            // fleeTower (6)
            if (checkCounter("setState", "6", Valuecompare.Equal)) {
                log("DANGER - TOWER", "", "");
                adjustCounter("state", "6", Valueadjust.Set);
            }
            // freeCreeps (7)
            if (checkCounter("setState", "7", Valuecompare.Equal)) {
                log("FREE CREEPS", "", "");
                removeTarget();
                adjustCounter("state", "7", Valueadjust.Set);
                selectDestWaypoint("FREECREEPS", Ownenemy.OWN_TEAM);
            }
            // pushTower (8)
            if (checkCounter("setState", "8", Valuecompare.Equal)) {
                log("PUSH TOWER", "", "");
                selectTargetWaypoint();
                adjustCounter("state", "8", Valueadjust.Set);
            }
            // collect monay (9)
            if (checkCounter("setState", "9", Valuecompare.Equal)) {
                log("COLLECT MONAY", "", "");
                adjustCounter("state", "9", Valueadjust.Set);
            }
            // returnToUpgrade (10)
            if (checkCounter("setState", "10", Valuecompare.Equal)) {
                log("RETURN TO UPGRADE", "", "");
                removeTarget();
                if (checkCounter("state", "10", Valuecompare.Equal)) {
                } else {
                    adjustCounter("state", "10", Valueadjust.Set);
                    selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
                }
            }
            // Defend towers (11)
            if (checkCounter("setState", "11", Valuecompare.Equal)) {
                log("DEFENDING TOWERS", "", "");
                adjustCounter("state", "11", Valueadjust.Set);
            }
            // fleeNauts (12)
            if (checkCounter("setState", "12", Valuecompare.Equal)) {
                // fleeNauts (12)
                adjustCounter("state", "12", Valueadjust.Set);
            }
            if (hasDestWaypoint()||checkCounter("state", "9", Valuecompare.Equal)) {
                adjustCounter("setState", "0", Valueadjust.Set);
            } else {
                log("waypoint invalid", "", "");
                adjustCounter("setState", "3", Valueadjust.Set);
            }
        }
        // Dodge
        if (timer(Timeunits.Seconds, 0.1D, Yesno.Yes)) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                setBool("CheckToDodge", Flagtoggle.Yes);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (timer(Timeunits.Seconds, 0.25D, Yesno.No)) {
                        setBool("CheckToDodge", Flagtoggle.Yes);
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                            setBool("CheckToDodge", Flagtoggle.Yes);
                        }
                    } else {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            setBool("CheckToDodge", Flagtoggle.Yes);
                        }
                    }
                }
            }
            if (getBoolEquals("CheckToDodge", Yesno.Yes)) {
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Blazer", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)) {
                        setBool("Dodge", Flagtoggle.Yes);
                    }
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Chameleon")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Chameleon", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.18D, 0.1D, Yesno.No)) {
                        setBool("Dodge", Flagtoggle.Yes);
                    }
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.15D, 0.1D, Yesno.No)) {
                        setBool("Dodge", Flagtoggle.Yes);
                    }
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.6D, 0.4D, Yesno.No)) {
                            if (checkClass(Targetself.Self, "Dasher")) {
                                if (isUpgradeEnabled(Yesno.Yes, "Dash")) {
                                    if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No)) {
                                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        } else {
                                            setBool("Dodge", Flagtoggle.Yes);
                                        }
                                    } else {
                                        setBool("Dodge", Flagtoggle.Yes);
                                    }
                                }
                            } else {
                                if (checkClass(Targetself.Self, "Chameleon")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "0", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No)) {
                                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                            } else {
                                                setBool("Dodge", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("Dodge", Flagtoggle.Yes);
                                        }
                                    } else {
                                        setBool("Dodge", Flagtoggle.Yes);
                                    }
                                } else {
                                    setBool("Dodge", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
                if (checkCounter("state", "8", Valuecompare.Equal)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.5D, 0.0D, 0.8D, 1.0D, Yesno.Yes, Yesno.No)) {
                    // avoid mines
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.1D, 0.05D, Yesno.No, Yesno.No)) {
                        setBool("Dodge", Flagtoggle.Yes);
                    }
                } else {
                    // avoid mines
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.05D, Yesno.No, Yesno.No)) {
                        setBool("Dodge", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("Dodge", Yesno.Yes)) {
                    if (getBoolEquals("Tank", Yesno.Yes)||getBoolEquals("Jetter", Yesno.Yes)) {
                        sequence5();
                    } else {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
                setBool("CheckToDodge", Flagtoggle.No);
                setBool("Dodge", Flagtoggle.No);
            }
        }
        if (getBoolEquals("DangerCheck", Yesno.No)) {
            if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                setBool("AmSafe", Flagtoggle.No);
                if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("AmSafe", Flagtoggle.Yes);
                }
                if (getBoolEquals("AmSafe", Yesno.No)) {
                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No, Yesno.Yes)&&isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                        // solar boss not near
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.Yes)) {
                        } else {
                            setBool("AmSafe", Flagtoggle.Yes);
                        }
                    }
                }
                if (getBoolEquals("AmSafe", Yesno.No)) {
                    // Coco not nearby
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Blazer", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                        setBool("AmSafe", Flagtoggle.No);
                    } else {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 30.0D, 1.2D, 0.0D, 2.0D, 0.6D, Yesno.No)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -1.0D, 0.0D, 2.0D, 1.0D, Yesno.No, Yesno.No)) {
                                } else {
                                    setBool("AmSafe", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 30.0D, -1.2D, 0.0D, 2.0D, 0.6D, Yesno.No)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 1.0D, 0.0D, 2.0D, 1.0D, Yesno.No, Yesno.No)) {
                                } else {
                                    setBool("AmSafe", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
            // Check behind for danger
            if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                setBool("MadeItToSafety", Flagtoggle.Yes);
                if (getBoolEquals("BackDangerPresent", Yesno.Yes)) {
                    setBool("MadeItToSafety", Flagtoggle.No);
                }
                setBool("BackDangerPresent", Flagtoggle.No);
                setBool("BackDangerCheckDone", Flagtoggle.No);
                if (getBoolEquals("BackDangerCheckDone", Yesno.No)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "WORMWARNING", -0.12D, 0.0D, 0.03D, 0.03D, Yesno.No, Yesno.No)) {
                        setBool("BackDangerPresent", Flagtoggle.Yes);
                        setBool("BackDangerCheckDone", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("BackDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                        if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "DoingExplode")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 0.25D, Yesno.No)) {
                                setBool("BackDangerPresent", Flagtoggle.Yes);
                                setBool("BackDangerCheckDone", Flagtoggle.Yes);
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                log("EXPLODING TANK!", "", "");
                            }
                        }
                    }
                }
                if (getBoolEquals("BackDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                        if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DoingWhirlwind")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 500.0D, "", -0.3D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                setBool("BackDangerPresent", Flagtoggle.Yes);
                                setBool("BackDangerCheckDone", Flagtoggle.Yes);
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                log("WHIRLWINDING DASHER!", "", "");
                            }
                        }
                    }
                }
                if (getBoolEquals("BackDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "CreepCeilingShooter")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -0.1D, 0.35D, 0.2D, 0.7D, Yesno.No)) {
                            setBool("FrontDangerPresent", Flagtoggle.Yes);
                            setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            log("WHIRLWINDING DASHER!", "", "");
                        }
                    }
                }
                if (getBoolEquals("BackDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                        if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "Siegemode")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.Less, Targetself.Self)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                                } else {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 400.0D, "", -0.3D, 0.0D, 0.6D, 0.2D, Yesno.No)) {
                                        setBool("BackDangerPresent", Flagtoggle.Yes);
                                        setBool("BackDangerCheckDone", Flagtoggle.Yes);
                                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                        log("TRANSFORMED HEAVY!", "", "");
                                    }
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("BackDangerPresent", Yesno.No)) {
                    if (getBoolEquals("MadeItToSafety", Yesno.Yes)) {
                    }
                } else {
                    setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                    adjustCounter("state", "3", Valueadjust.Set);
                }
            }
            // Check forward for danger
            if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                setBool("FrontDangerPresent", Flagtoggle.No);
                if (getBoolEquals("BackDangerPresent", Yesno.No)||directionToEnemyBase(Forwardbackward.FORWARD)) {
                    setBool("FrontDangerCheckDone", Flagtoggle.No);
                } else {
                    setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                }
                if (getBoolEquals("FrontDangerCheckDone", Yesno.No)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "WORMWARNING", 0.12D, 0.0D, 0.03D, 0.03D, Yesno.No, Yesno.No)) {
                        setBool("FrontDangerPresent", Flagtoggle.Yes);
                        setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("FrontDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                        if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "DoingExplode")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.15D, 0.0D, 0.3D, 0.2D, Yesno.No)) {
                                setBool("FrontDangerPresent", Flagtoggle.Yes);
                                setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                log("EXPLODING TANK!", "", "");
                            }
                        }
                    }
                }
                if (getBoolEquals("FrontDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                        if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DoingWhirlwind")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 500.0D, "", 0.1D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                                setBool("FrontDangerPresent", Flagtoggle.Yes);
                                setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                log("WHIRLWINDING DASHER!", "", "");
                            }
                        }
                    }
                }
                if (getBoolEquals("FrontDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "CreepCeilingShooter")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.1D, 0.35D, 0.2D, 0.7D, Yesno.No)) {
                            setBool("FrontDangerPresent", Flagtoggle.Yes);
                            setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            log("WHIRLWINDING DASHER!", "", "");
                        }
                    }
                }
                if (getBoolEquals("FrontDangerCheckDone", Yesno.No)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                        if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "Siegemode")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.Less, Targetself.Self)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                                } else {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 400.0D, "", 0.3D, 0.0D, 0.6D, 0.2D, Yesno.No)) {
                                        setBool("FrontDangerPresent", Flagtoggle.Yes);
                                        setBool("FrontDangerCheckDone", Flagtoggle.Yes);
                                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                        log("TRANSFORMED HEAVY!", "", "");
                                    }
                                }
                            }
                        }
                    }
                }
                setBool("FrontDangerCheckDone", Flagtoggle.Yes);
            }
            if (getBoolEquals("BackDangerPresent", Yesno.Yes)) {
                setBool("GoForward", Flagtoggle.Yes);
                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                setBool("GoBack", Flagtoggle.No);
                if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                    if (random("3")) {
                        // greens
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                            setBool("downjump", Flagtoggle.Yes);
                        } else {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
            } else {
                if (getBoolEquals("FrontDangerPresent", Yesno.Yes)) {
                    setBool("GoForward", Flagtoggle.No);
                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                    setBool("GoBack", Flagtoggle.Yes);
                } else {
                    if (getBoolEquals("ForceWaypointMovement", Yesno.Yes)) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                            }
                        }
                        setBool("ForceWaypointMovement", Flagtoggle.No);
                        setBool("WaypointMovement", Flagtoggle.Yes);
                        setBool("CantFindNextWaypoint", Flagtoggle.No);
                        if (isAtDestWaypoint()) {
                        } else {
                            if (getBoolEquals("Teleporting", Yesno.Yes)) {
                            } else {
                                if (isNextWaypointPosition(Offsetposition.BACK)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                } else {
                                    if (isNextWaypointPosition(Offsetposition.BELOW)) {
                                        if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                        } else {
                                            setBool("GoDown", Flagtoggle.Yes);
                                            setBool("DownJump", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isNextWaypointPosition(Offsetposition.HORIZONTALEQUAL)) {
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    if (isNextWaypointPosition(Offsetposition.FRONT)) {
                                        setBool("GoForward", Flagtoggle.Yes);
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.1D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, -0.03D, 0.08D, 0.02D, Yesno.No, Yesno.Yes)) {
                                            if (getBoolEquals("Jetter", Yesno.Yes)) {
                                                setBool("GoForward", Flagtoggle.No);
                                                // check walls
                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                                                    // check walls
                                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.1D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                                                        setBool("jump", Flagtoggle.Yes);
                                                    } else {
                                                        setBool("DownJump", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    setBool("jump", Flagtoggle.Yes);
                                                }
                                            } else {
                                                setBool("jump", Flagtoggle.Yes);
                                            }
                                        }
                                    } else {
                                        if (isNextWaypointPosition(Offsetposition.BELOW)) {
                                        } else {
                                            if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                                            } else {
                                                setBool("CantFindNextWaypoint", Flagtoggle.Yes);
                                            }
                                        }
                                        setBool("GoForward", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    } else {
                        setBool("WaypointMovement", Flagtoggle.No);
                    }
                }
            }
        }
        // Retreat logic
        if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
            if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                setBool("CheckHealth", Flagtoggle.No);
                if (isOnlineMatch()) {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                setBool("CheckHealth", Flagtoggle.Yes);
                            } else {
                                if (random("2")) {
                                    setBool("CheckHealth", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            if (random("4")) {
                                setBool("CheckHealth", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (random("6")) {
                            setBool("CheckHealth", Flagtoggle.Yes);
                        }
                    }
                } else {
                    setBool("CheckHealth", Flagtoggle.Yes);
                }
            }
            if (getBoolEquals("CheckHealth", Yesno.Yes)) {
                // Not fleeing for Towers
                if (checkCounter("state", "6", Valuecompare.Equal)) {
                } else {
                    setBool("EmergencyDefense", Flagtoggle.No);
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 2.0D, 1.2D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            if (checkCounter("TeamNo", "0", Valuecompare.Equal)) {
                                if (getBoolEquals("AttackbaseRed_Warning", Yesno.Yes)) {
                                    setBool("EmergencyDefense", Flagtoggle.Yes);
                                }
                            } else {
                                if (checkCounter("TeamNo", "1", Valuecompare.Equal)) {
                                    if (getBoolEquals("AttackbaseBlue_Warning", Yesno.Yes)) {
                                        setBool("EmergencyDefense", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                    if (getBoolEquals("EmergencyDefense", Yesno.No)) {
                        if (checkCounter("state", "1", Valuecompare.Equal)&&checkCounter("state", "10", Valuecompare.Equal)) {
                        } else {
                            if (getBoolEquals("AmSafe", Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
                                    if (checkCounter("Danger", "2", Valuecompare.Greater)) {
                                        // returnToUpgrade(10)
                                        adjustCounter("setState", "10", Valueadjust.Set);
                                    }
                                }
                            }
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.Less, Targetself.Self)) {
                                adjustCounter("setState", "1", Valueadjust.Set);
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 15.0D, Valuecompare.Less, Targetself.Self)) {
                                    // returnToUpgrade(10)
                                    adjustCounter("setState", "10", Valueadjust.Set);
                                }
                            }
                            if (((((checkCounter("state", "2", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "5", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||getBoolEquals("Recentlyhuntedcreeps", Yesno.Yes))||isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            } else {
                                if (getBoolEquals("Chasemode", Yesno.No)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.Less, Targetself.Self)) {
                                        if (random("8")) {
                                            // hunt creeps
                                            adjustCounter("setState", "5", Valueadjust.Set);
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.Less, Targetself.Self)) {
                                                if (random("4")) {
                                                    // hunt creeps
                                                    adjustCounter("setState", "5", Valueadjust.Set);
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
                                                        if (random("2")) {
                                                            // hunt creeps
                                                            adjustCounter("setState", "5", Valueadjust.Set);
                                                        }
                                                    } else {
                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.Less, Targetself.Self)) {
                                                            // hunt creeps
                                                            adjustCounter("setState", "5", Valueadjust.Set);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.Greater, Targetself.Self)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 70.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                    adjustCounter("setState", "1", Valueadjust.Set);
                                } else {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 50.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                        if (random("4")) {
                                            adjustCounter("setState", "1", Valueadjust.Set);
                                        }
                                    }
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                        adjustCounter("setState", "1", Valueadjust.Set);
                                    } else {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                            if (random("4")) {
                                                adjustCounter("setState", "1", Valueadjust.Set);
                                            }
                                        }
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                            adjustCounter("setState", "1", Valueadjust.Set);
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                                if (random("2")) {
                                                    adjustCounter("setState", "1", Valueadjust.Set);
                                                }
                                            }
                                        }
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 20.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                                adjustCounter("setState", "1", Valueadjust.Set);
                                            }
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 15.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                                adjustCounter("setState", "1", Valueadjust.Set);
                                            }
                                        }
                                    }
                                }
                            }
                            setBool("CheckToGoBack", Flagtoggle.Yes);
                        }
                    }
                }
            }
            if (getBoolEquals("Recentlyhuntedcreeps", Yesno.Yes)) {
                if (timer(Timeunits.Seconds, 30.0D, Yesno.No)) {
                    setBool("Recentlyhuntedcreeps", Flagtoggle.No);
                }
            }
        }
        // Check To Go Back
        if (getBoolEquals("CheckToGoBack", Yesno.Yes)) {
            if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                adjustCounter("LastVisted", "0", Valueadjust.Set);
            } else {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    adjustCounter("LastVisted", "1", Valueadjust.Add);
                }
            }
            if ((checkCounter("state", "4", Valuecompare.Equal)&&checkCounter("state", "8", Valuecompare.Equal))&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes, Yesno.No)) {
            } else {
                // dont go back to buy items if in end game!
                if (timePassed(Timeunits.Minutes, 20.0D)) {
                } else {
                    if (checkCounter("LastVisted", "25", Valuecompare.Greater)) {
                        if (checkCharacterValue(CharactervaluesCheckable.Gold, 700.0D, Valuecompare.Greater, Targetself.Self)) {
                            // returnToUpgrade(10)
                            adjustCounter("setState", "10", Valueadjust.Set);
                            setBool("goingbacktobuyitems", Flagtoggle.Yes);
                        } else {
                            if (random("2")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Gold, 600.0D, Valuecompare.Greater, Targetself.Self)) {
                                    // returnToUpgrade(10)
                                    adjustCounter("setState", "10", Valueadjust.Set);
                                    setBool("goingbacktobuyitems", Flagtoggle.Yes);
                                }
                            } else {
                                if (random("4")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Gold, 500.0D, Valuecompare.Greater, Targetself.Self)) {
                                        // returnToUpgrade(10)
                                        adjustCounter("setState", "10", Valueadjust.Set);
                                        setBool("goingbacktobuyitems", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (random("8")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Gold, 400.0D, Valuecompare.Greater, Targetself.Self)) {
                                            // returnToUpgrade(10)
                                            adjustCounter("setState", "10", Valueadjust.Set);
                                            setBool("goingbacktobuyitems", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (checkClass(Targetself.Self, "Tank")) {
                                        } else {
                                            if (random("20")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Gold, 300.0D, Valuecompare.Greater, Targetself.Self)) {
                                                    // returnToUpgrade(10)
                                                    adjustCounter("setState", "10", Valueadjust.Set);
                                                    setBool("goingbacktobuyitems", Flagtoggle.Yes);
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
            setBool("CheckToGoBack", Flagtoggle.No);
        } else {
            if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    adjustCounter("LastVisted", "1", Valueadjust.Add);
                }
            }
        }
        if (isOnlineMatch()) {
            if (once()) {
                enableUpgrade(Yesno.Yes, "OnlineBotGold");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        // attack
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        // attack
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("GoBack", Flagtoggle.Yes);
        setBool("GoForward", Flagtoggle.Yes);
        setBool("GoForward", Flagtoggle.Yes);
        setBool("GoForward", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        // attack
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(2.0D);
        // advanceToFrontline (3)
        adjustCounter("setState", "3", Valueadjust.Set);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        setBool("jump", Flagtoggle.Yes);
        setBool("jump", Flagtoggle.Yes);
        setBool("jump", Flagtoggle.Yes);
        setBool("jump", Flagtoggle.Yes);
    }

}

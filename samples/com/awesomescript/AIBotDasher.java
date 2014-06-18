
package com.awesomescript;

import java.util.EnumSet;

public class AIBotDasher
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Dasher", Flagtoggle.Yes);
        }
        executeBehaviourTree("Dasher");
        executeBehaviourTree("GeneralAI");
        if (checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "1", Valuecompare.Equal)) {
            setBool("Whirlwinding", Flagtoggle.No);
        } else {
            if (getBoolEquals("Whirlwinding", Yesno.Yes)) {
                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.3D, 1.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.3D, 1.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                setBool("MoveTowardsTarget", Flagtoggle.Yes);
            }
            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    // Dash!
                    if (isUpgradeEnabled(Yesno.Yes, "Dash")) {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.4D, 0.0D, 0.8D, 0.6D, Yesno.No)) {
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.8D, 0.1D, Yesno.No, Yesno.No)) {
                            } else {
                                if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 50.0D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                            aimStickAtTarget(0.4D, Yesno.No);
                                            sequence0();
                                        }
                                    }
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, -0.03D, 0.28D, 0.1D, Yesno.No, Yesno.No)) {
                                        sequence1();
                                    }
                                }
                            }
                        }
                    }
                }
                // Whirlwind!
                if (isUpgradeEnabled(Yesno.Yes, "Whirlwind")) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                        sequence2();
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            sequence3();
                        }
                    }
                }
            }
        }
        // Shoot
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                if (hasTarget(Yesno.Yes)) {
                    if (isTargetInArea(Yesno.Yes, 0.15D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                        aimStickAtTarget(0.1D, Yesno.Yes);
                    }
                }
                // bullet distance +max collision width/2 + a little offset
                pressButton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
        }
        // STATES
        if (getBoolEquals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                // at shop
                if (isAtDestWaypoint()) {
                    if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                        if (canPayUpgrade("Piggybank")) {
                            buyUpgrade("Piggybank");
                        }
                    }
                    // DASH
                    if (isUpgradeEnabled(Yesno.Yes, "dash")) {
                        if (random("2")) {
                            // skill upgrades
                            if (random("2")) {
                                if (random("4")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage1")||isUpgradeEnabled(Yesno.Yes, "DasherDashCooldownred1")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "DasherDashCooldownred1")) {
                                            if (canPayUpgrade("DasherDashCooldownred2")) {
                                                if (isUpgradeEnabled(Yesno.No, "DasherDashCooldownred2")) {
                                                    buyUpgrade("DasherDashCooldownred2");
                                                }
                                            }
                                        }
                                    } else {
                                        if (random("2")) {
                                            if (canPayUpgrade("DasherDashCooldownred1")) {
                                                if (isUpgradeEnabled(Yesno.No, "DasherDashCooldownred1")) {
                                                    buyUpgrade("DasherDashCooldownred1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("DasherDashDamage6")) {
                                                if (isUpgradeEnabled(Yesno.No, "DasherDashDamage6")) {
                                                    buyUpgrade("DasherDashDamage6");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (random("2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage2")) {
                                                if (canPayUpgrade("DasherDashDamage3")) {
                                                    if (isUpgradeEnabled(Yesno.No, "DasherDashDamage3")) {
                                                        buyUpgrade("DasherDashDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("DasherDashDamage2")) {
                                                    buyUpgrade("DasherDashDamage2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("DasherDashDamage1")) {
                                                buyUpgrade("DasherDashDamage1");
                                            }
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "DasherDashStun1")) {
                                            if (canPayUpgrade("DasherDashStun2")) {
                                                if (isUpgradeEnabled(Yesno.No, "DasherDashStun2")) {
                                                    buyUpgrade("DasherDashStun2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("DasherDashStun1")) {
                                                buyUpgrade("DasherDashStun1");
                                            }
                                        }
                                    }
                                }
                            } else {
                                // WIRLWIND
                                if (isUpgradeEnabled(Yesno.Yes, "whirlwind")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindShield")) {
                                        if (random("3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindDuration1")||isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindSpeed1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindSpeed1")) {
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindDuration1")) {
                                                        if (canPayUpgrade("DasherWhirlwindDuration2")) {
                                                            if (isUpgradeEnabled(Yesno.No, "DasherWhirlwindDuration2")) {
                                                                buyUpgrade("DasherWhirlwindDuration2");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random("2")) {
                                                    if (canPayUpgrade("DasherWhirlwindSpeed1")) {
                                                        if (isUpgradeEnabled(Yesno.No, "DasherWhirlwindSpeed1")) {
                                                            buyUpgrade("DasherWhirlwindSpeed1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("DasherWhirlwindDuration1")) {
                                                        buyUpgrade("DasherWhirlwindDuration1");
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindDamage1")) {
                                                if (canPayUpgrade("DasherWhirlwindDamage2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "DasherWhirlwindDamage2")) {
                                                        buyUpgrade("DasherWhirlwindDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("DasherWhirlwindDamage1")) {
                                                    buyUpgrade("DasherWhirlwindDamage1");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("DasherWhirlwindShield")) {
                                            buyUpgrade("DasherWhirlwindShield");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("whirlwind")) {
                                        buyUpgrade("whirlwind");
                                    }
                                }
                            }
                        } else {
                            // shot & passive & hp upgrades
                            if (random("3")) {
                                if (isUpgradeEnabled(Yesno.No, "DasherSpeed")) {
                                    if (canPayUpgrade("DasherSpeed")) {
                                        buyUpgrade("DasherSpeed");
                                    }
                                }
                            } else {
                                // shots or hp
                                if (random("3")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "MoreBullets2")) {
                                        if (random("3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "DasherShotDamage")) {
                                                if (canPayUpgrade("DasherShotDamage2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "DasherShotDamage2")) {
                                                        buyUpgrade("DasherShotDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("DasherShotDamage")) {
                                                    buyUpgrade("DasherShotDamage");
                                                }
                                            }
                                        } else {
                                            if (random("2")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "DasherShotFaster")||isUpgradeEnabled(Yesno.Yes, "DasherShotPenetrate")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "DasherShotFaster")) {
                                                        if (canPayUpgrade("DasherShotFaster2")) {
                                                            if (isUpgradeEnabled(Yesno.No, "DasherShotFaster2")) {
                                                                buyUpgrade("DasherShotFaster2");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random("2")) {
                                                        if (canPayUpgrade("DasherShotPenetrate")) {
                                                            buyUpgrade("DasherShotPenetrate");
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("DasherShotFaster")) {
                                                            buyUpgrade("DasherShotFaster");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "DasherShotMore")) {
                                        } else {
                                            if (canPayUpgrade("DasherShotMore")) {
                                                buyUpgrade("DasherShotMore");
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                                        if (canPayUpgrade("addHealth1")) {
                                            buyUpgrade("addHealth1");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                                            if (canPayUpgrade("addHealth2")) {
                                                buyUpgrade("addHealth2");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                                if (canPayUpgrade("addHealth3")) {
                                                    buyUpgrade("addHealth3");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canPayUpgrade("dash")) {
                            buyUpgrade("dash");
                        }
                    }
                }
                // use dash to get away
                if (isUpgradeEnabled(Yesno.Yes, "dash")) {
                    if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                        // enemy in nearby -> dash skill
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.4D, Yesno.Yes, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                                setBool("GoForward", Flagtoggle.Yes);
                            } else {
                                if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                }
                            }
                            if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                                setBool("GoUp", Flagtoggle.Yes);
                            } else {
                                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                    setBool("GoDown", Flagtoggle.Yes);
                                }
                            }
                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                        }
                    }
                }
            }
        }
        // Move Away From Target
        if (getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (directionToEnemyBase(Forwardbackward.BACKWARD)||isInNamedArea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            } else {
                setBool("GoBack", Flagtoggle.Yes);
            }
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        // Move Towards Target
        if (getBoolEquals("MoveTowardsTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                setBool("GoBack", Flagtoggle.Yes);
            } else {
                if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    // greens
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                        setBool("DownJump", Flagtoggle.Yes);
                    }
                }
                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        setBool("GoForward", Flagtoggle.Yes);
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
            }
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        // Handle Movement
        if (getBoolEquals("CantMove", Yesno.No)) {
            setBool("HasMoved", Flagtoggle.No);
            if (getBoolEquals("GoBack", Yesno.Yes)) {
                setBool("GoBack", Flagtoggle.No);
                if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    pressStick(Directions.BACKWARD, 0.1D);
                    setBool("HasMoved", Flagtoggle.Yes);
                }
            } else {
                if (getBoolEquals("GoForward", Yesno.Yes)) {
                    pressStick(Directions.FORWARD, 0.1D);
                    setBool("HasMoved", Flagtoggle.Yes);
                    setBool("GoForward", Flagtoggle.No);
                } else {
                    // at regen area
                    if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            } else {
                                // check enemies
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                                // check walls
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("GoDown", Yesno.Yes)) {
                pressStick(Directions.DOWN, 0.1D);
                setBool("GoDown", Flagtoggle.No);
            } else {
                if (getBoolEquals("GoUp", Yesno.Yes)) {
                    pressStick(Directions.UP, 0.1D);
                    setBool("GoUp", Flagtoggle.No);
                }
            }
            if (isInNamedArea("nodoublejump", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getBoolEquals("jump", Yesno.No)) {
                    if (getBoolEquals("DownJump", Yesno.No)) {
                        if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                            if (isInNamedArea("BOTSTOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("GOUPSTOP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                enableUpgrade(Yesno.Yes, "hold");
                            } else {
                                if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                                    enableUpgrade(Yesno.Yes, "hold");
                                }
                            }
                        }
                    }
                }
                // JUMPIN
                if (getBoolEquals("DownJump", Yesno.No)) {
                    if (getBoolEquals("ReadyToJump", Yesno.No)) {
                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                            setBool("ReadyToJump", Flagtoggle.Yes);
                        }
                    } else {
                        if (getBoolEquals("jump", Yesno.Yes)) {
                            setBool("jump", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                                if (random("2")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "Dasherspeed")) {
                                        sequence4();
                                    } else {
                                        sequence5();
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "Dasherspeed")) {
                                        sequence6();
                                    } else {
                                        sequence7();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    setBool("DownJump", Flagtoggle.No);
                    if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        // downjump
                        pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                        if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)||isOnGround(Yesno.No, Targetself.Self)) {
                        } else {
                            setBool("ReadyToJump", Flagtoggle.No);
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("CantMove", Flagtoggle.Yes);
        wait(0.04D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(0.2D);
        setBool("CantMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("CantMove", Flagtoggle.Yes);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(0.2D);
        setBool("CantMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("Whirlwinding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(1.0D);
        setBool("Whirlwinding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        setBool("Whirlwinding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(1.0D);
        setBool("Whirlwinding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.6D);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.8D);
    }

}

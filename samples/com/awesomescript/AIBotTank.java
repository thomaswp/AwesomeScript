
package com.awesomescript;

import java.util.EnumSet;

public class AIBotTank
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Tank", Flagtoggle.Yes);
        }
        executeBehaviourTree("Tank");
        executeBehaviourTree("GeneralAI");
        if (checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "1", Valuecompare.Equal)) {
            setBool("Exploding", Flagtoggle.No);
        } else {
            if (getBoolEquals("Exploding", Yesno.Yes)) {
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                setBool("MoveTowardsTarget", Flagtoggle.Yes);
            }
            // Bite!
            if (isUpgradeEnabled(Yesno.Yes, "LifeSteal")) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.Less, Targetself.Self)) {
                    if (getBoolEquals("hasBitten", Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.0D, 0.2D, 0.3D, Yesno.No, Yesno.No)) {
                            log("I will bite you!", "", "");
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.1D, 0.0D, 0.2D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            sequence0();
                        }
                    }
                }
            }
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                // Explode!
                if (isUpgradeEnabled(Yesno.Yes, "suicide")) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 70.0D, Valuecompare.Greater, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No, Yesno.No)) {
                                sequence1();
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 90.0D, Valuecompare.Greater, Targetself.Self)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.Greater, 80.0D, "0", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No)) {
                                    sequence2();
                                }
                            }
                        }
                    }
                }
            }
        }
        // Shoot
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                if (hasTarget(Yesno.Yes)) {
                    if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                        aimStickAtTarget(0.1D, Yesno.Yes);
                    }
                }
                pressButton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.1D, Yesno.Yes, Yesno.No)) {
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
                    // Bite
                    if (isUpgradeEnabled(Yesno.Yes, "LifeSteal")) {
                        if (random("2")) {
                            // skill upgrades
                            if (random("2")) {
                                if (isUpgradeEnabled(Yesno.Yes, "TankBiteTargets1")) {
                                    if (random("4")) {
                                        if (canPayUpgrade("TankBiteSnare")) {
                                            if (isUpgradeEnabled(Yesno.No, "TankBiteSnare")) {
                                                buyUpgrade("TankBiteSnare");
                                            }
                                        }
                                    } else {
                                        if (random("3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "TankBiteDamage2")) {
                                                if (canPayUpgrade("TankBiteDamage3")) {
                                                    if (isUpgradeEnabled(Yesno.No, "TankBiteDamage3")) {
                                                        buyUpgrade("TankBiteDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("TankBiteDamage2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "TankBiteDamage2")) {
                                                        buyUpgrade("TankBiteDamage2");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("TankBiteTargets1")) {
                                        if (isUpgradeEnabled(Yesno.No, "TankBiteTargets1")) {
                                            buyUpgrade("TankBiteTargets1");
                                        }
                                    }
                                }
                            } else {
                                // Self Explode
                                if (isUpgradeEnabled(Yesno.Yes, "suicide")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "TankExplodeDamage1")) {
                                        if (random("4")) {
                                            if (canPayUpgrade("TankExplodeDamage2")) {
                                                if (isUpgradeEnabled(Yesno.No, "TankExplodeDamage2")) {
                                                    buyUpgrade("TankExplodeDamage2");
                                                }
                                            }
                                        } else {
                                            if (random("3")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "TankExplodeHardhat1")) {
                                                    if (canPayUpgrade("TankExplodeHardhat2")) {
                                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeHardhat2")) {
                                                            buyUpgrade("TankExplodeHardhat2");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("TankExplodeHardhat1")) {
                                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeHardhat1")) {
                                                            buyUpgrade("TankExplodeHardhat1");
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "TankExplodeSlow1")) {
                                                    if (canPayUpgrade("TankExplodeSlow2")) {
                                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeSlow2")) {
                                                            buyUpgrade("TankExplodeSlow2");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("TankExplodeSlow1")) {
                                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeSlow1")) {
                                                            buyUpgrade("TankExplodeSlow1");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("TankExplodeDamage1")) {
                                            if (isUpgradeEnabled(Yesno.No, "TankExplodeDamage1")) {
                                                buyUpgrade("TankExplodeDamage1");
                                            }
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("suicide")) {
                                        if (isUpgradeEnabled(Yesno.No, "suicide")) {
                                            buyUpgrade("suicide");
                                        }
                                    }
                                }
                            }
                        } else {
                            // shot & passive & hp upgrades
                            if (random("3")) {
                                if (canPayUpgrade("tankspeed")) {
                                    if (isUpgradeEnabled(Yesno.No, "tankspeed")) {
                                        buyUpgrade("tankspeed");
                                    }
                                }
                            } else {
                                // passive or hp
                                if (random("3")) {
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
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "TankShotSpeed")) {
                                        // SHOTS
                                        if (random("2")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "TankShotAOE")) {
                                                if (canPayUpgrade("TankShotSpeed2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "TankShotSpeed2")) {
                                                        buyUpgrade("TankShotSpeed2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("TankShotAOE")) {
                                                    buyUpgrade("TankShotAOE");
                                                }
                                            }
                                            if (isUpgradeEnabled(Yesno.Yes, "TankShotHoming")) {
                                                if (canPayUpgrade("TankShotSpeed2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "TankShotSpeed2")) {
                                                        buyUpgrade("TankShotSpeed2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("TankShotHoming")) {
                                                    buyUpgrade("TankShotHoming");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("TankShotSpeed")) {
                                            if (isUpgradeEnabled(Yesno.No, "TankShotSpeed")) {
                                                buyUpgrade("TankShotSpeed");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canPayUpgrade("LifeSteal")) {
                            buyUpgrade("LifeSteal");
                        }
                    }
                    // all better now
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Equal, Targetself.Self)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            if (random("2")) {
                                adjustCounter("lane", "1", Valueadjust.Set);
                            } else {
                                adjustCounter("lane", "2", Valueadjust.Set);
                            }
                        }
                        sequence3();
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
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
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
                                    if (random("3")) {
                                        setBool("DownJump", Flagtoggle.Yes);
                                    } else {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
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
        }
        // JUMPIN
        if (getBoolEquals("DownJump", Yesno.No)) {
            if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                    } else {
                        pressButton(Buttons.FACE_BOTTOM, 0.1D);
                    }
                }
            }
        } else {
            setBool("DownJump", Flagtoggle.No);
            // downjump
            pressButton(Buttons.SHOULDER_LEFT, 0.1D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("hasBitten", Flagtoggle.Yes);
        setBool("MoveTowardsTarget", Flagtoggle.Yes);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(4.1D);
        setBool("hasBitten", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("Exploding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setBool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.4D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
        setBool("Exploding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setBool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(2.0D);
        // advanceToFrontline (3)
        adjustCounter("setState", "3", Valueadjust.Set);
    }

}

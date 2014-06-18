
package com.awesomescript;

import java.util.EnumSet;

public class AIBotChameleon
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Chameleon", Flagtoggle.Yes);
        }
        executeBehaviourTree("Chameleon");
        executeBehaviourTree("GeneralAI");
        if ((isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))||getBoolEquals("InStealth", Yesno.No))||checkCounter("state", "4", Valuecompare.Equal)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.Greater, Targetself.Self)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.14D, 0.1D, Yesno.Yes, Yesno.No)) {
                // enemy in front -> always shoot
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.14D, 0.1D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                    setBool("BreakStealth", Flagtoggle.Yes);
                } else {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueRange")) {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                        aimStickAtTarget(0.2D, Yesno.No);
                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        setBool("BreakStealth", Flagtoggle.Yes);
                                    }
                                }
                            } else {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                        aimStickAtTarget(0.2D, Yesno.No);
                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        setBool("BreakStealth", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Stealth
        if (getBoolEquals("InStealth", Yesno.Yes)) {
            if (getBoolEquals("BreakStealth", Yesno.Yes)) {
                log("Come Out Of Stealth", "", "");
                setBool("InStealth", Flagtoggle.No);
                setBool("BreakStealth", Flagtoggle.No);
            }
        } else {
            if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                // enemy in front -> always shoot
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.18D, 0.06D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
            if (isUpgradeEnabled(Yesno.Yes, "stealth")) {
                if (checkCounter("StealthInTime", "8", Valuecompare.Greater)) {
                    if (getBoolEquals("GoStealth", Yesno.Yes)) {
                        log("Go In Stealth", "", "");
                        setBool("GoStealth", Flagtoggle.No);
                        setBool("InStealth", Flagtoggle.Yes);
                        adjustCounter("StealthInTime", "0", Valueadjust.Set);
                        pressButton(Buttons.FACE_TOP, 0.0D);
                    }
                } else {
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        adjustCounter("StealthInTime", "1", Valueadjust.Add);
                    }
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
                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitCrit")) {
                        if (random("2")||checkCounter("SupportBuild", "2", Valuecompare.Greater)) {
                            if (random("2")||checkCounter("SupportBuild", "0", Valuecompare.Greater)) {
                                // stealth
                                if (isUpgradeEnabled(Yesno.Yes, "stealth")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneWalk")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneAttack")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneExplode")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneExplode2")) {
                                                } else {
                                                    if (canPayUpgrade("ChameleonStealthCloneExplode2")) {
                                                        buyUpgrade("ChameleonStealthCloneExplode2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("ChameleonStealthCloneExplode")) {
                                                    buyUpgrade("ChameleonStealthCloneExplode");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("ChameleonStealthCloneAttack")) {
                                                buyUpgrade("ChameleonStealthCloneAttack");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("ChameleonStealthCloneWalk")) {
                                            buyUpgrade("ChameleonStealthCloneWalk");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("stealth")) {
                                        buyUpgrade("stealth");
                                    }
                                }
                            } else {
                                // Tongue
                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage1")) {
                                        if (random("2")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage2")) {
                                                if (canPayUpgrade("ChameleonTongueDamage3")) {
                                                    if (isUpgradeEnabled(Yesno.No, "ChameleonTongueDamage3")) {
                                                        buyUpgrade("ChameleonTongueDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("ChameleonTongueDamage2")) {
                                                    buyUpgrade("ChameleonTongueDamage2");
                                                }
                                            }
                                            if (canPayUpgrade("ChameleonTongueDamage4")) {
                                                if (isUpgradeEnabled(Yesno.No, "ChameleonTongueDamage4")) {
                                                    buyUpgrade("ChameleonTongueDamage4");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUERANGE1")) {
                                                } else {
                                                    if (canPayUpgrade("ChameleonTongueRange1")) {
                                                        buyUpgrade("ChameleonTongueRange1");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("ChameleonTongueDamage1")) {
                                            buyUpgrade("ChameleonTongueDamage1");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("ChameleonTongue")) {
                                        buyUpgrade("ChameleonTongue");
                                    }
                                }
                            }
                        } else {
                            if (checkCounter("SupportBuild", "0", Valuecompare.Greater)||random("2")) {
                                if (random("3")||checkCounter("SupportBuild", "0", Valuecompare.LessOrEqual)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitDamage1")) {
                                        // SHOTS
                                        if (random("4")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitDamage2")) {
                                                if (canPayUpgrade("ChameleonHitDamage3")) {
                                                    if (isUpgradeEnabled(Yesno.No, "ChameleonHitDamage3")) {
                                                        buyUpgrade("ChameleonHitDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("ChameleonHitDamage2")) {
                                                    buyUpgrade("ChameleonHitDamage2");
                                                }
                                            }
                                        } else {
                                            if (random("3")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitAttackspeed1")) {
                                                    if (canPayUpgrade("ChameleonHitAttackspeed2")) {
                                                        if (isUpgradeEnabled(Yesno.No, "ChameleonHitAttackspeed2")) {
                                                            buyUpgrade("ChameleonHitAttackspeed2");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("ChameleonHitAttackspeed1")) {
                                                        buyUpgrade("ChameleonHitAttackspeed1");
                                                    }
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONHITCRIT2")) {
                                                } else {
                                                    if (canPayUpgrade("CHAMELEONHITCRIT2")) {
                                                        buyUpgrade("CHAMELEONHITCRIT2");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("ChameleonHitDamage1")) {
                                            buyUpgrade("ChameleonHitDamage1");
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                                        if (canPayUpgrade("addHealth1")) {
                                            buyUpgrade("addHealth1");
                                            adjustCounter("SupportBuild", "-2", Valueadjust.Add);
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
                            } else {
                                // PASSIVE
                                if (random("1")) {
                                    if (canPayUpgrade("ChameleonSpeed")) {
                                        if (isUpgradeEnabled(Yesno.No, "ChameleonSpeed")) {
                                            buyUpgrade("ChameleonSpeed");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canPayUpgrade("ChameleonHitCrit")) {
                            buyUpgrade("ChameleonHitCrit");
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
                            }
                        }
                    }
                }
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        // jump
                        pressButton(Buttons.FACE_BOTTOM, 0.3D);
                    }
                }
                // JUMPIN
                if (getBoolEquals("DownJump", Yesno.No)) {
                } else {
                    setBool("DownJump", Flagtoggle.No);
                    if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        // downjump
                        pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                    }
                }
            }
            if (getBoolEquals("DontMove", Yesno.No)) {
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
                                    // check walls
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.04D, 0.02D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.12D, 0.02D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                setBool("DontMove", Flagtoggle.No);
            }
        }
    }

}

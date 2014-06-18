
package com.awesomescript;

import java.util.EnumSet;

public class AIBotCowboy
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Cowboy", Flagtoggle.Yes);
        }
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("GeneralAI");
        // Throw Grenade
        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
            if (isUpgradeEnabled(Yesno.Yes, "Grenade")) {
                // enemy in front -> dynamite skill
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.45D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                    aimStickAtTarget(0.45D, Yesno.No);
                    // DYNAMITE BABY
                    pressButton(Buttons.FACE_RIGHT, 0.45D);
                    sequence0();
                } else {
                    // enemy in front -> dynamite skill
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                        aimStickAtTarget(0.22D, Yesno.No);
                        // DYNAMITE BABY
                        pressButton(Buttons.FACE_RIGHT, 0.22D);
                        sequence1();
                    } else {
                        // enemy in front -> dynamite skill
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.13D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                            // DYNAMITE BABY
                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                            setBool("DontMove", Flagtoggle.Yes);
                        }
                    }
                }
            }
        }
        // Throw Bull
        if (isUpgradeEnabled(Yesno.Yes, "Bull")) {
            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                // enemy in front -> bull skill
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.35D, 0.0D, 0.65D, 0.1D, Yesno.Yes, Yesno.No)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Less, Targetself.Self)||directionToEnemyBase(Forwardbackward.BACKWARD)) {
                        // BULL
                        pressButton(Buttons.FACE_TOP, 0.0D);
                        setBool("DontMove", Flagtoggle.Yes);
                    }
                    if (checkCounter("state", "8", Valuecompare.Equal)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.8D, 0.1D, Yesno.Yes, Yesno.No)) {
                            // BULL
                            pressButton(Buttons.FACE_TOP, 0.0D);
                            setBool("DontMove", Flagtoggle.Yes);
                        }
                    }
                }
            }
        }
        // STATES
        if (getBoolEquals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                        if (canPayUpgrade("Piggybank")) {
                            buyUpgrade("Piggybank");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "Grenade")) {
                        if (random("4")) {
                            // shot & passive & hp upgrades
                            if (random("4")) {
                                if (canPayUpgrade("CowboySpeed")) {
                                    if (isUpgradeEnabled(Yesno.No, "CowboySpeed")) {
                                        buyUpgrade("CowboySpeed");
                                    }
                                }
                            } else {
                                // passive or hp
                                if (random("4")) {
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
                                    if (random("2")||isUpgradeEnabled(Yesno.Yes, "Bull")) {
                                        if (random("2")) {
                                            if (canPayUpgrade("CowboyShotDamage")) {
                                                if (isUpgradeEnabled(Yesno.No, "CowboyShotDamage")) {
                                                    buyUpgrade("CowboyShotDamage");
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyShotAttackspeed")) {
                                                if (canPayUpgrade("CowboyShotAttackspeed2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "CowboyShotAttackspeed2")) {
                                                        buyUpgrade("CowboyShotAttackspeed2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("CowboyShotAttackspeed")) {
                                                    if (isUpgradeEnabled(Yesno.No, "CowboyShotAttackspeed")) {
                                                        buyUpgrade("CowboyShotAttackspeed");
                                                    }
                                                }
                                            }
                                        }
                                        if (isUpgradeEnabled(Yesno.Yes, "CowboyShotDamage")) {
                                            if (canPayUpgrade("CowboyShotDamage2")) {
                                                if (isUpgradeEnabled(Yesno.No, "CowboyShotDamage2")) {
                                                    buyUpgrade("CowboyShotDamage2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("CowboyShotDamage")) {
                                                if (isUpgradeEnabled(Yesno.No, "CowboyShotDamage")) {
                                                    buyUpgrade("CowboyShotDamage");
                                                }
                                            }
                                        }
                                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyShotHoming")) {
                                            } else {
                                                if (canPayUpgrade("CowboyShotHoming")) {
                                                    buyUpgrade("CowboyShotHoming");
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyShotDamage3")) {
                                            } else {
                                                if (canPayUpgrade("CowboyShotDamage3")) {
                                                    buyUpgrade("CowboyShotDamage3");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("Bull")) {
                                            buyUpgrade("Bull");
                                        }
                                    }
                                }
                            }
                        } else {
                            // skill upgrades
                            if (random("4")) {
                                // BULL
                                if (isUpgradeEnabled(Yesno.Yes, "Bull")) {
                                    if (random("5")) {
                                        if (canPayUpgrade("CowboyBullBigger")) {
                                            if (isUpgradeEnabled(Yesno.No, "CowboyBullBigger")) {
                                                buyUpgrade("CowboyBullBigger");
                                            }
                                        }
                                    } else {
                                        if (random("4")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyBullCooldown")) {
                                            } else {
                                                if (canPayUpgrade("CowboyBullCooldown")) {
                                                    buyUpgrade("CowboyBullCooldown");
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyBullDamage")) {
                                                if (canPayUpgrade("CowboyBullDamage2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "CowboyBullDamage2")) {
                                                        buyUpgrade("CowboyBullDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("CowboyBullDamage")) {
                                                    buyUpgrade("CowboyBullDamage");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("Bull")) {
                                        buyUpgrade("Bull");
                                    }
                                }
                            } else {
                                // GRENADE
                                if (isUpgradeEnabled(Yesno.Yes, "Grenade")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeMore")) {
                                        if (random("3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeExplosion1")) {
                                                if (canPayUpgrade("CowboyGrenadeExplosion2")) {
                                                    if (isUpgradeEnabled(Yesno.No, "CowboyGrenadeExplosion2")) {
                                                        buyUpgrade("CowboyGrenadeExplosion2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("CowboyGrenadeExplosion1")) {
                                                    buyUpgrade("CowboyGrenadeExplosion1");
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "CowboyGrenadeDot1")) {
                                                if (canPayUpgrade("CowboyGrenadeDot2")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeDot2")) {
                                                        buyUpgrade("CowboyGrenadeDot2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("CowboyGrenadeDot1")) {
                                                    buyUpgrade("CowboyGrenadeDot1");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("CowboyGrenadeMore")) {
                                            buyUpgrade("CowboyGrenadeMore");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canPayUpgrade("Grenade")) {
                            buyUpgrade("Grenade");
                        }
                    }
                }
            }
        }
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                if (hasTarget(Yesno.Yes)) {
                    if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                        aimStickAtTarget(0.1D, Yesno.Yes);
                    }
                }
                // bullet distance +max collision width/2 + a little offset
                pressButton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
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
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.02D, 0.01D, 0.04D, Yesno.Yes, Yesno.No)) {
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
                            } else {
                                if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                                    enableUpgrade(Yesno.Yes, "hold");
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("DoingDownJump", Yesno.No)) {
                    // JUMPIN
                    if (getBoolEquals("DownJump", Yesno.No)) {
                        if (getBoolEquals("jump", Yesno.Yes)) {
                            setBool("jump", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            } else {
                                pressButton(Buttons.FACE_BOTTOM, 0.1D);
                            }
                        }
                    } else {
                        setBool("DownJump", Flagtoggle.No);
                        if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            // downjump
                            pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                        }
                    }
                }
            }
            if (getBoolEquals("DontMove", Yesno.No)) {
                setBool("HasMoved", Flagtoggle.No);
                if (getBoolEquals("GoBack", Yesno.Yes)) {
                    setBool("GoBack", Flagtoggle.No);
                    if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
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
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
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

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("DontMove", Flagtoggle.Yes);
        setBool("DontMove", Flagtoggle.Yes);
        setBool("DontMove", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("DontMove", Flagtoggle.Yes);
        setBool("DontMove", Flagtoggle.Yes);
    }

}

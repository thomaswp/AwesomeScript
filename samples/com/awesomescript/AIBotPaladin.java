
package com.awesomescript;

import java.util.EnumSet;

public class AIBotPaladin
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Paladin");
        executeBehaviourTree("VeankoAI");
        // Drop pod Solar
        if (once()) {
            adjustCharacterValue(CharactervaluesAdjustable.Gold, 40.0D, Valueadjust.Add);
        }
        if (((getBoolEquals("RetreatingFromNauts", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "4", Valuecompare.Equal)) {
            if (getBoolEquals("RetreatingFromNauts", Yesno.Yes)&&checkClass(Targetself.Target, "Spy")) {
            } else {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)&&getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    if ((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "PaladinHammerRange1")) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No, Yesno.Yes)) {
                                aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.6D, 1.0D, Yesno.No, Yesno.Yes)) {
                                aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                            }
                        }
                    }
                }
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)&&getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    if (isInNamedArea("healArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.Yes)) {
                            pressButton(Buttons.FACE_TOP, 0.0D);
                        } else {
                            if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                                pressButton(Buttons.FACE_TOP, 0.0D);
                            }
                        }
                    }
                }
                // Slash
                if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                    if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.17D, 0.0D, 0.34D, 0.34D, Yesno.No, Yesno.No)) {
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.17D, 0.0D, 0.34D, 0.34D, Yesno.No, Yesno.Yes)) {
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    }
                }
            }
        } else {
            // Pushing skills
            if (checkCounter("state", "8", Valuecompare.Equal)) {
                // Slash
                if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.17D, 0.0D, 0.34D, 0.34D, Yesno.No, Yesno.No)) {
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.17D, 0.0D, 0.34D, 0.34D, Yesno.No, Yesno.Yes)) {
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            }
        }
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Shop logic
            executeBehaviourTree("PaladinShop");
        }
        // Remain in shop for 2 seconds
        if (isInNamedArea("HealArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (checkCounter("shopCounter", "20", Valuecompare.Less)) {
                setBool("DontMove", Flagtoggle.Yes);
            }
            adjustCounter("shopCounter", "1", Valueadjust.Add);
        } else {
            adjustCounter("shopCounter", "0", Valueadjust.Set);
        }
        if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
            setBool("MoveTowardsTarget", Flagtoggle.Yes);
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        executeBehaviourTree("AwesomebotsCommonLib");
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
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            } else {
                setBool("GoBack", Flagtoggle.Yes);
            }
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        } else {
            // Move Towards Target
            if (getBoolEquals("MoveTowardsTarget", Yesno.Yes)) {
                setBool("ForceWaypointMovement", Flagtoggle.No);
                if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                    setBool("GoBack", Flagtoggle.Yes);
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        // greens
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
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
                            if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    }
                }
                setBool("MoveTowardsTarget", Flagtoggle.No);
            }
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
                        if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            if (timer(Timeunits.Seconds, 0.31D, Yesno.Yes)) {
                                // jump
                                pressButton(Buttons.FACE_BOTTOM, 0.3D);
                            }
                        }
                    }
                }
                // JUMPIN
                if (getBoolEquals("DownJump", Yesno.No)) {
                } else {
                    setBool("DownJump", Flagtoggle.No);
                    if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (isInNamedArea("ABOVEHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
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
                    if (getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self)) {
                        pressStick(Directions.BACKWARD, 0.1D);
                        setBool("HasMoved", Flagtoggle.Yes);
                    } else {
                        if (isNextWaypointPosition(Offsetposition.BELOW)) {
                            pressStick(Directions.BACKWARD, 0.1D);
                            setBool("HasMoved", Flagtoggle.Yes);
                        }
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
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.04D, 0.02D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.12D, 0.02D, Yesno.No, Yesno.No)) {
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

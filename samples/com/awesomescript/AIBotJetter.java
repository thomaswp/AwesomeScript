
package com.awesomescript;

import java.util.EnumSet;

public class AIBotJetter
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Jetter", Flagtoggle.Yes);
        }
        executeBehaviourTree("Jetter");
        executeBehaviourTree("VeankoAI_Ignotis");
        executeBehaviourTree("BetterBotSkill");
        executeBehaviourTree("JetterShop");
        // Declares Variables
        if (once()) {
            // Tracks the amount of time spent airborne
            adjustCounter("airTime", "0", Valueadjust.Set);
            // Tracks how many times, in short succession, jumped
            adjustCounter("timesJumped", "0", Valueadjust.Set);
            // Tracks how long it's been since last jump
            adjustCounter("sinceLastJump", "0", Valueadjust.Set);
            // Self-Enforcing marker for jetpack use
            enableUpgrade(Yesno.No, "JetterJet");
            // Tracks whether YuriAI is stuck
            adjustCounter("timeAtDrillCore", "0", Valueadjust.Set);
            // Helps prevent getting ganked
            setBool("DangerousNaut", Flagtoggle.No);
        }
        // Tracks whether I'm in the field
        if (isFromTeam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
            if ((((((isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREABOTTOM_1", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREAUPPER_1", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREACENTER", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREACENTERBOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                setBool("inField", Flagtoggle.Yes);
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                    setBool("inField", Flagtoggle.Yes);
                } else {
                    setBool("inField", Flagtoggle.No);
                }
            }
        } else {
            if ((((((isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREABOTTOM_0", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREAUPPER_0", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREACENTER", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInNamedArea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREACENTERBOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                setBool("inField", Flagtoggle.Yes);
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                    setBool("inField", Flagtoggle.Yes);
                } else {
                    setBool("inField", Flagtoggle.No);
                }
            }
        }
        if (getBoolEquals("DangerousNaut", Yesno.No)) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                // Explode
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    } else {
                        adjustCounter("setState", "11", Valueadjust.Set);
                    }
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodThirstON")||hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodThirstSpeedON")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    } else {
                        adjustCounter("setState", "11", Valueadjust.Set);
                    }
                }
            }
            // Is it a player?
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                // Derpl
                if (checkClass(Targetself.Target, "Heavy")) {
                    if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "SIEGEMODEON")||hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "siegeshield")) {
                        setBool("DangerousNaut", Flagtoggle.Yes);
                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                        } else {
                            adjustCounter("setState", "11", Valueadjust.Set);
                        }
                    }
                }
                // Froggy G
                if (checkClass(Targetself.Target, "Dasher")) {
                    // Whilrwind
                    if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                        setBool("DangerousNaut", Flagtoggle.Yes);
                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                        } else {
                            adjustCounter("setState", "11", Valueadjust.Set);
                        }
                    }
                }
                if (checkClass(Targetself.Target, "Hunter")||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterPressSnipe")||hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                        setBool("DangerousNaut", Flagtoggle.Yes);
                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                        } else {
                            adjustCounter("setState", "11", Valueadjust.Set);
                        }
                    }
                }
                // Sentry X-58
                if (checkClass(Targetself.Target, "Spy")) {
                    // Absorb Shield
                    if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 10.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                } else {
                                    setBool("DangerousNaut", Flagtoggle.Yes);
                                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    } else {
                                        adjustCounter("setState", "11", Valueadjust.Set);
                                    }
                                }
                            }
                        } else {
                            setBool("DangerousNaut", Flagtoggle.Yes);
                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            } else {
                                adjustCounter("setState", "11", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
        } else {
            setBool("DangerousNaut", Flagtoggle.No);
        }
        // Protect turret
        if (checkCounter("state", "11", Valuecompare.Equal)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.05D, 0.05D, Yesno.Yes)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Brute", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 20.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                        adjustCounter("setState", "10", Valueadjust.Set);
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.3D, 0.5D, Yesno.Yes, Yesno.No)) {
                            executeBehaviourTree("VeankoCheckIfEnemyTooClose");
                            if (getBoolEquals("EnemyIsTooClose", Yesno.Yes)) {
                                setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                setBool("MoveTowardsTarget", Flagtoggle.No);
                            }
                            if (hasTarget(Yesno.Yes)) {
                            } else {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                            }
                        }
                    }
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                    }
                }
            } else {
                adjustCounter("setState", "10", Valueadjust.Set);
            }
        }
        if (((isUpgradeEnabled(Yesno.Yes, "Mine")&&isSkillOnButtonAvailable(Buttons.FACE_RIGHT))&&getBoolEquals("inField", Yesno.Yes))&&getBoolEquals("CanUseSkills", Yesno.Yes)) {
            // Not defending?
            if (checkCounter("state", "11", Valuecompare.Equal)) {
            } else {
                // Not lasering a turret?
                if (getBoolEquals("laseringTurret", Yesno.No)) {
                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                } else {
                    // Reset bool
                    setBool("laseringTurret", Flagtoggle.No);
                }
            }
        }
        if ((getBoolEquals("CanUseSkills", Yesno.Yes)&&isUpgradeEnabled(Yesno.Yes, "TimeBubble"))&&isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
            if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleHeal1")&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 90.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                pressButton(Buttons.FACE_TOP, 1.0D);
            }
            if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleHeal1")&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.LessOrEqual, 80.0D, "1", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
                sequence0();
            }
            // Will trigger bubble to escape certain CCs and runs away
            if (getBoolEquals("inField", Yesno.Yes)) {
                if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Self)||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self)) {
                    pressButton(Buttons.FACE_TOP, 1.0D);
                }
                if (checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    pressButton(Buttons.FACE_TOP, 1.0D);
                }
            }
            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                // Nearby enemy?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.8D, 0.4D, Yesno.No, Yesno.No)) {
                    pressButton(Buttons.FACE_TOP, 1.0D);
                }
            }
            if (getBoolEquals("useRetreatingSkills", Yesno.Yes)) {
                pressButton(Buttons.FACE_TOP, 1.0D);
            }
            if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                pressButton(Buttons.FACE_TOP, 1.0D);
            }
        }
        // Heal allies with bubble
        if (getBoolEquals("bubbleHealAlly", Yesno.Yes)) {
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.Yes);
        }
        if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
            // Checks for times to turn the jetpack off. Can be done once every five ticks for added performance
            if (isUpgradeEnabled(Yesno.Yes, "JetterJet")) {
                adjustCounter("airTime", "1", Valueadjust.Add);
                if ((isOnGround(Yesno.Yes, Targetself.Self)||checkCounter("airTime", "10", Valuecompare.GreaterOrEqual))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.08D, 0.05D, 0.08D, Yesno.No, Yesno.Yes)) {
                    adjustCounter("airTime", "0", Valueadjust.Set);
                    enableUpgrade(Yesno.No, "JetterJet");
                }
            }
        }
        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.1D, 0.3D, Yesno.No, Yesno.No)&&checkCounter("state", "3", Valuecompare.Equal))&&isInNamedArea("HealAreaClose", Ownenemy.OWN_TEAM, Targetself.Self)) {
            adjustCounter("timeAtDrillCore", "1", Valueadjust.Add);
            // Stuck for 2 or more seconds?
            if (checkCounter("timeAtDrillCore", "20", Valuecompare.Greater)) {
                // Hijack movement for 2 seconds
                sequence1();
                adjustCounter("timeAtDrillCore", "0", Valueadjust.Set);
            }
        } else {
            adjustCounter("timeAtDrillCore", "0", Valueadjust.Set);
            if (isInNamedArea("HIDE_AREA_BOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HIDE_AREA_BOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            } else {
                // Fix getting stuck elsewhere
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                    adjustCounter("timeStuck", "1", Valueadjust.Add);
                    // Stuck for 2 or more seconds?
                    if (checkCounter("timeStuck", "20", Valuecompare.Greater)) {
                        // Disable jetpack
                        setBool("dontFly", Flagtoggle.Yes);
                        log("Stuck fix enabled", "", "");
                        adjustCounter("timeStuck", "0", Valueadjust.Set);
                    }
                } else {
                    adjustCounter("timeStuck", "0", Valueadjust.Set);
                }
            }
        }
        // Don't fly in fire
        if (isInNamedArea("HAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
            enableUpgrade(Yesno.No, "JetterJet");
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
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
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
        // JUMPIN
        if (getBoolEquals("DownJump", Yesno.No)) {
            if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    // Remap jump to GoUp
                    setBool("GoUp", Flagtoggle.Yes);
                }
            }
        } else {
            setBool("DownJump", Flagtoggle.No);
            // Remap downjump to GoDown
            setBool("GoDown", Flagtoggle.Yes);
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
            if (isInNamedArea("HIDE_AREA_TOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HIDE_AREA_TOP", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            } else {
                // Below?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -0.15D, 0.1D, 0.3D, Yesno.Yes, Yesno.No)) {
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        if (timer(Timeunits.Seconds, 1.3D, Yesno.Yes)) {
                            setBool("GoUp", Flagtoggle.Yes);
                            setBool("GoDown", Flagtoggle.No);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "JetterJet")) {
                            enableUpgrade(Yesno.Yes, "JetterJet");
                        }
                    }
                } else {
                    // Above?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.15D, 0.1D, 0.3D, Yesno.Yes, Yesno.No)) {
                        // greens
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.02D, 0.01D, 0.04D, Yesno.Yes, Yesno.No)) {
                            setBool("GoDown", Flagtoggle.Yes);
                            setBool("GoUp", Flagtoggle.No);
                        }
                    }
                }
                if (checkCounter("state", "8", Valuecompare.Equal)) {
                } else {
                    // Back?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                if (timer(Timeunits.Seconds, 1.3D, Yesno.Yes)) {
                                    setBool("GoUp", Flagtoggle.Yes);
                                    setBool("GoDown", Flagtoggle.No);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "JetterJet")) {
                                    enableUpgrade(Yesno.Yes, "JetterJet");
                                }
                            }
                        } else {
                            setBool("GoForward", Flagtoggle.Yes);
                        }
                    } else {
                        // Front?
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                if (isNextWaypointPosition(Offsetposition.FRONT)) {
                                    if (timer(Timeunits.Seconds, 1.3D, Yesno.Yes)) {
                                        setBool("GoUp", Flagtoggle.Yes);
                                        setBool("GoDown", Flagtoggle.No);
                                    }
                                } else {
                                    setBool("GoBack", Flagtoggle.Yes);
                                }
                            } else {
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    if (timer(Timeunits.Seconds, 1.3D, Yesno.Yes)) {
                                        setBool("GoUp", Flagtoggle.Yes);
                                        setBool("GoDown", Flagtoggle.No);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "JetterJet")) {
                                        enableUpgrade(Yesno.Yes, "JetterJet");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.93D, 0.93D, Yesno.Yes, Yesno.No)&&getBoolEquals("DangerousNaut", Yesno.No)) {
            // Don't interfere with Time Warp's healing
            if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
            } else {
                if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "3", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.06D, 0.0D, 0.12D, 0.1D, Yesno.Yes, Yesno.No))||getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
                } else {
                    if ((((((checkClass(Targetself.Target, "CreepMawTurret")||checkClass(Targetself.Target, "CreepDroidMelee"))||checkClass(Targetself.Target, "CreepCritterAIStation404"))||checkClass(Targetself.Target, "CreepCritterSorona"))||checkClass(Targetself.Target, "CreepCritterRibbit4"))||checkClass(Targetself.Target, "CreepCritterCrab"))||checkClass(Targetself.Target, "CreepCaptainChain")) {
                        // Am I above it?
                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.38D, 0.93D, 0.47D, Yesno.No, Yesno.No)) {
                            // Giant Monocle
                            if (isUpgradeEnabled(Yesno.Yes, "JetterSummonerShotRange")) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.Yes, 55.0D, 720.0D, 10.0D, 40.0D);
                                pressButton(Buttons.FACE_LEFT, 0.1D);
                                if (checkCounter("state", "8", Valuecompare.Equal)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                    setBool("laseringTurret", Flagtoggle.Yes);
                                }
                            } else {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.74D, 0.74D, Yesno.Yes, Yesno.No)) {
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.Yes, 55.0D, 720.0D, 30.0D, 40.0D);
                                    pressButton(Buttons.FACE_LEFT, 0.1D);
                                    if (checkCounter("state", "8", Valuecompare.Equal)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                        setBool("laseringTurret", Flagtoggle.Yes);
                                    }
                                }
                            }
                        } else {
                            log("Targeting small creep -> get above him", "", "");
                            setBool("GoUp", Flagtoggle.Yes);
                            setBool("GoDown", Flagtoggle.No);
                            setBool("dontFly", Flagtoggle.No);
                        }
                    } else {
                        // Giant Monocle
                        if (isUpgradeEnabled(Yesno.Yes, "JetterSummonerShotRange")) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.Yes, 55.0D, 720.0D, 30.0D, 40.0D);
                            pressButton(Buttons.FACE_LEFT, 0.1D);
                            if (checkCounter("state", "8", Valuecompare.Equal)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                setBool("laseringTurret", Flagtoggle.Yes);
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.74D, 0.74D, Yesno.Yes, Yesno.No)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.Yes, 55.0D, 720.0D, 30.0D, 40.0D);
                                pressButton(Buttons.FACE_LEFT, 0.1D);
                                if (checkCounter("state", "8", Valuecompare.Equal)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                    setBool("laseringTurret", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (((checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "InAir"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "dash")) {
            if ((hasTarget(Yesno.Yes)&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target))&&checkClass(Targetself.Target, "Dasher")) {
                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)&&isOnGround(Yesno.Yes, Targetself.Self)) {
                    setBool("GoUp", Flagtoggle.Yes);
                }
            } else {
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    setBool("GoUp", Flagtoggle.Yes);
                }
            }
        }
        if (((checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Brute", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.1D, Yesno.Yes))&&hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteStamp"))&&isOnGround(Yesno.Yes, Targetself.Self)) {
            setBool("GoUp", Flagtoggle.Yes);
        }
        // Jumping management. The higher the counter gets, the more intense the movement handler makes jumping
        if (getBoolEquals("GoUp", Yesno.Yes)) {
            adjustCounter("sinceLastJump", "0", Valueadjust.Set);
            adjustCounter("timesJumped", "1", Valueadjust.Add);
        } else {
            adjustCounter("sinceLastJump", "1", Valueadjust.Add);
            // Has it been 1 seconds since last jump?
            if (checkCounter("sinceLastJump", "10", Valuecompare.GreaterOrEqual)) {
                adjustCounter("timesJumped", "0", Valueadjust.Set);
            }
        }
        // Hijack movement to prevent getting stuck
        if (getBoolEquals("moveOverride", Yesno.Yes)) {
            setBool("GoForward", Flagtoggle.Yes);
            setBool("GoBack", Flagtoggle.No);
            setBool("GoUp", Flagtoggle.No);
            setBool("GoDown", Flagtoggle.No);
            enableUpgrade(Yesno.No, "JetterJet");
        }
        // Disable jetpack if stuck
        if (getBoolEquals("dontFly", Yesno.Yes)) {
            if (isOnGround(Yesno.No, Targetself.Self)) {
                setBool("GoUp", Flagtoggle.No);
                setBool("GoDown", Flagtoggle.No);
                enableUpgrade(Yesno.No, "JetterJet");
            } else {
                setBool("dontFly", Flagtoggle.No);
                log("Stuck fix disabled", "", "");
            }
        }
        // Handle Movement
        if (getBoolEquals("CantMove", Yesno.No)) {
            setBool("HasMoved", Flagtoggle.No);
            if (getBoolEquals("GoBack", Yesno.Yes)) {
                setBool("GoBack", Flagtoggle.No);
                if (getBoolEquals("WaypointMovement", Yesno.No)||timer(Timeunits.Seconds, 0.25D, Yesno.No)) {
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
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                    if (random("3")) {
                                        setBool("DownJump", Flagtoggle.Yes);
                                    } else {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                // check walls
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("GoDown", Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.Yes, "JetterJet")) {
                    enableUpgrade(Yesno.No, "JetterJet");
                    sequence2();
                } else {
                    // downjump
                    pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                }
                setBool("GoDown", Flagtoggle.No);
            } else {
                if (getBoolEquals("GoUp", Yesno.Yes)) {
                    if (isInNamedArea("NODOUBLEJUMP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("NODOUBLEJUMP", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                        pressStick(Directions.UP, 0.5D);
                    } else {
                        // Jump
                        if (checkCounter("timesJumped", "1", Valuecompare.Equal)) {
                            pressStick(Directions.UP, 1.0D);
                        }
                        // Big Jump
                        if (checkCounter("timesJumped", "2", Valuecompare.Equal)) {
                            pressStick(Directions.UP, 2.0D);
                        }
                        // Mega Jump
                        if (checkCounter("timesJumped", "2", Valuecompare.Equal)) {
                            pressStick(Directions.UP, 3.0D);
                        }
                        // Moon Jump
                        if (checkCounter("timesJumped", "3", Valuecompare.GreaterOrEqual)) {
                            pressStick(Directions.UP, 4.0D);
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "JetterJet")) {
                        enableUpgrade(Yesno.Yes, "JetterJet");
                        pressButton(Buttons.FACE_BOTTOM, 0.1D);
                    }
                    setBool("GoUp", Flagtoggle.No);
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("bubbleHealAlly", Flagtoggle.Yes);
        wait(2.5D);
        pressButton(Buttons.FACE_TOP, 1.0D);
        wait(2.5D);
        setBool("bubbleHealAlly", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("moveOverride", Flagtoggle.Yes);
        log("Stuck fix enabled", "", "");
        wait(2.0D);
        setBool("moveOverride", Flagtoggle.No);
        log("Stuck fix disabled", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.5D);
        // downjump
        pressButton(Buttons.SHOULDER_LEFT, 0.5D);
    }

}

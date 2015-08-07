
package com.awesomescript;

import java.util.EnumSet;

public class AIBotSpy
    extends Script
{


    public void onTick() {
        if (getBoolEquals("VeankoInit", Yesno.No)) {
            setBool("Spy", Flagtoggle.Yes);
        }
        executeBehaviourTree("Spy");
        executeBehaviourTree("VeankoAI");
        if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain")&&getBoolEquals("IgnoreAnchor", Yesno.No))&&hasUpgrade("Captain", Teamswithnumbers.ENEMY_TEAM, "CaptainDrop"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.Yes);
        }
        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)&&getBoolEquals("CanUseSkills", Yesno.Yes)) {
            // Charged?
            if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbShootOn")) {
                if (getBoolEquals("RetreatingFromNauts", Yesno.Yes)&&checkClass(Targetself.Target, "Spy")) {
                } else {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))&&isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No, Yesno.Yes)) {
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)||getBoolEquals("UseRetreatingSkills", Yesno.Yes))||checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            sequence0();
                        }
                    }
                }
            } else {
                if ((((getBoolEquals("RetreatingFromNauts", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                } else {
                    if (hasTarget(Yesno.Yes)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        // chase em
                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("UseRetreatingSkills", Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.01D);
                }
                // Charge to prevent getting killed by Spike Dive
                if (getBoolEquals("spikediveDeath", Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.01D);
                }
                // Projectile coming towards me?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                    if (checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                    } else {
                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                    }
                }
                // im on fire?
                if (isInNamedArea("HAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                }
                if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")&&hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                }
                if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")&&hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodthirstOn"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 25.0D, "", 0.0D, 0.0D, 0.7D, 0.9D, Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                }
                if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")&&getBoolEquals("IgnoreSnipe", Yesno.No))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterPressSnipe")||hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                        pressButton(Buttons.FACE_RIGHT, 0.01D);
                    }
                }
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)||isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.01D);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBooth")&&getBoolEquals("CanUseSkills", Yesno.Yes)) {
            // have i placed the bacon?
            if (isUpgradeEnabled(Yesno.Yes, "SpyBoothIsPlaced")) {
                // check every 20 ticks to see if i want to teleport
                if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                    // not a noob
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        if (getBoolEquals("RetreatingFromNauts", Yesno.Yes)&&checkClass(Targetself.Target, "Spy")) {
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)||isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.Yes)) {
                                if (checkCounter("decoyDmg", "400", Valuecompare.Equal)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 400.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        // 4: bacon bomb
                                        adjustCounter("Bacon", "4", Valueadjust.Set);
                                    }
                                } else {
                                    if (checkCounter("decoyDmg", "200", Valuecompare.Equal)) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            // 4: bacon bomb
                                            adjustCounter("Bacon", "4", Valueadjust.Set);
                                        }
                                    }
                                }
                                // Nearby bacon?
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSpyBooth", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                                    if (checkCounter("decoyDmg", "0", Valuecompare.Greater)||isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
                                        // 4: bacon bomb
                                        adjustCounter("Bacon", "4", Valueadjust.Set);
                                    }
                                }
                            }
                        }
                    }
                    // 0: bacon unknown(or at enemy base)
                    if (checkCounter("Bacon", "0", Valuecompare.Equal)) {
                        if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                        } else {
                            if (checkCounter("state", "3", Valuecompare.Equal)) {
                                // eat yummy bacon
                                pressButton(Buttons.FACE_TOP, 0.0D);
                            }
                        }
                        if (((isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HEALAREACLOSE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (checkCounter("state", "10", Valuecompare.Equal)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSpyBooth", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes)) {
                                // 1: bacon at base
                                adjustCounter("Bacon", "1", Valueadjust.Set);
                            }
                        }
                    } else {
                        // 1: bacon at base
                        if (checkCounter("Bacon", "1", Valuecompare.Equal)) {
                            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HEALAREACLOSE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            } else {
                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||receivedPing(Ping.BASE_UNDER_ATTACK))||receivedPing(Ping.BASE_ALMOST_DESTROYED)) {
                                    // eat yummy bacon
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            }
                        } else {
                            // 2: bacon in jungle
                            if (checkCounter("Bacon", "2", Valuecompare.Equal)) {
                                if ((isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    if (checkCounter("state", "3", Valuecompare.Equal)) {
                                        // eat yummy bacon
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                } else {
                                    // want to go to jungle
                                    if (checkCounter("state", "5", Valuecompare.Equal)) {
                                        if (isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("JUNGLE", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        } else {
                                            // eat yummy bacon
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                    if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                            // eat yummy bacon
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                }
                            } else {
                                // 3: bacon in lane
                                if (checkCounter("Bacon", "3", Valuecompare.Equal)) {
                                    if ((isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                        if (checkCounter("state", "3", Valuecompare.Equal)) {
                                            // eat yummy bacon
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    } else {
                                        if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                            if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                // eat yummy bacon
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    }
                                } else {
                                    // 4: bacon bomb
                                    if (checkCounter("Bacon", "4", Valuecompare.Equal)) {
                                        // Nearby bacon?
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSpyBooth", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                                            // eat yummy bacon
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        } else {
                                            // 0: bacon unknown (or at enemy base)
                                            adjustCounter("Bacon", "0", Valueadjust.Set);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                // at base
                if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    // randon chance to place bacon
                    if (random("200")) {
                        // yummy bacon
                        pressButton(Buttons.FACE_TOP, 0.0D);
                        // 1: bacon at base
                        adjustCounter("Bacon", "1", Valueadjust.Set);
                    }
                } else {
                    if (((((isInNamedArea("HIDE_AREA_TOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HIDE_AREA_TOP_BELOW", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM_ABOVE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_SIDE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_CENTRE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (random("10")) {
                            // yummy bacon
                            pressButton(Buttons.FACE_TOP, 0.0D);
                            // 2: bacon in jungle
                            adjustCounter("Bacon", "2", Valueadjust.Set);
                        }
                    } else {
                        if (isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("JUNGLE", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                            if (random("30")) {
                                // yummy bacon
                                pressButton(Buttons.FACE_TOP, 0.0D);
                                // 2: bacon in jungle
                                adjustCounter("Bacon", "2", Valueadjust.Set);
                            }
                        }
                        // in a lane
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.8D, 0.5D, Yesno.Yes)) {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.4D, 0.5D, Yesno.Yes)) {
                            } else {
                                if (random("60")) {
                                    // yummy bacon
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                    // 3: bacon in lane
                                    adjustCounter("Bacon", "3", Valueadjust.Set);
                                }
                            }
                        }
                        // at enemy base
                        if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                            // yummy bacon
                            pressButton(Buttons.FACE_TOP, 0.0D);
                            // 0: bacon unknown(or at enemy base)
                            adjustCounter("Bacon", "0", Valueadjust.Set);
                        }
                    }
                }
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)||isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.Yes)) {
                    // not a noob
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        if (getBoolEquals("RetreatingFromNauts", Yesno.Yes)&&checkClass(Targetself.Target, "Spy")) {
                        } else {
                            if (checkCounter("decoyDmg", "0", Valuecompare.Greater)||isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
                                if (getBoolEquals("DetectedStealth", Yesno.Yes)) {
                                    // yummy bacon
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                    // 4: bacon bomb
                                    adjustCounter("Bacon", "4", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)&&getBoolEquals("RetreatingFromNauts", Yesno.No)) {
            if (getBoolEquals("RetreatingFromNauts", Yesno.Yes)&&checkClass(Targetself.Target, "Spy")) {
            } else {
                if ((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                } else {
                    // Don't decloak myself
                    if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                        executeBehaviourTree("SpyMinesLogic");
                    } else {
                        // Don't ruin surprise BHS
                        if (isUpgradeEnabled(Yesno.No, "SpyAbsorbShootOn")) {
                            // Don't ruin surprise teleburst
                            if (checkCounter("Bacon", "4", Valuecompare.Equal)) {
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)||isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                    executeBehaviourTree("SpyMinesLogic");
                                }
                            }
                        }
                    }
                }
            }
        }
        if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
            setBool("MoveTowardsTarget", Flagtoggle.Yes);
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        // Extra Solar at drop
        if (once()) {
            adjustCharacterValue(CharactervaluesAdjustable.Gold, 40.0D, Valueadjust.Add);
        }
        // Shopping
        if (getBoolEquals("canBuyItems", Yesno.Yes)) {
            executeBehaviourTree("SpyShop");
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
        executeBehaviourTree("AwesomebotsCommonLib");
        // Keep my distance when my target is not unhealthy
        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Greater, Targetself.Target)) {
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.68D, 0.68D, Yesno.Yes, Yesno.No)) {
                setBool("moveTowardsTarget", Flagtoggle.No);
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.28D, 0.28D, Yesno.Yes, Yesno.No)) {
                    setBool("moveAwayFromTarget", Flagtoggle.Yes);
                    setBool("retreatingFromNauts", Flagtoggle.Yes);
                }
            }
        }
        // Move Away From Target
        if (getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (directionToEnemyBase(Forwardbackward.BACKWARD)||isInNamedArea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
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
                    if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        setBool("GoForward", Flagtoggle.Yes);
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
                setBool("MoveTowardsTarget", Flagtoggle.No);
            }
        }
        if ((isInNamedArea("hideAreaTop", Ownenemy.OWN_TEAM, Targetself.Self)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.5D, 0.0D, 0.1D, 0.5D, Yesno.No, Yesno.No))&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.01D, 0.2D, Yesno.Yes, Yesno.No)) {
            setBool("DownJump", Flagtoggle.Yes);
            setBool("jump", Flagtoggle.No);
            setBool("GoUp", Flagtoggle.No);
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
                    if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                        } else {
                            pressButton(Buttons.FACE_BOTTOM, 0.1D);
                        }
                    }
                }
            }
        } else {
            setBool("DownJump", Flagtoggle.No);
            if (isInNamedArea("ABOVEHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                // downjump
                pressButton(Buttons.SHOULDER_LEFT, 0.1D);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressButton(Buttons.FACE_RIGHT, 0.01D);
        wait(0.3D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence1();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence2();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence3();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence4();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence5();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence6();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.7D, 0.7D, Yesno.No, Yesno.Yes)) {
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        }
    }

}

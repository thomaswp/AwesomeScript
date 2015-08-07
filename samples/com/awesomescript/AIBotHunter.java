
package com.awesomescript;

import java.util.EnumSet;

public class AIBotHunter
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Hunter");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // shoot
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (hasTarget(Yesno.Yes)) {
                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                } else {
                    if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                        if (isUpgradeEnabled(Yesno.No, "HunterSprint")) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // attack
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "HunterSprint")) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.No)) {
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                } else {
                    if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.No)) {
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
            // back away from people who are too close
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.45D, 0.45D, Yesno.No)) {
                setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                setBool("RetreatingFromNauts", Flagtoggle.Yes);
            }
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                    setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                    setBool("RetreatingFromNauts", Flagtoggle.Yes);
                }
            }
        }
        // Time Rift!
        if (isUpgradeEnabled(Yesno.Yes, "HunterWall")) {
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))||isUpgradeEnabled(Yesno.Yes, "HunterWallDroid")) {
                            if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            } else {
                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    if (isUpgradeEnabled(Yesno.No, "HunterSprint")) {
                                        // slow them down
                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.5D, Yesno.Yes, Yesno.No)) {
                                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        }
                                    }
                                } else {
                                    // target close
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.5D, Yesno.Yes, Yesno.No)) {
                                        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                    } else {
                                        // target somewhat close
                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.5D, Yesno.Yes, Yesno.No)) {
                                            aimStickAtTarget(0.22D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.22D);
                                        } else {
                                            // target far
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.5D, Yesno.Yes, Yesno.No)) {
                                                aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.4D);
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
        // Snipe!
        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipe")) {
            if (isUpgradeEnabled(Yesno.No, "HunterSnipeReady")) {
                if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    // Not near turret
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.5D, 1.0D, Yesno.Yes)) {
                    } else {
                        // Not blinded
                        if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.No, Targetself.Self)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                } else {
                                    if (((getBoolEquals("RetreatingFromNauts", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                            if (getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeCash")) {
                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes, Yesno.No)) {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange1")||isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange2")) {
                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes, Yesno.No)) {
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        } else {
                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes, Yesno.No)) {
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeCash")) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes, Yesno.No)) {
                                                if (getBoolEquals("LowerHealth", Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.No)) {
                                                    if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)||isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes))||isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.Yes, Yesno.No)) {
                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                    } else {
                                                        setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                                        setBool("RetreatingFromNauts", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    if (checkCounter("state", "11", Valuecompare.Equal)) {
                                                        if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        }
                                                    } else {
                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange1")||isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange2")) {
                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes, Yesno.No)) {
                                                    if (getBoolEquals("LowerHealth", Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.No)) {
                                                        if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)||isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes))||isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.Yes, Yesno.No)) {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        } else {
                                                            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                                            setBool("RetreatingFromNauts", Flagtoggle.Yes);
                                                        }
                                                    } else {
                                                        if (checkCounter("state", "11", Valuecompare.Equal)) {
                                                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        } else {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes, Yesno.No)) {
                                                    if (getBoolEquals("LowerHealth", Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.No)) {
                                                        if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)||isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes))||isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.4D, 1.4D, Yesno.Yes, Yesno.No)) {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        } else {
                                                            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                                                            setBool("RetreatingFromNauts", Flagtoggle.Yes);
                                                        }
                                                    } else {
                                                        if (checkCounter("state", "11", Valuecompare.Equal)) {
                                                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        } else {
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
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
                adjustCounter("TimeSpentInSnipe", "0", Valueadjust.Set);
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (timer(Timeunits.Seconds, 0.1D, Yesno.No)) {
                        adjustCounter("TimeSpentInSnipe", "1", Valueadjust.Add);
                    }
                } else {
                    adjustCounter("TimeSpentInSnipe", "0", Valueadjust.Set);
                }
                setBool("CantMove", Flagtoggle.Yes);
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                    pressStick(Directions.FORWARD, 0.1D);
                } else {
                    if (hasTarget(Yesno.Yes)) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                            aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 20.0D, 25.0D, 20.0D, 25.0D);
                        } else {
                            // Sentry
                            if (checkClass(Targetself.Target, "Spy")) {
                                // is sentry chargeing?
                                if (hasUpgrade("Sentry", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                                } else {
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            } else {
                                pressButton(Buttons.FACE_TOP, 0.0D);
                            }
                            if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)||isTargetInArea(Yesno.No, 0.0D, 0.0D, 1.9D, 1.9D, Yesno.No, Yesno.Yes)) {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                    aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 30.0D, 40.0D, 30.0D, 40.0D);
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.7D, Valuecompare.Less, Targetself.Self)) {
                                        aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 50.0D, 60.0D, 50.0D, 60.0D);
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.9D, Valuecompare.Less, Targetself.Self)) {
                                            aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 70.0D, 80.0D, 70.0D, 80.0D);
                                        } else {
                                            aimStickAtTarget(0.8D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        }
                                    }
                                }
                            } else {
                                if (checkCounter("TimeSpentInSnipe", "1", Valuecompare.LessOrEqual)) {
                                    aimStickAtTarget(0.8D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                        aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 30.0D, 40.0D, 30.0D, 40.0D);
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.7D, Valuecompare.Less, Targetself.Self)) {
                                            aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 50.0D, 60.0D, 50.0D, 60.0D);
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.9D, Valuecompare.Less, Targetself.Self)) {
                                                aimStickAtTarget(0.8D, Yesno.No, Yesno.Yes, 70.0D, 80.0D, 70.0D, 80.0D);
                                            } else {
                                                aimStickAtTarget(0.8D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeCash")) {
                        // below 45 health player
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 450.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 450.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        } else {
                            // below 55 health player
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 550.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 550.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            } else {
                                // below 65 health player
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 650.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 650.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                } else {
                                    // below 75 health player
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 750.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 750.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    } else {
                                        // below 90 health player
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 900.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 900.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        } else {
                                            // target players
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            } else {
                                                // no players around: targer creeps
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange1")||isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange2")) {
                            // below 45 health player
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 450.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .LessOrEqual, 450.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            } else {
                                // below 55 health player
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 550.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .LessOrEqual, 550.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                } else {
                                    // below 65 health player
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 650.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .LessOrEqual, 650.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    } else {
                                        // below 75 health player
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 750.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .LessOrEqual, 750.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        } else {
                                            // below 90 health player
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 900.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .LessOrEqual, 900.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            } else {
                                                // target players
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.9D, 1.9D, Yesno.Yes)) {
                                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                } else {
                                                    // no players around: targer creeps
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.1D, 2.1D, Yesno.Yes)) {
                                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.1D, 2.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                    } else {
                                                        // Target far away players if i have second upgrade
                                                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange2")) {
                                                            // target players
                                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.5D, 2.5D, Yesno.Yes)) {
                                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.5D, 2.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
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
                            // below 45 health player
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 450.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 450.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            } else {
                                // below 55 health player
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 550.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 550.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                } else {
                                    // below 65 health player
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 650.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 650.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    } else {
                                        // below 75 health player
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 750.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 750.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        } else {
                                            // below 90 health player
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 900.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .LessOrEqual, 900.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            } else {
                                                // target players
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                } else {
                                                    // no players around: targer creeps
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.7D, 1.7D, Yesno.Yes)) {
                                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.7D, 1.7D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
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
            if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage3")&&isUpgradeEnabled(Yesno.No, "HunterSnipeCash")) {
                if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                    // target can be one shotted
                    setBool("TargetInKillRange", Flagtoggle.Yes);
                } else {
                    setBool("TargetInKillRange", Flagtoggle.No);
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage3")) {
                    if (checkCharacterValue(CharactervaluesCheckable.Health, 750.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                        // target can be one shotted
                        setBool("TargetInKillRange", Flagtoggle.Yes);
                    } else {
                        setBool("TargetInKillRange", Flagtoggle.No);
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage2")) {
                        if (checkCharacterValue(CharactervaluesCheckable.Health, 650.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            // target can be one shotted
                            setBool("TargetInKillRange", Flagtoggle.Yes);
                        } else {
                            setBool("TargetInKillRange", Flagtoggle.No);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage1")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 550.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                // target can be one shotted
                                setBool("TargetInKillRange", Flagtoggle.Yes);
                            } else {
                                setBool("TargetInKillRange", Flagtoggle.No);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 450.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                // target can be one shotted
                                setBool("TargetInKillRange", Flagtoggle.Yes);
                            } else {
                                setBool("TargetInKillRange", Flagtoggle.No);
                            }
                        }
                    }
                }
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "HunterSnipe")) {
                    if (canPayUpgrade("HunterSnipe")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                        }
                        buyUpgrade("HunterSnipe");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HUNTERWALL")) {
                    if (canPayUpgrade("HUNTERWALL")) {
                        buyUpgrade("HUNTERWALL");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    // is there a voltair on my team?
                    if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "Summoner")) {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                            if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                                if (canPayUpgrade("Piggybank")) {
                                    buyUpgrade("Piggybank");
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                            // buy regen early if gnaw is on the enemy team
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                                if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                                    if (canPayUpgrade("healthRegen1")) {
                                        buyUpgrade("healthRegen1");
                                    }
                                }
                                if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                                    if (canPayUpgrade("healthRegen2")) {
                                        buyUpgrade("healthRegen2");
                                    }
                                }
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "HunterSpeed")) {
                        if (canPayUpgrade("HunterSpeed")) {
                            buyUpgrade("HunterSpeed");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HunterSnipeDamage1")) {
                    if (canPayUpgrade("HunterSnipeDamage1")) {
                        buyUpgrade("HunterSnipeDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HUNTERSNIPEDAMAGE2")) {
                    if (canPayUpgrade("HUNTERSNIPEDAMAGE2")) {
                        buyUpgrade("HUNTERSNIPEDAMAGE2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HunterSnipeDamage3")) {
                    if (canPayUpgrade("HunterSnipeDamage3")) {
                        buyUpgrade("HunterSnipeDamage3");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    if ((((((((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Chameleon"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Assassin"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterSnipeCash")) {
                            if (isUpgradeEnabled(Yesno.No, "HunterSnipeFaster1")) {
                                if (isUpgradeEnabled(Yesno.No, "HunterSnipeDebuffImmune")) {
                                    if (canPayUpgrade("HunterSnipeDebuffImmune")) {
                                        buyUpgrade("HunterSnipeDebuffImmune");
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "HunterSnipeDebuffImmune")) {
                            if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeRange2")) {
                                if (isUpgradeEnabled(Yesno.No, "HunterSnipeFaster1")) {
                                    if (isUpgradeEnabled(Yesno.No, "HunterSnipeCash")) {
                                        if (canPayUpgrade("HunterSnipeCash")) {
                                            buyUpgrade("HunterSnipeCash");
                                        }
                                        // random chance to buy cooldown if i cant afford flashy
                                        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage3")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Gold, 230.0D, Valuecompare.Less, Targetself.Self)) {
                                                if (random("50")) {
                                                    if (canPayUpgrade("HunterSnipeFaster1")) {
                                                        buyUpgrade("HunterSnipeFaster1");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeFaster1")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterSnipeFaster2")) {
                            if (canPayUpgrade("HunterSnipeFaster2")) {
                                buyUpgrade("HunterSnipeFaster2");
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterSnipeRange1")) {
                        if (canPayUpgrade("HunterSnipeRange1")) {
                            buyUpgrade("HunterSnipeRange1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeDamage1")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterSnipeRange2")) {
                            if (canPayUpgrade("HunterSnipeRange2")) {
                                buyUpgrade("HunterSnipeRange2");
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "HunterSnipeFaster1")) {
                        if (canPayUpgrade("HunterSnipeFaster1")) {
                            buyUpgrade("HunterSnipeFaster1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterSnipeFaster2")) {
                        if (canPayUpgrade("HunterSnipeFaster2")) {
                            buyUpgrade("HunterSnipeFaster2");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HunterWallDamage1")) {
                    if (canPayUpgrade("HunterWallDamage1")) {
                        buyUpgrade("HunterWallDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "HunterWallDamage2")) {
                    if (canPayUpgrade("HunterWallDamage2")) {
                        buyUpgrade("HunterWallDamage2");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.Yes, "HUNTERSNIPEDAMAGE2")) {
                        if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                            if (canPayUpgrade("addHealth1")) {
                                buyUpgrade("addHealth1");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "HUNTERSNIPEDAMAGE2")&&isUpgradeEnabled(Yesno.Yes, "HunterSpeed")) {
                    if ((((((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Bird"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Shaman"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Cowboy"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterWallDuration")) {
                            if (isUpgradeEnabled(Yesno.No, "HunterWallHeight1")) {
                                if (canPayUpgrade("HunterWallHeight1")) {
                                    buyUpgrade("HunterWallHeight1");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "HunterWallHeight2")) {
                                    if (canPayUpgrade("HunterWallHeight2")) {
                                        buyUpgrade("HunterWallHeight2");
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "HunterWallHeight1")) {
                            if (isUpgradeEnabled(Yesno.No, "HunterWallDuration")) {
                                if (canPayUpgrade("HunterWallDuration")) {
                                    buyUpgrade("HunterWallDuration");
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterShotDamage4")) {
                        if (canPayUpgrade("HunterShotDamage4")) {
                            buyUpgrade("HunterShotDamage4");
                        }
                    }
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                        if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                            if (canPayUpgrade("addHealth2")) {
                                buyUpgrade("addHealth2");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                            if (canPayUpgrade("addHealth3")) {
                                buyUpgrade("addHealth3");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                            if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                                if (canPayUpgrade("healthRegen1")) {
                                    buyUpgrade("healthRegen1");
                                }
                            }
                            if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                                if (canPayUpgrade("healthRegen2")) {
                                    buyUpgrade("healthRegen2");
                                }
                            }
                        }
                    }
                    if (random("4")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterWallSlow1")) {
                            if (isUpgradeEnabled(Yesno.No, "HunterWallDroid")) {
                                if (canPayUpgrade("HunterWallDroid")) {
                                    buyUpgrade("HunterWallDroid");
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "HunterWallDroid")) {
                            if (isUpgradeEnabled(Yesno.No, "HunterWallSlow1")) {
                                if (canPayUpgrade("HunterWallSlow1")) {
                                    buyUpgrade("HunterWallSlow1");
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "HunterWallSlow1")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterWallSlow2")) {
                            if (canPayUpgrade("HunterWallSlow2")) {
                                buyUpgrade("HunterWallSlow2");
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterShotDamage1")) {
                        if (canPayUpgrade("HunterShotDamage1")) {
                            buyUpgrade("HunterShotDamage1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterShotDamage2")) {
                        if (canPayUpgrade("HunterShotDamage2")) {
                            buyUpgrade("HunterShotDamage2");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterShotDamage3")) {
                        if (canPayUpgrade("HunterShotDamage3")) {
                            buyUpgrade("HunterShotDamage3");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "HunterShotDamage3")&&isUpgradeEnabled(Yesno.No, "HunterShotDamage4")) {
                        if (isUpgradeEnabled(Yesno.No, "HunterShotFaster1")) {
                            if (canPayUpgrade("HunterShotFaster1")) {
                                buyUpgrade("HunterShotFaster1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "HunterShotFaster2")) {
                            if (canPayUpgrade("HunterShotFaster2")) {
                                buyUpgrade("HunterShotFaster2");
                            }
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
                if (getBoolEquals("GoForward", Yesno.Yes)) {
                    pressStick(Directions.FORWARD, 0.1D);
                    setBool("HasMoved", Flagtoggle.Yes);
                    setBool("GoForward", Flagtoggle.No);
                } else {
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

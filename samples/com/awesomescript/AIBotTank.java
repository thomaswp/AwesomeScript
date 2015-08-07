
package com.awesomescript;

import java.util.EnumSet;

public class AIBotTank
    extends Script
{


    public void onTick() {
        if (getBoolEquals("VeankoInit", Yesno.No)) {
            setBool("Tank", Flagtoggle.Yes);
        }
        executeBehaviourTree("Tank");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // Rockets!
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
            } else {
                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                } else {
                    if (hasTarget(Yesno.Yes)) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.75D, 0.75D, Yesno.Yes, Yesno.Yes)) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.45D, 0.2D, Yesno.Yes, Yesno.No)) {
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            }
        }
        // Bite!
        if (isUpgradeEnabled(Yesno.Yes, "LifeSteal")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                    } else {
                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.2D, Yesno.Yes)) {
                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.4D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // Bite them!
                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)||isUpgradeEnabled(Yesno.Yes, "TankBiteMaxHP1")) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.2D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.4D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    // Bite them!
                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                } else {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 0.2D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    }
                                }
                            }
                        }
                    }
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // Bite them!
                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                            }
                        }
                    } else {
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)||isUpgradeEnabled(Yesno.Yes, "TankBiteMaxHP1")) {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                    aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    // Bite them!
                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                } else {
                                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    } else {
                                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Explode!
        if (isUpgradeEnabled(Yesno.Yes, "suicide")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    } else {
                        // use explode really badly if dumb
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.25D, 0.25D, Yesno.Yes, Yesno.No)) {
                                // blow em up
                                pressButton(Buttons.FACE_TOP, 0.1D);
                            }
                        } else {
                            if (getBoolEquals("DontSuicide", Yesno.No)) {
                                if (getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                    if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                            // blow em up
                                            pressButton(Buttons.FACE_TOP, 0.1D);
                                        }
                                    } else {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                            // blow em up
                                            pressButton(Buttons.FACE_TOP, 0.1D);
                                        }
                                    }
                                } else {
                                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    } else {
                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                if (((((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Blinker", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target)) {
                                                    // blow em up
                                                    pressButton(Buttons.FACE_TOP, 0.1D);
                                                } else {
                                                    // check again
                                                    if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                            // blow em up
                                                            pressButton(Buttons.FACE_TOP, 0.1D);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                if (((((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Blinker", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes))||checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target)) {
                                                    // blow em up
                                                    pressButton(Buttons.FACE_TOP, 0.1D);
                                                } else {
                                                    // check again
                                                    if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                            // blow em up
                                                            pressButton(Buttons.FACE_TOP, 0.1D);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 80.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                        // players are more important
                                        if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                // blow em up
                                                pressButton(Buttons.FACE_TOP, 0.1D);
                                            }
                                        }
                                    } else {
                                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)) {
                                                // players are more important
                                                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                                    // blow em up
                                                    pressButton(Buttons.FACE_TOP, 0.1D);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                // Losing health fast?
                                if (checkCounter("ten", "prevHealth-health", Valuecompare.LessOrEqual)) {
                                    if (getBoolEquals("TargetInKillRange", Yesno.Yes)||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                // blow em up
                                                pressButton(Buttons.FACE_TOP, 0.1D);
                                            }
                                        } else {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                // blow em up
                                                pressButton(Buttons.FACE_TOP, 0.1D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // am i exploding
            if (isUpgradeEnabled(Yesno.Yes, "TankExploding")) {
                // dont follow target if dumb
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    // Am i going to die?
                    if (getBoolEquals("DontSuicide", Yesno.Yes)) {
                        if (hasTarget(Yesno.Yes)) {
                            adjustCounter("state", "4", Valueadjust.Set);
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            } else {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                    } else {
                                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    }
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            }
                        }
                    } else {
                        if (hasTarget(Yesno.Yes)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.Yes)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    if (getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    } else {
                                        if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                        } else {
                                            setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        }
                                    }
                                } else {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                        } else {
                                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                            } else {
                                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            }
                        }
                    }
                }
            }
        }
        // check damage of explode
        if (isUpgradeEnabled(Yesno.Yes, "TankExplodeDamage2")) {
            // will explode kill my target?
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 1000.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                // Explode will kill my target
                setBool("TargetInKillRange", Flagtoggle.Yes);
            } else {
                setBool("TargetInKillRange", Flagtoggle.No);
            }
            // will explode kill me?
            if (checkCharacterValue(CharactervaluesCheckable.Health, 500.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                // explode will kill me
                setBool("DontSuicide", Flagtoggle.Yes);
            } else {
                // safe to explode
                setBool("DontSuicide", Flagtoggle.No);
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "TankExplodeDamage1")) {
                // will explode kill my target?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 750.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                    // Explode will kill my target
                    setBool("TargetInKillRange", Flagtoggle.Yes);
                } else {
                    setBool("TargetInKillRange", Flagtoggle.No);
                }
                // will explode kill me?
                if (checkCharacterValue(CharactervaluesCheckable.Health, 400.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // explode will kill me
                    setBool("DontSuicide", Flagtoggle.Yes);
                } else {
                    // safe to explode
                    setBool("DontSuicide", Flagtoggle.No);
                }
            } else {
                // will explode kill my target?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.LessOrEqual, 500.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                    // Explode will kill my target
                    setBool("TargetInKillRange", Flagtoggle.Yes);
                } else {
                    setBool("TargetInKillRange", Flagtoggle.No);
                }
                // will explode kill me?
                if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // explode will kill me
                    setBool("DontSuicide", Flagtoggle.Yes);
                } else {
                    // safe to explode
                    setBool("DontSuicide", Flagtoggle.No);
                }
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                // if enemy has CC heavy nauts: buy BKM
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    // Dont buy BKM if there is a gnaw
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                    } else {
                        if (once()) {
                            // Froggy G
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                                if (random("4")) {
                                    // Enemy has CC: Buy BKM
                                    setBool("BuyBKM", Flagtoggle.Yes);
                                }
                            }
                            // Derpl
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                                if (random("3")) {
                                    // Enemy has CC: Buy BKM
                                    setBool("BuyBKM", Flagtoggle.Yes);
                                }
                            }
                            // Scoop
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Paladin")) {
                                if (random("4")) {
                                    // Enemy has CC: Buy BKM
                                    setBool("BuyBKM", Flagtoggle.Yes);
                                }
                            }
                            // Skolldir
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")) {
                                if (random("4")) {
                                    // Enemy has CC: Buy BKM
                                    setBool("BuyBKM", Flagtoggle.Yes);
                                }
                            }
                            // Clunk
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                                // Screamer engine
                                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankBiteSnare")) {
                                    if (random("3")) {
                                        // Enemy has CC: Buy BKM
                                        setBool("BuyBKM", Flagtoggle.Yes);
                                    }
                                }
                            }
                            // Lilac
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker")) {
                                // Chilas Wax Candle
                                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "BlinkerHitSun1")) {
                                    if (random("3")) {
                                        // Enemy has CC: Buy BKM
                                        setBool("BuyBKM", Flagtoggle.Yes);
                                    }
                                }
                            }
                            // Voltar
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")) {
                                // this prevents the logic from activating, i want to leave the logic here just in case BKM is updated to affect knockback
                                if (getBoolEquals("null", Yesno.Yes)) {
                                    if (hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerShotKnockback")||hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerHealtotemKnockback")) {
                                        if (random("3")) {
                                            // Enemy has CC: Buy BKM
                                            setBool("BuyBKM", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                            // Vinne & Spike
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Bird")) {
                                // Red bandana
                                if (hasUpgrade("Bird", Teamswithnumbers.ENEMY_TEAM, "BirdSmokeSilence")) {
                                    if (random("12")) {
                                        // Enemy has CC: Buy BKM
                                        setBool("BuyBKM", Flagtoggle.Yes);
                                    }
                                }
                            }
                            // Ted
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Commando")) {
                                // this prevents the logic from activating, i want to leave the logic here just in case BKM is updated to affect knockback
                                if (getBoolEquals("null", Yesno.Yes)) {
                                    // Ted's power briefs
                                    if (hasUpgrade("Commando", Teamswithnumbers.ENEMY_TEAM, "CommandoShotKnockback1")) {
                                        if (random("3")) {
                                            // Enemy has CC: Buy BKM
                                            setBool("BuyBKM", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.Yes, "healthRegen1")||isUpgradeEnabled(Yesno.Yes, "Piggybank")) {
                                setBool("BuyBKM", Flagtoggle.No);
                            }
                        }
                    }
                }
            }
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "LifeSteal")) {
                    if (canPayUpgrade("LifeSteal")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                        }
                        buyUpgrade("LifeSteal");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "suicide")) {
                    if (canPayUpgrade("suicide")) {
                        buyUpgrade("suicide");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "TankSpeed")) {
                        if (canPayUpgrade("TankSpeed")) {
                            buyUpgrade("TankSpeed");
                        }
                    }
                    if (getBoolEquals("BuyBKM", Yesno.No)) {
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
                            if ((((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Shaman")) {
                                if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                                    if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                                        if (canPayUpgrade("healthRegen1")) {
                                            buyUpgrade("healthRegen1");
                                        }
                                    } else {
                                        // buy regen early if gnaw is on the enemy team
                                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                                            if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                                                if (canPayUpgrade("healthRegen2")) {
                                                    buyUpgrade("healthRegen2");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "TankExplodeDamage1")) {
                    if (canPayUpgrade("TankExplodeDamage1")) {
                        buyUpgrade("TankExplodeDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "TankBiteSnare")) {
                    if (canPayUpgrade("TankBiteSnare")) {
                        buyUpgrade("TankBiteSnare");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "TankExplodeDamage2")) {
                    if (canPayUpgrade("TankExplodeDamage2")) {
                        buyUpgrade("TankExplodeDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "TankBiteSnare2")) {
                    if (canPayUpgrade("TankBiteSnare2")) {
                        buyUpgrade("TankBiteSnare2");
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "TankExplodeDamage1")&&isUpgradeEnabled(Yesno.Yes, "TankBiteSnare2")) {
                    if (isUpgradeEnabled(Yesno.No, "TankBiteHeal1")) {
                        if (canPayUpgrade("TankBiteHeal1")) {
                            buyUpgrade("TankBiteHeal1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "TankBiteHeal2")) {
                        if (canPayUpgrade("TankBiteHeal2")) {
                            buyUpgrade("TankBiteHeal2");
                        }
                    }
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                        if (getBoolEquals("BuyBKM", Yesno.No)) {
                            if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                                if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                                    if (canPayUpgrade("healthRegen1")) {
                                        buyUpgrade("healthRegen1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                                        if (canPayUpgrade("healthRegen2")) {
                                            buyUpgrade("healthRegen2");
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "ccReduction")) {
                                if (canPayUpgrade("ccReduction")) {
                                    buyUpgrade("ccReduction");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "ccReduction2")) {
                                    if (canPayUpgrade("ccReduction2")) {
                                        buyUpgrade("ccReduction2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                            if (canPayUpgrade("addHealth1")) {
                                buyUpgrade("addHealth1");
                            }
                        }
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
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "TankExplodeDamage2")) {
                        if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Assassin"))||random("3")) {
                            if (isUpgradeEnabled(Yesno.No, "TankExplodeChargespeed")) {
                                if (isUpgradeEnabled(Yesno.No, "TankExplodeSlow1")) {
                                    if (canPayUpgrade("TankExplodeSlow1")) {
                                        buyUpgrade("TankExplodeSlow1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "TankExplodeSlow2")) {
                                        if (canPayUpgrade("TankExplodeSlow2")) {
                                            buyUpgrade("TankExplodeSlow2");
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "TankExplodeSlow1")) {
                                if (isUpgradeEnabled(Yesno.No, "TankExplodeChargespeed")) {
                                    if (canPayUpgrade("TankExplodeChargespeed")) {
                                        buyUpgrade("TankExplodeChargespeed");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "TankShotSalvo")) {
                            if (canPayUpgrade("TankShotSalvo")) {
                                buyUpgrade("TankShotSalvo");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.Yes, "TankExplodeSlow2")||isUpgradeEnabled(Yesno.Yes, "TankExplodeChargespeed")) {
                            if ((isUpgradeEnabled(Yesno.No, "TankExplodeCooldown")&&isUpgradeEnabled(Yesno.No, "TankExplodeHardhat1"))&&isUpgradeEnabled(Yesno.No, "TankExplodeRevive1")) {
                                if (random("2")) {
                                    if (isUpgradeEnabled(Yesno.No, "TankExplodeCooldown")) {
                                        if (canPayUpgrade("TankExplodeCooldown")) {
                                            buyUpgrade("TankExplodeCooldown");
                                        }
                                    }
                                } else {
                                    if (random("2")) {
                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeHardhat1")) {
                                            if (canPayUpgrade("TankExplodeHardhat1")) {
                                                buyUpgrade("TankExplodeHardhat1");
                                            }
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "TankExplodeRevive1")) {
                                            if (canPayUpgrade("TankExplodeRevive1")) {
                                                buyUpgrade("TankExplodeRevive1");
                                            }
                                        }
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.Yes, "TankExplodeHardhat1")) {
                                if (isUpgradeEnabled(Yesno.No, "TankExplodeHardhat2")) {
                                    if (canPayUpgrade("TankExplodeHardhat2")) {
                                        buyUpgrade("TankExplodeHardhat2");
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.No, "TankBiteMaxHP1")) {
                                if (canPayUpgrade("TankBiteMaxHP1")) {
                                    buyUpgrade("TankBiteMaxHP1");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "TankBiteMaxHP2")) {
                                    if (canPayUpgrade("TankBiteMaxHP2")) {
                                        buyUpgrade("TankBiteMaxHP2");
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.No, "TankShotBarrage2")) {
                                if (canPayUpgrade("TankShotBarrage2")) {
                                    buyUpgrade("TankShotBarrage2");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "TankShotBarrage3")) {
                                    if (canPayUpgrade("TankShotBarrage3")) {
                                        buyUpgrade("TankShotBarrage3");
                                    }
                                }
                            }
                            if (random("2")) {
                                if (isUpgradeEnabled(Yesno.No, "TankShotFatPete")) {
                                    if (isUpgradeEnabled(Yesno.No, "TankShotSpeed")) {
                                        if (canPayUpgrade("TankShotSpeed")) {
                                            buyUpgrade("TankShotSpeed");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "TankShotSpeed2")) {
                                            if (canPayUpgrade("TankShotSpeed2")) {
                                                buyUpgrade("TankShotSpeed2");
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "TankShotSpeed")) {
                                    if (isUpgradeEnabled(Yesno.No, "TankShotFatPete")) {
                                        if (canPayUpgrade("TankShotFatPete")) {
                                            buyUpgrade("TankShotFatPete");
                                        }
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.Yes, "TankShotSpeed")) {
                                if (isUpgradeEnabled(Yesno.No, "TankShotSpeed2")) {
                                    if (canPayUpgrade("TankShotSpeed2")) {
                                        buyUpgrade("TankShotSpeed2");
                                    }
                                }
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
        // did i kill someone?
        if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
            if ((((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No, Yesno.Yes))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.5D, 0.5D, Yesno.No, Yesno.Yes))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.3D, Yesno.No, Yesno.Yes)) {
            } else {
                // 1/4 chance of being true
                if (random("4")) {
                    // Epic Dance Remix!! (54)
                    adjustCounter("setState", "54", Valueadjust.Set);
                }
            }
        }
    }

}

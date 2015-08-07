
package com.awesomescript;

import java.util.EnumSet;

public class SuperFindAndTargetEnemiesShortRange_nailcliper
    extends Script
{


    public void onTick() {
        if (((checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target)||checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target)) {
            setBool("targetHasCC", Flagtoggle.Yes);
        } else {
            setBool("targetHasCC", Flagtoggle.No);
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 99.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 99.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
            setBool("targetHasDot", Flagtoggle.Yes);
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 96.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 96.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                setBool("targetHasDot", Flagtoggle.Yes);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 93.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 93.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                    setBool("targetHasDot", Flagtoggle.Yes);
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 90.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                        setBool("targetHasDot", Flagtoggle.Yes);
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 87.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 87.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                            setBool("targetHasDot", Flagtoggle.Yes);
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 84.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 84.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                setBool("targetHasDot", Flagtoggle.Yes);
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 81.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 81.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                    setBool("targetHasDot", Flagtoggle.Yes);
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 78.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 78.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                        setBool("targetHasDot", Flagtoggle.Yes);
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                            setBool("targetHasDot", Flagtoggle.Yes);
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 72.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 72.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                setBool("targetHasDot", Flagtoggle.Yes);
                                            } else {
                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 69.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 69.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 66.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 66.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                    } else {
                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 63.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 63.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                        } else {
                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                setBool("targetHasDot", Flagtoggle.Yes);
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 57.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 57.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                                } else {
                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 54.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 54.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                                    } else {
                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 51.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 51.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                                        } else {
                                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 48.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 48.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                setBool("targetHasDot", Flagtoggle.Yes);
                                                                            } else {
                                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 45.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                                                } else {
                                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 42.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 42.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                                                    } else {
                                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 39.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 39.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                                                        } else {
                                                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 36.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 36.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                setBool("targetHasDot", Flagtoggle.Yes);
                                                                                            } else {
                                                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 33.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 33.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                } else {
                                                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                    } else {
                                                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 27.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 27.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                        } else {
                                                                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 24.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 24.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                            } else {
                                                                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 21.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 21.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                } else {
                                                                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 18.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 18.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                    } else {
                                                                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 15.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 15.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                        } else {
                                                                                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 12.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 12.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                                setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                            } else {
                                                                                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 9.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 9.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                                    setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                                } else {
                                                                                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 6.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 6.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                                        setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                                    } else {
                                                                                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 3.0D, Valuecompare.Less, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 3.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                                                                                                                            setBool("targetHasDot", Flagtoggle.Yes);
                                                                                                                                        } else {
                                                                                                                                            setBool("targetHasDot", Flagtoggle.No);
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
        setBool("EnemyFound", Flagtoggle.No);
        if (getBoolEquals("IgnoreEnemies", Yesno.No)) {
            removeTarget();
            if (receivedMessage("FocusThisGuy")) {
            } else {
                // Any Enemies?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                    // Priority: Summoner
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 0.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    } else {
                        // Priority: Players
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 40.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    // Target Low Health Players
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                                    if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
                                        if (getBoolEquals("targetHasCC", Yesno.Yes)||getBoolEquals("targetHasDot", Yesno.Yes)) {
                                        } else {
                                            removeTarget();
                                            // Can Identify Stealthy Targets?
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                                // Contact!
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.15D, Yesno.No)) {
                                                    // Contact with Stealthed Player
                                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.1D, 0.15D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                                                    log("CONTACT!", "", "");
                                                } else {
                                                    // Noticed!
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.2D, 0.25D, Yesno.No)) {
                                                        if (random("6")) {
                                                            // Nearby Stealthed Players
                                                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.2D, 0.25D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.Yes);
                                                            log("NOTICED!", "", "");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // Can see into Hidden Areas
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                                }
                            } else {
                                // Ignore Hidden Players
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                            }
                        } else {
                            // Priority: Enemy Creeps
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                            }
                        }
                    }
                }
                if (hasTarget(Yesno.Yes)) {
                    setBool("EnemyFound", Flagtoggle.Yes);
                    // chaseBattle(4)
                    adjustCounter("setState", "4", Valueadjust.Set);
                }
            }
        }
    }

}

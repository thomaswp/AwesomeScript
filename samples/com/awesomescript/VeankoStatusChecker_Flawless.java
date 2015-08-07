
package com.awesomescript;

import java.util.EnumSet;

public class VeankoStatusChecker_Flawless
    extends Script
{


    public void onTick() {
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 91.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            setBool("LowerHealth2", Flagtoggle.No);
            setBool("LowerHealth", Flagtoggle.No);
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 81.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 100.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                setBool("LowerHealth2", Flagtoggle.Yes);
            } else {
                setBool("LowerHealth2", Flagtoggle.No);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 80.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 71.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 90.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                    setBool("LowerHealth2", Flagtoggle.Yes);
                } else {
                    setBool("LowerHealth2", Flagtoggle.No);
                }
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 61.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 80.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                        setBool("LowerHealth2", Flagtoggle.Yes);
                    } else {
                        setBool("LowerHealth2", Flagtoggle.No);
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 51.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 70.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                            setBool("LowerHealth2", Flagtoggle.Yes);
                        } else {
                            setBool("LowerHealth2", Flagtoggle.No);
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 41.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                setBool("LowerHealth2", Flagtoggle.Yes);
                            } else {
                                setBool("LowerHealth2", Flagtoggle.No);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 31.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 50.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                    setBool("LowerHealth2", Flagtoggle.Yes);
                                } else {
                                    setBool("LowerHealth2", Flagtoggle.No);
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 21.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                        setBool("LowerHealth2", Flagtoggle.Yes);
                                    } else {
                                        setBool("LowerHealth2", Flagtoggle.No);
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                            setBool("LowerHealth2", Flagtoggle.Yes);
                                        } else {
                                            setBool("LowerHealth2", Flagtoggle.No);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 81.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 100.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                setBool("LowerHealth", Flagtoggle.Yes);
            } else {
                setBool("LowerHealth", Flagtoggle.No);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 80.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 71.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 90.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                    setBool("LowerHealth", Flagtoggle.Yes);
                } else {
                    setBool("LowerHealth", Flagtoggle.No);
                }
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 61.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 80.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                        setBool("LowerHealth", Flagtoggle.Yes);
                    } else {
                        setBool("LowerHealth", Flagtoggle.No);
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 51.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 70.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                            setBool("LowerHealth", Flagtoggle.Yes);
                        } else {
                            setBool("LowerHealth", Flagtoggle.No);
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 41.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                setBool("LowerHealth", Flagtoggle.Yes);
                            } else {
                                setBool("LowerHealth", Flagtoggle.No);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 31.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 50.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                    setBool("LowerHealth", Flagtoggle.Yes);
                                } else {
                                    setBool("LowerHealth", Flagtoggle.No);
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 21.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                        setBool("LowerHealth", Flagtoggle.Yes);
                                    } else {
                                        setBool("LowerHealth", Flagtoggle.No);
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 2.0D, 1.0D, Yesno.No)) {
                                            setBool("LowerHealth", Flagtoggle.Yes);
                                        } else {
                                            setBool("LowerHealth", Flagtoggle.No);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (hasTarget(Yesno.Yes)) {
            if (((checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Target)||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target)) {
                setBool("targetHasCC", Flagtoggle.Yes);
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
        } else {
            setBool("targetHasCC", Flagtoggle.No);
            setBool("targetHasDot", Flagtoggle.No);
        }
    }

}

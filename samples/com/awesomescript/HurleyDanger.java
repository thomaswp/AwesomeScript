
package com.awesomescript;

import java.util.EnumSet;

public class HurleyDanger
    extends Script
{


    public void onTick() {
        setBool("unsafe", Flagtoggle.No);
        if (isInNamedArea("HEALAREACLOSE", Ownenemy.OWN_TEAM, Targetself.Self)) {
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    setBool("unsafe", Flagtoggle.Yes);
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 35.0D, "3", 0.0D, 0.0D, 1.5D, 1.0D, Yesno.No)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 85.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                                setBool("unsafe", Flagtoggle.Yes);
                            }
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                setBool("unsafe", Flagtoggle.Yes);
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "BotLevel2")) {
                                } else {
                                    setBool("unsafe", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            setBool("unsafe", Flagtoggle.Yes);
                        }
                    }
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "2", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 40.0D, "", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.No)) {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    setBool("unsafe", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                setBool("unsafe", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "BotLevel2")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 70.0D, "1", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 40.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                                    } else {
                                        setBool("unsafe", Flagtoggle.Yes);
                                    }
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 45.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                                    } else {
                                        setBool("unsafe", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 70.0D, "1", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.No)) {
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 70.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 40.0D, "2", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 70.0D, "1", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                            } else {
                                setBool("unsafe", Flagtoggle.Yes);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                setBool("unsafe", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.9D, 0.5D, Yesno.No)) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 55.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 40.0D, "2", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 70.0D, "1", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                                } else {
                                    setBool("unsafe", Flagtoggle.Yes);
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    setBool("unsafe", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                    if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidFlying", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 65.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                setBool("unsafe", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
        }
    }

}

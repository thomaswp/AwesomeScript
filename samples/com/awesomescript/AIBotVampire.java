
package com.awesomescript;

import java.util.EnumSet;

public class AIBotVampire
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Vampire");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("willnotkillSolarBoss", Yesno.No)) {
            setBool("willnotkillSolarBoss", Flagtoggle.Yes);
        }
        // chain wack
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (hasTarget(Yesno.Yes)) {
                // target is not from my team
                if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                        if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        } else {
                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.No)) {
                    // attack
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
        }
        // Evil Eye
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (isUpgradeEnabled(Yesno.Yes, "VampireBolas")) {
                        if (hasTarget(Yesno.Yes)) {
                            // target is not from my team
                            if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                            } else {
                                if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                } else {
                                    // avoid bugs
                                    if (getBoolEquals("BloodThirstToggle", Yesno.No)) {
                                        if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                        } else {
                                            if ((random("20")||isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes))||getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                                // do i have range upgrade
                                                if (isUpgradeEnabled(Yesno.Yes, "VampireBolasRange")) {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.3D, 1.3D, Yesno.Yes, Yesno.Yes)) {
                                                        // use eye badly if dumb
                                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                            setBool("usedEye", Flagtoggle.Yes);
                                                            setBool("RecentUsedEye", Flagtoggle.Yes);
                                                        } else {
                                                            setBool("DontMove", Flagtoggle.Yes);
                                                            // if super dumb: wait before using eye
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence0();
                                                            } else {
                                                                // if less dumb: wait a little less
                                                                sequence1();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes, Yesno.Yes)) {
                                                        // use eye badly if dumb
                                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                            setBool("usedEye", Flagtoggle.Yes);
                                                            setBool("RecentUsedEye", Flagtoggle.Yes);
                                                        } else {
                                                            setBool("DontMove", Flagtoggle.Yes);
                                                            // if super dumb: wait before using eye
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence2();
                                                            } else {
                                                                // if less dumb: wait a little less
                                                                sequence3();
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
        if (getBoolEquals("usedEye", Yesno.Yes)) {
            if (timer(Timeunits.Seconds, 7.5D, Yesno.No)) {
                setBool("usedEye", Flagtoggle.No);
            }
        }
        if (getBoolEquals("RecentUsedEye", Yesno.Yes)) {
            if (timer(Timeunits.Seconds, 2.5D, Yesno.No)) {
                setBool("RecentUsedEye", Flagtoggle.No);
            }
        }
        // Rage
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirst")) {
            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                // check if stunned to avoid bugs
                if (checkCharacterFlag(Characterflags.IsStunned, Yesno.No, Targetself.Self)) {
                    if (checkCharacterFlag(Characterflags.IsSilenced, Yesno.No, Targetself.Self)) {
                        if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                            if (hasTarget(Yesno.Yes)) {
                                // target is not from my team
                                if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                                } else {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                        // make sure there are no turrets
                                        if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.3D, 0.5D, Yesno.Yes, Yesno.No)) {
                                            // dont suicide with rage
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.Greater, Targetself.Self)) {
                                                // avoid bugs
                                                if (getBoolEquals("BloodThirstToggle", Yesno.No)) {
                                                    if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")&&hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                    } else {
                                                        if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker")&&hasUpgrade("Blinker", Teamswithnumbers.ENEMY_TEAM, "BlinkerTwirling"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Blinker", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 250.0D, "", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.Yes)) {
                                                        } else {
                                                            if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 200.0D, "", 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                                            } else {
                                                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                                } else {
                                                                    if (getBoolEquals("LowerHealth", Yesno.No)) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                }
                                                                            } else {
                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                    }
                                                                                } else {
                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                    }
                                                                                } else {
                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        // the more things that are in range, the higher the chance of raging
                                                                        if (checkCounter("TargetsInArea", "1", Valuecompare.Equal)) {
                                                                            if (random("40")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                                    if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                        }
                                                                                    } else {
                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        } else {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        } else {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            // the more things that are in range, the higher the chance of raging
                                                                            if (checkCounter("TargetsInArea", "2", Valuecompare.Equal)) {
                                                                                if (random("30")) {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                                        if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        } else {
                                                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            } else {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            } else {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                // the more things that are in range, the higher the chance of raging
                                                                                if (checkCounter("TargetsInArea", "3", Valuecompare.Equal)) {
                                                                                    if (random("20")) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            } else {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    // the more things that are in range, the higher the chance of raging
                                                                                    if (checkCounter("TargetsInArea", "4", Valuecompare.Equal)) {
                                                                                        if (random("10")) {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                                    if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
                                                                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")&&getBoolEquals("RecentUsedEye", Yesno.Yes)) {
                                                                                            if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.No)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            } else {
                                                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.65D, 0.65D, Yesno.Yes, Yesno.Yes)) {
                                                                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.No)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                if (getBoolEquals("DetectedStealth", Yesno.No)) {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                                                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)) {
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
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // check if ayla is using rage
                        if (getBoolEquals("BloodThirstToggle", Yesno.Yes)) {
                            if (getBoolEquals("CanStopRage", Yesno.Yes)) {
                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                    if ((isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.Yes)||checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Self))||getBoolEquals("LowerHealth", Yesno.Yes)) {
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                } else {
                                    // or im about to die
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                    if (hasTarget(Yesno.Yes)) {
                                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                            if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.8D, 1.4D, Yesno.Yes, Yesno.Yes)) {
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        } else {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
                                                } else {
                                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                                }
                                            } else {
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    } else {
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                }
                                if (getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                    // im not a noob
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                        // do i have range upgrade
                                        if (isUpgradeEnabled(Yesno.Yes, "VampireBolasRange")) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.3D, 1.3D, Yesno.Yes, Yesno.Yes)) {
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        } else {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes, Yesno.Yes)) {
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    }
                                }
                                if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
                                    // Target is too far away
                                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.Yes)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)) {
                                        } else {
                                            // the less people there are, the higer chance of quitting rage
                                            if (checkCounter("TargetsInArea", "1", Valuecompare.Equal)) {
                                                if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                    if (random("20")) {
                                                        // exit rage
                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                    }
                                                }
                                            } else {
                                                // the less people there are, the higer chance of quitting rage
                                                if (checkCounter("TargetsInArea", "2", Valuecompare.Equal)) {
                                                    if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                        if (random("50")) {
                                                            // exit rage
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        }
                                                    }
                                                } else {
                                                    // the less people there are, the higer chance of quitting rage
                                                    if (checkCounter("TargetsInArea", "3", Valuecompare.Equal)) {
                                                        if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                            if (random("80")) {
                                                                // exit rage
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // Target is too far away
                                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.Yes)) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes)) {
                                        } else {
                                            // the less people there are, the higer chance of quitting rage
                                            if (checkCounter("TargetsInArea", "1", Valuecompare.Equal)) {
                                                if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                    if (random("20")) {
                                                        // exit rage
                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                    }
                                                }
                                            } else {
                                                // the less people there are, the higer chance of quitting rage
                                                if (checkCounter("TargetsInArea", "2", Valuecompare.Equal)) {
                                                    if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                        if (random("50")) {
                                                            // exit rage
                                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                                        }
                                                    }
                                                } else {
                                                    // the less people there are, the higer chance of quitting rage
                                                    if (checkCounter("TargetsInArea", "3", Valuecompare.Equal)) {
                                                        if (getBoolEquals("LowerHealth", Yesno.Yes)) {
                                                            if (random("80")) {
                                                                // exit rage
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                // nearby clunk is exploding: retreat
                                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                                    if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                            // exit rage
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                }
                                // nearby sentry is charging: retreat
                                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy")) {
                                    if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 200.0D, "", 0.0D, 0.0D, 0.45D, 0.45D, Yesno.Yes)) {
                                            // exit rage
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                }
                                // is there a turret
                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.Yes)) {
                                    // check for creeps or players
                                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.4D, 0.0D, 0.5D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                }
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                    if (timer(Timeunits.Seconds, 2.5D, Yesno.No)) {
                                        setBool("CanStopRage", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                                            setBool("CanStopRage", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                            if (timer(Timeunits.Seconds, 1.5D, Yesno.No)) {
                                                setBool("CanStopRage", Flagtoggle.Yes);
                                            }
                                        } else {
                                            setBool("CanStopRage", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        } else {
                            setBool("CanStopRage", Flagtoggle.No);
                        }
                    }
                }
            }
            if (hasTarget(Yesno.Yes)) {
                if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                    // im not a noob
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        // Evil Eye off cooldown
                        if (getBoolEquals("usedEye", Yesno.No)) {
                            // target is player
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                // check to see if we can one shot our target with evil eye
                                if (isUpgradeEnabled(Yesno.Yes, "VAMPIREBOLASDAMAGE3")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "VampireHealth1")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 960.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            // we can one shot our target
                                            setBool("TargetInKillRange", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "VampireHealth2")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 860.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                // we can one shot our target
                                                setBool("TargetInKillRange", Flagtoggle.Yes);
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "VampireHealth3")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 760.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    // we can one shot our target
                                                    setBool("TargetInKillRange", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 660.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    // we can one shot our target
                                                    setBool("TargetInKillRange", Flagtoggle.Yes);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // check to see if we can one shot our target with evil eye
                                    if (isUpgradeEnabled(Yesno.Yes, "VAMPIREBOLASDAMAGE2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "VampireHealth1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 840.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                // we can one shot our target
                                                setBool("TargetInKillRange", Flagtoggle.Yes);
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "VampireHealth2")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 740.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    // we can one shot our target
                                                    setBool("TargetInKillRange", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "VampireHealth3")) {
                                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 640.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                        // we can one shot our target
                                                        setBool("TargetInKillRange", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 540.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                        // we can one shot our target
                                                        setBool("TargetInKillRange", Flagtoggle.Yes);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        // check to see if we can one shot our target with evil eye
                                        if (isUpgradeEnabled(Yesno.Yes, "VAMPIREBOLASDAMAGE1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "VampireHealth1")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 720.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    // we can one shot our target
                                                    setBool("TargetInKillRange", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "VampireHealth2")) {
                                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 620.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                        // we can one shot our target
                                                        setBool("TargetInKillRange", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.Yes, "VampireHealth3")) {
                                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 520.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                            // we can one shot our target
                                                            setBool("TargetInKillRange", Flagtoggle.Yes);
                                                        }
                                                    } else {
                                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 420.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                            // we can one shot our target
                                                            setBool("TargetInKillRange", Flagtoggle.Yes);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "VampireHealth1")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    // we can one shot our target
                                                    setBool("TargetInKillRange", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "VampireHealth2")) {
                                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 500.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                        // we can one shot our target
                                                        setBool("TargetInKillRange", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.Yes, "VampireHealth3")) {
                                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 400.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                            // we can one shot our target
                                                            setBool("TargetInKillRange", Flagtoggle.Yes);
                                                        }
                                                    } else {
                                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                            // we can one shot our target
                                                            setBool("TargetInKillRange", Flagtoggle.Yes);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                setBool("TargetInKillRange", Flagtoggle.No);
                            }
                        } else {
                            setBool("TargetInKillRange", Flagtoggle.No);
                        }
                    } else {
                        setBool("TargetInKillRange", Flagtoggle.No);
                    }
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "5", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                adjustCounter("TargetsInArea", "5", Valueadjust.Set);
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "4", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                    adjustCounter("TargetsInArea", "4", Valueadjust.Set);
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                        adjustCounter("TargetsInArea", "3", Valueadjust.Set);
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                            adjustCounter("TargetsInArea", "2", Valueadjust.Set);
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                adjustCounter("TargetsInArea", "1", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
            // is ayla using rage
            if (getBoolEquals("BloodThirstToggle", Yesno.Yes)) {
                // does she have a target
                if (hasTarget(Yesno.Yes)) {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                        if (checkCounter("state", "11", Valuecompare.Equal)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.5D, 1.0D, Yesno.Yes, Yesno.No)) {
                                // follow target
                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                // delay our chase if dumb
                                if (timer(Timeunits.Seconds, 0.8D, Yesno.Yes)) {
                                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                    } else {
                                        // follow target
                                        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                    }
                                }
                            } else {
                                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                } else {
                                    // follow target
                                    aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                } else {
                    // find players
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.8D, 1.4D, Yesno.Yes, Yesno.No)) {
                        // follow players
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 1.4D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    } else {
                        // find droids
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.8D, 1.4D, Yesno.Yes, Yesno.No)) {
                            // follow droids
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 1.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        } else {
                            // find health creeps
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.8D, 1.4D, Yesno.Yes, Yesno.No)) {
                                // follow health creeps
                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 1.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            }
                        }
                    }
                    setBool("TargetInKillRange", Flagtoggle.No);
                }
                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
                    // check walls
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                        adjustCounter("ragestuckfix", "1", Valueadjust.Add);
                    } else {
                        adjustCounter("ragestuckfix", "0", Valueadjust.Set);
                    }
                    if (checkCounter("ragestuckfix", "15", Valuecompare.GreaterOrEqual)) {
                        pressButton(Buttons.FACE_TOP, 0.0D);
                    }
                }
            } else {
                setBool("TargetInKillRange", Flagtoggle.No);
                adjustCounter("ragestuckfix", "0", Valueadjust.Set);
            }
        }
        // is healing orb in area?
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM, Teams.NEUTRAL_TEAM), "CreepAbsorb", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
                // no enemy nauts
                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes, Yesno.No)) {
                    // go to orb
                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM, Teams.NEUTRAL_TEAM), "CreepAbsorb", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                }
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")) {
                        if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                            // Enemy has CC: Buy BKM
                            setBool("BuyBKM", Flagtoggle.Yes);
                        }
                    } else {
                        // Froggy G
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                            if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                if (once()) {
                                    if (random("3")) {
                                        // Enemy has CC: Buy BKM
                                        setBool("BuyBKM", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                        // Derpl
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                            // Enemy has CC: Buy BKM
                            setBool("BuyBKM", Flagtoggle.Yes);
                        }
                        // Scoop
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Paladin")) {
                            if (random("3")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            }
                        }
                        // Lilac
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker")) {
                            // Chilas Wax Candle
                            if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "BlinkerHitSun1")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            }
                        }
                        // Clunk
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                            // Screamer engine
                            if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankBiteSnare")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                    if (once()) {
                                        if (checkGameTime(240.0D, Valuecompare.Less)) {
                                            if (random("4")) {
                                                // Enemy has CC: Buy BKM
                                                setBool("BuyBKM", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // Voltar
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")) {
                            if (hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerShotKnockback")||hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerHealtotemKnockback")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                    if (once()) {
                                        if (checkGameTime(240.0D, Valuecompare.Less)) {
                                            if (random("4")) {
                                                // Enemy has CC: Buy BKM
                                                setBool("BuyBKM", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // Vinne & Spike
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Bird")) {
                            // Ayla
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                            } else {
                                setBool("StoleNiggaBike", Flagtoggle.Yes);
                            }
                            // Red bandana
                            if (hasUpgrade("Bird", Teamswithnumbers.ENEMY_TEAM, "BirdSmokeSilence")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                    if (once()) {
                                        if (checkGameTime(240.0D, Valuecompare.Less)) {
                                            if (random("8")) {
                                                // Enemy has CC: Buy BKM
                                                setBool("BuyBKM", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // Admiral Swiggins
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain")) {
                            // Bovinian skimmed milk
                            if (hasUpgrade("Captain", Teamswithnumbers.ENEMY_TEAM, "CaptainHitMaxhp1")) {
                                // Ayla
                                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                                } else {
                                    setBool("StoleNiggaBike", Flagtoggle.Yes);
                                }
                            }
                        }
                        // Ayla
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                        } else {
                            // Raelynn
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
                                setBool("StoleNiggaBike", Flagtoggle.Yes);
                            } else {
                                // random chance to buy blue three wheeler
                                if (once()) {
                                    if (random("4")) {
                                        setBool("StoleNiggaBike", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                        // Ted
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Commando")) {
                            // Ted's power briefs
                            if (hasUpgrade("Commando", Teamswithnumbers.ENEMY_TEAM, "CommandoShotKnockback1")) {
                                // Enemy has CC: Buy BKM
                                setBool("BuyBKM", Flagtoggle.Yes);
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                    if (once()) {
                                        if (checkGameTime(240.0D, Valuecompare.Less)) {
                                            if (random("4")) {
                                                // Enemy has CC: Buy BKM
                                                setBool("BuyBKM", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "VAMPIREBOLAS")) {
                        if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                            // Buy BKM
                            setBool("BuyBKM", Flagtoggle.Yes);
                        } else {
                            // dont buy BKM
                            setBool("BuyBKM", Flagtoggle.No);
                        }
                    }
                    if (checkGameTime(1200.0D, Valuecompare.GreaterOrEqual)||checkCharacterValue(CharactervaluesCheckable.Gold, 1000.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                            // Buy BKM
                            setBool("BuyBKM", Flagtoggle.Yes);
                        }
                    }
                }
            }
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "VampireBloodThirst")) {
                    if (canPayUpgrade("VampireBloodThirst")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                        }
                        buyUpgrade("VampireBloodThirst");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (getBoolEquals("BuyBKM", Yesno.No)) {
                        if (isUpgradeEnabled(Yesno.No, "ccReduction")&&isUpgradeEnabled(Yesno.No, "ccReduction2")) {
                            if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                if (canPayUpgrade("PiggyBank")) {
                                    buyUpgrade("PiggyBank");
                                }
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "VAMPIREBOLAS")) {
                    if (canPayUpgrade("VAMPIREBOLAS")) {
                        buyUpgrade("VAMPIREBOLAS");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "VAMPIREBLOODTHIRSTDAMAGE1")) {
                    if (canPayUpgrade("VAMPIREBLOODTHIRSTDAMAGE1")) {
                        buyUpgrade("VAMPIREBLOODTHIRSTDAMAGE1");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBLOODTHIRSTDAMAGE2")) {
                        if (canPayUpgrade("VAMPIREBLOODTHIRSTDAMAGE2")) {
                            buyUpgrade("VAMPIREBLOODTHIRSTDAMAGE2");
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "VAMPIREBLOODTHIRSTDAMAGE3")) {
                            if (canPayUpgrade("VAMPIREBLOODTHIRSTDAMAGE3")) {
                                buyUpgrade("VAMPIREBLOODTHIRSTDAMAGE3");
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "VampireSpeed")) {
                                if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstSize")) {
                                    if (canPayUpgrade("VampireBloodThirstSize")) {
                                        buyUpgrade("VampireBloodThirstSize");
                                    }
                                }
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
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
                                    if (getBoolEquals("BuyBKM", Yesno.Yes)) {
                                        if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                            if (isUpgradeEnabled(Yesno.No, "ccReduction")) {
                                                if (canPayUpgrade("ccReduction")) {
                                                    buyUpgrade("ccReduction");
                                                }
                                            }
                                            if (isUpgradeEnabled(Yesno.No, "ccReduction2")) {
                                                if (canPayUpgrade("ccReduction2")) {
                                                    buyUpgrade("ccReduction2");
                                                }
                                            }
                                        }
                                    }
                                }
                                if (getBoolEquals("StoleNiggaBike", Yesno.No)) {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstSpeed")) {
                                        if (random("2")) {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstAttackspeed")) {
                                                if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstTrail1")) {
                                                    if (canPayUpgrade("VampireBloodThirstTrail1")) {
                                                        buyUpgrade("VampireBloodThirstTrail1");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstTrail2")) {
                                                        if (canPayUpgrade("VampireBloodThirstTrail2")) {
                                                            buyUpgrade("VampireBloodThirstTrail2");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstTrail3")) {
                                                            if (canPayUpgrade("VampireBloodThirstTrail3")) {
                                                                buyUpgrade("VampireBloodThirstTrail3");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstTrail1")) {
                                                if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstAttackspeed")) {
                                                    if (canPayUpgrade("VampireBloodThirstAttackspeed")) {
                                                        buyUpgrade("VampireBloodThirstAttackspeed");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstTrail1")&&isUpgradeEnabled(Yesno.No, "VampireBloodThirstAttackspeed")) {
                                        if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstSpeed")) {
                                            if (canPayUpgrade("VampireBloodThirstSpeed")) {
                                                buyUpgrade("VampireBloodThirstSpeed");
                                            }
                                        }
                                    }
                                }
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                    if (getBoolEquals("BuyBKM", Yesno.Yes)) {
                                        if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                            if (isUpgradeEnabled(Yesno.No, "ccReduction")) {
                                                if (canPayUpgrade("ccReduction")) {
                                                    buyUpgrade("ccReduction");
                                                }
                                            }
                                            if (isUpgradeEnabled(Yesno.No, "ccReduction2")) {
                                                if (canPayUpgrade("ccReduction2")) {
                                                    buyUpgrade("ccReduction2");
                                                }
                                            }
                                        }
                                    }
                                }
                                if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Assassin"))||random("3")) {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBolasRange")&&isUpgradeEnabled(Yesno.No, "VampireBolasDot1")) {
                                        if (isUpgradeEnabled(Yesno.No, "VampireBolasSlow1")) {
                                            if (canPayUpgrade("VampireBolasSlow1")) {
                                                buyUpgrade("VampireBolasSlow1");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBolasSlow2")) {
                                                if (canPayUpgrade("VampireBolasSlow2")) {
                                                    buyUpgrade("VampireBolasSlow2");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBolasSlow1")) {
                                        if (random("2")) {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBolasRange")) {
                                                if (isUpgradeEnabled(Yesno.No, "VampireBolasDot1")) {
                                                    if (canPayUpgrade("VampireBolasDot1")) {
                                                        buyUpgrade("VampireBolasDot1");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "VampireBolasDot2")) {
                                                        if (canPayUpgrade("VampireBolasDot2")) {
                                                            buyUpgrade("VampireBolasDot2");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBolasDot1")) {
                                                if (isUpgradeEnabled(Yesno.No, "VampireBolasRange")) {
                                                    if (canPayUpgrade("VampireBolasRange")) {
                                                        buyUpgrade("VampireBolasRange");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (isUpgradeEnabled(Yesno.No, "VAMPIREBOLASDAMAGE1")) {
                                    if (canPayUpgrade("VAMPIREBOLASDAMAGE1")) {
                                        buyUpgrade("VAMPIREBOLASDAMAGE1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBOLASDAMAGE2")) {
                                        if (canPayUpgrade("VAMPIREBOLASDAMAGE2")) {
                                            buyUpgrade("VAMPIREBOLASDAMAGE2");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "VAMPIREBOLASDAMAGE3")) {
                                            if (canPayUpgrade("VAMPIREBOLASDAMAGE3")) {
                                                buyUpgrade("VAMPIREBOLASDAMAGE3");
                                            }
                                        }
                                    }
                                }
                                if (isUpgradeEnabled(Yesno.No, "VampireBolasHp1")) {
                                    if (canPayUpgrade("VampireBolasHp1")) {
                                        buyUpgrade("VampireBolasHp1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBOLASHP2")) {
                                        if (canPayUpgrade("VAMPIREBOLASHP2")) {
                                            buyUpgrade("VAMPIREBOLASHP2");
                                        }
                                    }
                                }
                                if (random("2")) {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBiteNearbyhero1")) {
                                        if (isUpgradeEnabled(Yesno.No, "VampireBiteMaxhp1")) {
                                            if (canPayUpgrade("VampireBiteMaxhp1")) {
                                                buyUpgrade("VampireBiteMaxhp1");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBiteMaxhp2")) {
                                                if (canPayUpgrade("VampireBiteMaxhp2")) {
                                                    buyUpgrade("VampireBiteMaxhp2");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBiteMaxhp1")) {
                                        if (isUpgradeEnabled(Yesno.No, "VampireBiteNearbyhero1")) {
                                            if (canPayUpgrade("VampireBiteNearbyhero1")) {
                                                buyUpgrade("VampireBiteNearbyhero1");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VampireBiteNearbyhero2")) {
                                                if (canPayUpgrade("VampireBiteNearbyhero2")) {
                                                    buyUpgrade("VampireBiteNearbyhero2");
                                                }
                                            }
                                        }
                                    }
                                }
                                if (random("2")) {
                                    if (isUpgradeEnabled(Yesno.No, "VampireBiteMark")) {
                                        if (isUpgradeEnabled(Yesno.No, "VAMPIREBITELIFESTEAL")) {
                                            if (canPayUpgrade("VAMPIREBITELIFESTEAL")) {
                                                buyUpgrade("VAMPIREBITELIFESTEAL");
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBITELIFESTEAL")) {
                                        if (isUpgradeEnabled(Yesno.No, "VampireBiteMark")) {
                                            if (canPayUpgrade("VampireBiteMark")) {
                                                buyUpgrade("VampireBiteMark");
                                            }
                                        }
                                    }
                                }
                                if (random("2")) {
                                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEATTACKSPEED1")) {
                                        if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEDAMAGE1")) {
                                            if (canPayUpgrade("VAMPIREBITEDAMAGE1")) {
                                                buyUpgrade("VAMPIREBITEDAMAGE1");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEDAMAGE2")) {
                                                if (canPayUpgrade("VAMPIREBITEDAMAGE2")) {
                                                    buyUpgrade("VAMPIREBITEDAMAGE2");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEDAMAGE1")) {
                                        if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEATTACKSPEED1")) {
                                            if (canPayUpgrade("VAMPIREBITEATTACKSPEED1")) {
                                                buyUpgrade("VAMPIREBITEATTACKSPEED1");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "VAMPIREBITEATTACKSPEED2")) {
                                                if (canPayUpgrade("VAMPIREBITEATTACKSPEED2")) {
                                                    buyUpgrade("VAMPIREBITEATTACKSPEED2");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "VampireSpeed")) {
                        if (canPayUpgrade("VampireSpeed")) {
                            buyUpgrade("VampireSpeed");
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

    @Script.Sequence(blocking = false)
    void sequence0() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedEye", Flagtoggle.Yes);
        setBool("RecentUsedEye", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedEye", Flagtoggle.Yes);
        setBool("RecentUsedEye", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedEye", Flagtoggle.Yes);
        setBool("RecentUsedEye", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedEye", Flagtoggle.Yes);
        setBool("RecentUsedEye", Flagtoggle.Yes);
    }

}

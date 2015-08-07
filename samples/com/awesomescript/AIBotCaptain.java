
package com.awesomescript;

import java.util.EnumSet;

public class AIBotCaptain
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Captain", Flagtoggle.Yes);
        }
        executeBehaviourTree("Captain");
        executeBehaviourTree("VeankoAI_Swigs");
        // copy this code into your bot
        if (isButtonDown(Buttons.FACE_BOTTOM)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
            }
        }
        setBool("lowSkillWait", Flagtoggle.No);
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.01D, Valuecompare.LessOrEqual, Targetself.Self)) {
            if (random("12")) {
            } else {
                setBool("lowSkillWait", Flagtoggle.Yes);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.21D, Valuecompare.LessOrEqual, Targetself.Self)) {
                if (random("8")) {
                } else {
                    setBool("lowSkillWait", Flagtoggle.Yes);
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (hasTarget(Yesno.No)||isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.15D, 0.0D, 0.3D, 0.6D, Yesno.Yes, Yesno.No)) {
                        if (checkCounter("state", "1", Valuecompare.Equal)) {
                            if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.15D, 0.0D, 0.3D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            }
                        } else {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.15D, 0.0D, 0.3D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        }
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.15D, 0.0D, 0.3D, 0.6D, Yesno.Yes, Yesno.No)) {
                            if (checkCounter("state", "1", Valuecompare.Equal)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -0.15D, 0.0D, 0.3D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                }
                            } else {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, -0.15D, 0.0D, 0.3D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            }
                        }
                    }
                }
            }
        }
        setBool("hookSafe", Flagtoggle.Yes);
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.49D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                if ((checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.GreaterOrEqual, Targetself.Target))&&isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                    setBool("hookSafe", Flagtoggle.No);
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.3D, 0.0D, 0.5D, 0.4D, Yesno.No, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 25.0D, "3", 0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 33.0D, "2", 0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CaptainHookBomb")) {
                                    if (random("8")) {
                                    } else {
                                        setBool("hookSafe", Flagtoggle.No);
                                    }
                                } else {
                                    setBool("hookSafe", Flagtoggle.No);
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 25.0D, "2", 0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 33.0D, "1", 0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHookBomb")) {
                                        if (random("8")) {
                                        } else {
                                            setBool("hookSafe", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("hookSafe", Flagtoggle.No);
                                    }
                                }
                            }
                        }
                    }
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", 0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                            setBool("hookSafe", Flagtoggle.No);
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                                setBool("hookSafe", Flagtoggle.No);
                            }
                        }
                    }
                }
            } else {
                if ((checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.LessOrEqual, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.GreaterOrEqual, Targetself.Target))&&isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                    setBool("hookSafe", Flagtoggle.No);
                } else {
                    if (isTargetInArea(Yesno.Yes, -0.3D, 0.0D, 0.5D, 0.4D, Yesno.No, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 25.0D, "3", -0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 33.0D, "2", -0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CaptainHookBomb")) {
                                    if (random("8")) {
                                    } else {
                                        setBool("hookSafe", Flagtoggle.No);
                                    }
                                } else {
                                    setBool("hookSafe", Flagtoggle.No);
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 25.0D, "2", -0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 33.0D, "1", -0.3D, 0.0D, 0.5D, 0.4D, Yesno.No)) {
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHookBomb")) {
                                        if (random("8")) {
                                        } else {
                                            setBool("hookSafe", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("hookSafe", Flagtoggle.No);
                                    }
                                }
                            }
                        }
                    }
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, -0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", -0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                            setBool("hookSafe", Flagtoggle.No);
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", -0.4D, 0.0D, 0.8D, 0.4D, Yesno.No)) {
                                setBool("hookSafe", Flagtoggle.No);
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("hookSafe", Yesno.No)) {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage2")) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 56.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            setBool("hookSafe", Flagtoggle.Yes);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage1")) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 46.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                setBool("hookSafe", Flagtoggle.Yes);
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 36.0D, Valuecompare.GreaterOrEqual, Targetself.Target)) {
                                setBool("hookSafe", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
        }
        // Anchor Hook
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                if (getBoolEquals("lowSkillWait", Yesno.Yes)) {
                } else {
                    if (getBoolEquals("hookSafe", Yesno.Yes)) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                            if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.04D, 0.07D, 0.05D, 0.03D, Yesno.No, Yesno.No)&&isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.7D, 0.0D, 0.4D, 0.1D, Yesno.No)) {
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOKRANGE1")) {
                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.55D, 1.55D, Yesno.Yes, Yesno.Yes)) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOK")) {
                                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                            sequence0();
                                                        } else {
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence1();
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                                    sequence2();
                                                                } else {
                                                                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                                    } else {
                                                                        sequence3();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.15D, 1.15D, Yesno.Yes, Yesno.Yes)) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOK")) {
                                                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                            sequence4();
                                                        } else {
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence5();
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                                    sequence6();
                                                                } else {
                                                                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                                    } else {
                                                                        sequence7();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)&&isInArea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", -0.04D, 0.07D, 0.05D, 0.03D, Yesno.No, Yesno.No)) {
                                        } else {
                                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, -0.7D, 0.0D, 0.4D, 0.1D, Yesno.No)) {
                                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOKRANGE1")) {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.55D, 1.55D, Yesno.Yes, Yesno.Yes)) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOK")) {
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence8();
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                                    sequence9();
                                                                } else {
                                                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                                        sequence10();
                                                                    } else {
                                                                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                                        } else {
                                                                            sequence11();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.15D, 1.15D, Yesno.Yes, Yesno.Yes)) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOK")) {
                                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                                sequence12();
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                                    sequence13();
                                                                } else {
                                                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                                        sequence14();
                                                                    } else {
                                                                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                                        } else {
                                                                            sequence15();
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
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.15D, 0.15D, Yesno.Yes)) {
                    sequence16();
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (random("10")) {
                // Throw Anchor at turret
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.23D, 0.0D, 0.46D, 0.3D, Yesno.Yes)) {
                    // Don't throw anchor if it will just be picked up anyway!
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.35D, 0.3D, Yesno.Yes)) {
                    } else {
                        // no greens overhead
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.07D, 0.05D, 0.05D, Yesno.No, Yesno.No)) {
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 700.0D, "", 0.25D, 0.1D, 0.5D, 0.35D, Yesno.No)) {
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    if (isTargetType(Yesno.No, EnumSet.of(TargetGroups.CREEPS))) {
                                        if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                                            sequence18();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (once()) {
            setBool("anchorTime", Flagtoggle.Yes);
            setBool("hitOnce", Flagtoggle.Yes);
        }
        // Drop Anchor
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
            if (isUpgradeEnabled(Yesno.No, "CaptainDoubleHitReady")) {
                if (getBoolEquals("lowSkillWait", Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                        if (checkCounter("SkipDrop", "0", Valuecompare.LessOrEqual)) {
                            if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                sequence19();
                                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 350.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.8D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                sequence24();
                                            } else {
                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                    sequence25();
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                        sequence26();
                                                    } else {
                                                        sequence27();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.5D, 0.4D, Yesno.Yes, Yesno.Yes)) {
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                                sequence28();
                                            } else {
                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                                    sequence29();
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                                        sequence30();
                                                    } else {
                                                        sequence31();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            adjustCounter("SkipDrop", "-1", Valueadjust.Add);
                        }
                    }
                }
            }
        }
        setBool("Recall", Flagtoggle.No);
        if ((isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS)))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 55.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
            setBool("Recall", Flagtoggle.Yes);
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            setBool("Recall", Flagtoggle.Yes);
        }
        // Recall
        if (checkCounter("SkipDrop", "0", Valuecompare.LessOrEqual)) {
            if (getBoolEquals("Recall", Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainAnchorOnCooldown")) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            pressButton(Buttons.FACE_TOP, 0.0D);
                            adjustCounter("SkipDrop", "10", Valueadjust.Set);
                        } else {
                            if ((isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target))&&isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.32D, 0.2D, Yesno.No, Yesno.No)) {
                                pressButton(Buttons.FACE_TOP, 0.0D);
                                adjustCounter("SkipDrop", "10", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
        } else {
            adjustCounter("SkipDrop", "-1", Valueadjust.Add);
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            // Target Creeps
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterAIStation404", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterAIStation404", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                }
            } else {
                // Target Creeps
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterRibbit4", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterRibbit4", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                    }
                } else {
                    // Target Creeps
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterSorona", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes)) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterSorona", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                        }
                    } else {
                        // Target Creeps
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterCrab", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes)) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepCritterCrab", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                            }
                        }
                    }
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if ((((hasTarget(Yesno.Yes)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS)))&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target))&&isTargetInArea(Yesno.Yes, 0.36D, 0.0D, 0.04D, 0.72D, Yesno.Yes, Yesno.No))&&isOnGround(Yesno.Yes, Targetself.Self)) {
                adjustCounter("inkChase", "1", Valueadjust.Add);
            } else {
                adjustCounter("inkChase", "0", Valueadjust.Set);
            }
            if (checkCounter("inkChase", "15", Valuecompare.GreaterOrEqual)) {
                adjustCounter("inkChase", "0", Valueadjust.Set);
                sequence32();
            }
        }
        setBool("dontfire", Flagtoggle.No);
        if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.GreaterOrEqual, Targetself.Self)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 15.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)||isTargetInArea(Yesno.Yes, -0.3D, 0.0D, 0.6D, 1.0D, Yesno.No, Yesno.Yes)) {
                        setBool("dontfire", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (getBoolEquals("dontfire", Yesno.No)) {
            // Ink Shot
            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                } else {
                    if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)||isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                        if (getBoolEquals("stopInk", Yesno.No)) {
                            if (getMissionBoolEquals("MoveAwayFromTarget", Yesno.Yes)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            } else {
                                if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                                        if (hasTarget(Yesno.Yes)) {
                                            if ((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                                            } else {
                                                if (getBoolEquals("lowerInkRange", Yesno.Yes)) {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.64D, 0.72D, Yesno.Yes, Yesno.Yes)) {
                                                        sequence33();
                                                    }
                                                } else {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes, Yesno.Yes)) {
                                                        sequence34();
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
            // Anchor
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.32D, 0.2D, Yesno.No, Yesno.Yes)) {
                if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)||isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                    if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                        if (hasTarget(Yesno.Yes)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.32D, 0.2D, Yesno.No, Yesno.Yes)) {
                                if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                                } else {
                                    sequence35();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, 0.0D, 0.16D, 0.2D, Yesno.No, Yesno.No)) {
            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                pressButton(Buttons.FACE_LEFT, 0.0D);
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.01D, Valuecompare.LessOrEqual, Targetself.Self)) {
            if (checkGameTime(300.0D, Valuecompare.Less)) {
                setBool("noBuyUpgrades", Flagtoggle.Yes);
            } else {
                setBool("noBuyUpgrades", Flagtoggle.No);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.Health, 210.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                if (checkGameTime(180.0D, Valuecompare.Less)) {
                    setBool("noBuyUpgrades", Flagtoggle.Yes);
                } else {
                    setBool("noBuyUpgrades", Flagtoggle.No);
                }
            } else {
                setBool("noBuyUpgrades", Flagtoggle.No);
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)||getBoolEquals("noBuyUpgrades", Yesno.No)) {
            if (isInNamedArea("REGENHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "CAPTAINHOOK")) {
                    if (canPayUpgrade("CAPTAINHOOK")) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            // perfect drop, lets swigs buy both base abilities
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 38.0D, Valueadjust.Add);
                        }
                        buyUpgrade("CAPTAINHOOK");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainDrop")) {
                    if (canPayUpgrade("CaptainDrop")) {
                        buyUpgrade("CaptainDrop");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainHitDouble")) {
                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHitAttackspeed1")&&isUpgradeEnabled(Yesno.Yes, "CAPTAINHITSHIELD1")) {
                    } else {
                        if (canPayUpgrade("CaptainHitDouble")) {
                            buyUpgrade("CaptainHitDouble");
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                            if (canPayUpgrade("healthRegen1")) {
                                buyUpgrade("healthRegen1");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainHitDamage1")) {
                    if (canPayUpgrade("CaptainHitDamage1")) {
                        buyUpgrade("CaptainHitDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CAPTAINHITDAMAGE2")) {
                    if (canPayUpgrade("CAPTAINHITDAMAGE2")) {
                        buyUpgrade("CAPTAINHITDAMAGE2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CAPTAINHITDAMAGE3")) {
                    if (canPayUpgrade("CAPTAINHITDAMAGE3")) {
                        buyUpgrade("CAPTAINHITDAMAGE3");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainHookDamage1")) {
                    if (canPayUpgrade("CaptainHookDamage1")) {
                        buyUpgrade("CaptainHookDamage1");
                    }
                }
                if (hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteThrow")||hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankBiteSnare")) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainHookStun1")) {
                        if (canPayUpgrade("CaptainHookStun1")) {
                            buyUpgrade("CaptainHookStun1");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CAPTAINHOOKDAMAGE2")) {
                    if (canPayUpgrade("CAPTAINHOOKDAMAGE2")) {
                        buyUpgrade("CAPTAINHOOKDAMAGE2");
                    }
                }
                if (random("4")) {
                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHitAttackspeed1")&&isUpgradeEnabled(Yesno.Yes, "CaptainHitDouble")) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainHitAttackspeed2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage2")) {
                                    if (canPayUpgrade("CaptainHitAttackspeed2")) {
                                        buyUpgrade("CaptainHitAttackspeed2");
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                            if (isUpgradeEnabled(Yesno.No, "CAPTAINHITSHIELD1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                    if (canPayUpgrade("CAPTAINHITSHIELD1")) {
                                        buyUpgrade("CAPTAINHITSHIELD1");
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.No, "CaptainHitShield2")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                    if (canPayUpgrade("CaptainHitShield2")) {
                                        buyUpgrade("CaptainHitShield2");
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "CaptainHitAttackspeed1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage1")) {
                                        if (canPayUpgrade("CaptainHitAttackspeed1")) {
                                            buyUpgrade("CaptainHitAttackspeed1");
                                        }
                                    }
                                }
                            }
                            if (isUpgradeEnabled(Yesno.No, "CaptainHitAttackspeed2")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage2")) {
                                        if (canPayUpgrade("CaptainHitAttackspeed2")) {
                                            buyUpgrade("CaptainHitAttackspeed2");
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDouble")&&isUpgradeEnabled(Yesno.Yes, "CAPTAINHITSHIELD1")) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainHitShield2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                if (canPayUpgrade("CaptainHitShield2")) {
                                    buyUpgrade("CaptainHitShield2");
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "CaptainHitAttackspeed1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage1")) {
                                    if (canPayUpgrade("CaptainHitAttackspeed1")) {
                                        buyUpgrade("CaptainHitAttackspeed1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CaptainHitAttackspeed2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CaptainHookDamage2")) {
                                    if (canPayUpgrade("CaptainHitAttackspeed2")) {
                                        buyUpgrade("CaptainHitAttackspeed2");
                                    }
                                }
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                            if (canPayUpgrade("healthRegen2")) {
                                buyUpgrade("healthRegen2");
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDamage1")) {
                            if (canPayUpgrade("addHealth1")) {
                                buyUpgrade("addHealth1");
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                        if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHOOKDAMAGE2")) {
                            if (canPayUpgrade("addHealth2")) {
                                buyUpgrade("addHealth2");
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainSpeed")) {
                        if (canPayUpgrade("CaptainSpeed")) {
                            buyUpgrade("CaptainSpeed");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                    if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDamage3")) {
                        if (canPayUpgrade("addHealth3")) {
                            buyUpgrade("addHealth3");
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDamage1")) {
                            if (canPayUpgrade("healthRegen1")) {
                                buyUpgrade("healthRegen1");
                            }
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDamage2")) {
                            if (canPayUpgrade("healthRegen2")) {
                                buyUpgrade("healthRegen2");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainHookStun1")) {
                    if (canPayUpgrade("CaptainHookStun1")) {
                        buyUpgrade("CaptainHookStun1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainDropExplode1")) {
                    if (canPayUpgrade("CaptainDropExplode1")) {
                        buyUpgrade("CaptainDropExplode1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainDropExplode2")) {
                    if (canPayUpgrade("CaptainDropExplode2")) {
                        buyUpgrade("CaptainDropExplode2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CAPTAINDROPEXPLODE3")) {
                    if (canPayUpgrade("CAPTAINDROPEXPLODE3")) {
                        buyUpgrade("CAPTAINDROPEXPLODE3");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainDropDamage1")) {
                    if (canPayUpgrade("CaptainDropDamage1")) {
                        buyUpgrade("CaptainDropDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainDropDamage2")) {
                    if (canPayUpgrade("CaptainDropDamage2")) {
                        buyUpgrade("CaptainDropDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CaptainHookStun1")) {
                    if (canPayUpgrade("CaptainHookStun1")) {
                        buyUpgrade("CaptainHookStun1");
                    }
                }
                if (random("3")) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainHookBomb")) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainHookRange1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDropExplode3")) {
                                if (canPayUpgrade("CaptainHookRange1")) {
                                    buyUpgrade("CaptainHookRange1");
                                }
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "CaptainHookBomb")) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainHookRange1")) {
                            if (canPayUpgrade("CaptainHookBomb")) {
                                buyUpgrade("CaptainHookBomb");
                            }
                        }
                    }
                }
                if (random("3")) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainDropSpeed1")) {
                        if (isUpgradeEnabled(Yesno.No, "CAPTAINDROPANKERHEALTH1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE1")) {
                                    if (canPayUpgrade("CAPTAINDROPANKERHEALTH1")) {
                                        buyUpgrade("CAPTAINDROPANKERHEALTH1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropAnkerHealth2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropAnkerHealth2")) {
                                        buyUpgrade("CaptainDropAnkerHealth2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropAnkerHealth3")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropAnkerHealth3")) {
                                        buyUpgrade("CaptainDropAnkerHealth3");
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropSpeed2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropSpeed2")) {
                                        buyUpgrade("CaptainDropAnkerSpeed2");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "CAPTAINDROPANKERHEALTH1")) {
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropSpeed1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropSpeed1")) {
                                        buyUpgrade("CaptainDropAnkerSpeed1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropSpeed2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropSpeed2")) {
                                        buyUpgrade("CaptainDropAnkerSpeed2");
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropAnkerHealth2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropAnkerHealth2")) {
                                        buyUpgrade("CaptainDropAnkerHealth2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CaptainDropAnkerHealth3")) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINDROPEXPLODE3")) {
                                    if (canPayUpgrade("CaptainDropAnkerHealth3")) {
                                        buyUpgrade("CaptainDropAnkerHealth3");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
            if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.15D, 0.0D, 0.3D, 0.2D, Yesno.No)) {
                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                        setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                        setBool("MoveTowardsTarget", Flagtoggle.No);
                    }
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -0.15D, 0.0D, 0.3D, 0.2D, Yesno.No)) {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                        } else {
                            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                            setBool("MoveTowardsTarget", Flagtoggle.No);
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
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                    if (random("2")) {
                        if (timer(Timeunits.Seconds, 0.75D, Yesno.No)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    } else {
                        if (random("2")) {
                            if (timer(Timeunits.Seconds, 1.25D, Yesno.No)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        } else {
                            if (random("2")) {
                                if (timer(Timeunits.Seconds, 1.75D, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.06D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
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
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.06D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
            }
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        if (isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            if (isInNamedArea("HEALAREACLOSE", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            } else {
                if (getMissionBoolEquals("wantAnchor", Yesno.No)) {
                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.7D, 0.6D, Yesno.No, Yesno.Yes)) {
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.72D, 0.75D, Yesno.No, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            }
                            setBool("GoForward", Flagtoggle.Yes);
                            setBool("GoBack", Flagtoggle.No);
                            // check walls
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.06D, Yesno.No, Yesno.No)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.25D, 0.0D, 0.5D, 0.1D, Yesno.No, Yesno.No)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.No, Yesno.Yes)) {
                                } else {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.72D, 0.75D, Yesno.No, Yesno.No)) {
                                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.72D, 0.72D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                    }
                                    setBool("GoForward", Flagtoggle.No);
                                    setBool("GoBack", Flagtoggle.Yes);
                                    // check walls
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.06D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
            if (((checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
            } else {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.01D, Yesno.No, Yesno.No)) {
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.05D, -0.05D, 0.1D, 0.02D, Yesno.No, Yesno.No)) {
            if ((getBoolEquals("GoForward", Yesno.Yes)&&getBoolEquals("DontMove", Yesno.No))&&getBoolEquals("GoBack", Yesno.No)) {
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            // Are enemy creeps or turrets nearby?
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.06D, 0.0D, 0.12D, 0.1D, Yesno.Yes, Yesno.No)) {
                if (isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                    // Am I targeting the enemy base?
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                    } else {
                        setBool("GoForward", Flagtoggle.No);
                        // Don't stand so close to me!
                        setBool("GoBack", Flagtoggle.Yes);
                    }
                } else {
                    setBool("GoForward", Flagtoggle.No);
                    // Don't stand so close to me!
                    setBool("GoBack", Flagtoggle.Yes);
                }
                // Are friendly creeps blocking?
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.2D, 0.1D, Yesno.No)) {
                } else {
                    // I don't want to jump around turrets
                    if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.No)) {
                    } else {
                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                            // Don't jump while AA is ready
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                            } else {
                                // Don't jump too often
                                if (timer(Timeunits.Seconds, 1.2D, Yesno.No)) {
                                    // Delay jump slightly so AA still lands
                                    sequence36();
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            // Am I targeting the enemy base?
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                    // Recall
                    if (checkCounter("SkipDrop", "0", Valuecompare.LessOrEqual)) {
                        if (getBoolEquals("Recall", Yesno.Yes)) {
                            if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                                pressButton(Buttons.FACE_TOP, 0.0D);
                                adjustCounter("SkipDrop", "10", Valueadjust.Set);
                            }
                        }
                    } else {
                        adjustCounter("SkipDrop", "-1", Valueadjust.Add);
                    }
                }
            }
        }
        if (hasTarget(Yesno.No)) {
            if ((checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, null, "", 0.0D, -0.02D, 0.1D, 0.04D, Yesno.No, Yesno.No)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -0.4D, 0.5D, 0.6D, Yesno.No, Yesno.No)) {
                    setBool("DownJump", Flagtoggle.Yes);
                }
            }
        }
        if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
            if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Less, 0.0D, 0.1D, 0.0D, 0.2D, 0.1D, Yesno.Yes)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.Yes)) {
                    } else {
                        setBool("jump", Flagtoggle.No);
                    }
                }
            }
        }
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
            if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "CreepMawTurret", 0.08D, 0.0D, 0.16D, 0.05D, Yesno.No)) {
                            setBool("jump", Flagtoggle.No);
                            setBool("GoBack", Flagtoggle.No);
                        }
                    }
                }
            }
        }
        if (isInNamedArea("AREAHOME_0", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME_1", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, -0.65D, 0.35D, 0.1D, Yesno.No, Yesno.Yes)) {
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    setBool("GoForward", Flagtoggle.No);
                    setBool("GoBack", Flagtoggle.Yes);
                } else {
                    setBool("GoBack", Flagtoggle.No);
                    setBool("GoForward", Flagtoggle.Yes);
                }
            }
        }
        if (isInNamedArea("REGENHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    setBool("GoForward", Flagtoggle.No);
                    setBool("GoBack", Flagtoggle.No);
                }
            }
        }
        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange3")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 3.0D, 2.9D, Yesno.Yes)) {
                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage3")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    setBool("GoBack", Flagtoggle.Yes);
                                    setBool("GoForward", Flagtoggle.No);
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                    setBool("GoBack", Flagtoggle.No);
                                }
                            }
                        } else {
                            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage2")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 800.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("GoBack", Flagtoggle.Yes);
                                        setBool("GoForward", Flagtoggle.No);
                                    } else {
                                        setBool("GoForward", Flagtoggle.Yes);
                                        setBool("GoBack", Flagtoggle.No);
                                    }
                                }
                            } else {
                                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage1")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.No);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                            setBool("GoBack", Flagtoggle.No);
                                        }
                                    }
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.No);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                            setBool("GoBack", Flagtoggle.No);
                                        }
                                    }
                                }
                            }
                        }
                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                            if (random("2")) {
                                if (random("3")) {
                                    // jump
                                    pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                } else {
                                    // jump
                                    pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                }
                            } else {
                                if (random("3")) {
                                    sequence37();
                                } else {
                                    sequence38();
                                }
                            }
                        }
                    }
                } else {
                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange2")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.6D, 2.5D, Yesno.Yes)) {
                            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage3")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        setBool("GoBack", Flagtoggle.Yes);
                                        setBool("GoForward", Flagtoggle.No);
                                    } else {
                                        setBool("GoForward", Flagtoggle.Yes);
                                        setBool("GoBack", Flagtoggle.No);
                                    }
                                }
                            } else {
                                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage2")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 800.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.No);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                            setBool("GoBack", Flagtoggle.No);
                                        }
                                    }
                                } else {
                                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage1")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                                setBool("GoForward", Flagtoggle.No);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                                setBool("GoBack", Flagtoggle.No);
                                            }
                                        }
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                                setBool("GoForward", Flagtoggle.No);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                                setBool("GoBack", Flagtoggle.No);
                                            }
                                        }
                                    }
                                }
                            }
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                if (random("2")) {
                                    if (random("3")) {
                                        // jump
                                        pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                    } else {
                                        // jump
                                        pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                    }
                                } else {
                                    if (random("3")) {
                                        sequence39();
                                    } else {
                                        sequence40();
                                    }
                                }
                            }
                        }
                    } else {
                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange1")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.2D, 2.1D, Yesno.Yes)) {
                                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage3")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.No);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                            setBool("GoBack", Flagtoggle.No);
                                        }
                                    }
                                } else {
                                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage2")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 800.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                                setBool("GoForward", Flagtoggle.No);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                                setBool("GoBack", Flagtoggle.No);
                                            }
                                        }
                                    } else {
                                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                    setBool("GoBack", Flagtoggle.Yes);
                                                    setBool("GoForward", Flagtoggle.No);
                                                } else {
                                                    setBool("GoForward", Flagtoggle.Yes);
                                                    setBool("GoBack", Flagtoggle.No);
                                                }
                                            }
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                    setBool("GoBack", Flagtoggle.Yes);
                                                    setBool("GoForward", Flagtoggle.No);
                                                } else {
                                                    setBool("GoForward", Flagtoggle.Yes);
                                                    setBool("GoBack", Flagtoggle.No);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    if (random("2")) {
                                        if (random("3")) {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                        } else {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                        }
                                    } else {
                                        if (random("3")) {
                                            sequence41();
                                        } else {
                                            sequence42();
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.8D, 1.7D, Yesno.Yes)) {
                                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage3")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 900.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            setBool("GoBack", Flagtoggle.Yes);
                                            setBool("GoForward", Flagtoggle.No);
                                        } else {
                                            setBool("GoForward", Flagtoggle.Yes);
                                            setBool("GoBack", Flagtoggle.No);
                                        }
                                    }
                                } else {
                                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage2")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 800.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                setBool("GoBack", Flagtoggle.Yes);
                                                setBool("GoForward", Flagtoggle.No);
                                            } else {
                                                setBool("GoForward", Flagtoggle.Yes);
                                                setBool("GoBack", Flagtoggle.No);
                                            }
                                        }
                                    } else {
                                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                    setBool("GoBack", Flagtoggle.Yes);
                                                    setBool("GoForward", Flagtoggle.No);
                                                } else {
                                                    setBool("GoForward", Flagtoggle.Yes);
                                                    setBool("GoBack", Flagtoggle.No);
                                                }
                                            }
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                                    setBool("GoBack", Flagtoggle.Yes);
                                                    setBool("GoForward", Flagtoggle.No);
                                                } else {
                                                    setBool("GoForward", Flagtoggle.Yes);
                                                    setBool("GoBack", Flagtoggle.No);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    if (random("2")) {
                                        if (random("3")) {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                        } else {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                        }
                                    } else {
                                        if (random("3")) {
                                            sequence43();
                                        } else {
                                            sequence44();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isInNamedArea("WORM_BUTTON", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("WORM_BUTTON", Ownenemy.ENEMY_TEAM, Targetself.Target)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, -0.3D, 0.6D, 0.4D, Yesno.No, Yesno.No)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            }
        }
        // Don't stand too close to turret with ink
        if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))&&checkCounter("state", "8", Valuecompare.Equal)) {
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.1D, 0.0D, 0.2D, 0.1D, Yesno.No)) {
                    setBool("GoBack", Flagtoggle.Yes);
                    setBool("GoForward", Flagtoggle.No);
                } else {
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, -0.1D, 0.0D, 0.2D, 0.1D, Yesno.No)) {
                        setBool("GoForward", Flagtoggle.Yes);
                        setBool("GoBack", Flagtoggle.No);
                    }
                }
            }
        }
        setBool("stopInk", Flagtoggle.No);
        // Clunk explode handling
        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
            if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.3D, 0.0D, 0.6D, 1.0D, Yesno.No)) {
                    setBool("GoBack", Flagtoggle.Yes);
                    setBool("GoForward", Flagtoggle.No);
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.2D, 0.0D, 0.4D, 1.0D, Yesno.No)) {
                        if (checkCharacterFlag(Characterflags.IsStunned, Yesno.No, Targetself.Self)) {
                            setBool("stopInk", Flagtoggle.Yes);
                        }
                    }
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 1.0D, Yesno.No)) {
                        setBool("GoForward", Flagtoggle.Yes);
                        setBool("GoBack", Flagtoggle.No);
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", -0.2D, 0.0D, 0.4D, 1.0D, Yesno.No)) {
                            if (checkCharacterFlag(Characterflags.IsStunned, Yesno.No, Targetself.Self)) {
                                setBool("stopInk", Flagtoggle.Yes);
                            }
                        }
                    }
                }
                if ((checkClass(Targetself.Target, "Tank")&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    // greens
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        } else {
                            if (isInNamedArea("aboveHazardAreaEnabled", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            } else {
                                setBool("DownJump", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                        } else {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                setBool("jump", Flagtoggle.Yes);
                            } else {
                                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                    // float
                                    pressButton(Buttons.FACE_BOTTOM, 0.12D);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Jump over gaps (eg. mid Aiguillion)
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            if (isNextWaypointPosition(Offsetposition.FRONT)) {
                if (isNextWaypointPosition(Offsetposition.BELOW)) {
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.11D, -0.09D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                    } else {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.02D, 0.12D, Yesno.No, Yesno.Yes)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                adjustMissionCounter("stuck", "1", Valueadjust.Add);
            } else {
                adjustMissionCounter("stuck", "0", Valueadjust.Set);
            }
        } else {
            adjustMissionCounter("stuck", "0", Valueadjust.Set);
        }
        if (checkCounter("stuck", "5", Valuecompare.GreaterOrEqual)) {
            adjustMissionCounter("stuck", "0", Valueadjust.Set);
            setBool("jump", Flagtoggle.Yes);
        }
        // fix for flaky downjump
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            if (getBoolEquals("DownJump", Yesno.No)) {
                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 1.8D, 0.85D, Yesno.No, Yesno.Yes)) {
                        setBool("DownJump", Flagtoggle.Yes);
                    }
                }
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
                    if (timer(Timeunits.Seconds, 0.31D, Yesno.Yes)) {
                        setBool("jump", Flagtoggle.No);
                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                    if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.35D, 0.2D, Yesno.No)) {
                                        sequence45();
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                                sequence46();
                                            } else {
                                                sequence47();
                                            }
                                        } else {
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                                // jump
                                                pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                            } else {
                                                // jump
                                                pressButton(Buttons.FACE_BOTTOM, 0.25D);
                                            }
                                        }
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                                        if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                        } else {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.25D);
                                        }
                                    } else {
                                        if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                        } else {
                                            // jump
                                            pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                        }
                                    }
                                }
                            } else {
                                // check walls above
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.2D, 0.39D, 0.3D, 0.02D, Yesno.No, Yesno.No)) {
                                    // jump
                                    pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                } else {
                                    // jump
                                    pressButton(Buttons.FACE_BOTTOM, 0.3D);
                                }
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
                        if (isInNamedArea("aboveHazardAreaEnabled", Ownenemy.OWN_TEAM, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.Less, Targetself.Self)) {
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
                                    // check walls
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.04D, 0.05D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.02D, Yesno.No, Yesno.No)) {
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
        // Kill (and jump over) Shaman wall!
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepShamanWall", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.05D, 0.0D, 0.15D, 0.08D, Yesno.No)) {
            pressButton(Buttons.FACE_LEFT, 0.0D);
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                pressButton(Buttons.FACE_BOTTOM, 0.3D);
            }
        }
        if (isInNamedArea("hazardAreaEnabled", Ownenemy.OWN_TEAM, Targetself.Self)) {
        } else {
            if (((checkClass(Targetself.Target, "CreepCritterRibbit4")||checkClass(Targetself.Target, "CreepCritterSorona"))||checkClass(Targetself.Target, "CreepCritterAIStation404"))||checkClass(Targetself.Target, "CreepCritterCrab")) {
            } else {
                // Floating
                if (isOnGround(Yesno.No, Targetself.Self)) {
                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                    } else {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                                    if (isTargetType(Yesno.No, EnumSet.of(TargetGroups.CREEPS))) {
                                        if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Captain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.15D, 0.15D, Yesno.No)) {
                                                if (random("6")) {
                                                    pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                                }
                                            } else {
                                                pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // Below
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 250.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes, Yesno.No)) {
                                    if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                                    } else {
                                        // no greens below
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.2D, 0.05D, 0.33D, Yesno.No, Yesno.No)) {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                                                pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                            }
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Captain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.15D, 0.15D, Yesno.No)) {
                                                if (random("4")) {
                                                    pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                                }
                                            } else {
                                                pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                        if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")||isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                            if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.3D, 0.6D, 0.45D, Yesno.Yes, Yesno.Yes)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.0D, -0.06D, 0.01D, 0.12D, Yesno.No, Yesno.No)) {
                                    } else {
                                        if (isButtonDown(Buttons.FACE_BOTTOM)) {
                                        } else {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                                pressButton(Buttons.FACE_BOTTOM, 0.23D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // Float besides turrets
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                        if (isButtonDown(Buttons.FACE_BOTTOM)) {
                        } else {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.75D, 0.75D, Yesno.Yes)) {
                                pressButton(Buttons.FACE_BOTTOM, 0.23D);
                            }
                        }
                    }
                }
            }
        }
        if (isOnGround(Yesno.No, Targetself.Self)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.2D, 0.1D, 0.02D, Yesno.No, Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarBoss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.08D, 0.0D, 0.16D, 0.1D, Yesno.Yes)) {
                } else {
                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                }
            }
        }
        // extra droid clear incentive
        if (hasTarget(Yesno.Yes)) {
        } else {
            if (((getBoolEquals("unsafe", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
            } else {
                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.2D, 1.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
            }
        }
        // extrea chase incentive
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                } else {
                    if (((getBoolEquals("unsafe", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.Yes, Yesno.Yes)) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    adjustCounter("setState", "4", Valueadjust.Set);
                                } else {
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes, Yesno.Yes)) {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                adjustCounter("setState", "4", Valueadjust.Set);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)) {
                    } else {
                        if (((getBoolEquals("unsafe", Yesno.Yes)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.Yes, Yesno.Yes)) {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    } else {
                                        if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)&&directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
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

    @Script.Sequence(blocking = false)
    void sequence0() {
        aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.3D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.3D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.3D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence11() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence12() {
        aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.3D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence13() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence14() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence15() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence16() {
        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.15D, 0.15D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.Yes);
        if (hasTarget(Yesno.Yes)) {
            sequence17();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence17() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
    }

    @Script.Sequence(blocking = true)
    void sequence18() {
        pressButton(Buttons.FACE_BOTTOM, 0.01D);
        wait(0.15D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence19() {
        if (isTargetInArea(Yesno.Yes, 0.08D, 0.0D, 0.16D, 0.2D, Yesno.No, Yesno.Yes)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.1D, 0.1D, 0.2D, Yesno.No, Yesno.No)) {
            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 0.5D, 0.1D, Yesno.No)) {
                setBool("anchorTime", Flagtoggle.No);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                        if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE3")) {
                                if (getBoolEquals("hitOnce", Yesno.No)) {
                                    if (random("4")) {
                                        setBool("anchorTime", Flagtoggle.No);
                                    }
                                } else {
                                    setBool("hitOnce", Flagtoggle.No);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE2")) {
                                    if (getBoolEquals("hitOnce", Yesno.No)) {
                                        if (random("3")) {
                                            setBool("anchorTime", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("hitOnce", Flagtoggle.No);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "CAPTAINHITDAMAGE1")) {
                                        if (random("2")) {
                                            setBool("anchorTime", Flagtoggle.No);
                                        }
                                    } else {
                                        if (random("3")) {
                                        } else {
                                            setBool("anchorTime", Flagtoggle.No);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    setBool("anchorTime", Flagtoggle.No);
                }
            }
        } else {
            setBool("anchorTime", Flagtoggle.No);
        }
        if (isUpgradeEnabled(Yesno.No, "CaptainHookStun1")) {
            if ((((((checkClass(Targetself.Target, "Blazer")||checkClass(Targetself.Target, "Dasher"))||checkClass(Targetself.Target, "Maw"))||checkClass(Targetself.Target, "Chameleon"))||checkClass(Targetself.Target, "Cowboy"))||checkClass(Targetself.Target, "Hunter"))||checkClass(Targetself.Target, "Assassin")) {
                setBool("anchorTime", Flagtoggle.No);
            }
        }
        if (getBoolEquals("anchorTime", Yesno.No)) {
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
            } else {
                if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.Yes)) {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.25D, 0.05D, 0.1D, Yesno.No, Yesno.No)) {
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.Yes, Yesno.Yes, null, "", 0.08D, -0.05D, 0.01D, 0.01D, Yesno.No, Yesno.No)&&isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        } else {
                            setBool("anchorTime", Flagtoggle.Yes);
                            setBool("hitOnce", Flagtoggle.Yes);
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.Less, Targetself.Self)) {
                                sequence20();
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.Less, Targetself.Self)) {
                                    sequence21();
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.Less, Targetself.Self)) {
                                        sequence22();
                                    } else {
                                        sequence23();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence20() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence21() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence22() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence23() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence24() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence25() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence26() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence27() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence28() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence29() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence30() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence31() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_TOP, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence32() {
        setBool("lowerInkRange", Flagtoggle.Yes);
        wait(1.5D);
        setBool("lowerInkRange", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence33() {
        if (checkCounter("state", "1", Valuecompare.Equal)) {
            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        } else {
            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        pressButton(Buttons.FACE_LEFT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence34() {
        if (checkCounter("state", "1", Valuecompare.Equal)) {
            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        } else {
            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        pressButton(Buttons.FACE_LEFT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence35() {
        if (checkCounter("state", "1", Valuecompare.Equal)) {
            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        } else {
            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        pressButton(Buttons.FACE_LEFT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence36() {
        wait(0.06D);
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence37() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence38() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence39() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence40() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence41() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence42() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence43() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence44() {
        wait(0.25D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence45() {
        wait(0.1D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence46() {
        wait(0.06D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence47() {
        wait(0.22D);
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.1D);
    }

}

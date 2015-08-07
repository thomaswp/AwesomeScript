
package com.awesomescript;

import java.util.EnumSet;

public class AIBotShaman
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Shaman");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // lightling rod
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (hasTarget(Yesno.Yes)) {
                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes, Yesno.Yes)) {
                        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                }
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.4D, 0.3D, Yesno.Yes, Yesno.No)) {
                    // attack
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
            // back away from people who are too close
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.55D, 0.55D, Yesno.No)) {
                setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                setBool("RetreatingFromNauts", Flagtoggle.Yes);
            }
        }
        // Sawblade!
        if (isUpgradeEnabled(Yesno.Yes, "ShamanSpirit")) {
            if (getBoolEquals("sawbladeOut", Yesno.No)) {
                if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                        if (hasTarget(Yesno.Yes)) {
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                } else {
                                    // use sawblade badly if dumb
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                sequence0();
                                            } else {
                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                    sequence1();
                                                } else {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                        sequence2();
                                                    } else {
                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.1D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                            sequence3();
                                                        } else {
                                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.4D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                                sequence4();
                                                            } else {
                                                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.8D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                                    sequence5();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                                sequence6();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    setBool("sawbladeFront", Flagtoggle.Yes);
                    setBool("sawbladeBehind", Flagtoggle.No);
                } else {
                    setBool("sawbladeBehind", Flagtoggle.Yes);
                    setBool("sawbladeFront", Flagtoggle.No);
                }
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    // check every 20 ticks if i want to return sawblade
                    if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                        if (getBoolEquals("sawbladeReady", Yesno.Yes)) {
                            if (getBoolEquals("sawbladeFront", Yesno.Yes)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                    } else {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                            if (random("10")) {
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                            }
                                        }
                                    }
                                } else {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                        pressButton(Buttons.FACE_RIGHT, 0.0D);
                                    } else {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                            if (random("10")) {
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (getBoolEquals("sawbladeBehind", Yesno.Yes)) {
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        } else {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                                if (random("10")) {
                                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                }
                                            }
                                        }
                                    } else {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        } else {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.3D, 0.0D, 0.3D, 0.6D, Yesno.No, Yesno.No)) {
                                                if (random("10")) {
                                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
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
        // Totem!
        if (isUpgradeEnabled(Yesno.Yes, "ShamanWall")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.DESTROYABLE_OBSTACLES))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.8D, 0.5D, Yesno.Yes, Yesno.No)) {
                            // if really dumb: always charge totem fully and dont move
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Greater, Targetself.Self)) {
                                        aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    }
                                    pressButton(Buttons.FACE_TOP, 0.6D);
                                    setBool("DontMove", Flagtoggle.Yes);
                                }
                            } else {
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                    aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                } else {
                                    if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                            if (hasTarget(Yesno.Yes)) {
                                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            } else {
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    } else {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))&&checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_TOP, 0.4D);
                                            } else {
                                                aimStickAtTarget(0.22D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_TOP, 0.22D);
                                            }
                                        } else {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                                aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_TOP, 0.4D);
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
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "ShamanSpirit")) {
                    if (canPayUpgrade("ShamanSpirit")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                        }
                        buyUpgrade("ShamanSpirit");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ShamanWall")) {
                    if (canPayUpgrade("ShamanWall")) {
                        buyUpgrade("ShamanWall");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ShamanSpiritDamage1")) {
                    if (canPayUpgrade("ShamanSpiritDamage1")) {
                        buyUpgrade("ShamanSpiritDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ShamanSpiritDamage2")) {
                    if (canPayUpgrade("ShamanSpiritDamage2")) {
                        buyUpgrade("ShamanSpiritDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ShamanSpiritDamage3")) {
                    if (canPayUpgrade("ShamanSpiritDamage3")) {
                        buyUpgrade("ShamanSpiritDamage3");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ShamanSpiritSize1")) {
                    if (canPayUpgrade("ShamanSpiritSize1")) {
                        buyUpgrade("ShamanSpiritSize1");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    // buy regen early
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
                if (isUpgradeEnabled(Yesno.Yes, "ShamanSpiritDamage3")) {
                    if (isUpgradeEnabled(Yesno.No, "ShamanSpiritLifesteal1")) {
                        if (canPayUpgrade("ShamanSpiritLifesteal1")) {
                            buyUpgrade("ShamanSpiritLifesteal1");
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "Alldamage")) {
                                if (canPayUpgrade("Alldamage")) {
                                    buyUpgrade("Alldamage");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "Alldamage2")) {
                                    if (canPayUpgrade("Alldamage2")) {
                                        buyUpgrade("Alldamage2");
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
                        if (isUpgradeEnabled(Yesno.No, "ShamanShootDamage1")) {
                            if (canPayUpgrade("ShamanShootDamage1")) {
                                buyUpgrade("ShamanShootDamage1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanShootDamage2")) {
                            if (canPayUpgrade("ShamanShootDamage2")) {
                                buyUpgrade("ShamanShootDamage2");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanShootDamage3")) {
                            if (canPayUpgrade("ShamanShootDamage3")) {
                                buyUpgrade("ShamanShootDamage3");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanShootAttackspeed1")) {
                            if (canPayUpgrade("ShamanShootAttackspeed1")) {
                                buyUpgrade("ShamanShootAttackspeed1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanShootAttackspeed2")) {
                            if (canPayUpgrade("ShamanShootAttackspeed2")) {
                                buyUpgrade("ShamanShootAttackspeed2");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.Yes, "ShamanShootAttackspeed2")) {
                            if (isUpgradeEnabled(Yesno.No, "ShamanShootSlow1")) {
                                if (canPayUpgrade("ShamanShootSlow1")) {
                                    buyUpgrade("ShamanShootSlow1");
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanWallHeight1")) {
                            if (canPayUpgrade("ShamanWallHeight1")) {
                                buyUpgrade("ShamanWallHeight1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanWallHealth1")) {
                            if (canPayUpgrade("ShamanWallHealth1")) {
                                buyUpgrade("ShamanWallHealth1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanWallHealth2")) {
                            if (canPayUpgrade("ShamanWallHealth2")) {
                                buyUpgrade("ShamanWallHealth2");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanWallCooldown1")) {
                            if (canPayUpgrade("ShamanWallCooldown1")) {
                                buyUpgrade("ShamanWallCooldown1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ShamanWallCooldown2")) {
                            if (canPayUpgrade("ShamanWallCooldown2")) {
                                buyUpgrade("ShamanWallCooldown2");
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
        // Hover
        if (isOnGround(Yesno.No, Targetself.Self)) {
            // am i in fire?
            if (isInNamedArea("HAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                } else {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                        if ((isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW))||isTargetPosition(Yesno.Yes, Offsetposition.HORIZONTALEQUAL)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes, Yesno.No)) {
                                pressButton(Buttons.FACE_BOTTOM, 0.25D);
                            }
                        }
                    }
                }
                if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (timer(Timeunits.Seconds, 1.5D, Yesno.Yes)) {
                        pressButton(Buttons.FACE_BOTTOM, 0.65D);
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(0.3D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(0.6D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(0.8D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(1.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(1.2D);
        setBool("sawbladeReady", Flagtoggle.Yes);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
        setBool("sawbladeReady", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        setBool("sawbladeOut", Flagtoggle.Yes);
        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        wait(5.0D);
        setBool("sawbladeOut", Flagtoggle.No);
    }

}

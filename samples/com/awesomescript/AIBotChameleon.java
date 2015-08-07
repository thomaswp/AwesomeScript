
package com.awesomescript;

import java.util.EnumSet;

public class AIBotChameleon
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Chameleon");
        executeBehaviourTree("VeankoAI");
        // staby staby
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (getBoolEquals("Backdooring", Yesno.No)) {
                if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                    if (hasTarget(Yesno.Yes)) {
                        if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.15D, Yesno.Yes, Yesno.Yes)) {
                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // attack
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.3D, 0.15D, Yesno.Yes, Yesno.No)) {
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.15D, Yesno.Yes, Yesno.Yes)) {
                        if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                        } else {
                            if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                            } else {
                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // attack
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    }
                }
            }
        }
        // Tongue
        if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
            if (getBoolEquals("dontTongue", Yesno.No)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    } else {
                        // Tongue into towers and teammates
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            if (hasTarget(Yesno.No)||isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                                if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueRange")) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.82D, 0.82D, Yesno.Yes, Yesno.No)) {
                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.82D, 0.82D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                setBool("usedTongue", Flagtoggle.Yes);
                                            }
                                        }
                                    } else {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                setBool("usedTongue", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                            if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                    if (getBoolEquals("TargetInKillRange", Yesno.Yes)) {
                                        if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueRange")) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.82D, 0.82D, Yesno.Yes, Yesno.Yes)) {
                                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                                    aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                    setBool("usedTongue", Flagtoggle.Yes);
                                                }
                                            }
                                        } else {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                                    aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                    setBool("usedTongue", Flagtoggle.Yes);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueRange")) {
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.82D, 0.82D, Yesno.Yes, Yesno.Yes)) {
                                        if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                            // use tongue badly if dumb
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                setBool("usedTongue", Flagtoggle.Yes);
                                            } else {
                                                setBool("DontMove", Flagtoggle.Yes);
                                                // if super dumb: wait before using tongue
                                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                                    sequence0();
                                                } else {
                                                    // if less dumb: wait a little less
                                                    sequence1();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                        if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                            // use tongue badly if dumb
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                setBool("usedTongue", Flagtoggle.Yes);
                                            } else {
                                                setBool("DontMove", Flagtoggle.Yes);
                                                // if super dumb: wait before using tongue
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
        // Stealth
        if (isUpgradeEnabled(Yesno.Yes, "stealth")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    // am i in stealth
                    if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                        // only use stealth to retreat if dumb
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                            // is target nearby?
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                                    // go into stealth
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            } else {
                                // go into stealth
                                pressButton(Buttons.FACE_TOP, 0.0D);
                            }
                        } else {
                            if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    // go into stealth
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            }
                        }
                        setBool("Backdooring", Flagtoggle.No);
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                            } else {
                                if (getBoolEquals("usedTongue", Yesno.No)) {
                                    if (getBoolEquals("dontTongue", Yesno.No)) {
                                        if (getBoolEquals("Backdooring", Yesno.No)) {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                                if ((isTurretInArea(EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.5D, 1.0D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes)) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueRange")) {
                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.82D, 0.82D, Yesno.Yes, Yesno.Yes)) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
                                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                                            }
                                                        }
                                                    } else {
                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongue")) {
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
                            // Backdoor logic
                            if (getBoolEquals("Backdooring", Yesno.No)) {
                                if (getBoolEquals("BaseCanBeReached", Yesno.Yes)) {
                                    if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    } else {
                                        if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                            if (getBoolEquals("AttackingBase", Yesno.Yes)) {
                                            } else {
                                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                                } else {
                                                    setBool("Backdooring", Flagtoggle.Yes);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (((((((isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No))||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||getBoolEquals("AttackingBase", Yesno.Yes)) {
                                    setBool("Backdooring", Flagtoggle.No);
                                }
                                if (hasTarget(Yesno.Yes)) {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                                        removeTarget();
                                    }
                                }
                                adjustCounter("setState", "3", Valueadjust.Set);
                                selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                if (timer(Timeunits.Seconds, 1.0D, Yesno.Yes)) {
                                    log("BACKDOORING THEIR BASE", "", "Backdooring");
                                }
                            }
                        }
                    }
                }
            }
        }
        if (getBoolEquals("usedTongue", Yesno.Yes)) {
            if (timer(Timeunits.Seconds, 7.0D, Yesno.No)) {
                setBool("usedTongue", Flagtoggle.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE4")&&isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE3")) {
            if (checkCharacterValue(CharactervaluesCheckable.Health, 600.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                // target can be one shotted
                setBool("TargetInKillRange", Flagtoggle.Yes);
            } else {
                setBool("TargetInKillRange", Flagtoggle.No);
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE4")||isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE3")) {
                if (checkCharacterValue(CharactervaluesCheckable.Health, 420.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // target can be one shotted
                    setBool("TargetInKillRange", Flagtoggle.Yes);
                } else {
                    setBool("TargetInKillRange", Flagtoggle.No);
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE2")) {
                    if (checkCharacterValue(CharactervaluesCheckable.Health, 360.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        // target can be one shotted
                        setBool("TargetInKillRange", Flagtoggle.Yes);
                    } else {
                        setBool("TargetInKillRange", Flagtoggle.No);
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE1")) {
                    if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        // target can be one shotted
                        setBool("TargetInKillRange", Flagtoggle.Yes);
                    } else {
                        setBool("TargetInKillRange", Flagtoggle.No);
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.Health, 240.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        // target can be one shotted
                        setBool("TargetInKillRange", Flagtoggle.Yes);
                    } else {
                        setBool("TargetInKillRange", Flagtoggle.No);
                    }
                }
            }
        }
        // dont tongue exploding clunk
        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                        setBool("dontTongue", Flagtoggle.Yes);
                    }
                }
            }
        }
        // dont tongue mad ayla
        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodthirstOn")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 25.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                        setBool("dontTongue", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (getBoolEquals("dontTongue", Yesno.Yes)) {
            if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")||hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodthirstOn")) {
            } else {
                setBool("dontTongue", Flagtoggle.No);
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "CHAMELEONTONGUE")) {
                    if (canPayUpgrade("CHAMELEONTONGUE")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 40.0D, Valueadjust.Add);
                        }
                        buyUpgrade("CHAMELEONTONGUE");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                        // buy regen early if gnaw is on the enemy team
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.Gold, 800.0D, Valuecompare.Less, Targetself.Self)) {
                                if (isUpgradeEnabled(Yesno.No, "Piggybank")) {
                                    if (canPayUpgrade("Piggybank")) {
                                        buyUpgrade("Piggybank");
                                    }
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "ChameleonSpeed")) {
                        if (canPayUpgrade("ChameleonSpeed")) {
                            buyUpgrade("ChameleonSpeed");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CHAMELEONTONGUEDAMAGE4")) {
                    if (canPayUpgrade("CHAMELEONTONGUEDAMAGE4")) {
                        buyUpgrade("CHAMELEONTONGUEDAMAGE4");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
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
                if (isUpgradeEnabled(Yesno.No, "ChameleonTongueDamage1")) {
                    if (canPayUpgrade("ChameleonTongueDamage1")) {
                        buyUpgrade("ChameleonTongueDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ChameleonTongueDamage2")) {
                    if (canPayUpgrade("ChameleonTongueDamage2")) {
                        buyUpgrade("ChameleonTongueDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CHAMELEONTONGUEDAMAGE3")) {
                    if (canPayUpgrade("CHAMELEONTONGUEDAMAGE3")) {
                        buyUpgrade("CHAMELEONTONGUEDAMAGE3");
                    }
                }
                if ((((((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blinker"))||isUpgradeEnabled(Yesno.Yes, "ChameleonTongueSilence1")) {
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONTONGUERANGE1")) {
                        if (isUpgradeEnabled(Yesno.No, "ChameleonTongueSilence1")) {
                            if (canPayUpgrade("ChameleonTongueSilence1")) {
                                buyUpgrade("ChameleonTongueSilence1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "ChameleonTongueSilence2")) {
                            if (canPayUpgrade("ChameleonTongueSilence2")) {
                                buyUpgrade("ChameleonTongueSilence2");
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "ChameleonTongueSilence1")) {
                        if (isUpgradeEnabled(Yesno.No, "CHAMELEONTONGUERANGE1")) {
                            if (canPayUpgrade("CHAMELEONTONGUERANGE1")) {
                                buyUpgrade("CHAMELEONTONGUERANGE1");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "Stealth")) {
                    if (canPayUpgrade("Stealth")) {
                        buyUpgrade("Stealth");
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "CHAMELEONTONGUEDAMAGE4")) {
                    if (isUpgradeEnabled(Yesno.No, "ChameleonHitDamage1")) {
                        if (canPayUpgrade("ChameleonHitDamage1")) {
                            buyUpgrade("ChameleonHitDamage1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONHITDAMAGE2")) {
                        if (canPayUpgrade("CHAMELEONHITDAMAGE2")) {
                            buyUpgrade("CHAMELEONHITDAMAGE2");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONHITATTACKSPEED1")) {
                        if (canPayUpgrade("CHAMELEONHITATTACKSPEED1")) {
                            buyUpgrade("CHAMELEONHITATTACKSPEED1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "ChameleonHitAttackspeed2")) {
                        if (canPayUpgrade("ChameleonHitAttackspeed2")) {
                            buyUpgrade("ChameleonHitAttackspeed2");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONHITDAMAGE3")) {
                        if (canPayUpgrade("CHAMELEONHITDAMAGE3")) {
                            buyUpgrade("CHAMELEONHITDAMAGE3");
                        }
                    }
                    if (random("2")) {
                        if (isUpgradeEnabled(Yesno.No, "ChameleonHitLifesteal1")) {
                            if (isUpgradeEnabled(Yesno.No, "ChameleonHitCrit")) {
                                if (canPayUpgrade("ChameleonHitCrit")) {
                                    buyUpgrade("ChameleonHitCrit");
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "ChameleonHitCrit")) {
                            if (isUpgradeEnabled(Yesno.No, "ChameleonHitLifesteal1")) {
                                if (canPayUpgrade("ChameleonHitLifesteal1")) {
                                    buyUpgrade("ChameleonHitLifesteal1");
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitCrit")) {
                        if (isUpgradeEnabled(Yesno.No, "ChameleonHitCrit2")) {
                            if (canPayUpgrade("ChameleonHitCrit2")) {
                                buyUpgrade("ChameleonHitCrit2");
                            }
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
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONSTEALTHSURPRISE1")) {
                        if (canPayUpgrade("CHAMELEONSTEALTHSURPRISE1")) {
                            buyUpgrade("CHAMELEONSTEALTHSURPRISE1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "ChameleonStealthSurprise2")) {
                        if (canPayUpgrade("ChameleonStealthSurprise2")) {
                            buyUpgrade("ChameleonStealthSurprise2");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "ChameleonStealthCloneWalk")) {
                        if (canPayUpgrade("ChameleonStealthCloneWalk")) {
                            buyUpgrade("ChameleonStealthCloneWalk");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "CHAMELEONSTEALTHCLONEATTACK")) {
                        if (canPayUpgrade("CHAMELEONSTEALTHCLONEATTACK")) {
                            buyUpgrade("CHAMELEONSTEALTHCLONEATTACK");
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
        setBool("usedTongue", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedTongue", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedTongue", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        aimStickAtTarget(0.4D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        wait(0.2D);
        pressButton(Buttons.FACE_RIGHT, 0.0D);
        setBool("usedTongue", Flagtoggle.Yes);
    }

}

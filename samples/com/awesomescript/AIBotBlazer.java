
package com.awesomescript;

import java.util.EnumSet;

public class AIBotBlazer
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Blazer", Flagtoggle.Yes);
        }
        // Skill Initialization
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            adjustCounter("SkillLevel", "3", Valueadjust.Set);
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                adjustCounter("SkillLevel", "2", Valueadjust.Set);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.19D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    adjustCounter("SkillLevel", "1", Valueadjust.Set);
                } else {
                    adjustCounter("SkillLevel", "0", Valueadjust.Set);
                }
            }
        }
        // copy this code into your bot
        if (isButtonDown(Buttons.FACE_BOTTOM)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
            }
        }
        // Retreat on Low Health
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 59.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // returnToUpgrade
                    adjustCounter("setState", "10", Valueadjust.Set);
                } else {
                    // retreatHP
                    adjustCounter("setState", "1", Valueadjust.Set);
                }
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 39.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        // returnToUpgrade
                        adjustCounter("setState", "10", Valueadjust.Set);
                    } else {
                        // retreatHP
                        adjustCounter("setState", "1", Valueadjust.Set);
                    }
                }
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 19.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            // returnToUpgrade
                            adjustCounter("setState", "10", Valueadjust.Set);
                        } else {
                            // retreatHP
                            adjustCounter("setState", "1", Valueadjust.Set);
                        }
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            // returnToUpgrade
                            adjustCounter("setState", "10", Valueadjust.Set);
                        } else {
                            // retreatHP
                            adjustCounter("setState", "1", Valueadjust.Set);
                        }
                    }
                }
            }
        }
        setBool("willnotkillSolarBoss", Flagtoggle.Yes);
        // Don't fight Solar Boss
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.NEUTRAL_TEAM), "CreepSolarboss", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.Yes)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                removeTarget();
            }
        }
        // Don't hang out in drop pad area
        if (isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            // returnToUpgrade (10)
            adjustCounter("setState", "10", Valueadjust.Set);
        }
        executeBehaviourTree("Blazer");
        executeBehaviourTree("SuperAI_nailcliper");
        // Ball Lightning
        if (isUpgradeEnabled(Yesno.Yes, "Detonator")) {
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                if (getBoolEquals("BlazeOn", Yesno.No)) {
                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                        // Target only Players when Retreating
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                            if (hasTarget(Yesno.Yes)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    sequence0();
                                }
                            }
                        }
                    } else {
                        // Radius = 7.5 Gnaws
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 0.9D, Yesno.No)) {
                            // Priority: Low Health Nauts
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 400.0D, "", 0.0D, 0.0D, 1.5D, 0.9D, Yesno.No)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 0.9D, Valuecompare2 .Less, 40.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                            } else {
                                // Priority: SuperDroid
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.3D, 0.9D, Yesno.No)) {
                                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidSuper", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 0.9D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                } else {
                                    // Priority: Players
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 0.9D, Yesno.No)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 0.9D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                    } else {
                                        // Priority: 2 Dragonflies
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidFlying", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.5D, 0.9D, Yesno.No)) {
                                            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDroidFlying", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                        } else {
                                            // Priority: 2 Droids
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.5D, 0.8D, Yesno.No)) {
                                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                            } else {
                                                // Priority: Weedlings
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 0.9D, Yesno.No)) {
                                                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 0.9D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            // Ball Timing Logic
                            if (hasTarget(Yesno.Yes)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                                    aimStickAtTarget(0.12D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    sequence6();
                                }
                            }
                        }
                    }
                }
            }
        }
        // Blaze
        if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                        pressButton(Buttons.FACE_TOP, 0.01D);
                        // Ball Cooldown Buffer
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength")) {
                            sequence22();
                        } else {
                            sequence23();
                        }
                    }
                } else {
                    // Only Blaze Nauts
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        // Blaze to chase
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                            if ((checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)&&checkCounter("state", "4", Valuecompare.Equal))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDot, 1200.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)&&isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No, Yesno.No)) {
                                    pressButton(Buttons.FACE_TOP, 0.01D);
                                    log("BLAZE IT!", "", "");
                                    // Ball Cooldown Buffer
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength")) {
                                        sequence24();
                                    } else {
                                        sequence25();
                                    }
                                }
                            }
                        }
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.1D, 0.25D, Yesno.No, Yesno.Yes)) {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                pressButton(Buttons.FACE_TOP, 0.01D);
                                // Ball Cooldown Buffer
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength")) {
                                    sequence26();
                                } else {
                                    sequence27();
                                }
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                                pressButton(Buttons.FACE_TOP, 0.01D);
                                // Ball Cooldown Buffer
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength")) {
                                    sequence28();
                                } else {
                                    sequence29();
                                }
                            }
                        }
                    }
                }
            }
        }
        // Shock
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (((checkCounter("state", "6", Valuecompare.Equal)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.25D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.1D, 0.0D, 0.25D, 0.2D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.Yes);
                    if (hasTarget(Yesno.Yes)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.25D, 0.2D, Yesno.Yes, Yesno.No)) {
                            aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.05D, 0.0D, 0.17D, 0.2D, Yesno.Yes, Yesno.No)) {
                                setBool("DontMove", Flagtoggle.Yes);
                            } else {
                                setBool("DontMove", Flagtoggle.No);
                            }
                        }
                        sequence30();
                    }
                }
            }
        }
        // Shop Upgrades
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (checkCounter("SkillLevel", "3", Valuecompare.Equal)) {
                // Base Build
                if (isUpgradeEnabled(Yesno.Yes, "Detonator")) {
                    if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
                        if (isUpgradeEnabled(Yesno.Yes, "Blazerspeed1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "addHealth1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")||isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                        } else {
                                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")||random("3")) {
                                                // Auto Attack build
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                } else {
                                                    if (canPayUpgrade("BlazerShotHoming")) {
                                                        buyUpgrade("BlazerShotHoming");
                                                    }
                                                }
                                            } else {
                                                // Blaze Build
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                                } else {
                                                    if (canPayUpgrade("BlazerBlazeDamage1")) {
                                                        buyUpgrade("BlazerBlazeDamage1");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerBlazeSpeed2")) {
                                            buyUpgrade("BlazerBlazeSpeed2");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("BlazerBlazeSpeed1")) {
                                        buyUpgrade("BlazerBlazeSpeed1");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("addHealth1")) {
                                    buyUpgrade("addHealth1");
                                }
                            }
                        } else {
                            if (canPayUpgrade("Blazerspeed1")) {
                                buyUpgrade("Blazerspeed1");
                            }
                        }
                    } else {
                        if (canPayUpgrade("Blaze")) {
                            buyUpgrade("Blaze");
                        }
                    }
                } else {
                    if (canPayUpgrade("Detonator")) {
                        buyUpgrade("Detonator");
                    }
                    if (once()) {
                        // Perfect Drop
                        adjustCharacterValue(CharactervaluesAdjustable.Gold, 37.0D, Valueadjust.Add);
                        log("WINGS OF SILVER", "", "");
                    }
                }
                // Build Check
                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                    // Blaze Build
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDuration1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDuration2")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage2")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage3")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "healthRegen1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "healthRegen2")) {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallKnockback1")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown1")) {
                                                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown2")) {
                                                                                                } else {
                                                                                                    if (canPayUpgrade("BlazerShotCooldown2")) {
                                                                                                        buyUpgrade("BlazerShotCooldown2");
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                if (canPayUpgrade("BlazerShotCooldown1")) {
                                                                                                    buyUpgrade("BlazerShotCooldown1");
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (canPayUpgrade("BlazerBallDamage3")) {
                                                                                                buyUpgrade("BlazerBallDamage3");
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("BlazerBallDamage2")) {
                                                                                            buyUpgrade("BlazerBallDamage2");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (canPayUpgrade("BlazerBallDamage1")) {
                                                                                        buyUpgrade("BlazerBallDamage1");
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BlazerBallKnockback1")) {
                                                                                    buyUpgrade("BlazerBallKnockback1");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("healthRegen2")) {
                                                                                buyUpgrade("healthRegen2");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("addHealth3")) {
                                                                            buyUpgrade("addHealth3");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("BlazerShotDamage2")) {
                                                                        buyUpgrade("BlazerShotDamage2");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerShotDamage1")) {
                                                                    buyUpgrade("BlazerShotDamage1");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerShotHoming2")) {
                                                                buyUpgrade("BlazerShotHoming2");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerShotHoming")) {
                                                            buyUpgrade("BlazerShotHoming");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBallCooldown1")) {
                                                        buyUpgrade("BlazerBallCooldown1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("healthRegen1")) {
                                                    buyUpgrade("healthRegen1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("addHealth2")) {
                                                buyUpgrade("addHealth2");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerBlazeDamage3")) {
                                            buyUpgrade("BlazerBlazeDamage3");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("BlazerBlazeDamage2")) {
                                        buyUpgrade("BlazerBlazeDamage2");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("BlazerBlazeDuration2")) {
                                    buyUpgrade("BlazerBlazeDuration2");
                                }
                            }
                        } else {
                            if (canPayUpgrade("BlazerBlazeDuration1")) {
                                buyUpgrade("BlazerBlazeDuration1");
                            }
                        }
                    }
                } else {
                    // Auto Attack Build
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "healthRegen1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "healthRegen2")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow1")) {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown1")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow2")) {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown2")) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow3")) {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallKnockback1")) {
                                                                                            } else {
                                                                                                if (canPayUpgrade("BlazerBallKnockback1")) {
                                                                                                    buyUpgrade("BlazerBallKnockback1");
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (canPayUpgrade("BlazerBlazeSlow3")) {
                                                                                                buyUpgrade("BlazerBlazeSlow3");
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("BlazerShotCooldown2")) {
                                                                                            buyUpgrade("BlazerShotCooldown2");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (canPayUpgrade("BlazerBlazeSlow2")) {
                                                                                        buyUpgrade("BlazerBlazeSlow2");
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BlazerShotCooldown1")) {
                                                                                    buyUpgrade("BlazerShotCooldown1");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("BlazerBlazeSlow1")) {
                                                                                buyUpgrade("BlazerBlazeSlow1");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("healthRegen2")) {
                                                                            buyUpgrade("healthRegen2");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("addHealth3")) {
                                                                        buyUpgrade("addHealth3");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerBallDamage3")) {
                                                                    buyUpgrade("BlazerBallDamage3");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerBallDamage2")) {
                                                                buyUpgrade("BlazerBallDamage2");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerBallDamage1")) {
                                                            buyUpgrade("BlazerBallDamage1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBallCooldown1")) {
                                                        buyUpgrade("BlazerBallCooldown1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBlazeLength1")) {
                                                    buyUpgrade("BlazerBlazeLength1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("healthRegen1")) {
                                                buyUpgrade("healthRegen1");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("addHealth2")) {
                                            buyUpgrade("addHealth2");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("BlazerShotDamage2")) {
                                        buyUpgrade("BlazerShotDamage2");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("BlazerShotDamage1")) {
                                    buyUpgrade("BlazerShotDamage1");
                                }
                            }
                        } else {
                            if (canPayUpgrade("BlazerShotHoming2")) {
                                buyUpgrade("BlazerShotHoming2");
                            }
                        }
                    }
                }
            } else {
                if (checkCounter("SkillLevel", "2", Valuecompare.Equal)) {
                    // Base Build
                    if (isUpgradeEnabled(Yesno.Yes, "Detonator")) {
                        if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
                            if (isUpgradeEnabled(Yesno.Yes, "Blazerspeed1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "addHealth1")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed2")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")||isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                            } else {
                                                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")||random("3")) {
                                                    // Auto Attack build
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                    } else {
                                                        if (canPayUpgrade("BlazerShotHoming")) {
                                                            buyUpgrade("BlazerShotHoming");
                                                        }
                                                    }
                                                } else {
                                                    // Blaze Build
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                                    } else {
                                                        if (canPayUpgrade("BlazerBlazeDamage1")) {
                                                            buyUpgrade("BlazerBlazeDamage1");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerBlazeSpeed2")) {
                                                buyUpgrade("BlazerBlazeSpeed2");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerBlazeSpeed1")) {
                                            buyUpgrade("BlazerBlazeSpeed1");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("addHealth1")) {
                                        buyUpgrade("addHealth1");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("Blazerspeed1")) {
                                    buyUpgrade("Blazerspeed1");
                                }
                            }
                        } else {
                            if (canPayUpgrade("Blaze")) {
                                buyUpgrade("Blaze");
                            }
                        }
                    } else {
                        if (canPayUpgrade("Detonator")) {
                            buyUpgrade("Detonator");
                        }
                        if (once()) {
                            // Perfect Drop
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 37.0D, Valueadjust.Add);
                            log("WINGS OF SILVER", "", "");
                        }
                    }
                    // Build Check
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                        // Blaze Build
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDuration1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDuration2")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallKnockback1")) {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown1")) {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown2")) {
                                                                                            } else {
                                                                                                if (canPayUpgrade("BlazerShotCooldown2")) {
                                                                                                    buyUpgrade("BlazerShotCooldown2");
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (canPayUpgrade("BlazerShotCooldown1")) {
                                                                                                buyUpgrade("BlazerShotCooldown1");
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("BlazerBallDamage3")) {
                                                                                            buyUpgrade("BlazerBallDamage3");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (canPayUpgrade("BlazerBallDamage2")) {
                                                                                        buyUpgrade("BlazerBallDamage2");
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BlazerBallDamage1")) {
                                                                                    buyUpgrade("BlazerBallDamage1");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("BlazerBallKnockback1")) {
                                                                                buyUpgrade("BlazerBallKnockback1");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("addHealth3")) {
                                                                            buyUpgrade("addHealth3");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("BlazerShotDamage2")) {
                                                                        buyUpgrade("BlazerShotDamage2");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerShotDamage1")) {
                                                                    buyUpgrade("BlazerShotDamage1");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerShotHoming2")) {
                                                                buyUpgrade("BlazerShotHoming2");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerShotHoming")) {
                                                            buyUpgrade("BlazerShotHoming");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBallCooldown1")) {
                                                        buyUpgrade("BlazerBallCooldown1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("addHealth2")) {
                                                    buyUpgrade("addHealth2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerBlazeDamage3")) {
                                                buyUpgrade("BlazerBlazeDamage3");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerBlazeDamage2")) {
                                            buyUpgrade("BlazerBlazeDamage2");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("BlazerBlazeDuration2")) {
                                        buyUpgrade("BlazerBlazeDuration2");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("BlazerBlazeDuration1")) {
                                    buyUpgrade("BlazerBlazeDuration1");
                                }
                            }
                        }
                    } else {
                        // Auto Attack Build
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow1")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown1")) {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow2")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotCooldown2")) {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSlow3")) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallKnockback1")) {
                                                                                        } else {
                                                                                            if (canPayUpgrade("BlazerBallKnockback1")) {
                                                                                                buyUpgrade("BlazerBallKnockback1");
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("BlazerBlazeSlow3")) {
                                                                                            buyUpgrade("BlazerBlazeSlow3");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (canPayUpgrade("BlazerShotCooldown2")) {
                                                                                        buyUpgrade("BlazerShotCooldown2");
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BlazerBlazeSlow2")) {
                                                                                    buyUpgrade("BlazerBlazeSlow2");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("BlazerShotCooldown1")) {
                                                                                buyUpgrade("BlazerShotCooldown1");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("BlazerBlazeSlow1")) {
                                                                            buyUpgrade("BlazerBlazeSlow1");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("addHealth3")) {
                                                                        buyUpgrade("addHealth3");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerBallDamage3")) {
                                                                    buyUpgrade("BlazerBallDamage3");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerBallDamage2")) {
                                                                buyUpgrade("BlazerBallDamage2");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerBallDamage1")) {
                                                            buyUpgrade("BlazerBallDamage1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBallCooldown1")) {
                                                        buyUpgrade("BlazerBallCooldown1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBlazeLength1")) {
                                                    buyUpgrade("BlazerBlazeLength1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("addHealth2")) {
                                                buyUpgrade("addHealth2");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerShotDamage2")) {
                                            buyUpgrade("BlazerShotDamage2");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("BlazerShotDamage1")) {
                                        buyUpgrade("BlazerShotDamage1");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("BlazerShotHoming2")) {
                                    buyUpgrade("BlazerShotHoming2");
                                }
                            }
                        }
                    }
                } else {
                    if (checkCounter("SkillLevel", "1", Valuecompare.Equal)) {
                        if (checkGameTime(180.0D, Valuecompare.GreaterOrEqual)) {
                            // Base Build
                            if (isUpgradeEnabled(Yesno.Yes, "Detonator")) {
                                if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "Blazerspeed1")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed2")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")||isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                } else {
                                                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")||random("3")) {
                                                        // Auto Attack build
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                        } else {
                                                            if (canPayUpgrade("BlazerShotHoming")) {
                                                                buyUpgrade("BlazerShotHoming");
                                                            }
                                                        }
                                                    } else {
                                                        // Blaze Build
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                                        } else {
                                                            if (canPayUpgrade("BlazerBlazeDamage1")) {
                                                                buyUpgrade("BlazerBlazeDamage1");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBlazeSpeed2")) {
                                                    buyUpgrade("BlazerBlazeSpeed2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerBlazeSpeed1")) {
                                                buyUpgrade("BlazerBlazeSpeed1");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("Blazerspeed1")) {
                                            buyUpgrade("Blazerspeed1");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("Blaze")) {
                                        buyUpgrade("Blaze");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("Detonator")) {
                                    buyUpgrade("Detonator");
                                }
                                if (once()) {
                                    // Perfect Drop
                                    adjustCharacterValue(CharactervaluesAdjustable.Gold, 37.0D, Valueadjust.Add);
                                    log("WINGS OF SILVER", "", "");
                                }
                            }
                            // Build Check
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                // Blaze Build
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage3")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                        } else {
                                                                            if (canPayUpgrade("BlazerBallDamage3")) {
                                                                                buyUpgrade("BlazerBallDamage3");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("BlazerBallDamage2")) {
                                                                            buyUpgrade("BlazerBallDamage2");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("BlazerBallDamage1")) {
                                                                        buyUpgrade("BlazerBallDamage1");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerShotDamage2")) {
                                                                    buyUpgrade("BlazerShotDamage2");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerShotDamage1")) {
                                                                buyUpgrade("BlazerShotDamage1");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerShotHoming2")) {
                                                            buyUpgrade("BlazerShotHoming2");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerShotHoming")) {
                                                        buyUpgrade("BlazerShotHoming");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBallCooldown1")) {
                                                    buyUpgrade("BlazerBallCooldown1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerBlazeDamage3")) {
                                                buyUpgrade("BlazerBlazeDamage3");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerBlazeDamage2")) {
                                            buyUpgrade("BlazerBlazeDamage2");
                                        }
                                    }
                                }
                            } else {
                                // Auto Attack Build
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage2")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage2")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage3")) {
                                                                } else {
                                                                    if (canPayUpgrade("BlazerBallDamage3")) {
                                                                        buyUpgrade("BlazerBallDamage3");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BlazerBallDamage2")) {
                                                                    buyUpgrade("BlazerBallDamage2");
                                                                }
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BlazerBallDamage1")) {
                                                                buyUpgrade("BlazerBallDamage1");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BlazerBallCooldown1")) {
                                                            buyUpgrade("BlazerBallCooldown1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBlazeLength")) {
                                                        buyUpgrade("BlazerBlazeLength");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerShotDamage2")) {
                                                    buyUpgrade("BlazerShotDamage2");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerShotDamage1")) {
                                                buyUpgrade("BlazerShotDamage1");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BlazerShotHoming2")) {
                                            buyUpgrade("BlazerShotHoming2");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (checkCounter("SkillLevel", "0", Valuecompare.Equal)) {
                            if (checkGameTime(300.0D, Valuecompare.GreaterOrEqual)) {
                                // Base Build
                                if (isUpgradeEnabled(Yesno.Yes, "Detonator")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "Blazerspeed1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")||isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                } else {
                                                    if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")||random("3")) {
                                                        // Auto Attack build
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                        } else {
                                                            if (canPayUpgrade("BlazerShotHoming")) {
                                                                buyUpgrade("BlazerShotHoming");
                                                            }
                                                        }
                                                    } else {
                                                        // Blaze Build
                                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                                        } else {
                                                            if (canPayUpgrade("BlazerBlazeDamage1")) {
                                                                buyUpgrade("BlazerBlazeDamage1");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBlazeSpeed1")) {
                                                    buyUpgrade("BlazerBlazeSpeed1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("Blazerspeed1")) {
                                                buyUpgrade("Blazerspeed1");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("Blaze")) {
                                            buyUpgrade("Blaze");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("Detonator")) {
                                        buyUpgrade("Detonator");
                                    }
                                    if (once()) {
                                        // Perfect Drop
                                        adjustCharacterValue(CharactervaluesAdjustable.Gold, 37.0D, Valueadjust.Add);
                                        log("WINGS OF SILVER", "", "");
                                    }
                                }
                                // Build Check
                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                    // Blaze Build
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeDamage1")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                    } else {
                                                        if (canPayUpgrade("BlazerBallDamage1")) {
                                                            buyUpgrade("BlazerBallDamage1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerShotDamage1")) {
                                                        buyUpgrade("BlazerShotDamage1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerShotHoming")) {
                                                    buyUpgrade("BlazerShotHoming");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerBallCooldown1")) {
                                                buyUpgrade("BlazerBallCooldown1");
                                            }
                                        }
                                    }
                                } else {
                                    // Auto Attack Build
                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerShotHoming")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BlazerShotDamage1")) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BlazerBallCooldown1")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBallDamage1")) {
                                                    } else {
                                                        if (canPayUpgrade("BlazerBallDamage1")) {
                                                            buyUpgrade("BlazerBallDamage1");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BlazerBallCooldown1")) {
                                                        buyUpgrade("BlazerBallCooldown1");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BlazerBlazeLength1")) {
                                                    buyUpgrade("BlazerBlazeLength1");
                                                }
                                            }
                                        } else {
                                            if (canPayUpgrade("BlazerShotDamage1")) {
                                                buyUpgrade("BlazerShotDamage1");
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
        if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.GreaterOrEqual, 25.0D, 0.2D, 0.0D, 0.2D, 0.4D, Yesno.No)&&directionToEnemyBase(Forwardbackward.FORWARD)) {
        } else {
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodthirstOn")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                        // fleeNauts (12)
                        adjustCounter("setState", "12", Valueadjust.Set);
                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                        log("DANGER - RAGE", "", "");
                    }
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                        // fleeNauts (12)
                        adjustCounter("setState", "12", Valueadjust.Set);
                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                        log("DANGER - EXPLODE", "", "");
                    }
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "SieGEMODEON")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 1.2D, 1.2D, Yesno.Yes)) {
                        // fleeNauts (12)
                        adjustCounter("setState", "12", Valueadjust.Set);
                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                        log("DANGER - SIEGE", "", "");
                    }
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy")) {
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)) {
                        // fleeNauts (12)
                        adjustCounter("setState", "12", Valueadjust.Set);
                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                        log("DANGER - SPY", "", "");
                    }
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbShootOn")) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 1.2D, 1.2D, Yesno.No)) {
                        // fleeNauts (12)
                        adjustCounter("setState", "12", Valueadjust.Set);
                        setBool("UseRetreatingSkills", Flagtoggle.Yes);
                        log("DANGER - SPY", "", "");
                    }
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                    if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange3")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 3.2D, 3.2D, Yesno.Yes)) {
                            // fleeNauts (12)
                            adjustCounter("setState", "12", Valueadjust.Set);
                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            log("DANGER - SNIPE", "", "");
                        }
                    } else {
                        if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange2")) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.8D, 2.8D, Yesno.Yes)) {
                                // fleeNauts (12)
                                adjustCounter("setState", "12", Valueadjust.Set);
                                setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                log("DANGER - SNIPE", "", "");
                            }
                        } else {
                            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeRange1")) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.4D, 2.4D, Yesno.Yes)) {
                                    // fleeNauts (12)
                                    adjustCounter("setState", "12", Valueadjust.Set);
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                    log("DANGER - SNIPE", "", "");
                                }
                            } else {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                                    // fleeNauts (12)
                                    adjustCounter("setState", "12", Valueadjust.Set);
                                    setBool("UseRetreatingSkills", Flagtoggle.Yes);
                                    log("DANGER - SNIPE", "", "");
                                }
                            }
                        }
                    }
                }
            }
            // Doesn't seem to work
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                    if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect")) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                            // fleeNauts (12)
                            adjustCounter("setState", "12", Valueadjust.Set);
                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            log("DANGER - RBAY", "", "");
                        }
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 400.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)) {
                            // fleeNauts (12)
                            adjustCounter("setState", "12", Valueadjust.Set);
                            setBool("UseRetreatingSkills", Flagtoggle.Yes);
                            log("DANGER - WHIRLWIND", "", "");
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
                if (isTargetPosition(Yesno.Yes, Offsetposition.HORIZONTALEQUAL)) {
                    if ((isTargetPosition(Yesno.Yes, Offsetposition.BACK)||isTargetPosition(Yesno.Yes, Offsetposition.FRONT))||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
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
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
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
                            } else {
                                if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                                    enableUpgrade(Yesno.Yes, "hold");
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("DoingDownJump", Yesno.No)) {
                    // JUMPIN
                    if (getBoolEquals("DownJump", Yesno.No)) {
                        if (getBoolEquals("jump", Yesno.Yes)) {
                            setBool("jump", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            } else {
                                pressButton(Buttons.FACE_BOTTOM, 0.1D);
                            }
                        }
                    } else {
                        setBool("DownJump", Flagtoggle.No);
                        if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
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
                    if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
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
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
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
        pressButton(Buttons.FACE_RIGHT, 0.01D);
        wait(0.3D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.05", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence1();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.10", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence2();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.15", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence3();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.20", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence4();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.25", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence5();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.No)) {
            log("R-BALL 0.30", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        pressButton(Buttons.FACE_RIGHT, 0.01D);
        wait(0.38D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
            log("BALL 0.05", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence7();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
            log("BALL 0.10", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence8();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.No)) {
            log("BALL 0.15", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence9();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
            log("BALL 0.20", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence10();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
            log("BALL 0.25", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence11();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence11() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.No)) {
            log("BALL 0.30", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence12();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence12() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.7D, 0.7D, Yesno.No, Yesno.No)) {
            log("BALL 0.35", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence13();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence13() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No, Yesno.No)) {
            log("BALL 0.40", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence14();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence14() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.9D, Yesno.No, Yesno.No)) {
            log("BALL 0.45", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence15();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence15() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
            log("BALL 0.50", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence16();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence16() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No, Yesno.No)) {
            log("BALL 0.55", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence17();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence17() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.No, Yesno.No)) {
            log("BALL 0.60", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence18();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence18() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.3D, 1.3D, Yesno.No, Yesno.No)) {
            log("BALL 0.65", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence19();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence19() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.4D, 1.4D, Yesno.No, Yesno.No)) {
            log("BALL 0.70", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence20();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence20() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No, Yesno.No)) {
            log("BALL 0.75", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        } else {
            sequence21();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence21() {
        wait(0.12D);
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.6D, 1.6D, Yesno.No, Yesno.No)) {
            log("BALL 0.80", "", "");
            pressButton(Buttons.FACE_RIGHT, 0.01D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence22() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(3.0D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence23() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(1.5D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence24() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(3.0D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence25() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(1.5D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence26() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(3.0D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence27() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(1.5D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence28() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(3.0D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence29() {
        setBool("BlazeOn", Flagtoggle.Yes);
        wait(1.5D);
        setBool("BlazeOn", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence30() {
        // attack
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

}

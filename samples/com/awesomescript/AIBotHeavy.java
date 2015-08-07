
package com.awesomescript;

import java.util.EnumSet;

public class AIBotHeavy
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Heavy", Flagtoggle.Yes);
        }
        executeBehaviourTree("VeankoAI");
        executeBehaviourTree("Heavy");
        executeBehaviourTree("FN_HealbotLogicMesp");
        if (once()) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.8D, Valuecompare.Greater, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "botlevel2");
                enableUpgrade(Yesno.Yes, "botlevel3");
                enableUpgrade(Yesno.Yes, "botlevel4");
                enableUpgrade(Yesno.Yes, "botlevel5");
            }
            adjustCounter("siegeTimer", "0", Valueadjust.Set);
            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
        }
        // Preventing rare stuck-in-siege bug
        if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
                    // LeaveSiege
                    pressButton(Buttons.FACE_TOP, 0.1D);
                }
            }
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                adjustCounter("siegeTimer", "1", Valueadjust.Add);
            }
            if (checkCounter("siegeTimer", "40", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
                    // LeaveSiege
                    pressButton(Buttons.FACE_TOP, 0.1D);
                }
            }
            if (checkCounter("siegeTimer", "60", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
                    enableUpgrade(Yesno.No, "SIEGEMODEON");
                }
            }
        } else {
            adjustCounter("siegeTimer", "0", Valueadjust.Set);
        }
        // Am I in shop?
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.28D, Valuecompare.Greater, Targetself.Self)||checkGameTime(180.0D, Valuecompare.GreaterOrEqual)) {
                // Upgrade path
                if (isUpgradeEnabled(Yesno.No, "Trap")) {
                    if (canPayUpgrade("Trap")) {
                        buyUpgrade("Trap");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "Turretmode")) {
                        if (canPayUpgrade("Turretmode")) {
                            buyUpgrade("Turretmode");
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "HeavySpeed")) {
                            if (canPayUpgrade("HeavySpeed")) {
                                buyUpgrade("HeavySpeed");
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                                if (canPayUpgrade("addHealth1")) {
                                    buyUpgrade("addHealth1");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "HeavyTurretDamage1")) {
                                    if (canPayUpgrade("HeavyTurretDamage1")) {
                                        buyUpgrade("HeavyTurretDamage1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "HeavyTurretDamage2")) {
                                        if (canPayUpgrade("HeavyTurretDamage2")) {
                                            buyUpgrade("HeavyTurretDamage2");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                                            if (canPayUpgrade("addHealth2")) {
                                                buyUpgrade("addHealth2");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "HeavyTurretDamage3")) {
                                                if (canPayUpgrade("HeavyTurretDamage3")) {
                                                    buyUpgrade("HeavyTurretDamage3");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "HeavyTrapLongevity1")) {
                                                    if (canPayUpgrade("HeavyTrapLongevity1")) {
                                                        buyUpgrade("HeavyTrapLongevity1");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "HeavyTrapNukeDamage1")) {
                                                        if (canPayUpgrade("HeavyTrapNukeDamage1")) {
                                                            buyUpgrade("HeavyTrapNukeDamage1");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "HeavyTrapSlow1")) {
                                                            if (canPayUpgrade("HeavyTrapSlow1")) {
                                                                buyUpgrade("HeavyTrapSlow1");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                                                if (canPayUpgrade("addHealth3")) {
                                                                    buyUpgrade("addHealth3");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.No, "HeavyTrapSlow2")) {
                                                                    if (canPayUpgrade("HeavyTrapSlow2")) {
                                                                        buyUpgrade("HeavyTrapSlow2");
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyTurretShield1")) {
                                                                        if (canPayUpgrade("HeavyTurretShield1")) {
                                                                            buyUpgrade("HeavyTurretShield1");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "HeavyTurretShield2")) {
                                                                            if (canPayUpgrade("HeavyTurretShield2")) {
                                                                                buyUpgrade("HeavyTurretShield2");
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "HeavyTrapNukeDamage2")) {
                                                                                if (canPayUpgrade("HeavyTrapNukeDamage2")) {
                                                                                    buyUpgrade("HeavyTrapNukeDamage2");
                                                                                }
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.No, "HeavyTrapNukeDamage3")) {
                                                                                    if (canPayUpgrade("HeavyTrapNukeDamage3")) {
                                                                                        buyUpgrade("HeavyTrapNukeDamage3");
                                                                                    }
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyTurretShield3")) {
                                                                                        if (canPayUpgrade("HeavyTurretShield3")) {
                                                                                            buyUpgrade("HeavyTurretShield3");
                                                                                        }
                                                                                    } else {
                                                                                        if (isUpgradeEnabled(Yesno.No, "HeavyTurretShield4")) {
                                                                                            if (canPayUpgrade("HeavyTurretShield4")) {
                                                                                                buyUpgrade("HeavyTurretShield4");
                                                                                            }
                                                                                        } else {
                                                                                            if (isUpgradeEnabled(Yesno.No, "PassiveShield1")) {
                                                                                                if (canPayUpgrade("PassiveShield1")) {
                                                                                                    buyUpgrade("PassiveShield1");
                                                                                                }
                                                                                            } else {
                                                                                                if (isUpgradeEnabled(Yesno.No, "PassiveShield2")) {
                                                                                                    if (canPayUpgrade("PassiveShield2")) {
                                                                                                        buyUpgrade("PassiveShield2");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyShotDamage1")) {
                                                                                                        if (canPayUpgrade("HeavyShotDamage1")) {
                                                                                                            buyUpgrade("HeavyShotDamage1");
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (isUpgradeEnabled(Yesno.No, "HeavyShotDamage2")) {
                                                                                                            if (canPayUpgrade("HeavyShotDamage2")) {
                                                                                                                buyUpgrade("HeavyShotDamage2");
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (isUpgradeEnabled(Yesno.No, "HeavyShotDamage3")) {
                                                                                                                if (canPayUpgrade("HeavyShotDamage3")) {
                                                                                                                    buyUpgrade("HeavyShotDamage3");
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (isUpgradeEnabled(Yesno.No, "HeavyShotDamage4")) {
                                                                                                                    if (canPayUpgrade("HeavyShotDamage4")) {
                                                                                                                        buyUpgrade("HeavyShotDamage4");
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyShotAttackspeed1")) {
                                                                                                                        if (canPayUpgrade("HeavyShotAttackspeed1")) {
                                                                                                                            buyUpgrade("HeavyShotAttackspeed1");
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (isUpgradeEnabled(Yesno.No, "HeavyShotAttackspeed2")) {
                                                                                                                            if (canPayUpgrade("HeavyShotAttackspeed2")) {
                                                                                                                                buyUpgrade("HeavyShotAttackspeed2");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (isUpgradeEnabled(Yesno.No, "HeavyShotAttackspeed3")) {
                                                                                                                                if (canPayUpgrade("HeavyShotAttackspeed3")) {
                                                                                                                                    buyUpgrade("HeavyShotAttackspeed3");
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
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.9D, Valuecompare.GreaterOrEqual, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "HeavyShotAttackspeed3")) {
                    if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                        if (canPayUpgrade("PiggyBank")) {
                            buyUpgrade("PiggyBank");
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                            if (canPayUpgrade("healthRegen1")) {
                                buyUpgrade("healthRegen1");
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                                if (canPayUpgrade("healthRegen2")) {
                                    buyUpgrade("healthRegen2");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "CCReduction1")) {
                                    if (canPayUpgrade("CCReduction1")) {
                                        buyUpgrade("CCReduction1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "CCReduction2")) {
                                        if (canPayUpgrade("CCReduction2")) {
                                            buyUpgrade("CCReduction2");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "Trap")) {
                                            if (canPayUpgrade("Trap")) {
                                                buyUpgrade("Trap");
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "HeavyTrapNukeSize")) {
                                                if (canPayUpgrade("HeavyTrapNukeSize")) {
                                                    buyUpgrade("HeavyTrapNukeSize");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "HeavyTrapSilence")) {
                                                    if (canPayUpgrade("HeavyTrapSilence")) {
                                                        buyUpgrade("HeavyTrapSilence");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "HeavyTrapSlow4")) {
                                                        if (canPayUpgrade("HeavyTrapSlow4")) {
                                                            buyUpgrade("HeavyTrapSlow4");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "Turretmode")) {
                                                            if (canPayUpgrade("Turretmode")) {
                                                                buyUpgrade("Turretmode");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "HeavyTurretTransformKnockback")) {
                                                                if (canPayUpgrade("HeavyTurretTransformKnockback")) {
                                                                    buyUpgrade("HeavyTurretTransformKnockback");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.No, "HeavyTurretSlow1")) {
                                                                    if (canPayUpgrade("HeavyTurretSlow1")) {
                                                                        buyUpgrade("HeavyTurretSlow1");
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyTurretRocket")) {
                                                                        if (canPayUpgrade("HeavyTurretRocket")) {
                                                                            buyUpgrade("HeavyTurretRocket");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "HeavyShotRange1")) {
                                                                            if (canPayUpgrade("HeavyShotRange1")) {
                                                                                buyUpgrade("HeavyShotRange1");
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "HeavyShotRange2")) {
                                                                                if (canPayUpgrade("HeavyShotRange2")) {
                                                                                    buyUpgrade("HeavyShotRange2");
                                                                                }
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.No, "HeavyShotSplit")) {
                                                                                    if (canPayUpgrade("HeavyShotSplit")) {
                                                                                        buyUpgrade("HeavyShotSplit");
                                                                                    }
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.No, "HeavyShotGoUp")) {
                                                                                        if (canPayUpgrade("HeavyShotGoUp")) {
                                                                                            buyUpgrade("HeavyShotGoUp");
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
            if (checkCounter("shopCounter", "20", Valuecompare.Less)) {
                setBool("CantMove", Flagtoggle.Yes);
            } else {
                setBool("CantMove", Flagtoggle.No);
            }
            adjustCounter("shopCounter", "1", Valueadjust.Add);
        } else {
            adjustCounter("shopCounter", "0", Valueadjust.Set);
        }
        // Siege Logic
        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
            // I am in Siege
            if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
                // Am I in danger?
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
                    // Can I get out of siege?
                    if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                        // ABORT! ABORT!
                        sequence0();
                    }
                }
                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                    // Can I get out of siege?
                    if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                        // ABORT! ABORT!
                        sequence1();
                    }
                }
                // Is there anything around me?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                } else {
                    // Can I get out of siege?
                    if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                        // Time to go be productive.
                        sequence2();
                    }
                }
                // Am I by the enemy turret?
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.25D, 0.0D, 0.5D, 0.5D, Yesno.Yes)) {
                    // Did I lose my backup?
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 50.0D, "1", 0.25D, 0.0D, 0.5D, 0.5D, Yesno.Yes)) {
                    } else {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            // Can I get out of siege?
                            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                // GTFO!
                                sequence3();
                            }
                        }
                    }
                }
                // Is my target a turret?
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                    // I shouldn't be backwards.
                    if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                        // I think I'm firing the wrong way.
                        sequence4();
                    }
                }
                if (((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.01D, 0.01D, Yesno.No, Yesno.Yes)&&hasUpgrade("hunter", Teamswithnumbers.ENEMY_TEAM, "HunterWall"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 1.0D, 1.5D, 3.0D, Yesno.No))&&checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                    // SCREW NUKING, I GOTTA GTFO
                    pressButton(Buttons.FACE_TOP, 0.1D);
                }
            }
            // I am not in Siege
            if (isUpgradeEnabled(Yesno.No, "SIEGEMODEON")) {
                if (((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.Yes)&&hasUpgrade("hunter", Teamswithnumbers.ENEMY_TEAM, "HunterWall"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 1.0D, 1.5D, 3.0D, Yesno.No))&&checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                } else {
                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                    } else {
                        // I should never enter siege if 1/3 health
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 33.33D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            // Am I by my turret?
                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.1D, 0.1D, Yesno.Yes)) {
                                // Do I have enough health?
                                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.Greater, Targetself.Self)) {
                                    // Is the turret under attack?
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                        // Can I go into siege?
                                        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                            // Am I facing the wrong way?
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                                                pressStick(Directions.BACKWARD, 0.1D);
                                            }
                                            // Turtle mode Activate!
                                            sequence5();
                                        }
                                    }
                                }
                            } else {
                                // Am I by the enemy turret?
                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.24D, 0.0D, 0.48D, 0.5D, Yesno.Yes)) {
                                    // Do I have drones for backup?
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.25D, 0.0D, 0.5D, 0.5D, Yesno.Yes)) {
                                        // Can I go into siege?
                                        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                            // Am I facing the wrong way?
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                                                pressStick(Directions.BACKWARD, 0.1D);
                                            }
                                            // Siege mode Activate!
                                            sequence6();
                                        }
                                    }
                                }
                            }
                            // Am I in the enemy base?
                            if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                // Am I attacking their base?
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))) {
                                    // Can I reach the base?
                                    if (isTargetInArea(Yesno.Yes, 0.15D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                        // Can I go into siege?
                                        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                            // Am I facing the wrong way?
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                                                pressStick(Directions.BACKWARD, 0.1D);
                                            }
                                            // Siege mode Activate!
                                            sequence7();
                                        }
                                    }
                                }
                            }
                            // Is there allies by me?
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                // Is there enemies by me?
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                    // Must be a teamfight!
                                    sequence8();
                                }
                            }
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                                // Can I siege?
                                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                    // Lets clear out this nest.
                                    sequence9();
                                }
                            }
                        }
                    }
                }
            }
        }
        // Nuke Logic
        if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
            if (isUpgradeEnabled(Yesno.Yes, "Trap")) {
                // Is there a player REALLY FRIGGIN CLOSE to me?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                    aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                    sequence10();
                } else {
                    // Is there a player near me?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.4D, 1.2D, Yesno.No, Yesno.No)) {
                        aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        // Nuke the player!
                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                    } else {
                        // Is there a creep near me?
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.4D, 1.2D, Yesno.Yes, Yesno.No)) {
                            // Is there a stronger creep wave?
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.Yes)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                // Nuke the creep wave!
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                            }
                        }
                    }
                }
            }
        }
        // Snare Logic
        if (isUpgradeEnabled(Yesno.No, "SIEGEMODEON")) {
            if (isUpgradeEnabled(Yesno.Yes, "Trap")) {
                // Am I running away?
                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.5D, 0.0D, 1.5D, 1.0D, Yesno.No, Yesno.No)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                        // Snare them!
                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                    }
                }
                // Is there anything around me?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)) {
                    // Snare them!
                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                }
                // Am I on a jumppad?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                    sequence11();
                }
                // Am I below a glass platform?
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.1D, 0.1D, 0.2D, Yesno.No, Yesno.No)) {
                    sequence12();
                }
            }
        }
        // AA Logic
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            // Am I sieging?
            if (isUpgradeEnabled(Yesno.Yes, "SIEGEMODEON")) {
                // Siege Derpl Shooting logic
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.Yes, Yesno.No)) {
                    if (hasTarget(Yesno.Yes)) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 0.8D, Yesno.No, Yesno.No)) {
                            aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                } else {
                    // enemy in range -> always shoot
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.Yes, Yesno.No)) {
                        // bullet distance +max collision width/2 + a little offset
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                }
            } else {
                // Cat Derpl Shooting logic
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.65D, 0.4D, Yesno.Yes, Yesno.No)) {
                    if (hasTarget(Yesno.Yes)) {
                        if (isTargetInArea(Yesno.Yes, 0.1D, 0.0D, 0.65D, 0.4D, Yesno.No, Yesno.No)) {
                            aimStickAtTarget(0.1D, Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    // bullet distance +max collision width/2 + a little offset
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                } else {
                    // enemy in front -> always shoot
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                        // bullet distance +max collision width/2 + a little offset
                        pressButton(Buttons.FACE_LEFT, 0.0D);
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
        // Jump Logic
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
        // idk what this is
        if (timePassed(Timeunits.Seconds, 10.0D)) {
            // like seriously wtf
            pressButton(Buttons.DPAD_DOWN, 0.0D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        // Nuke one last time if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(1.0D);
        // LeaveSiege
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        // Nuke one last time if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(1.0D);
        // LeaveSiege
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        // Nuke one last time if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(1.0D);
        // LeaveSiege
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        // Nuke one last time if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(1.0D);
        // LeaveSiege
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        // Nuke one last time if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(1.0D);
        // LeaveSiege
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        // Plant one last snare if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Move forward a bit
        pressStick(Directions.FORWARD, 0.2D);
        // Siege
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        // Plant one last snare if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Move forward a bit
        pressStick(Directions.FORWARD, 0.2D);
        // Siege
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        // Plant one last snare if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Move forward a bit
        pressStick(Directions.FORWARD, 0.2D);
        // Siege
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        // Am I facing the wrong way?
        if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
            pressStick(Directions.BACKWARD, 0.1D);
        }
        // Plant one last snare if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Move forward a bit
        pressStick(Directions.FORWARD, 0.2D);
        // Siege
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = true)
    void sequence9() {
        // Plant one last snare if I can
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Siege
        pressButton(Buttons.FACE_TOP, 0.2D);
        // Target the weeds
        selectTarget(EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "CreepMawTurret", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
        // Aim at the weeds
        aimStickAtTarget(1.0D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        // Nuke the weeds!
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        // Wait to unsiege
        wait(2.5D);
        // Unsiege
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        // Nuke the player!
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        wait(0.8D);
        // Detonate the nuke!
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence11() {
        wait(0.4D);
        // Set a trap!
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence12() {
        wait(0.4D);
        // Am I still below a glass platform?
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.1D, 0.1D, 0.2D, Yesno.No, Yesno.No)) {
            // Set a trap!
            pressButton(Buttons.FACE_RIGHT, 0.1D);
        }
    }

}


package com.awesomescript;

import java.util.EnumSet;

public class SkillLogic_Foxless
    extends Script
{


    public void onTick() {
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
            // Can I kill with Pounce?
            if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                    setBool("InPounceRange", Flagtoggle.No);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "AssassinAssailDistance")) {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                            if (isTargetInArea(Yesno.Yes, 0.35D, 0.0D, 0.7D, 0.1D, Yesno.Yes, Yesno.No)) {
                                setBool("InPounceRange", Flagtoggle.Yes);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                if (isTargetInArea(Yesno.Yes, 0.34D, 0.0D, 0.68D, 0.1D, Yesno.Yes, Yesno.No)) {
                                    setBool("InPounceRange", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                    if (isTargetInArea(Yesno.Yes, 0.32D, 0.0D, 0.65D, 0.1D, Yesno.Yes, Yesno.No)) {
                                        setBool("InPounceRange", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                        if (isTargetInArea(Yesno.Yes, 0.3D, 0.0D, 0.6D, 0.1D, Yesno.Yes, Yesno.No)) {
                                            setBool("InPounceRange", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                            if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.5D, 0.1D, Yesno.Yes, Yesno.No)) {
                                setBool("InPounceRange", Flagtoggle.Yes);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                if (isTargetInArea(Yesno.Yes, 0.23D, 0.0D, 0.46D, 0.1D, Yesno.Yes, Yesno.No)) {
                                    setBool("InPounceRange", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                    if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.43D, 0.1D, Yesno.Yes, Yesno.No)) {
                                        setBool("InPounceRange", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                        if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.1D, Yesno.Yes, Yesno.No)) {
                                            setBool("InPounceRange", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("PounceKill", Yesno.Yes)) {
                    setBool("PounceKill", Flagtoggle.No);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "AssassinAssailDmg2")) {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 420.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                setBool("PounceKill", Flagtoggle.Yes);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 350.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("PounceKill", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 280.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("PounceKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 210.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("PounceKill", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinAssailDmg")) {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 360.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("PounceKill", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("PounceKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 240.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("PounceKill", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 180.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                setBool("PounceKill", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("PounceKill", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 250.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("PounceKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("PounceKill", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 150.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                setBool("PounceKill", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                setBool("PounceKill", Flagtoggle.No);
                setBool("InPounceRange", Flagtoggle.No);
            }
            // Can I kill with Swipe?
            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                    setBool("InSwipeRange", Flagtoggle.No);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "AssassinJoltRange1")) {
                        if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.8D, Yesno.No, Yesno.No)) {
                            setBool("InSwipeRange", Flagtoggle.Yes);
                        }
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.1D, 0.0D, 0.2D, 0.4D, Yesno.No, Yesno.No)) {
                            setBool("InSwipeRange", Flagtoggle.Yes);
                        }
                    }
                }
                if (getBoolEquals("SwipeKill", Yesno.Yes)) {
                    setBool("SwipeKill", Flagtoggle.No);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "AssassinJoltDmgpercharge3")) {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 640.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                setBool("SwipeKill", Flagtoggle.Yes);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 480.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("SwipeKill", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 320.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("SwipeKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 160.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("SwipeKill", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "AssassinJoltDmgpercharge2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                                if (checkCharacterValue(CharactervaluesCheckable.Health, 560.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("SwipeKill", Flagtoggle.Yes);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 420.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("SwipeKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 280.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("SwipeKill", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 140.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                setBool("SwipeKill", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "AssassinJoltDmgpercharge1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 480.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("SwipeKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 360.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("SwipeKill", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 240.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                setBool("SwipeKill", Flagtoggle.Yes);
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 120.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    setBool("SwipeKill", Flagtoggle.Yes);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                                    if (checkCharacterValue(CharactervaluesCheckable.Health, 400.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        setBool("SwipeKill", Flagtoggle.Yes);
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                                        if (checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            setBool("SwipeKill", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                                            if (checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                setBool("SwipeKill", Flagtoggle.Yes);
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                                                if (checkCharacterValue(CharactervaluesCheckable.Health, 100.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    setBool("SwipeKill", Flagtoggle.Yes);
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
                setBool("SwipeKill", Flagtoggle.No);
                setBool("InSwipeRange", Flagtoggle.No);
            }
            if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
                if (getBoolEquals("SwipeKill", Yesno.Yes)&&getBoolEquals("InSwipeRange", Yesno.Yes)) {
                    if (getBoolEquals("DangerousClunk", Yesno.Yes)) {
                    } else {
                        setBool("Swipe", Flagtoggle.Yes);
                    }
                } else {
                    if (getBoolEquals("PounceKill", Yesno.Yes)&&getBoolEquals("InPounceRange", Yesno.Yes)) {
                        if (getBoolEquals("DangerousClunk", Yesno.Yes)) {
                        } else {
                            setBool("PounceAttack", Flagtoggle.Yes);
                        }
                    } else {
                        // Pounce to Disable/Flee
                        if (getBoolEquals("DangerousNaut", Yesno.Yes)) {
                            if (getBoolEquals("DangerousFroggy", Yesno.Yes)||getBoolEquals("DangerousRaelynn", Yesno.Yes)) {
                                if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                    setBool("PounceAttack", Flagtoggle.Yes);
                                } else {
                                    setBool("PounceFlee", Flagtoggle.Yes);
                                }
                            } else {
                                if (getBoolEquals("DangerousYuri", Yesno.Yes)||getBoolEquals("DangerousAyla", Yesno.Yes)) {
                                    // 2 teammates
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                        if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                            setBool("PounceAttack", Flagtoggle.Yes);
                                        } else {
                                            setBool("PounceFlee", Flagtoggle.Yes);
                                        }
                                    } else {
                                        // 1 teammate
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                            // 3 enemies
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                setBool("PounceFlee", Flagtoggle.Yes);
                                            } else {
                                                // 2 enemies
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                    if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                                        setBool("PounceAttack", Flagtoggle.Yes);
                                                    }
                                                } else {
                                                    // 1 enemy
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                        if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                                            setBool("PounceAttack", Flagtoggle.Yes);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            // 3 enemies
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                setBool("PounceFlee", Flagtoggle.Yes);
                                            } else {
                                                // 2 enemies
                                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                    setBool("PounceFlee", Flagtoggle.Yes);
                                                } else {
                                                    // 1 enemy
                                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                        setBool("PounceFlee", Flagtoggle.Yes);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    setBool("PounceFlee", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            // 2 teammates
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                                if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                    if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                        setBool("Swipe", Flagtoggle.Yes);
                                    }
                                }
                            } else {
                                // 1 teammate
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                                    // 3 enemies
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                        if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                            if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                                setBool("Swipe", Flagtoggle.Yes);
                                            }
                                        }
                                    } else {
                                        // 2 enemies
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                            if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                                if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                                    setBool("Swipe", Flagtoggle.Yes);
                                                } else {
                                                    if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                                        setBool("PounceAttack", Flagtoggle.Yes);
                                                    }
                                                }
                                            }
                                        } else {
                                            // 1 enemy
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                                    if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                                        setBool("Swipe", Flagtoggle.Yes);
                                                    } else {
                                                        if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                                            setBool("PounceAttack", Flagtoggle.Yes);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // 3 enemies
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                    } else {
                                        // 2 enemies
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                            if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                                if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                                    setBool("Swipe", Flagtoggle.Yes);
                                                }
                                            }
                                        } else {
                                            // 1 enemy
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                if (checkCounter("Charges", "3", Valuecompare.GreaterOrEqual)) {
                                                    if (getBoolEquals("InSwipeRange", Yesno.Yes)) {
                                                        setBool("Swipe", Flagtoggle.Yes);
                                                    } else {
                                                        if (getBoolEquals("InPounceRange", Yesno.Yes)) {
                                                            setBool("PounceAttack", Flagtoggle.Yes);
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


package com.awesomescript;

import java.util.EnumSet;

public class Cowboy
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (isTutorialMatch()) {
            // Tutorial?
            if (getBoolEquals("DoTutorial", Yesno.No)) {
                if (timePassed(Timeunits.Seconds, 0.1D)) {
                    if (isInNamedArea("TutorialText1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        setBool("DoTutorial", Flagtoggle.Yes);
                    }
                }
            } else {
                if (timePassed(Timeunits.Seconds, 0.1D)) {
                    if (checkCharacterValue(CharactervaluesCheckable.Gold, 150.0D, Valuecompare.Less, Targetself.Self)) {
                        if (isUpgradeEnabled(Yesno.No, "Grenade")) {
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 150.0D, Valueadjust.Set);
                        }
                    }
                }
                enableUpgrade(Yesno.Yes, "LevelStart");
                // Tutorial Triggers
                if (getBoolEquals("TutorialTriggers", Yesno.No)) {
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Freezers", Yesno.No)) {
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Base", Yesno.Yes)) {
                                    sequence0();
                                    setBool("DoOverlay_Base_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Base", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_EnemyBase", Yesno.Yes)) {
                                    sequence1();
                                    setBool("DoOverlay_EnemyBase_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_EnemyBase", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Friendlies", Yesno.Yes)) {
                                    sequence2();
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Healing", Yesno.Yes)) {
                                    sequence3();
                                    setBool("DoOverlay_Healing_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Healing", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Neutrals", Yesno.Yes)) {
                                    sequence4();
                                    setBool("DoOverlay_Neutrals_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Neutrals", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Teleport", Yesno.Yes)) {
                                    sequence5();
                                    setBool("DoOverlay_Teleport_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Teleport", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Turret1", Yesno.Yes)) {
                                    sequence6();
                                    setBool("DoOverlay_Turret1_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Turret1", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Money", Yesno.Yes)) {
                                    sequence7();
                                    setBool("DoOverlay_Money_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Money", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Shop", Yesno.Yes)) {
                                    sequence8();
                                    setBool("DoOverlay_Shop_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Shop", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_EnemyHero", Yesno.Yes)) {
                                    sequence9();
                                    setBool("DoOverlay_EnemyHero_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_EnemyHero", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_InvisArea", Yesno.Yes)) {
                                    sequence10();
                                    setBool("DoOverlay_InvisArea_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_InvisArea", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Greens", Yesno.Yes)) {
                                    sequence11();
                                    setBool("DoOverlay_Greens_Done", Flagtoggle.Yes);
                                    setBool("DoOverlay_Greens", Flagtoggle.No);
                                }
                            }
                            if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_End", Yesno.Yes)) {
                                    pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Text_15c", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
                                    setBool("DoOverlay_End", Flagtoggle.No);
                                    setBool("DoOverlay_End_Done", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial1", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            playAnimation("Tut_Scene2_a", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 100.0D, Yesno.No, Teams.OWN_TEAM);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial1", Flagtoggle.No);
                            setBool("Tutorial1Done", Flagtoggle.Yes);
                            sequence12();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial1b", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            playAnimation("Tut_Scene2_b", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Teams.OWN_TEAM);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial1b", Flagtoggle.No);
                            setBool("Tutorial1bDone", Flagtoggle.Yes);
                            sequence13();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial1c", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            playAnimation("Tut_Scene2_c", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Teams.OWN_TEAM);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial1c", Flagtoggle.No);
                            setBool("Tutorial1cDone", Flagtoggle.Yes);
                            sequence14();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial2", Yesno.Yes)) {
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial2", Flagtoggle.No);
                            setBool("Tutorial2Done", Flagtoggle.Yes);
                            sequence15();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial3Done", Yesno.No)) {
                            if (getBoolEquals("DoTutorial3", Yesno.Yes)) {
                                setBool("GiveMoneyWarning", Flagtoggle.Yes);
                                playAnimation("Tutorial_Text_3", AnimationLocation.HUD, 0.0D, 0.0D, 0.9D, 0.5D, Yesno.No, Teams.OWN_TEAM);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial3", Flagtoggle.No);
                                setBool("Tutorial3Done", Flagtoggle.Yes);
                                sequence16();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial4aDone", Yesno.No)) {
                            if (getBoolEquals("DoTutorial4a", Yesno.Yes)) {
                                setBool("GiveHealthWarning", Flagtoggle.Yes);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial4a", Flagtoggle.No);
                                setBool("Tutorial4aDone", Flagtoggle.Yes);
                                sequence17();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial4bDone", Yesno.No)) {
                            if (getBoolEquals("DoTutorial4b", Yesno.Yes)) {
                                setBool("GiveHealthWarning", Flagtoggle.Yes);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial4b", Flagtoggle.No);
                                setBool("Tutorial4bDone", Flagtoggle.Yes);
                                sequence18();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial5aDone", Yesno.No)) {
                            if (getBoolEquals("DoTutorial5a", Yesno.Yes)) {
                                setBool("GiveHealthWarning", Flagtoggle.Yes);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial5a", Flagtoggle.No);
                                setBool("Tutorial4aDone", Flagtoggle.Yes);
                                setBool("Tutorial4bDone", Flagtoggle.Yes);
                                setBool("Tutorial5aDone", Flagtoggle.Yes);
                                sequence19();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial5bDone", Yesno.No)) {
                            if (getBoolEquals("DoTutorial5b", Yesno.Yes)) {
                                setBool("GiveHealthWarning", Flagtoggle.Yes);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial5b", Flagtoggle.No);
                                setBool("Tutorial5bDone", Flagtoggle.Yes);
                                sequence20();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("Tutorial5cDone", Yesno.No)) {
                            if (getBoolEquals("DoTutorial5c", Yesno.Yes)) {
                                setBool("GiveHealthWarning", Flagtoggle.Yes);
                                setBool("DoingTutorial", Flagtoggle.Yes);
                                setBool("DoTutorial5c", Flagtoggle.No);
                                setBool("Tutorial5cDone", Flagtoggle.Yes);
                                sequence21();
                            }
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial6", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial6", Flagtoggle.No);
                            setBool("Tutorial6Done", Flagtoggle.Yes);
                            setBool("Tutorial5aDone", Flagtoggle.Yes);
                            setBool("Tutorial5bDone", Flagtoggle.Yes);
                            setBool("Tutorial5bDone", Flagtoggle.Yes);
                            sequence22();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial7a", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial7a", Flagtoggle.No);
                            setBool("Tutorial7aDone", Flagtoggle.Yes);
                            sequence23();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial7b", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial7b", Flagtoggle.No);
                            setBool("Tutorial7bDone", Flagtoggle.Yes);
                            sequence24();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial7c", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial7c", Flagtoggle.No);
                            setBool("Tutorial7cDone", Flagtoggle.Yes);
                            sequence25();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial8", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial8", Flagtoggle.No);
                            setBool("Tutorial8Done", Flagtoggle.Yes);
                            sequence26();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial9", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial9", Flagtoggle.No);
                            setBool("Tutorial9Done", Flagtoggle.Yes);
                            sequence27();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial10", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial10", Flagtoggle.No);
                            setBool("Tutorial10Done", Flagtoggle.Yes);
                            sequence28();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial11", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial11", Flagtoggle.No);
                            setBool("Tutorial11Done", Flagtoggle.Yes);
                            sequence29();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial12", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial12", Flagtoggle.No);
                            setBool("Tutorial12Done", Flagtoggle.Yes);
                            sequence30();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial13", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial13", Flagtoggle.No);
                            setBool("Tutorial13Done", Flagtoggle.Yes);
                            sequence31();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial14", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial14", Flagtoggle.No);
                            setBool("Tutorial14Done", Flagtoggle.Yes);
                            sequence32();
                        }
                    }
                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                        if (getBoolEquals("DoTutorial15", Yesno.Yes)) {
                            setBool("GiveHealthWarning", Flagtoggle.Yes);
                            setBool("DoingTutorial", Flagtoggle.Yes);
                            setBool("DoTutorial15", Flagtoggle.No);
                            setBool("Tutorial15Done", Flagtoggle.Yes);
                            sequence33();
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "TutorialListen")) {
                    enableUpgrade(Yesno.No, "ShootPenalty");
                    if (getBoolEquals("ToldFrogToTalk", Yesno.No)) {
                        emitMessageInArea("FreezeImListening", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM, Teamswithtarget.ENEMY_TEAM), 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes, Yesno.No);
                        setBool("ToldFrogToTalk", Flagtoggle.Yes);
                        log("Telling To Freeze", "", "");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "TutorialTalk")) {
                        enableUpgrade(Yesno.No, "ShootPenalty");
                        if (getBoolEquals("ToldFrogToListen", Yesno.Yes)) {
                            emitMessageInArea("FreezeImTalking", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM, Teamswithtarget.ENEMY_TEAM), 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes, Yesno.No);
                            setBool("ToldFrogToListen", Flagtoggle.Yes);
                            log("Telling To Freeze", "", "");
                        }
                    } else {
                        if (getBoolEquals("ToldFrogToTalk", Yesno.Yes)||getBoolEquals("ToldFrogToListen", Yesno.Yes)) {
                            emitMessageInArea("ImDoneTalking", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM, Teamswithtarget.ENEMY_TEAM), 0.0D, 0.0D, 10.0D, 10.0D, Yesno.Yes, Yesno.No);
                            setBool("ToldFrogToTalk", Flagtoggle.No);
                            setBool("ToldFrogToListen", Flagtoggle.No);
                            log("Telling To Unfreeze", "", "");
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.Less, Targetself.Self)) {
                    if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                    } else {
                        if (getBoolEquals("DoOverlay_Teleport_Done", Yesno.No)) {
                            if (getBoolEquals("DoOverlay_Neutrals_Done", Yesno.Yes)) {
                                setBool("DoOverlay_Teleport", Flagtoggle.Yes);
                            }
                        }
                    }
                }
                if (isInNamedArea("OpeningDone", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (getBoolEquals("Tutorial12Done", Yesno.No)) {
                        setBool("DoTutorial12", Flagtoggle.Yes);
                    }
                    setBool("OpeningDone", Flagtoggle.Yes);
                    enableUpgrade(Yesno.No, "TutorialOpening");
                } else {
                    if (getBoolEquals("OpeningDone", Yesno.No)) {
                        if (getBoolEquals("Tutorial4aDone", Yesno.Yes)) {
                            enableUpgrade(Yesno.No, "TutorialOpening");
                        } else {
                            log("DISABLING TELEPORT", "", "");
                            enableUpgrade(Yesno.Yes, "TutorialOpening");
                        }
                    }
                }
                if (getBoolEquals("OpeningDone", Yesno.No)) {
                    if (getBoolEquals("Crashlanded", Yesno.No)) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, 500.0D, Valueadjust.Set);
                        setBool("Crashlanded", Flagtoggle.Yes);
                    }
                    if (isInNamedArea("SECRETAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (getBoolEquals("DoOverlay_InvisArea_Done", Yesno.No)) {
                            setBool("DoOverlay_InvisArea", Flagtoggle.Yes);
                        }
                    }
                    if (getBoolEquals("Tutorial2Done", Yesno.No)) {
                        if (isInNamedArea("TutorialText2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            setBool("DoTutorial2", Flagtoggle.Yes);
                        }
                    }
                    if (isInNamedArea("TutorialText4", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (getBoolEquals("Tutorial4aDone", Yesno.No)) {
                            if (getBoolEquals("DoOverlay_Neutrals_Done", Yesno.No)) {
                                setBool("DoOverlay_Neutrals", Flagtoggle.Yes);
                            } else {
                                sequence34();
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "grenade")) {
                                if (getBoolEquals("DoingTutorial", Yesno.No)) {
                                    if (getBoolEquals("Tutorial4bDone", Yesno.No)) {
                                        setBool("DoTutorial4b", Flagtoggle.Yes);
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "Grenade")) {
                                            if (getBoolEquals("DoOverlay_Shop_Done", Yesno.No)) {
                                                setBool("DoOverlay_Shop", Flagtoggle.Yes);
                                            } else {
                                                if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                                                    setBool("DoOverlay_Shop", Flagtoggle.Yes);
                                                } else {
                                                    if (getBoolEquals("DoingOverlay", Yesno.No)) {
                                                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                                            if (isInNamedArea("SHOPRIGHT", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                                                playAnimation("Tutorial_Text_5b_right", AnimationLocation.HUD, 0.0D, 0.18D, 1.0D, -1.0D, Yesno.No, Teams.OWN_TEAM);
                                                            } else {
                                                                if (isInNamedArea("SHOPLEFT", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                                                    playAnimation("Tutorial_Text_5b_left", AnimationLocation.HUD, 0.0D, 0.18D, 1.0D, -1.0D, Yesno.No, Teams.OWN_TEAM);
                                                                } else {
                                                                    if (isInNamedArea("SHOPLEFTUP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                                                        playAnimation("Tutorial_Text_5b_left", AnimationLocation.HUD, 0.0D, 0.18D, 1.0D, -1.0D, Yesno.No, Teams.OWN_TEAM);
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
                    if (isInNamedArea("TutorialText5", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (isUpgradeEnabled(Yesno.No, "Grenade")) {
                        } else {
                            if (getBoolEquals("Tutorial5aDone", Yesno.No)) {
                                sequence35();
                            } else {
                                if (getBoolEquals("DoingTutorial", Yesno.No)) {
                                    if (getBoolEquals("Tutorial5bDone", Yesno.No)) {
                                        setBool("DoTutorial5b", Flagtoggle.Yes);
                                    } else {
                                        if (getBoolEquals("Tutorial5cDone", Yesno.No)) {
                                            setBool("DoTutorial5c", Flagtoggle.Yes);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (isInNamedArea("TutorialText6", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (getBoolEquals("Tutorial6Done", Yesno.No)) {
                            setBool("DoTutorial6", Flagtoggle.Yes);
                        }
                    }
                    if (isInNamedArea("TutorialText7", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (getBoolEquals("Tutorial7aDone", Yesno.No)) {
                            setBool("DoTutorial7a", Flagtoggle.Yes);
                        } else {
                            if (getBoolEquals("DoingTutorial", Yesno.No)) {
                                if (getBoolEquals("Tutorial7bDone", Yesno.No)) {
                                    setBool("DoTutorial7b", Flagtoggle.Yes);
                                } else {
                                    if (getBoolEquals("DoingTutorial", Yesno.No)) {
                                        if (getBoolEquals("Tutorial7cDone", Yesno.No)) {
                                            setBool("DoTutorial7c", Flagtoggle.Yes);
                                        } else {
                                            sequence36();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (getBoolEquals("Tutorial8Done", Yesno.No)) {
                        if (isInNamedArea("TutorialText8", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            setBool("DoTutorial8", Flagtoggle.Yes);
                            setBool("TutorialBuddy1Active", Flagtoggle.Yes);
                        }
                    }
                    if (getBoolEquals("Tutorial9Done", Yesno.No)) {
                        if (isInNamedArea("TutorialText9", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            setBool("DoTutorial9", Flagtoggle.Yes);
                        }
                    }
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.25D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                        if (getBoolEquals("Tutorial10Done", Yesno.Yes)) {
                            if (getBoolEquals("DoOverlay_EnemyHero_Done", Yesno.No)) {
                                if (getBoolEquals("DoOverlay_Friendlies_Done", Yesno.Yes)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.3D, 0.0D, 0.9D, 0.5D, Yesno.No, Yesno.No)) {
                                    } else {
                                        if (timer(Timeunits.Seconds, 7.0D, Yesno.No)) {
                                            setBool("DoOverlay_Friendlies_Done", Flagtoggle.Yes);
                                        }
                                    }
                                } else {
                                    if (getBoolEquals("DoOverlay_Friendlies_Done", Yesno.No)) {
                                        setBool("DoOverlay_Friendlies", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                        setBool("CanDoTutorial11", Flagtoggle.Yes);
                    }
                }
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.25D, 0.0D, 0.5D, 0.5D, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    setBool("CanDoTutorial11", Flagtoggle.Yes);
                } else {
                    if (getBoolEquals("CanDoTutorial11", Yesno.Yes)) {
                        if (hasTarget(Yesno.Yes)) {
                        } else {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                            } else {
                                if (getBoolEquals("Tutorial11Done", Yesno.No)) {
                                    setBool("DoTutorial11", Flagtoggle.Yes);
                                    log("EXCELLENT", "", "");
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("TutorialBuddy1Active", Yesno.Yes)) {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepDasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Greater, 1.0D, "", 0.0D, 0.0D, 100.0D, 100.0D, Yesno.No)) {
                    } else {
                        setBool("DoTutorial10", Flagtoggle.Yes);
                        setBool("TutorialBuddy1Active", Flagtoggle.No);
                        if (getBoolEquals("DoOverlay_Friendlies_Done", Yesno.No)) {
                            sequence37();
                        }
                    }
                }
                if (getBoolEquals("Tutorial6bDone", Yesno.Yes)||getBoolEquals("Tutorial6Done", Yesno.Yes)) {
                    if (areGoldCoinsInArea(1.0D, Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)) {
                        if (getBoolEquals("DoOverlay_Money_Done", Yesno.No)) {
                            setBool("DoOverlay_Money", Flagtoggle.Yes);
                        }
                    }
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "CreepCowboy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 1100.0D, "", 0.0D, 0.0D, 0.7D, 0.5D, Yesno.No)) {
                    if (getBoolEquals("DoOverlay_EnemyHero_Done", Yesno.No)) {
                        setBool("DoOverlay_EnemyHero", Flagtoggle.Yes);
                    } else {
                        if (getBoolEquals("Tutorial13Done", Yesno.No)) {
                            sequence38();
                        }
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Less, Targetself.Self)) {
                    if (getBoolEquals("DoOverlay_Friendlies_Done", Yesno.No)) {
                    } else {
                        if (getBoolEquals("DoOverlay_Healing_Done", Yesno.No)) {
                            setBool("DoOverlay_Healing", Flagtoggle.Yes);
                        } else {
                            if (timer(Timeunits.Seconds, 15.0D, Yesno.No)) {
                                setBool("DoOverlay_Healing_Done", Flagtoggle.No);
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "TutorialCowboyOnce")) {
                    if (isInNamedArea("NEARLONE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        buyUpgrade("TutorialCowboyOnce");
                        enableUpgrade(Yesno.Yes, "TutorialCowboyOnce");
                        setBool("DoOverlay_EnemyHero", Flagtoggle.Yes);
                        if (getBoolEquals("Tutorial13Done", Yesno.No)) {
                            sequence39();
                        }
                    }
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 1100.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                    if (getBoolEquals("Tutorial14Done", Yesno.No)) {
                        sequence40();
                    }
                    setBool("GroggySeen", Flagtoggle.Yes);
                } else {
                    if (getBoolEquals("Tutorial14Done", Yesno.Yes)) {
                        if (getBoolEquals("Tutorial15Done", Yesno.No)) {
                            if (isInNamedArea("TutorialText15", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (getBoolEquals("DoOverlay_EnemyBase_Done", Yesno.No)) {
                                    setBool("DoOverlay_EnemyBase", Flagtoggle.Yes);
                                } else {
                                    sequence41();
                                }
                            }
                        }
                    }
                    if (getBoolEquals("GroggySeen", Yesno.Yes)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "CreepDasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 35.0D, 35.0D, Yesno.No)) {
                            } else {
                                setBool("DoGroggyMessage", Flagtoggle.Yes);
                                setBool("GroggySeen", Flagtoggle.No);
                            }
                        }
                    }
                    if (getBoolEquals("DoGroggyMessage", Yesno.Yes)) {
                        if (getBoolEquals("DoingTutorial", Yesno.No)) {
                            playAnimation("GMT_KILLEDPLAYER_GROGGY", AnimationLocation.HUD, 0.0D, 0.2D, 0.8D, -1.0D, Yesno.No, Teams.OWN_TEAM);
                            setBool("DoGroggyMessage", Flagtoggle.No);
                        }
                    }
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "CreepCowboy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.No)) {
                    setBool("ClintSeen", Flagtoggle.Yes);
                    log("I See Cowboy", "", "");
                } else {
                    if (getBoolEquals("ClintSeen", Yesno.Yes)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "CreepCowboy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 35.0D, 35.0D, Yesno.No)) {
                            } else {
                                setBool("DoClintMessage", Flagtoggle.Yes);
                                setBool("ClintSeen", Flagtoggle.No);
                            }
                        }
                    }
                    if (getBoolEquals("DoClintMessage", Yesno.Yes)) {
                        if (getBoolEquals("DoingTutorial", Yesno.No)) {
                            log("Cowboy Died", "", "");
                            playAnimation("GMT_KILLEDPLAYER_CLINT", AnimationLocation.HUD, 0.0D, 0.2D, 0.8D, -1.0D, Yesno.No, Teams.OWN_TEAM);
                            setBool("DoClintMessage", Flagtoggle.No);
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Base", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.Yes, Yesno.No);
        wait(0.2D);
        log("Show: Base", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_EnemyBase", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Enemybase", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Friendlies", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Friendlies", "", "");
        setBool("DoOverlay_Friendlies_Done", Flagtoggle.Yes);
        setBool("DoOverlay_Friendlies", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Healing", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Healing", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Neutrals", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Neutrals", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Teleport", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Teleport", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Turret1", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        log("Show: Turret1", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Money", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Shop", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_EnemyHero", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_InvisArea", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence11() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Greens", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence12() {
        wait(14.9D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence13() {
        wait(14.9D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence14() {
        wait(15.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence15() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_001SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.05D);
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_002CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.55D);
        enableUpgrade(Yesno.No, "TutorialListen");
        playAnimation("tut_ig_003SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.25D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        wait(0.4D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence16() {
        wait(3.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence17() {
        playAnimation("tut_ig_004DS", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.45D);
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_005CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(5.05D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence18() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_006SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.15D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence19() {
        playAnimation("Tutorial_Overlay_FI", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, -400.0D, Yesno.No, Teams.OWN_TEAM);
        wait(0.4D);
        pauseGame(Yesno.Yes, Yesno.No, Yesno.No, 5.0D, "Tutorial_Overlay_Base", Yesno.Yes, 0.0D, 0.0D, 1.2D, Yesno.No, Yesno.Yes);
        wait(0.2D);
        wait(1.0D);
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_007CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence20() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_008SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(4.5D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence21() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_009SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.8D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence22() {
        playAnimation("tut_ig_010DS", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.0D);
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_011CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.3D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence23() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_012SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(5.2D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence24() {
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_013CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence25() {
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_014SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence26() {
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_015FG", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        enableUpgrade(Yesno.No, "TutorialListen");
        enableUpgrade(Yesno.Yes, "TutorialTalk");
        playAnimation("tut_ig_016SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        enableUpgrade(Yesno.No, "TutorialTalk");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence27() {
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_017FG", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.8D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence28() {
        playAnimation("tut_ig_018SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(7.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence29() {
        playAnimation("tut_ig_018bCR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(3.0D);
        setBool("DoingTutorial", Flagtoggle.No);
        setBool("CanDoTutorial11", Flagtoggle.No);
        setBool("Tutorial12Done", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence30() {
        enableUpgrade(Yesno.Yes, "TutorialListen");
        playAnimation("tut_ig_019CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(6.8D);
        enableUpgrade(Yesno.No, "TutorialListen");
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence31() {
        playAnimation("tut_ig_020CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(4.2D);
        playAnimation("tut_ig_021SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(2.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence32() {
        playAnimation("tut_ig_022SL", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(5.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence33() {
        playAnimation("tut_ig_023CR", AnimationLocation.HUD, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        wait(5.0D);
        setBool("DoingTutorial", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence34() {
        wait(0.4D);
        setBool("DoTutorial4a", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence35() {
        wait(1.0D);
        setBool("DoTutorial5a", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence36() {
        wait(18.0D);
        setBool("Tutorial7aDone", Flagtoggle.No);
        setBool("Tutorial7bDone", Flagtoggle.No);
        setBool("Tutorial7cDone", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence37() {
        wait(1.0D);
        setBool("DoOverlay_Friendlies", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence38() {
        wait(1.0D);
        setBool("DoTutorial13", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence39() {
        wait(1.0D);
        setBool("DoTutorial14", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence40() {
        wait(0.1D);
        setBool("DoTutorial14", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence41() {
        wait(1.0D);
        setBool("DoTutorial15", Flagtoggle.Yes);
    }

}

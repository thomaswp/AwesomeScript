
package com.awesomescript;

import java.util.EnumSet;

public class JetterShop
    extends Script
{


    public void onTick() {
        if (once()) {
            // Drop pod Solar
            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
            if (isUpgradeEnabled(Yesno.Yes, "Piggybank")) {
                adjustCounter("jetterBuild", "1", Valueadjust.Set);
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "Mine")) {
                    adjustCounter("jetterBuild", "2", Valueadjust.Set);
                } else {
                    sequence0();
                }
            }
        }
        // Remain in shop for 2 seconds
        if (isInNamedArea("HealArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (checkCounter("shopCounter", "20", Valuecompare.Less)) {
                setBool("DontMove", Flagtoggle.Yes);
            }
            adjustCounter("shopCounter", "1", Valueadjust.Add);
        } else {
            adjustCounter("shopCounter", "0", Valueadjust.Set);
        }
        if ((isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)&&isUpgradeEnabled(Yesno.No, "TutorialTalk"))&&isUpgradeEnabled(Yesno.No, "TutorialListen")) {
            if (random("2")) {
                enableUpgrade(Yesno.Yes, "TutorialTalk");
            } else {
                enableUpgrade(Yesno.Yes, "TutorialListen");
            }
        }
        // Check enemy burst power
        if (checkCharacterValue(CharactervaluesCheckable.Health, 0.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
            adjustCounter("enemyBurst", "0", Valueadjust.Set);
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")) {
                if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherDashDamage3")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherDashDamage6")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindExplode2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Chameleon")) {
                if (hasUpgrade("Chameleon", Teamswithnumbers.ENEMY_TEAM, "ChameleonTongueDamage3")&&hasUpgrade("Chameleon", Teamswithnumbers.ENEMY_TEAM, "ChameleonTongueDamage4")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Chameleon", Teamswithnumbers.ENEMY_TEAM, "ChameleonStealthCloneExplode")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Chameleon", Teamswithnumbers.ENEMY_TEAM, "ChameleonStealthCloneExplode2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")) {
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExplodeDamage1")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExplodeDamage2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankBiteDamage1")&&hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankBiteDamage3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Summoner")&&hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerDroneAmount1"))&&hasUpgrade("Summoner", Teamswithnumbers.ENEMY_TEAM, "SummonerDroneExplode2")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer")&&hasUpgrade("Blazer", Teamswithnumbers.ENEMY_TEAM, "BlazerBallDamage3")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")) {
                if (hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteThrowGnome")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteThrowGnome2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter")) {
                if (hasUpgrade("Jetter", Teamswithnumbers.ENEMY_TEAM, "JetterMineDamage3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Jetter", Teamswithnumbers.ENEMY_TEAM, "JetterMineDamage4")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")&&hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeDamage3")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")&&hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "HeavyTrapNukeDamage2")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Bird")&&hasUpgrade("Bird", Teamswithnumbers.ENEMY_TEAM, "BirdDiveDamage2")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Butterfly")) {
                if (hasUpgrade("Butterfly", Teamswithnumbers.ENEMY_TEAM, "ButterflyCocoonExplode1")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Butterfly", Teamswithnumbers.ENEMY_TEAM, "ButterflyCocoonExplode2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")&&hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBolasDamage3")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain")&&hasUpgrade("Captain", Teamswithnumbers.ENEMY_TEAM, "CaptainHookDamage2")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Commando")&&hasUpgrade("Commando", Teamswithnumbers.ENEMY_TEAM, "CommandoAirstrikeDamage3")) {
                adjustCounter("enemyBurst", "1", Valueadjust.Add);
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Assassin")) {
                if (hasUpgrade("Assassin", Teamswithnumbers.ENEMY_TEAM, "AssassinJoltNexthit2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Assassin", Teamswithnumbers.ENEMY_TEAM, "AssassinJoltDmgpercharge3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy")) {
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothClone1")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothClone2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothClone3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothDamage1")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothDamage2")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyBoothDamage3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbDamage3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbFlatDamage3")) {
                    adjustCounter("enemyBurst", "1", Valueadjust.Add);
                }
            }
        }
        if ((isUpgradeEnabled(Yesno.Yes, "TutorialTalk")&&isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self))&&getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Buy pills to deal with burst
            if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                if (checkCounter("enemyBurst", "2", Valuecompare.GreaterOrEqual)) {
                    setBool("buyPills", Flagtoggle.Yes);
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                    if (checkCounter("enemyBurst", "2", Valuecompare.GreaterOrEqual)) {
                        setBool("buyPills", Flagtoggle.Yes);
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                        if (checkCounter("enemyBurst", "3", Valuecompare.GreaterOrEqual)) {
                            setBool("buyPills", Flagtoggle.Yes);
                        }
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "Mine")) {
                if (canPayUpgrade("Mine")) {
                    buyUpgrade("Mine");
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "TimeBubble")) {
                    if (canPayUpgrade("TimeBubble")) {
                        buyUpgrade("TimeBubble");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "JetterSpeed")) {
                        if (canPayUpgrade("JetterSpeed")) {
                            buyUpgrade("JetterSpeed");
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
                                if (isUpgradeEnabled(Yesno.No, "JetterSummonerShotRange")) {
                                    if (canPayUpgrade("JetterSummonerShotRange")) {
                                        buyUpgrade("JetterSummonerShotRange");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "JetterShotSlow")) {
                                        if (canPayUpgrade("JetterShotSlow")) {
                                            buyUpgrade("JetterShotSlow");
                                        }
                                    } else {
                                        if (getBoolEquals("buyPills", Yesno.Yes)) {
                                            if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                                                if (canPayUpgrade("addHealth1")) {
                                                    buyUpgrade("addHealth1");
                                                    setBool("buyPills", Flagtoggle.No);
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                                                    if (canPayUpgrade("addHealth2")) {
                                                        buyUpgrade("addHealth2");
                                                        setBool("buyPills", Flagtoggle.No);
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                                        if (canPayUpgrade("addHealth3")) {
                                                            buyUpgrade("addHealth3");
                                                        }
                                                    } else {
                                                        setBool("buyPills", Flagtoggle.No);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity")) {
                                                if (canPayUpgrade("JetterMineLongevity")) {
                                                    buyUpgrade("JetterMineLongevity");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity2")) {
                                                    if (canPayUpgrade("JetterMineLongevity2")) {
                                                        buyUpgrade("JetterMineLongevity2");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "JetterMineDamage4")) {
                                                        if (canPayUpgrade("JetterMineDamage4")) {
                                                            buyUpgrade("JetterMineDamage4");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "JetterMineDamage1")) {
                                                            if (canPayUpgrade("JetterMineDamage1")) {
                                                                buyUpgrade("JetterMineDamage1");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "JetterMineDamage2")) {
                                                                if (canPayUpgrade("JetterMineDamage2")) {
                                                                    buyUpgrade("JetterMineDamage2");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.No, "JetterMineDamage3")) {
                                                                    if (canPayUpgrade("JetterMineDamage3")) {
                                                                        buyUpgrade("JetterMineDamage3");
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSpeedup")) {
                                                                        if (canPayUpgrade("JetterTimebubbleSpeedup")) {
                                                                            buyUpgrade("JetterTimebubbleSpeedup");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal4")) {
                                                                            if (canPayUpgrade("JetterTimebubbleHeal4")) {
                                                                                buyUpgrade("JetterTimebubbleHeal4");
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleLifesteal")) {
                                                                                if (canPayUpgrade("JetterTimebubbleLifesteal")) {
                                                                                    buyUpgrade("JetterTimebubbleLifesteal");
                                                                                }
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.No, "JetterShotMoreStages3")) {
                                                                                    if (canPayUpgrade("JetterShotMoreStages3")) {
                                                                                        buyUpgrade("JetterShotMoreStages3");
                                                                                    }
                                                                                } else {
                                                                                    setBool("buyPills", Flagtoggle.Yes);
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
        // Credit: FishmanDerp
        if (isUpgradeEnabled(Yesno.Yes, "TutorialListen")) {
            if (once()) {
                // I died -> get Utility
                if (isUpgradeEnabled(Yesno.Yes, "Mine")) {
                    if (isUpgradeEnabled(Yesno.No, "JetterSpeed")) {
                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                            if (isUpgradeEnabled(Yesno.Yes, "Healthregen2")) {
                                setBool("buyBoots", Flagtoggle.Yes);
                            }
                        } else {
                            setBool("buyBoots", Flagtoggle.Yes);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleSpeedup")) {
                            setBool("buyPills", Flagtoggle.Yes);
                        }
                    }
                }
            }
            // Count friendly tanks
            if (checkCharacterValue(CharactervaluesCheckable.Health, 0.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                adjustCounter("friendlyTanks", "0", Valueadjust.Set);
                if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "Paladin")) {
                    adjustCounter("friendlyTanks", "1", Valueadjust.Add);
                }
                if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "Tank")) {
                    adjustCounter("friendlyTanks", "1", Valueadjust.Add);
                }
                if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "Heavy")) {
                    adjustCounter("friendlyTanks", "1", Valueadjust.Add);
                }
                if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "Spy")) {
                    adjustCounter("friendlyTanks", "1", Valueadjust.Add);
                }
            }
            // Buy pills to deal with burst
            if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleSpeedup")) {
                if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                    if (checkCounter("enemyBurst", "1", Valuecompare.GreaterOrEqual)) {
                        setBool("buyPills", Flagtoggle.Yes);
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                        if (checkCounter("enemyBurst", "2", Valuecompare.GreaterOrEqual)) {
                            setBool("buyPills", Flagtoggle.Yes);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                            if (checkCounter("enemyBurst", "3", Valuecompare.GreaterOrEqual)) {
                                setBool("buyPills", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
            // Check for enemies with DOT
            if (checkCharacterValue(CharactervaluesCheckable.Health, 0.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                setBool("enemyDOT", Flagtoggle.No);
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                    if (hasUpgrade("Maw", Teamswithnumbers.ENEMY_TEAM, "MawSpit")||hasUpgrade("Maw", Teamswithnumbers.ENEMY_TEAM, "MawShotDot2")) {
                        setBool("enemyDOT", Flagtoggle.Yes);
                    }
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer")&&hasUpgrade("Blazer", Teamswithnumbers.ENEMY_TEAM, "BlazerBlazeDamage3")) {
                    setBool("enemyDOT", Flagtoggle.Yes);
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")&&hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteStampDamage2")) {
                    setBool("enemyDOT", Flagtoggle.Yes);
                }
                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")&&hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBolasDot2")) {
                    setBool("enemyDOT", Flagtoggle.Yes);
                }
            }
            if (getBoolEquals("CanBuyItems", Yesno.Yes)&&isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getBoolEquals("buyBoots", Yesno.Yes)&&isUpgradeEnabled(Yesno.Yes, "JetterMineDamage1")) {
                    if (canPayUpgrade("JetterSpeed")) {
                        buyUpgrade("JetterSpeed");
                        setBool("buyBoots", Flagtoggle.No);
                    }
                }
                if (getBoolEquals("buyPills", Yesno.Yes)) {
                    if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                        if (canPayUpgrade("addHealth1")) {
                            buyUpgrade("addHealth1");
                            setBool("buyPills", Flagtoggle.No);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                            if (canPayUpgrade("addHealth2")) {
                                buyUpgrade("addHealth2");
                                setBool("buyPills", Flagtoggle.No);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                if (canPayUpgrade("addHealth3")) {
                                    buyUpgrade("addHealth3");
                                }
                            } else {
                                setBool("buyPills", Flagtoggle.No);
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "Mine")) {
                    if (canPayUpgrade("Mine")) {
                        buyUpgrade("Mine");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "TimeBubble")) {
                        if (canPayUpgrade("TimeBubble")) {
                            buyUpgrade("TimeBubble");
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "Healthregen1")) {
                            if (canPayUpgrade("Healthregen1")) {
                                buyUpgrade("Healthregen1");
                            }
                        } else {
                            if (getBoolEquals("enemyDOT", Yesno.Yes)&&isUpgradeEnabled(Yesno.No, "Healthregen2")) {
                                if (canPayUpgrade("Healthregen2")) {
                                    buyUpgrade("Healthregen2");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "JetterMineDamage1")) {
                                    if (canPayUpgrade("JetterMineDamage1")) {
                                        buyUpgrade("JetterMineDamage1");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSpeedup")) {
                                        if (canPayUpgrade("JetterTimebubbleSpeedup")) {
                                            buyUpgrade("JetterTimebubbleSpeedup");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal2")&&isUpgradeEnabled(Yesno.No, "JetterMineLongevity2")) {
                                            if (checkCounter("friendlyTanks", "1", Valuecompare.GreaterOrEqual)||getBoolEquals("buyBubble", Yesno.Yes)) {
                                                if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSize")) {
                                                    if (canPayUpgrade("JetterTimebubbleSize")) {
                                                        buyUpgrade("JetterTimebubbleSize");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSize2")) {
                                                        if (canPayUpgrade("JetterTimebubbleSize2")) {
                                                            buyUpgrade("JetterTimebubbleSize2");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSize3")) {
                                                            if (canPayUpgrade("JetterTimebubbleSize3")) {
                                                                buyUpgrade("JetterTimebubbleSize3");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal1")) {
                                                                if (canPayUpgrade("JetterTimebubbleHeal1")) {
                                                                    buyUpgrade("JetterTimebubbleHeal1");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal2")) {
                                                                    if (canPayUpgrade("JetterTimebubbleHeal2")) {
                                                                        buyUpgrade("JetterTimebubbleHeal2");
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "JetterMineDamage2")) {
                                                                        if (canPayUpgrade("JetterMineDamage2")) {
                                                                            buyUpgrade("JetterMineDamage2");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "JetterMineDamage3")) {
                                                                            if (canPayUpgrade("JetterMineDamage3")) {
                                                                                buyUpgrade("JetterMineDamage3");
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "JetterMineDamage4")) {
                                                                                if (canPayUpgrade("JetterMineDamage4")) {
                                                                                    buyUpgrade("JetterMineDamage4");
                                                                                }
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity")) {
                                                                                    if (canPayUpgrade("JetterMineLongevity")) {
                                                                                        buyUpgrade("JetterMineLongevity");
                                                                                    }
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity2")) {
                                                                                        if (canPayUpgrade("JetterMineLongevity2")) {
                                                                                            buyUpgrade("JetterMineLongevity2");
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
                                                if (isUpgradeEnabled(Yesno.No, "JetterMineDamage2")) {
                                                    if (canPayUpgrade("JetterMineDamage2")) {
                                                        buyUpgrade("JetterMineDamage2");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "JetterMineDamage3")) {
                                                        if (canPayUpgrade("JetterMineDamage3")) {
                                                            buyUpgrade("JetterMineDamage3");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "JetterMineDamage4")) {
                                                            if (canPayUpgrade("JetterMineDamage4")) {
                                                                buyUpgrade("JetterMineDamage4");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity")) {
                                                                if (canPayUpgrade("JetterMineLongevity")) {
                                                                    buyUpgrade("JetterMineLongevity");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.No, "JetterMineLongevity2")) {
                                                                    if (canPayUpgrade("JetterMineLongevity2")) {
                                                                        buyUpgrade("JetterMineLongevity2");
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal1")) {
                                                                        if (canPayUpgrade("JetterTimebubbleHeal1")) {
                                                                            buyUpgrade("JetterTimebubbleHeal1");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleHeal2")) {
                                                                            if (canPayUpgrade("JetterTimebubbleHeal2")) {
                                                                                buyUpgrade("JetterTimebubbleHeal2");
                                                                            }
                                                                        } else {
                                                                            setBool("buyBubble", Flagtoggle.Yes);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "JetterSummonerShotRange")) {
                                                if (canPayUpgrade("JetterSummonerShotRange")) {
                                                    buyUpgrade("JetterSummonerShotRange");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "JetterShotAttackspeed2")&&isUpgradeEnabled(Yesno.No, "JetterShotSlow")) {
                                                    if (isUpgradeEnabled(Yesno.No, "JetterShotAttackspeed")) {
                                                        if (checkCounter("friendlyTanks", "2", Valuecompare.GreaterOrEqual)) {
                                                            if (canPayUpgrade("JetterShotSlow")) {
                                                                buyUpgrade("JetterShotSlow");
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("JetterShotAttackspeed")) {
                                                                buyUpgrade("JetterShotAttackspeed");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("JetterShotAttackspeed2")) {
                                                            buyUpgrade("JetterShotAttackspeed2");
                                                        }
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "JetterShotMoreStages3")) {
                                                        if (canPayUpgrade("JetterShotMoreStages3")) {
                                                            buyUpgrade("JetterShotMoreStages3");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "JetterSpeed")) {
                                                            setBool("buyBoots", Flagtoggle.Yes);
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "Healthregen2")) {
                                                                if (canPayUpgrade("Healthregen2")) {
                                                                    buyUpgrade("Healthregen2");
                                                                }
                                                            } else {
                                                                setBool("buyPills", Flagtoggle.Yes);
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

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(1.0D);
        if (random("2")) {
            adjustCounter("jetterBuild", "1", Valueadjust.Set);
        } else {
            adjustCounter("jetterBuild", "2", Valueadjust.Set);
        }
    }

}

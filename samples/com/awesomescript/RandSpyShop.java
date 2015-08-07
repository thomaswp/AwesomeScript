
package com.awesomescript;

import java.util.EnumSet;

public class RandSpyShop
    extends Script
{


    public void onTick() {
        // Check if enemy team has Maw
        if (once()) {
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                setBool("enemyMaw", Flagtoggle.Yes);
            } else {
                setBool("enemyMaw", Flagtoggle.No);
            }
        }
        // In shop?
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (((isUpgradeEnabled(Yesno.No, "Piggybank")&&getBoolEquals("enemyMaw", Yesno.No))&&isUpgradeEnabled(Yesno.No, "Healthregen1"))&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                buyUpgrade("Piggybank");
            } else {
                if (isUpgradeEnabled(Yesno.No, "SpyAbsorb")) {
                    // Extra starting Solar
                    adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                    if (canPayUpgrade("SpyAbsorb")) {
                        buyUpgrade("SpyAbsorb");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.No, "SpySpeed")&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                        if (canPayUpgrade("SpySpeed")) {
                            buyUpgrade("SpySpeed");
                        }
                    } else {
                        if ((isUpgradeEnabled(Yesno.No, "Piggybank")&&isUpgradeEnabled(Yesno.No, "Healthregen2"))&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                            if (isUpgradeEnabled(Yesno.No, "Healthregen1")) {
                                if (canPayUpgrade("Healthregen1")) {
                                    buyUpgrade("Healthregen1");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "Healthregen2")) {
                                    if (canPayUpgrade("Healthregen2")) {
                                        buyUpgrade("Healthregen2");
                                    }
                                }
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.No, "SpyShootAttackspeed1")) {
                                if (canPayUpgrade("SpyShootAttackspeed1")) {
                                    buyUpgrade("SpyShootAttackspeed1");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "SpyShootAttackspeed2")) {
                                    if (canPayUpgrade("SpyShootAttackspeed2")) {
                                        buyUpgrade("SpyShootAttackspeed2");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "addHealth1")&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                                        if (canPayUpgrade("addHealth1")) {
                                            buyUpgrade("addHealth1");
                                        }
                                    } else {
                                        if (isUpgradeEnabled(Yesno.No, "SpyShootHeal1")&&isUpgradeEnabled(Yesno.No, "SpyShootDetonate1")) {
                                            // Choose Photon Mine build
                                            if (checkCounter("minesBuild", "0", Valuecompare.Equal)) {
                                                if (random("2")) {
                                                    // Not So Serious Tank + Tactical Vest + Dog Tags
                                                    adjustCounter("minesBuild", "1", Valueadjust.Set);
                                                } else {
                                                    // Not So Serious Tank/Drive-Over Skulls + Dog Tags + Counter Intelligence Cross
                                                    adjustCounter("minesBuild", "2", Valueadjust.Set);
                                                }
                                            } else {
                                                if (checkCounter("minesBuild", "1", Valuecompare.Equal)) {
                                                    if (canPayUpgrade("SpyShootHeal1")) {
                                                        buyUpgrade("SpyShootHeal1");
                                                    }
                                                }
                                                if (checkCounter("minesBuild", "2", Valuecompare.Equal)) {
                                                    if (canPayUpgrade("SpyShootDetonate1")) {
                                                        buyUpgrade("SpyShootDetonate1");
                                                    }
                                                }
                                            }
                                        } else {
                                            // Remember Photon Mine build
                                            if (checkCounter("minesBuild", "0", Valuecompare.Equal)) {
                                                if (isUpgradeEnabled(Yesno.Yes, "SpyShootHeal1")) {
                                                    // Not So Serious Tank + Tactical Vest + Dog Tags
                                                    adjustCounter("minesBuild", "1", Valueadjust.Set);
                                                }
                                                if (isUpgradeEnabled(Yesno.Yes, "SpyShootDetonate1")) {
                                                    // Not So Serious Tank/Drive-Over Skulls + Dog Tags + Counter Intelligence Cross
                                                    adjustCounter("minesBuild", "2", Valueadjust.Set);
                                                }
                                            }
                                            if (isUpgradeEnabled(Yesno.No, "addHealth2")&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                                                if (canPayUpgrade("addHealth2")) {
                                                    buyUpgrade("addHealth2");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "SpyShootDamage2")&&isUpgradeEnabled(Yesno.No, "SpyShootArea1")) {
                                                    if (isUpgradeEnabled(Yesno.No, "SpyShootDamage1")) {
                                                        if (random("2")&&checkCounter("minesBuild", "2", Valuecompare.Equal)) {
                                                            if (canPayUpgrade("SpyShootArea1")) {
                                                                buyUpgrade("SpyShootArea1");
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("SpyShootDamage1")) {
                                                                buyUpgrade("SpyShootDamage1");
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("SpyShootDamage2")) {
                                                            buyUpgrade("SpyShootDamage2");
                                                        }
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "addHealth3")&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                                                        if (canPayUpgrade("addHealth3")) {
                                                            buyUpgrade("addHealth3");
                                                        }
                                                    } else {
                                                        // Choose BHS build
                                                        if (checkCounter("BHSBuild", "0", Valuecompare.Equal)) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbFlatDamage1")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamage1")) {
                                                                // Microfilm + Cyanide Cigarettes + Disguise Moustache
                                                                adjustCounter("BHSBuild", "1", Valueadjust.Set);
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamageReduction1")&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                                                                    // Microfilm + Hacking Satellite + Cyanide Cigarettes/Bug Detector/Disguise Moustache
                                                                    adjustCounter("BHSBuild", "2", Valueadjust.Set);
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamageReduction1")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbCooldown1")) {
                                                                        // Microfilm + Hacking Satellite + Cyanide Cigarettes/Bug Detector/Disguise Moustache
                                                                        adjustCounter("BHSBuild", "2", Valueadjust.Set);
                                                                    } else {
                                                                        if (((isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamageReduction1")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbFlatDamage1"))&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage1"))&&isUpgradeEnabled(Yesno.No, "SpyAbsorbCooldown1")) {
                                                                            // Microfilm + Bug Detector + Disguise Moustache
                                                                            adjustCounter("BHSBuild", "3", Valueadjust.Set);
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbCooldown1")) {
                                                                                // Hacking Satellite/Bug Detector + Night Vision Spywatch + Disguise Moustache
                                                                                adjustCounter("BHSBuild", "4", Valueadjust.Set);
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamageReduction1")&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                                                                                    // Hacking Satellite/Bug Detector + Night Vision Spywatch + Disguise Moustache
                                                                                    adjustCounter("BHSBuild", "4", Valueadjust.Set);
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbFlatDamage1")) {
                                                                                        if (random("3")) {
                                                                                            // Microfilm + Cyanide Cigarettes + Disguise Moustache
                                                                                            adjustCounter("BHSBuild", "1", Valueadjust.Set);
                                                                                        } else {
                                                                                            sequence0();
                                                                                        }
                                                                                    } else {
                                                                                        if (random("2")) {
                                                                                            sequence1();
                                                                                        } else {
                                                                                            sequence2();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage3")&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction2")) {
                                                                if (checkCounter("BHSBuild", "2", Valuecompare.Equal)) {
                                                                    if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                                                                        if (canPayUpgrade("SpyAbsorbDamageReduction1")) {
                                                                            buyUpgrade("SpyAbsorbDamageReduction1");
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("SpyAbsorbDamageReduction2")) {
                                                                            buyUpgrade("SpyAbsorbDamageReduction2");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage1")) {
                                                                        if (canPayUpgrade("SpyAbsorbFlatDamage1")) {
                                                                            buyUpgrade("SpyAbsorbFlatDamage1");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage2")) {
                                                                            if (canPayUpgrade("SpyAbsorbFlatDamage2")) {
                                                                                buyUpgrade("SpyAbsorbFlatDamage2");
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("SpyAbsorbFlatDamage3")) {
                                                                                buyUpgrade("SpyAbsorbFlatDamage3");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                if (checkCounter("BHSBuild", "1", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage3")) {
                                                                    if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage1")) {
                                                                        if (canPayUpgrade("SpyAbsorbDamage1")) {
                                                                            buyUpgrade("SpyAbsorbDamage1");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage2")) {
                                                                            if (canPayUpgrade("SpyAbsorbDamage2")) {
                                                                                buyUpgrade("SpyAbsorbDamage2");
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("SpyAbsorbDamage3")) {
                                                                                buyUpgrade("SpyAbsorbDamage3");
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (checkCounter("BHSBuild", "2", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbCooldown2")) {
                                                                        if (isUpgradeEnabled(Yesno.No, "SpyAbsorbCooldown1")) {
                                                                            if (canPayUpgrade("SpyAbsorbCooldown1")) {
                                                                                buyUpgrade("SpyAbsorbCooldown1");
                                                                            }
                                                                        } else {
                                                                            if (canPayUpgrade("SpyAbsorbCooldown2")) {
                                                                                buyUpgrade("SpyAbsorbCooldown2");
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (checkCounter("BHSBuild", "3", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction2")) {
                                                                            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                                                                                if (canPayUpgrade("SpyAbsorbDamageReduction1")) {
                                                                                    buyUpgrade("SpyAbsorbDamageReduction1");
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("SpyAbsorbDamageReduction2")) {
                                                                                    buyUpgrade("SpyAbsorbDamageReduction2");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if ((checkCounter("BHSBuild", "4", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbCooldown2"))&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDouble1")) {
                                                                                if (isUpgradeEnabled(Yesno.No, "SpyAbsorbCooldown1")) {
                                                                                    if (random("2")) {
                                                                                        if (canPayUpgrade("SpyAbsorbCooldown1")) {
                                                                                            buyUpgrade("SpyAbsorbCooldown1");
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("SpyAbsorbDouble1")) {
                                                                                            buyUpgrade("SpyAbsorbDouble1");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (canPayUpgrade("SpyAbsorbCooldown2")) {
                                                                                        buyUpgrade("SpyAbsorbCooldown2");
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (checkCounter("BHSBuild", "1", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction2")) {
                                                                                    if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                                                                                        if (canPayUpgrade("SpyAbsorbDamageReduction1")) {
                                                                                            buyUpgrade("SpyAbsorbDamageReduction1");
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("SpyAbsorbDamageReduction2")) {
                                                                                            buyUpgrade("SpyAbsorbDamageReduction2");
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (((checkCounter("BHSBuild", "2", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage3"))&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDouble1"))&&isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage3")) {
                                                                                        if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage1")&&isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage1")) {
                                                                                            if (random("3")) {
                                                                                                if (canPayUpgrade("SpyAbsorbDamage1")) {
                                                                                                    buyUpgrade("SpyAbsorbDamage1");
                                                                                                }
                                                                                            } else {
                                                                                                sequence3();
                                                                                            }
                                                                                        } else {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbDamage1")) {
                                                                                                if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamage2")) {
                                                                                                    if (canPayUpgrade("SpyAbsorbDamage2")) {
                                                                                                        buyUpgrade("SpyAbsorbDamage2");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (canPayUpgrade("SpyAbsorbDamage3")) {
                                                                                                        buyUpgrade("SpyAbsorbDamage3");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbFlatDamage1")) {
                                                                                                if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage2")) {
                                                                                                    if (canPayUpgrade("SpyAbsorbFlatDamage2")) {
                                                                                                        buyUpgrade("SpyAbsorbFlatDamage2");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (canPayUpgrade("SpyAbsorbFlatDamage3")) {
                                                                                                        buyUpgrade("SpyAbsorbFlatDamage3");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (checkCounter("BHSBuild", "3", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbDouble1")) {
                                                                                            if (canPayUpgrade("SpyAbsorbDouble1")) {
                                                                                                buyUpgrade("SpyAbsorbDouble1");
                                                                                            }
                                                                                        } else {
                                                                                            if (checkCounter("BHSBuild", "4", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyAbsorbSpeed2")) {
                                                                                                if (isUpgradeEnabled(Yesno.No, "SpyAbsorbSpeed1")) {
                                                                                                    if (canPayUpgrade("SpyAbsorbSpeed1")) {
                                                                                                        buyUpgrade("SpyAbsorbSpeed1");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (canPayUpgrade("SpyAbsorbSpeed2")) {
                                                                                                        buyUpgrade("SpyAbsorbSpeed2");
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                if (isUpgradeEnabled(Yesno.No, "SpyBooth")) {
                                                                                                    if (canPayUpgrade("SpyBooth")) {
                                                                                                        buyUpgrade("SpyBooth");
                                                                                                    }
                                                                                                } else {
                                                                                                    // Choose Teleport Beacon build
                                                                                                    if (checkCounter("boothBuild", "0", Valuecompare.Equal)) {
                                                                                                        if (checkCounter("BHSBuild", "1", Valuecompare.Equal)) {
                                                                                                            // Yellow King Pages + Circuits Of Time + Interrogation Answering Machine
                                                                                                            adjustCounter("boothBuild", "1", Valueadjust.Set);
                                                                                                        }
                                                                                                        if (checkCounter("BHSBuild", "2", Valuecompare.Equal)) {
                                                                                                            // Ejection Seat + Interrogation Answering Machine + Ringtones For The Deaf
                                                                                                            adjustCounter("boothBuild", "3", Valueadjust.Set);
                                                                                                        }
                                                                                                        if (checkCounter("BHSBuild", "3", Valuecompare.Equal)) {
                                                                                                            if (isUpgradeEnabled(Yesno.Yes, "SpyBoothClone1")) {
                                                                                                                // Yellow King Pages + Circuits Of Time + Interrogation Answering Machine
                                                                                                                adjustCounter("boothBuild", "1", Valueadjust.Set);
                                                                                                            } else {
                                                                                                                if (isUpgradeEnabled(Yesno.Yes, "SpyBoothDamage1")&&isUpgradeEnabled(Yesno.No, "SpyBoothClone1")) {
                                                                                                                    // Yellow King Pages + Glass Case Of Emotion + Ringtones For The Deaf
                                                                                                                    adjustCounter("boothBuild", "2", Valueadjust.Set);
                                                                                                                } else {
                                                                                                                    if (isUpgradeEnabled(Yesno.Yes, "SpyBoothHeal2")) {
                                                                                                                        // Ejection Seat + Interrogation Answering Machine + Ringtones For The Deaf
                                                                                                                        adjustCounter("boothBuild", "3", Valueadjust.Set);
                                                                                                                    } else {
                                                                                                                        if (random("3")) {
                                                                                                                            // Yellow King Pages + Circuits Of Time + Interrogation Answering Machine
                                                                                                                            adjustCounter("boothBuild", "1", Valueadjust.Set);
                                                                                                                        } else {
                                                                                                                            sequence4();
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (checkCounter("boothBuild", "1", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothClone2")) {
                                                                                                            if (isUpgradeEnabled(Yesno.No, "SpyBoothClone1")) {
                                                                                                                if (canPayUpgrade("SpyBoothClone1")) {
                                                                                                                    buyUpgrade("SpyBoothClone1");
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (canPayUpgrade("SpyBoothClone2")) {
                                                                                                                    buyUpgrade("SpyBoothClone2");
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (checkCounter("boothBuild", "2", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothDamage3")) {
                                                                                                                if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage1")) {
                                                                                                                    if (canPayUpgrade("SpyBoothDamage1")) {
                                                                                                                        buyUpgrade("SpyBoothDamage1");
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage2")) {
                                                                                                                        if (canPayUpgrade("SpyBoothDamage2")) {
                                                                                                                            buyUpgrade("SpyBoothDamage2");
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (canPayUpgrade("SpyBoothDamage3")) {
                                                                                                                            buyUpgrade("SpyBoothDamage3");
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (checkCounter("boothBuild", "3", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothHeal2")) {
                                                                                                                    if (isUpgradeEnabled(Yesno.No, "SpyBoothHeal1")) {
                                                                                                                        if (canPayUpgrade("SpyBoothHeal1")) {
                                                                                                                            buyUpgrade("SpyBoothHeal1");
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (canPayUpgrade("SpyBoothHeal2")) {
                                                                                                                            buyUpgrade("SpyBoothHeal2");
                                                                                                                        }
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (checkCounter("boothBuild", "1", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothDamage3")) {
                                                                                                                        if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage1")) {
                                                                                                                            if (canPayUpgrade("SpyBoothDamage1")) {
                                                                                                                                buyUpgrade("SpyBoothDamage1");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage2")) {
                                                                                                                                if (canPayUpgrade("SpyBoothDamage2")) {
                                                                                                                                    buyUpgrade("SpyBoothDamage2");
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (canPayUpgrade("SpyBoothDamage3")) {
                                                                                                                                    buyUpgrade("SpyBoothDamage3");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (checkCounter("boothBuild", "2", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothSilence1")) {
                                                                                                                            if (canPayUpgrade("SpyBoothSilence1")) {
                                                                                                                                buyUpgrade("SpyBoothSilence1");
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (checkCounter("boothBuild", "3", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothSilence1")) {
                                                                                                                                if (canPayUpgrade("SpyBoothSilence1")) {
                                                                                                                                    buyUpgrade("SpyBoothSilence1");
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (checkCounter("boothBuild", "1", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothShoot1")) {
                                                                                                                                    if (canPayUpgrade("SpyBoothShoot1")) {
                                                                                                                                        buyUpgrade("SpyBoothShoot1");
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (checkCounter("boothBuild", "2", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothStealth1")) {
                                                                                                                                        if (canPayUpgrade("SpyBoothStealth1")) {
                                                                                                                                            buyUpgrade("SpyBoothStealth1");
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if (checkCounter("boothBuild", "3", Valuecompare.Equal)&&isUpgradeEnabled(Yesno.No, "SpyBoothShoot1")) {
                                                                                                                                            if (canPayUpgrade("SpyBoothShoot1")) {
                                                                                                                                                buyUpgrade("SpyBoothShoot1");
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
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.1D);
        if (random("2")) {
            // Microfilm + Bug Detector + Disguise Moustache
            adjustCounter("BHSBuild", "3", Valueadjust.Set);
        } else {
            // Hacking Satellite/Bug Detector + Night Vision Spywatch + Disguise Moustache
            adjustCounter("BHSBuild", "4", Valueadjust.Set);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.1D);
        if (random("2")) {
            // Microfilm + Cyanide Cigarettes + Disguise Moustache
            adjustCounter("BHSBuild", "1", Valueadjust.Set);
        } else {
            // Microfilm + Hacking Satellite + Cyanide Cigarettes/Bug Detector/Disguise Moustache
            adjustCounter("BHSBuild", "2", Valueadjust.Set);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.1D);
        if (random("2")) {
            // Microfilm + Bug Detector + Disguise Moustache
            adjustCounter("BHSBuild", "3", Valueadjust.Set);
        } else {
            // Hacking Satellite/Bug Detector + Night Vision Spywatch + Disguise Moustache
            adjustCounter("BHSBuild", "4", Valueadjust.Set);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.1D);
        if (random("2")) {
            if (canPayUpgrade("SpyAbsorbDouble1")) {
                buyUpgrade("SpyAbsorbDouble1");
            }
        } else {
            if (canPayUpgrade("SpyAbsorbFlatDamage1")) {
                buyUpgrade("SpyAbsorbFlatDamage1");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.1D);
        if (random("2")) {
            // Yellow King Pages + Glass Case Of Emotion + Ringtones For The Deaf
            adjustCounter("boothBuild", "2", Valueadjust.Set);
        } else {
            // Ejection Seat + Interrogation Answering Machine + Ringtones For The Deaf
            adjustCounter("boothBuild", "3", Valueadjust.Set);
        }
    }

}

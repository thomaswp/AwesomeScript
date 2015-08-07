
package com.awesomescript;

import java.util.EnumSet;

public class DasherShop
    extends Script
{


    public void onTick() {
        if (once()) {
            adjustCounter("rbayPro", "0", Valueadjust.Set);
            adjustCounter("rbayCon", "0", Valueadjust.Set);
            // rbay (derpl+)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy")) {
                adjustCounter("rbayPro", "2", Valueadjust.Add);
            }
            // Ted McPain (rbay+)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Commando")) {
                adjustCounter("rbayPro", "1", Valueadjust.Add);
            }
            // Lonestar (rbay+)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Cowboy")) {
                adjustCounter("rbayPro", "1", Valueadjust.Add);
            }
            // Coco (rbay+)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Blazer")) {
                adjustCounter("rbayPro", "1", Valueadjust.Add);
            }
            // Leon (rbay-)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Chameleon")) {
                adjustCounter("rbayCon", "1", Valueadjust.Add);
            }
            // Skolldir (rbay-)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")) {
                adjustCounter("rbayCon", "1", Valueadjust.Add);
            }
            // Yuri (rbay-)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter")) {
                adjustCounter("rbayCon", "1", Valueadjust.Add);
            }
            // Skree (rbay-)
            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Shaman")) {
                adjustCounter("rbayCon", "1", Valueadjust.Add);
            }
            if (checkCounter("rbayPro", "rbayCon", Valuecompare.Greater)) {
                setBool("useRbay", Flagtoggle.Yes);
            } else {
                if (checkCounter("rbayPro", "rbayCon", Valuecompare.Less)) {
                    setBool("useRbay", Flagtoggle.No);
                } else {
                    if (random("2")) {
                        setBool("useRbay", Flagtoggle.Yes);
                    }
                }
            }
        }
        // Am I in shop?
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.No, "DASH")) {
                if (canPayUpgrade("DASH")) {
                    buyUpgrade("DASH");
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "WHIRLWIND")) {
                    if (canPayUpgrade("WHIRLWIND")) {
                        buyUpgrade("WHIRLWIND");
                    }
                } else {
                    if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)||isUpgradeEnabled(Yesno.Yes, "PiggyBank")) {
                        if (isUpgradeEnabled(Yesno.Yes, "DASHERSPEED")||checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                            if (isUpgradeEnabled(Yesno.No, "DasherShotRange")) {
                                if (canPayUpgrade("DasherShotRange")) {
                                    buyUpgrade("DasherShotRange");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.No, "DasherDashDamage6")) {
                                    if (canPayUpgrade("DasherDashDamage6")) {
                                        buyUpgrade("DasherDashDamage6");
                                    }
                                } else {
                                    if (isUpgradeEnabled(Yesno.No, "DASHERWHIRLWINDSPEED1")) {
                                        if (canPayUpgrade("DASHERWHIRLWINDSPEED1")) {
                                            buyUpgrade("DASHERWHIRLWINDSPEED1");
                                        }
                                    } else {
                                        if (getBoolEquals("useRbay", Yesno.No)) {
                                            if (isUpgradeEnabled(Yesno.No, "DASHERWHIRLWINDSHIELD")) {
                                                if (canPayUpgrade("DASHERWHIRLWINDSHIELD")) {
                                                    buyUpgrade("DASHERWHIRLWINDSHIELD");
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.No, "DasherWhirlwindReflect")) {
                                                if (canPayUpgrade("DasherWhirlwindReflect")) {
                                                    buyUpgrade("DasherWhirlwindReflect");
                                                }
                                            }
                                        }
                                        if (isUpgradeEnabled(Yesno.Yes, "DASHERWHIRLWINDSHIELD")||isUpgradeEnabled(Yesno.Yes, "DASHERWHIRLWINDREFLECT")) {
                                            if (isUpgradeEnabled(Yesno.No, "DasherWhirlwindExplode1")) {
                                                if (canPayUpgrade("DasherWhirlwindExplode1")) {
                                                    buyUpgrade("DasherWhirlwindExplode1");
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.No, "DASHERWHIRLWINDEXPLODE2")) {
                                                    if (canPayUpgrade("DASHERWHIRLWINDEXPLODE2")) {
                                                        buyUpgrade("DASHERWHIRLWINDEXPLODE2");
                                                    }
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.No, "DASHERWHIRLWINDSPEED2")) {
                                                        if (canPayUpgrade("DASHERWHIRLWINDSPEED2")) {
                                                            buyUpgrade("DASHERWHIRLWINDSPEED2");
                                                        }
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.No, "DASHERDASHSTUN1")) {
                                                            if (canPayUpgrade("DASHERDASHSTUN1")) {
                                                                buyUpgrade("DASHERDASHSTUN1");
                                                            }
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.No, "DASHERDASHSTUN2")) {
                                                                if (canPayUpgrade("DASHERDASHSTUN2")) {
                                                                    buyUpgrade("DASHERDASHSTUN2");
                                                                }
                                                            } else {
                                                                if (isUpgradeEnabled(Yesno.Yes, "addHealth1")||checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                                                                    if (isUpgradeEnabled(Yesno.No, "DasherShotFaster")) {
                                                                        if (canPayUpgrade("DasherShotFaster")) {
                                                                            buyUpgrade("DasherShotFaster");
                                                                        }
                                                                    } else {
                                                                        if (isUpgradeEnabled(Yesno.No, "DasherShotDamage")) {
                                                                            if (canPayUpgrade("DasherShotDamage")) {
                                                                                buyUpgrade("DasherShotDamage");
                                                                            }
                                                                        } else {
                                                                            if (isUpgradeEnabled(Yesno.No, "DASHERSHOTFASTER2")) {
                                                                                if (canPayUpgrade("DASHERSHOTFASTER2")) {
                                                                                    buyUpgrade("DASHERSHOTFASTER2");
                                                                                }
                                                                            } else {
                                                                                if (isUpgradeEnabled(Yesno.No, "DasherShotDamage2")) {
                                                                                    if (canPayUpgrade("DasherShotDamage2")) {
                                                                                        buyUpgrade("DasherShotDamage2");
                                                                                    }
                                                                                } else {
                                                                                    if (isUpgradeEnabled(Yesno.No, "DasherShotFaster3")) {
                                                                                        if (canPayUpgrade("DasherShotFaster3")) {
                                                                                            buyUpgrade("DasherShotFaster3");
                                                                                        }
                                                                                    } else {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "addHealth2")||checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                                                                                            if (isUpgradeEnabled(Yesno.No, "DasherDashDamage1")) {
                                                                                                if (canPayUpgrade("DasherDashDamage1")) {
                                                                                                    buyUpgrade("DasherDashDamage1");
                                                                                                }
                                                                                            } else {
                                                                                                if (isUpgradeEnabled(Yesno.No, "DasherDashDamage2")) {
                                                                                                    if (canPayUpgrade("DasherDashDamage2")) {
                                                                                                        buyUpgrade("DasherDashDamage2");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (isUpgradeEnabled(Yesno.No, "DasherDashDamage3")) {
                                                                                                        if (canPayUpgrade("DasherDashDamage3")) {
                                                                                                            buyUpgrade("DasherDashDamage3");
                                                                                                        }
                                                                                                    } else {
                                                                                                        // are we dumb?
                                                                                                        if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                                                                                                        } else {
                                                                                                            // nope, buy pills 3
                                                                                                            if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                                                                                                if (canPayUpgrade("addHealth3")) {
                                                                                                                    buyUpgrade("addHealth3");
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (canPayUpgrade("addHealth2")) {
                                                                                                buyUpgrade("addHealth2");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("addHealth1")) {
                                                                        buyUpgrade("addHealth1");
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
                            if (canPayUpgrade("DASHERSPEED")) {
                                buyUpgrade("DASHERSPEED");
                            }
                        }
                    } else {
                        if (canPayUpgrade("PiggyBank")) {
                            buyUpgrade("PiggyBank");
                        }
                    }
                }
            }
        }
    }

}

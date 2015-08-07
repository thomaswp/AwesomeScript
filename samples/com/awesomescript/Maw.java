
package com.awesomescript;

import java.util.EnumSet;

public class Maw
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (once()) {
            // set max chunks
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
                adjustCounter("TurretChunks", "3", Valueadjust.Set);
            } else {
                adjustCounter("TurretChunks", "5", Valueadjust.Set);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawBiteHit")||isUpgradeEnabled(Yesno.Yes, "MawBiteHitCreeps")) {
            log("Eating!", "", "");
            if (isUpgradeEnabled(Yesno.Yes, "MawTurret")) {
                adjustCounter("TurretChunks", "1", Valueadjust.Add);
            }
            if (isUpgradeEnabled(Yesno.Yes, "MawShotSpeedUp")) {
                enableUpgrade(Yesno.Yes, "MawSpeedUp");
                adjustCounter("SpeedUpTimer", "6", Valueadjust.Set);
            }
            enableUpgrade(Yesno.No, "MawBiteHitCreeps");
            enableUpgrade(Yesno.No, "MawBiteHit");
        }
        if (checkCounter("SpeedUpTimer", "0", Valuecompare.Greater)) {
            if (timer(Timeunits.Seconds, 0.25D, Yesno.No)) {
                adjustCounter("SpeedUpTimer", "-1", Valueadjust.Add);
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "MawSpeedUp")) {
                enableUpgrade(Yesno.No, "MawSpeedUp");
            }
        }
        // set max chunks
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkCounter("TurretChunks", "6", Valuecompare.Greater)) {
                adjustCounter("TurretChunks", "6", Valueadjust.Set);
            }
        } else {
            if (checkCounter("TurretChunks", "10", Valuecompare.Greater)) {
                adjustCounter("TurretChunks", "10", Valueadjust.Set);
            }
        }
        // enable turret building
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkCounter("TurretChunks", "3", Valuecompare.Less)) {
                enableUpgrade(Yesno.No, "TurretAvailable");
            } else {
                enableUpgrade(Yesno.Yes, "TurretAvailable");
            }
        } else {
            if (checkCounter("TurretChunks", "5", Valuecompare.Less)) {
                enableUpgrade(Yesno.No, "TurretAvailable");
            } else {
                enableUpgrade(Yesno.Yes, "TurretAvailable");
            }
        }
        // turret build remove chunks
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretCreated")) {
            enableUpgrade(Yesno.No, "MawTurretCreated");
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
                sequence0();
            } else {
                sequence1();
            }
        }
        // set icons
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkCounter("TurretChunks", "9", Valuecompare.Equal)) {
                enableUpgrade(Yesno.No, "MawBite0");
                enableUpgrade(Yesno.No, "MawBite1");
                enableUpgrade(Yesno.No, "MawBite2");
                enableUpgrade(Yesno.No, "MawBite3");
                enableUpgrade(Yesno.No, "MawBite4");
                enableUpgrade(Yesno.No, "MawBite5");
                enableUpgrade(Yesno.No, "MawBite6");
                enableUpgrade(Yesno.No, "MawBite7");
                enableUpgrade(Yesno.No, "MawBite8");
                enableUpgrade(Yesno.No, "MawBite9");
                enableUpgrade(Yesno.No, "MawBite10");
                enableUpgrade(Yesno.No, "MawBite11");
                enableUpgrade(Yesno.No, "MawBite12");
                enableUpgrade(Yesno.No, "MawBite13");
                enableUpgrade(Yesno.No, "MawBite14");
                enableUpgrade(Yesno.Yes, "MawBite15");
            } else {
                if (checkCounter("TurretChunks", "8", Valuecompare.Equal)) {
                    enableUpgrade(Yesno.No, "MawBite0");
                    enableUpgrade(Yesno.No, "MawBite1");
                    enableUpgrade(Yesno.No, "MawBite2");
                    enableUpgrade(Yesno.No, "MawBite3");
                    enableUpgrade(Yesno.No, "MawBite4");
                    enableUpgrade(Yesno.No, "MawBite5");
                    enableUpgrade(Yesno.No, "MawBite6");
                    enableUpgrade(Yesno.No, "MawBite7");
                    enableUpgrade(Yesno.No, "MawBite8");
                    enableUpgrade(Yesno.No, "MawBite9");
                    enableUpgrade(Yesno.No, "MawBite10");
                    enableUpgrade(Yesno.No, "MawBite11");
                    enableUpgrade(Yesno.No, "MawBite12");
                    enableUpgrade(Yesno.No, "MawBite13");
                    enableUpgrade(Yesno.Yes, "MawBite14");
                    enableUpgrade(Yesno.No, "MawBite15");
                } else {
                    if (checkCounter("TurretChunks", "7", Valuecompare.Equal)) {
                        enableUpgrade(Yesno.No, "MawBite0");
                        enableUpgrade(Yesno.No, "MawBite1");
                        enableUpgrade(Yesno.No, "MawBite2");
                        enableUpgrade(Yesno.No, "MawBite3");
                        enableUpgrade(Yesno.No, "MawBite4");
                        enableUpgrade(Yesno.No, "MawBite5");
                        enableUpgrade(Yesno.No, "MawBite6");
                        enableUpgrade(Yesno.No, "MawBite7");
                        enableUpgrade(Yesno.No, "MawBite8");
                        enableUpgrade(Yesno.No, "MawBite9");
                        enableUpgrade(Yesno.No, "MawBite10");
                        enableUpgrade(Yesno.No, "MawBite11");
                        enableUpgrade(Yesno.No, "MawBite12");
                        enableUpgrade(Yesno.Yes, "MawBite13");
                        enableUpgrade(Yesno.No, "MawBite14");
                        enableUpgrade(Yesno.No, "MawBite15");
                    } else {
                        if (checkCounter("TurretChunks", "6", Valuecompare.Equal)) {
                            enableUpgrade(Yesno.No, "MawBite0");
                            enableUpgrade(Yesno.No, "MawBite1");
                            enableUpgrade(Yesno.No, "MawBite2");
                            enableUpgrade(Yesno.No, "MawBite3");
                            enableUpgrade(Yesno.No, "MawBite4");
                            enableUpgrade(Yesno.No, "MawBite5");
                            enableUpgrade(Yesno.No, "MawBite6");
                            enableUpgrade(Yesno.No, "MawBite7");
                            enableUpgrade(Yesno.No, "MawBite8");
                            enableUpgrade(Yesno.No, "MawBite9");
                            enableUpgrade(Yesno.Yes, "MawBite10");
                            enableUpgrade(Yesno.No, "MawBite11");
                            enableUpgrade(Yesno.No, "MawBite12");
                            enableUpgrade(Yesno.No, "MawBite13");
                            enableUpgrade(Yesno.No, "MawBite14");
                            enableUpgrade(Yesno.No, "MawBite15");
                        } else {
                            if (checkCounter("TurretChunks", "5", Valuecompare.Equal)) {
                                enableUpgrade(Yesno.No, "MawBite0");
                                enableUpgrade(Yesno.No, "MawBite1");
                                enableUpgrade(Yesno.No, "MawBite2");
                                enableUpgrade(Yesno.No, "MawBite3");
                                enableUpgrade(Yesno.No, "MawBite4");
                                enableUpgrade(Yesno.No, "MawBite5");
                                enableUpgrade(Yesno.No, "MawBite6");
                                enableUpgrade(Yesno.No, "MawBite7");
                                enableUpgrade(Yesno.No, "MawBite8");
                                enableUpgrade(Yesno.Yes, "MawBite9");
                                enableUpgrade(Yesno.No, "MawBite10");
                                enableUpgrade(Yesno.No, "MawBite11");
                                enableUpgrade(Yesno.No, "MawBite12");
                                enableUpgrade(Yesno.No, "MawBite13");
                                enableUpgrade(Yesno.No, "MawBite14");
                                enableUpgrade(Yesno.No, "MawBite15");
                            } else {
                                if (checkCounter("TurretChunks", "4", Valuecompare.Equal)) {
                                    enableUpgrade(Yesno.No, "MawBite0");
                                    enableUpgrade(Yesno.No, "MawBite1");
                                    enableUpgrade(Yesno.No, "MawBite2");
                                    enableUpgrade(Yesno.No, "MawBite3");
                                    enableUpgrade(Yesno.No, "MawBite4");
                                    enableUpgrade(Yesno.No, "MawBite5");
                                    enableUpgrade(Yesno.No, "MawBite6");
                                    enableUpgrade(Yesno.No, "MawBite7");
                                    enableUpgrade(Yesno.Yes, "MawBite8");
                                    enableUpgrade(Yesno.No, "MawBite9");
                                    enableUpgrade(Yesno.No, "MawBite10");
                                    enableUpgrade(Yesno.No, "MawBite11");
                                    enableUpgrade(Yesno.No, "MawBite12");
                                    enableUpgrade(Yesno.No, "MawBite13");
                                    enableUpgrade(Yesno.No, "MawBite14");
                                    enableUpgrade(Yesno.No, "MawBite15");
                                } else {
                                    if (checkCounter("TurretChunks", "3", Valuecompare.Equal)) {
                                        enableUpgrade(Yesno.No, "MawBite0");
                                        enableUpgrade(Yesno.No, "MawBite1");
                                        enableUpgrade(Yesno.No, "MawBite2");
                                        enableUpgrade(Yesno.No, "MawBite3");
                                        enableUpgrade(Yesno.No, "MawBite4");
                                        enableUpgrade(Yesno.Yes, "MawBite5");
                                        enableUpgrade(Yesno.No, "MawBite6");
                                        enableUpgrade(Yesno.No, "MawBite7");
                                        enableUpgrade(Yesno.No, "MawBite8");
                                        enableUpgrade(Yesno.No, "MawBite9");
                                        enableUpgrade(Yesno.No, "MawBite10");
                                        enableUpgrade(Yesno.No, "MawBite11");
                                        enableUpgrade(Yesno.No, "MawBite12");
                                        enableUpgrade(Yesno.No, "MawBite13");
                                        enableUpgrade(Yesno.No, "MawBite14");
                                        enableUpgrade(Yesno.No, "MawBite15");
                                    } else {
                                        if (checkCounter("TurretChunks", "2", Valuecompare.Equal)) {
                                            enableUpgrade(Yesno.No, "MawBite0");
                                            enableUpgrade(Yesno.No, "MawBite1");
                                            enableUpgrade(Yesno.No, "MawBite2");
                                            enableUpgrade(Yesno.No, "MawBite3");
                                            enableUpgrade(Yesno.Yes, "MawBite4");
                                            enableUpgrade(Yesno.No, "MawBite5");
                                            enableUpgrade(Yesno.No, "MawBite6");
                                            enableUpgrade(Yesno.No, "MawBite7");
                                            enableUpgrade(Yesno.No, "MawBite8");
                                            enableUpgrade(Yesno.No, "MawBite9");
                                            enableUpgrade(Yesno.No, "MawBite10");
                                            enableUpgrade(Yesno.No, "MawBite11");
                                            enableUpgrade(Yesno.No, "MawBite12");
                                            enableUpgrade(Yesno.No, "MawBite13");
                                            enableUpgrade(Yesno.No, "MawBite14");
                                            enableUpgrade(Yesno.No, "MawBite15");
                                        } else {
                                            if (checkCounter("TurretChunks", "1", Valuecompare.Equal)) {
                                                enableUpgrade(Yesno.No, "MawBite0");
                                                enableUpgrade(Yesno.No, "MawBite1");
                                                enableUpgrade(Yesno.No, "MawBite2");
                                                enableUpgrade(Yesno.Yes, "MawBite3");
                                                enableUpgrade(Yesno.No, "MawBite4");
                                                enableUpgrade(Yesno.No, "MawBite5");
                                                enableUpgrade(Yesno.No, "MawBite6");
                                                enableUpgrade(Yesno.No, "MawBite7");
                                                enableUpgrade(Yesno.No, "MawBite8");
                                                enableUpgrade(Yesno.No, "MawBite9");
                                                enableUpgrade(Yesno.No, "MawBite10");
                                                enableUpgrade(Yesno.No, "MawBite11");
                                                enableUpgrade(Yesno.No, "MawBite12");
                                                enableUpgrade(Yesno.No, "MawBite13");
                                                enableUpgrade(Yesno.No, "MawBite14");
                                                enableUpgrade(Yesno.No, "MawBite15");
                                            } else {
                                                if (checkCounter("TurretChunks", "0", Valuecompare.Equal)) {
                                                    enableUpgrade(Yesno.Yes, "MawBite0");
                                                    enableUpgrade(Yesno.No, "MawBite1");
                                                    enableUpgrade(Yesno.No, "MawBite2");
                                                    enableUpgrade(Yesno.No, "MawBite3");
                                                    enableUpgrade(Yesno.No, "MawBite4");
                                                    enableUpgrade(Yesno.No, "MawBite5");
                                                    enableUpgrade(Yesno.No, "MawBite6");
                                                    enableUpgrade(Yesno.No, "MawBite7");
                                                    enableUpgrade(Yesno.No, "MawBite8");
                                                    enableUpgrade(Yesno.No, "MawBite9");
                                                    enableUpgrade(Yesno.No, "MawBite10");
                                                    enableUpgrade(Yesno.No, "MawBite11");
                                                    enableUpgrade(Yesno.No, "MawBite12");
                                                    enableUpgrade(Yesno.No, "MawBite13");
                                                    enableUpgrade(Yesno.No, "MawBite14");
                                                    enableUpgrade(Yesno.No, "MawBite15");
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
            if (checkCounter("TurretChunks", "15", Valuecompare.Equal)) {
                enableUpgrade(Yesno.No, "MawBite0");
                enableUpgrade(Yesno.No, "MawBite1");
                enableUpgrade(Yesno.No, "MawBite2");
                enableUpgrade(Yesno.No, "MawBite3");
                enableUpgrade(Yesno.No, "MawBite4");
                enableUpgrade(Yesno.No, "MawBite5");
                enableUpgrade(Yesno.No, "MawBite6");
                enableUpgrade(Yesno.No, "MawBite7");
                enableUpgrade(Yesno.No, "MawBite8");
                enableUpgrade(Yesno.No, "MawBite9");
                enableUpgrade(Yesno.No, "MawBite10");
                enableUpgrade(Yesno.No, "MawBite11");
                enableUpgrade(Yesno.No, "MawBite12");
                enableUpgrade(Yesno.No, "MawBite13");
                enableUpgrade(Yesno.No, "MawBite14");
                enableUpgrade(Yesno.Yes, "MawBite15");
            } else {
                if (checkCounter("TurretChunks", "14", Valuecompare.Equal)) {
                    enableUpgrade(Yesno.No, "MawBite0");
                    enableUpgrade(Yesno.No, "MawBite1");
                    enableUpgrade(Yesno.No, "MawBite2");
                    enableUpgrade(Yesno.No, "MawBite3");
                    enableUpgrade(Yesno.No, "MawBite4");
                    enableUpgrade(Yesno.No, "MawBite5");
                    enableUpgrade(Yesno.No, "MawBite6");
                    enableUpgrade(Yesno.No, "MawBite7");
                    enableUpgrade(Yesno.No, "MawBite8");
                    enableUpgrade(Yesno.No, "MawBite9");
                    enableUpgrade(Yesno.No, "MawBite10");
                    enableUpgrade(Yesno.No, "MawBite11");
                    enableUpgrade(Yesno.No, "MawBite12");
                    enableUpgrade(Yesno.No, "MawBite13");
                    enableUpgrade(Yesno.Yes, "MawBite14");
                    enableUpgrade(Yesno.No, "MawBite15");
                } else {
                    if (checkCounter("TurretChunks", "13", Valuecompare.Equal)) {
                        enableUpgrade(Yesno.No, "MawBite0");
                        enableUpgrade(Yesno.No, "MawBite1");
                        enableUpgrade(Yesno.No, "MawBite2");
                        enableUpgrade(Yesno.No, "MawBite3");
                        enableUpgrade(Yesno.No, "MawBite4");
                        enableUpgrade(Yesno.No, "MawBite5");
                        enableUpgrade(Yesno.No, "MawBite6");
                        enableUpgrade(Yesno.No, "MawBite7");
                        enableUpgrade(Yesno.No, "MawBite8");
                        enableUpgrade(Yesno.No, "MawBite9");
                        enableUpgrade(Yesno.No, "MawBite10");
                        enableUpgrade(Yesno.No, "MawBite11");
                        enableUpgrade(Yesno.No, "MawBite12");
                        enableUpgrade(Yesno.Yes, "MawBite13");
                        enableUpgrade(Yesno.No, "MawBite14");
                        enableUpgrade(Yesno.No, "MawBite15");
                    } else {
                        if (checkCounter("TurretChunks", "12", Valuecompare.Equal)) {
                            enableUpgrade(Yesno.No, "MawBite0");
                            enableUpgrade(Yesno.No, "MawBite1");
                            enableUpgrade(Yesno.No, "MawBite2");
                            enableUpgrade(Yesno.No, "MawBite3");
                            enableUpgrade(Yesno.No, "MawBite4");
                            enableUpgrade(Yesno.No, "MawBite5");
                            enableUpgrade(Yesno.No, "MawBite6");
                            enableUpgrade(Yesno.No, "MawBite7");
                            enableUpgrade(Yesno.No, "MawBite8");
                            enableUpgrade(Yesno.No, "MawBite9");
                            enableUpgrade(Yesno.No, "MawBite10");
                            enableUpgrade(Yesno.No, "MawBite11");
                            enableUpgrade(Yesno.Yes, "MawBite12");
                            enableUpgrade(Yesno.No, "MawBite13");
                            enableUpgrade(Yesno.No, "MawBite14");
                            enableUpgrade(Yesno.No, "MawBite15");
                        } else {
                            if (checkCounter("TurretChunks", "11", Valuecompare.Equal)) {
                                enableUpgrade(Yesno.No, "MawBite0");
                                enableUpgrade(Yesno.No, "MawBite1");
                                enableUpgrade(Yesno.No, "MawBite2");
                                enableUpgrade(Yesno.No, "MawBite3");
                                enableUpgrade(Yesno.No, "MawBite4");
                                enableUpgrade(Yesno.No, "MawBite5");
                                enableUpgrade(Yesno.No, "MawBite6");
                                enableUpgrade(Yesno.No, "MawBite7");
                                enableUpgrade(Yesno.No, "MawBite8");
                                enableUpgrade(Yesno.No, "MawBite9");
                                enableUpgrade(Yesno.No, "MawBite10");
                                enableUpgrade(Yesno.Yes, "MawBite11");
                                enableUpgrade(Yesno.No, "MawBite12");
                                enableUpgrade(Yesno.No, "MawBite13");
                                enableUpgrade(Yesno.No, "MawBite14");
                                enableUpgrade(Yesno.No, "MawBite15");
                            } else {
                                if (checkCounter("TurretChunks", "10", Valuecompare.Equal)) {
                                    enableUpgrade(Yesno.No, "MawBite0");
                                    enableUpgrade(Yesno.No, "MawBite1");
                                    enableUpgrade(Yesno.No, "MawBite2");
                                    enableUpgrade(Yesno.No, "MawBite3");
                                    enableUpgrade(Yesno.No, "MawBite4");
                                    enableUpgrade(Yesno.No, "MawBite5");
                                    enableUpgrade(Yesno.No, "MawBite6");
                                    enableUpgrade(Yesno.No, "MawBite7");
                                    enableUpgrade(Yesno.No, "MawBite8");
                                    enableUpgrade(Yesno.No, "MawBite9");
                                    enableUpgrade(Yesno.Yes, "MawBite10");
                                    enableUpgrade(Yesno.No, "MawBite11");
                                    enableUpgrade(Yesno.No, "MawBite12");
                                    enableUpgrade(Yesno.No, "MawBite13");
                                    enableUpgrade(Yesno.No, "MawBite14");
                                    enableUpgrade(Yesno.No, "MawBite15");
                                } else {
                                    if (checkCounter("TurretChunks", "9", Valuecompare.Equal)) {
                                        enableUpgrade(Yesno.No, "MawBite0");
                                        enableUpgrade(Yesno.No, "MawBite1");
                                        enableUpgrade(Yesno.No, "MawBite2");
                                        enableUpgrade(Yesno.No, "MawBite3");
                                        enableUpgrade(Yesno.No, "MawBite4");
                                        enableUpgrade(Yesno.No, "MawBite5");
                                        enableUpgrade(Yesno.No, "MawBite6");
                                        enableUpgrade(Yesno.No, "MawBite7");
                                        enableUpgrade(Yesno.No, "MawBite8");
                                        enableUpgrade(Yesno.Yes, "MawBite9");
                                        enableUpgrade(Yesno.No, "MawBite10");
                                        enableUpgrade(Yesno.No, "MawBite11");
                                        enableUpgrade(Yesno.No, "MawBite12");
                                        enableUpgrade(Yesno.No, "MawBite13");
                                        enableUpgrade(Yesno.No, "MawBite14");
                                        enableUpgrade(Yesno.No, "MawBite15");
                                    } else {
                                        if (checkCounter("TurretChunks", "8", Valuecompare.Equal)) {
                                            enableUpgrade(Yesno.No, "MawBite0");
                                            enableUpgrade(Yesno.No, "MawBite1");
                                            enableUpgrade(Yesno.No, "MawBite2");
                                            enableUpgrade(Yesno.No, "MawBite3");
                                            enableUpgrade(Yesno.No, "MawBite4");
                                            enableUpgrade(Yesno.No, "MawBite5");
                                            enableUpgrade(Yesno.No, "MawBite6");
                                            enableUpgrade(Yesno.No, "MawBite7");
                                            enableUpgrade(Yesno.Yes, "MawBite8");
                                            enableUpgrade(Yesno.No, "MawBite9");
                                            enableUpgrade(Yesno.No, "MawBite10");
                                            enableUpgrade(Yesno.No, "MawBite11");
                                            enableUpgrade(Yesno.No, "MawBite12");
                                            enableUpgrade(Yesno.No, "MawBite13");
                                            enableUpgrade(Yesno.No, "MawBite14");
                                            enableUpgrade(Yesno.No, "MawBite15");
                                        } else {
                                            if (checkCounter("TurretChunks", "7", Valuecompare.Equal)) {
                                                enableUpgrade(Yesno.No, "MawBite0");
                                                enableUpgrade(Yesno.No, "MawBite1");
                                                enableUpgrade(Yesno.No, "MawBite2");
                                                enableUpgrade(Yesno.No, "MawBite3");
                                                enableUpgrade(Yesno.No, "MawBite4");
                                                enableUpgrade(Yesno.No, "MawBite5");
                                                enableUpgrade(Yesno.No, "MawBite6");
                                                enableUpgrade(Yesno.Yes, "MawBite7");
                                                enableUpgrade(Yesno.No, "MawBite8");
                                                enableUpgrade(Yesno.No, "MawBite9");
                                                enableUpgrade(Yesno.No, "MawBite10");
                                                enableUpgrade(Yesno.No, "MawBite11");
                                                enableUpgrade(Yesno.No, "MawBite12");
                                                enableUpgrade(Yesno.No, "MawBite13");
                                                enableUpgrade(Yesno.No, "MawBite14");
                                                enableUpgrade(Yesno.No, "MawBite15");
                                            } else {
                                                if (checkCounter("TurretChunks", "6", Valuecompare.Equal)) {
                                                    enableUpgrade(Yesno.No, "MawBite0");
                                                    enableUpgrade(Yesno.No, "MawBite1");
                                                    enableUpgrade(Yesno.No, "MawBite2");
                                                    enableUpgrade(Yesno.No, "MawBite3");
                                                    enableUpgrade(Yesno.No, "MawBite4");
                                                    enableUpgrade(Yesno.No, "MawBite5");
                                                    enableUpgrade(Yesno.Yes, "MawBite6");
                                                    enableUpgrade(Yesno.No, "MawBite7");
                                                    enableUpgrade(Yesno.No, "MawBite8");
                                                    enableUpgrade(Yesno.No, "MawBite9");
                                                    enableUpgrade(Yesno.No, "MawBite10");
                                                    enableUpgrade(Yesno.No, "MawBite11");
                                                    enableUpgrade(Yesno.No, "MawBite12");
                                                    enableUpgrade(Yesno.No, "MawBite13");
                                                    enableUpgrade(Yesno.No, "MawBite14");
                                                    enableUpgrade(Yesno.No, "MawBite15");
                                                } else {
                                                    if (checkCounter("TurretChunks", "5", Valuecompare.Equal)) {
                                                        enableUpgrade(Yesno.No, "MawBite0");
                                                        enableUpgrade(Yesno.No, "MawBite1");
                                                        enableUpgrade(Yesno.No, "MawBite2");
                                                        enableUpgrade(Yesno.No, "MawBite3");
                                                        enableUpgrade(Yesno.No, "MawBite4");
                                                        enableUpgrade(Yesno.Yes, "MawBite5");
                                                        enableUpgrade(Yesno.No, "MawBite6");
                                                        enableUpgrade(Yesno.No, "MawBite7");
                                                        enableUpgrade(Yesno.No, "MawBite8");
                                                        enableUpgrade(Yesno.No, "MawBite9");
                                                        enableUpgrade(Yesno.No, "MawBite10");
                                                        enableUpgrade(Yesno.No, "MawBite11");
                                                        enableUpgrade(Yesno.No, "MawBite12");
                                                        enableUpgrade(Yesno.No, "MawBite13");
                                                        enableUpgrade(Yesno.No, "MawBite14");
                                                        enableUpgrade(Yesno.No, "MawBite15");
                                                    } else {
                                                        if (checkCounter("TurretChunks", "4", Valuecompare.Equal)) {
                                                            enableUpgrade(Yesno.No, "MawBite0");
                                                            enableUpgrade(Yesno.No, "MawBite1");
                                                            enableUpgrade(Yesno.No, "MawBite2");
                                                            enableUpgrade(Yesno.No, "MawBite3");
                                                            enableUpgrade(Yesno.Yes, "MawBite4");
                                                            enableUpgrade(Yesno.No, "MawBite5");
                                                            enableUpgrade(Yesno.No, "MawBite6");
                                                            enableUpgrade(Yesno.No, "MawBite7");
                                                            enableUpgrade(Yesno.No, "MawBite8");
                                                            enableUpgrade(Yesno.No, "MawBite9");
                                                            enableUpgrade(Yesno.No, "MawBite10");
                                                            enableUpgrade(Yesno.No, "MawBite11");
                                                            enableUpgrade(Yesno.No, "MawBite12");
                                                            enableUpgrade(Yesno.No, "MawBite13");
                                                            enableUpgrade(Yesno.No, "MawBite14");
                                                            enableUpgrade(Yesno.No, "MawBite15");
                                                        } else {
                                                            if (checkCounter("TurretChunks", "3", Valuecompare.Equal)) {
                                                                enableUpgrade(Yesno.No, "MawBite0");
                                                                enableUpgrade(Yesno.No, "MawBite1");
                                                                enableUpgrade(Yesno.No, "MawBite2");
                                                                enableUpgrade(Yesno.Yes, "MawBite3");
                                                                enableUpgrade(Yesno.No, "MawBite4");
                                                                enableUpgrade(Yesno.No, "MawBite5");
                                                                enableUpgrade(Yesno.No, "MawBite6");
                                                                enableUpgrade(Yesno.No, "MawBite7");
                                                                enableUpgrade(Yesno.No, "MawBite8");
                                                                enableUpgrade(Yesno.No, "MawBite9");
                                                                enableUpgrade(Yesno.No, "MawBite10");
                                                                enableUpgrade(Yesno.No, "MawBite11");
                                                                enableUpgrade(Yesno.No, "MawBite12");
                                                                enableUpgrade(Yesno.No, "MawBite13");
                                                                enableUpgrade(Yesno.No, "MawBite14");
                                                                enableUpgrade(Yesno.No, "MawBite15");
                                                            } else {
                                                                if (checkCounter("TurretChunks", "2", Valuecompare.Equal)) {
                                                                    enableUpgrade(Yesno.No, "MawBite0");
                                                                    enableUpgrade(Yesno.No, "MawBite1");
                                                                    enableUpgrade(Yesno.Yes, "MawBite2");
                                                                    enableUpgrade(Yesno.No, "MawBite3");
                                                                    enableUpgrade(Yesno.No, "MawBite4");
                                                                    enableUpgrade(Yesno.No, "MawBite5");
                                                                    enableUpgrade(Yesno.No, "MawBite6");
                                                                    enableUpgrade(Yesno.No, "MawBite7");
                                                                    enableUpgrade(Yesno.No, "MawBite8");
                                                                    enableUpgrade(Yesno.No, "MawBite9");
                                                                    enableUpgrade(Yesno.No, "MawBite10");
                                                                    enableUpgrade(Yesno.No, "MawBite11");
                                                                    enableUpgrade(Yesno.No, "MawBite12");
                                                                    enableUpgrade(Yesno.No, "MawBite13");
                                                                    enableUpgrade(Yesno.No, "MawBite14");
                                                                    enableUpgrade(Yesno.No, "MawBite15");
                                                                } else {
                                                                    if (checkCounter("TurretChunks", "1", Valuecompare.Equal)) {
                                                                        enableUpgrade(Yesno.No, "MawBite0");
                                                                        enableUpgrade(Yesno.Yes, "MawBite1");
                                                                        enableUpgrade(Yesno.No, "MawBite2");
                                                                        enableUpgrade(Yesno.No, "MawBite3");
                                                                        enableUpgrade(Yesno.No, "MawBite4");
                                                                        enableUpgrade(Yesno.No, "MawBite5");
                                                                        enableUpgrade(Yesno.No, "MawBite6");
                                                                        enableUpgrade(Yesno.No, "MawBite7");
                                                                        enableUpgrade(Yesno.No, "MawBite8");
                                                                        enableUpgrade(Yesno.No, "MawBite9");
                                                                        enableUpgrade(Yesno.No, "MawBite10");
                                                                        enableUpgrade(Yesno.No, "MawBite11");
                                                                        enableUpgrade(Yesno.No, "MawBite12");
                                                                        enableUpgrade(Yesno.No, "MawBite13");
                                                                        enableUpgrade(Yesno.No, "MawBite14");
                                                                        enableUpgrade(Yesno.No, "MawBite15");
                                                                    } else {
                                                                        if (checkCounter("TurretChunks", "0", Valuecompare.Equal)) {
                                                                            enableUpgrade(Yesno.Yes, "MawBite0");
                                                                            enableUpgrade(Yesno.No, "MawBite1");
                                                                            enableUpgrade(Yesno.No, "MawBite2");
                                                                            enableUpgrade(Yesno.No, "MawBite3");
                                                                            enableUpgrade(Yesno.No, "MawBite4");
                                                                            enableUpgrade(Yesno.No, "MawBite5");
                                                                            enableUpgrade(Yesno.No, "MawBite6");
                                                                            enableUpgrade(Yesno.No, "MawBite7");
                                                                            enableUpgrade(Yesno.No, "MawBite8");
                                                                            enableUpgrade(Yesno.No, "MawBite9");
                                                                            enableUpgrade(Yesno.No, "MawBite10");
                                                                            enableUpgrade(Yesno.No, "MawBite11");
                                                                            enableUpgrade(Yesno.No, "MawBite12");
                                                                            enableUpgrade(Yesno.No, "MawBite13");
                                                                            enableUpgrade(Yesno.No, "MawBite14");
                                                                            enableUpgrade(Yesno.No, "MawBite15");
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
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkCounter("TurretChunks", "3", Valuecompare.Less)) {
                enableUpgrade(Yesno.No, "MawTurretCooldownNoReset");
                enableUpgrade(Yesno.Yes, "MawTurretCooldownReset");
            } else {
                enableUpgrade(Yesno.No, "MawTurretCooldownReset");
                enableUpgrade(Yesno.Yes, "MawTurretCooldownNoReset");
            }
        } else {
            if (checkCounter("TurretChunks", "5", Valuecompare.Less)) {
                enableUpgrade(Yesno.No, "MawTurretCooldownNoReset");
                enableUpgrade(Yesno.Yes, "MawTurretCooldownReset");
            } else {
                enableUpgrade(Yesno.No, "MawTurretCooldownReset");
                enableUpgrade(Yesno.Yes, "MawTurretCooldownNoReset");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurret")) {
            if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                adjustCounter("TurretChunks", "1", Valueadjust.Add);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretAttackspeed1")) {
            if (once()) {
                emitMessageInArea("MawTurretAttackspeed1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretAttackspeed2")) {
            if (once()) {
                emitMessageInArea("MawTurretAttackspeed2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretAttackspeed3")) {
            if (once()) {
                emitMessageInArea("MawTurretAttackspeed3", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretGrow")) {
            if (once()) {
                emitMessageInArea("MawTurretGrow", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretDamage1")) {
            if (once()) {
                emitMessageInArea("MawTurretDamage1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawTurretDamage2")) {
            if (once()) {
                emitMessageInArea("MawTurretDamage2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.CREEP, Teamswithnumbers.ENEMY_TEAM, "CreepCowboyBull", "", Valuecompare.Greater, "0", "")) {
            playSound("MawKillBull");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.4D);
        adjustCounter("TurretChunks", "-3", Valueadjust.Add);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.4D);
        adjustCounter("TurretChunks", "-5", Valueadjust.Add);
    }

}

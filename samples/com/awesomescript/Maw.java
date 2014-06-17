
package com.awesomescript;

import java.util.EnumSet;

public class Maw
    extends Script
{


    public void onTick() {
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        if (once()) {
            // set max chunks
            if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
                adjustcounter("TurretChunks", "3", Valueadjust.Set);
            } else {
                adjustcounter("TurretChunks", "5", Valueadjust.Set);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawBiteHit")||isupgradeenabled(Yesno.Yes, "MawBiteHitCreeps")) {
            log("Eating!", "", "");
            if (isupgradeenabled(Yesno.Yes, "MawTurret")) {
                adjustcounter("TurretChunks", "1", Valueadjust.Add);
            }
            if (isupgradeenabled(Yesno.Yes, "MawShotSpeedUp")) {
                enableupgrade(Yesno.Yes, "MawSpeedUp");
                adjustcounter("SpeedUpTimer", "6", Valueadjust.Set);
            }
            enableupgrade(Yesno.No, "MawBiteHitCreeps");
            enableupgrade(Yesno.No, "MawBiteHit");
        }
        if (checkcounter("SpeedUpTimer", "0", Valuecompare.Greater)) {
            if (timer(Timeunits.Seconds, 0.25D, Yesno.No)) {
                adjustcounter("SpeedUpTimer", "-1", Valueadjust.Add);
            }
        } else {
            if (isupgradeenabled(Yesno.Yes, "MawSpeedUp")) {
                enableupgrade(Yesno.No, "MawSpeedUp");
            }
        }
        // set max chunks
        if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkcounter("TurretChunks", "6", Valuecompare.Greater)) {
                adjustcounter("TurretChunks", "6", Valueadjust.Set);
            }
        } else {
            if (checkcounter("TurretChunks", "10", Valuecompare.Greater)) {
                adjustcounter("TurretChunks", "10", Valueadjust.Set);
            }
        }
        // enable turret building
        if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkcounter("TurretChunks", "3", Valuecompare.Less)) {
                enableupgrade(Yesno.No, "TurretAvailable");
            } else {
                enableupgrade(Yesno.Yes, "TurretAvailable");
            }
        } else {
            if (checkcounter("TurretChunks", "5", Valuecompare.Less)) {
                enableupgrade(Yesno.No, "TurretAvailable");
            } else {
                enableupgrade(Yesno.Yes, "TurretAvailable");
            }
        }
        // turret build remove chunks
        if (isupgradeenabled(Yesno.Yes, "MawTurretCreated")) {
            enableupgrade(Yesno.No, "MawTurretCreated");
            if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
                sequence0();
            } else {
                sequence1();
            }
        }
        // set icons
        if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkcounter("TurretChunks", "9", Valuecompare.Equal)) {
                enableupgrade(Yesno.No, "MawBite0");
                enableupgrade(Yesno.No, "MawBite1");
                enableupgrade(Yesno.No, "MawBite2");
                enableupgrade(Yesno.No, "MawBite3");
                enableupgrade(Yesno.No, "MawBite4");
                enableupgrade(Yesno.No, "MawBite5");
                enableupgrade(Yesno.No, "MawBite6");
                enableupgrade(Yesno.No, "MawBite7");
                enableupgrade(Yesno.No, "MawBite8");
                enableupgrade(Yesno.No, "MawBite9");
                enableupgrade(Yesno.No, "MawBite10");
                enableupgrade(Yesno.No, "MawBite11");
                enableupgrade(Yesno.No, "MawBite12");
                enableupgrade(Yesno.No, "MawBite13");
                enableupgrade(Yesno.No, "MawBite14");
                enableupgrade(Yesno.Yes, "MawBite15");
            } else {
                if (checkcounter("TurretChunks", "8", Valuecompare.Equal)) {
                    enableupgrade(Yesno.No, "MawBite0");
                    enableupgrade(Yesno.No, "MawBite1");
                    enableupgrade(Yesno.No, "MawBite2");
                    enableupgrade(Yesno.No, "MawBite3");
                    enableupgrade(Yesno.No, "MawBite4");
                    enableupgrade(Yesno.No, "MawBite5");
                    enableupgrade(Yesno.No, "MawBite6");
                    enableupgrade(Yesno.No, "MawBite7");
                    enableupgrade(Yesno.No, "MawBite8");
                    enableupgrade(Yesno.No, "MawBite9");
                    enableupgrade(Yesno.No, "MawBite10");
                    enableupgrade(Yesno.No, "MawBite11");
                    enableupgrade(Yesno.No, "MawBite12");
                    enableupgrade(Yesno.No, "MawBite13");
                    enableupgrade(Yesno.Yes, "MawBite14");
                    enableupgrade(Yesno.No, "MawBite15");
                } else {
                    if (checkcounter("TurretChunks", "7", Valuecompare.Equal)) {
                        enableupgrade(Yesno.No, "MawBite0");
                        enableupgrade(Yesno.No, "MawBite1");
                        enableupgrade(Yesno.No, "MawBite2");
                        enableupgrade(Yesno.No, "MawBite3");
                        enableupgrade(Yesno.No, "MawBite4");
                        enableupgrade(Yesno.No, "MawBite5");
                        enableupgrade(Yesno.No, "MawBite6");
                        enableupgrade(Yesno.No, "MawBite7");
                        enableupgrade(Yesno.No, "MawBite8");
                        enableupgrade(Yesno.No, "MawBite9");
                        enableupgrade(Yesno.No, "MawBite10");
                        enableupgrade(Yesno.No, "MawBite11");
                        enableupgrade(Yesno.No, "MawBite12");
                        enableupgrade(Yesno.Yes, "MawBite13");
                        enableupgrade(Yesno.No, "MawBite14");
                        enableupgrade(Yesno.No, "MawBite15");
                    } else {
                        if (checkcounter("TurretChunks", "6", Valuecompare.Equal)) {
                            enableupgrade(Yesno.No, "MawBite0");
                            enableupgrade(Yesno.No, "MawBite1");
                            enableupgrade(Yesno.No, "MawBite2");
                            enableupgrade(Yesno.No, "MawBite3");
                            enableupgrade(Yesno.No, "MawBite4");
                            enableupgrade(Yesno.No, "MawBite5");
                            enableupgrade(Yesno.No, "MawBite6");
                            enableupgrade(Yesno.No, "MawBite7");
                            enableupgrade(Yesno.No, "MawBite8");
                            enableupgrade(Yesno.No, "MawBite9");
                            enableupgrade(Yesno.Yes, "MawBite10");
                            enableupgrade(Yesno.No, "MawBite11");
                            enableupgrade(Yesno.No, "MawBite12");
                            enableupgrade(Yesno.No, "MawBite13");
                            enableupgrade(Yesno.No, "MawBite14");
                            enableupgrade(Yesno.No, "MawBite15");
                        } else {
                            if (checkcounter("TurretChunks", "5", Valuecompare.Equal)) {
                                enableupgrade(Yesno.No, "MawBite0");
                                enableupgrade(Yesno.No, "MawBite1");
                                enableupgrade(Yesno.No, "MawBite2");
                                enableupgrade(Yesno.No, "MawBite3");
                                enableupgrade(Yesno.No, "MawBite4");
                                enableupgrade(Yesno.No, "MawBite5");
                                enableupgrade(Yesno.No, "MawBite6");
                                enableupgrade(Yesno.No, "MawBite7");
                                enableupgrade(Yesno.No, "MawBite8");
                                enableupgrade(Yesno.Yes, "MawBite9");
                                enableupgrade(Yesno.No, "MawBite10");
                                enableupgrade(Yesno.No, "MawBite11");
                                enableupgrade(Yesno.No, "MawBite12");
                                enableupgrade(Yesno.No, "MawBite13");
                                enableupgrade(Yesno.No, "MawBite14");
                                enableupgrade(Yesno.No, "MawBite15");
                            } else {
                                if (checkcounter("TurretChunks", "4", Valuecompare.Equal)) {
                                    enableupgrade(Yesno.No, "MawBite0");
                                    enableupgrade(Yesno.No, "MawBite1");
                                    enableupgrade(Yesno.No, "MawBite2");
                                    enableupgrade(Yesno.No, "MawBite3");
                                    enableupgrade(Yesno.No, "MawBite4");
                                    enableupgrade(Yesno.No, "MawBite5");
                                    enableupgrade(Yesno.No, "MawBite6");
                                    enableupgrade(Yesno.No, "MawBite7");
                                    enableupgrade(Yesno.Yes, "MawBite8");
                                    enableupgrade(Yesno.No, "MawBite9");
                                    enableupgrade(Yesno.No, "MawBite10");
                                    enableupgrade(Yesno.No, "MawBite11");
                                    enableupgrade(Yesno.No, "MawBite12");
                                    enableupgrade(Yesno.No, "MawBite13");
                                    enableupgrade(Yesno.No, "MawBite14");
                                    enableupgrade(Yesno.No, "MawBite15");
                                } else {
                                    if (checkcounter("TurretChunks", "3", Valuecompare.Equal)) {
                                        enableupgrade(Yesno.No, "MawBite0");
                                        enableupgrade(Yesno.No, "MawBite1");
                                        enableupgrade(Yesno.No, "MawBite2");
                                        enableupgrade(Yesno.No, "MawBite3");
                                        enableupgrade(Yesno.No, "MawBite4");
                                        enableupgrade(Yesno.Yes, "MawBite5");
                                        enableupgrade(Yesno.No, "MawBite6");
                                        enableupgrade(Yesno.No, "MawBite7");
                                        enableupgrade(Yesno.No, "MawBite8");
                                        enableupgrade(Yesno.No, "MawBite9");
                                        enableupgrade(Yesno.No, "MawBite10");
                                        enableupgrade(Yesno.No, "MawBite11");
                                        enableupgrade(Yesno.No, "MawBite12");
                                        enableupgrade(Yesno.No, "MawBite13");
                                        enableupgrade(Yesno.No, "MawBite14");
                                        enableupgrade(Yesno.No, "MawBite15");
                                    } else {
                                        if (checkcounter("TurretChunks", "2", Valuecompare.Equal)) {
                                            enableupgrade(Yesno.No, "MawBite0");
                                            enableupgrade(Yesno.No, "MawBite1");
                                            enableupgrade(Yesno.No, "MawBite2");
                                            enableupgrade(Yesno.No, "MawBite3");
                                            enableupgrade(Yesno.Yes, "MawBite4");
                                            enableupgrade(Yesno.No, "MawBite5");
                                            enableupgrade(Yesno.No, "MawBite6");
                                            enableupgrade(Yesno.No, "MawBite7");
                                            enableupgrade(Yesno.No, "MawBite8");
                                            enableupgrade(Yesno.No, "MawBite9");
                                            enableupgrade(Yesno.No, "MawBite10");
                                            enableupgrade(Yesno.No, "MawBite11");
                                            enableupgrade(Yesno.No, "MawBite12");
                                            enableupgrade(Yesno.No, "MawBite13");
                                            enableupgrade(Yesno.No, "MawBite14");
                                            enableupgrade(Yesno.No, "MawBite15");
                                        } else {
                                            if (checkcounter("TurretChunks", "1", Valuecompare.Equal)) {
                                                enableupgrade(Yesno.No, "MawBite0");
                                                enableupgrade(Yesno.No, "MawBite1");
                                                enableupgrade(Yesno.No, "MawBite2");
                                                enableupgrade(Yesno.Yes, "MawBite3");
                                                enableupgrade(Yesno.No, "MawBite4");
                                                enableupgrade(Yesno.No, "MawBite5");
                                                enableupgrade(Yesno.No, "MawBite6");
                                                enableupgrade(Yesno.No, "MawBite7");
                                                enableupgrade(Yesno.No, "MawBite8");
                                                enableupgrade(Yesno.No, "MawBite9");
                                                enableupgrade(Yesno.No, "MawBite10");
                                                enableupgrade(Yesno.No, "MawBite11");
                                                enableupgrade(Yesno.No, "MawBite12");
                                                enableupgrade(Yesno.No, "MawBite13");
                                                enableupgrade(Yesno.No, "MawBite14");
                                                enableupgrade(Yesno.No, "MawBite15");
                                            } else {
                                                if (checkcounter("TurretChunks", "0", Valuecompare.Equal)) {
                                                    enableupgrade(Yesno.Yes, "MawBite0");
                                                    enableupgrade(Yesno.No, "MawBite1");
                                                    enableupgrade(Yesno.No, "MawBite2");
                                                    enableupgrade(Yesno.No, "MawBite3");
                                                    enableupgrade(Yesno.No, "MawBite4");
                                                    enableupgrade(Yesno.No, "MawBite5");
                                                    enableupgrade(Yesno.No, "MawBite6");
                                                    enableupgrade(Yesno.No, "MawBite7");
                                                    enableupgrade(Yesno.No, "MawBite8");
                                                    enableupgrade(Yesno.No, "MawBite9");
                                                    enableupgrade(Yesno.No, "MawBite10");
                                                    enableupgrade(Yesno.No, "MawBite11");
                                                    enableupgrade(Yesno.No, "MawBite12");
                                                    enableupgrade(Yesno.No, "MawBite13");
                                                    enableupgrade(Yesno.No, "MawBite14");
                                                    enableupgrade(Yesno.No, "MawBite15");
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
            if (checkcounter("TurretChunks", "15", Valuecompare.Equal)) {
                enableupgrade(Yesno.No, "MawBite0");
                enableupgrade(Yesno.No, "MawBite1");
                enableupgrade(Yesno.No, "MawBite2");
                enableupgrade(Yesno.No, "MawBite3");
                enableupgrade(Yesno.No, "MawBite4");
                enableupgrade(Yesno.No, "MawBite5");
                enableupgrade(Yesno.No, "MawBite6");
                enableupgrade(Yesno.No, "MawBite7");
                enableupgrade(Yesno.No, "MawBite8");
                enableupgrade(Yesno.No, "MawBite9");
                enableupgrade(Yesno.No, "MawBite10");
                enableupgrade(Yesno.No, "MawBite11");
                enableupgrade(Yesno.No, "MawBite12");
                enableupgrade(Yesno.No, "MawBite13");
                enableupgrade(Yesno.No, "MawBite14");
                enableupgrade(Yesno.Yes, "MawBite15");
            } else {
                if (checkcounter("TurretChunks", "14", Valuecompare.Equal)) {
                    enableupgrade(Yesno.No, "MawBite0");
                    enableupgrade(Yesno.No, "MawBite1");
                    enableupgrade(Yesno.No, "MawBite2");
                    enableupgrade(Yesno.No, "MawBite3");
                    enableupgrade(Yesno.No, "MawBite4");
                    enableupgrade(Yesno.No, "MawBite5");
                    enableupgrade(Yesno.No, "MawBite6");
                    enableupgrade(Yesno.No, "MawBite7");
                    enableupgrade(Yesno.No, "MawBite8");
                    enableupgrade(Yesno.No, "MawBite9");
                    enableupgrade(Yesno.No, "MawBite10");
                    enableupgrade(Yesno.No, "MawBite11");
                    enableupgrade(Yesno.No, "MawBite12");
                    enableupgrade(Yesno.No, "MawBite13");
                    enableupgrade(Yesno.Yes, "MawBite14");
                    enableupgrade(Yesno.No, "MawBite15");
                } else {
                    if (checkcounter("TurretChunks", "13", Valuecompare.Equal)) {
                        enableupgrade(Yesno.No, "MawBite0");
                        enableupgrade(Yesno.No, "MawBite1");
                        enableupgrade(Yesno.No, "MawBite2");
                        enableupgrade(Yesno.No, "MawBite3");
                        enableupgrade(Yesno.No, "MawBite4");
                        enableupgrade(Yesno.No, "MawBite5");
                        enableupgrade(Yesno.No, "MawBite6");
                        enableupgrade(Yesno.No, "MawBite7");
                        enableupgrade(Yesno.No, "MawBite8");
                        enableupgrade(Yesno.No, "MawBite9");
                        enableupgrade(Yesno.No, "MawBite10");
                        enableupgrade(Yesno.No, "MawBite11");
                        enableupgrade(Yesno.No, "MawBite12");
                        enableupgrade(Yesno.Yes, "MawBite13");
                        enableupgrade(Yesno.No, "MawBite14");
                        enableupgrade(Yesno.No, "MawBite15");
                    } else {
                        if (checkcounter("TurretChunks", "12", Valuecompare.Equal)) {
                            enableupgrade(Yesno.No, "MawBite0");
                            enableupgrade(Yesno.No, "MawBite1");
                            enableupgrade(Yesno.No, "MawBite2");
                            enableupgrade(Yesno.No, "MawBite3");
                            enableupgrade(Yesno.No, "MawBite4");
                            enableupgrade(Yesno.No, "MawBite5");
                            enableupgrade(Yesno.No, "MawBite6");
                            enableupgrade(Yesno.No, "MawBite7");
                            enableupgrade(Yesno.No, "MawBite8");
                            enableupgrade(Yesno.No, "MawBite9");
                            enableupgrade(Yesno.No, "MawBite10");
                            enableupgrade(Yesno.No, "MawBite11");
                            enableupgrade(Yesno.Yes, "MawBite12");
                            enableupgrade(Yesno.No, "MawBite13");
                            enableupgrade(Yesno.No, "MawBite14");
                            enableupgrade(Yesno.No, "MawBite15");
                        } else {
                            if (checkcounter("TurretChunks", "11", Valuecompare.Equal)) {
                                enableupgrade(Yesno.No, "MawBite0");
                                enableupgrade(Yesno.No, "MawBite1");
                                enableupgrade(Yesno.No, "MawBite2");
                                enableupgrade(Yesno.No, "MawBite3");
                                enableupgrade(Yesno.No, "MawBite4");
                                enableupgrade(Yesno.No, "MawBite5");
                                enableupgrade(Yesno.No, "MawBite6");
                                enableupgrade(Yesno.No, "MawBite7");
                                enableupgrade(Yesno.No, "MawBite8");
                                enableupgrade(Yesno.No, "MawBite9");
                                enableupgrade(Yesno.No, "MawBite10");
                                enableupgrade(Yesno.Yes, "MawBite11");
                                enableupgrade(Yesno.No, "MawBite12");
                                enableupgrade(Yesno.No, "MawBite13");
                                enableupgrade(Yesno.No, "MawBite14");
                                enableupgrade(Yesno.No, "MawBite15");
                            } else {
                                if (checkcounter("TurretChunks", "10", Valuecompare.Equal)) {
                                    enableupgrade(Yesno.No, "MawBite0");
                                    enableupgrade(Yesno.No, "MawBite1");
                                    enableupgrade(Yesno.No, "MawBite2");
                                    enableupgrade(Yesno.No, "MawBite3");
                                    enableupgrade(Yesno.No, "MawBite4");
                                    enableupgrade(Yesno.No, "MawBite5");
                                    enableupgrade(Yesno.No, "MawBite6");
                                    enableupgrade(Yesno.No, "MawBite7");
                                    enableupgrade(Yesno.No, "MawBite8");
                                    enableupgrade(Yesno.No, "MawBite9");
                                    enableupgrade(Yesno.Yes, "MawBite10");
                                    enableupgrade(Yesno.No, "MawBite11");
                                    enableupgrade(Yesno.No, "MawBite12");
                                    enableupgrade(Yesno.No, "MawBite13");
                                    enableupgrade(Yesno.No, "MawBite14");
                                    enableupgrade(Yesno.No, "MawBite15");
                                } else {
                                    if (checkcounter("TurretChunks", "9", Valuecompare.Equal)) {
                                        enableupgrade(Yesno.No, "MawBite0");
                                        enableupgrade(Yesno.No, "MawBite1");
                                        enableupgrade(Yesno.No, "MawBite2");
                                        enableupgrade(Yesno.No, "MawBite3");
                                        enableupgrade(Yesno.No, "MawBite4");
                                        enableupgrade(Yesno.No, "MawBite5");
                                        enableupgrade(Yesno.No, "MawBite6");
                                        enableupgrade(Yesno.No, "MawBite7");
                                        enableupgrade(Yesno.No, "MawBite8");
                                        enableupgrade(Yesno.Yes, "MawBite9");
                                        enableupgrade(Yesno.No, "MawBite10");
                                        enableupgrade(Yesno.No, "MawBite11");
                                        enableupgrade(Yesno.No, "MawBite12");
                                        enableupgrade(Yesno.No, "MawBite13");
                                        enableupgrade(Yesno.No, "MawBite14");
                                        enableupgrade(Yesno.No, "MawBite15");
                                    } else {
                                        if (checkcounter("TurretChunks", "8", Valuecompare.Equal)) {
                                            enableupgrade(Yesno.No, "MawBite0");
                                            enableupgrade(Yesno.No, "MawBite1");
                                            enableupgrade(Yesno.No, "MawBite2");
                                            enableupgrade(Yesno.No, "MawBite3");
                                            enableupgrade(Yesno.No, "MawBite4");
                                            enableupgrade(Yesno.No, "MawBite5");
                                            enableupgrade(Yesno.No, "MawBite6");
                                            enableupgrade(Yesno.No, "MawBite7");
                                            enableupgrade(Yesno.Yes, "MawBite8");
                                            enableupgrade(Yesno.No, "MawBite9");
                                            enableupgrade(Yesno.No, "MawBite10");
                                            enableupgrade(Yesno.No, "MawBite11");
                                            enableupgrade(Yesno.No, "MawBite12");
                                            enableupgrade(Yesno.No, "MawBite13");
                                            enableupgrade(Yesno.No, "MawBite14");
                                            enableupgrade(Yesno.No, "MawBite15");
                                        } else {
                                            if (checkcounter("TurretChunks", "7", Valuecompare.Equal)) {
                                                enableupgrade(Yesno.No, "MawBite0");
                                                enableupgrade(Yesno.No, "MawBite1");
                                                enableupgrade(Yesno.No, "MawBite2");
                                                enableupgrade(Yesno.No, "MawBite3");
                                                enableupgrade(Yesno.No, "MawBite4");
                                                enableupgrade(Yesno.No, "MawBite5");
                                                enableupgrade(Yesno.No, "MawBite6");
                                                enableupgrade(Yesno.Yes, "MawBite7");
                                                enableupgrade(Yesno.No, "MawBite8");
                                                enableupgrade(Yesno.No, "MawBite9");
                                                enableupgrade(Yesno.No, "MawBite10");
                                                enableupgrade(Yesno.No, "MawBite11");
                                                enableupgrade(Yesno.No, "MawBite12");
                                                enableupgrade(Yesno.No, "MawBite13");
                                                enableupgrade(Yesno.No, "MawBite14");
                                                enableupgrade(Yesno.No, "MawBite15");
                                            } else {
                                                if (checkcounter("TurretChunks", "6", Valuecompare.Equal)) {
                                                    enableupgrade(Yesno.No, "MawBite0");
                                                    enableupgrade(Yesno.No, "MawBite1");
                                                    enableupgrade(Yesno.No, "MawBite2");
                                                    enableupgrade(Yesno.No, "MawBite3");
                                                    enableupgrade(Yesno.No, "MawBite4");
                                                    enableupgrade(Yesno.No, "MawBite5");
                                                    enableupgrade(Yesno.Yes, "MawBite6");
                                                    enableupgrade(Yesno.No, "MawBite7");
                                                    enableupgrade(Yesno.No, "MawBite8");
                                                    enableupgrade(Yesno.No, "MawBite9");
                                                    enableupgrade(Yesno.No, "MawBite10");
                                                    enableupgrade(Yesno.No, "MawBite11");
                                                    enableupgrade(Yesno.No, "MawBite12");
                                                    enableupgrade(Yesno.No, "MawBite13");
                                                    enableupgrade(Yesno.No, "MawBite14");
                                                    enableupgrade(Yesno.No, "MawBite15");
                                                } else {
                                                    if (checkcounter("TurretChunks", "5", Valuecompare.Equal)) {
                                                        enableupgrade(Yesno.No, "MawBite0");
                                                        enableupgrade(Yesno.No, "MawBite1");
                                                        enableupgrade(Yesno.No, "MawBite2");
                                                        enableupgrade(Yesno.No, "MawBite3");
                                                        enableupgrade(Yesno.No, "MawBite4");
                                                        enableupgrade(Yesno.Yes, "MawBite5");
                                                        enableupgrade(Yesno.No, "MawBite6");
                                                        enableupgrade(Yesno.No, "MawBite7");
                                                        enableupgrade(Yesno.No, "MawBite8");
                                                        enableupgrade(Yesno.No, "MawBite9");
                                                        enableupgrade(Yesno.No, "MawBite10");
                                                        enableupgrade(Yesno.No, "MawBite11");
                                                        enableupgrade(Yesno.No, "MawBite12");
                                                        enableupgrade(Yesno.No, "MawBite13");
                                                        enableupgrade(Yesno.No, "MawBite14");
                                                        enableupgrade(Yesno.No, "MawBite15");
                                                    } else {
                                                        if (checkcounter("TurretChunks", "4", Valuecompare.Equal)) {
                                                            enableupgrade(Yesno.No, "MawBite0");
                                                            enableupgrade(Yesno.No, "MawBite1");
                                                            enableupgrade(Yesno.No, "MawBite2");
                                                            enableupgrade(Yesno.No, "MawBite3");
                                                            enableupgrade(Yesno.Yes, "MawBite4");
                                                            enableupgrade(Yesno.No, "MawBite5");
                                                            enableupgrade(Yesno.No, "MawBite6");
                                                            enableupgrade(Yesno.No, "MawBite7");
                                                            enableupgrade(Yesno.No, "MawBite8");
                                                            enableupgrade(Yesno.No, "MawBite9");
                                                            enableupgrade(Yesno.No, "MawBite10");
                                                            enableupgrade(Yesno.No, "MawBite11");
                                                            enableupgrade(Yesno.No, "MawBite12");
                                                            enableupgrade(Yesno.No, "MawBite13");
                                                            enableupgrade(Yesno.No, "MawBite14");
                                                            enableupgrade(Yesno.No, "MawBite15");
                                                        } else {
                                                            if (checkcounter("TurretChunks", "3", Valuecompare.Equal)) {
                                                                enableupgrade(Yesno.No, "MawBite0");
                                                                enableupgrade(Yesno.No, "MawBite1");
                                                                enableupgrade(Yesno.No, "MawBite2");
                                                                enableupgrade(Yesno.Yes, "MawBite3");
                                                                enableupgrade(Yesno.No, "MawBite4");
                                                                enableupgrade(Yesno.No, "MawBite5");
                                                                enableupgrade(Yesno.No, "MawBite6");
                                                                enableupgrade(Yesno.No, "MawBite7");
                                                                enableupgrade(Yesno.No, "MawBite8");
                                                                enableupgrade(Yesno.No, "MawBite9");
                                                                enableupgrade(Yesno.No, "MawBite10");
                                                                enableupgrade(Yesno.No, "MawBite11");
                                                                enableupgrade(Yesno.No, "MawBite12");
                                                                enableupgrade(Yesno.No, "MawBite13");
                                                                enableupgrade(Yesno.No, "MawBite14");
                                                                enableupgrade(Yesno.No, "MawBite15");
                                                            } else {
                                                                if (checkcounter("TurretChunks", "2", Valuecompare.Equal)) {
                                                                    enableupgrade(Yesno.No, "MawBite0");
                                                                    enableupgrade(Yesno.No, "MawBite1");
                                                                    enableupgrade(Yesno.Yes, "MawBite2");
                                                                    enableupgrade(Yesno.No, "MawBite3");
                                                                    enableupgrade(Yesno.No, "MawBite4");
                                                                    enableupgrade(Yesno.No, "MawBite5");
                                                                    enableupgrade(Yesno.No, "MawBite6");
                                                                    enableupgrade(Yesno.No, "MawBite7");
                                                                    enableupgrade(Yesno.No, "MawBite8");
                                                                    enableupgrade(Yesno.No, "MawBite9");
                                                                    enableupgrade(Yesno.No, "MawBite10");
                                                                    enableupgrade(Yesno.No, "MawBite11");
                                                                    enableupgrade(Yesno.No, "MawBite12");
                                                                    enableupgrade(Yesno.No, "MawBite13");
                                                                    enableupgrade(Yesno.No, "MawBite14");
                                                                    enableupgrade(Yesno.No, "MawBite15");
                                                                } else {
                                                                    if (checkcounter("TurretChunks", "1", Valuecompare.Equal)) {
                                                                        enableupgrade(Yesno.No, "MawBite0");
                                                                        enableupgrade(Yesno.Yes, "MawBite1");
                                                                        enableupgrade(Yesno.No, "MawBite2");
                                                                        enableupgrade(Yesno.No, "MawBite3");
                                                                        enableupgrade(Yesno.No, "MawBite4");
                                                                        enableupgrade(Yesno.No, "MawBite5");
                                                                        enableupgrade(Yesno.No, "MawBite6");
                                                                        enableupgrade(Yesno.No, "MawBite7");
                                                                        enableupgrade(Yesno.No, "MawBite8");
                                                                        enableupgrade(Yesno.No, "MawBite9");
                                                                        enableupgrade(Yesno.No, "MawBite10");
                                                                        enableupgrade(Yesno.No, "MawBite11");
                                                                        enableupgrade(Yesno.No, "MawBite12");
                                                                        enableupgrade(Yesno.No, "MawBite13");
                                                                        enableupgrade(Yesno.No, "MawBite14");
                                                                        enableupgrade(Yesno.No, "MawBite15");
                                                                    } else {
                                                                        if (checkcounter("TurretChunks", "0", Valuecompare.Equal)) {
                                                                            enableupgrade(Yesno.Yes, "MawBite0");
                                                                            enableupgrade(Yesno.No, "MawBite1");
                                                                            enableupgrade(Yesno.No, "MawBite2");
                                                                            enableupgrade(Yesno.No, "MawBite3");
                                                                            enableupgrade(Yesno.No, "MawBite4");
                                                                            enableupgrade(Yesno.No, "MawBite5");
                                                                            enableupgrade(Yesno.No, "MawBite6");
                                                                            enableupgrade(Yesno.No, "MawBite7");
                                                                            enableupgrade(Yesno.No, "MawBite8");
                                                                            enableupgrade(Yesno.No, "MawBite9");
                                                                            enableupgrade(Yesno.No, "MawBite10");
                                                                            enableupgrade(Yesno.No, "MawBite11");
                                                                            enableupgrade(Yesno.No, "MawBite12");
                                                                            enableupgrade(Yesno.No, "MawBite13");
                                                                            enableupgrade(Yesno.No, "MawBite14");
                                                                            enableupgrade(Yesno.No, "MawBite15");
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
        if (isupgradeenabled(Yesno.Yes, "MawTurretCheaper1")) {
            if (checkcounter("TurretChunks", "3", Valuecompare.Less)) {
                enableupgrade(Yesno.No, "MawTurretCooldownNoReset");
                enableupgrade(Yesno.Yes, "MawTurretCooldownReset");
            } else {
                enableupgrade(Yesno.No, "MawTurretCooldownReset");
                enableupgrade(Yesno.Yes, "MawTurretCooldownNoReset");
            }
        } else {
            if (checkcounter("TurretChunks", "5", Valuecompare.Less)) {
                enableupgrade(Yesno.No, "MawTurretCooldownNoReset");
                enableupgrade(Yesno.Yes, "MawTurretCooldownReset");
            } else {
                enableupgrade(Yesno.No, "MawTurretCooldownReset");
                enableupgrade(Yesno.Yes, "MawTurretCooldownNoReset");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurret")) {
            if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                adjustcounter("TurretChunks", "1", Valueadjust.Add);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretAttackspeed1")) {
            if (once()) {
                emitmessageinarea("MawTurretAttackspeed1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretAttackspeed2")) {
            if (once()) {
                emitmessageinarea("MawTurretAttackspeed2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretAttackspeed3")) {
            if (once()) {
                emitmessageinarea("MawTurretAttackspeed3", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretGrow")) {
            if (once()) {
                emitmessageinarea("MawTurretGrow", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretDamage1")) {
            if (once()) {
                emitmessageinarea("MawTurretDamage1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "MawTurretDamage2")) {
            if (once()) {
                emitmessageinarea("MawTurretDamage2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 15.0D, 15.0D, Yesno.Yes, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.4D);
        adjustcounter("TurretChunks", "-3", Valueadjust.Add);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.4D);
        adjustcounter("TurretChunks", "-5", Valueadjust.Add);
    }

}

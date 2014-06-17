
package com.awesomescript;

import java.util.EnumSet;

public class Tank
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (getboolequals("Init", Yesno.No)) {
            setbool("RemoveMaxhp", Flagtoggle.No);
            adjustcounter("HpGained", "0", Valueadjust.Set);
            adjustcounter("HpCounter", "0", Valueadjust.Set);
            setbool("Init", Flagtoggle.Yes);
        }
        if (isupgradeenabled(Yesno.Yes, "TankShotHoming")) {
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.No)) {
                if (isupgradeenabled(Yesno.No, "MissileSuperFollow")) {
                    enableupgrade(Yesno.Yes, "MissileSuperFollow");
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "MissileSuperFollow")) {
                    enableupgrade(Yesno.No, "MissileSuperFollow");
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "Salvo")) {
            enableupgrade(Yesno.No, "Salvo");
            if (isupgradeenabled(Yesno.Yes, "SalvoUp")) {
                enableupgrade(Yesno.No, "SalvoUp");
                adjustcounter("SalvoNo", "1", Valueadjust.Add);
                if (isupgradeenabled(Yesno.Yes, "TankShotSalvo")||isupgradeenabled(Yesno.Yes, "TankShotFatPete")) {
                    if (checkcounter("SalvoNo", "3", Valuecompare.Greater)) {
                        adjustcounter("SalvoNo", "0", Valueadjust.Set);
                    }
                } else {
                    if (isupgradeenabled(Yesno.Yes, "TankShotBarrage3")) {
                        if (checkcounter("SalvoNo", "2", Valuecompare.Greater)) {
                            adjustcounter("SalvoNo", "0", Valueadjust.Set);
                        }
                    } else {
                        if (checkcounter("SalvoNo", "1", Valuecompare.Greater)) {
                            adjustcounter("SalvoNo", "0", Valueadjust.Set);
                        }
                    }
                }
            }
            if (checkcounter("SalvoNo", "0", Valuecompare.Equal)) {
                enableupgrade(Yesno.No, "Salvo1");
                enableupgrade(Yesno.No, "Salvo2");
                enableupgrade(Yesno.No, "Salvo3");
            }
            if (checkcounter("SalvoNo", "1", Valuecompare.Equal)) {
                if (isupgradeenabled(Yesno.Yes, "TankShotSalvo")||isupgradeenabled(Yesno.Yes, "TankShotBarrage2")) {
                    enableupgrade(Yesno.Yes, "Salvo1");
                    enableupgrade(Yesno.No, "Salvo2");
                    enableupgrade(Yesno.No, "Salvo3");
                } else {
                    enableupgrade(Yesno.No, "Salvo1");
                    enableupgrade(Yesno.No, "Salvo2");
                    enableupgrade(Yesno.No, "Salvo3");
                }
            }
            if (checkcounter("SalvoNo", "2", Valuecompare.Equal)) {
                if (isupgradeenabled(Yesno.Yes, "TankShotSalvo")||isupgradeenabled(Yesno.Yes, "TankShotBarrage3")) {
                    enableupgrade(Yesno.No, "Salvo1");
                    enableupgrade(Yesno.Yes, "Salvo2");
                    enableupgrade(Yesno.No, "Salvo3");
                } else {
                    enableupgrade(Yesno.No, "Salvo1");
                    enableupgrade(Yesno.No, "Salvo2");
                    enableupgrade(Yesno.No, "Salvo3");
                }
            }
            if (checkcounter("SalvoNo", "3", Valuecompare.Equal)) {
                if (isupgradeenabled(Yesno.Yes, "TankShotFatPete")||isupgradeenabled(Yesno.Yes, "TankShotSalvo")) {
                    enableupgrade(Yesno.No, "Salvo1");
                    enableupgrade(Yesno.No, "Salvo2");
                    enableupgrade(Yesno.Yes, "Salvo3");
                } else {
                    enableupgrade(Yesno.No, "Salvo1");
                    enableupgrade(Yesno.No, "Salvo2");
                    enableupgrade(Yesno.No, "Salvo3");
                }
            }
        }
        // Do Special Skills on Bite
        if (isupgradeenabled(Yesno.Yes, "TankBiteHit")) {
            if (getboolequals("TankBiteHitDone", Yesno.No)) {
                // Maxhp up bij lifesteal upgrade
                if (isupgradeenabled(Yesno.Yes, "TankBiteMaxHP1")) {
                    setbool("TankBiteHitDone", Flagtoggle.Yes);
                    log("Extra Leven!", "", "");
                    if (isupgradeenabled(Yesno.Yes, "TankBiteMaxHP2")) {
                        if (checkcounter("HpGained", "5", Valuecompare.Equal)) {
                            adjustcounter("HpGained", "1", Valueadjust.Add);
                            enableupgrade(Yesno.Yes, "StealHp6");
                        }
                        if (checkcounter("HpGained", "4", Valuecompare.Equal)) {
                            adjustcounter("HpGained", "1", Valueadjust.Add);
                            enableupgrade(Yesno.Yes, "StealHp5");
                        }
                        if (checkcounter("HpGained", "3", Valuecompare.Equal)) {
                            adjustcounter("HpGained", "1", Valueadjust.Add);
                            enableupgrade(Yesno.Yes, "StealHp4");
                        }
                    }
                    if (checkcounter("HpGained", "2", Valuecompare.Equal)) {
                        adjustcounter("HpGained", "1", Valueadjust.Add);
                        enableupgrade(Yesno.Yes, "StealHp3");
                    }
                    if (checkcounter("HpGained", "1", Valuecompare.Equal)) {
                        adjustcounter("HpGained", "1", Valueadjust.Add);
                        enableupgrade(Yesno.Yes, "StealHp2");
                    }
                    if (checkcounter("HpGained", "0", Valuecompare.Equal)) {
                        adjustcounter("HpGained", "1", Valueadjust.Add);
                        enableupgrade(Yesno.Yes, "StealHp1");
                    }
                }
            }
        } else {
            setbool("TankBiteHitDone", Flagtoggle.No);
            if (isinnamedarea("StartArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setbool("RemoveMaxhp", Flagtoggle.Yes);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "TankExploding")) {
            if (checkcharacterflag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "Breakstealth");
            } else {
                enableupgrade(Yesno.No, "Breakstealth");
            }
        }
    }

}

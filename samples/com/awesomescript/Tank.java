
package com.awesomescript;

import java.util.EnumSet;

public class Tank
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (getBoolEquals("Init", Yesno.No)) {
            setBool("RemoveMaxhp", Flagtoggle.No);
            adjustCounter("HpGained", "0", Valueadjust.Set);
            adjustCounter("HpCounter", "0", Valueadjust.Set);
            setBool("Init", Flagtoggle.Yes);
        }
        if (isUpgradeEnabled(Yesno.Yes, "TankShotHoming")) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.No)) {
                if (isUpgradeEnabled(Yesno.No, "MissileSuperFollow")) {
                    enableUpgrade(Yesno.Yes, "MissileSuperFollow");
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "MissileSuperFollow")) {
                    enableUpgrade(Yesno.No, "MissileSuperFollow");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "Salvo")) {
            enableUpgrade(Yesno.No, "Salvo");
            if (isUpgradeEnabled(Yesno.Yes, "SalvoUp")) {
                enableUpgrade(Yesno.No, "SalvoUp");
                adjustCounter("SalvoNo", "1", Valueadjust.Add);
                if (isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")||isUpgradeEnabled(Yesno.Yes, "TankShotFatPete")) {
                    if (checkCounter("SalvoNo", "3", Valuecompare.Greater)) {
                        adjustCounter("SalvoNo", "0", Valueadjust.Set);
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "TankShotBarrage3")) {
                        if (checkCounter("SalvoNo", "2", Valuecompare.Greater)) {
                            adjustCounter("SalvoNo", "0", Valueadjust.Set);
                        }
                    } else {
                        if (checkCounter("SalvoNo", "1", Valuecompare.Greater)) {
                            adjustCounter("SalvoNo", "0", Valueadjust.Set);
                        }
                    }
                }
            }
            if (checkCounter("SalvoNo", "0", Valuecompare.Equal)) {
                enableUpgrade(Yesno.No, "Salvo1");
                enableUpgrade(Yesno.No, "Salvo2");
                enableUpgrade(Yesno.No, "Salvo3");
            }
            if (checkCounter("SalvoNo", "1", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")||isUpgradeEnabled(Yesno.Yes, "TankShotBarrage2")) {
                    enableUpgrade(Yesno.Yes, "Salvo1");
                    enableUpgrade(Yesno.No, "Salvo2");
                    enableUpgrade(Yesno.No, "Salvo3");
                } else {
                    enableUpgrade(Yesno.No, "Salvo1");
                    enableUpgrade(Yesno.No, "Salvo2");
                    enableUpgrade(Yesno.No, "Salvo3");
                }
            }
            if (checkCounter("SalvoNo", "2", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")||isUpgradeEnabled(Yesno.Yes, "TankShotBarrage3")) {
                    enableUpgrade(Yesno.No, "Salvo1");
                    enableUpgrade(Yesno.Yes, "Salvo2");
                    enableUpgrade(Yesno.No, "Salvo3");
                } else {
                    enableUpgrade(Yesno.No, "Salvo1");
                    enableUpgrade(Yesno.No, "Salvo2");
                    enableUpgrade(Yesno.No, "Salvo3");
                }
            }
            if (checkCounter("SalvoNo", "3", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotFatPete")||isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")) {
                    enableUpgrade(Yesno.No, "Salvo1");
                    enableUpgrade(Yesno.No, "Salvo2");
                    enableUpgrade(Yesno.Yes, "Salvo3");
                } else {
                    enableUpgrade(Yesno.No, "Salvo1");
                    enableUpgrade(Yesno.No, "Salvo2");
                    enableUpgrade(Yesno.No, "Salvo3");
                }
            }
        }
        // Do Special Skills on Bite
        if (isUpgradeEnabled(Yesno.Yes, "TankBiteHit")) {
            if (getBoolEquals("TankBiteHitDone", Yesno.No)) {
                // Maxhp up bij lifesteal upgrade
                if (isUpgradeEnabled(Yesno.Yes, "TankBiteMaxHP1")) {
                    setBool("TankBiteHitDone", Flagtoggle.Yes);
                    log("Extra Leven!", "", "");
                    if (isUpgradeEnabled(Yesno.Yes, "TankBiteMaxHP2")) {
                        if (checkCounter("HpGained", "5", Valuecompare.Equal)) {
                            adjustCounter("HpGained", "1", Valueadjust.Add);
                            enableUpgrade(Yesno.Yes, "StealHp6");
                        }
                        if (checkCounter("HpGained", "4", Valuecompare.Equal)) {
                            adjustCounter("HpGained", "1", Valueadjust.Add);
                            enableUpgrade(Yesno.Yes, "StealHp5");
                        }
                        if (checkCounter("HpGained", "3", Valuecompare.Equal)) {
                            adjustCounter("HpGained", "1", Valueadjust.Add);
                            enableUpgrade(Yesno.Yes, "StealHp4");
                        }
                    }
                    if (checkCounter("HpGained", "2", Valuecompare.Equal)) {
                        adjustCounter("HpGained", "1", Valueadjust.Add);
                        enableUpgrade(Yesno.Yes, "StealHp3");
                    }
                    if (checkCounter("HpGained", "1", Valuecompare.Equal)) {
                        adjustCounter("HpGained", "1", Valueadjust.Add);
                        enableUpgrade(Yesno.Yes, "StealHp2");
                    }
                    if (checkCounter("HpGained", "0", Valuecompare.Equal)) {
                        adjustCounter("HpGained", "1", Valueadjust.Add);
                        enableUpgrade(Yesno.Yes, "StealHp1");
                    }
                }
            }
        } else {
            setBool("TankBiteHitDone", Flagtoggle.No);
            if (isInNamedArea("StartArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setBool("RemoveMaxhp", Flagtoggle.Yes);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "TankExploding")) {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "Breakstealth");
            } else {
                enableUpgrade(Yesno.No, "Breakstealth");
            }
        }
    }

}


package com.awesomescript;


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
        if (isUpgradeEnabled(Yesno.Yes, "TankSalvo")) {
            enableUpgrade(Yesno.No, "TankSalvo");
            if (isUpgradeEnabled(Yesno.Yes, "TankSalvoUp")) {
                enableUpgrade(Yesno.No, "TankSalvoUp");
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
                enableUpgrade(Yesno.No, "TankShotSalvo1");
                enableUpgrade(Yesno.No, "TankShotSalvo2");
                enableUpgrade(Yesno.No, "TankShotSalvo3");
            }
            if (checkCounter("SalvoNo", "1", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")||isUpgradeEnabled(Yesno.Yes, "TankShotBarrage2")) {
                    enableUpgrade(Yesno.Yes, "TankShotSalvo1");
                    enableUpgrade(Yesno.No, "TankShotSalvo2");
                    enableUpgrade(Yesno.No, "TankShotSalvo3");
                } else {
                    enableUpgrade(Yesno.No, "TankShotSalvo1");
                    enableUpgrade(Yesno.No, "TankShotSalvo2");
                    enableUpgrade(Yesno.No, "TankShotSalvo3");
                }
            }
            if (checkCounter("SalvoNo", "2", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")||isUpgradeEnabled(Yesno.Yes, "TankShotBarrage3")) {
                    enableUpgrade(Yesno.No, "TankShotSalvo1");
                    enableUpgrade(Yesno.Yes, "TankShotSalvo2");
                    enableUpgrade(Yesno.No, "TankShotSalvo3");
                } else {
                    enableUpgrade(Yesno.No, "TankShotSalvo1");
                    enableUpgrade(Yesno.No, "TankShotSalvo2");
                    enableUpgrade(Yesno.No, "TankShotSalvo3");
                }
            }
            if (checkCounter("SalvoNo", "3", Valuecompare.Equal)) {
                if (isUpgradeEnabled(Yesno.Yes, "TankShotFatPete")||isUpgradeEnabled(Yesno.Yes, "TankShotSalvo")) {
                    enableUpgrade(Yesno.No, "TankShotSalvo1");
                    enableUpgrade(Yesno.No, "TankShotSalvo2");
                    enableUpgrade(Yesno.Yes, "TankShotSalvo3");
                } else {
                    enableUpgrade(Yesno.No, "TankShotSalvo1");
                    enableUpgrade(Yesno.No, "TankShotSalvo2");
                    enableUpgrade(Yesno.No, "TankShotSalvo3");
                }
            }
        }
        // Do Special Skills on Bite
        if (isUpgradeEnabled(Yesno.Yes, "TankBiteHit")) {
            if (getBoolEquals("TankBiteHitDone", Yesno.No)) {
                // Maxhp up bij lifesteal upgrade
                if (isUpgradeEnabled(Yesno.Yes, "TankBiteMaxHP1")) {
                    setBool("TankBiteHitDone", Flagtoggle.Yes);
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


package com.awesomescript;


public class SpyShop
    extends Script
{


    public void onTick() {
        // Am I in shop?
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorb")) {
                if (canPayUpgrade("SpyAbsorb")) {
                    buyUpgrade("SpyAbsorb");
                }
            }
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                    if (canPayUpgrade("healthRegen1")) {
                        buyUpgrade("healthRegen1");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDouble1")) {
                if (canPayUpgrade("SpyAbsorbDouble1")) {
                    buyUpgrade("SpyAbsorbDouble1");
                }
            }
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                    if (canPayUpgrade("healthRegen2")) {
                        buyUpgrade("healthRegen2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "SpySpeed")) {
                    if (canPayUpgrade("SpySpeed")) {
                        buyUpgrade("SpySpeed");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBooth")) {
                if (canPayUpgrade("SpyBooth")) {
                    buyUpgrade("SpyBooth");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyShootHeal1")) {
                if (canPayUpgrade("SpyShootHeal1")) {
                    buyUpgrade("SpyShootHeal1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyShootAttackspeed1")) {
                if (canPayUpgrade("SpyShootAttackspeed1")) {
                    buyUpgrade("SpyShootAttackspeed1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyShootAttackspeed2")) {
                if (canPayUpgrade("SpyShootAttackspeed2")) {
                    buyUpgrade("SpyShootAttackspeed2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothClone1")) {
                if (canPayUpgrade("SpyBoothClone1")) {
                    buyUpgrade("SpyBoothClone1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothClone2")) {
                if (canPayUpgrade("SpyBoothClone2")) {
                    buyUpgrade("SpyBoothClone2");
                }
            }
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                    if (canPayUpgrade("addHealth1")) {
                        buyUpgrade("addHealth1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                    if (canPayUpgrade("addHealth2")) {
                        buyUpgrade("addHealth2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                    if (canPayUpgrade("addHealth3")) {
                        buyUpgrade("addHealth3");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyShootDamage1")) {
                if (canPayUpgrade("SpyShootDamage1")) {
                    buyUpgrade("SpyShootDamage1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyShootDamage2")) {
                if (canPayUpgrade("SpyShootDamage2")) {
                    buyUpgrade("SpyShootDamage2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "undefined")) {
                if (canPayUpgrade("undefined")) {
                    buyUpgrade("undefined");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage1")) {
                if (canPayUpgrade("SpyBoothDamage1")) {
                    buyUpgrade("SpyBoothDamage1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage2")) {
                if (canPayUpgrade("SpyBoothDamage2")) {
                    buyUpgrade("SpyBoothDamage2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothDamage3")) {
                if (canPayUpgrade("SpyBoothDamage3")) {
                    buyUpgrade("SpyBoothDamage3");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage1")) {
                if (canPayUpgrade("SpyAbsorbFlatDamage1")) {
                    buyUpgrade("SpyAbsorbFlatDamage1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage2")) {
                if (canPayUpgrade("SpyAbsorbFlatDamage2")) {
                    buyUpgrade("SpyAbsorbFlatDamage2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbFlatDamage3")) {
                if (canPayUpgrade("SpyAbsorbFlatDamage3")) {
                    buyUpgrade("SpyAbsorbFlatDamage3");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction1")) {
                if (canPayUpgrade("SpyAbsorbDamageReduction1")) {
                    buyUpgrade("SpyAbsorbDamageReduction1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyAbsorbDamageReduction2")) {
                if (canPayUpgrade("SpyAbsorbDamageReduction2")) {
                    buyUpgrade("SpyAbsorbDamageReduction2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "SpyBoothSilence1")) {
                if (canPayUpgrade("SpyBoothSilence1")) {
                    buyUpgrade("SpyBoothSilence1");
                }
            }
        }
    }

}

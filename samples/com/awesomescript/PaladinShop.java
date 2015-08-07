
package com.awesomescript;


public class PaladinShop
    extends Script
{


    public void onTick() {
        // Am I in shop?
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.No, "PaladinHammer")) {
                if (canPayUpgrade("PaladinHammer")) {
                    buyUpgrade("PaladinHammer");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAura")) {
                if (canPayUpgrade("PaladinAura")) {
                    buyUpgrade("PaladinAura");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerRange1")) {
                if (canPayUpgrade("PaladinHammerRange1")) {
                    buyUpgrade("PaladinHammerRange1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraDamageEnd1")) {
                if (canPayUpgrade("PaladinAuraDamageEnd1")) {
                    buyUpgrade("PaladinAuraDamageEnd1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraDamageEnd2")) {
                if (canPayUpgrade("PaladinAuraDamageEnd2")) {
                    buyUpgrade("PaladinAuraDamageEnd2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraDamage1")) {
                if (canPayUpgrade("PaladinAuraDamage1")) {
                    buyUpgrade("PaladinAuraDamage1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraDamage2")) {
                if (canPayUpgrade("PaladinAuraDamage2")) {
                    buyUpgrade("PaladinAuraDamage2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraDamage3")) {
                if (canPayUpgrade("PaladinAuraDamage3")) {
                    buyUpgrade("PaladinAuraDamage3");
                }
            }
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "PaladinSpeed")) {
                    if (canPayUpgrade("PaladinSpeed")) {
                        buyUpgrade("PaladinSpeed");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraHot1")) {
                if (canPayUpgrade("PaladinAuraHot1")) {
                    buyUpgrade("PaladinAuraHot1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitFriendly1")) {
                if (canPayUpgrade("PaladinHitFriendly1")) {
                    buyUpgrade("PaladinHitFriendly1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitFriendly2")) {
                if (canPayUpgrade("PaladinHitFriendly2")) {
                    buyUpgrade("PaladinHitFriendly2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitMark1")) {
                if (canPayUpgrade("PaladinHitMark1")) {
                    buyUpgrade("PaladinHitMark1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerDamage1")) {
                if (canPayUpgrade("PaladinHammerDamage1")) {
                    buyUpgrade("PaladinHammerDamage1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerDamage2")) {
                if (canPayUpgrade("PaladinHammerDamage2")) {
                    buyUpgrade("PaladinHammerDamage2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerCooldown1")) {
                if (canPayUpgrade("PaladinHammerCooldown1")) {
                    buyUpgrade("PaladinHammerCooldown1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerCooldown2")) {
                if (canPayUpgrade("PaladinHammerCooldown2")) {
                    buyUpgrade("PaladinHammerCooldown2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHammerDamage3")) {
                if (canPayUpgrade("PaladinHammerDamage3")) {
                    buyUpgrade("PaladinHammerDamage3");
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
                if (isUpgradeEnabled(Yesno.No, "ccReduction")) {
                    if (canPayUpgrade("ccReduction")) {
                        buyUpgrade("ccReduction");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "ccReduction2")) {
                    if (canPayUpgrade("ccReduction2")) {
                        buyUpgrade("ccReduction2");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitAttackspeed1")) {
                if (canPayUpgrade("PaladinHitAttackspeed1")) {
                    buyUpgrade("PaladinHitAttackspeed1");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitAttackspeed2")) {
                if (canPayUpgrade("PaladinHitAttackspeed2")) {
                    buyUpgrade("PaladinHitAttackspeed2");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinHitAttackspeed3")) {
                if (canPayUpgrade("PaladinHitAttackspeed3")) {
                    buyUpgrade("PaladinHitAttackspeed3");
                }
            }
            if (isUpgradeEnabled(Yesno.No, "PaladinAuraHot2")) {
                if (canPayUpgrade("PaladinAuraHot2")) {
                    buyUpgrade("PaladinAuraHot2");
                }
            }
        }
    }

}

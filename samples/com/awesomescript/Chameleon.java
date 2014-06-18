
package com.awesomescript;

import java.util.EnumSet;

public class Chameleon
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (getBoolEquals("stealth", Yesno.No)) {
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitLifesteal1")) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.16D, Yesno.No, Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonHitLifesteal2")) {
                        if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                            adjustCharacterValue(CharactervaluesAdjustable.Health, 1.0D, Valueadjust.Add);
                        }
                    } else {
                        if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            adjustCharacterValue(CharactervaluesAdjustable.Health, 1.0D, Valueadjust.Add);
                        }
                    }
                }
            }
        }
        if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage4")) {
                enableUpgrade(Yesno.Yes, "ChameleonTongueDamage4Vis");
                enableUpgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                enableUpgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                enableUpgrade(Yesno.No, "ChameleonTongueDamage1Vis");
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage3")) {
                    enableUpgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                    enableUpgrade(Yesno.Yes, "ChameleonTongueDamage3Vis");
                    enableUpgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                    enableUpgrade(Yesno.No, "ChameleonTongueDamage1Vis");
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage2")) {
                        enableUpgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                        enableUpgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                        enableUpgrade(Yesno.Yes, "ChameleonTongueDamage2Vis");
                        enableUpgrade(Yesno.No, "ChameleonTongueDamage1Vis");
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "ChameleonTongueDamage1")) {
                            enableUpgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                            enableUpgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                            enableUpgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                            enableUpgrade(Yesno.Yes, "ChameleonTongueDamage1Vis");
                        }
                    }
                }
            }
        }
        if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
            // special upgrade for expanding upgrades
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthRegen")) {
                // special upgrade for expanding upgrades
                if (isUpgradeEnabled(Yesno.Yes, "Healthregen1")) {
                    // special upgrade for expanding upgrades
                    if (isUpgradeEnabled(Yesno.Yes, "Healthregen2")) {
                        // on
                        enableUpgrade(Yesno.Yes, "ChameleonStealthRegen2On");
                        // on
                        enableUpgrade(Yesno.No, "ChameleonStealthRegenOn");
                        // on
                        enableUpgrade(Yesno.No, "ChameleonStealthRegen1On");
                    } else {
                        // on
                        enableUpgrade(Yesno.Yes, "ChameleonStealthRegen1On");
                        // on
                        enableUpgrade(Yesno.No, "ChameleonStealthRegenOn");
                        // on
                        enableUpgrade(Yesno.No, "ChameleonStealthRegen2On");
                    }
                } else {
                    // on
                    enableUpgrade(Yesno.Yes, "ChameleonStealthRegenOn");
                    // on
                    enableUpgrade(Yesno.No, "ChameleonStealthRegen1On");
                    // on
                    enableUpgrade(Yesno.No, "ChameleonStealthRegen2On");
                }
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "StealthLeon")) {
                // off
                enableUpgrade(Yesno.No, "StealthLeon");
            }
            // special upgrade for expanding upgrades
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthRegenOn")) {
                // off
                enableUpgrade(Yesno.No, "ChameleonStealthRegenOn");
            }
            // special upgrade for expanding upgrades
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthRegen1On")) {
                // off
                enableUpgrade(Yesno.No, "ChameleonStealthRegen1On");
            }
            // special upgrade for expanding upgrades
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthRegen2On")) {
                // off
                enableUpgrade(Yesno.No, "ChameleonStealthRegen2On");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "StealthLeon")) {
            enableUpgrade(Yesno.Yes, "ChameleonStealthOffActive");
        } else {
            enableUpgrade(Yesno.No, "ChameleonStealthOffActive");
        }
    }

}

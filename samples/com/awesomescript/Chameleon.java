
package com.awesomescript;

import java.util.EnumSet;

public class Chameleon
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (getboolequals("stealth", Yesno.No)) {
            if (isupgradeenabled(Yesno.Yes, "ChameleonHitLifesteal1")) {
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.16D, Yesno.No, Yesno.No)) {
                    if (isupgradeenabled(Yesno.Yes, "ChameleonHitLifesteal2")) {
                        if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                            adjustcharactervalue(CharactervaluesAdjustable.Health, 1.0D, Valueadjust.Add);
                        }
                    } else {
                        if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            adjustcharactervalue(CharactervaluesAdjustable.Health, 1.0D, Valueadjust.Add);
                        }
                    }
                }
            }
        }
        if (isinnamedarea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
            if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage4")) {
                enableupgrade(Yesno.Yes, "ChameleonTongueDamage4Vis");
                enableupgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                enableupgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                enableupgrade(Yesno.No, "ChameleonTongueDamage1Vis");
            } else {
                if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage3")) {
                    enableupgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                    enableupgrade(Yesno.Yes, "ChameleonTongueDamage3Vis");
                    enableupgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                    enableupgrade(Yesno.No, "ChameleonTongueDamage1Vis");
                } else {
                    if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage2")) {
                        enableupgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                        enableupgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                        enableupgrade(Yesno.Yes, "ChameleonTongueDamage2Vis");
                        enableupgrade(Yesno.No, "ChameleonTongueDamage1Vis");
                    } else {
                        if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage1")) {
                            enableupgrade(Yesno.No, "ChameleonTongueDamage4Vis");
                            enableupgrade(Yesno.No, "ChameleonTongueDamage3Vis");
                            enableupgrade(Yesno.No, "ChameleonTongueDamage2Vis");
                            enableupgrade(Yesno.Yes, "ChameleonTongueDamage1Vis");
                        }
                    }
                }
            }
        }
        if (checkcharacterflag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
            // special upgrade for expanding upgrades
            if (isupgradeenabled(Yesno.Yes, "ChameleonStealthRegen")) {
                // special upgrade for expanding upgrades
                if (isupgradeenabled(Yesno.Yes, "Healthregen1")) {
                    // special upgrade for expanding upgrades
                    if (isupgradeenabled(Yesno.Yes, "Healthregen2")) {
                        // on
                        enableupgrade(Yesno.Yes, "ChameleonStealthRegen2On");
                        // on
                        enableupgrade(Yesno.No, "ChameleonStealthRegenOn");
                        // on
                        enableupgrade(Yesno.No, "ChameleonStealthRegen1On");
                    } else {
                        // on
                        enableupgrade(Yesno.Yes, "ChameleonStealthRegen1On");
                        // on
                        enableupgrade(Yesno.No, "ChameleonStealthRegenOn");
                        // on
                        enableupgrade(Yesno.No, "ChameleonStealthRegen2On");
                    }
                } else {
                    // on
                    enableupgrade(Yesno.Yes, "ChameleonStealthRegenOn");
                    // on
                    enableupgrade(Yesno.No, "ChameleonStealthRegen1On");
                    // on
                    enableupgrade(Yesno.No, "ChameleonStealthRegen2On");
                }
            }
        } else {
            if (isupgradeenabled(Yesno.Yes, "StealthLeon")) {
                // off
                enableupgrade(Yesno.No, "StealthLeon");
            }
            // special upgrade for expanding upgrades
            if (isupgradeenabled(Yesno.Yes, "ChameleonStealthRegenOn")) {
                // off
                enableupgrade(Yesno.No, "ChameleonStealthRegenOn");
            }
            // special upgrade for expanding upgrades
            if (isupgradeenabled(Yesno.Yes, "ChameleonStealthRegen1On")) {
                // off
                enableupgrade(Yesno.No, "ChameleonStealthRegen1On");
            }
            // special upgrade for expanding upgrades
            if (isupgradeenabled(Yesno.Yes, "ChameleonStealthRegen2On")) {
                // off
                enableupgrade(Yesno.No, "ChameleonStealthRegen2On");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "StealthLeon")) {
            enableupgrade(Yesno.Yes, "ChameleonStealthOffActive");
        } else {
            enableupgrade(Yesno.No, "ChameleonStealthOffActive");
        }
    }

}

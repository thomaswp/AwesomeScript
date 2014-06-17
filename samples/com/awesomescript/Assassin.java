
package com.awesomescript;

import java.util.EnumSet;

public class Assassin
    extends Script
{


    public void onTick() {
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges4")&&isupgradeenabled(Yesno.Yes, "AssassinStrikeMaxchargesranged")) {
            enableupgrade(Yesno.Yes, "AssassinStrikeMaxchargesrangedActivate");
        }
        // Check if assassin has charge speed upgrade
        if (isupgradeenabled(Yesno.Yes, "AssassinStrikeSpd")) {
            // Check if assassin has 1 charge
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges1")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinStrikeSpdActivate1");
            }
            // Check if assassin has 2 charges
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges2")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinStrikeSpdActivate2");
            }
            // Check if assassin has 3 charges
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges3")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinStrikeSpdActivate3");
            }
            // Check if assassin has 4 charges
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges4")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinStrikeSpdActivate4");
            }
            // Check if assassin has 5 charges
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges5")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinStrikeSpdActivate5");
            }
        }
        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, null, "healarea", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            enableupgrade(Yesno.Yes, "AssassinLightningcharges1");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges2");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges3");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges4");
            // Check if assassin has 5 max charges
            if (isupgradeenabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinLightningcharges5");
            }
        }
        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, null, "startarea", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            enableupgrade(Yesno.Yes, "AssassinLightningcharges1");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges2");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges3");
            enableupgrade(Yesno.Yes, "AssassinLightningcharges4");
            // Check if assassin has 5 max charges
            if (isupgradeenabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
                // give assassin bonus speed upgrade
                enableupgrade(Yesno.Yes, "AssassinLightningcharges5");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "AssassinAssail")) {
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges1")||isupgradeenabled(Yesno.Yes, "AssassinLightningcharges2")) {
                enableupgrade(Yesno.Yes, "AssassinAssailAvailable");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "AssassinJolt")) {
            if (isupgradeenabled(Yesno.Yes, "AssassinLightningcharges1")||isupgradeenabled(Yesno.Yes, "AssassinLightningcharges2")) {
                enableupgrade(Yesno.Yes, "AssassinJoltAvailable");
            }
        }
        // Check if assassin has 5 max charges
        if (isupgradeenabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
            if (once()) {
                enableupgrade(Yesno.No, "AssassinLightningcharges1");
                enableupgrade(Yesno.No, "AssassinLightningcharges2");
                enableupgrade(Yesno.No, "AssassinLightningcharges3");
                enableupgrade(Yesno.No, "AssassinLightningcharges4");
                enableupgrade(Yesno.No, "AssassinLightningcharges5");
                enableupgrade(Yesno.No, "AssassinStrikeSpdActivate1");
                enableupgrade(Yesno.No, "AssassinStrikeSpdActivate2");
                enableupgrade(Yesno.No, "AssassinStrikeSpdActivate3");
                enableupgrade(Yesno.No, "AssassinStrikeSpdActivate4");
                enableupgrade(Yesno.No, "AssassinStrikeSpdActivate5");
            }
        }
    }

}

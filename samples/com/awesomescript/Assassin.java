
package com.awesomescript;

import java.util.EnumSet;

public class Assassin
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")&&isUpgradeEnabled(Yesno.Yes, "AssassinStrikeMaxchargesranged")) {
            enableUpgrade(Yesno.Yes, "AssassinStrikeMaxchargesrangedActivate");
        }
        // Check if assassin has charge speed upgrade
        if (isUpgradeEnabled(Yesno.Yes, "AssassinStrikeSpd")) {
            // Check if assassin has 1 charge
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinStrikeSpdActivate1");
            }
            // Check if assassin has 2 charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinStrikeSpdActivate2");
            }
            // Check if assassin has 3 charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges3")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinStrikeSpdActivate3");
            }
            // Check if assassin has 4 charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges4")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinStrikeSpdActivate4");
            }
            // Check if assassin has 5 charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges5")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinStrikeSpdActivate5");
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "healarea", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges1");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges2");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges3");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges4");
            // Check if assassin has 5 max charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinLightningcharges5");
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "startarea", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges1");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges2");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges3");
            enableUpgrade(Yesno.Yes, "AssassinLightningcharges4");
            // Check if assassin has 5 max charges
            if (isUpgradeEnabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
                // give assassin bonus speed upgrade
                enableUpgrade(Yesno.Yes, "AssassinLightningcharges5");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "AssassinAssail")) {
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")||isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                enableUpgrade(Yesno.Yes, "AssassinAssailAvailable");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "AssassinJolt")) {
            if (isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges1")||isUpgradeEnabled(Yesno.Yes, "AssassinLightningcharges2")) {
                enableUpgrade(Yesno.Yes, "AssassinJoltAvailable");
            }
        }
        // Check if assassin has 5 max charges
        if (isUpgradeEnabled(Yesno.Yes, "AssassinStrikeIncreasemax")) {
            if (once()) {
                enableUpgrade(Yesno.No, "AssassinLightningcharges1");
                enableUpgrade(Yesno.No, "AssassinLightningcharges2");
                enableUpgrade(Yesno.No, "AssassinLightningcharges3");
                enableUpgrade(Yesno.No, "AssassinLightningcharges4");
                enableUpgrade(Yesno.No, "AssassinLightningcharges5");
                enableUpgrade(Yesno.No, "AssassinStrikeSpdActivate1");
                enableUpgrade(Yesno.No, "AssassinStrikeSpdActivate2");
                enableUpgrade(Yesno.No, "AssassinStrikeSpdActivate3");
                enableUpgrade(Yesno.No, "AssassinStrikeSpdActivate4");
                enableUpgrade(Yesno.No, "AssassinStrikeSpdActivate5");
            }
        }
    }

}

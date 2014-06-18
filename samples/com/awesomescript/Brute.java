
package com.awesomescript;


public class Brute
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (isUpgradeEnabled(Yesno.Yes, "BruteStampReset")) {
            if (random("3")) {
                if (isUpgradeEnabled(Yesno.No, "BruteStampDoreset")) {
                    enableUpgrade(Yesno.Yes, "BruteStampDoreset");
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "BruteStampDoreset")) {
                    enableUpgrade(Yesno.No, "BruteStampDoreset");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BruteStampIgnoreAir")) {
        } else {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.Yes, "BruteStampInAir")) {
                    enableUpgrade(Yesno.No, "BruteStampInAir");
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "BruteStampInAir")) {
                    enableUpgrade(Yesno.Yes, "BruteStampInAir");
                }
            }
        }
    }

}

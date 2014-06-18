
package com.awesomescript;


public class Jetter
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.No, "GroundingOn")) {
            if (isInNamedArea("NoFlyZone", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getBoolEquals("JetOn", Yesno.Yes)) {
                    enableUpgrade(Yesno.No, "JetterJet");
                    setBool("JetOn", Flagtoggle.No);
                }
            } else {
                if (getBoolEquals("JetOn", Yesno.No)) {
                    enableUpgrade(Yesno.Yes, "JetterJet");
                    setBool("JetOn", Flagtoggle.Yes);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleSpeedup")) {
            if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleDuration")) {
                if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSpeedupAndDuration1")) {
                    enableUpgrade(Yesno.Yes, "JetterTimebubbleSpeedupAndDuration1");
                }
            }
            if (isUpgradeEnabled(Yesno.Yes, "JetterTimebubbleDuration2")) {
                if (isUpgradeEnabled(Yesno.No, "JetterTimebubbleSpeedupAndDuration2")) {
                    enableUpgrade(Yesno.Yes, "JetterTimebubbleSpeedupAndDuration2");
                }
            }
        }
    }

}


package com.awesomescript;


public class Heavy
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (getBoolEquals("siegemode", Yesno.Yes)) {
            if (isInNamedArea("SecretArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "EnableJumppad")) {
                    enableUpgrade(Yesno.Yes, "EnableJumppad");
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "EnableJumppad")) {
                    enableUpgrade(Yesno.No, "EnableJumppad");
                }
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "EnableJumppad")) {
                enableUpgrade(Yesno.No, "EnableJumppad");
            }
        }
    }

}


package com.awesomescript;


public class Captain
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "CaptainDoubleHitDone")) {
            enableUpgrade(Yesno.No, "CaptainDoubleHitReady");
            enableUpgrade(Yesno.No, "CaptainDoubleHitDone");
        }
    }

}


package com.awesomescript;


public class Dasher
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "dashPenalty")) {
            if (getBoolEquals("dashPenaltyRunning", Yesno.No)) {
                setBool("dashPenaltyRunning", Flagtoggle.Yes);
                sequence0();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "whirlPenalty")) {
            if (getBoolEquals("whirlPenaltyRunning", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindDuration2")) {
                    setBool("whirlPenaltyRunning", Flagtoggle.Yes);
                    sequence1();
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "DasherWhirlwindDuration1")) {
                        setBool("whirlPenaltyRunning", Flagtoggle.Yes);
                        sequence2();
                    } else {
                        setBool("whirlPenaltyRunning", Flagtoggle.Yes);
                        sequence3();
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.4D);
        enableUpgrade(Yesno.No, "dashPenalty");
        setBool("dashPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(3.2D);
        enableUpgrade(Yesno.No, "whirlPenalty");
        setBool("whirlPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(2.4D);
        enableUpgrade(Yesno.No, "whirlPenalty");
        setBool("whirlPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(1.6D);
        enableUpgrade(Yesno.No, "whirlPenalty");
        setBool("whirlPenaltyRunning", Flagtoggle.No);
    }

}

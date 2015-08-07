
package com.awesomescript;


public class Blazer
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        // Achievements die specifiek voor Coco zijn
        executeBehaviourTree("BlazerAchievements");
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            if (timer(Timeunits.Seconds, 0.1D, Yesno.No)) {
                if (random("4")) {
                    if (isUpgradeEnabled(Yesno.No, "DoFlip")) {
                        enableUpgrade(Yesno.Yes, "DoFlip");
                        enableUpgrade(Yesno.No, "DontFlip");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "DoFlip")) {
                        enableUpgrade(Yesno.No, "DoFlip");
                        enableUpgrade(Yesno.Yes, "DontFlip");
                    }
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "LightningPenalty")) {
            enableUpgrade(Yesno.No, "LightningPenalty");
            enableUpgrade(Yesno.Yes, "Speedpenalty");
            sequence0();
        } else {
            if (getBoolEquals("lightningdone", Yesno.Yes)) {
                enableUpgrade(Yesno.No, "Speedpenalty");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlazeSpeedup")) {
            enableUpgrade(Yesno.No, "BlazeSpeedup");
            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed3")) {
                enableUpgrade(Yesno.Yes, "BlazeSpeed3On");
                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength2")) {
                    sequence1();
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                        sequence2();
                    } else {
                        sequence3();
                    }
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed2")) {
                    enableUpgrade(Yesno.Yes, "BlazeSpeed2On");
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength2")) {
                        sequence4();
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                            sequence5();
                        } else {
                            sequence6();
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                        enableUpgrade(Yesno.Yes, "BlazeSpeed1On");
                        if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength2")) {
                            sequence7();
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "BlazerBlazeLength1")) {
                                sequence8();
                            } else {
                                sequence9();
                            }
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("lightningdone", Flagtoggle.No);
        wait(0.1D);
        setBool("lightningdone", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(6.0D);
        enableUpgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(4.2D);
        enableUpgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(2.4D);
        enableUpgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(6.0D);
        enableUpgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        wait(4.2D);
        enableUpgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        wait(2.4D);
        enableUpgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        wait(6.0D);
        enableUpgrade(Yesno.No, "BlazeSpeed1On");
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        wait(4.2D);
        enableUpgrade(Yesno.No, "BlazeSpeed1On");
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        wait(2.4D);
        enableUpgrade(Yesno.No, "BlazeSpeed1On");
    }

}

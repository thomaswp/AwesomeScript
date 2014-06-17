
package com.awesomescript;


public class Blazer
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isonground(Yesno.Yes, Targetself.Self)) {
            if (timer(Timeunits.Seconds, 0.1D, null)) {
                if (random("4")) {
                    if (isupgradeenabled(Yesno.No, "DoFlip")) {
                        enableupgrade(Yesno.Yes, "DoFlip");
                        enableupgrade(Yesno.No, "DontFlip");
                    }
                } else {
                    if (isupgradeenabled(Yesno.Yes, "DoFlip")) {
                        enableupgrade(Yesno.No, "DoFlip");
                        enableupgrade(Yesno.Yes, "DontFlip");
                    }
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "LightningPenalty")) {
            enableupgrade(Yesno.No, "LightningPenalty");
            enableupgrade(Yesno.Yes, "Speedpenalty");
            sequence0();
        } else {
            if (getboolequals("lightningdone", Yesno.Yes)) {
                enableupgrade(Yesno.No, "Speedpenalty");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "BlazeSpeedup")) {
            enableupgrade(Yesno.No, "BlazeSpeedup");
            if (isupgradeenabled(Yesno.Yes, "BlazerBlazeSpeed3")) {
                enableupgrade(Yesno.Yes, "BlazeSpeed3On");
                if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength2")) {
                    sequence1();
                } else {
                    if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength1")) {
                        sequence2();
                    } else {
                        sequence3();
                    }
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "BlazerBlazeSpeed2")) {
                    enableupgrade(Yesno.Yes, "BlazeSpeed2On");
                    if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength2")) {
                        sequence4();
                    } else {
                        if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength1")) {
                            sequence5();
                        } else {
                            sequence6();
                        }
                    }
                } else {
                    if (isupgradeenabled(Yesno.Yes, "BlazerBlazeSpeed1")) {
                        enableupgrade(Yesno.Yes, "BlazeSpeed1On");
                        if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength2")) {
                            sequence7();
                        } else {
                            if (isupgradeenabled(Yesno.Yes, "BlazerBlazeLength1")) {
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
        setbool("lightningdone", Flagtoggle.No);
        wait(0.1D);
        setbool("lightningdone", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(6.0D);
        enableupgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(4.2D);
        enableupgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(2.4D);
        enableupgrade(Yesno.No, "BlazeSpeed3On");
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(6.0D);
        enableupgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        wait(4.2D);
        enableupgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        wait(2.4D);
        enableupgrade(Yesno.No, "BlazeSpeed2On");
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        wait(6.0D);
        enableupgrade(Yesno.No, "BlazeSpeed1On");
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        wait(4.2D);
        enableupgrade(Yesno.No, "BlazeSpeed1On");
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        wait(2.4D);
        enableupgrade(Yesno.No, "BlazeSpeed1On");
    }

}

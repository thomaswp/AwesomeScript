
package com.awesomescript;


public class Dasher
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isupgradeenabled(Yesno.Yes, "dashPenalty")) {
            if (getboolequals("dashPenaltyRunning", Yesno.No)) {
                setbool("dashPenaltyRunning", Flagtoggle.Yes);
                sequence0();
            }
        }
        if (isupgradeenabled(Yesno.Yes, "whirlPenalty")) {
            if (getboolequals("whirlPenaltyRunning", Yesno.No)) {
                if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindDuration2")) {
                    setbool("whirlPenaltyRunning", Flagtoggle.Yes);
                    sequence1();
                } else {
                    if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindDuration1")) {
                        setbool("whirlPenaltyRunning", Flagtoggle.Yes);
                        sequence2();
                    } else {
                        setbool("whirlPenaltyRunning", Flagtoggle.Yes);
                        sequence3();
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.4D);
        enableupgrade(Yesno.No, "dashPenalty");
        setbool("dashPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(3.2D);
        enableupgrade(Yesno.No, "whirlPenalty");
        setbool("whirlPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(2.4D);
        enableupgrade(Yesno.No, "whirlPenalty");
        setbool("whirlPenaltyRunning", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(1.6D);
        enableupgrade(Yesno.No, "whirlPenalty");
        setbool("whirlPenaltyRunning", Flagtoggle.No);
    }

}

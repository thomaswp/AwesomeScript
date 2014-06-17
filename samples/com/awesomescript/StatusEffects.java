
package com.awesomescript;


public class StatusEffects
    extends Script
{


    public void onTick() {
        if (isinnamedarea("WIND", Ownenemy.OWN_TEAM, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "wind");
        } else {
            enableupgrade(Yesno.No, "wind");
        }
        if (once()) {
            if (isfromteam(Teamswithnumbers.ONE_TEAM, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "TeamOne");
            }
            if (isfromteam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "TeamZero");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CocoonZero")) {
            setbool("WasCocooned", Flagtoggle.Yes);
            if (getboolequals("CocoonHalfDealed", Yesno.No)) {
                if (hasupgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonHalf2")) {
                    sequence0();
                } else {
                    if (hasupgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonHalf1")) {
                        sequence1();
                    }
                }
                setbool("CocoonHalfDealed", Flagtoggle.Yes);
            }
            if (getboolequals("CocoonExplodeChecked", Yesno.No)) {
                if (hasupgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonExplode1")) {
                    enableupgrade(Yesno.Yes, "ButterflyCocoonExploding1");
                    if (hasupgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonExplode2")) {
                        enableupgrade(Yesno.Yes, "ButterflyCocoonExploding2");
                    }
                }
                setbool("CocoonExplodeChecked", Flagtoggle.Yes);
            }
        } else {
            if (isupgradeenabled(Yesno.Yes, "CocoonOne")) {
                setbool("WasCocooned", Flagtoggle.Yes);
                if (getboolequals("CocoonHalfDealed", Yesno.No)) {
                    if (hasupgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonHalf2")) {
                        sequence2();
                    } else {
                        if (hasupgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonHalf1")) {
                            sequence3();
                        }
                    }
                    setbool("CocoonHalfDealed", Flagtoggle.Yes);
                }
                if (getboolequals("CocoonExplodeChecked", Yesno.No)) {
                    if (hasupgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonExplode1")) {
                        enableupgrade(Yesno.Yes, "ButterflyCocoonExploding1");
                        if (hasupgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonExplode2")) {
                            enableupgrade(Yesno.Yes, "ButterflyCocoonExploding2");
                        }
                    }
                    setbool("CocoonExplodeChecked", Flagtoggle.Yes);
                }
            } else {
                if (getboolequals("WasCocooned", Yesno.Yes)) {
                    setbool("WasCocooned", Flagtoggle.No);
                    enableupgrade(Yesno.No, "ButterflyCocoonExploding1");
                    enableupgrade(Yesno.No, "ButterflyCocoonExploding2");
                }
                setbool("CocoonExplodeChecked", Flagtoggle.No);
                setbool("CocoonHalfDealed", Flagtoggle.No);
                setbool("CocoonTotemChecked", Flagtoggle.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "StealthPowerup")) {
            sequence4();
            enableupgrade(Yesno.Yes, "StealthPowerupActive");
        } else {
            enableupgrade(Yesno.No, "PowerupEnd");
        }
        if (checkcharacterflag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
            if (isupgradeenabled(Yesno.Yes, "StealthPowerupActive")) {
                enableupgrade(Yesno.No, "StealthPowerupActive");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(1.9D);
        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.8D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(1.9D);
        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.9D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(1.9D);
        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.7D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(1.9D);
        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.85D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(20.0D);
        if (isupgradeenabled(Yesno.Yes, "StealthLeon")) {
        } else {
            enableupgrade(Yesno.Yes, "PowerupEnd");
        }
        enableupgrade(Yesno.No, "StealthPowerup");
    }

}

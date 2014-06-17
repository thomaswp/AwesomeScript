
package com.awesomescript;

import java.util.EnumSet;

public class Spy
    extends Script
{


    public void onTick() {
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        if (getboolequals("initspy", Yesno.No)) {
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSpyBooth", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 150.0D, 150.0D, Yesno.No)) {
                sequence0();
            } else {
                if (isupgradeenabled(Yesno.Yes, "SpyBooth")) {
                    enableupgrade(Yesno.Yes, "SpyBoothEnable");
                }
                setbool("initspy", Flagtoggle.Yes);
            }
        } else {
            if (isupgradeenabled(Yesno.Yes, "SpyBooth")) {
                enableupgrade(Yesno.Yes, "SpyBoothEnable");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SpyBoothIsPlaced")) {
            enableupgrade(Yesno.No, "SpyBoothTeleportOn");
        }
        if (isupgradeenabled(Yesno.Yes, "SpyBoothRemoveIt")) {
            sequence1();
        }
        if (isupgradeenabled(Yesno.Yes, "SpyBoothIsPlaced")) {
            if (isupgradeenabled(Yesno.Yes, "SpyBoothDamage1")||isupgradeenabled(Yesno.Yes, "SpyBoothSilence1")) {
                enableupgrade(Yesno.Yes, "SpyBoothEnableExplode");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SpyBoothAPBoostON")) {
            sequence2();
        }
        if (isupgradeenabled(Yesno.Yes, "SpyAbsorbSpeed2")&&isupgradeenabled(Yesno.Yes, "SpyAbsorbStartOn")) {
            enableupgrade(Yesno.Yes, "SpyAbsorbSpeed2On");
            enableupgrade(Yesno.Yes, "SpyAbsorbSpeed1On");
        } else {
            if (isupgradeenabled(Yesno.Yes, "SpyAbsorbSpeed1")&&isupgradeenabled(Yesno.Yes, "SpyAbsorbStartOn")) {
                enableupgrade(Yesno.Yes, "SpyAbsorbSpeed1On");
            } else {
                enableupgrade(Yesno.No, "SpyAbsorbSpeed1On");
                enableupgrade(Yesno.No, "SpyAbsorbSpeed2On");
            }
        }
        sequence3();
        if (isbuttonpressed(Buttons.DPAD_UP)) {
            if (isbuttonpressed(Buttons.DPAD_DOWN)) {
                if (isbuttonpressed(Buttons.DPAD_LEFT)) {
                    if (isbuttonpressed(Buttons.DPAD_RIGHT)) {
                        sequence5();
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableupgrade(Yesno.Yes, "SpyBoothTeleportOn");
        setbool("initspy", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        emitmessageinarea("boothremove", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 10.0D, 10.0D, Yesno.No, Yesno.No);
        enableupgrade(Yesno.No, "SpyBoothRemoveIt");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(5.0D);
        enableupgrade(Yesno.No, "SpyBoothAPBoostON");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(3.0D);
        if (random("10")) {
            sequence4();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        enableupgrade(Yesno.Yes, "SpyVisualAltidle");
        wait(4.5D);
        enableupgrade(Yesno.No, "SpyVisualAltidle");
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        enableupgrade(Yesno.No, "SpyVisualAltidle");
        wait(1.4D);
        enableupgrade(Yesno.No, "SpyVisualAltidle");
    }

}

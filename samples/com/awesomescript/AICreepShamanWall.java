
package com.awesomescript;


public class AICreepShamanWall
    extends Script
{


    public void onTick() {
        if (timer(Timeunits.Seconds, 7.0D, Yesno.No)) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "ShamanWallGround1")||isUpgradeEnabled(Yesno.Yes, "ShamanWallSlow1")) {
            pressButton(Buttons.FACE_LEFT, 0.1D);
        }
        if (isUpgradeEnabled(Yesno.Yes, "ShamanWallKnockback1")) {
            pressButton(Buttons.FACE_RIGHT, 0.1D);
        }
        if (checkGameTime(270.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    sequence0();
                }
            }
        }
        if (checkGameTime(540.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    sequence1();
                }
            }
        }
        if (checkGameTime(810.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    sequence2();
                }
            }
        }
        if (getBoolEquals("init", Yesno.No)) {
            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                sequence3();
            } else {
                sequence4();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "cocoonzero")) {
            enableUpgrade(Yesno.No, "cocoonzero");
        }
        if (isUpgradeEnabled(Yesno.Yes, "cocoonone")) {
            enableUpgrade(Yesno.No, "cocoonone");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        buyUpgrade("Addhealth1");
        adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        buyUpgrade("Addhealth2");
        adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        buyUpgrade("Addhealth3");
        adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        pressStick(Directions.FORWARD, 0.0D);
        setBool("init", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        pressStick(Directions.BACKWARD, 0.0D);
        setBool("init", Flagtoggle.Yes);
    }

}

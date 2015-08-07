
package com.awesomescript;


public class AICreepCaptainChain
    extends Script
{


    public void onTick() {
        if (once()) {
            sequence0();
        }
        if (checkGameTime(270.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    buyUpgrade("Addhealth1");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
        if (checkGameTime(540.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth2")) {
                if (once()) {
                    buyUpgrade("Addhealth2");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
        if (checkGameTime(810.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth3")) {
                if (once()) {
                    buyUpgrade("Addhealth3");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
        if (hasTarget(Yesno.No)) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressButton(Buttons.FACE_LEFT, 0.0D);
        enableUpgrade(Yesno.Yes, "ChainSecondIdle");
    }

}

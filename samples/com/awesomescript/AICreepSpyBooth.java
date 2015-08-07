
package com.awesomescript;


public class AICreepSpyBooth
    extends Script
{


    public void onTick() {
        if (receivedMessage("boothremove")) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBoothStealth1")) {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                sequence0();
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(5.0D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

}

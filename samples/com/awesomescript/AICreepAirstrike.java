
package com.awesomescript;


public class AICreepAirstrike
    extends Script
{


    public void onTick() {
        if (once()) {
            sequence0();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressStick(Directions.DOWN, 10.0D);
        wait(0.1D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        wait(1.2D);
        if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikeHealthpack1")) {
            pressButton(Buttons.FACE_BOTTOM, 0.1D);
        }
        wait(1.2D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

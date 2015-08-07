
package com.awesomescript;


public class AICreepAbsorb
    extends Script
{


    public void onTick() {
        if (once()) {
            sequence0();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressButton(Buttons.FACE_LEFT, 1.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_RIGHT, 1.0D);
        wait(0.15D);
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
        wait(3.0D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

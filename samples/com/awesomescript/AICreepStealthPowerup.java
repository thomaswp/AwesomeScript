
package com.awesomescript;


public class AICreepStealthPowerup
    extends Script
{


    public void onTick() {
        sequence0();
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressButton(Buttons.FACE_LEFT, 0.1D);
        wait(1000.1D);
    }

}

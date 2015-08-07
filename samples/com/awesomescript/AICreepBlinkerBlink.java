
package com.awesomescript;

import java.util.EnumSet;

public class AICreepBlinkerBlink
    extends Script
{


    public void onTick() {
        if (timePassed(Timeunits.Seconds, 0.01D)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.1D, 0.0D, 0.05D, 0.05D, Yesno.No, Yesno.Yes)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.1D, 0.15D, 0.05D, 0.05D, Yesno.No, Yesno.Yes)) {
                } else {
                    pressButton(Buttons.FACE_BOTTOM, 0.1D);
                }
            }
            pressStick(Directions.FORWARD, 0.1D);
        }
        if (receivedMessage("blinkertargetremove")) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (once()) {
            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
            } else {
                pressStick(Directions.BACKWARD, 0.0D);
            }
        }
        if (hasUpgrade("Blinker", Teamswithnumbers.OWN_TEAM, "BlinkerTwirlWalk1")) {
            if (hasUpgrade("Blinker", Teamswithnumbers.OWN_TEAM, "blinkertwirling")) {
                pressButton(Buttons.FACE_LEFT, 0.1D);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerBlinkRange1")) {
            if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
            }
        } else {
            if (timer(Timeunits.Seconds, 1.5D, Yesno.No)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerBlinkSpeed1")) {
            enableUpgrade(Yesno.Yes, "BlinkerBlinkSpeed1On");
        }
    }

}

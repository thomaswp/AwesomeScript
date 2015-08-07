
package com.awesomescript;

import java.util.EnumSet;

public class AIHealTotem
    extends Script
{


    public void onTick() {
        if (once()) {
            enableUpgrade(Yesno.Yes, "HealbotDespawnOn");
        }
        // heals all the time
        pressButton(Buttons.FACE_LEFT, 0.0D);
        // damage all the time
        pressButton(Buttons.FACE_TOP, 0.0D);
        // check for turn
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.12D, 0.0D, 0.24D, 0.3D, Yesno.Yes, Yesno.No)) {
            setBool("turn", Flagtoggle.Yes);
        }
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
        if (getBoolEquals("turn", Yesno.Yes)) {
            // don't turn all the time
            if (checkCounter("waitToTurn", "0", Valuecompare.LessOrEqual)) {
                pressStick(Directions.BACKWARD, 0.0D);
                setBool("turn", Flagtoggle.No);
                adjustCounter("waitToTurn", "7", Valueadjust.Set);
            } else {
                // count down
                adjustCounter("waitToTurn", "-1", Valueadjust.Add);
            }
        }
        if (checkGameTime(300.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    buyUpgrade("Addhealth1");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
        if (checkGameTime(600.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth2")) {
                if (once()) {
                    buyUpgrade("Addhealth2");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
        if (checkGameTime(900.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth3")) {
                if (once()) {
                    buyUpgrade("Addhealth3");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
            }
        }
    }

}

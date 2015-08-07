
package com.awesomescript;

import java.util.EnumSet;

public class AIBull
    extends Script
{


    public void onTick() {
        if (isUpgradeEnabled(Yesno.Yes, "Cocoon")) {
        } else {
            if (isUpgradeEnabled(Yesno.No, "BullPatience")||getBoolEquals("start", Yesno.Yes)) {
                pressStick(Directions.FORWARD, 0.1D);
                // do effect
                pressButton(Buttons.FACE_LEFT, 0.0D);
                // change life time
                if (getBoolEquals("foundWall", Yesno.No)) {
                    // out of time (short)
                    if (timer(Timeunits.Seconds, 2.6D, Yesno.No)) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                } else {
                    // stay bumping longer
                    if (timer(Timeunits.Seconds, 5.8D, Yesno.No)) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepBull", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Less, 0.0D, "", 0.1D, 0.0D, 0.05D, 0.05D, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, 0.0D, 0.01D, 0.02D, Yesno.No, Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, 0.0D, 0.01D, 0.02D, Yesno.No, Yesno.No)) {
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "CowboyBullCooldown")) {
                        // turn on wall
                        setBool("turn", Flagtoggle.Yes);
                        setBool("returning", Flagtoggle.Yes);
                        setBool("foundWall", Flagtoggle.Yes);
                        adjustCounter("waitToGoBack", "0", Valueadjust.Set);
                    } else {
                        // die
                        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                }
            }
            // wait longer with patience upgrade
            if (isUpgradeEnabled(Yesno.Yes, "BullPatience2")) {
                if (timer(Timeunits.Seconds, 19.0D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                }
            } else {
                if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CowboyBullDamage")) {
            if (isUpgradeEnabled(Yesno.Yes, "CowboyBullExplode")) {
                if (isUpgradeEnabled(Yesno.No, "CowboyBullDamageAndExplode")) {
                    enableUpgrade(Yesno.Yes, "CowboyBullDamageAndExplode");
                }
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.06D, 0.0D, 1.4D, 0.1D, Yesno.Yes, Yesno.No)) {
            setBool("start", Flagtoggle.Yes);
        }
    }

}

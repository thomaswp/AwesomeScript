
package com.awesomescript;

import java.util.EnumSet;

public class AIBull
    extends Script
{


    public void onTick() {
        if (isupgradeenabled(Yesno.Yes, "Cocoon")) {
        } else {
            if (isupgradeenabled(Yesno.No, "BullPatience")||getboolequals("start", Yesno.Yes)) {
                pressstick(Directions.FORWARD, 0.1D);
                // do effect
                pressbutton(Buttons.FACE_LEFT, 0.0D);
                // change life time
                if (getboolequals("foundWall", Yesno.No)) {
                    // out of time (short)
                    if (timer(Timeunits.Seconds, 2.6D, Yesno.No)) {
                        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                } else {
                    // stay bumping longer
                    if (timer(Timeunits.Seconds, 5.8D, Yesno.No)) {
                        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                }
            }
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepBull", CharactervaluesCheckable.Health, Valuecompare.Less, 0.0D, "", 0.1D, 0.0D, 0.05D, 0.05D, Yesno.No)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, 0.0D, 0.01D, 0.02D, Yesno.No, Yesno.No)) {
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, 0.0D, 0.01D, 0.02D, Yesno.No, Yesno.No)) {
                } else {
                    if (isupgradeenabled(Yesno.Yes, "CowboyBullCooldown")) {
                        // turn on wall
                        setbool("turn", Flagtoggle.Yes);
                        setbool("returning", Flagtoggle.Yes);
                        setbool("foundWall", Flagtoggle.Yes);
                        adjustcounter("waitToGoBack", "0", Valueadjust.Set);
                    } else {
                        // die
                        adjustcharactervalue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                    }
                }
            }
            // wait longer with patience upgrade
            if (isupgradeenabled(Yesno.Yes, "BullPatience2")) {
                if (timer(Timeunits.Seconds, 19.0D, Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                }
            } else {
                if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CowboyBullDamage")) {
            if (isupgradeenabled(Yesno.Yes, "CowboyBullExplode")) {
                if (isupgradeenabled(Yesno.No, "CowboyBullDamageAndExplode")) {
                    enableupgrade(Yesno.Yes, "CowboyBullDamageAndExplode");
                }
            }
        }
        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.06D, 0.0D, 1.4D, 0.1D, Yesno.Yes, Yesno.No)) {
            setbool("start", Flagtoggle.Yes);
        }
    }

}

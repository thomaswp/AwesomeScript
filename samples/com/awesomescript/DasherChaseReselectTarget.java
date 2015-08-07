
package com.awesomescript;

import java.util.EnumSet;

public class DasherChaseReselectTarget
    extends Script
{


    public void onTick() {
        setBool("lookforcreeps", Flagtoggle.No);
        // check for people to chase, first check if we have enough hp
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.Greater, Targetself.Self)) {
            // search for players
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.6D, 1.6D, Yesno.No)) {
                // [selectPlayer]
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            } else {
                setBool("lookforcreeps", Flagtoggle.Yes);
            }
        } else {
            setBool("lookforcreeps", Flagtoggle.Yes);
        }
        if (getBoolEquals("lookforcreeps", Yesno.Yes)) {
            // make sure we are not too low
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.Greater, Targetself.Self)) {
                // grab enemy droids [selectDroids]
                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
            }
        }
    }

}

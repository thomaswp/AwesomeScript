
package com.awesomescript;

import java.util.EnumSet;

public class SuperTedFocusEnemy
    extends Script
{


    public void onTick() {
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
            if (receivedMessage("FocusThisGuy")) {
                if (receivedTarget(EnumSet.of(TargetGroups.PLAYERS))) {
                    receiveTarget();
                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    } else {
                        // chaseBattle(4)
                        adjustCounter("setState", "4", Valueadjust.Set);
                    }
                }
            }
        }
        // chaseBattle(4)
        if (checkCounter("state", "4", Valuecompare.Equal)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                emitTargetInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.5D, 1.5D);
                emitMessageInArea("FocusThisGuy", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes, Yesno.No);
            }
        }
        if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                // make sure there are no turrets
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.5D, 1.0D, Yesno.Yes)) {
                } else {
                    // ally near
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 50.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                        // enemy near
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            adjustCounter("setState", "4", Valueadjust.Set);
                        }
                    }
                }
            }
        }
    }

}

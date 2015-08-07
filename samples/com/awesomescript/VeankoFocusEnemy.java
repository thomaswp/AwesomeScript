
package com.awesomescript;

import java.util.EnumSet;

public class VeankoFocusEnemy
    extends Script
{


    public void onTick() {
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
            if (getBoolEquals("Backdooring", Yesno.No)) {
                if (receivedMessage("FocusThisGuy")) {
                    if (receivedTarget(EnumSet.of(TargetGroups.PLAYERS))) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes, Yesno.No)) {
                            if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            } else {
                                receiveTarget();
                                // chaseBattle(4)
                                adjustCounter("setState", "4", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
        }
        // chaseBattle(4)
        if (checkCounter("state", "4", Valuecompare.Equal)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                emitTargetInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.5D, 1.5D);
                emitMessageInArea("FocusThisGuy", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.5D, 1.5D, Yesno.Yes, Yesno.Yes);
            }
        }
        if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "4", Valuecompare.Equal))||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (getBoolEquals("Backdooring", Yesno.No)) {
                    if (getBoolEquals("Outnumbered", Yesno.No)) {
                        // make sure there are no turrets
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 2.5D, 1.0D, Yesno.Yes)) {
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 50.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)||checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                                // enemy near
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 2.0D, 2.0D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    adjustCounter("setState", "4", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

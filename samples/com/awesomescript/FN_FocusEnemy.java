
package com.awesomescript;

import java.util.EnumSet;

public class FN_FocusEnemy
    extends Script
{


    public void onTick() {
        if ((checkCounter("state", "3", Valuecompare.Equal)||checkCounter("state", "2", Valuecompare.Equal))||checkCounter("state", "4", Valuecompare.Equal)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (receivedMessage("FocusThisGuy")) {
                    if (receivedTarget(EnumSet.of(TargetGroups.PLAYERS))) {
                        // chaseBattle(4)
                        adjustCounter("setState", "4", Valueadjust.Set);
                        receiveTarget();
                    }
                }
            }
        }
        // chaseBattle(4)
        if (checkCounter("state", "4", Valuecompare.Equal)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    emitTargetInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 0.6D, 0.6D);
                    emitMessageInArea("FocusThisGuy", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 0.6D, 0.6D, null, null);
                }
            }
        }
    }

}

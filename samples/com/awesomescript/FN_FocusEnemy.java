
package com.awesomescript;

import java.util.EnumSet;

public class FN_FocusEnemy
    extends Script
{


    public void onTick() {
        if ((checkcounter("state", "3", Valuecompare.Equal)||checkcounter("state", "2", Valuecompare.Equal))||checkcounter("state", "4", Valuecompare.Equal)) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (receivedmessage("FocusThisGuy")) {
                    if (receivedtarget(EnumSet.of(TargetGroups.PLAYERS))) {
                        // chaseBattle(4)
                        adjustcounter("setState", "4", Valueadjust.Set);
                        receivetarget();
                    }
                }
            }
        }
        // chaseBattle(4)
        if (checkcounter("state", "4", Valuecompare.Equal)) {
            if (istargettype(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    emittargetinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 0.6D, 0.6D);
                    emitmessageinarea("FocusThisGuy", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 0.6D, 0.6D, null, null);
                }
            }
        }
    }

}

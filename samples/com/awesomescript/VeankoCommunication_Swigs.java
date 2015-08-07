
package com.awesomescript;

import java.util.EnumSet;

public class VeankoCommunication_Swigs
    extends Script
{


    public void onTick() {
        if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
        } else {
            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                emitMessageInArea("InLane1", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 100.0D, 100.0D, Yesno.Yes, Yesno.No);
                if (checkCounter("lane", "2", Valuecompare.Equal)) {
                    emitMessageInArea("InLane2", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 100.0D, 100.0D, Yesno.Yes, Yesno.No);
                }
            }
        }
    }

}

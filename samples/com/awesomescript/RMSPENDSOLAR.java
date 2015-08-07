
package com.awesomescript;


public class RMSPENDSOLAR
    extends Script
{


    public void onTick() {
        if (checkMissionCounter("RMSTAT_SOLAR_SPENT", "3000", Valuecompare.GreaterOrEqual)) {
            completeMission(MissionCompletionDelay.INSTANT);
        }
        if (isMissionCompleted("RMKILLENEMY")) {
            if (onGoldSpent(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", Valuecompare.Greater, "0", "SOLARSPENT")) {
                adjustMissionCounter("RMSTAT_SOLAR_SPENT", "SOLARSPENT", Valueadjust.Add);
            }
        }
    }

}

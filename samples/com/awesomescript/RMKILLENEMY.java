
package com.awesomescript;


public class RMKILLENEMY
    extends Script
{


    public void onTick() {
        if (checkMissionCounter("COMPLETE", "1", Valuecompare.GreaterOrEqual)) {
            completeMission(MissionCompletionDelay.INSTANT);
        }
        if (isMissionCompleted("RMWINBOTMATCH")) {
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.GreaterOrEqual, "1", "")) {
                adjustMissionCounter("COMPLETE", "1", Valueadjust.Set);
            }
        }
    }

}

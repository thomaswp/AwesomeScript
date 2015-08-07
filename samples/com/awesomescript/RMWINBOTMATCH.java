
package com.awesomescript;


public class RMWINBOTMATCH
    extends Script
{


    public void onTick() {
        if (isMissionCompleted("RMTUTORIAL")) {
            if (isPracticeMatch()) {
                if (onWin(Teamswithnumbers.OWN_TEAM)) {
                    adjustMissionCounter("COMPLETE", "1", Valueadjust.Set);
                }
            }
        }
        if (checkMissionCounter("COMPLETE", "1", Valuecompare.GreaterOrEqual)) {
            completeMission(MissionCompletionDelay.INSTANT);
        }
    }

}

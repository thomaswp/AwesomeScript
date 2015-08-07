
package com.awesomescript;


public class RMTUTORIAL
    extends Script
{


    public void onTick() {
        if (checkMissionCounter("COMPLETE", "1", Valuecompare.GreaterOrEqual)) {
            completeMission(MissionCompletionDelay.INSTANT);
        }
        if (isTutorialMatch()) {
            if (onWin(Teamswithnumbers.OWN_TEAM)) {
                adjustMissionCounter("COMPLETE", "1", Valueadjust.Set);
            }
        }
    }

}

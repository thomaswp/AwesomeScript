
package com.awesomescript;

import java.util.EnumSet;

public class AICreepSpy
    extends Script
{


    public void onTick() {
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.Yes)) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (((((onKill(MissionTarget.CREEP, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", "")||onKill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.CREEP, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.TURRET, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.DAMAGE_AREA, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "SPY", "", Valuecompare.Greater, "0", "")) {
            sequence0();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(5.0D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

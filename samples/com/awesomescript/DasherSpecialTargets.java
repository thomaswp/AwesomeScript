
package com.awesomescript;

import java.util.EnumSet;

public class DasherSpecialTargets
    extends Script
{


    public void onTick() {
        // target swiggins anchor
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
        } else {
            if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterPressSnipe")||hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "CreepSummonerHealtotem", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                }
            }
        }
    }

}

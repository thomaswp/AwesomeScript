
package com.awesomescript;

import java.util.EnumSet;

public class Summoner
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
            emitMessageInArea("StealthON", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneBlind")) {
            if (once()) {
                emitMessageInArea("SummonerDroneBlind", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneFaster1")) {
            if (once()) {
                emitMessageInArea("SummonerDroneFaster1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneFaster2")) {
            if (once()) {
                emitMessageInArea("SummonerDroneFaster2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneDamage1")) {
            if (once()) {
                emitMessageInArea("SummonerDroneDamage1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneDamage2")) {
            if (once()) {
                emitMessageInArea("SummonerDroneDamage2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerHealtotemCreatedOn")) {
            sequence0();
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerShotHealOn")) {
            enableUpgrade(Yesno.No, "SummonerShotHealOn");
            adjustCounter("healcounter", "0", Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerShotSolar1")) {
            if (checkCounter("healcounter", "20", Valuecompare.GreaterOrEqual)) {
                enableUpgrade(Yesno.Yes, "SummonerShotDoubleOn");
                playAnimation("HEALSuper_Overlay", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            } else {
                adjustCounter("healcounter", "1", Valueadjust.Add);
                enableUpgrade(Yesno.No, "SummonerShotDoubleOn");
            }
        }
        // Drone counter for icons
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerDrone", Yesno.No, Yesno.Yes, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "4", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            enableUpgrade(Yesno.No, "SummonerDroneCount0ON");
            enableUpgrade(Yesno.No, "SummonerDroneCount1ON");
            enableUpgrade(Yesno.No, "SummonerDroneCount2ON");
            enableUpgrade(Yesno.No, "SummonerDroneCount3ON");
            enableUpgrade(Yesno.Yes, "SummonerDroneCount4ON");
        } else {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerDrone", Yesno.No, Yesno.Yes, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                enableUpgrade(Yesno.No, "SummonerDroneCount0ON");
                enableUpgrade(Yesno.No, "SummonerDroneCount1ON");
                enableUpgrade(Yesno.No, "SummonerDroneCount2ON");
                enableUpgrade(Yesno.Yes, "SummonerDroneCount3ON");
                enableUpgrade(Yesno.No, "SummonerDroneCount4ON");
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerDrone", Yesno.No, Yesno.Yes, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    enableUpgrade(Yesno.No, "SummonerDroneCount0ON");
                    enableUpgrade(Yesno.No, "SummonerDroneCount1ON");
                    enableUpgrade(Yesno.Yes, "SummonerDroneCount2ON");
                    enableUpgrade(Yesno.No, "SummonerDroneCount3ON");
                    enableUpgrade(Yesno.No, "SummonerDroneCount4ON");
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSummonerDrone", Yesno.No, Yesno.Yes, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                        enableUpgrade(Yesno.No, "SummonerDroneCount0ON");
                        enableUpgrade(Yesno.Yes, "SummonerDroneCount1ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount2ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount3ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount4ON");
                    } else {
                        enableUpgrade(Yesno.Yes, "SummonerDroneCount0ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount1ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount2ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount3ON");
                        enableUpgrade(Yesno.No, "SummonerDroneCount4ON");
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.5D);
        enableUpgrade(Yesno.No, "SummonerHealtotemCreatedOn");
    }

}

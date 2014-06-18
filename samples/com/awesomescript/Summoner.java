
package com.awesomescript;

import java.util.EnumSet;

public class Summoner
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "Shocking")) {
            enableUpgrade(Yesno.No, "Shocking");
            if (isUpgradeEnabled(Yesno.Yes, "SummonerShotSolar1")) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 100.0D, "", 0.1D, 0.0D, 0.16D, 0.1D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Gold, 1.0D, Valueadjust.Add);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "PassiveSummonerCoinHeal")) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (onGoldCollected(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", GoldPickupType.PICKUP, Valuecompare.GreaterOrEqual, "1", "")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    playAnimation("health", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
            emitMessageInArea("StealthON", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
        }
        if (isUpgradeEnabled(Yesno.Yes, "SummonerDroneKill")) {
            sequence0();
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
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        emitMessageInArea("DronesKill", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
        enableUpgrade(Yesno.No, "SummonerDroneKill");
    }

}

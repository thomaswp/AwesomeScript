
package com.awesomescript;

import java.util.EnumSet;

public class Summoner
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isupgradeenabled(Yesno.Yes, "Shocking")) {
            enableupgrade(Yesno.No, "Shocking");
            if (isupgradeenabled(Yesno.Yes, "SummonerShotSolar1")) {
                if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "", CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 100.0D, "", 0.1D, 0.0D, 0.16D, 0.1D, Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.Gold, 1.0D, Valueadjust.Add);
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "PassiveSummonerCoinHeal")) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (ongoldcollected(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", GoldPickupType.PICKUP, Valuecompare.GreaterOrEqual, "1", "")) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    playanimation("health", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "StealthPowerup")) {
            emitmessageinarea("StealthON", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneKill")) {
            sequence0();
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneBlind")) {
            if (once()) {
                emitmessageinarea("SummonerDroneBlind", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneFaster1")) {
            if (once()) {
                emitmessageinarea("SummonerDroneFaster1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneFaster2")) {
            if (once()) {
                emitmessageinarea("SummonerDroneFaster2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneDamage1")) {
            if (once()) {
                emitmessageinarea("SummonerDroneDamage1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "SummonerDroneDamage2")) {
            if (once()) {
                emitmessageinarea("SummonerDroneDamage2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        emitmessageinarea("DronesKill", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
        enableupgrade(Yesno.No, "SummonerDroneKill");
    }

}

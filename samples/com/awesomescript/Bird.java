
package com.awesomescript;

import java.util.EnumSet;

public class Bird
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            enableUpgrade(Yesno.No, "BirdFly");
        } else {
            enableUpgrade(Yesno.Yes, "BirdFly");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdBlock")) {
            if (getBoolEquals("BirdBlockHealthGiven", Yesno.No)) {
                setBool("BirdBlockHealthGiven", Flagtoggle.Yes);
                adjustCharacterValue(CharactervaluesAdjustable.Health, 300.0D, Valueadjust.Add);
            }
        } else {
            setBool("BirdBlockHealthGiven", Flagtoggle.No);
        }
        if (isInNamedArea("NOFLYZONE", Ownenemy.OWN_TEAM, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "BirdStopFly");
        } else {
            enableUpgrade(Yesno.No, "BirdStopFly");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdDiveGold")) {
            if (checkCharacterValue(CharactervaluesCheckable.Gold, 150.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "BirdGoldInPocket");
            } else {
                enableUpgrade(Yesno.No, "BirdGoldInPocket");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdShootDamageGold")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Gold, Valuecompare.GreaterOrEqual, 150.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "EnemyHasGold");
                playAnimation("wealth", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            } else {
                enableUpgrade(Yesno.No, "EnemyHasGold");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdShootHero")) {
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "1", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 50.0D, Valueadjust.Add);
                if (isUpgradeEnabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 500.0D, Valueadjust.Add);
                }
            }
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "2", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 100.0D, Valueadjust.Add);
                if (isUpgradeEnabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 500.0D, Valueadjust.Add);
                }
            }
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "3", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 150.0D, Valueadjust.Add);
                if (isUpgradeEnabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 500.0D, Valueadjust.Add);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdDiveCooldown")) {
            if (once()) {
                sequence0();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdDiveCooldown")) {
            if (isUpgradeEnabled(Yesno.Yes, "BirdDiveActivated")) {
                sequence1();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdDiveCooldown")) {
            if (getBoolEquals("DiveToggle", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "BirdDiveToggle");
            } else {
                enableUpgrade(Yesno.No, "BirdDiveToggle");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BotLevel1")) {
            enableUpgrade(Yesno.Yes, "BotLevel1x");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BotLevel2")) {
            enableUpgrade(Yesno.Yes, "BotLevel2x");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BotLevel3")) {
            enableUpgrade(Yesno.Yes, "BotLevel3x");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BotLevel4")) {
            enableUpgrade(Yesno.Yes, "BotLevel4x");
        }
        if (isUpgradeEnabled(Yesno.Yes, "bothandicap1")) {
            enableUpgrade(Yesno.Yes, "bothandicap1x");
        }
        if (isUpgradeEnabled(Yesno.Yes, "bothandicap2")) {
            enableUpgrade(Yesno.Yes, "bothandicap2x");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.No, "BirdDiveActivated");
        wait(0.2D);
        setBool("DiveToggle", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("DiveToggle", Flagtoggle.Toggle);
        wait(0.2D);
        enableUpgrade(Yesno.No, "BirdDiveReset");
        wait(0.8D);
        enableUpgrade(Yesno.No, "BirdDiveActivated");
    }

}

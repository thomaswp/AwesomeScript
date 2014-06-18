
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
                adjustCharacterValue(CharactervaluesAdjustable.Health, 30.0D, Valueadjust.Add);
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
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Gold, Valuecompare.GreaterOrEqual, 150.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "EnemyHasGold");
                playAnimation("wealth", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            } else {
                enableUpgrade(Yesno.No, "EnemyHasGold");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BirdShootHero")) {
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 50.0D, Valueadjust.Add);
                if (isUpgradeEnabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 50.0D, Valueadjust.Add);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (onGoldCollected(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", GoldPickupType.PICKUP, Valuecompare.GreaterOrEqual, "1", "")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    playAnimation("health", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
    }

}

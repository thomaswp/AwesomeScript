
package com.awesomescript;

import java.util.EnumSet;

public class Bird
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isonground(Yesno.Yes, Targetself.Self)) {
            enableupgrade(Yesno.No, "BirdFly");
        } else {
            enableupgrade(Yesno.Yes, "BirdFly");
        }
        if (isupgradeenabled(Yesno.Yes, "BirdBlock")) {
            if (getboolequals("BirdBlockHealthGiven", Yesno.No)) {
                setbool("BirdBlockHealthGiven", Flagtoggle.Yes);
                adjustcharactervalue(CharactervaluesAdjustable.Health, 30.0D, Valueadjust.Add);
            }
        } else {
            setbool("BirdBlockHealthGiven", Flagtoggle.No);
        }
        if (isinnamedarea("NOFLYZONE", Ownenemy.OWN_TEAM, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "BirdStopFly");
        } else {
            enableupgrade(Yesno.No, "BirdStopFly");
        }
        if (isupgradeenabled(Yesno.Yes, "BirdDiveGold")) {
            if (checkcharactervalue(CharactervaluesCheckable.Gold, 150.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "BirdGoldInPocket");
            } else {
                enableupgrade(Yesno.No, "BirdGoldInPocket");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "BirdShootDamageGold")) {
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Gold, Valuecompare.GreaterOrEqual, 150.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableupgrade(Yesno.Yes, "EnemyHasGold");
                playanimation("wealth", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            } else {
                enableupgrade(Yesno.No, "EnemyHasGold");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "BirdShootHero")) {
            if (onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                adjustcharactervalue(CharactervaluesAdjustable.Gold, 50.0D, Valueadjust.Add);
                if (isupgradeenabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 50.0D, Valueadjust.Add);
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (ongoldcollected(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", GoldPickupType.PICKUP, Valuecompare.GreaterOrEqual, "1", "")) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    playanimation("health", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
    }

}

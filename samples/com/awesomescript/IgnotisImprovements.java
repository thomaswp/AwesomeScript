
package com.awesomescript;

import java.util.EnumSet;

public class IgnotisImprovements
    extends Script
{


    public void onTick() {
        // Drop pod Solar
        if (once()) {
            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
        }
        // Check if I shouldn't target creeps (nearby unhealthy enemies)
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.Less, 50.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
            setBool("dontTargetCreeps", Flagtoggle.Yes);
        } else {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.Less, 95.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.Less, 95.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                setBool("dontTargetCreeps", Flagtoggle.Yes);
            }
        }
        // Kill creeps more often
        if (getBoolEquals("dontTargetCreeps", Yesno.No)) {
            // Check if I don't have an advantage in numbers
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.Greater, 30.0D, "3", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)&&isTargetType(Yesno.No, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                    if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||getBoolEquals("RetreatingFromNauts", Yesno.Yes))||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                    } else {
                        // Target a creep
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    }
                }
            } else {
                if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.Greater, 30.0D, "2", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No))&&isTargetType(Yesno.No, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                    if (((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||getBoolEquals("RetreatingFromNauts", Yesno.Yes))||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                    } else {
                        // Target a creep
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    }
                }
            }
        } else {
            setBool("dontTargetCreeps", Flagtoggle.No);
        }
        // Be extra careful when outnumbered
        if (getBoolEquals("Outnumbered", Yesno.Yes)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.Greater, Targetself.Target)) {
                        setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                        setBool("RetreatingFromNauts", Flagtoggle.Yes);
                        setBool("MoveTowardsTarget", Flagtoggle.No);
                    }
                }
            } else {
                if ((((((isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||getBoolEquals("RetreatingFromNauts", Yesno.Yes))||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self))||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
                } else {
                    // Target a creep
                    selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 2.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                }
            }
        }
        if (checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self)||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                // Unless I can get a kill
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.Greater, Targetself.Target)) {
                    setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                    setBool("RetreatingFromNauts", Flagtoggle.Yes);
                    setBool("MoveTowardsTarget", Flagtoggle.No);
                }
            }
        }
        if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain")&&getBoolEquals("IgnoreAnchor", Yesno.No))&&hasUpgrade("Captain", Teamswithnumbers.ENEMY_TEAM, "CaptainDrop"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.Yes);
            setBool("MoveTowardsTarget", Flagtoggle.Yes);
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
    }

}

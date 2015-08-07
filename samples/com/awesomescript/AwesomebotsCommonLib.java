
package com.awesomescript;

import java.util.EnumSet;

public class AwesomebotsCommonLib
    extends Script
{


    public void onTick() {
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Brute", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.1D, Yesno.Yes)&&hasUpgrade("Brute", Teamswithnumbers.ENEMY_TEAM, "BruteStamp")) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                setBool("jump", Flagtoggle.Yes);
            }
        }
        if ((isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "InAir"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "dash")) {
            if ((hasTarget(Yesno.Yes)&&isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target))&&checkClass(Targetself.Target, "Dasher")) {
                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
            } else {
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            }
        }
        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.05D, 0.0D, 0.1D, 0.02D, Yesno.No, Yesno.No)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.01D, 0.2D, Yesno.Yes, Yesno.No))&&isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, -0.4D, 0.5D, 0.2D, Yesno.No)) {
            if (isNextWaypointPosition(Offsetposition.ABOVE)) {
            } else {
                setBool("DownJump", Flagtoggle.Yes);
            }
        }
        if (((getBoolEquals("Outnumbered", Yesno.Yes)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No))&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS)))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Greater, Targetself.Target)) {
            setBool("MoveAwayFromTarget", Flagtoggle.Yes);
            setBool("RetreatingFromNauts", Flagtoggle.Yes);
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        if (checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Self)||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Self)) {
            // Unless I can get a kill
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Greater, Targetself.Target)) {
                setBool("MoveAwayFromTarget", Flagtoggle.Yes);
                setBool("RetreatingFromNauts", Flagtoggle.Yes);
                setBool("MoveTowardsTarget", Flagtoggle.No);
            }
        }
        if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Captain")&&getBoolEquals("IgnoreAnchor", Yesno.No))&&hasUpgrade("Captain", Teamswithnumbers.ENEMY_TEAM, "CaptainDrop"))&&isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes)) {
            selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.Yes);
            setBool("MoveTowardsTarget", Flagtoggle.Yes);
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        if (isInNamedArea("healAreaClose", Ownenemy.OWN_TEAM, Targetself.Self)&&checkCounter("state", "3", Valuecompare.Equal)) {
            setBool("goForward", Flagtoggle.Yes);
            setBool("goBack", Flagtoggle.No);
        }
    }

}


package com.awesomescript;

import java.util.EnumSet;

public class AIRangedCreep
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("FN_CreepLevelling");
        if (getBoolEquals("Initialized", Yesno.No)) {
            sequence0();
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.0D, -0.02D, 0.01D, 0.04D, Yesno.No, Yesno.No)) {
            if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                if (getBoolEquals("OnGroundTooLong", Yesno.Yes)) {
                    setBool("Initialized", Flagtoggle.No);
                    setBool("OnGroundTooLong", Flagtoggle.No);
                }
                setBool("OnGroundTooLong", Flagtoggle.Yes);
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, -0.1D, 0.28D, 0.5D, Yesno.Yes, Yesno.No)) {
            sequence1();
            if (hasTarget(Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.No, "CreepFlyingStop")) {
                    enableUpgrade(Yesno.Yes, "CreepFlyingStop");
                }
                if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
                } else {
                    aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                    sequence2();
                }
            }
        } else {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.2D, -0.1D, 0.24D, 0.5D, Yesno.No, Yesno.No)) {
                if (timer(Timeunits.Seconds, 0.2D, Yesno.Yes)) {
                    pressStick(Directions.BACKWARD, 0.0D);
                }
            } else {
                if (timer(Timeunits.Seconds, 1.5D, Yesno.No)) {
                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    } else {
                        pressStick(Directions.BACKWARD, 0.0D);
                    }
                }
                log("Bewegen", "", "");
                if (isUpgradeEnabled(Yesno.Yes, "CreepFlyingStop")) {
                    enableUpgrade(Yesno.No, "CreepFlyingStop");
                }
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    pressStick(Directions.FORWARD, 0.0D);
                } else {
                    pressStick(Directions.BACKWARD, 0.0D);
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepFlying", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)) {
                    if (random("50")) {
                        sequence3();
                    }
                }
                if (isInNamedArea("FlyUp", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    pressStick(Directions.UP, 1.0D);
                }
                if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "dontfly", 0.1D, 0.1D, 0.0D, 0.0D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.0D, 0.1D, 0.01D, 0.05D, Yesno.No, Yesno.No))||isInArea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.0D, 0.1D, 0.01D, 0.12D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.DOWN, 0.2D);
                }
            }
        }
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.0D, -0.08D, 0.01D, 0.11D, Yesno.No, Yesno.No)) {
            if (isUpgradeEnabled(Yesno.Yes, "CreepFlyingStop")) {
                enableUpgrade(Yesno.No, "CreepFlyingStop");
            }
            pressStick(Directions.UP, 0.2D);
        }
        if (isUpgradeEnabled(Yesno.Yes, "HunterWallDroid")) {
            if (((((onKill(MissionTarget.CREEP, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", "")||onKill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.CREEP, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.TURRET, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.DAMAGE_AREA, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "HUNTER", "", Valuecompare.Greater, "0", "")) {
                sequence4();
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.No, "CreepFlyingStop");
        setBool("Initialized", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.2D);
        pressStick(Directions.UP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.2D, -0.1D, 0.28D, 0.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        log("Aanvallen", "", "");
        pressButton(Buttons.FACE_LEFT, 0.1D);
        removeTarget();
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(5.0D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

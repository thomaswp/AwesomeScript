
package com.awesomescript;

import java.util.EnumSet;

public class AIMawTurret
    extends Script
{


    public void onTick() {
        if (getBoolEquals("Init", Yesno.No)) {
            setBool("Init", Flagtoggle.Yes);
            adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 25.0D, Valueadjust.Set);
        }
        if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
            if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.2D, 0.0D, 0.4D, 0.65D, Yesno.Yes, Yesno.No)) {
                    aimStickAtTarget(0.3D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                    sequence0();
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, 0.0D, 0.4D, 0.65D, Yesno.No, Yesno.No)) {
                        pressStick(Directions.BACKWARD, 0.0D);
                        log("DRAAIEN!", "", "");
                    }
                }
            }
        }
        if (((((onKill(MissionTarget.CREEP, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", "")||onKill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.CREEP, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.TURRET, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.DAMAGE_AREA, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "MAW", "", Valuecompare.Greater, "0", "")) {
            sequence1();
        }
        if (checkGameTime(300.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth1")) {
                if (once()) {
                    buyUpgrade("Addhealth1");
                }
            }
        }
        if (checkGameTime(600.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth2")) {
                if (once()) {
                    buyUpgrade("Addhealth2");
                }
            }
        }
        if (checkGameTime(900.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "Addhealth3")) {
                if (once()) {
                    buyUpgrade("Addhealth3");
                }
            }
        }
        if (checkGameTime(900.0D, Valuecompare.Greater)) {
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretTimer3")) {
            } else {
                enableUpgrade(Yesno.Yes, "MawTurretTimer3");
                adjustCharacterValue(CharactervaluesAdjustable.Health, 70.0D, Valueadjust.Add);
            }
        }
        if (checkGameTime(600.0D, Valuecompare.Greater)) {
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretTimer2")) {
            } else {
                enableUpgrade(Yesno.Yes, "MawTurretTimer2");
                adjustCharacterValue(CharactervaluesAdjustable.Health, 70.0D, Valueadjust.Add);
            }
        }
        if (checkGameTime(300.0D, Valuecompare.Greater)) {
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretTimer1")) {
            } else {
                enableUpgrade(Yesno.Yes, "MawTurretTimer1");
                adjustCharacterValue(CharactervaluesAdjustable.Health, 70.0D, Valueadjust.Add);
            }
        }
        if (receivedMessage("MawTurretAttackspeed1")) {
            enableUpgrade(Yesno.Yes, "MawTurretAttackspeed1");
        }
        if (receivedMessage("MawTurretAttackspeed2")) {
            enableUpgrade(Yesno.Yes, "MawTurretAttackspeed2");
        }
        if (receivedMessage("MawTurretAttackspeed3")) {
            enableUpgrade(Yesno.Yes, "MawTurretAttackspeed3");
        }
        if (receivedMessage("MawTurretGrow")) {
            enableUpgrade(Yesno.Yes, "MawTurretGrow");
        }
        if (receivedMessage("MawTurretDamage1")) {
            enableUpgrade(Yesno.Yes, "MawTurretDamage1");
        }
        if (receivedMessage("MawTurretDamage2")) {
            enableUpgrade(Yesno.Yes, "MawTurretDamage2");
        }
        if (isUpgradeEnabled(Yesno.Yes, "MawFertilized")) {
            if (once()) {
                if (isUpgradeEnabled(Yesno.Yes, "MawSpitTrajectory")) {
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 30.0D, Valueadjust.Add);
                } else {
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 20.0D, Valueadjust.Add);
                }
            }
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretGrow")) {
                enableUpgrade(Yesno.Yes, "MawFertilizerLifetime");
            }
            if (isUpgradeEnabled(Yesno.Yes, "MawTurretMaxChunks")) {
                enableUpgrade(Yesno.Yes, "MawFertilizerDamage");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.65D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(5.0D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

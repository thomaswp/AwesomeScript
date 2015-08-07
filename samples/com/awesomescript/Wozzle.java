
package com.awesomescript;

import java.util.EnumSet;

public class Wozzle
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "WozzleFireHitEnemyOn")) {
            enableUpgrade(Yesno.No, "WozzleFireHitEnemyOn");
            if (isUpgradeEnabled(Yesno.Yes, "WozzleAimedSpeedup2")) {
                enableUpgrade(Yesno.Yes, "WozzleAimedSpeedup2On");
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "WozzleAimedSpeedup1")) {
                    enableUpgrade(Yesno.Yes, "WozzleAimedSpeedup1On");
                }
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostOn")) {
                enableUpgrade(Yesno.No, "WozzleAttackspeedIconFireOn");
                enableUpgrade(Yesno.Yes, "WozzleIconFrostOn");
                enableUpgrade(Yesno.No, "WozzleAttackspeedIconFrostOn");
            } else {
                enableUpgrade(Yesno.No, "WozzleAttackspeedIconFrostOn");
                enableUpgrade(Yesno.No, "WozzleIconFrostOn");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "WozzleAimedSpeedup1On")) {
            if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostOn")) {
                enableUpgrade(Yesno.Yes, "WozzleAttackspeedIconFrostOn");
                enableUpgrade(Yesno.No, "WozzleIconFrostOn");
                enableUpgrade(Yesno.No, "WozzleAttackspeedIconFireOn");
            } else {
                enableUpgrade(Yesno.Yes, "WozzleAttackspeedIconFireOn");
                enableUpgrade(Yesno.No, "WozzleAttackspeedIconFrostOn");
                enableUpgrade(Yesno.No, "WozzleIconFrostOn");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "WozzleAimedSpeedup1On")||isUpgradeEnabled(Yesno.Yes, "WozzleAimedSpeedup2On")) {
            sequence0();
        }
        if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostOn")) {
            setBool("FrostOn", Flagtoggle.Yes);
            if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostRegen1")) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 30.0D, Valueadjust.Add);
                }
            }
            if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostRegen2")) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 30.0D, Valueadjust.Add);
                }
            }
            adjustCounter("frosttimer", "1", Valueadjust.Add);
            if (checkCounter("frosttimer", "60", Valuecompare.GreaterOrEqual)) {
                enableUpgrade(Yesno.Yes, "WozzleFrostLongOn");
            } else {
                enableUpgrade(Yesno.No, "WozzleFrostLongOn");
            }
        } else {
            sequence1();
            adjustCounter("frosttimer", "0", Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "WozzleShotNoEnemies1")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes)) {
                enableUpgrade(Yesno.No, "WozzleNoEnemiesNear1On");
                if (isUpgradeEnabled(Yesno.Yes, "WozzleShotNoEnemies2")) {
                    enableUpgrade(Yesno.No, "WozzleNoEnemiesNear2On");
                }
            } else {
                enableUpgrade(Yesno.Yes, "WozzleNoEnemiesNear1On");
                if (isUpgradeEnabled(Yesno.Yes, "WozzleShotNoEnemies2")) {
                    enableUpgrade(Yesno.Yes, "WozzleNoEnemiesNear2On");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostLongOn")&&isUpgradeEnabled(Yesno.Yes, "WozzleFrostSpeed1")) {
            // show overlay animation when sprint starts
            playAnimation("SPRINTSTART", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, -100.0D, Yesno.No, Teams.OWN_TEAM);
        }
        if (getBoolEquals("FrostOn", Yesno.Yes)) {
            if (isUpgradeEnabled(Yesno.No, "WozzleFrostOn")) {
                enableUpgrade(Yesno.Yes, "WozzleFrostSwitchCooldown");
                setBool("FrostOn", Flagtoggle.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "Cocoon")) {
            if (isUpgradeEnabled(Yesno.Yes, "WozzleFrostOn")) {
                enableUpgrade(Yesno.No, "WozzleFrostOn");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(2.0D);
        enableUpgrade(Yesno.No, "WozzleAimedSpeedup2On");
        enableUpgrade(Yesno.No, "WozzleAimedSpeedup1On");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(10.0D);
        enableUpgrade(Yesno.No, "WozzleFrostLongOn");
    }

}

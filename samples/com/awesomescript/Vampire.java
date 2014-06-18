
package com.awesomescript;

import java.util.EnumSet;

public class Vampire
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "Cocoon")) {
            sequence0();
        }
        if (isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
            sequence1();
        }
        if (isInNamedArea("NoFlyZone", Ownenemy.OWN_TEAM, Targetself.Self)) {
            sequence2();
        }
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstToggle")) {
            setBool("BloodThirstToggle", Flagtoggle.Toggle);
            if (isUpgradeEnabled(Yesno.No, "VampireBloodThirstON")) {
                setBool("SetCloudCooldown", Flagtoggle.Yes);
            }
            enableUpgrade(Yesno.No, "VampireBloodThirstToggle");
        }
        if (getBoolEquals("SetCloudCooldown", Yesno.Yes)) {
            sequence3();
        }
        if (getBoolEquals("BloodThirstToggle", Yesno.No)) {
            enableUpgrade(Yesno.No, "VampireBloodThirstON");
        } else {
            enableUpgrade(Yesno.Yes, "VampireBloodThirstON");
        }
        // Bloodthirst healthdrain
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstON")) {
            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstAttackspeed")) {
                if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, -2.0D, Valueadjust.Add);
                    if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage1")) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage2")) {
                            adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage3")) {
                                adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            }
                        }
                    }
                }
            } else {
                if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, -2.0D, Valueadjust.Add);
                    if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage1")) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage2")) {
                            adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstDamage3")) {
                                adjustCharacterValue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            }
                        }
                    }
                }
            }
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "Breakstealth");
            }
            // Bloodthirst speed inc
            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSpeed")) {
                enableUpgrade(Yesno.Yes, "VampireBloodThirstSpeedON");
            }
        } else {
            enableUpgrade(Yesno.No, "VampireBloodThirstSpeedON");
        }
        // Bolas increase dmg based on health
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.Less, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "VampireHealth3");
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 85.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp1")) {
                enableUpgrade(Yesno.Yes, "VampireHealth3");
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 95.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableUpgrade(Yesno.Yes, "VampireHealth3");
                } else {
                    enableUpgrade(Yesno.No, "VampireHealth3");
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "VampireHealth2");
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp1")) {
                enableUpgrade(Yesno.Yes, "VampireHealth2");
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableUpgrade(Yesno.Yes, "VampireHealth2");
                } else {
                    enableUpgrade(Yesno.No, "VampireHealth2");
                }
            }
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 25.0D, Valuecompare.Less, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "VampireHealth1");
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 35.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp1")) {
                enableUpgrade(Yesno.Yes, "VampireHealth1");
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 45.0D, Valuecompare.Less, Targetself.Self)&&isUpgradeEnabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableUpgrade(Yesno.Yes, "VampireHealth1");
                } else {
                    enableUpgrade(Yesno.No, "VampireHealth1");
                }
            }
        }
        // Bite increase max hp
        if (isUpgradeEnabled(Yesno.Yes, "VampireBiteMaxhp1")) {
            if (getBoolEquals("VampireExtrahp1done", Yesno.No)) {
                if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                    enableUpgrade(Yesno.Yes, "VampireExtrahp1");
                    setBool("VampireExtrahp1done", Flagtoggle.Yes);
                }
            }
            if (getBoolEquals("VampireExtrahp2done", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "VampireBiteMaxhp2")) {
                    if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                        enableUpgrade(Yesno.Yes, "VampireExtrahp2");
                        setBool("VampireExtrahp2done", Flagtoggle.Yes);
                    }
                }
            }
        }
        // Bite enemy low hp
        if (isUpgradeEnabled(Yesno.Yes, "VampireBiteNearbyhero1")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "VampireEnemynear1");
                if (isUpgradeEnabled(Yesno.Yes, "VampireBiteNearbyhero2")) {
                    enableUpgrade(Yesno.Yes, "VampireEnemynear2");
                }
            } else {
                enableUpgrade(Yesno.No, "VampireEnemynear1");
                enableUpgrade(Yesno.No, "VampireEnemynear2");
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
        if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.Yes, "Breakstealth")) {
                enableUpgrade(Yesno.No, "Breakstealth");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("BloodThirstToggle", Flagtoggle.No);
        wait(2.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("BloodThirstToggle", Flagtoggle.No);
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("BloodThirstToggle", Flagtoggle.No);
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        enableUpgrade(Yesno.Yes, "VampireCloudCooldownON");
        wait(1.1D);
        enableUpgrade(Yesno.No, "VampireCloudCooldownON");
        setBool("SetCloudCooldown", Flagtoggle.No);
    }

}

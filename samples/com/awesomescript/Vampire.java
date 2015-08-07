
package com.awesomescript;

import java.util.EnumSet;

public class Vampire
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstToggle")) {
            setBool("BloodThirstToggle", Flagtoggle.Toggle);
            enableUpgrade(Yesno.No, "VampireBloodThirstToggle");
        }
        if (getBoolEquals("BloodThirstToggle", Yesno.No)) {
            enableUpgrade(Yesno.No, "VampireBloodThirstON");
        } else {
            enableUpgrade(Yesno.Yes, "VampireBloodThirstON");
        }
        if ((isUpgradeEnabled(Yesno.Yes, "Cocoon")||isUpgradeEnabled(Yesno.Yes, "StealthPowerup"))||isInNamedArea("NoFlyZone", Ownenemy.OWN_TEAM, Targetself.Self)) {
            sequence0();
        }
        // Bloodthirst healthdrain
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstON")) {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "Breakstealth");
            }
            if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSpeed")) {
                enableUpgrade(Yesno.Yes, "VampireBloodThirstSpeedON");
            }
        } else {
            enableUpgrade(Yesno.No, "VampireBloodThirstSpeedON");
        }
        if (isUpgradeEnabled(Yesno.Yes, "VampireBloodThirstSize")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "6", 0.0D, 0.0D, 0.33D, 0.33D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "VampireRageTargets6");
                enableUpgrade(Yesno.No, "VampireRageTargets5");
                enableUpgrade(Yesno.No, "VampireRageTargets4");
                enableUpgrade(Yesno.No, "VampireRageTargets3");
                enableUpgrade(Yesno.No, "VampireRageTargets2");
                enableUpgrade(Yesno.No, "VampireRageTargets1");
                enableUpgrade(Yesno.No, "VampireRageTargets0");
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "5", 0.0D, 0.0D, 0.33D, 0.33D, Yesno.No)) {
                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                    enableUpgrade(Yesno.Yes, "VampireRageTargets5");
                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                    enableUpgrade(Yesno.No, "VampireRageTargets1");
                    enableUpgrade(Yesno.No, "VampireRageTargets0");
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "4", 0.0D, 0.0D, 0.33D, 0.33D, Yesno.No)) {
                        enableUpgrade(Yesno.No, "VampireRageTargets6");
                        enableUpgrade(Yesno.No, "VampireRageTargets5");
                        enableUpgrade(Yesno.Yes, "VampireRageTargets4");
                        enableUpgrade(Yesno.No, "VampireRageTargets3");
                        enableUpgrade(Yesno.No, "VampireRageTargets2");
                        enableUpgrade(Yesno.No, "VampireRageTargets1");
                        enableUpgrade(Yesno.No, "VampireRageTargets0");
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.33D, 0.33D, Yesno.No)) {
                            enableUpgrade(Yesno.No, "VampireRageTargets6");
                            enableUpgrade(Yesno.No, "VampireRageTargets5");
                            enableUpgrade(Yesno.No, "VampireRageTargets4");
                            enableUpgrade(Yesno.Yes, "VampireRageTargets3");
                            enableUpgrade(Yesno.No, "VampireRageTargets2");
                            enableUpgrade(Yesno.No, "VampireRageTargets1");
                            enableUpgrade(Yesno.No, "VampireRageTargets0");
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.33D, 0.33D, Yesno.No)) {
                                enableUpgrade(Yesno.No, "VampireRageTargets6");
                                enableUpgrade(Yesno.No, "VampireRageTargets5");
                                enableUpgrade(Yesno.No, "VampireRageTargets4");
                                enableUpgrade(Yesno.No, "VampireRageTargets3");
                                enableUpgrade(Yesno.Yes, "VampireRageTargets2");
                                enableUpgrade(Yesno.No, "VampireRageTargets1");
                                enableUpgrade(Yesno.No, "VampireRageTargets0");
                            } else {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                                    enableUpgrade(Yesno.No, "VampireRageTargets5");
                                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                                    enableUpgrade(Yesno.No, "VampireRageTargets0");
                                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                                    enableUpgrade(Yesno.Yes, "VampireRageTargets1");
                                } else {
                                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                                    enableUpgrade(Yesno.No, "VampireRageTargets5");
                                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                                    enableUpgrade(Yesno.No, "VampireRageTargets1");
                                    enableUpgrade(Yesno.Yes, "VampireRageTargets0");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "6", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "VampireRageTargets6");
                enableUpgrade(Yesno.No, "VampireRageTargets5");
                enableUpgrade(Yesno.No, "VampireRageTargets4");
                enableUpgrade(Yesno.No, "VampireRageTargets3");
                enableUpgrade(Yesno.No, "VampireRageTargets2");
                enableUpgrade(Yesno.No, "VampireRageTargets1");
                enableUpgrade(Yesno.No, "VampireRageTargets0");
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "5", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                    enableUpgrade(Yesno.Yes, "VampireRageTargets5");
                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                    enableUpgrade(Yesno.No, "VampireRageTargets1");
                    enableUpgrade(Yesno.No, "VampireRageTargets0");
                } else {
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "4", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                        enableUpgrade(Yesno.No, "VampireRageTargets6");
                        enableUpgrade(Yesno.No, "VampireRageTargets5");
                        enableUpgrade(Yesno.Yes, "VampireRageTargets4");
                        enableUpgrade(Yesno.No, "VampireRageTargets3");
                        enableUpgrade(Yesno.No, "VampireRageTargets2");
                        enableUpgrade(Yesno.No, "VampireRageTargets1");
                        enableUpgrade(Yesno.No, "VampireRageTargets0");
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                            enableUpgrade(Yesno.No, "VampireRageTargets6");
                            enableUpgrade(Yesno.No, "VampireRageTargets5");
                            enableUpgrade(Yesno.No, "VampireRageTargets4");
                            enableUpgrade(Yesno.Yes, "VampireRageTargets3");
                            enableUpgrade(Yesno.No, "VampireRageTargets2");
                            enableUpgrade(Yesno.No, "VampireRageTargets1");
                            enableUpgrade(Yesno.No, "VampireRageTargets0");
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                                enableUpgrade(Yesno.No, "VampireRageTargets6");
                                enableUpgrade(Yesno.No, "VampireRageTargets5");
                                enableUpgrade(Yesno.No, "VampireRageTargets4");
                                enableUpgrade(Yesno.No, "VampireRageTargets3");
                                enableUpgrade(Yesno.Yes, "VampireRageTargets2");
                                enableUpgrade(Yesno.No, "VampireRageTargets1");
                                enableUpgrade(Yesno.No, "VampireRageTargets0");
                            } else {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "1", 0.0D, 0.0D, 0.28D, 0.28D, Yesno.No)) {
                                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                                    enableUpgrade(Yesno.No, "VampireRageTargets5");
                                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                                    enableUpgrade(Yesno.No, "VampireRageTargets0");
                                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                                    enableUpgrade(Yesno.Yes, "VampireRageTargets1");
                                } else {
                                    enableUpgrade(Yesno.No, "VampireRageTargets6");
                                    enableUpgrade(Yesno.No, "VampireRageTargets5");
                                    enableUpgrade(Yesno.No, "VampireRageTargets4");
                                    enableUpgrade(Yesno.No, "VampireRageTargets3");
                                    enableUpgrade(Yesno.No, "VampireRageTargets2");
                                    enableUpgrade(Yesno.No, "VampireRageTargets1");
                                    enableUpgrade(Yesno.Yes, "VampireRageTargets0");
                                }
                            }
                        }
                    }
                }
            }
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
                if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                    enableUpgrade(Yesno.Yes, "VampireExtrahp1");
                    setBool("VampireExtrahp1done", Flagtoggle.Yes);
                }
            }
            if (getBoolEquals("VampireExtrahp2done", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "VampireBiteMaxhp2")) {
                    if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                        enableUpgrade(Yesno.Yes, "VampireExtrahp2");
                        setBool("VampireExtrahp2done", Flagtoggle.Yes);
                    }
                }
            }
        }
        // Bite enemy low hp
        if (isUpgradeEnabled(Yesno.Yes, "VampireBiteNearbyhero1")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "VampireEnemynear1");
                playAnimation("EnemyNearDmg", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                if (isUpgradeEnabled(Yesno.Yes, "VampireBiteNearbyhero2")) {
                    enableUpgrade(Yesno.Yes, "VampireEnemynear2");
                }
            } else {
                enableUpgrade(Yesno.No, "VampireEnemynear1");
                enableUpgrade(Yesno.No, "VampireEnemynear2");
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
    }

}

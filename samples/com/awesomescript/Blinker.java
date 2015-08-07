
package com.awesomescript;

import java.util.EnumSet;

public class Blinker
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerTargetRemoveIt")) {
            sequence0();
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitTarget2")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "BlinkerHitTarget1On");
                enableUpgrade(Yesno.Yes, "BlinkerHitTarget2On");
            } else {
                enableUpgrade(Yesno.No, "BlinkerHitTarget1On");
                enableUpgrade(Yesno.No, "BlinkerHitTarget2On");
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitTarget1")) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No)) {
                    enableUpgrade(Yesno.Yes, "BlinkerHitTarget1On");
                } else {
                    enableUpgrade(Yesno.No, "BlinkerHitTarget1On");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerTwirlTargets2")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "3", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "BlinkerTwirlTarget1On");
                enableUpgrade(Yesno.Yes, "BlinkerTwirlTarget2On");
            } else {
                enableUpgrade(Yesno.No, "BlinkerTwirlTarget1On");
                enableUpgrade(Yesno.No, "BlinkerTwirlTarget2On");
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerTwirlTargets1")) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No)) {
                    enableUpgrade(Yesno.Yes, "BlinkerTwirlTarget1On");
                } else {
                    enableUpgrade(Yesno.No, "BlinkerTwirlTarget1On");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitCooldown1")) {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
                enableUpgrade(Yesno.Yes, "BlinkerFuryCooldown");
            } else {
                enableUpgrade(Yesno.No, "BlinkerFuryCooldown");
            }
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerBlinkAttackspeed1")) {
                enableUpgrade(Yesno.Yes, "BlinkerFuryCooldown");
            }
        }
        if (isUpgradeEnabled(Yesno.No, "BlinkerFuryCooldown")) {
            enableUpgrade(Yesno.Yes, "BlinkerNoFury");
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitTarget1")) {
                setBool("BlinkerFrenzyHeal1", Flagtoggle.Yes);
            }
        } else {
            enableUpgrade(Yesno.No, "BlinkerNoFury");
        }
        // Bools Voor de Heal
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitHeal1")) {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup1")) {
                setBool("FrenzyHeal1", Flagtoggle.Yes);
            }
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup2")) {
                setBool("FrenzyHeal2", Flagtoggle.Yes);
            }
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup3")) {
                setBool("FrenzyHeal3", Flagtoggle.Yes);
            }
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
                setBool("FrenzyHeal4", Flagtoggle.Yes);
            }
        }
        // Bools omzetten naar upgrades maar niet deactiveren
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitHeal1")) {
            if (getBoolEquals("FrenzyHeal1", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "BlinkerHitFrenzyHeal1");
            }
            if (getBoolEquals("FrenzyHeal2", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "BlinkerHitFrenzyHeal2");
            }
            if (getBoolEquals("FrenzyHeal3", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "BlinkerHitFrenzyHeal3");
            }
            if (getBoolEquals("FrenzyHeal4", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "BlinkerHitFrenzyHeal4");
            }
        }
        // Healen als alles uit is (bools zorgen dat het heal getal meetbaar blijft.)
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitHeal1")) {
            if (((isUpgradeEnabled(Yesno.No, "BlinkerHitSpeedup1")&&isUpgradeEnabled(Yesno.No, "BlinkerHitSpeedup2"))&&isUpgradeEnabled(Yesno.No, "BlinkerHitSpeedup3"))&&isUpgradeEnabled(Yesno.No, "BlinkerHitSpeedup4")) {
                if (((isUpgradeEnabled(Yesno.Yes, "BlinkerHitFrenzyHeal4")||isUpgradeEnabled(Yesno.Yes, "BlinkerHitFrenzyHeal3"))||isUpgradeEnabled(Yesno.Yes, "BlinkerHitFrenzyHeal2"))||isUpgradeEnabled(Yesno.Yes, "BlinkerHitFrenzyHeal1")) {
                    sequence1();
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerTwirlStacks2")) {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
                enableUpgrade(Yesno.Yes, "BlinkerTwirlStacks2On");
            } else {
                enableUpgrade(Yesno.No, "BlinkerTwirlStacks2On");
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerTwirlStacks")) {
                if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
                    enableUpgrade(Yesno.Yes, "BlinkerTwirlStacksOn");
                } else {
                    enableUpgrade(Yesno.No, "BlinkerTwirlStacksOn");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "blinkertwirling")) {
            if (isUpgradeEnabled(Yesno.Yes, "BlinkerTwirlRange1")) {
                enableUpgrade(Yesno.Yes, "BlinkerTwirlAnimationRangeOn");
            } else {
                enableUpgrade(Yesno.Yes, "BlinkerTwirlAnimationOn");
            }
        } else {
            enableUpgrade(Yesno.No, "BlinkerTwirlAnimationRangeOn");
            enableUpgrade(Yesno.No, "BlinkerTwirlAnimationOn");
        }
        if (isUpgradeEnabled(Yesno.Yes, "BLINKERHITSTUN1")) {
            if (((isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup1")||isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup2"))||isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup3"))||isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
                enableUpgrade(Yesno.No, "BlinkerHitStun1On");
            } else {
                enableUpgrade(Yesno.Yes, "BlinkerHitStun1On");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitSpeedup4")) {
            if (timer(Timeunits.Seconds, 0.2D, Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitRegen2")) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 10.0D, Valueadjust.Add);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "BlinkerHitRegen1")) {
                        adjustCharacterValue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        emitMessageInArea("blinkertargetremove", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 10.0D, 10.0D, Yesno.No, Yesno.No);
        enableUpgrade(Yesno.No, "BlinkerTargetRemoveIt");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        enableUpgrade(Yesno.Yes, "BlinkerHitHealCast1");
        wait(0.3D);
        enableUpgrade(Yesno.No, "BlinkerHitFrenzyHeal2");
        enableUpgrade(Yesno.No, "BlinkerHitFrenzyHeal1");
        enableUpgrade(Yesno.No, "BlinkerHitFrenzyHeal4");
        enableUpgrade(Yesno.No, "BlinkerHitFrenzyHeal3");
        setBool("FrenzyHeal1", Flagtoggle.No);
        setBool("FrenzyHeal2", Flagtoggle.No);
        setBool("FrenzyHeal3", Flagtoggle.No);
        setBool("FrenzyHeal4", Flagtoggle.No);
        enableUpgrade(Yesno.No, "BlinkerHitHealCast1");
    }

}

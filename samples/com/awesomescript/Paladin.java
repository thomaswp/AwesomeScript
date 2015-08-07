
package com.awesomescript;

import java.util.EnumSet;

public class Paladin
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        // Shield geplaatst.
        if (isUpgradeEnabled(Yesno.Yes, "PaladinShieldAI")) {
            enableUpgrade(Yesno.No, "PaladinShieldAI");
            adjustCounter("shield", "1", Valueadjust.Add);
        }
        if (checkCounter("shield", "1", Valuecompare.Equal)) {
            emitMessageInArea("Explode", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 10.0D, 10.0D, Yesno.Yes, Yesno.No);
            adjustCounter("shield", "0", Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "PaladinHitFriendly2")) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes, Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "PaladinFriendliesNear2");
            } else {
                enableUpgrade(Yesno.No, "PaladinFriendliesNear2");
            }
            enableUpgrade(Yesno.No, "PaladinFriendliesNear1");
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "PaladinHitFriendly1")) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.7D, 0.7D, Yesno.Yes, Yesno.Yes)) {
                    enableUpgrade(Yesno.Yes, "PaladinFriendliesNear1");
                } else {
                    enableUpgrade(Yesno.No, "PaladinFriendliesNear1");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "PaladinHitKill1")) {
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
            } else {
                if (onKill(MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
                } else {
                    if (onKill(MissionTarget.CREEP, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                        adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
                    } else {
                        if (onKill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                            adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
                        } else {
                            if (onKill(MissionTarget.TURRET, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
                            } else {
                                if (onKill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "")) {
                                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 50.0D, Valueadjust.Add);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "PaladinHitHeal2")) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.Less, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "PaladinLowHealth1On");
                enableUpgrade(Yesno.Yes, "PaladinLowHealth2On");
            } else {
                enableUpgrade(Yesno.No, "PaladinLowHealth1On");
                enableUpgrade(Yesno.No, "PaladinLowHealth2On");
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "PaladinHitHeal1")) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.Less, Targetself.Self)) {
                    enableUpgrade(Yesno.Yes, "PaladinLowHealth1On");
                } else {
                    enableUpgrade(Yesno.No, "PaladinLowHealth1On");
                }
            }
        }
        if (isButtonDown(Buttons.FACE_LEFT)) {
            enableUpgrade(Yesno.Yes, "PaladinNoTeleport");
        } else {
            enableUpgrade(Yesno.No, "PaladinNoTeleport");
        }
    }

}

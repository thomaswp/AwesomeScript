
package com.awesomescript;

import java.util.EnumSet;

public class Hunter
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (once()) {
            enableUpgrade(Yesno.Yes, "HunterSnipeStopAim");
        }
        if (isUpgradeEnabled(Yesno.Yes, "HunterInCombat")) {
            enableUpgrade(Yesno.No, "HunterInCombat");
            adjustCounter("InCombat", "2", Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "HunterShotBounty")) {
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "1", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 50.0D, Valueadjust.Add);
            }
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "2", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 100.0D, Valueadjust.Add);
            }
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Equal, "3", "")) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 150.0D, Valueadjust.Add);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "HUNTERSPEED")) {
            if (checkCounter("InCombat", "0", Valuecompare.Greater)) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.Yes)) {
                    adjustCounter("InCombat", "-1", Valueadjust.Add);
                }
                if (isUpgradeEnabled(Yesno.Yes, "HunterSprint")) {
                    enableUpgrade(Yesno.No, "HunterSprint");
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "HunterSprint")) {
                    enableUpgrade(Yesno.Yes, "HunterSprint");
                    // show overlay animation when sprint starts
                    playAnimation("SPRINTSTART", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, -100.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            // check walls
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.06D, 0.05D, Yesno.No, Yesno.Yes)) {
                enableUpgrade(Yesno.No, "HunterJetpackOn");
                enableUpgrade(Yesno.Yes, "HunterJump");
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "HunterJump")) {
                    sequence0();
                } else {
                    enableUpgrade(Yesno.Yes, "HunterJetpackOn");
                }
            }
        } else {
            enableUpgrade(Yesno.No, "HunterJump");
            enableUpgrade(Yesno.No, "HunterJetpackOn");
        }
        if (isUpgradeEnabled(Yesno.Yes, "HunterSnipeReady")) {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "Breakstealth");
            } else {
                enableUpgrade(Yesno.No, "Breakstealth");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.3D);
        enableUpgrade(Yesno.No, "HunterJump");
        enableUpgrade(Yesno.Yes, "HunterJetpackOn");
    }

}

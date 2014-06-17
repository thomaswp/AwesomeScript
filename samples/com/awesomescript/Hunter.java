
package com.awesomescript;

import java.util.EnumSet;

public class Hunter
    extends Script
{


    public void onTick() {
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        if (once()) {
            enableupgrade(Yesno.Yes, "HunterSnipeStopAim");
        }
        if (isupgradeenabled(Yesno.Yes, "HunterInCombat")) {
            enableupgrade(Yesno.No, "HunterInCombat");
            adjustcounter("InCombat", "2", Valueadjust.Set);
        }
        if (isupgradeenabled(Yesno.Yes, "HunterShotBounty")) {
            if (onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                adjustcharactervalue(CharactervaluesAdjustable.Gold, 50.0D, Valueadjust.Add);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "HUNTERSPEED")) {
            if (checkcounter("InCombat", "0", Valuecompare.Greater)) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.Yes)) {
                    adjustcounter("InCombat", "-1", Valueadjust.Add);
                }
                if (isupgradeenabled(Yesno.Yes, "HunterSprint")) {
                    enableupgrade(Yesno.No, "HunterSprint");
                }
            } else {
                if (isupgradeenabled(Yesno.No, "HunterSprint")) {
                    enableupgrade(Yesno.Yes, "HunterSprint");
                    // show overlay animation when sprint starts
                    playanimation("SPRINTSTART", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, -100.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
        if (isonground(Yesno.Yes, Targetself.Self)) {
            // check walls
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.06D, 0.05D, Yesno.No, Yesno.Yes)) {
                enableupgrade(Yesno.No, "HunterJetpackOn");
                enableupgrade(Yesno.Yes, "HunterJump");
            } else {
                if (isupgradeenabled(Yesno.Yes, "HunterJump")) {
                    sequence0();
                } else {
                    enableupgrade(Yesno.Yes, "HunterJetpackOn");
                }
            }
        } else {
            enableupgrade(Yesno.No, "HunterJump");
            enableupgrade(Yesno.No, "HunterJetpackOn");
        }
        if (isupgradeenabled(Yesno.Yes, "HunterSnipeReady")) {
            if (checkcharacterflag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "Breakstealth");
            } else {
                enableupgrade(Yesno.No, "Breakstealth");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.3D);
        enableupgrade(Yesno.No, "HunterJump");
        enableupgrade(Yesno.Yes, "HunterJetpackOn");
    }

}

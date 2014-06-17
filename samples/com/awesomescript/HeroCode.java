
package com.awesomescript;

import java.util.EnumSet;

public class HeroCode
    extends Script
{


    public void onTick() {
        if (getboolequals("", Yesno.No)) {
            if (isupgradeenabled(Yesno.Yes, "addHealth1")) {
                enableupgrade(Yesno.Yes, "Health1");
                if (isupgradeenabled(Yesno.Yes, "addHealth2")) {
                    enableupgrade(Yesno.Yes, "Health2");
                    if (isupgradeenabled(Yesno.Yes, "addHealth3")) {
                        enableupgrade(Yesno.Yes, "Health3");
                    }
                }
            }
            if (isupgradeenabled(Yesno.Yes, "addHealthAuto")) {
                sequence0();
            }
            if (once()) {
                adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
        }
        if (isupgradeenabled(Yesno.Yes, "ButterflyBuffReceived")) {
            enableupgrade(Yesno.No, "ButterflyBuffReceived");
            setbool("ButterflyBuffReceived", Flagtoggle.Yes);
            if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffMax2")) {
                enableupgrade(Yesno.Yes, "ButterflyBuffMax2Received");
            }
            if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffMax1")) {
                enableupgrade(Yesno.Yes, "ButterflyBuffMax1Received");
            }
        }
        if (getboolequals("ButterflyBuffReceived", Yesno.Yes)) {
            enableupgrade(Yesno.Yes, "ButterflyBuffOn");
            if (checkclass(Targetself.Self, "Butterfly")) {
            } else {
                if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffAbsorb1")) {
                    enableupgrade(Yesno.Yes, "ButterflyBuffAbsorb1");
                }
                if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffAbsorb2")) {
                    enableupgrade(Yesno.Yes, "ButterflyBuffAbsorb2");
                }
                if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffShield1")) {
                    enableupgrade(Yesno.Yes, "ButterflyBuffShield1");
                }
                if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffShield2")) {
                    enableupgrade(Yesno.Yes, "ButterflyBuffShield2");
                }
            }
            if (hasupgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffSpeed1")) {
                enableupgrade(Yesno.Yes, "ButterflyBuffSpeed1Received");
            }
            sequence1();
        }
        // Context Sensitive Upgrades
        if (getboolequals("", Yesno.No)) {
            if (isonground(Yesno.Yes, Targetself.Self)) {
                if (isupgradeenabled(Yesno.Yes, "InAir")) {
                    enableupgrade(Yesno.No, "InAir");
                }
            } else {
                if (isupgradeenabled(Yesno.No, "InAir")) {
                    enableupgrade(Yesno.Yes, "InAir");
                }
            }
            if (isinnamedarea("JUMPPADS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isupgradeenabled(Yesno.No, "EnableJumppad")) {
                    enableupgrade(Yesno.Yes, "EnableJumppad");
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "EnableJumppad")) {
                    enableupgrade(Yesno.No, "EnableJumppad");
                }
            }
        }
        // Shop indicator
        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, EnumSet.of(Teams.OWN_TEAM), "HealArea", 0.0D, 0.0D, 0.55D, 0.3D, Yesno.No, Yesno.No)) {
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                playanimation("BB_shop_button_active", AnimationLocation.HUD, 0.0D, -0.17D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            }
        }
        // tell everyone I'm freeing creeps
        if (isinnamedarea("FREECREEPS", Ownenemy.OWN_TEAM, Targetself.Self)) {
            emitmessageinarea("ImFreeingCreeps", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
        }
        // Warnings
        if (timepassed(Timeunits.Seconds, 1.0D)) {
            if (isinnamedarea("FREEBOT_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setbool("notification_freebot_teamred", Flagtoggle.Yes);
            }
            if (isinnamedarea("FREEBOT_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setbool("notification_freebot_teamblue", Flagtoggle.Yes);
            }
            if (isinnamedarea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getboolequals("AttackbaseRed_Warning", Yesno.No)) {
                    setbool("notification_attackbase_teamred", Flagtoggle.Yes);
                    setbool("AttackbaseRed_Warning", Flagtoggle.Yes);
                }
            } else {
                setbool("AttackbaseRed_Warning", Flagtoggle.No);
            }
            if (isinnamedarea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getboolequals("AttackbaseBlue_Warning", Yesno.No)) {
                    setbool("notification_attackbase_teamblue", Flagtoggle.Yes);
                    setbool("AttackbaseBlue_Warning", Flagtoggle.Yes);
                }
            } else {
                setbool("AttackbaseBlue_Warning", Flagtoggle.No);
            }
            if (getboolequals("DoingMessage", Yesno.No)) {
                if (getboolequals("DoingMessage", Yesno.No)) {
                    if (getboolequals("notification_freebot_teamred", Yesno.Yes)) {
                        setbool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getboolequals("DoingMessage", Yesno.No)) {
                    if (getboolequals("notification_freebot_teamblue", Yesno.Yes)) {
                        setbool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getboolequals("DoingMessage", Yesno.No)) {
                    if (getboolequals("notification_attackbase_teamred", Yesno.Yes)) {
                        setbool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getboolequals("DoingMessage", Yesno.No)) {
                    if (getboolequals("notification_attackbase_teamblue", Yesno.Yes)) {
                        setbool("DoingMessage", Flagtoggle.Yes);
                    }
                }
            } else {
                if (getboolequals("NotificationsCleared", Yesno.No)) {
                    setbool("notification_freebot_teamred", Flagtoggle.No);
                    setbool("notification_freebot_teamblue", Flagtoggle.No);
                    setbool("notification_attackbase_teamred", Flagtoggle.No);
                    setbool("notification_attackbase_teamblue", Flagtoggle.No);
                }
                sequence2();
            }
        }
        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
            adjustcounter("GoldTimer", "1", Valueadjust.Add);
        }
        if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
            if (isupgradeenabled(Yesno.Yes, "Cooler2")) {
                if (checkcharactervalue(CharactervaluesCheckable.AISkill, 0.95D, Valuecompare.Greater, Targetself.Self)) {
                    adjustcharactervalue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
                }
            }
        }
        // Normal Gold over time
        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
            adjustcharactervalue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
        }
        // Solartree
        if (timer(Timeunits.Seconds, 3.53D, Yesno.No)) {
            if (isupgradeenabled(Yesno.Yes, "Coinregen1")) {
                adjustcharactervalue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
            }
        }
        // Never hold for more than one tick
        if (isupgradeenabled(Yesno.Yes, "Hold")) {
            enableupgrade(Yesno.No, "Hold");
        }
        // combine burning and blind
        if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeMine")) {
            if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeBlind")) {
                if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeMoreAndFlash")) {
                } else {
                    enableupgrade(Yesno.Yes, "CowboyGrenadeMoreAndFlash");
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "ShootPenalty")) {
            sequence3();
        }
        if (isupgradeenabled(Yesno.Yes, "BlazerShootPenalty")) {
            sequence4();
        }
        if (checkgametime(900.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill10")) {
                if (once()) {
                    buyupgrade("HealthKill10");
                }
            }
        }
        if (checkgametime(810.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill9")) {
                if (once()) {
                    buyupgrade("HealthKill9");
                }
            }
        }
        if (checkgametime(720.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill8")) {
                if (once()) {
                    buyupgrade("HealthKill8");
                }
            }
        }
        if (checkgametime(630.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill7")) {
                if (once()) {
                    buyupgrade("HealthKill7");
                }
            }
        }
        if (checkgametime(540.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill6")) {
                if (once()) {
                    buyupgrade("HealthKill6");
                }
            }
        }
        if (checkgametime(450.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill5")) {
                if (once()) {
                    buyupgrade("HealthKill5");
                }
            }
        }
        if (checkgametime(360.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill4")) {
                if (once()) {
                    buyupgrade("HealthKill4");
                }
            }
        }
        if (checkgametime(270.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill3")) {
                if (once()) {
                    buyupgrade("HealthKill3");
                }
            }
        }
        if (checkgametime(180.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill2")) {
                if (once()) {
                    buyupgrade("HealthKill2");
                }
            }
        }
        if (checkgametime(90.0D, Valuecompare.GreaterOrEqual)) {
            if (isupgradeenabled(Yesno.No, "HealthKill1")) {
                if (once()) {
                    buyupgrade("HealthKill1");
                }
            }
        }
        if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            enableupgrade(Yesno.Yes, "TurnPetOff");
        } else {
            enableupgrade(Yesno.No, "TurnPetOff");
        }
        // Killing Spree Counter
        if (getboolequals("", Yesno.No)) {
            if (getboolequals("StarthealthSet", Yesno.No)) {
                adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                adjustcounter("Spree", "0", Valueadjust.Set);
                setbool("StarthealthSet", Flagtoggle.Yes);
            }
            if (onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "KillsDone")) {
                log("KILL!", "KillsDone", "");
                adjustcounter("Spree", "1", Valueadjust.Add);
                if (checkcounter("Spree", "3", Valuecompare.GreaterOrEqual)) {
                    if (isupgradeenabled(Yesno.No, "HasKillingSpree")) {
                        enableupgrade(Yesno.Yes, "HasKillingSpree");
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableupgrade(Yesno.Yes, "Health1");
        wait(120.0D);
        enableupgrade(Yesno.Yes, "Health2");
        wait(120.0D);
        enableupgrade(Yesno.Yes, "Health3");
        wait(120.0D);
        enableupgrade(Yesno.Yes, "Health4");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(4.0D);
        enableupgrade(Yesno.No, "ButterflyBuffSpeed1Received");
        enableupgrade(Yesno.No, "ButterflyBuffAbsorb2");
        enableupgrade(Yesno.No, "ButterflyBuffShield2");
        enableupgrade(Yesno.No, "ButterflyBuffShield1");
        enableupgrade(Yesno.No, "ButterflyBuffSpeed1");
        enableupgrade(Yesno.No, "ButterflyBuffAbsorb1");
        enableupgrade(Yesno.No, "ButterflyBuffOn");
        setbool("ButterflyBuffReceived", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(5.0D);
        setbool("DoingMessage", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.1D);
        enableupgrade(Yesno.No, "ShootPenalty");
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.1D);
        enableupgrade(Yesno.No, "BlazerShootPenalty");
    }

}

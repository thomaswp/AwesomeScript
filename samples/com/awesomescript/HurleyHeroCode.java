
package com.awesomescript;

import java.util.EnumSet;

public class HurleyHeroCode
    extends Script
{


    public void onTick() {
        if (getBoolEquals("", Yesno.No)) {
            if (isUpgradeEnabled(Yesno.Yes, "addHealth1")) {
                enableUpgrade(Yesno.Yes, "Health1");
                if (isUpgradeEnabled(Yesno.Yes, "addHealth2")) {
                    enableUpgrade(Yesno.Yes, "Health2");
                    if (isUpgradeEnabled(Yesno.Yes, "addHealth3")) {
                        enableUpgrade(Yesno.Yes, "Health3");
                    }
                }
            }
            if (isUpgradeEnabled(Yesno.Yes, "addHealthAuto")) {
                sequence0();
            }
            if (once()) {
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "ButterflyBuffReceived")) {
            enableUpgrade(Yesno.No, "ButterflyBuffReceived");
            setBool("ButterflyBuffReceived", Flagtoggle.Yes);
            if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffMax2")) {
                enableUpgrade(Yesno.Yes, "ButterflyBuffMax2Received");
            }
            if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffMax1")) {
                enableUpgrade(Yesno.Yes, "ButterflyBuffMax1Received");
            }
        }
        if (getBoolEquals("ButterflyBuffReceived", Yesno.Yes)) {
            enableUpgrade(Yesno.Yes, "ButterflyBuffOn");
            if (checkClass(Targetself.Self, "Butterfly")) {
            } else {
                if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffAbsorb1")) {
                    enableUpgrade(Yesno.Yes, "ButterflyBuffAbsorb1");
                }
                if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffAbsorb2")) {
                    enableUpgrade(Yesno.Yes, "ButterflyBuffAbsorb2");
                }
                if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffShield1")) {
                    enableUpgrade(Yesno.Yes, "ButterflyBuffShield1");
                }
                if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffShield2")) {
                    enableUpgrade(Yesno.Yes, "ButterflyBuffShield2");
                }
            }
            if (hasUpgrade("Butterfly", Teamswithnumbers.OWN_TEAM, "ButterflyBuffSpeed1")) {
                enableUpgrade(Yesno.Yes, "ButterflyBuffSpeed1Received");
            }
            sequence1();
        }
        // Context Sensitive Upgrades
        if (getBoolEquals("", Yesno.No)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.Yes, "InAir")) {
                    enableUpgrade(Yesno.No, "InAir");
                }
            } else {
                if (isUpgradeEnabled(Yesno.No, "InAir")) {
                    enableUpgrade(Yesno.Yes, "InAir");
                }
            }
            if (isInNamedArea("JUMPPADS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "EnableJumppad")) {
                    enableUpgrade(Yesno.Yes, "EnableJumppad");
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "EnableJumppad")) {
                    enableUpgrade(Yesno.No, "EnableJumppad");
                }
            }
        }
        // tell everyone I'm freeing creeps
        if (isInNamedArea("FREECREEPS", Ownenemy.OWN_TEAM, Targetself.Self)) {
            emitMessageInArea("ImFreeingCreeps", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
        }
        // Warnings
        if (timePassed(Timeunits.Seconds, 1.0D)) {
            if (isInNamedArea("FREEBOT_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setBool("notification_freebot_teamred", Flagtoggle.Yes);
            }
            if (isInNamedArea("FREEBOT_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                setBool("notification_freebot_teamblue", Flagtoggle.Yes);
            }
            if (isInNamedArea("ATTACKBASE_RED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getBoolEquals("AttackbaseRed_Warning", Yesno.No)) {
                    setBool("notification_attackbase_teamred", Flagtoggle.Yes);
                    setBool("AttackbaseRed_Warning", Flagtoggle.Yes);
                }
            } else {
                setBool("AttackbaseRed_Warning", Flagtoggle.No);
            }
            if (isInNamedArea("ATTACKBASE_BLUE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getBoolEquals("AttackbaseBlue_Warning", Yesno.No)) {
                    setBool("notification_attackbase_teamblue", Flagtoggle.Yes);
                    setBool("AttackbaseBlue_Warning", Flagtoggle.Yes);
                }
            } else {
                setBool("AttackbaseBlue_Warning", Flagtoggle.No);
            }
            if (getBoolEquals("DoingMessage", Yesno.No)) {
                if (getBoolEquals("DoingMessage", Yesno.No)) {
                    if (getBoolEquals("notification_freebot_teamred", Yesno.Yes)) {
                        setBool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("DoingMessage", Yesno.No)) {
                    if (getBoolEquals("notification_freebot_teamblue", Yesno.Yes)) {
                        setBool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("DoingMessage", Yesno.No)) {
                    if (getBoolEquals("notification_attackbase_teamred", Yesno.Yes)) {
                        setBool("DoingMessage", Flagtoggle.Yes);
                    }
                }
                if (getBoolEquals("DoingMessage", Yesno.No)) {
                    if (getBoolEquals("notification_attackbase_teamblue", Yesno.Yes)) {
                        setBool("DoingMessage", Flagtoggle.Yes);
                    }
                }
            } else {
                if (getBoolEquals("NotificationsCleared", Yesno.No)) {
                    setBool("notification_freebot_teamred", Flagtoggle.No);
                    setBool("notification_freebot_teamblue", Flagtoggle.No);
                    setBool("notification_attackbase_teamred", Flagtoggle.No);
                    setBool("notification_attackbase_teamblue", Flagtoggle.No);
                }
                sequence2();
            }
        }
        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
            adjustCounter("GoldTimer", "1", Valueadjust.Add);
        }
        if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
            if (isUpgradeEnabled(Yesno.Yes, "Cooler2")) {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    adjustCharacterValue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
                }
            }
        }
        // Normal Gold over time
        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
            adjustCharacterValue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
        }
        // Solartree
        if (timer(Timeunits.Seconds, 3.53D, Yesno.No)) {
            if (isUpgradeEnabled(Yesno.Yes, "Coinregen1")) {
                adjustCharacterValue(CharactervaluesAdjustable.GoldWithoutXp, 1.0D, Valueadjust.Add);
            }
        }
        // Never hold for more than one tick
        if (isUpgradeEnabled(Yesno.Yes, "Hold")) {
            enableUpgrade(Yesno.No, "Hold");
        }
        // combine burning and blind
        if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeMine")) {
            if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeBlind")) {
                if (isUpgradeEnabled(Yesno.Yes, "CowboyGrenadeMoreAndFlash")) {
                } else {
                    enableUpgrade(Yesno.Yes, "CowboyGrenadeMoreAndFlash");
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "ShootPenalty")) {
            sequence3();
        }
        if (isUpgradeEnabled(Yesno.Yes, "BlazerShootPenalty")) {
            sequence4();
        }
        if (checkGameTime(900.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill10")) {
                if (once()) {
                    buyUpgrade("HealthKill10");
                }
            }
        }
        if (checkGameTime(810.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill9")) {
                if (once()) {
                    buyUpgrade("HealthKill9");
                }
            }
        }
        if (checkGameTime(720.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill8")) {
                if (once()) {
                    buyUpgrade("HealthKill8");
                }
            }
        }
        if (checkGameTime(630.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill7")) {
                if (once()) {
                    buyUpgrade("HealthKill7");
                }
            }
        }
        if (checkGameTime(540.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill6")) {
                if (once()) {
                    buyUpgrade("HealthKill6");
                }
            }
        }
        if (checkGameTime(450.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill5")) {
                if (once()) {
                    buyUpgrade("HealthKill5");
                }
            }
        }
        if (checkGameTime(360.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill4")) {
                if (once()) {
                    buyUpgrade("HealthKill4");
                }
            }
        }
        if (checkGameTime(270.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill3")) {
                if (once()) {
                    buyUpgrade("HealthKill3");
                }
            }
        }
        if (checkGameTime(180.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill2")) {
                if (once()) {
                    buyUpgrade("HealthKill2");
                }
            }
        }
        if (checkGameTime(90.0D, Valuecompare.GreaterOrEqual)) {
            if (isUpgradeEnabled(Yesno.No, "HealthKill1")) {
                if (once()) {
                    buyUpgrade("HealthKill1");
                }
            }
        }
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            enableUpgrade(Yesno.Yes, "TurnPetOff");
        } else {
            enableUpgrade(Yesno.No, "TurnPetOff");
        }
        // Killing Spree Counter
        if (getBoolEquals("", Yesno.No)) {
            if (getBoolEquals("StarthealthSet", Yesno.No)) {
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                adjustCounter("Spree", "0", Valueadjust.Set);
                setBool("StarthealthSet", Flagtoggle.Yes);
            }
            if (onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", "", Valuecompare.Greater, "0", "KillsDone")) {
                log("KILL!", "KillsDone", "");
                adjustCounter("Spree", "1", Valueadjust.Add);
                if (checkCounter("Spree", "3", Valuecompare.GreaterOrEqual)) {
                    if (isUpgradeEnabled(Yesno.No, "HasKillingSpree")) {
                        enableUpgrade(Yesno.Yes, "HasKillingSpree");
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.Yes, "Health1");
        wait(120.0D);
        enableUpgrade(Yesno.Yes, "Health2");
        wait(120.0D);
        enableUpgrade(Yesno.Yes, "Health3");
        wait(120.0D);
        enableUpgrade(Yesno.Yes, "Health4");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(4.0D);
        enableUpgrade(Yesno.No, "ButterflyBuffSpeed1Received");
        enableUpgrade(Yesno.No, "ButterflyBuffAbsorb2");
        enableUpgrade(Yesno.No, "ButterflyBuffShield2");
        enableUpgrade(Yesno.No, "ButterflyBuffShield1");
        enableUpgrade(Yesno.No, "ButterflyBuffSpeed1");
        enableUpgrade(Yesno.No, "ButterflyBuffAbsorb1");
        enableUpgrade(Yesno.No, "ButterflyBuffOn");
        setBool("ButterflyBuffReceived", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(5.0D);
        setBool("DoingMessage", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.1D);
        enableUpgrade(Yesno.No, "ShootPenalty");
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.1D);
        enableUpgrade(Yesno.No, "BlazerShootPenalty");
    }

}

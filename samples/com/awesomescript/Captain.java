
package com.awesomescript;

import java.util.EnumSet;

public class Captain
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (receivedmessage("AnkerReturn")) {
            enableupgrade(Yesno.No, "CaptainNoAnker");
            if (isupgradeenabled(Yesno.Yes, "CaptainHitDouble")) {
                enableupgrade(Yesno.Yes, "CaptainDoubleHitReady");
            }
            if (isupgradeenabled(Yesno.Yes, "CaptainDropHealth1")) {
                sequence0();
            }
            // anker return
            playanimation("ANCHOR_RETURN", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
        } else {
            if (isupgradeenabled(Yesno.Yes, "CaptainNoAnker")) {
                sequence1();
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainHitMaxhp1")) {
            if (isupgradeenabled(Yesno.No, "CaptainNoAnker")) {
                enableupgrade(Yesno.Yes, "CaptainExtraMaxhp1");
            } else {
                enableupgrade(Yesno.No, "CaptainExtraMaxhp1");
            }
            if (isinnamedarea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (once()) {
                    sequence2();
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainHitMaxhp2")) {
            if (isupgradeenabled(Yesno.No, "CaptainNoAnker")) {
                enableupgrade(Yesno.Yes, "CaptainExtraMaxhp2");
            } else {
                enableupgrade(Yesno.No, "CaptainExtraMaxhp2");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainDoubleHitDone")) {
            sequence3();
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainDropSpeed1")) {
            if (isupgradeenabled(Yesno.Yes, "CaptainNoAnker")) {
                enableupgrade(Yesno.Yes, "CaptainDropSpeedActive");
            } else {
                enableupgrade(Yesno.No, "CaptainDropSpeedActive");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainHitShield1")&&isupgradeenabled(Yesno.Yes, "CaptainDrop")) {
            enableupgrade(Yesno.Yes, "CaptainDropShieldActive");
        }
        if (isupgradeenabled(Yesno.Yes, "CaptainHitShield1")) {
            if (once()) {
                emitmessageinarea("KILLOLDHOOK", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 4.0D, 4.0D, Yesno.Yes, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableupgrade(Yesno.Yes, "CaptainEnableAnkerHeal");
        wait(0.15D);
        enableupgrade(Yesno.No, "CaptainEnableAnkerHeal");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(10.0D);
        if (doesclassexist(EnumSet.of(Teams.OWN_TEAM), "CreepCaptainChain")) {
        } else {
            enableupgrade(Yesno.No, "CaptainNoAnker");
            if (isupgradeenabled(Yesno.No, "CaptainNoAnker")) {
                // anker return
                playanimation("ANCHOR_RETURN", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.1D);
        adjustcharactervalue(CharactervaluesAdjustable.Health, 300.0D, Valueadjust.Add);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        enableupgrade(Yesno.No, "CaptainDoubleHitReady");
        enableupgrade(Yesno.No, "CaptainDoubleHitDone");
    }

}

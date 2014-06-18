
package com.awesomescript;

import java.util.EnumSet;

public class Captain
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (receivedMessage("AnkerReturn")) {
            enableUpgrade(Yesno.No, "CaptainNoAnker");
            if (isUpgradeEnabled(Yesno.Yes, "CaptainHitDouble")) {
                enableUpgrade(Yesno.Yes, "CaptainDoubleHitReady");
            }
            if (isUpgradeEnabled(Yesno.Yes, "CaptainDropHealth1")) {
                sequence0();
            }
            // anker return
            playAnimation("ANCHOR_RETURN", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                sequence1();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitMaxhp1")) {
            if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                enableUpgrade(Yesno.Yes, "CaptainExtraMaxhp1");
            } else {
                enableUpgrade(Yesno.No, "CaptainExtraMaxhp1");
            }
            if (isInNamedArea("STARTAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (once()) {
                    sequence2();
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitMaxhp2")) {
            if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                enableUpgrade(Yesno.Yes, "CaptainExtraMaxhp2");
            } else {
                enableUpgrade(Yesno.No, "CaptainExtraMaxhp2");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainDoubleHitDone")) {
            sequence3();
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainDropSpeed1")) {
            if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                enableUpgrade(Yesno.Yes, "CaptainDropSpeedActive");
            } else {
                enableUpgrade(Yesno.No, "CaptainDropSpeedActive");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitShield1")&&isUpgradeEnabled(Yesno.Yes, "CaptainDrop")) {
            enableUpgrade(Yesno.Yes, "CaptainDropShieldActive");
        }
        if (isUpgradeEnabled(Yesno.Yes, "CaptainHitShield1")) {
            if (once()) {
                emitMessageInArea("KILLOLDHOOK", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 4.0D, 4.0D, Yesno.Yes, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.Yes, "CaptainEnableAnkerHeal");
        wait(0.15D);
        enableUpgrade(Yesno.No, "CaptainEnableAnkerHeal");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(10.0D);
        if (doesClassExist(EnumSet.of(Teams.OWN_TEAM), "CreepCaptainChain")) {
        } else {
            enableUpgrade(Yesno.No, "CaptainNoAnker");
            if (isUpgradeEnabled(Yesno.No, "CaptainNoAnker")) {
                // anker return
                playAnimation("ANCHOR_RETURN", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.1D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 300.0D, Valueadjust.Add);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        enableUpgrade(Yesno.No, "CaptainDoubleHitReady");
        enableUpgrade(Yesno.No, "CaptainDoubleHitDone");
    }

}

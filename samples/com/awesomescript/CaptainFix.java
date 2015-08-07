
package com.awesomescript;

import java.util.EnumSet;

public class CaptainFix
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HurleyHeroCode");
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
                if (isUpgradeEnabled(Yesno.Yes, "BotLevel4")) {
                    sequence1();
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "BotLevel3")) {
                        sequence2();
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "BotLevel2")) {
                            sequence3();
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "BotLevel1")) {
                                sequence4();
                            } else {
                                sequence5();
                            }
                        }
                    }
                }
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
                    sequence6();
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
            sequence7();
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
        wait(6.0D);
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
        wait(7.0D);
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
    void sequence3() {
        wait(8.0D);
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
    void sequence4() {
        wait(9.0D);
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
    void sequence5() {
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
    void sequence6() {
        wait(0.1D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 3000.0D, Valueadjust.Add);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        enableUpgrade(Yesno.No, "CaptainDoubleHitReady");
        enableUpgrade(Yesno.No, "CaptainDoubleHitDone");
    }

}

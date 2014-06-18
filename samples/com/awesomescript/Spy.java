
package com.awesomescript;

import java.util.EnumSet;

public class Spy
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("HeroCode");
        if (getBoolEquals("initspy", Yesno.No)) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSpyBooth", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 150.0D, 150.0D, Yesno.No)) {
                sequence0();
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "SpyBooth")) {
                    enableUpgrade(Yesno.Yes, "SpyBoothEnable");
                }
                setBool("initspy", Flagtoggle.Yes);
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "SpyBooth")) {
                enableUpgrade(Yesno.Yes, "SpyBoothEnable");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBoothIsPlaced")) {
            enableUpgrade(Yesno.No, "SpyBoothTeleportOn");
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBoothRemoveIt")) {
            sequence1();
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBoothIsPlaced")) {
            if (isUpgradeEnabled(Yesno.Yes, "SpyBoothDamage1")||isUpgradeEnabled(Yesno.Yes, "SpyBoothSilence1")) {
                enableUpgrade(Yesno.Yes, "SpyBoothEnableExplode");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyBoothAPBoostON")) {
            sequence2();
        }
        if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbSpeed2")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbStartOn")) {
            enableUpgrade(Yesno.Yes, "SpyAbsorbSpeed2On");
            enableUpgrade(Yesno.Yes, "SpyAbsorbSpeed1On");
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "SpyAbsorbSpeed1")&&isUpgradeEnabled(Yesno.Yes, "SpyAbsorbStartOn")) {
                enableUpgrade(Yesno.Yes, "SpyAbsorbSpeed1On");
            } else {
                enableUpgrade(Yesno.No, "SpyAbsorbSpeed1On");
                enableUpgrade(Yesno.No, "SpyAbsorbSpeed2On");
            }
        }
        sequence3();
        if (isButtonPressed(Buttons.DPAD_UP)) {
            if (isButtonPressed(Buttons.DPAD_DOWN)) {
                if (isButtonPressed(Buttons.DPAD_LEFT)) {
                    if (isButtonPressed(Buttons.DPAD_RIGHT)) {
                        sequence5();
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.Yes, "SpyBoothTeleportOn");
        setBool("initspy", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        emitMessageInArea("boothremove", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 10.0D, 10.0D, Yesno.No, Yesno.No);
        enableUpgrade(Yesno.No, "SpyBoothRemoveIt");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(5.0D);
        enableUpgrade(Yesno.No, "SpyBoothAPBoostON");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(3.0D);
        if (random("10")) {
            sequence4();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        enableUpgrade(Yesno.Yes, "SpyVisualAltidle");
        wait(4.5D);
        enableUpgrade(Yesno.No, "SpyVisualAltidle");
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        enableUpgrade(Yesno.No, "SpyVisualAltidle");
        wait(1.4D);
        enableUpgrade(Yesno.No, "SpyVisualAltidle");
    }

}

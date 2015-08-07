
package com.awesomescript;


public class Commando
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if (once()) {
            enableUpgrade(Yesno.Yes, "CommandoMachineStart");
        }
        // stimpack
        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimActive")) {
            // damagereduction
            if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                enableUpgrade(Yesno.Yes, "CommandoStimpackDamagereduction1On");
            }
            // speedupgrade
            if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackMovement1")) {
                enableUpgrade(Yesno.Yes, "CommandoStimSpeedOn1");
            }
            // Attackspeedupgrade
            if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                enableUpgrade(Yesno.Yes, "CommandoStimOn2");
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                    enableUpgrade(Yesno.Yes, "CommandoStimOn1");
                } else {
                    enableUpgrade(Yesno.Yes, "CommandoStimOn0");
                }
            }
            playAnimation("STIM", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        } else {
            enableUpgrade(Yesno.No, "CommandoStimNoCollisionOn");
            enableUpgrade(Yesno.No, "CommandoStimpackDamagereduction1On");
            enableUpgrade(Yesno.No, "CommandoStimOn0");
            enableUpgrade(Yesno.No, "CommandoStimOn1");
            enableUpgrade(Yesno.No, "CommandoStimOn2");
            enableUpgrade(Yesno.No, "CommandoStimSpeedOn1");
        }
        if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (once()) {
                sequence0();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikeActivated")) {
                sequence1();
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (getBoolEquals("AirstrikeToggle", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "CommandoAirstrikeToggle");
            } else {
                enableUpgrade(Yesno.No, "CommandoAirstrikeToggle");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.No, "CommandoAirstrikeActivated");
        wait(0.2D);
        setBool("AirstrikeToggle", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("AirstrikeToggle", Flagtoggle.Toggle);
        wait(0.2D);
        enableUpgrade(Yesno.No, "CommandoAirstrikeReset");
        wait(0.8D);
        enableUpgrade(Yesno.No, "CommandoAirstrikeActivated");
    }

}

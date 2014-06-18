
package com.awesomescript;


public class StatusEffects
    extends Script
{


    public void onTick() {
        if (isInNamedArea("WIND", Ownenemy.OWN_TEAM, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "wind");
        } else {
            enableUpgrade(Yesno.No, "wind");
        }
        if (once()) {
            if (isFromTeam(Teamswithnumbers.ONE_TEAM, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "TeamOne");
            }
            if (isFromTeam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "TeamZero");
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CocoonZero")) {
            setBool("WasCocooned", Flagtoggle.Yes);
            if (getBoolEquals("CocoonHalfDealed", Yesno.No)) {
                if (hasUpgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonHalf2")) {
                    sequence0();
                } else {
                    if (hasUpgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonHalf1")) {
                        sequence1();
                    }
                }
                setBool("CocoonHalfDealed", Flagtoggle.Yes);
            }
            if (getBoolEquals("CocoonExplodeChecked", Yesno.No)) {
                if (hasUpgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonExplode1")) {
                    enableUpgrade(Yesno.Yes, "ButterflyCocoonExploding1");
                    if (hasUpgrade("Butterfly", Teamswithnumbers.ZERO_TEAM, "ButterflyCocoonExplode2")) {
                        enableUpgrade(Yesno.Yes, "ButterflyCocoonExploding2");
                    }
                }
                setBool("CocoonExplodeChecked", Flagtoggle.Yes);
            }
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "CocoonOne")) {
                setBool("WasCocooned", Flagtoggle.Yes);
                if (getBoolEquals("CocoonHalfDealed", Yesno.No)) {
                    if (hasUpgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonHalf2")) {
                        sequence2();
                    } else {
                        if (hasUpgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonHalf1")) {
                            sequence3();
                        }
                    }
                    setBool("CocoonHalfDealed", Flagtoggle.Yes);
                }
                if (getBoolEquals("CocoonExplodeChecked", Yesno.No)) {
                    if (hasUpgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonExplode1")) {
                        enableUpgrade(Yesno.Yes, "ButterflyCocoonExploding1");
                        if (hasUpgrade("Butterfly", Teamswithnumbers.ONE_TEAM, "ButterflyCocoonExplode2")) {
                            enableUpgrade(Yesno.Yes, "ButterflyCocoonExploding2");
                        }
                    }
                    setBool("CocoonExplodeChecked", Flagtoggle.Yes);
                }
            } else {
                if (getBoolEquals("WasCocooned", Yesno.Yes)) {
                    setBool("WasCocooned", Flagtoggle.No);
                    enableUpgrade(Yesno.No, "ButterflyCocoonExploding1");
                    enableUpgrade(Yesno.No, "ButterflyCocoonExploding2");
                }
                setBool("CocoonExplodeChecked", Flagtoggle.No);
                setBool("CocoonHalfDealed", Flagtoggle.No);
                setBool("CocoonTotemChecked", Flagtoggle.No);
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "StealthPowerup")) {
            sequence4();
            enableUpgrade(Yesno.Yes, "StealthPowerupActive");
        } else {
            enableUpgrade(Yesno.No, "PowerupEnd");
        }
        if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
            if (isUpgradeEnabled(Yesno.Yes, "StealthPowerupActive")) {
                enableUpgrade(Yesno.No, "StealthPowerupActive");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(1.9D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.8D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(1.9D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.9D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(1.9D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.7D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(1.9D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.85D, Valueadjust.Multiply);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(20.0D);
        if (isUpgradeEnabled(Yesno.Yes, "StealthLeon")) {
        } else {
            enableUpgrade(Yesno.Yes, "PowerupEnd");
        }
        enableUpgrade(Yesno.No, "StealthPowerup");
    }

}

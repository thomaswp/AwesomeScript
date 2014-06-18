
package com.awesomescript;


public class Commando
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        // stimpack
        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimActive")) {
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
            enableUpgrade(Yesno.No, "CommandoStimOn0");
            enableUpgrade(Yesno.No, "CommandoStimOn1");
            enableUpgrade(Yesno.No, "CommandoStimOn2");
            enableUpgrade(Yesno.No, "CommandoStimSpeedOn1");
        }
        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpack")) {
            if (isUpgradeEnabled(Yesno.No, "CommandoSwitchStance")) {
                if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                    if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                        if (checkCharacterValue(CharactervaluesCheckable.Health, 21.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "CommandoBlockStim")) {
                                enableUpgrade(Yesno.Yes, "CommandoBlockStim");
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                                enableUpgrade(Yesno.No, "CommandoBlockStim");
                            }
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.Health, 36.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "CommandoBlockStim")) {
                                enableUpgrade(Yesno.Yes, "CommandoBlockStim");
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                                enableUpgrade(Yesno.No, "CommandoBlockStim");
                            }
                        }
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackAttackspeed1")) {
                        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 11.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isUpgradeEnabled(Yesno.No, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 26.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isUpgradeEnabled(Yesno.No, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 16.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isUpgradeEnabled(Yesno.No, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableUpgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        }
                    }
                }
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "CommandoBlockStim")) {
                    enableUpgrade(Yesno.No, "CommandoBlockStim");
                }
            }
        }
        // stimdurationonkillsupgrade
        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpackReset1")) {
            if (checkCounter("stimkills", "6", Valuecompare.Less)) {
                if ((((onKill(MissionTarget.CREEP, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")||onKill(MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onKill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                    adjustCounter("stimkills", "1", Valueadjust.Add);
                }
            }
        }
        // stimdurationonkillsupgrade
        if (checkCounter("stimkills", "3", Valuecompare.Equal)) {
            enableUpgrade(Yesno.Yes, "CommandoStimKill3");
        } else {
            if (checkCounter("stimkills", "2", Valuecompare.Equal)) {
                enableUpgrade(Yesno.Yes, "CommandoStimKill2");
            } else {
                if (checkCounter("stimkills", "1", Valuecompare.Equal)) {
                    enableUpgrade(Yesno.Yes, "CommandoStimKill1");
                }
            }
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

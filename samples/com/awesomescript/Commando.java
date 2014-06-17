
package com.awesomescript;


public class Commando
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        // stimpack
        if (isupgradeenabled(Yesno.Yes, "CommandoStimActive")) {
            // speedupgrade
            if (isupgradeenabled(Yesno.Yes, "CommandoStimpackMovement1")) {
                enableupgrade(Yesno.Yes, "CommandoStimSpeedOn1");
            }
            // Attackspeedupgrade
            if (isupgradeenabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                enableupgrade(Yesno.Yes, "CommandoStimOn2");
            } else {
                if (isupgradeenabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                    enableupgrade(Yesno.Yes, "CommandoStimOn1");
                } else {
                    enableupgrade(Yesno.Yes, "CommandoStimOn0");
                }
            }
            playanimation("STIM", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No, Teams.OWN_TEAM);
        } else {
            enableupgrade(Yesno.No, "CommandoStimOn0");
            enableupgrade(Yesno.No, "CommandoStimOn1");
            enableupgrade(Yesno.No, "CommandoStimOn2");
            enableupgrade(Yesno.No, "CommandoStimSpeedOn1");
        }
        if (isupgradeenabled(Yesno.Yes, "CommandoStimpack")) {
            if (isupgradeenabled(Yesno.No, "CommandoSwitchStance")) {
                if (isupgradeenabled(Yesno.Yes, "CommandoStimpackAttackspeed2")) {
                    if (isupgradeenabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                        if (checkcharactervalue(CharactervaluesCheckable.Health, 21.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            if (isupgradeenabled(Yesno.No, "CommandoBlockStim")) {
                                enableupgrade(Yesno.Yes, "CommandoBlockStim");
                            }
                        } else {
                            if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                                enableupgrade(Yesno.No, "CommandoBlockStim");
                            }
                        }
                    } else {
                        if (checkcharactervalue(CharactervaluesCheckable.Health, 36.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                            if (isupgradeenabled(Yesno.No, "CommandoBlockStim")) {
                                enableupgrade(Yesno.Yes, "CommandoBlockStim");
                            }
                        } else {
                            if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                                enableupgrade(Yesno.No, "CommandoBlockStim");
                            }
                        }
                    }
                } else {
                    if (isupgradeenabled(Yesno.Yes, "CommandoStimpackAttackspeed1")) {
                        if (isupgradeenabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                            if (checkcharactervalue(CharactervaluesCheckable.Health, 11.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isupgradeenabled(Yesno.No, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        } else {
                            if (checkcharactervalue(CharactervaluesCheckable.Health, 26.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isupgradeenabled(Yesno.No, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        }
                    } else {
                        if (isupgradeenabled(Yesno.Yes, "CommandoStimpackDamagereduction1")) {
                        } else {
                            if (checkcharactervalue(CharactervaluesCheckable.Health, 16.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                if (isupgradeenabled(Yesno.No, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.Yes, "CommandoBlockStim");
                                }
                            } else {
                                if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                                    enableupgrade(Yesno.No, "CommandoBlockStim");
                                }
                            }
                        }
                    }
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "CommandoBlockStim")) {
                    enableupgrade(Yesno.No, "CommandoBlockStim");
                }
            }
        }
        // stimdurationonkillsupgrade
        if (isupgradeenabled(Yesno.Yes, "CommandoStimpackReset1")) {
            if (checkcounter("stimkills", "6", Valuecompare.Less)) {
                if ((((onkill(MissionTarget.CREEP, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")||onkill(MissionTarget.HERO, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onkill(MissionTarget.WORM, Teamswithnumbers.NEUTRAL_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onkill(MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", ""))||onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                    adjustcounter("stimkills", "1", Valueadjust.Add);
                }
            }
        }
        // stimdurationonkillsupgrade
        if (checkcounter("stimkills", "3", Valuecompare.Equal)) {
            enableupgrade(Yesno.Yes, "CommandoStimKill3");
        } else {
            if (checkcounter("stimkills", "2", Valuecompare.Equal)) {
                enableupgrade(Yesno.Yes, "CommandoStimKill2");
            } else {
                if (checkcounter("stimkills", "1", Valuecompare.Equal)) {
                    enableupgrade(Yesno.Yes, "CommandoStimKill1");
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (once()) {
                sequence0();
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (isupgradeenabled(Yesno.Yes, "CommandoAirstrikeActivated")) {
                sequence1();
            }
        }
        if (isupgradeenabled(Yesno.Yes, "CommandoAirstrikeSplit1")) {
            if (getboolequals("AirstrikeToggle", Yesno.Yes)) {
                enableupgrade(Yesno.Yes, "CommandoAirstrikeToggle");
            } else {
                enableupgrade(Yesno.No, "CommandoAirstrikeToggle");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableupgrade(Yesno.No, "CommandoAirstrikeActivated");
        wait(0.2D);
        setbool("AirstrikeToggle", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("AirstrikeToggle", Flagtoggle.Toggle);
        wait(0.2D);
        enableupgrade(Yesno.No, "CommandoAirstrikeReset");
        wait(0.8D);
        enableupgrade(Yesno.No, "CommandoAirstrikeActivated");
    }

}

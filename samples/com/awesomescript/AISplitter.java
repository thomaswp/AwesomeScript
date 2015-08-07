
package com.awesomescript;

import java.util.EnumSet;

public class AISplitter
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        if (getBoolEquals("Init", Yesno.No)) {
            pressButton(Buttons.FACE_BOTTOM, 0.0D);
            if (random("3")) {
                sequence0();
            } else {
                if (random("2")) {
                    pressStick(Directions.BACKWARD, 1.0D);
                } else {
                    pressStick(Directions.FORWARD, 1.0D);
                }
            }
        } else {
            if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                if (random("3")) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, 0.0D, 0.3D, 0.45D, Yesno.No, Yesno.No)) {
                        setBool("DontMove", Flagtoggle.Yes);
                        sequence1();
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.6D, 0.0D, 0.4D, 0.3D, Yesno.Yes, Yesno.No)) {
                            setBool("DontMove", Flagtoggle.Yes);
                            enableUpgrade(Yesno.Yes, "Far");
                            sequence2();
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.5D, 0.5D, 0.6D, Yesno.Yes, Yesno.No)) {
                                setBool("DontMove", Flagtoggle.Yes);
                                pressStick(Directions.UP, 1.0D);
                                sequence3();
                            }
                        }
                    }
                }
            }
        }
        if (timePassed(Timeunits.Seconds, 1.0D)) {
            setBool("Init", Flagtoggle.Yes);
        }
        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.5D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                pressStick(Directions.BACKWARD, 0.0D);
                setBool("DontMove", Flagtoggle.Yes);
                log("Omdraaien voor Vijand", "", "");
            }
        }
        if (getBoolEquals("DoHealing", Yesno.Yes)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.2D, 0.42D, 0.4D, Yesno.No, Yesno.No)) {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    log("Healing: I see enemy", "", "");
                    setBool("DoHealing", Flagtoggle.No);
                    setBool("DontMove", Flagtoggle.No);
                }
            } else {
                log("Healing: I see no enemy", "", "");
                if (timer(Timeunits.Seconds, 0.1D, Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.Health, 60.0D, Valueadjust.Add);
                }
                setBool("DontMove", Flagtoggle.Yes);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES, CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM), "", 0.0D, 0.2D, 1.0D, 0.6D, Yesno.No, Yesno.No)) {
                    log("No Healing: I see enemy", "", "");
                } else {
                    log("No Healing: I see no enemy", "", "");
                    setBool("DoHealing", Flagtoggle.Yes);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "Cocoon")) {
            setBool("EvenSlower", Flagtoggle.No);
            setBool("Slower", Flagtoggle.No);
        } else {
            if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                    if (random("2")) {
                        setBool("Slower", Flagtoggle.Yes);
                        if (random("2")) {
                            setBool("EvenSlower", Flagtoggle.Yes);
                        } else {
                            setBool("EvenSlower", Flagtoggle.No);
                        }
                    } else {
                        setBool("Slower", Flagtoggle.No);
                    }
                }
            }
        }
        if (getBoolEquals("DontMove", Yesno.No)) {
            if (isOnCreepTurner(Yesno.Yes, Forwardbackward.BACKWARD)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.No)) {
                } else {
                    pressStick(Directions.BACKWARD, 0.0D);
                }
            } else {
                pressStick(Directions.FORWARD, 0.1D);
            }
            if (getBoolEquals("Slower", Yesno.Yes)) {
                enableUpgrade(Yesno.Yes, "Slower");
                if (getBoolEquals("EvenSlower", Yesno.Yes)) {
                    enableUpgrade(Yesno.Yes, "EvenSlower");
                } else {
                    enableUpgrade(Yesno.No, "EvenSlower");
                }
            } else {
                enableUpgrade(Yesno.No, "Slower");
                enableUpgrade(Yesno.No, "EvenSlower");
            }
        } else {
            setBool("DontMove", Flagtoggle.No);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("DontMove", Flagtoggle.Yes);
        wait(1.0D);
        setBool("DontMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        setBool("DontMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        setBool("DontMove", Flagtoggle.No);
        enableUpgrade(Yesno.No, "Far");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        wait(0.4D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        setBool("DontMove", Flagtoggle.No);
    }

}

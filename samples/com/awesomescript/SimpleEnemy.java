
package com.awesomescript;

import java.util.EnumSet;

public class SimpleEnemy
    extends Script
{


    public void onTick() {
        if (getBoolEquals("Init", Yesno.No)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "StandStill", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "hold");
            }
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "Running", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                setBool("Running", Flagtoggle.Yes);
            }
            enableUpgrade(Yesno.Yes, "dash");
            enableUpgrade(Yesno.Yes, "Grenade");
            adjustCharacterValue(CharactervaluesAdjustable.Health, 2000.0D, Valueadjust.Add);
            enableUpgrade(Yesno.Yes, "whirlwind");
            enableUpgrade(Yesno.Yes, "Nerf");
            setBool("Init", Flagtoggle.Yes);
        } else {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.No)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 10.0D, Valueadjust.Add);
            }
        }
        if (checkCounter("Waiting", "0", Valuecompare.Equal)) {
            if (getBoolEquals("Running", Yesno.No)) {
                if (hasTarget(Yesno.Yes)) {
                    if (timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                        if (random("2")) {
                            sequence0();
                        } else {
                            sequence1();
                        }
                    }
                    if (getBoolEquals("FoundTarget", Yesno.No)) {
                        emitTargetInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.0D, 0.3D);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        if (getBoolEquals("Melee", Yesno.No)) {
                            if (timer(Timeunits.Seconds, 0.7D, Yesno.No)) {
                                sequence2();
                            }
                            if (isTargetInArea(Yesno.Yes, 0.1D, 0.0D, 0.25D, 0.2D, Yesno.No, Yesno.No)) {
                                if (random("3")) {
                                    sequence3();
                                } else {
                                    if (random("20")) {
                                        sequence4();
                                    }
                                }
                            } else {
                                pressStick(Directions.FORWARD, 0.1D);
                            }
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.04D, -0.01D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                                if (timer(Timeunits.Seconds, 0.35D, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.2D, 0.2D, 0.45D, 0.3D, Yesno.No, Yesno.No)) {
                                if (timer(Timeunits.Seconds, 5.0D, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                            } else {
                                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                            }
                            if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.15D, 0.2D, Yesno.No, Yesno.No)) {
                                if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                                    pressButton(Buttons.FACE_LEFT, 0.0D);
                                }
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.04D, -0.01D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                                pressStick(Directions.FORWARD, 0.1D);
                            }
                        }
                    } else {
                        if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                            if (getBoolEquals("MovingAround", Yesno.No)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            }
                        }
                    }
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        // Find enemy
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    }
                } else {
                    // Find enemy
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.2D, 0.0D, 0.4D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    if (receivedTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                        receiveTarget();
                    }
                    // Enemy behind?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.05D, 0.0D, 0.05D, 0.05D, Yesno.Yes, Yesno.No)) {
                        pressStick(Directions.BACKWARD, 0.1D);
                    } else {
                        if (random("200")) {
                            setBool("DontMove", Flagtoggle.Toggle);
                        }
                        if (getBoolEquals("DontMove", Yesno.No)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, -0.01D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -0.07D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                                    if (random("50")) {
                                        pressStick(Directions.BACKWARD, 0.1D);
                                    } else {
                                        pressStick(Directions.FORWARD, 0.1D);
                                    }
                                } else {
                                    if (random("2")) {
                                        pressStick(Directions.BACKWARD, 0.1D);
                                    } else {
                                        setBool("DontMove", Flagtoggle.Toggle);
                                    }
                                }
                            }
                        } else {
                            if (random("50")) {
                                setBool("DontMove", Flagtoggle.Toggle);
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Less, Targetself.Self)) {
                            // Find enemy
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                        }
                    }
                }
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.1D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                        adjustCounter("Waiting", "1", Valueadjust.Set);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        if (isTargetInArea(Yesno.Yes, 0.12D, 0.0D, 0.25D, 0.2D, Yesno.No, Yesno.No)) {
                            setBool("Running", Flagtoggle.No);
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.04D, -0.01D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                                pressButton(Buttons.FACE_BOTTOM, 0.0D);
                            }
                            pressStick(Directions.FORWARD, 0.1D);
                        }
                    } else {
                        pressStick(Directions.BACKWARD, 0.0D);
                    }
                } else {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 7.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                }
            }
        } else {
            if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                if (checkCounter("Waiting", "0", Valuecompare.Greater)) {
                    adjustCounter("Waiting", "-1", Valueadjust.Add);
                } else {
                    adjustCounter("Waiting", "0", Valueadjust.Set);
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        aimStickAtTarget(0.6D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.5D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(1.0D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressStick(Directions.FORWARD, 1.0D);
        pressButton(Buttons.FACE_TOP, 1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        enableUpgrade(Yesno.Yes, "hold");
        wait(0.2D);
        aimStickAtTarget(0.0D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        enableUpgrade(Yesno.No, "hold");
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        setBool("MovingAround", Flagtoggle.Yes);
        pressStick(Directions.FORWARD, 0.5D);
        pressStick(Directions.FORWARD, 0.7D);
        pressButton(Buttons.FACE_BOTTOM, 0.1D);
        pressStick(Directions.FORWARD, 0.5D);
        setBool("MovingAround", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        setBool("MovingAround", Flagtoggle.Yes);
        pressStick(Directions.BACKWARD, 1.0D);
        setBool("MovingAround", Flagtoggle.No);
    }

}

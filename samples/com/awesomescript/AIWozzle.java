
package com.awesomescript;

import java.util.EnumSet;

public class AIWozzle
    extends Script
{


    public void onTick() {
        if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
        } else {
            if (getBoolEquals("Init", Yesno.No)) {
                selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUp", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("GoUp", Flagtoggle.Yes);
                    // Find enemy
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                }
                if (isInNamedArea("CREEPLEVEL1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    enableUpgrade(Yesno.Yes, "CreepLevel1");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
                if (isInNamedArea("CREEPLEVEL2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    enableUpgrade(Yesno.Yes, "CreepLevel2");
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                }
                log("INIT DONE", "", "");
                setBool("Init", Flagtoggle.Yes);
            } else {
                executeBehaviourTree("StatusEffects");
                if (hasTarget(Yesno.Yes)) {
                    if (getBoolEquals("FoundTarget", Yesno.No)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            emitTargetInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.0D, 0.3D);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.15D, 0.15D, Yesno.No, Yesno.No)||isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            if (timer(Timeunits.Seconds, 0.25D, Yesno.No)) {
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.3D, 0.0D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                                pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                pressStick(Directions.FORWARD, 0.1D);
                            } else {
                                setBool("MoveForward", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            if (getBoolEquals("MovingAround", Yesno.No)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            }
                        }
                    }
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        // Find enemy
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.1D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.2D, Yesno.No, Yesno.No)) {
                        } else {
                            // Find enemy
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        }
                    }
                } else {
                    // Find enemy
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.5D, 0.0D, 0.6D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    // Enemy behind?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.05D, 0.0D, 0.05D, 0.05D, Yesno.Yes, Yesno.No)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            pressStick(Directions.BACKWARD, 0.1D);
                        }
                    } else {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Pyromancer", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.3D, 0.0D, 0.15D, 0.15D, Yesno.No)) {
                            setBool("MoveForward", Flagtoggle.Yes);
                        } else {
                            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Less, Targetself.Self)) {
                            // Find enemy
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            enableUpgrade(Yesno.No, "hold");
                        }
                    }
                }
                if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                        log("I SEE TOWER", "", "");
                        if (isUpgradeEnabled(Yesno.No, "Shielded")) {
                            enableUpgrade(Yesno.Yes, "Shielded");
                            adjustCharacterValue(CharactervaluesAdjustable.Health, 500.0D, Valueadjust.Add);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "Shielded")) {
                            enableUpgrade(Yesno.No, "Shielded");
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 99.0D, Valuecompare.Greater, Targetself.Self)) {
                                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                            }
                        }
                    }
                }
                if (getBoolEquals("MoveForward", Yesno.Yes)) {
                    if (hasTarget(Yesno.Yes)) {
                        setBool("GoForward", Flagtoggle.Yes);
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                        } else {
                            if (getBoolEquals("GoUp", Yesno.Yes)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpJump", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                    if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                                        pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                    }
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpStop", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoDownJump", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                        pressStick(Directions.DOWN, 1.0D);
                                        sequence0();
                                    }
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                    if (getBoolEquals("GoForward", Yesno.Yes)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -0.07D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                            if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                if (random("5")) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                                    } else {
                                        sequence1();
                                    }
                                }
                            }
                            pressStick(Directions.FORWARD, 0.1D);
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -3.5D, 0.02D, 6.9D, Yesno.No, Yesno.No)) {
                                if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                    if (random("5")) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                                        } else {
                                            sequence2();
                                        }
                                    }
                                }
                                pressStick(Directions.FORWARD, 0.1D);
                            }
                        }
                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.05D, 0.01D, 0.05D, 0.02D, Yesno.No, Yesno.No)) {
                                if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.25D);
                                }
                            }
                        }
                        setBool("GoForward", Flagtoggle.No);
                    }
                    setBool("MoveForward", Flagtoggle.No);
                }
            }
        }
        if (timer(Timeunits.Seconds, 10.0D, Yesno.No)) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "PyromancerWozzlesRage")) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Pyromancer", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 50.0D, "", 0.0D, 0.0D, 5.0D, 5.0D, Yesno.No)) {
                enableUpgrade(Yesno.Yes, "WozzleDoubleD");
            } else {
                enableUpgrade(Yesno.No, "WozzleDoubleD");
            }
            log("ik doe het", "", "");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(0.2D);
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
    }

}

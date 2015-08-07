
package com.awesomescript;

import java.util.EnumSet;

public class AIMeleeCreep
    extends Script
{


    public void onTick() {
        if (once()) {
            if (random("4")) {
                enableUpgrade(Yesno.Yes, "DroidSize3");
            } else {
                if (random("3")) {
                    enableUpgrade(Yesno.Yes, "DroidSize2");
                } else {
                    if (random("2")) {
                        enableUpgrade(Yesno.Yes, "DroidSize1");
                    }
                }
            }
        }
        if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
        } else {
            if (getBoolEquals("Init", Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUp", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("GoUp", Flagtoggle.Yes);
                    setBool("gettarget", Flagtoggle.Yes);
                }
                log("INIT DONE", "", "");
                setBool("Init", Flagtoggle.Yes);
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.07D, 0.01D, 0.06D, 0.08D, Yesno.No, Yesno.No)) {
                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                    if (getBoolEquals("FoundTarget", Yesno.No)) {
                        emitTargetInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.0D, 0.3D);
                    }
                    if (isTargetInArea(Yesno.Yes, 0.07D, 0.01D, 0.06D, 0.09D, Yesno.No, Yesno.No)||isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        if (isTargetInArea(Yesno.Yes, 0.07D, 0.01D, 0.06D, 0.09D, Yesno.No, Yesno.No)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpStop", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                setBool("MoveForward", Flagtoggle.No);
                            } else {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.01D, 0.1D, 0.1D, Yesno.Yes, Yesno.No)) {
                                    setBool("MoveForward", Flagtoggle.Yes);
                                } else {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.15D, 0.1D, 0.2D, 0.08D, Yesno.No, Yesno.No)) {
                                        if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                            setBool("MoveForward", Flagtoggle.No);
                                        }
                                    } else {
                                        setBool("MoveForward", Flagtoggle.Yes);
                                    }
                                }
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
                        setBool("gettarget", Flagtoggle.Yes);
                    }
                } else {
                    setBool("gettarget", Flagtoggle.Yes);
                }
                if (getBoolEquals("gettarget", Yesno.Yes)) {
                    removeTarget();
                    sequence0();
                }
                executeBehaviourTree("StatusEffects");
                if (isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                        selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 1.0D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "Shielded")) {
                            enableUpgrade(Yesno.No, "Shielded");
                            if (checkCharacterValue(CharactervaluesCheckable.Health, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 25.0D, Valueadjust.Set);
                            } else {
                                adjustCharacterValue(CharactervaluesAdjustable.Health, -500.0D, Valueadjust.Add);
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
                                    log("Spring!", "", "");
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpStop", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                            }
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoDownJump", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                    pressStick(Directions.DOWN, 1.0D);
                                    sequence4();
                                }
                                setBool("GoForward", Flagtoggle.No);
                            } else {
                                if (getBoolEquals("GoUp", Yesno.Yes)) {
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                    if (getBoolEquals("GoForward", Yesno.Yes)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -0.07D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                            if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                if (random("5")) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                                    } else {
                                        sequence5();
                                    }
                                }
                            }
                            pressStick(Directions.FORWARD, 0.1D);
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -3.5D, 0.02D, 6.9D, Yesno.No, Yesno.No)) {
                                if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.No, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                    if (random("5")) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.1D, Yesno.No, Yesno.No)) {
                                        } else {
                                            sequence6();
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
                                    log("Spring!", "", "");
                                    pressButton(Buttons.FACE_BOTTOM, 0.2D);
                                }
                            }
                        }
                        setBool("GoForward", Flagtoggle.No);
                    }
                    setBool("MoveForward", Flagtoggle.No);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "Cocoon")) {
            if (hasUpgrade("Butterfly", Teamswithnumbers.ENEMY_TEAM, "ButterflyCocoonDroid")) {
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                sequence7();
            }
        }
        executeBehaviourTree("StatusEffects");
        executeBehaviourTree("FN_CreepLevelling");
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        // Find creep/structure in front
        selectTarget(EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.09D, 0.01D, 0.1D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
        if (hasTarget(Yesno.Yes)) {
            setBool("gettarget", Flagtoggle.No);
        } else {
            sequence1();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        // Find creep/structure behind
        selectTarget(EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, -0.09D, 0.01D, 0.1D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
        if (hasTarget(Yesno.Yes)) {
            setBool("gettarget", Flagtoggle.No);
            pressStick(Directions.BACKWARD, 0.1D);
        } else {
            sequence2();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        // Find enemy front
        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, 0.09D, 0.01D, 0.1D, 0.09D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
        if (hasTarget(Yesno.Yes)) {
            setBool("gettarget", Flagtoggle.No);
        } else {
            sequence3();
        }
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        // enemy behind
        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, -0.09D, 0.01D, 0.1D, 0.09D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
        if (hasTarget(Yesno.Yes)) {
            setBool("gettarget", Flagtoggle.No);
            pressStick(Directions.BACKWARD, 0.1D);
        } else {
            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpStop", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("MoveForward", Flagtoggle.No);
                } else {
                    setBool("MoveForward", Flagtoggle.Yes);
                }
            } else {
                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                    pressStick(Directions.BACKWARD, 0.1D);
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        wait(0.2D);
        log("Spring naar beneden!", "", "");
        pressButton(Buttons.FACE_BOTTOM, 0.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        wait(2.0D);
        adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
    }

}

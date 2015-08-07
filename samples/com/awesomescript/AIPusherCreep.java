
package com.awesomescript;

import java.util.EnumSet;

public class AIPusherCreep
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
        } else {
            if (getBoolEquals("Init", Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUp", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("GoUp", Flagtoggle.Yes);
                }
                if (isInNamedArea("Wait", Ownenemy.OWN_TEAM, Targetself.Self)) {
                } else {
                    setBool("Init", Flagtoggle.Yes);
                }
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (getBoolEquals("FoundTarget", Yesno.No)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            emitTargetInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.0D, 0.3D);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 1.0D, 0.0D, 2.0D, 1.0D, Yesno.No, Yesno.No)) {
                        if (isTargetInArea(Yesno.Yes, 0.14D, 0.0D, 0.3D, 0.1D, Yesno.No, Yesno.No)) {
                        } else {
                            setBool("MoveForward", Flagtoggle.Yes);
                        }
                        if (isTargetInArea(Yesno.Yes, 0.15D, 0.0D, 0.5D, 0.2D, Yesno.No, Yesno.No)) {
                            if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    } else {
                        if (getBoolEquals("MovingAround", Yesno.No)) {
                            if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            }
                        }
                        log("Enemy Behind me!", "", "");
                    }
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        // Find enemy
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.1D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.2D, Yesno.No, Yesno.No)) {
                        } else {
                            // Find enemy
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                        }
                    }
                } else {
                    // Find enemy
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.4D, 0.0D, 0.8D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                    if (receivedTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                        receiveTarget();
                    }
                    // Enemy behind?
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", -0.1D, 0.0D, 0.12D, 0.05D, Yesno.Yes, Yesno.No)) {
                        pressStick(Directions.BACKWARD, 0.1D);
                    } else {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            setBool("MoveForward", Flagtoggle.Yes);
                        } else {
                            pressStick(Directions.BACKWARD, 0.1D);
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Less, Targetself.Self)) {
                            // Find enemy
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            enableUpgrade(Yesno.No, "hold");
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
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpSuper", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                                }
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, null, "GoUpStop", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                                } else {
                                    setBool("GoForward", Flagtoggle.Yes);
                                }
                            } else {
                                setBool("GoForward", Flagtoggle.Yes);
                            }
                        }
                    }
                    if (getBoolEquals("GoForward", Yesno.Yes)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -0.07D, 0.02D, 0.02D, Yesno.No, Yesno.No)) {
                            if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                if (random("5")) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.3D, Yesno.No, Yesno.No)) {
                                    } else {
                                        sequence0();
                                    }
                                }
                            }
                            pressStick(Directions.FORWARD, 0.1D);
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, null, "", 0.15D, -3.5D, 0.02D, 6.9D, Yesno.No, Yesno.No)) {
                                if (((isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No)||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.1D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepMelee", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepSuper", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", -0.8D, 0.0D, 1.5D, 0.1D, Yesno.No)) {
                                    if (random("5")) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.3D, Yesno.No, Yesno.No)) {
                                        } else {
                                            sequence1();
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
                if (isInNamedArea("aboveenemyjumppad", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    pressStick(Directions.BACKWARD, 3.1D);
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        enableUpgrade(Yesno.Yes, "CreepMeleeSlower");
        wait(1.0D);
        enableUpgrade(Yesno.No, "CreepMeleeSlower");
    }

}

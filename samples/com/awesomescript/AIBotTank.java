
package com.awesomescript;

import java.util.EnumSet;

public class AIBotTank
    extends Script
{


    public void onTick() {
        if (getboolequals("init", Yesno.No)) {
            setbool("Tank", Flagtoggle.Yes);
        }
        executebehaviourtree("Tank");
        executebehaviourtree("GeneralAI");
        if (checkcounter("state", "6", Valuecompare.Equal)||checkcounter("state", "1", Valuecompare.Equal)) {
            setbool("Exploding", Flagtoggle.No);
        } else {
            if (getboolequals("Exploding", Yesno.Yes)) {
                selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                setbool("MoveTowardsTarget", Flagtoggle.Yes);
            }
            // Bite!
            if (isupgradeenabled(Yesno.Yes, "LifeSteal")) {
                if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.Less, Targetself.Self)) {
                    if (getboolequals("hasBitten", Yesno.No)) {
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.0D, 0.2D, 0.3D, Yesno.No, Yesno.No)) {
                            log("I will bite you!", "", "");
                            selecttarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.1D, 0.0D, 0.2D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            setbool("MoveTowardsTarget", Flagtoggle.Yes);
                            sequence0();
                        }
                    }
                }
            }
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                // Explode!
                if (isupgradeenabled(Yesno.Yes, "suicide")) {
                    if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 70.0D, Valuecompare.Greater, Targetself.Self)) {
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No, Yesno.No)) {
                                sequence1();
                            }
                        } else {
                            if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 90.0D, Valuecompare.Greater, Targetself.Self)) {
                                if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.Greater, 80.0D, "0", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No)) {
                                    sequence2();
                                }
                            }
                        }
                    }
                }
            }
        }
        // Shoot
        if (isskillonbuttonavailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                if (hastarget(Yesno.Yes)) {
                    if (istargetinarea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                        aimstickattarget(0.1D, Yesno.Yes);
                    }
                }
                pressbutton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.1D, Yesno.Yes, Yesno.No)) {
                    pressbutton(Buttons.FACE_LEFT, 0.0D);
                }
            }
        }
        // STATES
        if (getboolequals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkcounter("state", "10", Valuecompare.Equal)) {
                setbool("ForceWaypointMovement", Flagtoggle.Yes);
                // at shop
                if (isatdestwaypoint()) {
                    if (isupgradeenabled(Yesno.No, "Piggybank")) {
                        if (canpayupgrade("Piggybank")) {
                            buyupgrade("Piggybank");
                        }
                    }
                    // Bite
                    if (isupgradeenabled(Yesno.Yes, "LifeSteal")) {
                        if (random("2")) {
                            // skill upgrades
                            if (random("2")) {
                                if (isupgradeenabled(Yesno.Yes, "TankBiteTargets1")) {
                                    if (random("4")) {
                                        if (canpayupgrade("TankBiteSnare")) {
                                            if (isupgradeenabled(Yesno.No, "TankBiteSnare")) {
                                                buyupgrade("TankBiteSnare");
                                            }
                                        }
                                    } else {
                                        if (random("3")) {
                                            if (isupgradeenabled(Yesno.Yes, "TankBiteDamage2")) {
                                                if (canpayupgrade("TankBiteDamage3")) {
                                                    if (isupgradeenabled(Yesno.No, "TankBiteDamage3")) {
                                                        buyupgrade("TankBiteDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("TankBiteDamage2")) {
                                                    if (isupgradeenabled(Yesno.No, "TankBiteDamage2")) {
                                                        buyupgrade("TankBiteDamage2");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("TankBiteTargets1")) {
                                        if (isupgradeenabled(Yesno.No, "TankBiteTargets1")) {
                                            buyupgrade("TankBiteTargets1");
                                        }
                                    }
                                }
                            } else {
                                // Self Explode
                                if (isupgradeenabled(Yesno.Yes, "suicide")) {
                                    if (isupgradeenabled(Yesno.Yes, "TankExplodeDamage1")) {
                                        if (random("4")) {
                                            if (canpayupgrade("TankExplodeDamage2")) {
                                                if (isupgradeenabled(Yesno.No, "TankExplodeDamage2")) {
                                                    buyupgrade("TankExplodeDamage2");
                                                }
                                            }
                                        } else {
                                            if (random("3")) {
                                                if (isupgradeenabled(Yesno.Yes, "TankExplodeHardhat1")) {
                                                    if (canpayupgrade("TankExplodeHardhat2")) {
                                                        if (isupgradeenabled(Yesno.No, "TankExplodeHardhat2")) {
                                                            buyupgrade("TankExplodeHardhat2");
                                                        }
                                                    }
                                                } else {
                                                    if (canpayupgrade("TankExplodeHardhat1")) {
                                                        if (isupgradeenabled(Yesno.No, "TankExplodeHardhat1")) {
                                                            buyupgrade("TankExplodeHardhat1");
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (isupgradeenabled(Yesno.Yes, "TankExplodeSlow1")) {
                                                    if (canpayupgrade("TankExplodeSlow2")) {
                                                        if (isupgradeenabled(Yesno.No, "TankExplodeSlow2")) {
                                                            buyupgrade("TankExplodeSlow2");
                                                        }
                                                    }
                                                } else {
                                                    if (canpayupgrade("TankExplodeSlow1")) {
                                                        if (isupgradeenabled(Yesno.No, "TankExplodeSlow1")) {
                                                            buyupgrade("TankExplodeSlow1");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("TankExplodeDamage1")) {
                                            if (isupgradeenabled(Yesno.No, "TankExplodeDamage1")) {
                                                buyupgrade("TankExplodeDamage1");
                                            }
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("suicide")) {
                                        if (isupgradeenabled(Yesno.No, "suicide")) {
                                            buyupgrade("suicide");
                                        }
                                    }
                                }
                            }
                        } else {
                            // shot & passive & hp upgrades
                            if (random("3")) {
                                if (canpayupgrade("tankspeed")) {
                                    if (isupgradeenabled(Yesno.No, "tankspeed")) {
                                        buyupgrade("tankspeed");
                                    }
                                }
                            } else {
                                // passive or hp
                                if (random("3")) {
                                    if (isupgradeenabled(Yesno.No, "addHealth1")) {
                                        if (canpayupgrade("addHealth1")) {
                                            buyupgrade("addHealth1");
                                        }
                                    } else {
                                        if (isupgradeenabled(Yesno.No, "addHealth2")) {
                                            if (canpayupgrade("addHealth2")) {
                                                buyupgrade("addHealth2");
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.No, "addHealth3")) {
                                                if (canpayupgrade("addHealth3")) {
                                                    buyupgrade("addHealth3");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isupgradeenabled(Yesno.Yes, "TankShotSpeed")) {
                                        // SHOTS
                                        if (random("2")) {
                                            if (isupgradeenabled(Yesno.Yes, "TankShotAOE")) {
                                                if (canpayupgrade("TankShotSpeed2")) {
                                                    if (isupgradeenabled(Yesno.No, "TankShotSpeed2")) {
                                                        buyupgrade("TankShotSpeed2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("TankShotAOE")) {
                                                    buyupgrade("TankShotAOE");
                                                }
                                            }
                                            if (isupgradeenabled(Yesno.Yes, "TankShotHoming")) {
                                                if (canpayupgrade("TankShotSpeed2")) {
                                                    if (isupgradeenabled(Yesno.No, "TankShotSpeed2")) {
                                                        buyupgrade("TankShotSpeed2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("TankShotHoming")) {
                                                    buyupgrade("TankShotHoming");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("TankShotSpeed")) {
                                            if (isupgradeenabled(Yesno.No, "TankShotSpeed")) {
                                                buyupgrade("TankShotSpeed");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canpayupgrade("LifeSteal")) {
                            buyupgrade("LifeSteal");
                        }
                    }
                    // all better now
                    if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Equal, Targetself.Self)) {
                        if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                            if (random("2")) {
                                adjustcounter("lane", "1", Valueadjust.Set);
                            } else {
                                adjustcounter("lane", "2", Valueadjust.Set);
                            }
                        }
                        sequence3();
                    }
                }
            }
        }
        // Move Away From Target
        if (getboolequals("MoveAwayFromTarget", Yesno.Yes)) {
            setbool("ForceWaypointMovement", Flagtoggle.No);
            if (directiontoenemybase(Forwardbackward.BACKWARD)||isinnamedarea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (istargetposition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (istargetposition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                        setbool("jump", Flagtoggle.Yes);
                    }
                }
                setbool("GoForward", Flagtoggle.Yes);
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||istargetposition(Yesno.Yes, Offsetposition.BELOW)) {
                    setbool("jump", Flagtoggle.Yes);
                }
            } else {
                setbool("GoBack", Flagtoggle.Yes);
            }
            setbool("MoveAwayFromTarget", Flagtoggle.No);
        }
        // Move Towards Target
        if (getboolequals("MoveTowardsTarget", Yesno.Yes)) {
            setbool("ForceWaypointMovement", Flagtoggle.No);
            if (istargetposition(Yesno.Yes, Offsetposition.BACK)) {
                setbool("GoBack", Flagtoggle.Yes);
            } else {
                if (istargetposition(Yesno.Yes, Offsetposition.BELOW)) {
                    // greens
                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                        setbool("DownJump", Flagtoggle.Yes);
                    }
                }
                if (istargetposition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (istargetposition(Yesno.Yes, Offsetposition.ABOVE)) {
                        setbool("jump", Flagtoggle.Yes);
                    }
                } else {
                    if (istargetposition(Yesno.Yes, Offsetposition.FRONT)) {
                        setbool("GoForward", Flagtoggle.Yes);
                        if ((isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isnextwaypointposition(Offsetposition.ABOVE)) {
                            setbool("jump", Flagtoggle.Yes);
                        }
                    }
                }
            }
            setbool("MoveTowardsTarget", Flagtoggle.No);
        }
        // Handle Movement
        if (getboolequals("CantMove", Yesno.No)) {
            setbool("HasMoved", Flagtoggle.No);
            if (getboolequals("GoBack", Yesno.Yes)) {
                setbool("GoBack", Flagtoggle.No);
                if ((getboolequals("WaypointMovement", Yesno.No)||isonground(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    pressstick(Directions.BACKWARD, 0.1D);
                    setbool("HasMoved", Flagtoggle.Yes);
                }
            } else {
                if (getboolequals("GoForward", Yesno.Yes)) {
                    pressstick(Directions.FORWARD, 0.1D);
                    setbool("HasMoved", Flagtoggle.Yes);
                    setbool("GoForward", Flagtoggle.No);
                } else {
                    // at regen area
                    if (isinnamedarea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (checkcounter("state", "1", Valuecompare.Equal)||checkcounter("state", "10", Valuecompare.Equal)) {
                            if (directiontoenemybase(Forwardbackward.FORWARD)) {
                                pressstick(Directions.BACKWARD, 0.1D);
                            } else {
                                // check enemies
                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                    if (random("3")) {
                                        setbool("DownJump", Flagtoggle.Yes);
                                    } else {
                                        setbool("jump", Flagtoggle.Yes);
                                    }
                                }
                                // check walls
                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                    setbool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
            if (getboolequals("GoDown", Yesno.Yes)) {
                pressstick(Directions.DOWN, 0.1D);
                setbool("GoDown", Flagtoggle.No);
            } else {
                if (getboolequals("GoUp", Yesno.Yes)) {
                    pressstick(Directions.UP, 0.1D);
                    setbool("GoUp", Flagtoggle.No);
                }
            }
        }
        // JUMPIN
        if (getboolequals("DownJump", Yesno.No)) {
            if (isinnamedarea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getboolequals("jump", Yesno.Yes)) {
                    setbool("jump", Flagtoggle.No);
                    if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                    } else {
                        pressbutton(Buttons.FACE_BOTTOM, 0.1D);
                    }
                }
            }
        } else {
            setbool("DownJump", Flagtoggle.No);
            // downjump
            pressbutton(Buttons.SHOULDER_LEFT, 0.1D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setbool("hasBitten", Flagtoggle.Yes);
        setbool("MoveTowardsTarget", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_RIGHT, 0.1D);
        wait(4.1D);
        setbool("hasBitten", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("Exploding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setbool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        selecttarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.4D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
        setbool("Exploding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setbool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        wait(2.0D);
        // advanceToFrontline (3)
        adjustcounter("setState", "3", Valueadjust.Set);
    }

}

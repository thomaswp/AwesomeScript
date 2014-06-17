
package com.awesomescript;

import java.util.EnumSet;

public class AIBotDasher
    extends Script
{


    public void onTick() {
        if (getboolequals("init", Yesno.No)) {
            setbool("Dasher", Flagtoggle.Yes);
        }
        executebehaviourtree("Dasher");
        executebehaviourtree("GeneralAI");
        if (checkcounter("state", "6", Valuecompare.Equal)||checkcounter("state", "1", Valuecompare.Equal)) {
            setbool("Whirlwinding", Flagtoggle.No);
        } else {
            if (getboolequals("Whirlwinding", Yesno.Yes)) {
                selecttarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.3D, 1.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.3D, 1.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                setbool("MoveTowardsTarget", Flagtoggle.Yes);
            }
            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                if (isskillonbuttonavailable(Buttons.FACE_RIGHT)) {
                    // Dash!
                    if (isupgradeenabled(Yesno.Yes, "Dash")) {
                        if (directiontoenemybase(Forwardbackward.FORWARD)||ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.4D, 0.0D, 0.8D, 0.6D, Yesno.No)) {
                        } else {
                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.8D, 0.1D, Yesno.No, Yesno.No)) {
                            } else {
                                if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                                    if (checkcharactervalue(CharactervaluesCheckable.Health, 50.0D, Valuecompare.Greater, Targetself.Self)) {
                                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                            selecttarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                                            aimstickattarget(0.4D, Yesno.No);
                                            sequence0();
                                        }
                                    }
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, -0.03D, 0.28D, 0.1D, Yesno.No, Yesno.No)) {
                                        sequence1();
                                    }
                                }
                            }
                        }
                    }
                }
                // Whirlwind!
                if (isupgradeenabled(Yesno.Yes, "Whirlwind")) {
                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                        selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                        sequence2();
                    } else {
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                            selecttarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                            sequence3();
                        }
                    }
                }
            }
        }
        // Shoot
        if (isskillonbuttonavailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                if (hastarget(Yesno.Yes)) {
                    if (istargetinarea(Yesno.Yes, 0.15D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                        aimstickattarget(0.1D, Yesno.Yes);
                    }
                }
                // bullet distance +max collision width/2 + a little offset
                pressbutton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
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
                    // DASH
                    if (isupgradeenabled(Yesno.Yes, "dash")) {
                        if (random("2")) {
                            // skill upgrades
                            if (random("2")) {
                                if (random("4")) {
                                    if (isupgradeenabled(Yesno.Yes, "DasherDashDamage1")||isupgradeenabled(Yesno.Yes, "DasherDashCooldownred1")) {
                                        if (isupgradeenabled(Yesno.Yes, "DasherDashCooldownred1")) {
                                            if (canpayupgrade("DasherDashCooldownred2")) {
                                                if (isupgradeenabled(Yesno.No, "DasherDashCooldownred2")) {
                                                    buyupgrade("DasherDashCooldownred2");
                                                }
                                            }
                                        }
                                    } else {
                                        if (random("2")) {
                                            if (canpayupgrade("DasherDashCooldownred1")) {
                                                if (isupgradeenabled(Yesno.No, "DasherDashCooldownred1")) {
                                                    buyupgrade("DasherDashCooldownred1");
                                                }
                                            }
                                        } else {
                                            if (canpayupgrade("DasherDashDamage6")) {
                                                if (isupgradeenabled(Yesno.No, "DasherDashDamage6")) {
                                                    buyupgrade("DasherDashDamage6");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (random("2")) {
                                        if (isupgradeenabled(Yesno.Yes, "DasherDashDamage1")) {
                                            if (isupgradeenabled(Yesno.Yes, "DasherDashDamage2")) {
                                                if (canpayupgrade("DasherDashDamage3")) {
                                                    if (isupgradeenabled(Yesno.No, "DasherDashDamage3")) {
                                                        buyupgrade("DasherDashDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("DasherDashDamage2")) {
                                                    buyupgrade("DasherDashDamage2");
                                                }
                                            }
                                        } else {
                                            if (canpayupgrade("DasherDashDamage1")) {
                                                buyupgrade("DasherDashDamage1");
                                            }
                                        }
                                    } else {
                                        if (isupgradeenabled(Yesno.Yes, "DasherDashStun1")) {
                                            if (canpayupgrade("DasherDashStun2")) {
                                                if (isupgradeenabled(Yesno.No, "DasherDashStun2")) {
                                                    buyupgrade("DasherDashStun2");
                                                }
                                            }
                                        } else {
                                            if (canpayupgrade("DasherDashStun1")) {
                                                buyupgrade("DasherDashStun1");
                                            }
                                        }
                                    }
                                }
                            } else {
                                // WIRLWIND
                                if (isupgradeenabled(Yesno.Yes, "whirlwind")) {
                                    if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindShield")) {
                                        if (random("3")) {
                                            if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindDuration1")||isupgradeenabled(Yesno.Yes, "DasherWhirlwindSpeed1")) {
                                                if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindSpeed1")) {
                                                } else {
                                                    if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindDuration1")) {
                                                        if (canpayupgrade("DasherWhirlwindDuration2")) {
                                                            if (isupgradeenabled(Yesno.No, "DasherWhirlwindDuration2")) {
                                                                buyupgrade("DasherWhirlwindDuration2");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (random("2")) {
                                                    if (canpayupgrade("DasherWhirlwindSpeed1")) {
                                                        if (isupgradeenabled(Yesno.No, "DasherWhirlwindSpeed1")) {
                                                            buyupgrade("DasherWhirlwindSpeed1");
                                                        }
                                                    }
                                                } else {
                                                    if (canpayupgrade("DasherWhirlwindDuration1")) {
                                                        buyupgrade("DasherWhirlwindDuration1");
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.Yes, "DasherWhirlwindDamage1")) {
                                                if (canpayupgrade("DasherWhirlwindDamage2")) {
                                                    if (isupgradeenabled(Yesno.No, "DasherWhirlwindDamage2")) {
                                                        buyupgrade("DasherWhirlwindDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("DasherWhirlwindDamage1")) {
                                                    buyupgrade("DasherWhirlwindDamage1");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("DasherWhirlwindShield")) {
                                            buyupgrade("DasherWhirlwindShield");
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("whirlwind")) {
                                        buyupgrade("whirlwind");
                                    }
                                }
                            }
                        } else {
                            // shot & passive & hp upgrades
                            if (random("3")) {
                                if (isupgradeenabled(Yesno.No, "DasherSpeed")) {
                                    if (canpayupgrade("DasherSpeed")) {
                                        buyupgrade("DasherSpeed");
                                    }
                                }
                            } else {
                                // shots or hp
                                if (random("3")) {
                                    if (isupgradeenabled(Yesno.Yes, "MoreBullets2")) {
                                        if (random("3")) {
                                            if (isupgradeenabled(Yesno.Yes, "DasherShotDamage")) {
                                                if (canpayupgrade("DasherShotDamage2")) {
                                                    if (isupgradeenabled(Yesno.No, "DasherShotDamage2")) {
                                                        buyupgrade("DasherShotDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("DasherShotDamage")) {
                                                    buyupgrade("DasherShotDamage");
                                                }
                                            }
                                        } else {
                                            if (random("2")) {
                                                if (isupgradeenabled(Yesno.Yes, "DasherShotFaster")||isupgradeenabled(Yesno.Yes, "DasherShotPenetrate")) {
                                                    if (isupgradeenabled(Yesno.Yes, "DasherShotFaster")) {
                                                        if (canpayupgrade("DasherShotFaster2")) {
                                                            if (isupgradeenabled(Yesno.No, "DasherShotFaster2")) {
                                                                buyupgrade("DasherShotFaster2");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (random("2")) {
                                                        if (canpayupgrade("DasherShotPenetrate")) {
                                                            buyupgrade("DasherShotPenetrate");
                                                        }
                                                    } else {
                                                        if (canpayupgrade("DasherShotFaster")) {
                                                            buyupgrade("DasherShotFaster");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (isupgradeenabled(Yesno.Yes, "DasherShotMore")) {
                                        } else {
                                            if (canpayupgrade("DasherShotMore")) {
                                                buyupgrade("DasherShotMore");
                                            }
                                        }
                                    }
                                } else {
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
                                }
                            }
                        }
                    } else {
                        if (canpayupgrade("dash")) {
                            buyupgrade("dash");
                        }
                    }
                }
                // use dash to get away
                if (isupgradeenabled(Yesno.Yes, "dash")) {
                    if (timer(Timeunits.Seconds, 0.6D, Yesno.No)) {
                        // enemy in nearby -> dash skill
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.4D, Yesno.Yes, Yesno.No)) {
                            selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            if (istargetposition(Yesno.Yes, Offsetposition.BACK)) {
                                setbool("GoForward", Flagtoggle.Yes);
                            } else {
                                if (istargetposition(Yesno.Yes, Offsetposition.FRONT)) {
                                    setbool("GoBack", Flagtoggle.Yes);
                                }
                            }
                            if (istargetposition(Yesno.Yes, Offsetposition.BELOW)) {
                                setbool("GoUp", Flagtoggle.Yes);
                            } else {
                                if (istargetposition(Yesno.Yes, Offsetposition.ABOVE)) {
                                    setbool("GoDown", Flagtoggle.Yes);
                                }
                            }
                            pressbutton(Buttons.FACE_RIGHT, 0.0D);
                        }
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
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||istargetposition(Yesno.Yes, Offsetposition.BELOW)) {
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
                                    setbool("jump", Flagtoggle.Yes);
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
            if (isinnamedarea("nodoublejump", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getboolequals("jump", Yesno.No)) {
                    if (getboolequals("DownJump", Yesno.No)) {
                        if (isnextwaypointposition(Offsetposition.ABOVE)) {
                            if (isinnamedarea("BOTSTOP", Ownenemy.OWN_TEAM, Targetself.Self)||isinnamedarea("GOUPSTOP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                enableupgrade(Yesno.Yes, "hold");
                            } else {
                                if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                                    enableupgrade(Yesno.Yes, "hold");
                                }
                            }
                        }
                    }
                }
                // JUMPIN
                if (getboolequals("DownJump", Yesno.No)) {
                    if (getboolequals("ReadyToJump", Yesno.No)) {
                        if (isonground(Yesno.Yes, Targetself.Self)) {
                            setbool("ReadyToJump", Flagtoggle.Yes);
                        }
                    } else {
                        if (getboolequals("jump", Yesno.Yes)) {
                            setbool("jump", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                                if (random("2")) {
                                    if (isupgradeenabled(Yesno.Yes, "Dasherspeed")) {
                                        sequence4();
                                    } else {
                                        sequence5();
                                    }
                                } else {
                                    if (isupgradeenabled(Yesno.Yes, "Dasherspeed")) {
                                        sequence6();
                                    } else {
                                        sequence7();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    setbool("DownJump", Flagtoggle.No);
                    if (isinnamedarea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        // downjump
                        pressbutton(Buttons.SHOULDER_LEFT, 0.1D);
                        if (isinarea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)||isonground(Yesno.No, Targetself.Self)) {
                        } else {
                            setbool("ReadyToJump", Flagtoggle.No);
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setbool("CantMove", Flagtoggle.Yes);
        wait(0.04D);
        pressbutton(Buttons.FACE_RIGHT, 0.1D);
        wait(0.2D);
        setbool("CantMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("CantMove", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_RIGHT, 0.1D);
        wait(0.2D);
        setbool("CantMove", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setbool("Whirlwinding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(1.0D);
        setbool("Whirlwinding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        setbool("Whirlwinding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(1.0D);
        setbool("Whirlwinding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        // jump
        pressbutton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        // jump
        pressbutton(Buttons.FACE_BOTTOM, 0.3D);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        // jump
        pressbutton(Buttons.FACE_BOTTOM, 0.6D);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        // jump
        pressbutton(Buttons.FACE_BOTTOM, 0.8D);
    }

}

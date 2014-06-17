
package com.awesomescript;

import java.util.EnumSet;

public class AIBotCowboy
    extends Script
{


    public void onTick() {
        if (getboolequals("init", Yesno.No)) {
            setbool("Cowboy", Flagtoggle.Yes);
        }
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        executebehaviourtree("GeneralAI");
        // Throw Grenade
        if (isskillonbuttonavailable(Buttons.FACE_RIGHT)) {
            if (isupgradeenabled(Yesno.Yes, "Grenade")) {
                // enemy in front -> dynamite skill
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.45D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                    aimstickattarget(0.45D, Yesno.No);
                    // DYNAMITE BABY
                    pressbutton(Buttons.FACE_RIGHT, 0.45D);
                    sequence0();
                } else {
                    // enemy in front -> dynamite skill
                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                        aimstickattarget(0.22D, Yesno.No);
                        // DYNAMITE BABY
                        pressbutton(Buttons.FACE_RIGHT, 0.22D);
                        sequence1();
                    } else {
                        // enemy in front -> dynamite skill
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.13D, 0.0D, 0.07D, 0.1D, Yesno.Yes, Yesno.No)) {
                            // DYNAMITE BABY
                            pressbutton(Buttons.FACE_RIGHT, 0.0D);
                            setbool("DontMove", Flagtoggle.Yes);
                        }
                    }
                }
            }
        }
        // Throw Bull
        if (isupgradeenabled(Yesno.Yes, "Bull")) {
            if (isskillonbuttonavailable(Buttons.FACE_TOP)) {
                // enemy in front -> bull skill
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.35D, 0.0D, 0.65D, 0.1D, Yesno.Yes, Yesno.No)) {
                    if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Less, Targetself.Self)||directiontoenemybase(Forwardbackward.BACKWARD)) {
                        // BULL
                        pressbutton(Buttons.FACE_TOP, 0.0D);
                        setbool("DontMove", Flagtoggle.Yes);
                    }
                    if (checkcounter("state", "8", Valuecompare.Equal)) {
                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.4D, 0.0D, 0.8D, 0.1D, Yesno.Yes, Yesno.No)) {
                            // BULL
                            pressbutton(Buttons.FACE_TOP, 0.0D);
                            setbool("DontMove", Flagtoggle.Yes);
                        }
                    }
                }
            }
        }
        // STATES
        if (getboolequals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkcounter("state", "10", Valuecompare.Equal)) {
                setbool("ForceWaypointMovement", Flagtoggle.Yes);
                if (isinnamedarea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (isupgradeenabled(Yesno.No, "Piggybank")) {
                        if (canpayupgrade("Piggybank")) {
                            buyupgrade("Piggybank");
                        }
                    }
                    if (isupgradeenabled(Yesno.Yes, "Grenade")) {
                        if (random("4")) {
                            // shot & passive & hp upgrades
                            if (random("4")) {
                                if (canpayupgrade("CowboySpeed")) {
                                    if (isupgradeenabled(Yesno.No, "CowboySpeed")) {
                                        buyupgrade("CowboySpeed");
                                    }
                                }
                            } else {
                                // passive or hp
                                if (random("4")) {
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
                                    if (random("2")||isupgradeenabled(Yesno.Yes, "Bull")) {
                                        if (random("2")) {
                                            if (canpayupgrade("CowboyShotDamage")) {
                                                if (isupgradeenabled(Yesno.No, "CowboyShotDamage")) {
                                                    buyupgrade("CowboyShotDamage");
                                                }
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyShotAttackspeed")) {
                                                if (canpayupgrade("CowboyShotAttackspeed2")) {
                                                    if (isupgradeenabled(Yesno.No, "CowboyShotAttackspeed2")) {
                                                        buyupgrade("CowboyShotAttackspeed2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("CowboyShotAttackspeed")) {
                                                    if (isupgradeenabled(Yesno.No, "CowboyShotAttackspeed")) {
                                                        buyupgrade("CowboyShotAttackspeed");
                                                    }
                                                }
                                            }
                                        }
                                        if (isupgradeenabled(Yesno.Yes, "CowboyShotDamage")) {
                                            if (canpayupgrade("CowboyShotDamage2")) {
                                                if (isupgradeenabled(Yesno.No, "CowboyShotDamage2")) {
                                                    buyupgrade("CowboyShotDamage2");
                                                }
                                            }
                                        } else {
                                            if (canpayupgrade("CowboyShotDamage")) {
                                                if (isupgradeenabled(Yesno.No, "CowboyShotDamage")) {
                                                    buyupgrade("CowboyShotDamage");
                                                }
                                            }
                                        }
                                        if (doesclassexist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter")) {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyShotHoming")) {
                                            } else {
                                                if (canpayupgrade("CowboyShotHoming")) {
                                                    buyupgrade("CowboyShotHoming");
                                                }
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyShotDamage3")) {
                                            } else {
                                                if (canpayupgrade("CowboyShotDamage3")) {
                                                    buyupgrade("CowboyShotDamage3");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("Bull")) {
                                            buyupgrade("Bull");
                                        }
                                    }
                                }
                            }
                        } else {
                            // skill upgrades
                            if (random("4")) {
                                // BULL
                                if (isupgradeenabled(Yesno.Yes, "Bull")) {
                                    if (random("5")) {
                                        if (canpayupgrade("CowboyBullBigger")) {
                                            if (isupgradeenabled(Yesno.No, "CowboyBullBigger")) {
                                                buyupgrade("CowboyBullBigger");
                                            }
                                        }
                                    } else {
                                        if (random("4")) {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyBullCooldown")) {
                                            } else {
                                                if (canpayupgrade("CowboyBullCooldown")) {
                                                    buyupgrade("CowboyBullCooldown");
                                                }
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyBullDamage")) {
                                                if (canpayupgrade("CowboyBullDamage2")) {
                                                    if (isupgradeenabled(Yesno.No, "CowboyBullDamage2")) {
                                                        buyupgrade("CowboyBullDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("CowboyBullDamage")) {
                                                    buyupgrade("CowboyBullDamage");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("Bull")) {
                                        buyupgrade("Bull");
                                    }
                                }
                            } else {
                                // GRENADE
                                if (isupgradeenabled(Yesno.Yes, "Grenade")) {
                                    if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeMore")) {
                                        if (random("3")) {
                                            if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeExplosion1")) {
                                                if (canpayupgrade("CowboyGrenadeExplosion2")) {
                                                    if (isupgradeenabled(Yesno.No, "CowboyGrenadeExplosion2")) {
                                                        buyupgrade("CowboyGrenadeExplosion2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("CowboyGrenadeExplosion1")) {
                                                    buyupgrade("CowboyGrenadeExplosion1");
                                                }
                                            }
                                        } else {
                                            if (isupgradeenabled(Yesno.No, "CowboyGrenadeDot1")) {
                                                if (canpayupgrade("CowboyGrenadeDot2")) {
                                                    if (isupgradeenabled(Yesno.Yes, "CowboyGrenadeDot2")) {
                                                        buyupgrade("CowboyGrenadeDot2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("CowboyGrenadeDot1")) {
                                                    buyupgrade("CowboyGrenadeDot1");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("CowboyGrenadeMore")) {
                                            buyupgrade("CowboyGrenadeMore");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canpayupgrade("Grenade")) {
                            buyupgrade("Grenade");
                        }
                    }
                }
            }
        }
        if (isskillonbuttonavailable(Buttons.FACE_LEFT)) {
            // enemy in front -> always shoot
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                if (hastarget(Yesno.Yes)) {
                    if (istargetinarea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                        aimstickattarget(0.1D, Yesno.Yes);
                    }
                }
                // bullet distance +max collision width/2 + a little offset
                pressbutton(Buttons.FACE_LEFT, 0.0D);
            } else {
                // enemy in front -> always shoot
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.4D, 0.2D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressbutton(Buttons.FACE_LEFT, 0.0D);
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
                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.02D, 0.01D, 0.04D, Yesno.Yes, Yesno.No)) {
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
                if (getboolequals("DoingDownJump", Yesno.No)) {
                    // JUMPIN
                    if (getboolequals("DownJump", Yesno.No)) {
                        if (getboolequals("jump", Yesno.Yes)) {
                            setbool("jump", Flagtoggle.No);
                            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                            } else {
                                pressbutton(Buttons.FACE_BOTTOM, 0.1D);
                            }
                        }
                    } else {
                        setbool("DownJump", Flagtoggle.No);
                        if (isinnamedarea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            // downjump
                            pressbutton(Buttons.SHOULDER_LEFT, 0.1D);
                        }
                    }
                }
            }
            if (getboolequals("DontMove", Yesno.No)) {
                setbool("HasMoved", Flagtoggle.No);
                if (getboolequals("GoBack", Yesno.Yes)) {
                    setbool("GoBack", Flagtoggle.No);
                    if ((getboolequals("WaypointMovement", Yesno.No)||isonground(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
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
                                    // check walls
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setbool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setbool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                        setbool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                setbool("DontMove", Flagtoggle.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setbool("DontMove", Flagtoggle.Yes);
        setbool("DontMove", Flagtoggle.Yes);
        setbool("DontMove", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("DontMove", Flagtoggle.Yes);
        setbool("DontMove", Flagtoggle.Yes);
    }

}

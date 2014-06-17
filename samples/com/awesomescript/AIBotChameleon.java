
package com.awesomescript;

import java.util.EnumSet;

public class AIBotChameleon
    extends Script
{


    public void onTick() {
        if (getboolequals("init", Yesno.No)) {
            setbool("Chameleon", Flagtoggle.Yes);
        }
        executebehaviourtree("Chameleon");
        executebehaviourtree("GeneralAI");
        if ((istargettype(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))||getboolequals("InStealth", Yesno.No))||checkcounter("state", "4", Valuecompare.Equal)) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.Greater, Targetself.Self)||isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.14D, 0.1D, Yesno.Yes, Yesno.No)) {
                // enemy in front -> always shoot
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.14D, 0.1D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressbutton(Buttons.FACE_LEFT, 0.0D);
                    setbool("BreakStealth", Flagtoggle.Yes);
                } else {
                    if (istargettype(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        if (isskillonbuttonavailable(Buttons.FACE_RIGHT)) {
                            if (isupgradeenabled(Yesno.Yes, "ChameleonTongueRange")) {
                                if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    if (isupgradeenabled(Yesno.Yes, "ChameleonTongue")) {
                                        aimstickattarget(0.2D, Yesno.No);
                                        pressbutton(Buttons.FACE_RIGHT, 0.0D);
                                        setbool("BreakStealth", Flagtoggle.Yes);
                                    }
                                }
                            } else {
                                if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.No)) {
                                    if (isupgradeenabled(Yesno.Yes, "ChameleonTongue")) {
                                        aimstickattarget(0.2D, Yesno.No);
                                        pressbutton(Buttons.FACE_RIGHT, 0.0D);
                                        setbool("BreakStealth", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Stealth
        if (getboolequals("InStealth", Yesno.Yes)) {
            if (getboolequals("BreakStealth", Yesno.Yes)) {
                log("Come Out Of Stealth", "", "");
                setbool("InStealth", Flagtoggle.No);
                setbool("BreakStealth", Flagtoggle.No);
            }
        } else {
            if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                // enemy in front -> always shoot
                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.07D, 0.0D, 0.18D, 0.06D, Yesno.Yes, Yesno.No)) {
                    // bullet distance +max collision width/2 + a little offset
                    pressbutton(Buttons.FACE_LEFT, 0.0D);
                }
            }
            if (isupgradeenabled(Yesno.Yes, "stealth")) {
                if (checkcounter("StealthInTime", "8", Valuecompare.Greater)) {
                    if (getboolequals("GoStealth", Yesno.Yes)) {
                        log("Go In Stealth", "", "");
                        setbool("GoStealth", Flagtoggle.No);
                        setbool("InStealth", Flagtoggle.Yes);
                        adjustcounter("StealthInTime", "0", Valueadjust.Set);
                        pressbutton(Buttons.FACE_TOP, 0.0D);
                    }
                } else {
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        adjustcounter("StealthInTime", "1", Valueadjust.Add);
                    }
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
                    if (isupgradeenabled(Yesno.Yes, "ChameleonHitCrit")) {
                        if (random("2")||checkcounter("SupportBuild", "2", Valuecompare.Greater)) {
                            if (random("2")||checkcounter("SupportBuild", "0", Valuecompare.Greater)) {
                                // stealth
                                if (isupgradeenabled(Yesno.Yes, "stealth")) {
                                    if (isupgradeenabled(Yesno.Yes, "ChameleonStealthCloneWalk")) {
                                        if (isupgradeenabled(Yesno.Yes, "ChameleonStealthCloneAttack")) {
                                            if (isupgradeenabled(Yesno.Yes, "ChameleonStealthCloneExplode")) {
                                                if (isupgradeenabled(Yesno.Yes, "ChameleonStealthCloneExplode2")) {
                                                } else {
                                                    if (canpayupgrade("ChameleonStealthCloneExplode2")) {
                                                        buyupgrade("ChameleonStealthCloneExplode2");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("ChameleonStealthCloneExplode")) {
                                                    buyupgrade("ChameleonStealthCloneExplode");
                                                }
                                            }
                                        } else {
                                            if (canpayupgrade("ChameleonStealthCloneAttack")) {
                                                buyupgrade("ChameleonStealthCloneAttack");
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("ChameleonStealthCloneWalk")) {
                                            buyupgrade("ChameleonStealthCloneWalk");
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("stealth")) {
                                        buyupgrade("stealth");
                                    }
                                }
                            } else {
                                // Tongue
                                if (isupgradeenabled(Yesno.Yes, "ChameleonTongue")) {
                                    if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage1")) {
                                        if (random("2")) {
                                            if (isupgradeenabled(Yesno.Yes, "ChameleonTongueDamage2")) {
                                                if (canpayupgrade("ChameleonTongueDamage3")) {
                                                    if (isupgradeenabled(Yesno.No, "ChameleonTongueDamage3")) {
                                                        buyupgrade("ChameleonTongueDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("ChameleonTongueDamage2")) {
                                                    buyupgrade("ChameleonTongueDamage2");
                                                }
                                            }
                                            if (canpayupgrade("ChameleonTongueDamage4")) {
                                                if (isupgradeenabled(Yesno.No, "ChameleonTongueDamage4")) {
                                                    buyupgrade("ChameleonTongueDamage4");
                                                }
                                            } else {
                                                if (isupgradeenabled(Yesno.Yes, "CHAMELEONTONGUERANGE1")) {
                                                } else {
                                                    if (canpayupgrade("ChameleonTongueRange1")) {
                                                        buyupgrade("ChameleonTongueRange1");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("ChameleonTongueDamage1")) {
                                            buyupgrade("ChameleonTongueDamage1");
                                        }
                                    }
                                } else {
                                    if (canpayupgrade("ChameleonTongue")) {
                                        buyupgrade("ChameleonTongue");
                                    }
                                }
                            }
                        } else {
                            if (checkcounter("SupportBuild", "0", Valuecompare.Greater)||random("2")) {
                                if (random("3")||checkcounter("SupportBuild", "0", Valuecompare.LessOrEqual)) {
                                    if (isupgradeenabled(Yesno.Yes, "ChameleonHitDamage1")) {
                                        // SHOTS
                                        if (random("4")) {
                                            if (isupgradeenabled(Yesno.Yes, "ChameleonHitDamage2")) {
                                                if (canpayupgrade("ChameleonHitDamage3")) {
                                                    if (isupgradeenabled(Yesno.No, "ChameleonHitDamage3")) {
                                                        buyupgrade("ChameleonHitDamage3");
                                                    }
                                                }
                                            } else {
                                                if (canpayupgrade("ChameleonHitDamage2")) {
                                                    buyupgrade("ChameleonHitDamage2");
                                                }
                                            }
                                        } else {
                                            if (random("3")) {
                                                if (isupgradeenabled(Yesno.Yes, "ChameleonHitAttackspeed1")) {
                                                    if (canpayupgrade("ChameleonHitAttackspeed2")) {
                                                        if (isupgradeenabled(Yesno.No, "ChameleonHitAttackspeed2")) {
                                                            buyupgrade("ChameleonHitAttackspeed2");
                                                        }
                                                    }
                                                } else {
                                                    if (canpayupgrade("ChameleonHitAttackspeed1")) {
                                                        buyupgrade("ChameleonHitAttackspeed1");
                                                    }
                                                }
                                            } else {
                                                if (isupgradeenabled(Yesno.Yes, "CHAMELEONHITCRIT2")) {
                                                } else {
                                                    if (canpayupgrade("CHAMELEONHITCRIT2")) {
                                                        buyupgrade("CHAMELEONHITCRIT2");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (canpayupgrade("ChameleonHitDamage1")) {
                                            buyupgrade("ChameleonHitDamage1");
                                        }
                                    }
                                } else {
                                    if (isupgradeenabled(Yesno.No, "addHealth1")) {
                                        if (canpayupgrade("addHealth1")) {
                                            buyupgrade("addHealth1");
                                            adjustcounter("SupportBuild", "-2", Valueadjust.Add);
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
                            } else {
                                // PASSIVE
                                if (random("1")) {
                                    if (canpayupgrade("ChameleonSpeed")) {
                                        if (isupgradeenabled(Yesno.No, "ChameleonSpeed")) {
                                            buyupgrade("ChameleonSpeed");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (canpayupgrade("ChameleonHitCrit")) {
                            buyupgrade("ChameleonHitCrit");
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
                            }
                        }
                    }
                }
                if (getboolequals("jump", Yesno.Yes)) {
                    setbool("jump", Flagtoggle.No);
                    if (isonground(Yesno.Yes, Targetself.Self)) {
                        // jump
                        pressbutton(Buttons.FACE_BOTTOM, 0.3D);
                    }
                }
                // JUMPIN
                if (getboolequals("DownJump", Yesno.No)) {
                } else {
                    setbool("DownJump", Flagtoggle.No);
                    if (isinnamedarea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        // downjump
                        pressbutton(Buttons.SHOULDER_LEFT, 0.1D);
                    }
                }
            }
            if (getboolequals("DontMove", Yesno.No)) {
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
                                    // check walls
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.04D, 0.02D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setbool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setbool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.12D, 0.02D, Yesno.No, Yesno.No)) {
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

}

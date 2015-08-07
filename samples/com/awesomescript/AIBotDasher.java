
package com.awesomescript;

import java.util.EnumSet;

public class AIBotDasher
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            // Froggy OP (by gmfreaky/Robin)
            setBool("Dasher", Flagtoggle.Yes);
        }
        executeBehaviourTree("BotSkill");
        executeBehaviourTree("Check205");
        if (once()) {
            if (checkGameTime(30.0D, Valuecompare.Less)) {
                adjustCharacterValue(CharactervaluesAdjustable.Gold, 40.0D, Valueadjust.Add);
                // (a few more solar to compensate for the bot's solar drop)
                log("*APPLY HAX*", "", "");
            }
            // set to yes debug
            setBool("nopushfix", Flagtoggle.No);
        }
        executeBehaviourTree("Dasher");
        // SuperAI by Veanko
        executeBehaviourTree("SuperAI_Dasher");
        executeBehaviourTree("DasherSpecialTargets");
        if (checkCounter("state", "10", Valuecompare.Equal)) {
            setBool("retreating", Flagtoggle.Yes);
        } else {
            setBool("retreating", Flagtoggle.No);
        }
        // shoot more often on higher difficulties
        sequence0();
        // Shoot
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (getBoolEquals("doShooting", Yesno.Yes)) {
                if (getBoolEquals("retreating", Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "DasherShotRange")&&checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.84D, 0.84D, Yesno.Yes, Yesno.No)) {
                            sequence1();
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.21D, 0.0D, 0.42D, 0.1D, Yesno.No)) {
                                pressButton(Buttons.FACE_LEFT, 0.2D);
                            }
                        }
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.48D, 0.48D, Yesno.Yes, Yesno.No)) {
                            sequence2();
                        } else {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.12D, 0.0D, 0.24D, 0.1D, Yesno.No)) {
                                pressButton(Buttons.FACE_LEFT, 0.2D);
                            }
                        }
                    }
                }
            }
        }
        // 40% or higher, listen to pings
        if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
            // listen to pings
            sequence3();
        }
        // Triangle dash (dash + tornado)
        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
            if (getBoolEquals("retreating", Yesno.No)) {
                if (getBoolEquals("PrepareDash", Yesno.No)) {
                    adjustCounter("DashPrepareTimer", "0", Valueadjust.Set);
                    // we are not dashing, add timer
                    adjustCounter("TimeSinceLastDash", "1", Valueadjust.Add);
                    sequence4();
                }
            }
            if (getBoolEquals("PrepareDash", Yesno.Yes)) {
                adjustCounter("DashPrepareTimer", "1", Valueadjust.Add);
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.Greater, Targetself.Self)||checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                    if (getBoolEquals("retreating", Yesno.No)) {
                        executeBehaviourTree("DasherCheckTriangleDash");
                    }
                }
            }
        }
        adjustCounter("TryTornado", "-1", Valueadjust.Add);
        setBool("tornadoDanger", Flagtoggle.No);
        if (getBoolEquals("turretNear", Yesno.Yes)) {
            if (getBoolEquals("lowTargetNear", Yesno.No)) {
                // dumb bots tornado at bad moments
                if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                    setBool("tornadoDanger", Flagtoggle.Yes);
                }
            }
        }
        // Tornado skill
        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
            if (getBoolEquals("tornadoDanger", Yesno.No)) {
                if (getBoolEquals("retreating", Yesno.No)) {
                    setBool("doTornado", Flagtoggle.No);
                    // check for enemies to tornado
                    if (isUpgradeEnabled(Yesno.Yes, "DASHERWHIRLWINDSPEED2")) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.5D, Yesno.No, Yesno.No)) {
                            setBool("doTornado", Flagtoggle.Yes);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "DASHERWHIRLWINDSPEED1")) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.25D, 0.25D, Yesno.No, Yesno.No)) {
                                setBool("doTornado", Flagtoggle.Yes);
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.15D, 0.25D, Yesno.No, Yesno.No)) {
                                setBool("doTornado", Flagtoggle.Yes);
                            }
                        }
                    }
                    // the dumber we are, the less chance of tornadoing
                    if (getBoolEquals("doTornado", Yesno.Yes)) {
                        if (checkCounter("botSkill", "0", Valuecompare.Equal)) {
                            if (random("2")) {
                                setBool("doTornado", Flagtoggle.No);
                            }
                        }
                        if (checkCounter("botSkill", "1", Valuecompare.Equal)) {
                            if (random("6")) {
                                setBool("doTornado", Flagtoggle.No);
                            }
                        }
                        if (checkCounter("botSkill", "2", Valuecompare.Equal)) {
                            if (random("12")) {
                                setBool("doTornado", Flagtoggle.No);
                            }
                        }
                    }
                    if (getBoolEquals("doTornado", Yesno.Yes)) {
                        setBool("forceTornado", Flagtoggle.No);
                        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                setBool("forceTornado", Flagtoggle.Yes);
                            }
                        }
                        // if we cannot dash+tornado, we just tornado
                        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                        } else {
                            setBool("forceTornado", Flagtoggle.Yes);
                        }
                        if (checkCounter("TryTornado", "0", Valuecompare.Greater)||getBoolEquals("forceTornado", Yesno.Yes)) {
                            sequence5();
                            log("do the tornado!", "", "");
                        }
                    }
                }
            }
        }
        // maximum smartness, try to get insta-kills on dashes
        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
            // dashing low targets
            sequence6();
        }
        // retreating skills
        if (getBoolEquals("retreating", Yesno.Yes)) {
            // if there is danger near
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                if (checkCounter("botSkill", "1", Valuecompare.GreaterOrEqual)) {
                    // jump 1 in 20 chance (every 2 seconds on avg)
                    if (random("20")) {
                        // short jump
                        pressButton(Buttons.FACE_BOTTOM, 0.15D);
                    }
                }
                if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                    // can we dash away?
                    if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                        sequence7();
                    } else {
                        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
                            // if we have double speed on 'nado, we can use that as escape
                            if (isUpgradeEnabled(Yesno.Yes, "DASHERWHIRLWINDSPEED2")) {
                                // we can tornado
                                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                    pressButton(Buttons.FACE_TOP, 0.5D);
                                }
                            }
                        }
                    }
                }
            }
        }
        // STATES
        if (getBoolEquals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                // at shop
                if (isAtDestWaypoint()) {
                    if (checkCounter("botSkill", "0", Valuecompare.Equal)) {
                        // very stupid bots don't shop for 5 mins = 300 seconds
                        if (checkGameTime(300.0D, Valuecompare.Greater)) {
                            executeBehaviourTree("DasherShop");
                        }
                    } else {
                        if (checkCounter("botSkill", "1", Valuecompare.Equal)) {
                            // stupid bots don't shop for 3 minutes
                            if (checkGameTime(180.0D, Valuecompare.Greater)) {
                                executeBehaviourTree("DasherShop");
                            }
                        } else {
                            executeBehaviourTree("DasherShop");
                        }
                    }
                }
            }
        }
        // if there are some cheap kills near, chase
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.Less, 60.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
            setBool("lowTargetNear", Flagtoggle.Yes);
        } else {
            setBool("lowTargetNear", Flagtoggle.No);
        }
        if (getBoolEquals("Tornadoing", Yesno.Yes)||getBoolEquals("lowTargetNear", Yesno.Yes)) {
            setBool("chase", Flagtoggle.Yes);
        } else {
            setBool("chase", Flagtoggle.No);
        }
        // check for turrets near us
        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.0D, 0.0D, 1.4D, 0.5D, Yesno.Yes)) {
            setBool("turretNear", Flagtoggle.Yes);
        } else {
            setBool("turretNear", Flagtoggle.No);
        }
        if (getBoolEquals("retreating", Yesno.No)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                if (getBoolEquals("turretNear", Yesno.Yes)) {
                    // retreat
                    adjustCounter("setState", "10", Valueadjust.Set);
                    setBool("retreating", Flagtoggle.Yes);
                }
            }
        }
        // if we are dumb, don't chase for too long
        if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
            // we don't chase for too long
            if (random("50")) {
                setBool("chase", Flagtoggle.No);
            }
        }
        // if retreating, dont ever chase
        if (getBoolEquals("retreating", Yesno.Yes)) {
            setBool("chase", Flagtoggle.No);
        }
        // chase peoples
        if (getBoolEquals("chase", Yesno.Yes)) {
            adjustCounter("chaseWait", "20", Valueadjust.Set);
            executeBehaviourTree("DasherChaseReselectTarget");
            if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    // dont chase when theres a turret
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.8D, 0.2D, Yesno.Yes)) {
                        // abort chase
                        setBool("chase", Flagtoggle.No);
                    }
                }
            }
            if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
                // if we are damaged
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.Less, Targetself.Self)) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        // if enemy is pretty high
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 80.0D, Valuecompare.Greater, Targetself.Target)) {
                            // abort chase
                            setBool("chase", Flagtoggle.No);
                        }
                    }
                }
            }
            if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                // if we are low
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
                    // if we target a player
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        // if enemy is not low enough to chase after
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.Greater, Targetself.Target)) {
                            // abort chase
                            setBool("chase", Flagtoggle.No);
                        }
                    }
                }
            }
            if (checkCounter("botSkill", "1", Valuecompare.GreaterOrEqual)) {
                // if we are very low
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.Less, Targetself.Self)) {
                    // abort chase
                    setBool("chase", Flagtoggle.No);
                }
            }
            // jump over some things
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES, CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.05D, 0.05D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                if (getBoolEquals("Tornadoing", Yesno.No)) {
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        pressButton(Buttons.FACE_BOTTOM, 0.1D);
                    }
                }
            }
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.6D, 1.6D, Yesno.No, Yesno.No)) {
                // does the ai have a target
                if (hasTarget(Yesno.Yes)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        pressStick(Directions.FORWARD, 0.1D);
                        setBool("HasMoved", Flagtoggle.Yes);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                        setBool("HasMoved", Flagtoggle.Yes);
                        pressStick(Directions.BACKWARD, 0.1D);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                        if (getBoolEquals("Tornadoing", Yesno.No)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                // jump
                                pressButton(Buttons.FACE_BOTTOM, 0.1D);
                                setBool("HasMoved", Flagtoggle.Yes);
                            }
                        } else {
                            adjustCounter("tornadoJumpCounter", "1", Valueadjust.Add);
                            if (checkCounter("tornadoJumpCounter", "6", Valuecompare.Greater)) {
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    // jump
                                    pressButton(Buttons.FACE_BOTTOM, 0.1D);
                                }
                                setBool("HasMoved", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        adjustCounter("tornadoJumpCounter", "0", Valueadjust.Set);
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        // we don't want to jump down on jumppad when chasing
                        if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.05D, 0.1D, 0.1D, Yesno.No, Yesno.No)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                // jump down platform
                                pressButton(Buttons.SHOULDER_LEFT, 0.2D);
                                setBool("HasMoved", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            } else {
                // target not near and at waypoint: give up
                if (isAtDestWaypoint()) {
                    // we give up
                    setBool("chase", Flagtoggle.No);
                }
                sequence8();
            }
        } else {
            adjustCounter("chaseWait", "-1", Valueadjust.Add);
        }
        // use our wits to get between enemy droids and turret, taking damage
        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
            // jump over creeps and get between them and turret
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.15D, 0.15D, Yesno.No)) {
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    if (getBoolEquals("retreating", Yesno.No)&&isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.0D, 0.5D, Yesno.No)) {
                        if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.05D, 0.0D, 0.1D, 0.0D, Yesno.No)) {
                                pressStick(Directions.FORWARD, 0.5D);
                                pressButton(Buttons.FACE_BOTTOM, 0.1D);
                            }
                        }
                    } else {
                        if (getBoolEquals("Tornadoing", Yesno.No)) {
                            pressButton(Buttons.FACE_BOTTOM, 0.1D);
                        }
                    }
                }
            }
        }
        // make sure the ai doesnt get stuck in chase state
        if (checkCounter("MoveCheck", "5", Valuecompare.Greater)) {
            setBool("chase", Flagtoggle.No);
        }
        // when we aren't completely braindead, jump over stuff to escape
        if (checkCounter("botSkill", "1", Valuecompare.GreaterOrEqual)) {
            // if retreating, jump over players/creeps
            if (getBoolEquals("retreating", Yesno.Yes)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.15D, 0.2D, Yesno.No)) {
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        if (timer(Timeunits.Seconds, 0.2D, Yesno.Yes)) {
                            if (isButtonDown(Buttons.FACE_BOTTOM)) {
                            } else {
                                // jump high
                                pressButton(Buttons.FACE_BOTTOM, 0.5D);
                            }
                        }
                    }
                }
            }
        }
        // jump over projectiles on higher bot skill
        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
            // jump over projectiles
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.3D, 0.3D, Yesno.No, Yesno.No)) {
                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                    if (timer(Timeunits.Seconds, 0.2D, Yesno.Yes)) {
                        if (isButtonDown(Buttons.FACE_BOTTOM)) {
                        } else {
                            // jump high
                            pressButton(Buttons.FACE_BOTTOM, 0.5D);
                        }
                    }
                }
            }
        }
        setBool("BlockDownJump", Flagtoggle.No);
        adjustCounter("ForceDownJumpTimer", "-1", Valueadjust.Add);
        // we are sorta smart, avoid fire hazard on 205
        if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
            if (isInNamedArea("aboveHazardAreaEnabled", Ownenemy.OWN_TEAM, Targetself.Self)) {
                // Block jumping down when above the fire hazard
                setBool("BlockDownJump", Flagtoggle.Yes);
            }
            if (isInNamedArea("belowHazardAreaEnabled", Ownenemy.OWN_TEAM, Targetself.Self)) {
                // when we are below active fire, force jumping down platforms for 3 seconds
                adjustCounter("ForceDownJumpTimer", "30", Valueadjust.Set);
            }
        }
        if (checkCounter("ForceDownJump", "0", Valuecompare.Greater)) {
            // Force jumping down
            setBool("DownJump", Flagtoggle.Yes);
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.Less, Targetself.Self)) {
            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.3D, 1.0D, Yesno.Yes)) {
                setBool("retreating", Flagtoggle.Yes);
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    pressStick(Directions.BACKWARD, 1.0D);
                    // dash away if possible
                    if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                        pressButton(Buttons.FACE_RIGHT, 0.2D);
                    }
                } else {
                    pressStick(Directions.FORWARD, 1.0D);
                }
            }
        }
        // Handle movement if not chasing
        if (getBoolEquals("chase", Yesno.No)) {
            // Move Away From Target
            if (getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
                setBool("ForceWaypointMovement", Flagtoggle.No);
                if (directionToEnemyBase(Forwardbackward.BACKWARD)||isInNamedArea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                    setBool("GoForward", Flagtoggle.Yes);
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                } else {
                    setBool("GoBack", Flagtoggle.Yes);
                }
                setBool("MoveAwayFromTarget", Flagtoggle.No);
            }
            // Move Towards Target
            if (getBoolEquals("MoveTowardsTarget", Yesno.Yes)) {
                setBool("ForceWaypointMovement", Flagtoggle.No);
                if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                    setBool("GoBack", Flagtoggle.Yes);
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        // greens
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                            setBool("DownJump", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    } else {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                            setBool("GoForward", Flagtoggle.Yes);
                            if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    }
                }
                setBool("MoveTowardsTarget", Flagtoggle.No);
            }
            // 205 special movement hacks
            if (checkCounter("205hacks", "0", Valuecompare.Greater)) {
                setBool("CantMove", Flagtoggle.Yes);
                if (checkCounter("205hacks", "15", Valuecompare.Greater)) {
                    if (timer(Timeunits.Seconds, 0.4D, Yesno.Yes)) {
                        // jump down
                        pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                    }
                }
                adjustCounter("205hacks", "-1", Valueadjust.Add);
                if (checkCounter("205hacks", "15", Valuecompare.Less)) {
                    if (isNextWaypointPosition(Offsetposition.FRONT)) {
                        pressStick(Directions.FORWARD, 1.0D);
                    } else {
                        pressStick(Directions.BACKWARD, 1.0D);
                    }
                    if (timer(Timeunits.Seconds, 0.4D, Yesno.Yes)) {
                        // jumpies
                        pressButton(Buttons.FACE_BOTTOM, 0.3D);
                    }
                }
                if (checkCounter("205hacks", "0", Valuecompare.Equal)) {
                    setBool("CantMove", Flagtoggle.No);
                    log("end hacks", "", "");
                }
            } else {
                // Use dirty hacks on AI 205 (waypoints are shit in one area)
                if (getBoolEquals("on205", Yesno.Yes)) {
                    if (isInNamedArea("AREABOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREABOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        // are there jumppads close below us
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.1D, 0.02D, 0.2D, Yesno.No, Yesno.No)) {
                            // we wanna go up?
                            if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                                adjustCounter("205hacks", "20", Valueadjust.Set);
                            }
                        }
                        // are there jumppads below us
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.25D, 0.02D, 0.5D, Yesno.No, Yesno.No)) {
                            // we wanna go up?
                            if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                                adjustCounter("ForceDownJumpTimer", "20", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
            // Handle Movement
            if (getBoolEquals("CantMove", Yesno.No)) {
                setBool("HasMoved", Flagtoggle.No);
                if (getBoolEquals("GoBack", Yesno.Yes)) {
                    setBool("GoBack", Flagtoggle.No);
                    if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                        pressStick(Directions.BACKWARD, 0.1D);
                        setBool("HasMoved", Flagtoggle.Yes);
                    }
                } else {
                    if (getBoolEquals("GoForward", Yesno.Yes)) {
                        pressStick(Directions.FORWARD, 0.1D);
                        setBool("HasMoved", Flagtoggle.Yes);
                        setBool("GoForward", Flagtoggle.No);
                    } else {
                        // at regen area
                        if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                    pressStick(Directions.BACKWARD, 0.1D);
                                } else {
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                    // check walls
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
                if (getBoolEquals("GoDown", Yesno.Yes)) {
                    pressStick(Directions.DOWN, 0.1D);
                    setBool("GoDown", Flagtoggle.No);
                } else {
                    if (getBoolEquals("GoUp", Yesno.Yes)) {
                        pressStick(Directions.UP, 0.1D);
                        setBool("GoUp", Flagtoggle.No);
                    }
                }
                if (isInNamedArea("nodoublejump", Ownenemy.OWN_TEAM, Targetself.Self)) {
                } else {
                    if (getBoolEquals("jump", Yesno.No)) {
                        if (getBoolEquals("DownJump", Yesno.No)) {
                            if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                                if (isInNamedArea("BOTSTOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("GOUPSTOP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                    enableUpgrade(Yesno.Yes, "hold");
                                } else {
                                    if (timer(Timeunits.Seconds, 4.0D, Yesno.No)) {
                                        enableUpgrade(Yesno.Yes, "hold");
                                    }
                                }
                            }
                        }
                    }
                    // JUMPIN
                    if (getBoolEquals("DownJump", Yesno.No)) {
                        if (getBoolEquals("ReadyToJump", Yesno.No)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                setBool("ReadyToJump", Flagtoggle.Yes);
                            }
                        } else {
                            if (getBoolEquals("jump", Yesno.Yes)) {
                                setBool("jump", Flagtoggle.No);
                                if (timer(Timeunits.Seconds, 0.4D, Yesno.Yes)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "Dasherspeed")) {
                                        sequence9();
                                    } else {
                                        sequence10();
                                    }
                                }
                            }
                        }
                    } else {
                        setBool("DownJump", Flagtoggle.No);
                        if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            if (getBoolEquals("BlockDownJump", Yesno.No)) {
                                // downjump
                                pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)||isOnGround(Yesno.No, Targetself.Self)) {
                                } else {
                                    setBool("ReadyToJump", Flagtoggle.No);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        if (checkCounter("botSkill", "0", Valuecompare.Equal)) {
            // low chance of doing shooting
            if (random("6")) {
                setBool("doShooting", Flagtoggle.Yes);
            } else {
                setBool("doShooting", Flagtoggle.No);
            }
        } else {
            if (checkCounter("botSkill", "1", Valuecompare.Equal)) {
                // higher chance of doing shooting
                if (random("3")) {
                    setBool("doShooting", Flagtoggle.Yes);
                } else {
                    setBool("doShooting", Flagtoggle.No);
                }
            } else {
                if (checkCounter("botSkill", "2", Valuecompare.Equal)) {
                    // very high chance of doing shooting
                    if (random("4")) {
                        setBool("doShooting", Flagtoggle.No);
                    } else {
                        setBool("doShooting", Flagtoggle.Yes);
                    }
                } else {
                    if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
                        setBool("doShooting", Flagtoggle.Yes);
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "0", Valuecompare.LessOrEqual)) {
            wait(0.2D);
        }
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
            wait(0.1D);
        }
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "2", Valuecompare.LessOrEqual)) {
            wait(0.1D);
        }
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "0", Valuecompare.LessOrEqual)) {
            wait(0.2D);
        }
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
            wait(0.1D);
        }
        // dumb bots have delayed shooting
        if (checkCounter("botSkill", "2", Valuecompare.LessOrEqual)) {
            wait(0.1D);
        }
        pressButton(Buttons.FACE_LEFT, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        // if a teammate needs help
        if (receivedPing(Ping.HELP)) {
            // go help him!
            selectPingWaypoint(Ping.HELP);
        }
        // if a turret is under attack
        if (receivedPing(Ping.TURRET_UNDER_ATTACK)) {
            // go to that turret
            selectPingWaypoint(Ping.TURRET_UNDER_ATTACK);
        }
        // if a turret is almost lost
        if (receivedPing(Ping.TURRET_ALMOST_DESTROYED)) {
            // go to that turret
            selectPingWaypoint(Ping.TURRET_ALMOST_DESTROYED);
        }
        // if base is under attack
        if (receivedPing(Ping.BASE_UNDER_ATTACK)) {
            // go to base
            selectPingWaypoint(Ping.BASE_UNDER_ATTACK);
        }
        // if base is almost lost
        if (receivedPing(Ping.BASE_ALMOST_DESTROYED)) {
            // go to base
            selectPingWaypoint(Ping.BASE_ALMOST_DESTROYED);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        setBool("dashTargetNear", Flagtoggle.No);
        // try players, we need enough hp
        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 55.0D, Valuecompare.Greater, Targetself.Self)) {
            // players near to dash?
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)) {
                // [selectPlayer]
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 0.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                setBool("dashTargetNear", Flagtoggle.Yes);
            }
        }
        // try creeps
        if (getBoolEquals("dashTargetNear", Yesno.No)) {
            // if there are no players anywhere near, we can waste our dash on droids
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.Yes)) {
            } else {
                // we need enough hp
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.Greater, Targetself.Self)) {
                    // creeps near to dash? (more than 2)
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes)) {
                        // [selectDroids]
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.8D, 0.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.Yes, Yesno.No);
                        setBool("dashTargetNear", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (getBoolEquals("dashTargetNear", Yesno.Yes)) {
            // we are now preparing for triangle dash
            setBool("PrepareDash", Flagtoggle.Yes);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        // use tornado skill!
        pressButton(Buttons.FACE_TOP, 0.2D);
        // we are in tornado mode
        setBool("Tornadoing", Flagtoggle.Yes);
        setBool("chase", Flagtoggle.Yes);
        // tornado lasts for 2 seconds
        wait(2.0D);
        setBool("Tornadoing", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
            if (getBoolEquals("Retreating", Yesno.No)) {
                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), Valuecompare.GreaterOrEqual, 20.0D, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No)) {
                } else {
                    // check if we can finish this target, starting at highest damage upgrade
                    if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage3")) {
                        // dash low targets
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.LessOrEqual, 60.0D, "", 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes)) {
                            // [selectPlayer]
                            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .LessOrEqual, 600.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage2")) {
                            // dash insta-kills instantly
                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.LessOrEqual, 50.0D, "", 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes)) {
                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                            }
                        } else {
                            if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage1")) {
                                // dash insta-kills instantly
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.LessOrEqual, 45.0D, "", 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes)) {
                                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                }
                            } else {
                                if (isUpgradeEnabled(Yesno.Yes, "DasherDashDamage6")) {
                                    // dash insta-kills instantly
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.LessOrEqual, 45.0D, "", 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                    }
                                } else {
                                    // dash insta-kills instantly
                                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.LessOrEqual, 35.0D, "", 0.0D, 0.0D, 0.9D, 0.9D, Yesno.Yes)) {
                                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .Lowest, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
            pressStick(Directions.BACKWARD, 0.1D);
        } else {
            pressStick(Directions.FORWARD, 0.1D);
        }
        wait(0.2D);
        // dash away!
        pressButton(Buttons.FACE_RIGHT, 0.3D);
        log("escape dash", "", "");
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        if (isNextWaypointPosition(Offsetposition.FRONT)) {
            pressStick(Directions.FORWARD, 0.1D);
            setBool("HasMoved", Flagtoggle.Yes);
        }
        if (isNextWaypointPosition(Offsetposition.BACK)) {
            pressStick(Directions.BACKWARD, 0.1D);
            setBool("HasMoved", Flagtoggle.Yes);
        }
        if (isNextWaypointPosition(Offsetposition.ABOVE)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                // jump
                pressButton(Buttons.FACE_BOTTOM, 0.4D);
                setBool("HasMoved", Flagtoggle.Yes);
            }
        }
        if (isNextWaypointPosition(Offsetposition.BELOW)) {
            // jump down platform
            pressButton(Buttons.SHOULDER_LEFT, 0.2D);
            setBool("HasMoved", Flagtoggle.Yes);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        // jump
        pressButton(Buttons.FACE_BOTTOM, 0.3D);
    }

}

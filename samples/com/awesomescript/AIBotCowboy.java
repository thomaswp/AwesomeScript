
package com.awesomescript;

import java.util.EnumSet;

public class AIBotCowboy
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Cowboy", Flagtoggle.Yes);
        }
        executeBehaviourTree("Cowboy");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // Blast em!
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
            } else {
                if (hasTarget(Yesno.Yes)) {
                    if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.No)) {
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                }
            }
        }
        // Throw Grenade
        if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isUpgradeEnabled(Yesno.Yes, "Grenade")) {
                    if (hasTarget(Yesno.Yes)) {
                        if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                            if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            } else {
                                if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                } else {
                                    // if really dumb: always charge dynamite fully and dont move
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Greater, Targetself.Self)) {
                                                aimStickAtTarget(0.45D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            }
                                            // DYNAMITE BABY
                                            pressButton(Buttons.FACE_RIGHT, 0.45D);
                                            setBool("DontMove", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                            // dont face mite if dumb
                                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                                aimStickAtTarget(0.06D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                // DYNAMITE BABY
                                                pressButton(Buttons.FACE_RIGHT, 0.06D);
                                            } else {
                                                aimStickAtTarget(0.22D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                // DYNAMITE BABY
                                                pressButton(Buttons.FACE_RIGHT, 0.22D);
                                            }
                                        } else {
                                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                                } else {
                                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                                        aimStickAtTarget(0.22D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                        // DYNAMITE BABY
                                                        pressButton(Buttons.FACE_RIGHT, 0.22D);
                                                    } else {
                                                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.2D, Yesno.Yes, Yesno.Yes)) {
                                                            aimStickAtTarget(0.45D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                            // DYNAMITE BABY
                                                            pressButton(Buttons.FACE_RIGHT, 0.45D);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Throw Bull
        if (isUpgradeEnabled(Yesno.Yes, "Bull")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    if (hasTarget(Yesno.Yes)) {
                        if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.9D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.3D, 0.0D, 0.6D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                                selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.3D, 0.0D, 0.6D, 0.1D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                // Bull em!
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    }
                                    // dont bull them into turrets if super dumb
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                            // Bull em!
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    } else {
                                        if ((((directionToEnemyBase(Forwardbackward.BACKWARD)||checkCounter("state", "1", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                            aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            // Bull em!
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                        }
                                    }
                                } else {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS, TargetGroups.DESTROYABLE_OBSTACLES))) {
                                        if (isTargetInArea(Yesno.Yes, 0.3D, 0.0D, 0.6D, 0.1D, Yesno.Yes, Yesno.No)) {
                                            if (directionToEnemyBase(Forwardbackward.FORWARD)||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                                aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                // Bull em!
                                                pressButton(Buttons.FACE_TOP, 0.0D);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "GRENADE")) {
                    if (canPayUpgrade("GRENADE")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 40.0D, Valueadjust.Add);
                        }
                        buyUpgrade("GRENADE");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if ((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")||checkGameTime(600.0D, Valuecompare.GreaterOrEqual))||checkCharacterValue(CharactervaluesCheckable.Gold, 600.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                            if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                if (canPayUpgrade("PiggyBank")) {
                                    buyUpgrade("PiggyBank");
                                }
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYGRENADEMORE")) {
                    if (canPayUpgrade("COWBOYGRENADEMORE")) {
                        buyUpgrade("COWBOYGRENADEMORE");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "BULL")) {
                    if (canPayUpgrade("BULL")) {
                        buyUpgrade("BULL");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "COWBOYSPEED")) {
                        if (canPayUpgrade("COWBOYSPEED")) {
                            buyUpgrade("COWBOYSPEED");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                        if (isUpgradeEnabled(Yesno.No, "healthRegen1")) {
                            if (canPayUpgrade("healthRegen1")) {
                                buyUpgrade("healthRegen1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "healthRegen2")) {
                            if (canPayUpgrade("healthRegen2")) {
                                buyUpgrade("healthRegen2");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYGRENADELIFESTEAL")) {
                    if (canPayUpgrade("COWBOYGRENADELIFESTEAL")) {
                        buyUpgrade("COWBOYGRENADELIFESTEAL");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYBULLEXPLODE")) {
                    if (canPayUpgrade("COWBOYBULLEXPLODE")) {
                        buyUpgrade("COWBOYBULLEXPLODE");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYSHOTDAMAGE3")) {
                    if (canPayUpgrade("COWBOYSHOTDAMAGE3")) {
                        buyUpgrade("COWBOYSHOTDAMAGE3");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYSHOTDAMAGE")) {
                    if (canPayUpgrade("COWBOYSHOTDAMAGE")) {
                        buyUpgrade("COWBOYSHOTDAMAGE");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYSHOTDAMAGE2")) {
                    if (canPayUpgrade("COWBOYSHOTDAMAGE2")) {
                        buyUpgrade("COWBOYSHOTDAMAGE2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CowboyGrenadeDot1")) {
                    if (canPayUpgrade("CowboyGrenadeDot1")) {
                        buyUpgrade("CowboyGrenadeDot1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CowboyGrenadeDot2")) {
                    if (canPayUpgrade("CowboyGrenadeDot2")) {
                        buyUpgrade("CowboyGrenadeDot2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CowboyShotAttackspeed")) {
                    if (canPayUpgrade("CowboyShotAttackspeed")) {
                        buyUpgrade("CowboyShotAttackspeed");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "COWBOYSHOTATTACKSPEED2")) {
                    if (canPayUpgrade("COWBOYSHOTATTACKSPEED2")) {
                        buyUpgrade("COWBOYSHOTATTACKSPEED2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CowboyBullCooldown")) {
                    if (canPayUpgrade("CowboyBullCooldown")) {
                        buyUpgrade("CowboyBullCooldown");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                        if (canPayUpgrade("addHealth1")) {
                            buyUpgrade("addHealth1");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                        if (canPayUpgrade("addHealth2")) {
                            buyUpgrade("addHealth2");
                        }
                    }
                    if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                        if (canPayUpgrade("addHealth3")) {
                            buyUpgrade("addHealth3");
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "CowboyBullBigger")) {
                    if (canPayUpgrade("CowboyBullBigger")) {
                        buyUpgrade("CowboyBullBigger");
                    }
                }
            }
        }
        // Move Away From Target
        if (getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (directionToEnemyBase(Forwardbackward.BACKWARD)||isInNamedArea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                } else {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
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
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.02D, 0.01D, 0.04D, Yesno.Yes, Yesno.No)) {
                        setBool("DownJump", Flagtoggle.Yes);
                    }
                }
                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                    setBool("jump", Flagtoggle.Yes);
                }
                if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                    setBool("GoForward", Flagtoggle.Yes);
                    if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
            }
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        // Handle Movement
        if (getBoolEquals("CantMove", Yesno.No)) {
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
                if (getBoolEquals("DoingDownJump", Yesno.No)) {
                    // JUMPIN
                    if (getBoolEquals("DownJump", Yesno.No)) {
                        if (getBoolEquals("jump", Yesno.Yes)) {
                            setBool("jump", Flagtoggle.No);
                            if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            } else {
                                if (timer(Timeunits.Seconds, 0.4D, Yesno.Yes)) {
                                } else {
                                    pressButton(Buttons.FACE_BOTTOM, 0.1D);
                                }
                            }
                        }
                    } else {
                        setBool("DownJump", Flagtoggle.No);
                        if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            if (isInNamedArea("ABOVEHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            } else {
                                // downjump
                                pressButton(Buttons.SHOULDER_LEFT, 0.1D);
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("DontMove", Yesno.No)) {
                setBool("HasMoved", Flagtoggle.No);
                if (getBoolEquals("GoBack", Yesno.Yes)) {
                    setBool("GoBack", Flagtoggle.No);
                    if (getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self)) {
                        pressStick(Directions.BACKWARD, 0.1D);
                        setBool("HasMoved", Flagtoggle.Yes);
                    } else {
                        if (isNextWaypointPosition(Offsetposition.BELOW)) {
                            pressStick(Directions.BACKWARD, 0.1D);
                            setBool("HasMoved", Flagtoggle.Yes);
                        }
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
                                    // check walls
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                setBool("DontMove", Flagtoggle.No);
            }
        }
    }

}

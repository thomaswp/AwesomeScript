
package com.awesomescript;

import java.util.EnumSet;

public class AIBotMaw
    extends Script
{


    public void onTick() {
        executeBehaviourTree("Maw");
        executeBehaviourTree("VeankoAI");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // make them your chew toy
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (hasTarget(Yesno.Yes)) {
                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.15D, Yesno.Yes, Yesno.Yes)) {
                        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                }
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.2D, 0.15D, Yesno.Yes, Yesno.No)) {
                    // attack
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
        }
        // Spit!
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (isUpgradeEnabled(Yesno.Yes, "MawSpit")) {
                        // use spit badly if dumb
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.Yes)) {
                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_RIGHT, 0.0D);
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.Yes)) {
                                if (isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.Yes)||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Greater, Targetself.Self)) {
                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Greater, Targetself.Self)) {
                                        aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    }
                                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Weedlings!
        if (isUpgradeEnabled(Yesno.Yes, "MawTurret")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    if (isUpgradeEnabled(Yesno.Yes, "TurretAvailable")) {
                        if (getBoolEquals("hasWeed", Yesno.No)) {
                            // use weedlings badly if dumb
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                    } else {
                                        sequence0();
                                    }
                                } else {
                                    if (checkCounter("state", "2", Valuecompare.Equal)) {
                                        if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                                            sequence1();
                                        }
                                    } else {
                                        if (isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("JUNGLE", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                            sequence2();
                                        }
                                    }
                                }
                            } else {
                                // never weed health creeps if dumb
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                    sequence3();
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.Yes)) {
                                if (((checkClass(Targetself.Target, "Spy")&&hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn"))&&checkCharacterValue(CharactervaluesCheckable.Health, 200.0D, Valuecompare.Greater, Targetself.Target))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                                } else {
                                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                    } else {
                                        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                    }
                                }
                            }
                        }
                        // only place weedlings in hiddin areas if smart
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            if (((((isInNamedArea("HIDE_AREA_TOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HIDE_AREA_TOP_BELOW", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM_ABOVE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_SIDE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_CENTRE", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                } else {
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            }
                        }
                    }
                }
            }
        }
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Am I in shop?
            if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isUpgradeEnabled(Yesno.No, "MawSpit")) {
                    if (canPayUpgrade("MawSpit")) {
                        // check difficulty level
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Add Solar
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 35.0D, Valueadjust.Add);
                        }
                        buyUpgrade("MawSpit");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawTurret")) {
                    if (canPayUpgrade("MawTurret")) {
                        buyUpgrade("MawTurret");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitDamage1")) {
                    if (canPayUpgrade("MawSpitDamage1")) {
                        buyUpgrade("MawSpitDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitDamage2")) {
                    if (canPayUpgrade("MawSpitDamage2")) {
                        buyUpgrade("MawSpitDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitDamage3")) {
                    if (canPayUpgrade("MawSpitDamage3")) {
                        buyUpgrade("MawSpitDamage3");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitLonger")) {
                    if (canPayUpgrade("MawSpitLonger")) {
                        buyUpgrade("MawSpitLonger");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitSlow1")) {
                    if (canPayUpgrade("MawSpitSlow1")) {
                        buyUpgrade("MawSpitSlow1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawSpitSlow2")) {
                    if (canPayUpgrade("MawSpitSlow2")) {
                        buyUpgrade("MawSpitSlow2");
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (isUpgradeEnabled(Yesno.No, "MawSpeed")) {
                        if (canPayUpgrade("MawSpeed")) {
                            buyUpgrade("MawSpeed");
                        }
                    }
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
                if (isUpgradeEnabled(Yesno.No, "MawShotDot1")) {
                    if (canPayUpgrade("MawShotDot1")) {
                        buyUpgrade("MawShotDot1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawShotDot2")) {
                    if (canPayUpgrade("MawShotDot2")) {
                        buyUpgrade("MawShotDot2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawShotCombine")) {
                    if (canPayUpgrade("MawShotCombine")) {
                        buyUpgrade("MawShotCombine");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawShotSpeedUp")) {
                    if (canPayUpgrade("MawShotSpeedUp")) {
                        buyUpgrade("MawShotSpeedUp");
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
                if (isUpgradeEnabled(Yesno.No, "MawTurretMaxChunks")) {
                    if (canPayUpgrade("MawTurretMaxChunks")) {
                        buyUpgrade("MawTurretMaxChunks");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawTurretMaxChunks2")) {
                    if (canPayUpgrade("MawTurretMaxChunks2")) {
                        buyUpgrade("MawTurretMaxChunks2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawTurretDamage1")) {
                    if (canPayUpgrade("MawTurretDamage1")) {
                        buyUpgrade("MawTurretDamage1");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawTurretDamage2")) {
                    if (canPayUpgrade("MawTurretDamage2")) {
                        buyUpgrade("MawTurretDamage2");
                    }
                }
                if (isUpgradeEnabled(Yesno.No, "MawTurretCheaper1")) {
                    if (canPayUpgrade("MawTurretCheaper1")) {
                        buyUpgrade("MawTurretCheaper1");
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
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
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
                            }
                        }
                    }
                }
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    if (isOnGround(Yesno.Yes, Targetself.Self)) {
                        if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        } else {
                            if (timer(Timeunits.Seconds, 0.31D, Yesno.Yes)) {
                                // jump
                                pressButton(Buttons.FACE_BOTTOM, 0.3D);
                            }
                        }
                    }
                }
                // JUMPIN
                if (getBoolEquals("DownJump", Yesno.No)) {
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
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.08D, 0.04D, 0.02D, Yesno.No, Yesno.No)) {
                                        if (random("3")) {
                                            setBool("DownJump", Flagtoggle.Yes);
                                        } else {
                                            setBool("jump", Flagtoggle.Yes);
                                        }
                                    }
                                    // check enemies
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.12D, 0.02D, Yesno.No, Yesno.No)) {
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

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("hasWeed", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.0D);
        wait(2.0D);
        setBool("hasWeed", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("hasWeed", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.0D);
        wait(2.0D);
        setBool("hasWeed", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("hasWeed", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.0D);
        wait(2.0D);
        setBool("hasWeed", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        setBool("hasWeed", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.0D);
        wait(5.0D);
        setBool("hasWeed", Flagtoggle.No);
    }

}

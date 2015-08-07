
package com.awesomescript;

import java.util.EnumSet;

public class AIBotBrute
    extends Script
{


    public void onTick() {
        if (getBoolEquals("VeankoInit", Yesno.No)) {
            setBool("Brute", Flagtoggle.Yes);
        }
        executeBehaviourTree("Brute");
        // reset haltJump for next tick
        setBool("haltJump", Flagtoggle.No);
        if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
            adjustCounter("3rdHitTime", "1", Valueadjust.Add);
        } else {
            adjustCounter("3rdHitTime", "0", Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage2")&&isUpgradeEnabled(Yesno.Yes, "AddHealth3")) {
            setBool("wilNotKillSolarBoss", Flagtoggle.No);
        } else {
            setBool("wilNotKillSolarBoss", Flagtoggle.Yes);
        }
        // Set up temporary var for throw and quake CD
        if (isUpgradeEnabled(Yesno.Yes, "BotLevel4")) {
            adjustCounter("CDInit", "53", Valueadjust.Set);
        } else {
            if (isUpgradeEnabled(Yesno.Yes, "BotLevel3")) {
                adjustCounter("CDInit", "59", Valueadjust.Set);
            } else {
                if (isUpgradeEnabled(Yesno.Yes, "BotLevel2")) {
                    adjustCounter("CDInit", "65", Valueadjust.Set);
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "BotLevel1")) {
                        adjustCounter("CDInit", "72", Valueadjust.Set);
                    } else {
                        adjustCounter("CDtInit", "80", Valueadjust.Set);
                    }
                }
            }
        }
        // Keep bash disabled to land throw
        if (getBoolEquals("noBashNextTick", Yesno.Yes)) {
            setBool("noBash", Flagtoggle.Yes);
            if ((((isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))&&directionToEnemyBase(Forwardbackward.FORWARD))&&isTargetInArea(Yesno.Yes, 0.15D, 0.0D, 0.3D, 0.35D, Yesno.No, Yesno.No))&&checkCounter("state", "4", Valuecompare.Equal))&&checkCounter("throwCount", "0", Valuecompare.LessOrEqual)) {
                setBool("MoveAwayFromTarget", Flagtoggle.No);
                setBool("MoveTowardsTarget", Flagtoggle.Yes);
            } else {
                setBool("noBashNextTick", Flagtoggle.No);
            }
        }
        // tap instead of holding down attack
        if (checkCounter("tapTime", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("tapTime", "-1", Valueadjust.Add);
            setBool("tapBash", Flagtoggle.Yes);
            if (checkCounter("tapTime", "0", Valuecompare.Equal)) {
                setBool("tapBash", Flagtoggle.No);
            }
        }
        // Get Ready to tap for 3rd Bash
        if (isUpgradeEnabled(Yesno.Yes, "BruteHit2")) {
            setBool("hit2", Flagtoggle.Yes);
            adjustCounter("hit2Time", "4", Valueadjust.Set);
        } else {
            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            } else {
                if (getBoolEquals("hit2", Yesno.Yes)) {
                    adjustCounter("tapTime", "4", Valueadjust.Set);
                }
            }
        }
        if (checkCounter("hit2Time", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("hit2Time", "-1", Valueadjust.Add);
        } else {
            setBool("hit2", Flagtoggle.No);
        }
        setBool("approachTurret", Flagtoggle.No);
        // Mighty Throw
        if (isUpgradeEnabled(Yesno.Yes, "BruteThrow")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (checkCounter("throwCount", "0", Valuecompare.LessOrEqual)) {
                    // Walk into turret if it can get a throw
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.19D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.14D, 0.04D, 0.28D, 0.18D, Yesno.No, Yesno.No)) {
                                setBool("MoveAwayFromTarget", Flagtoggle.No);
                                setBool("haltJump", Flagtoggle.Yes);
                                pressStick(Directions.FORWARD, 0.1D);
                            }
                        } else {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.17D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.13D, 0.04D, 0.26D, 0.18D, Yesno.No, Yesno.No)) {
                                    setBool("MoveAwayFromTarget", Flagtoggle.No);
                                    setBool("haltJump", Flagtoggle.Yes);
                                    pressStick(Directions.FORWARD, 0.1D);
                                }
                            } else {
                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.15D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.13D, 0.04D, 0.26D, 0.18D, Yesno.No, Yesno.No)) {
                                        setBool("MoveAwayFromTarget", Flagtoggle.No);
                                        setBool("haltJump", Flagtoggle.Yes);
                                        pressStick(Directions.FORWARD, 0.1D);
                                    }
                                } else {
                                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.13D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.12D, 0.04D, 0.24D, 0.18D, Yesno.No, Yesno.No)) {
                                            setBool("MoveAwayFromTarget", Flagtoggle.No);
                                            setBool("haltJump", Flagtoggle.Yes);
                                            pressStick(Directions.FORWARD, 0.1D);
                                        }
                                    } else {
                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.11D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.12D, 0.04D, 0.24D, 0.18D, Yesno.No, Yesno.No)) {
                                                setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                setBool("haltJump", Flagtoggle.Yes);
                                                pressStick(Directions.FORWARD, 0.1D);
                                            }
                                        } else {
                                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.09D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.11D, 0.04D, 0.22D, 0.18D, Yesno.No, Yesno.No)) {
                                                    setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                    setBool("haltJump", Flagtoggle.Yes);
                                                    pressStick(Directions.FORWARD, 0.1D);
                                                }
                                            } else {
                                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.07D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.11D, 0.04D, 0.22D, 0.18D, Yesno.No, Yesno.No)) {
                                                        setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                        setBool("haltJump", Flagtoggle.Yes);
                                                        setBool("noBash", Flagtoggle.Yes);
                                                        pressStick(Directions.FORWARD, 0.1D);
                                                    }
                                                } else {
                                                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.05D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.04D, 0.2D, 0.18D, Yesno.No, Yesno.No)) {
                                                            setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                            setBool("haltJump", Flagtoggle.Yes);
                                                            setBool("noBash", Flagtoggle.Yes);
                                                            pressStick(Directions.FORWARD, 0.1D);
                                                        }
                                                    } else {
                                                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.03D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.1D, 0.04D, 0.2D, 0.18D, Yesno.No, Yesno.No)) {
                                                                setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                                setBool("haltJump", Flagtoggle.Yes);
                                                                setBool("noBash", Flagtoggle.Yes);
                                                                pressStick(Directions.FORWARD, 0.1D);
                                                            }
                                                        } else {
                                                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.01D, 0.0D, 0.02D, 0.2D, Yesno.No)) {
                                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.9D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.No)) {
                                                                    setBool("MoveAwayFromTarget", Flagtoggle.No);
                                                                    setBool("haltJump", Flagtoggle.Yes);
                                                                    setBool("noBash", Flagtoggle.Yes);
                                                                    pressStick(Directions.FORWARD, 0.1D);
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
                    // set up for throw behind turrets
                    if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.1D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.Yes)) {
                            setBool("noBash", Flagtoggle.Yes);
                            setBool("haltJump", Flagtoggle.Yes);
                        }
                    }
                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.17D, 0.17D, Yesno.No, Yesno.No)) {
                            setBool("noBash", Flagtoggle.Yes);
                            setBool("haltJump", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.25D, Yesno.No, Yesno.Yes)) {
                            // Tap the bash button, don't hold down AA
                            setBool("tapBash", Flagtoggle.Yes);
                        }
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            // Prepare to throw
                            if (isTargetInArea(Yesno.Yes, 0.14D, 0.0D, 0.28D, 0.36D, Yesno.No, Yesno.Yes)) {
                                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                                } else {
                                    setBool("noBash", Flagtoggle.Yes);
                                }
                                // Release FACE_LEFT if being held down
                                if (isButtonDown(Buttons.FACE_LEFT)) {
                                    pressButton(Buttons.FACE_LEFT, 0.0D);
                                }
                            }
                        }
                    } else {
                        if (checkCounter("state", "8", Valuecompare.Equal)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.Yes)) {
                                // Release FACE_LEFT if being held down
                                if (isButtonDown(Buttons.FACE_LEFT)) {
                                    pressButton(Buttons.FACE_LEFT, 0.0D);
                                    setBool("noBash", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
                if (isSkillOnButtonAvailable(Buttons.FACE_RIGHT)) {
                    if (hasTarget(Yesno.Yes)) {
                        if (((isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))&&checkCounter("state", "4", Valuecompare.Equal))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self))&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 66.67D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                if (checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target)||checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 33.33D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                    setBool("MoveAwayFromTarget", Flagtoggle.No);
                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                }
                                if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target)) {
                                    // Aggressive behaviour persists after stun duration
                                    adjustCounter("goHam", "10", Valueadjust.Set);
                                }
                            }
                            // Target is alone
                            if (isTargetInArea(Yesno.Yes, 0.3D, 0.0D, 0.6D, 0.6D, Yesno.Yes, Yesno.Yes)) {
                                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "2", 0.0D, 0.0D, 1.5D, 0.8D, Yesno.No)) {
                                } else {
                                    setBool("MoveAwayFromTarget", Flagtoggle.No);
                                    setBool("MoveTowardsTarget", Flagtoggle.Yes);
                                }
                            }
                        }
                        // Go in when preparing to throw
                        if (getBoolEquals("noBash", Yesno.Yes)) {
                            if ((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                            } else {
                                setBool("MoveAwayFromTarget", Flagtoggle.No);
                                setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            }
                        }
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.04D, 0.36D, 0.18D, Yesno.Yes, Yesno.Yes)) {
                            if (isFromTeam(Teamswithnumbers.ENEMY_TEAM, Targetself.Target)) {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    // Throw enemy 'nauts towards side
                                    if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                    // Throw enemy 'nauts when snared
                                    if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Self)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                    // Throw enemy 'nauts when health is less than a third
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 33.33D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                    // Throw enemy exploding Clunks
                                    if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                    // Throw enemy enraged Aylas
                                    if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "BloodThirstToggle")) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BruteSpeed")) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                            adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                        }
                                    }
                                    if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage1")&&checkCharacterValue(CharactervaluesCheckable.Health, 150.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    } else {
                                        if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage2")&&checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                            adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome")&&checkCharacterValue(CharactervaluesCheckable.Health, 500.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome2")&&checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                        // Throw enemy droids when snared
                                        if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Self)) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                            adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                        }
                                        if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                            if (isUpgradeEnabled(Yesno.Yes, "BruteSpeed")) {
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                            }
                                        }
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                        } else {
                                            // Throw enemy droids away from turrets if there are no enemy 'nauts nearby
                                            if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                                }
                                            }
                                            if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage1")&&checkCharacterValue(CharactervaluesCheckable.Health, 150.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage2")&&checkCharacterValue(CharactervaluesCheckable.Health, 300.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                                } else {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome")&&checkCharacterValue(CharactervaluesCheckable.Health, 500.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                                    } else {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome2")&&checkCharacterValue(CharactervaluesCheckable.Health, 700.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                                            adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.Yes)) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                        }
                    } else {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.1D, 0.0D, 0.2D, 0.2D, Yesno.No)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.Yes)) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.No, Yesno.No)) {
                            // Throw enemy 'nauts towards side
                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                            // Throw enemy 'nauts when snared
                            if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Self)) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                            // Throw enemy 'nauts when health is less than a third
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 33.33D, Valuecompare.LessOrEqual, Targetself.Self)) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                            // Throw enemy exploding Clunks
                            if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                            // Throw enemy enraged Aylas
                            if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "BloodThirstToggle")) {
                                pressButton(Buttons.FACE_RIGHT, 0.1D);
                                adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                            }
                            if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                if (isUpgradeEnabled(Yesno.Yes, "BruteSpeed")) {
                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                }
                            }
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.09D, 0.04D, 0.18D, 0.18D, Yesno.Yes, Yesno.No)) {
                                // Throw enemy droids when snared
                                if (checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Self)) {
                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                }
                                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BruteSpeed")) {
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    }
                                }
                                // Throw enemy droids away from turrets if there are no enemy 'nauts nearby
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                                } else {
                                    if (isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                                        if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                            pressButton(Buttons.FACE_RIGHT, 0.1D);
                                            adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // Throw Homeless Gnome at enemy turrets if there are no enemy 'nauts nearby
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 0.8D, Yesno.Yes, Yesno.No)) {
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome")||isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome2")) {
                            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.1D, 0.0D, 0.2D, 0.2D, Yesno.Yes)) {
                                sequence0();
                            } else {
                                if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes)) {
                                    if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                        pressButton(Buttons.FACE_RIGHT, 0.1D);
                                        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                    } else {
                                        sequence1();
                                    }
                                }
                            }
                        }
                    }
                    // Throw Homeless Gnome behind when escaping if there are no enemy 'nauts or droids in front
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.25D, 0.0D, 0.5D, 1.0D, Yesno.Yes, Yesno.No)) {
                    } else {
                        if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal)) {
                            if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome")||isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome2")) {
                                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                                    adjustCounter("throwCount", "CDInit", Valueadjust.Set);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Earthquake
        if (isUpgradeEnabled(Yesno.Yes, "BruteStamp")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                if (checkCounter("quakeCount", "0", Valuecompare.LessOrEqual)) {
                    if (isUpgradeEnabled(Yesno.Yes, "bruteHit3")) {
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, 0.0D, 0.4D, 0.1D, Yesno.Yes, Yesno.No)) {
                            if (isTargetType(Yesno.No, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.01D, 0.0D, 0.02D, 0.2D, Yesno.No, Yesno.No)) {
                                if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                    setBool("noBash", Flagtoggle.Yes);
                                }
                            }
                        }
                        // check wall
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)&&isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                            } else {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BruteStampRange")) {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 1.25D, 0.75D, Yesno.Yes, Yesno.No)) {
                                            setBool("noBash", Flagtoggle.Yes);
                                        }
                                    } else {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 0.8D, 0.75D, Yesno.Yes, Yesno.No)) {
                                            setBool("noBash", Flagtoggle.Yes);
                                        }
                                    }
                                } else {
                                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                        if (isUpgradeEnabled(Yesno.Yes, "BruteStampRange")) {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 1.35D, 0.75D, Yesno.Yes, Yesno.No)) {
                                                setBool("noBash", Flagtoggle.Yes);
                                            }
                                        } else {
                                            if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 0.85D, 0.75D, Yesno.Yes, Yesno.No)) {
                                                setBool("noBash", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                        if (isTargetType(Yesno.No, EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES))||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.01D, 0.0D, 0.02D, 0.2D, Yesno.No, Yesno.No)) {
                            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                                pressButton(Buttons.FACE_TOP, 0.0D);
                                adjustCounter("quakeCount", "CDInit", Valueadjust.Set);
                            }
                        }
                    }
                    // check wall
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)) {
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)&&isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                        } else {
                            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                                if (isUpgradeEnabled(Yesno.Yes, "BruteStampRange")) {
                                    if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 1.25D, 0.75D, Yesno.Yes, Yesno.No)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                        adjustCounter("quakeCount", "CDInit", Valueadjust.Set);
                                    }
                                } else {
                                    if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 0.8D, 0.75D, Yesno.Yes, Yesno.No)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                        adjustCounter("quakeCount", "CDInit", Valueadjust.Set);
                                    }
                                }
                            } else {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BruteStampRange")) {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 1.35D, 0.75D, Yesno.Yes, Yesno.No)) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                            adjustCounter("quakeCount", "CDInit", Valueadjust.Set);
                                        }
                                    } else {
                                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.5D, 0.85D, 0.75D, Yesno.Yes, Yesno.No)) {
                                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                            pressButton(Buttons.FACE_TOP, 0.0D);
                                            adjustCounter("quakeCount", "CDInit", Valueadjust.Set);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // "isSkillOnBottonAvailable" is broken for throw while AA is active - throwCount keeps track of throw's CD
        if (checkCounter("throwCount", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("throwCount", "-1", Valueadjust.Add);
        }
        // "isSkillOnBottonAvailable" is broken for quake while AA is active - throwCount keeps track of quake's CD
        if (checkCounter("quakeCount", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("quakeCount", "-1", Valueadjust.Add);
        }
        if (checkCounter("hit3Linger", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("hit3Linger", "-1", Valueadjust.Add);
        }
        // This is all the way down here as there are checks for noBash in VeankoAI_HB
        executeBehaviourTree("VeankoAI_HB");
        if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")||checkCounter("hit3Linger", "1", Valuecompare.GreaterOrEqual)) {
            if (checkCounter("state", "4", Valuecompare.Equal)) {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                    if (getBoolEquals("prepareToTurnAround", Yesno.Yes)) {
                        if (isTargetInArea(Yesno.Yes, 0.01D, 0.0D, 0.02D, 0.5D, Yesno.No, Yesno.Yes)) {
                            pressStick(Directions.BACKWARD, 0.1D);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.03D, 0.0D, 0.02D, 0.5D, Yesno.No, Yesno.Yes)) {
                        setBool("prepareToTurnAround", Flagtoggle.Yes);
                    } else {
                        setBool("prepareToTurnAround", Flagtoggle.No);
                    }
                }
            }
        }
        if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
            // don't waste 3rd bash if there is a chance it might hit
            if (isTargetInArea(Yesno.Yes, 0.12D, 0.0D, 0.6D, 0.32D, Yesno.No, Yesno.Yes)) {
                if (checkCounter("3rdHitTime", "4", Valuecompare.GreaterOrEqual)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.02D, 0.4D, 0.16D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.25D, 0.02D, 0.4D, 0.16D, Yesno.No, Yesno.Yes)) {
                setBool("3rdBashOnTarget", Flagtoggle.Yes);
            }
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.13D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.25D, 0.13D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)) {
                setBool("2ndTop", Flagtoggle.Yes);
                adjustCounter("2ndTopCount", "2", Valueadjust.Set);
            }
            if (checkCounter("2ndTop", "1", Valuecompare.GreaterOrEqual)) {
                adjustCounter("2ndTopCount", "-1", Valueadjust.Add);
                if (isTargetInArea(Yesno.Yes, 0.25D, 0.11D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.25D, 0.11D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
            if (isTargetInArea(Yesno.Yes, 0.25D, -0.09D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.25D, -0.09D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)) {
                setBool("2ndBot", Flagtoggle.Yes);
                adjustCounter("2ndBotCount", "2", Valueadjust.Set);
            }
            if (checkCounter("2ndBot", "1", Valuecompare.GreaterOrEqual)) {
                adjustCounter("2ndBotCount", "-1", Valueadjust.Add);
                if (isTargetInArea(Yesno.Yes, 0.25D, -0.07D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.25D, -0.07D, 0.42D, 0.02D, Yesno.No, Yesno.Yes)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
            if (isTargetInArea(Yesno.Yes, 0.49D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.49D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)) {
                setBool("2ndSide", Flagtoggle.Yes);
                adjustCounter("2ndSideCount", "2", Valueadjust.Set);
            }
            if (checkCounter("2ndSide", "1", Valuecompare.GreaterOrEqual)) {
                adjustCounter("2ndSideCount", "-1", Valueadjust.Add);
                if (isTargetInArea(Yesno.Yes, 0.47D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.47D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
        } else {
            if (isTargetInArea(Yesno.Yes, 0.2D, 0.02D, 0.3D, 0.16D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.2D, 0.02D, 0.3D, 0.16D, Yesno.No, Yesno.Yes)) {
                setBool("3rdBashOnTarget", Flagtoggle.Yes);
            }
            if (isTargetInArea(Yesno.Yes, 0.2D, 0.13D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.2D, 0.13D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)) {
                setBool("2ndTop", Flagtoggle.Yes);
                adjustCounter("2ndTopCount", "2", Valueadjust.Set);
            }
            if (checkCounter("2ndTop", "1", Valuecompare.GreaterOrEqual)) {
                adjustCounter("2ndTopCount", "-1", Valueadjust.Add);
                if (isTargetInArea(Yesno.Yes, 0.2D, 0.11D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.2D, 0.11D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
            if (isTargetInArea(Yesno.Yes, 0.2D, -0.09D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.2D, -0.09D, 0.32D, 0.02D, Yesno.No, Yesno.Yes)) {
                setBool("2ndBot", Flagtoggle.Yes);
                adjustCounter("2ndBotCount", "2", Valueadjust.Set);
            }
            if (isTargetInArea(Yesno.Yes, 0.39D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.39D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)) {
                setBool("2ndSide", Flagtoggle.Yes);
                adjustCounter("2ndSideCount", "2", Valueadjust.Set);
            }
            if (checkCounter("2ndSide", "1", Valuecompare.GreaterOrEqual)) {
                adjustCounter("2ndSideCount", "-1", Valueadjust.Add);
                if (isTargetInArea(Yesno.Yes, 0.37D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)||isTargetInArea(Yesno.Yes, -0.37D, 0.02D, 0.02D, 0.17D, Yesno.No, Yesno.Yes)) {
                    setBool("3rdBashOnTarget", Flagtoggle.Yes);
                }
            }
        }
        if (checkCounter("noBack", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("noBack", "-1", Valueadjust.Add);
        }
        if (getBoolEquals("tapBash", Yesno.No)) {
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.12D, 0.2D, Yesno.No, Yesno.Yes)) {
                    setBool("tapBash", Flagtoggle.Yes);
                }
            }
            if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.22D, 0.2D, Yesno.No, Yesno.Yes)) {
                    setBool("tapBash", Flagtoggle.Yes);
                }
            }
        }
        if (checkCounter("state", "4", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (checkCounter("state", "8", Valuecompare.Equal)) {
                    if (isTargetInArea(Yesno.Yes, -0.3D, 0.0D, 0.6D, 0.4D, Yesno.No, Yesno.Yes)) {
                        if (getBoolEquals("tapBash", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.No, Yesno.Yes)) {
                        if (getBoolEquals("tapBash", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            } else {
                if (checkCounter("state", "8", Valuecompare.Equal)) {
                    if (isTargetInArea(Yesno.Yes, -0.25D, 0.0D, 0.5D, 0.3D, Yesno.No, Yesno.Yes)) {
                        if (getBoolEquals("tapBash", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.5D, Yesno.No, Yesno.Yes)) {
                        if (getBoolEquals("tapBash", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            }
                        } else {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.3D, Yesno.No, Yesno.Yes)) {
                    if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                        if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    } else {
                        if (checkCounter("Hit3Linger", "1", Valuecompare.GreaterOrEqual)||isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
        // 3rd Bash
        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
            if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
                if (getBoolEquals("noBash", Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.02D, 0.46D, 0.17D, Yesno.Yes, Yesno.No)) {
                            if (getBoolEquals("tapBash", Yesno.Yes)) {
                                // tap
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            } else {
                                // hold down
                                pressButton(Buttons.FACE_LEFT, 0.1D);
                            }
                            adjustCounter("hit3Linger", "4", Valueadjust.Set);
                        }
                    } else {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.18D, 0.02D, 0.36D, 0.17D, Yesno.Yes, Yesno.No)) {
                            if (getBoolEquals("tapBash", Yesno.Yes)) {
                                // tap
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            } else {
                                // hold down
                                pressButton(Buttons.FACE_LEFT, 0.1D);
                            }
                            adjustCounter("hit3Linger", "4", Valueadjust.Set);
                        }
                    }
                    if (getBoolEquals("3rdBashOnTarget", Yesno.Yes)) {
                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        adjustCounter("hit3Linger", "4", Valueadjust.Set);
                        if (getBoolEquals("tapBash", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                // tap
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        } else {
                            // hold down
                            pressButton(Buttons.FACE_LEFT, 0.1D);
                        }
                    }
                }
            } else {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.Yes)) {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            if (checkCounter("throwCount", "0", Valuecompare.LessOrEqual)) {
                                setBool("noBashNextTick", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
        }
        setBool("hop", Flagtoggle.No);
        // Keep a constant Bash rythm going
        if (isTargetInArea(Yesno.Yes, 0.0D, -0.1D, 1.0D, 0.5D, Yesno.No, Yesno.Yes)) {
            if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
            } else {
                if (getBoolEquals("noBash", Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.Yes, "BruteHit2")) {
                        setBool("hop", Flagtoggle.Yes);
                    }
                    if (getBoolEquals("tapBash", Yesno.Yes)) {
                        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                            // tap
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    } else {
                        // hold down
                        pressButton(Buttons.FACE_LEFT, 0.1D);
                    }
                }
            }
        }
        // reset noBash for next tick
        setBool("noBash", Flagtoggle.No);
        // reset tapBash for next tick
        setBool("tapBash", Flagtoggle.No);
        // allowed to buy items
        if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
            // Upgrades
            if (isInNamedArea("REGENHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                // Every time Skolldir spawns, determine whether or not to rush AA/Snare Quake. Can edit the likelyhood of each event by changing each random block.
                if (once()) {
                    if (random("3")) {
                        setBool("rushAA", Flagtoggle.No);
                    } else {
                        setBool("rushAA", Flagtoggle.Yes);
                        // use flaming fist instead of meat
                        if (random("3")) {
                            setBool("useRange", Flagtoggle.No);
                        } else {
                            setBool("useRange", Flagtoggle.Yes);
                        }
                    }
                    if (random("4")) {
                        setBool("rushSnareQuake", Flagtoggle.Yes);
                    } else {
                        setBool("rushSnareQuake", Flagtoggle.No);
                    }
                }
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (random("4")&&timer(Timeunits.Seconds, 10.0D, Yesno.Yes)) {
                        // Small chance of earlier pills, but buy certain abilities first
                        if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage2")) {
                            if (isUpgradeEnabled(Yesno.Yes, "AddHealth1")) {
                                if (isUpgradeEnabled(Yesno.Yes, "BruteStampSnare")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "AddHealth2")) {
                                        if (isUpgradeEnabled(Yesno.Yes, "AddHealth3")) {
                                        } else {
                                            if (canPayUpgrade("AddHealth3")) {
                                                buyUpgrade("AddHealth3");
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("AddHealth2")) {
                                            buyUpgrade("AddHealth2");
                                        }
                                    }
                                }
                            } else {
                                if (canPayUpgrade("AddHealth1")) {
                                    buyUpgrade("AddHealth1");
                                }
                            }
                        }
                        if (((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")&&isUpgradeEnabled(Yesno.Yes, "healthRegen1"))&&isUpgradeEnabled(Yesno.No, "healthRegen2"))&&isUpgradeEnabled(Yesno.Yes, "BruteStampSnare")) {
                            if (canPayUpgrade("healthRegen2")) {
                                buyUpgrade("healthRegen2");
                            }
                        }
                    }
                }
                if (isUpgradeEnabled(Yesno.Yes, "BruteThrow")) {
                    if (((checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)||isUpgradeEnabled(Yesno.Yes, "BruteStamp"))||isUpgradeEnabled(Yesno.Yes, "healthRegen1"))||isUpgradeEnabled(Yesno.Yes, "PiggyBank")) {
                        if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndStun")) {
                            if (isUpgradeEnabled(Yesno.Yes, "BruteStamp")) {
                                if ((checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)||isUpgradeEnabled(Yesno.Yes, "PiggyBank"))||isUpgradeEnabled(Yesno.Yes, "healthRegen1")) {
                                    if (isUpgradeEnabled(Yesno.Yes, "BruteSpeed")||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                                        // AA rush
                                        if (getBoolEquals("rushAA", Yesno.No)) {
                                            // snare rush
                                            if (getBoolEquals("rushSnareQuake", Yesno.No)) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage1")) {
                                                } else {
                                                    if (canPayUpgrade("BruteThrowDamage1")) {
                                                        buyUpgrade("BruteThrowDamage1");
                                                    }
                                                }
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowDamage2")) {
                                                } else {
                                                    if (canPayUpgrade("BruteThrowDamage2")) {
                                                        buyUpgrade("BruteThrowDamage2");
                                                    }
                                                }
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome")) {
                                                } else {
                                                    if (canPayUpgrade("BruteThrowGnome")) {
                                                        buyUpgrade("BruteThrowGnome");
                                                    }
                                                }
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteThrowGnome2")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage1")) {
                                                    } else {
                                                        if (canPayUpgrade("BruteHitEndDamage1")) {
                                                            buyUpgrade("BruteHitEndDamage1");
                                                        }
                                                    }
                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage2")) {
                                                    } else {
                                                        if (canPayUpgrade("BruteHitEndDamage2")) {
                                                            buyUpgrade("BruteHitEndDamage2");
                                                        }
                                                    }
                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteStampSnare")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BruteThrowSpeedup")||isUpgradeEnabled(Yesno.Yes, "BruteThrowDistance")) {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage1")||isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage2")||isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage3")||isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                                                        if (isUpgradeEnabled(Yesno.Yes, "BruteStampDamage1")||isUpgradeEnabled(Yesno.Yes, "BruteStampHeight")) {
                                                                            if (isUpgradeEnabled(Yesno.Yes, "BruteStampDamage2")||isUpgradeEnabled(Yesno.Yes, "BruteStampHeight")) {
                                                                                if (isUpgradeEnabled(Yesno.Yes, "BruteStampRange")||isUpgradeEnabled(Yesno.Yes, "BruteStampReset")) {
                                                                                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "AddHealth1")) {
                                                                                        } else {
                                                                                            if (canPayUpgrade("AddHealth1")) {
                                                                                                buyUpgrade("AddHealth1");
                                                                                            }
                                                                                        }
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "AddHealth2")) {
                                                                                        } else {
                                                                                            if (canPayUpgrade("AddHealth2")) {
                                                                                                buyUpgrade("AddHealth2");
                                                                                            }
                                                                                        }
                                                                                        if (isUpgradeEnabled(Yesno.Yes, "AddHealth3")) {
                                                                                            if (isUpgradeEnabled(Yesno.Yes, "PiggyBank")||isUpgradeEnabled(Yesno.Yes, "healthRegen2")) {
                                                                                            } else {
                                                                                                if (canPayUpgrade("healthRegen2")) {
                                                                                                    buyUpgrade("healthRegen2");
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (canPayUpgrade("AddHealth3")) {
                                                                                                buyUpgrade("AddHealth3");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (random("2")) {
                                                                                        if (canPayUpgrade("BruteStampRange")) {
                                                                                            buyUpgrade("BruteStampRange");
                                                                                        } else {
                                                                                            if (canPayUpgrade("BruteStampReset")) {
                                                                                                buyUpgrade("BruteStampReset");
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (canPayUpgrade("BruteStampReset")) {
                                                                                            buyUpgrade("BruteStampReset");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BruteStampDamage2")) {
                                                                                    buyUpgrade("BruteStampDamage2");
                                                                                }
                                                                            }
                                                                        } else {
                                                                            if (((((((((doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Cowboy")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Jetter"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Heavy"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Butterfly"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Bird"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Assassin"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Spy"))||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Shaman")) {
                                                                                if (canPayUpgrade("BruteStampHeight")) {
                                                                                    buyUpgrade("BruteStampHeight");
                                                                                }
                                                                            } else {
                                                                                if (canPayUpgrade("BruteStampDamage1")) {
                                                                                    buyUpgrade("BruteStampDamage1");
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (canPayUpgrade("BruteHitDamage3")) {
                                                                            buyUpgrade("BruteHitDamage3");
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("BruteHitDamage2")) {
                                                                        buyUpgrade("BruteHitDamage2");
                                                                    }
                                                                }
                                                            } else {
                                                                if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")) {
                                                                    if (canPayUpgrade("BruteHitFurther")) {
                                                                        buyUpgrade("BruteHitFurther");
                                                                    }
                                                                } else {
                                                                    if (canPayUpgrade("BruteHitDamage1")) {
                                                                        buyUpgrade("BruteHitDamage1");
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Tank")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                                                                if (canPayUpgrade("BruteThrowDistance")) {
                                                                    buyUpgrade("BruteThrowDistance");
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BruteThrowSpeedup")) {
                                                                    buyUpgrade("BruteThrowSpeedup");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (canPayUpgrade("BruteStampSnare")) {
                                                            buyUpgrade("BruteStampSnare");
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BruteThrowGnome2")) {
                                                        buyUpgrade("BruteThrowGnome2");
                                                    }
                                                }
                                            } else {
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteStampSnare")) {
                                                    setBool("rushSnareQuake", Flagtoggle.No);
                                                } else {
                                                    if (canPayUpgrade("BruteStampSnare")) {
                                                        buyUpgrade("BruteStampSnare");
                                                    }
                                                }
                                            }
                                        } else {
                                            if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage1")) {
                                                if (isUpgradeEnabled(Yesno.Yes, "BruteHitEndDamage2")) {
                                                    if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage1")||isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                                        if (isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                                            setBool("rushAA", Flagtoggle.No);
                                                        } else {
                                                            if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage2")) {
                                                                if (isUpgradeEnabled(Yesno.Yes, "BruteHitDamage3")) {
                                                                    setBool("rushAA", Flagtoggle.No);
                                                                } else {
                                                                    if (canPayUpgrade("BruteHitDamage3")) {
                                                                        buyUpgrade("BruteHitDamage3");
                                                                    }
                                                                }
                                                            } else {
                                                                if (canPayUpgrade("BruteHitDamage2")) {
                                                                    buyUpgrade("BruteHitDamage2");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Brute")||getBoolEquals("useRange", Yesno.Yes)) {
                                                            if (canPayUpgrade("BruteHitFurther")) {
                                                                buyUpgrade("BruteHitFurther");
                                                            }
                                                        } else {
                                                            if (canPayUpgrade("BruteHitDamage1")) {
                                                                buyUpgrade("BruteHitDamage1");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (canPayUpgrade("BruteHitEndDamage2")) {
                                                        buyUpgrade("BruteHitEndDamage2");
                                                    }
                                                }
                                            } else {
                                                if (canPayUpgrade("BruteHitEndDamage1")) {
                                                    buyUpgrade("BruteHitEndDamage1");
                                                }
                                            }
                                        }
                                    } else {
                                        if (canPayUpgrade("BruteSpeed")) {
                                            buyUpgrade("BruteSpeed");
                                        }
                                    }
                                } else {
                                    if (canPayUpgrade("healthRegen1")) {
                                        buyUpgrade("healthRegen1");
                                    }
                                }
                            } else {
                                if (canPayUpgrade("BruteStamp")) {
                                    buyUpgrade("BruteStamp");
                                }
                            }
                        } else {
                            if (canPayUpgrade("BruteHitEndStun")) {
                                buyUpgrade("BruteHitEndStun");
                            }
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.Gold, 1000.0D, Valuecompare.GreaterOrEqual, Targetself.Self)||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Maw")) {
                            if (canPayUpgrade("BruteStamp")) {
                                buyUpgrade("BruteStamp");
                            }
                        } else {
                            if (canPayUpgrade("PiggyBank")) {
                                buyUpgrade("PiggyBank");
                            }
                        }
                    }
                } else {
                    if (canPayUpgrade("BruteThrow")) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                            // Start with the same solar level as a player
                            adjustCharacterValue(CharactervaluesAdjustable.Gold, 37.0D, Valueadjust.Add);
                        }
                        buyUpgrade("BruteThrow");
                    }
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
            adjustCounter("stayGrounded", "5", Valueadjust.Set);
        }
        if (checkCounter("stayGrounded", "1", Valuecompare.GreaterOrEqual)) {
            if ((isOnGround(Yesno.Yes, Targetself.Self)&&isOnGround(Yesno.Yes, Targetself.Target))&&isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.42D, 0.17D, Yesno.No, Yesno.No)) {
                if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    adjustCounter("stayGrounded", "0", Valueadjust.Set);
                } else {
                    setBool("haltJump", Flagtoggle.Yes);
                    adjustCounter("stayGrounded", "-1", Valueadjust.Add);
                }
            } else {
                adjustCounter("stayGrounded", "0", Valueadjust.Set);
            }
        }
        if (getBoolEquals("haltJump", Yesno.Yes)) {
            setBool("jump", Flagtoggle.No);
        }
        if ((((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal))||checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
            adjustCounter("goHam", "0", Valueadjust.Set);
        }
        if (checkCounter("goHam", "1", Valuecompare.GreaterOrEqual)) {
            adjustCounter("goHam", "-1", Valueadjust.Add);
            setBool("MoveTowardsTarget", Flagtoggle.Yes);
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        // Don't jump unless needed when trying to kill close enemy
        if (checkCounter("state", "4", Valuecompare.Equal)) {
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.45D, 0.17D, Yesno.Yes, Yesno.Yes)) {
                setBool("jump", Flagtoggle.No);
            }
        }
        if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))&&isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.0D, 0.4D, Yesno.No, Yesno.No)) {
            if (checkCounter("hit3Linger", "1", Valuecompare.GreaterOrEqual)||isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                } else {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.22D, 0.22D, Yesno.No, Yesno.No)) {
                        if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.1D, 0.0D, 0.2D, 0.1D, Yesno.No)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.15D, 0.0D, 0.3D, 0.18D, Yesno.No, Yesno.Yes)) {
                            setBool("MoveTowardsTarget", Flagtoggle.Yes);
                            setBool("MoveAwayFromTarget", Flagtoggle.No);
                        }
                    } else {
                        setBool("MoveTowardsTarget", Flagtoggle.Yes);
                        setBool("MoveAwayFromTarget", Flagtoggle.No);
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
                            if (getBoolEquals("haltJump", Yesno.Yes)||isUpgradeEnabled(Yesno.Yes, "BruteHit3")) {
                            } else {
                                setBool("jump", Flagtoggle.Yes);
                            }
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
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.92D, 0.17D, Yesno.Yes, Yesno.Yes)) {
                    } else {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
                if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                    setBool("GoForward", Flagtoggle.Yes);
                    // check if going up
                    if (isNextWaypointPosition(Offsetposition.ABOVE)) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.92D, 0.17D, Yesno.Yes, Yesno.Yes)) {
                        } else {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                    // check walls
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)) {
                        setBool("jump", Flagtoggle.Yes);
                    } else {
                        if (isTargetType(Yesno.No, EnumSet.of(TargetGroups.CREEPS))) {
                            // check creeps
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        if (getBoolEquals("approachTurret", Yesno.No)) {
            if (isTurretInArea(EnumSet.of(Teams.ENEMY_TEAM), Valuecompare.GreaterOrEqual, 0.0D, 0.03D, 0.0D, 0.06D, 0.1D, Yesno.No)) {
                setBool("GoBack", Flagtoggle.Yes);
            }
        }
        // Handle Movement
        if (getBoolEquals("CantMove", Yesno.No)) {
            setBool("HasMoved", Flagtoggle.No);
            if (getBoolEquals("GoBack", Yesno.Yes)) {
                setBool("GoBack", Flagtoggle.No);
                if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    if (checkCounter("noBack", "0", Valuecompare.LessOrEqual)) {
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
                                if (checkCounter("noBack", "0", Valuecompare.LessOrEqual)) {
                                    pressStick(Directions.BACKWARD, 0.1D);
                                }
                            } else {
                                // check enemies
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                    if (random("3")) {
                                        setBool("DownJump", Flagtoggle.Yes);
                                    } else {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
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
                if ((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal)) {
                    if (isUpgradeEnabled(Yesno.Yes, "BruteStamp")) {
                        if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
                                // don't EQ when already close to the ground
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS, CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.15D, 0.1D, 0.2D, Yesno.No, Yesno.No)) {
                                } else {
                                    if (hasTarget(Yesno.Yes)) {
                                        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    }
                                    pressButton(Buttons.FACE_TOP, 0.0D);
                                }
                            }
                        }
                    }
                }
                setBool("GoDown", Flagtoggle.No);
            } else {
                if (getBoolEquals("GoUp", Yesno.Yes)) {
                    if (isOnGround(Yesno.No, Targetself.Self)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.92D, 0.17D, Yesno.Yes, Yesno.Yes)) {
                            } else {
                                setBool("jump", Flagtoggle.Yes);
                            }
                        }
                    }
                    setBool("GoUp", Flagtoggle.No);
                }
            }
        }
        if (((checkCounter("state", "4", Valuecompare.Equal)&&isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS)))&&isTargetPosition(Yesno.No, Offsetposition.BELOW))&&isOnGround(Yesno.No, Targetself.Target)) {
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                setBool("jump", Flagtoggle.Yes);
            } else {
                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.02D, 0.92D, 0.17D, Yesno.Yes, Yesno.Yes)) {
                    } else {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
            }
        }
        // Jump before throwing the third bash combo punch while attacking on the ground
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            if (getBoolEquals("hop", Yesno.Yes)) {
                if (getBoolEquals("noBash", Yesno.No)) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                        if (isTargetPosition(Yesno.No, Offsetposition.BELOW)) {
                            if (getBoolEquals("Jump", Yesno.No)) {
                                // greens
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                                } else {
                                    if (((checkClass(Targetself.Target, "Tank")||checkClass(Targetself.Target, "Brute"))||checkClass(Targetself.Target, "Heavy"))||isUpgradeEnabled(Yesno.Yes, "BruteHitFurther")) {
                                        setBool("jump", Flagtoggle.Yes);
                                    } else {
                                        if (checkClass(Targetself.Target, "Captain")||checkClass(Targetself.Target, "Summoner")) {
                                            pressButton(Buttons.FACE_BOTTOM, 0.09D);
                                        } else {
                                            if (checkClass(Targetself.Target, "Commando")) {
                                                pressButton(Buttons.FACE_BOTTOM, 0.08D);
                                            } else {
                                                pressButton(Buttons.FACE_BOTTOM, 0.07D);
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
        // JUMPIN
        if (getBoolEquals("DownJump", Yesno.No)) {
            if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    if (isInNamedArea("BELOWHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (timer(Timeunits.Seconds, 0.31D, Yesno.Yes)) {
                        } else {
                            pressButton(Buttons.FACE_BOTTOM, 0.1D);
                        }
                    }
                }
            }
        } else {
            setBool("DownJump", Flagtoggle.No);
            if (isInNamedArea("ABOVEHAZARDAREAENABLED", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                // downjump
                pressButton(Buttons.SHOULDER_LEFT, 0.1D);
            }
        }
        // try not to jump too high
        if (isOnGround(Yesno.No, Targetself.Self)) {
            if (checkCounter("state", "4", Valuecompare.Equal)) {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS))) {
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.8D, 0.8D, Yesno.Yes, Yesno.Yes)) {
                        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                            if (isButtonDown(Buttons.FACE_BOTTOM)) {
                                pressButton(Buttons.FACE_BOTTOM, 0.0D);
                            }
                        }
                    }
                }
            }
        }
        setBool("stayInState3", Flagtoggle.No);
        if (((isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)&&checkCounter("4", "state", Valuecompare.Equal))&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.35D, 0.1D, 0.1D, Yesno.No, Yesno.No))&&isNextWaypointInArea(0.0D, 0.45D, 0.25D, 0.1D)) {
            if (isInNamedArea("CREEP_AREA", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("CREEP_AREA", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                if (isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Target)||isInNamedArea("AREACENTER", Ownenemy.ENEMY_TEAM, Targetself.Target)) {
                    adjustCounter("3", "setState", Valueadjust.Set);
                    setBool("stayInState3", Flagtoggle.Yes);
                }
            }
        }
    }

    @Script.Sequence(blocking = true)
    void sequence0() {
        pressStick(Directions.FORWARD, 0.5D);
        wait(0.5D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
    }

    @Script.Sequence(blocking = true)
    void sequence1() {
        pressStick(Directions.BACKWARD, 0.4D);
        wait(0.4D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
        adjustCounter("throwCount", "CDInit", Valueadjust.Set);
    }

}

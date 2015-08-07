
package com.awesomescript;

import java.util.EnumSet;

public class AICreepSummonDrone
    extends Script
{


    public void onTick() {
        // Initialisatie
        if (getBoolEquals("init", Yesno.No)) {
            setBool("init", Flagtoggle.Yes);
            setBool("starting", Flagtoggle.Yes);
            adjustCounter("GroundCounter", "0", Valueadjust.Set);
            pressStick(Directions.UP, 0.1D);
            setBool("Moving", Flagtoggle.Yes);
        }
        // Resume after stun
        if (checkCharacterFlag(Characterflags.IsUnderAnyEffect, Yesno.Yes, Targetself.Self)) {
            setBool("Resume", Flagtoggle.Yes);
        } else {
            if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                if (getBoolEquals("Resume", Yesno.Yes)) {
                    setBool("JetOn", Flagtoggle.No);
                    setBool("Resume", Flagtoggle.No);
                }
            }
        }
        if (receivedMessage("DronesKill")) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        if (isUpgradeEnabled(Yesno.No, "StealthPowerup")) {
            // check for enemy
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                // fire
                pressButton(Buttons.FACE_LEFT, 0.0D);
            }
        }
        if (timePassed(Timeunits.Seconds, 2.0D)) {
            // Jump down if master is below me
            if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.02D, 0.01D, 0.03D, Yesno.No, Yesno.No)) {
                    setBool("Moving", Flagtoggle.No);
                    pressStick(Directions.DOWN, 0.1D);
                    pressButton(Buttons.FACE_RIGHT, 0.0D);
                } else {
                    setBool("Moving", Flagtoggle.Yes);
                }
            } else {
                setBool("Moving", Flagtoggle.Yes);
            }
        }
        // can I move?
        if (getBoolEquals("Moving", Yesno.Yes)) {
            // Reset Movements
            if (getBoolEquals("ResetMovements", Yesno.No)) {
                setBool("MoveUp", Flagtoggle.No);
                setBool("MoveDown", Flagtoggle.No);
                setBool("MoveForward", Flagtoggle.No);
                setBool("MoveBackward", Flagtoggle.No);
            }
            // turn when master is behind me
            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                if (isInArea(Yesno.No, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES, CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                    setBool("turn", Flagtoggle.Yes);
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.Yes, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.3D, Yesno.No)) {
                } else {
                    setBool("turn", Flagtoggle.Yes);
                }
            } else {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.Yes, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.25D, 0.25D, Yesno.No)) {
                }
            }
            // turning variation
            if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                if (getBoolEquals("isVertEqual", Yesno.No)) {
                    setBool("isVertEqual", Flagtoggle.Yes);
                }
            }
            if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)||isTargetPosition(Yesno.Yes, Offsetposition.HORIZONTALEQUAL)) {
                setBool("MoveUp", Flagtoggle.Yes);
            } else {
                // master is below
                if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    setBool("MoveDown", Flagtoggle.Yes);
                } else {
                    // dodge ground
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.03D, 0.02D, 0.03D, Yesno.No, Yesno.No)) {
                        setBool("MoveUp", Flagtoggle.Yes);
                    } else {
                        // stay above player
                        if (isTargetInArea(Yesno.Yes, 0.0D, -0.05D, 0.6D, 0.03D, Yesno.No, Yesno.No)) {
                            if (isUpgradeEnabled(Yesno.No, "protect")) {
                                setBool("MoveUp", Flagtoggle.Yes);
                            }
                        }
                    }
                }
            }
            if (receivedMessage("GotoEnemy")) {
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    setBool("MoveBackward", Flagtoggle.Yes);
                } else {
                    setBool("MoveForward", Flagtoggle.Yes);
                }
                setBool("Speed2", Flagtoggle.Yes);
            } else {
                if (random("1")) {
                    // do turning & moving
                    if (getBoolEquals("turn", Yesno.Yes)) {
                        setBool("turn", Flagtoggle.No);
                        setBool("MoveBackward", Flagtoggle.Yes);
                    } else {
                        setBool("MoveForward", Flagtoggle.Yes);
                    }
                }
            }
            // stay off the ground
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                setBool("MoveUp", Flagtoggle.Yes);
                adjustCounter("GroundCounter", "1", Valueadjust.Add);
                if (checkCounter("GroundCounter", "8", Valuecompare.GreaterOrEqual)) {
                    adjustCounter("GroundCounter", "0", Valueadjust.Set);
                    setBool("JetOn", Flagtoggle.No);
                    setBool("MoveUp", Flagtoggle.Yes);
                    if (checkCounter("GroundCounter", "20", Valuecompare.Greater)) {
                    }
                }
            } else {
                adjustCounter("GroundCounter", "0", Valueadjust.Set);
            }
            // Do Movements
            if (getBoolEquals("DoMovements", Yesno.No)) {
                // Do Movements
                if (getBoolEquals("DoMovements", Yesno.No)) {
                    if (getBoolEquals("MoveUp", Yesno.Yes)) {
                        pressStick(Directions.UP, 0.0D);
                    }
                    if (getBoolEquals("MoveDown", Yesno.Yes)) {
                        pressStick(Directions.DOWN, 0.0D);
                    }
                    if (getBoolEquals("MoveForward", Yesno.Yes)) {
                        pressStick(Directions.FORWARD, 0.0D);
                    }
                    if (getBoolEquals("MoveBackward", Yesno.Yes)) {
                        pressStick(Directions.BACKWARD, 0.0D);
                    }
                }
            }
        }
        if (hasTarget(Yesno.No)||isTargetInArea(Yesno.No, 0.0D, 0.0D, 3.0D, 2.5D, Yesno.No, Yesno.No)) {
            sequence0();
        }
        // Start met omhoog vliegen
        if (timePassed(Timeunits.Seconds, 0.3D)) {
        } else {
            pressStick(Directions.UP, 0.1D);
        }
        // Staat Jetpack Aan?
        if (getBoolEquals("JetOn", Yesno.No)) {
            sequence1();
        }
        if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "StealthPowerup");
            }
        } else {
            if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableUpgrade(Yesno.No, "StealthPowerup");
                // fire
                pressButton(Buttons.FACE_LEFT, 0.0D);
            }
        }
        if (receivedMessage("SummonerDroneBlind")) {
            enableUpgrade(Yesno.Yes, "SummonerDroneBlind");
        }
        if (receivedMessage("SummonerDroneFaster1")) {
            enableUpgrade(Yesno.Yes, "SummonerDroneFaster1");
        }
        if (receivedMessage("SummonerDroneFaster2")) {
            enableUpgrade(Yesno.Yes, "SummonerDroneFaster2");
        }
        if (receivedMessage("SummonerDroneDamage1")) {
            enableUpgrade(Yesno.Yes, "SummonerDroneDamage1");
        }
        if (receivedMessage("SummonerDroneDamage2")) {
            enableUpgrade(Yesno.Yes, "SummonerDroneDamage2");
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(2.1D);
        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.Yes, Yesno.No, 0.0D, 0.0D, 0.3D, 0.3D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        // activate jetpack
        pressButton(Buttons.FACE_TOP, 0.2D);
        setBool("JetOn", Flagtoggle.Yes);
    }

}

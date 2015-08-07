
package com.awesomescript;

import java.util.EnumSet;

public class AICreepPet
    extends Script
{


    public void onTick() {
        // Initialisatie
        if (getBoolEquals("init", Yesno.No)) {
            setBool("init", Flagtoggle.Yes);
            emitMessageInArea("Id1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
            setBool("starting", Flagtoggle.Yes);
            adjustCounter("GroundCounter", "0", Valueadjust.Set);
            pressStick(Directions.UP, 0.1D);
            setBool("Id1", Flagtoggle.Yes);
            setBool("Moving", Flagtoggle.Yes);
            if (isUpgradeEnabled(Yesno.Yes, "Speed1")) {
                emitMessageInArea("Speed1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
            }
            if (isUpgradeEnabled(Yesno.Yes, "Speed2")) {
                emitMessageInArea("Speed2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
            }
            if (isUpgradeEnabled(Yesno.Yes, "max1")) {
                emitMessageInArea("max1", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
            }
            if (isUpgradeEnabled(Yesno.Yes, "max2")) {
                emitMessageInArea("max2", EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 20.0D, 20.0D, Yesno.Yes, Yesno.No);
            }
        }
        // Check teamsize upgrades
        if (receivedMessage("max1")) {
            setBool("max1", Flagtoggle.Yes);
            if (receivedMessage("max2")) {
                setBool("max2", Flagtoggle.Yes);
            }
        }
        // Check speed upgrades
        if (receivedMessage("Speed1")) {
            setBool("Speed1", Flagtoggle.Yes);
            if (receivedMessage("Speed2")) {
                setBool("Speed2", Flagtoggle.Yes);
            } else {
                setBool("Speed2", Flagtoggle.No);
            }
        } else {
            setBool("Speed1", Flagtoggle.No);
            setBool("Speed2", Flagtoggle.No);
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
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.3D, Yesno.No)) {
                } else {
                    setBool("turn", Flagtoggle.Yes);
                }
            }
            // turning variation
            if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                if (getBoolEquals("isVertEqual", Yesno.No)) {
                    setBool("isVertEqual", Flagtoggle.Yes);
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.12D, 0.12D, Yesno.No)) {
                setBool("isFar", Flagtoggle.Yes);
                if (isUpgradeEnabled(Yesno.Yes, "slow")) {
                } else {
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        enableUpgrade(Yesno.Yes, "slow");
                    }
                }
            } else {
                setBool("isFar", Flagtoggle.No);
                if (isUpgradeEnabled(Yesno.Yes, "slow")) {
                    enableUpgrade(Yesno.No, "slow");
                }
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.Greater, 0.0D, "", 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No)) {
                    if (isUpgradeEnabled(Yesno.No, "fast")) {
                    } else {
                        enableUpgrade(Yesno.No, "fast");
                    }
                } else {
                    if (isUpgradeEnabled(Yesno.Yes, "fast")) {
                    } else {
                        enableUpgrade(Yesno.Yes, "fast");
                    }
                }
            }
            if (random("1")) {
                // do turning & moving
                if (getBoolEquals("turn", Yesno.Yes)) {
                    setBool("turn", Flagtoggle.No);
                    setBool("MoveBackward", Flagtoggle.Yes);
                } else {
                    setBool("MoveForward", Flagtoggle.Yes);
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
            // stay off the ground
            if (isOnGround(Yesno.Yes, Targetself.Self)) {
                adjustCounter("GroundCounter", "1", Valueadjust.Add);
                setBool("MoveUp", Flagtoggle.Yes);
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
            // die
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
        // Start met omhoog vliegen
        if (timePassed(Timeunits.Seconds, 0.3D)) {
        } else {
            pressStick(Directions.UP, 0.1D);
        }
        // Staat Jetpack Aan?
        if (getBoolEquals("JetOn", Yesno.No)) {
            sequence0();
        }
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
            adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        // activate jetpack
        pressButton(Buttons.FACE_TOP, 0.2D);
        setBool("JetOn", Flagtoggle.Yes);
    }

}


package com.awesomescript;

import java.util.EnumSet;

public class FN_RetreatingSkills_nailcliper
    extends Script
{


    public void onTick() {
        if (getBoolEquals("UseRetreatingSkills", Yesno.Yes)) {
            setBool("UseRetreatingSkills", Flagtoggle.No);
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                if (random("2")||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.39D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                    if (random("2")||checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        // bubble
                        if (isUpgradeEnabled(Yesno.Yes, "TimeBubble")) {
                            // enemy close
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES, CollisonGroups.PROJECTILES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)) {
                                // BUBBLE
                                pressButton(Buttons.FACE_TOP, 0.0D);
                            }
                        } else {
                            // stealth
                            if (isUpgradeEnabled(Yesno.Yes, "stealth")) {
                                if (checkCounter("StealthInTime", "8", Valuecompare.Greater)) {
                                    setBool("GoStealth", Flagtoggle.Yes);
                                }
                            } else {
                                // dash
                                if (isUpgradeEnabled(Yesno.Yes, "dash")) {
                                    if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                                        // enemy in nearby -> dash skill
                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.4D, Yesno.Yes, Yesno.No)) {
                                            selectTarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            if (hasTarget(Yesno.Yes)) {
                                            } else {
                                                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            }
                                            if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                                                setBool("GoUp", Flagtoggle.Yes);
                                            } else {
                                                if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                                                    setBool("GoDown", Flagtoggle.Yes);
                                                }
                                            }
                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                        }
                                    }
                                } else {
                                    // bull
                                    if (isUpgradeEnabled(Yesno.Yes, "bull")) {
                                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                            if (timer(Timeunits.Seconds, 6.0D, Yesno.No)) {
                                                sequence0();
                                            }
                                        } else {
                                            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                                pressButton(Buttons.FACE_TOP, 0.1D);
                                            }
                                        }
                                    } else {
                                        // HealTotem
                                        if (isUpgradeEnabled(Yesno.Yes, "HealTotem")) {
                                            pressButton(Buttons.FACE_TOP, 0.1D);
                                        } else {
                                            // Blaze to escape
                                            if (isUpgradeEnabled(Yesno.Yes, "Blaze")) {
                                                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, 0.0D, 1.0D, 0.6D, Yesno.Yes, Yesno.No)) {
                                                        pressButton(Buttons.FACE_TOP, 0.0D);
                                                    }
                                                }
                                            } else {
                                                // Trap to escape
                                                if (isUpgradeEnabled(Yesno.Yes, "Trap")) {
                                                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, 0.0D, 1.0D, 0.6D, Yesno.Yes, Yesno.No)) {
                                                            pressButton(Buttons.FACE_RIGHT, 0.0D);
                                                        }
                                                    }
                                                } else {
                                                    // Explode!
                                                    if (isUpgradeEnabled(Yesno.Yes, "suicide")) {
                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 10.0D, Valuecompare.Less, Targetself.Self)) {
                                                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                                                                    sequence1();
                                                                }
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Greater, Targetself.Self)) {
                                                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                                                                        sequence2();
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
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setBool("GoBack", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setBool("Exploding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setBool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setBool("Exploding", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setBool("Exploding", Flagtoggle.No);
    }

}

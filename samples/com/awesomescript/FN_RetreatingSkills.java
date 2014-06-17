
package com.awesomescript;

import java.util.EnumSet;

public class FN_RetreatingSkills
    extends Script
{


    public void onTick() {
        if (getboolequals("UseRetreatingSkills", Yesno.Yes)) {
            setbool("UseRetreatingSkills", Flagtoggle.No);
            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                if (random("2")||checkcharactervalue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)) {
                    if (random("2")||checkcharactervalue(CharactervaluesCheckable.AISkill, 0.6D, Valuecompare.Greater, Targetself.Self)) {
                        // bubble
                        if (isupgradeenabled(Yesno.Yes, "TimeBubble")) {
                            // enemy close
                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES, CollisonGroups.PROJECTILES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)) {
                                // BUBBLE
                                pressbutton(Buttons.FACE_TOP, 0.0D);
                            }
                        } else {
                            // stealth
                            if (isupgradeenabled(Yesno.Yes, "stealth")) {
                                if (checkcounter("StealthInTime", "8", Valuecompare.Greater)) {
                                    setbool("GoStealth", Flagtoggle.Yes);
                                }
                            } else {
                                // dash
                                if (isupgradeenabled(Yesno.Yes, "dash")) {
                                    if (directiontoenemybase(Forwardbackward.BACKWARD)) {
                                        // enemy in nearby -> dash skill
                                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.6D, 0.4D, Yesno.Yes, Yesno.No)) {
                                            selecttarget(EnumSet.of(TargetGroups.DESTROYABLE_OBSTACLES), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
                                            if (hastarget(Yesno.Yes)) {
                                            } else {
                                                selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.6D, 0.4D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.Yes, Yesno.No);
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
                                } else {
                                    // bull
                                    if (isupgradeenabled(Yesno.Yes, "bull")) {
                                        if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                            if (timer(Timeunits.Seconds, 6.0D, Yesno.No)) {
                                                sequence0();
                                            }
                                        } else {
                                            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.HealthMinusDot, Valuecompare.GreaterOrEqual, 0.0D, "", -0.3D, 0.0D, 0.6D, 0.6D, Yesno.No)) {
                                                pressbutton(Buttons.FACE_TOP, 0.1D);
                                            }
                                        }
                                    } else {
                                        // HealTotem
                                        if (isupgradeenabled(Yesno.Yes, "HealTotem")) {
                                            pressbutton(Buttons.FACE_TOP, 0.1D);
                                        } else {
                                            // Blaze to escape
                                            if (isupgradeenabled(Yesno.Yes, "Blaze")) {
                                                if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, 0.0D, 1.0D, 0.6D, Yesno.Yes, Yesno.No)) {
                                                        pressbutton(Buttons.FACE_RIGHT, 0.0D);
                                                    }
                                                }
                                            } else {
                                                // Trap to escape
                                                if (isupgradeenabled(Yesno.Yes, "Trap")) {
                                                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                                        if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, 0.0D, 1.0D, 0.6D, Yesno.Yes, Yesno.No)) {
                                                            pressbutton(Buttons.FACE_RIGHT, 0.0D);
                                                        }
                                                    }
                                                } else {
                                                    // Explode!
                                                    if (isupgradeenabled(Yesno.Yes, "suicide")) {
                                                        if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 10.0D, Valuecompare.Less, Targetself.Self)) {
                                                            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No, Yesno.No)) {
                                                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                                                                    sequence1();
                                                                }
                                                            } else {
                                                                if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.Greater, Targetself.Self)) {
                                                                    if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
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
        setbool("GoBack", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("Exploding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setbool("Exploding", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setbool("Exploding", Flagtoggle.Yes);
        pressbutton(Buttons.FACE_TOP, 0.1D);
        wait(2.0D);
        setbool("Exploding", Flagtoggle.No);
    }

}

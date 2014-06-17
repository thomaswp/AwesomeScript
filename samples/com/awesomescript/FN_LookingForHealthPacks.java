
package com.awesomescript;

import java.util.EnumSet;

public class FN_LookingForHealthPacks
    extends Script
{


    public void onTick() {
        if (getboolequals("LookingForHealthPacks", Yesno.Yes)) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.Less, Targetself.Self)) {
                if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 60.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                    if (hastarget(Yesno.Yes)) {
                        adjustcounter("state", "3", Valueadjust.Set);
                        selecttargetwaypoint();
                    }
                }
            }
            setbool("FoundHealthPack", Flagtoggle.No);
            // first
            if (isinnamedarea("AREAFIRST", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (ispickupatwaypoint("FIRSTHP", Ownenemy.OWN_TEAM)) {
                    selectdestwaypoint("FIRSTHP", Ownenemy.OWN_TEAM);
                    setbool("FoundHealthPack", Flagtoggle.Yes);
                }
            } else {
                // upper lane
                if (isinnamedarea("AREAUPPER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (ispickupatwaypoint("UPPERHP", Ownenemy.OWN_TEAM)) {
                        selectdestwaypoint("UPPERHP", Ownenemy.OWN_TEAM);
                        setbool("FoundHealthPack", Flagtoggle.Yes);
                    }
                } else {
                    // bottom lane
                    if (isinnamedarea("AREABOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (ispickupatwaypoint("BOTTOMHP", Ownenemy.OWN_TEAM)) {
                            selectdestwaypoint("BOTTOMHP", Ownenemy.OWN_TEAM);
                            setbool("FoundHealthPack", Flagtoggle.Yes);
                        }
                    } else {
                        // center
                        if (isinnamedarea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (ispickupatwaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No, Yesno.No)||checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.Greater, Targetself.Self)) {
                                    selectdestwaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                    setbool("FoundHealthPack", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            // center bottom
                            if (isinnamedarea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (ispickupatwaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM)) {
                                    log("GETTING CENTERBOTTOMHP", "", "");
                                    selectdestwaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM);
                                    setbool("FoundHealthPack", Flagtoggle.Yes);
                                }
                            } else {
                                // enemy bottom
                                if (isinnamedarea("AREABOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    if (ispickupatwaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM)) {
                                        log("GETTING BOTTOMHP", "", "");
                                        selectdestwaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM);
                                        setbool("FoundHealthPack", Flagtoggle.Yes);
                                    }
                                } else {
                                    // enemy upper
                                    if (isinnamedarea("AREAUPPER", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        if (getboolequals("enemyTower1Lane1", Yesno.No)) {
                                            if (getboolequals("enemyTower2Lane1", Yesno.No)) {
                                                if (ispickupatwaypoint("UPPERHP", Ownenemy.ENEMY_TEAM)) {
                                                    log("GETTING UPPERHP", "", "");
                                                    selectdestwaypoint("UPPERHP", Ownenemy.ENEMY_TEAM);
                                                    setbool("FoundHealthPack", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (ispickupatwaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                    log("GETTING CENTERHP", "", "");
                                                    selectdestwaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                    setbool("FoundHealthPack", Flagtoggle.Yes);
                                                }
                                            }
                                        } else {
                                            if (ispickupatwaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                log("GETTING CENTERHP", "", "");
                                                selectdestwaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                setbool("FoundHealthPack", Flagtoggle.Yes);
                                            }
                                        }
                                    } else {
                                        if (isinnamedarea("AREAFIRST", Ownenemy.ENEMY_TEAM, Targetself.Self)||isinnamedarea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                            if (ispickupatwaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM)) {
                                                log("GETTING FIRSTHP", "", "");
                                                selectdestwaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM);
                                                setbool("FoundHealthPack", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (getboolequals("FoundHealthPack", Yesno.No)) {
                selectdestwaypoint("REGENHOME", Ownenemy.OWN_TEAM);
            }
            setbool("LookingForHealthPacks", Flagtoggle.No);
        }
    }

}

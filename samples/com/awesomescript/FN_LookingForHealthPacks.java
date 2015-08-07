
package com.awesomescript;

import java.util.EnumSet;

public class FN_LookingForHealthPacks
    extends Script
{


    public void onTick() {
        if (getBoolEquals("LookingForHealthPacks", Yesno.Yes)) {
            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.Less, Targetself.Self)) {
                if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 60.0D, "1", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                    selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "Summoner", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 60.0D, DistanceCheck.NONE, Yesno.No, Yesno.Yes);
                    if (hasTarget(Yesno.Yes)) {
                        adjustCounter("state", "3", Valueadjust.Set);
                        selectTargetWaypoint();
                    }
                }
            }
            setBool("FoundHealthPack", Flagtoggle.No);
            // first
            if (isInNamedArea("AREAFIRST", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isPickupAtWaypoint("FIRSTHP", Ownenemy.OWN_TEAM)) {
                    selectDestWaypoint("FIRSTHP", Ownenemy.OWN_TEAM);
                    setBool("FoundHealthPack", Flagtoggle.Yes);
                }
            } else {
                // upper lane
                if (isInNamedArea("AREAUPPER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (isPickupAtWaypoint("UPPERHP", Ownenemy.OWN_TEAM)) {
                        selectDestWaypoint("UPPERHP", Ownenemy.OWN_TEAM);
                        setBool("FoundHealthPack", Flagtoggle.Yes);
                    }
                } else {
                    // bottom lane
                    if (isInNamedArea("AREABOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (isPickupAtWaypoint("BOTTOMHP", Ownenemy.OWN_TEAM)) {
                            selectDestWaypoint("BOTTOMHP", Ownenemy.OWN_TEAM);
                            setBool("FoundHealthPack", Flagtoggle.Yes);
                        }
                    } else {
                        // center
                        if (isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No, Yesno.No)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.Greater, Targetself.Self)) {
                                    selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                }
                            }
                        } else {
                            // center bottom
                            if (isInNamedArea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isPickupAtWaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM)) {
                                    log("GETTING CENTERBOTTOMHP", "", "");
                                    selectDestWaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM);
                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                }
                            } else {
                                // enemy bottom
                                if (isInNamedArea("AREABOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    if (isPickupAtWaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM)) {
                                        log("GETTING BOTTOMHP", "", "");
                                        selectDestWaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM);
                                        setBool("FoundHealthPack", Flagtoggle.Yes);
                                    }
                                } else {
                                    // enemy upper
                                    if (isInNamedArea("AREAUPPER", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                        if (getBoolEquals("enemyTower1Lane1", Yesno.No)) {
                                            if (getBoolEquals("enemyTower2Lane1", Yesno.No)) {
                                                if (isPickupAtWaypoint("UPPERHP", Ownenemy.ENEMY_TEAM)) {
                                                    log("GETTING UPPERHP", "", "");
                                                    selectDestWaypoint("UPPERHP", Ownenemy.ENEMY_TEAM);
                                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                                }
                                            } else {
                                                if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                    log("GETTING CENTERHP", "", "");
                                                    selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                                }
                                            }
                                        } else {
                                            if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                log("GETTING CENTERHP", "", "");
                                                selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                setBool("FoundHealthPack", Flagtoggle.Yes);
                                            }
                                        }
                                    } else {
                                        if (isInNamedArea("AREAFIRST", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                            if (isPickupAtWaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM)) {
                                                log("GETTING FIRSTHP", "", "");
                                                selectDestWaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM);
                                                setBool("FoundHealthPack", Flagtoggle.Yes);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("FoundHealthPack", Yesno.No)) {
                selectDestWaypoint("REGENHOME", Ownenemy.OWN_TEAM);
            }
            setBool("LookingForHealthPacks", Flagtoggle.No);
        }
    }

}

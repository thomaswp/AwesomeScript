
package com.awesomescript;

import java.util.EnumSet;

public class VeankoLookingForHealthPacks
    extends Script
{


    public void onTick() {
        if (getBoolEquals("LookingForHealthPacks", Yesno.Yes)) {
            // first
            if (isInNamedArea("AREAFIRST", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isPickupAtWaypoint("FIRSTHP", Ownenemy.OWN_TEAM)) {
                    selectDestWaypoint("FIRSTHP", Ownenemy.OWN_TEAM);
                    setBool("FoundHealthPack", Flagtoggle.Yes);
                } else {
                    setBool("FoundHealthPack", Flagtoggle.No);
                }
            } else {
                // upper lane
                if (isInNamedArea("AREAUPPER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    if (isPickupAtWaypoint("UPPERHP", Ownenemy.OWN_TEAM)) {
                        selectDestWaypoint("UPPERHP", Ownenemy.OWN_TEAM);
                        setBool("FoundHealthPack", Flagtoggle.Yes);
                    } else {
                        setBool("FoundHealthPack", Flagtoggle.No);
                    }
                } else {
                    // bottom lane
                    if (isInNamedArea("AREABOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (isPickupAtWaypoint("BOTTOMHP", Ownenemy.OWN_TEAM)) {
                            selectDestWaypoint("BOTTOMHP", Ownenemy.OWN_TEAM);
                            setBool("FoundHealthPack", Flagtoggle.Yes);
                        } else {
                            setBool("FoundHealthPack", Flagtoggle.No);
                        }
                    } else {
                        // center
                        if (isInNamedArea("AREACENTER", Ownenemy.OWN_TEAM, Targetself.Self)) {
                            if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 0.35D, 0.35D, Yesno.No, Yesno.No)||checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.Greater, Targetself.Self)) {
                                    selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                }
                            } else {
                                setBool("FoundHealthPack", Flagtoggle.No);
                            }
                        } else {
                            // center bottom
                            if (isInNamedArea("AREACENTERBOTTOM", Ownenemy.OWN_TEAM, Targetself.Self)) {
                                if (isPickupAtWaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM)) {
                                    log("GETTING CENTERBOTTOMHP", "", "");
                                    selectDestWaypoint("CENTERBOTTOMHP", Ownenemy.OWN_TEAM);
                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                } else {
                                    setBool("FoundHealthPack", Flagtoggle.No);
                                }
                            } else {
                                // enemy bottom
                                if (isInNamedArea("AREABOTTOM", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                    if (isPickupAtWaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM)) {
                                        log("GETTING BOTTOMHP", "", "");
                                        selectDestWaypoint("BOTTOMHP", Ownenemy.ENEMY_TEAM);
                                        setBool("FoundHealthPack", Flagtoggle.Yes);
                                    } else {
                                        setBool("FoundHealthPack", Flagtoggle.No);
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
                                                } else {
                                                    setBool("FoundHealthPack", Flagtoggle.No);
                                                }
                                            } else {
                                                if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                    log("GETTING CENTERHP", "", "");
                                                    selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                    setBool("FoundHealthPack", Flagtoggle.Yes);
                                                } else {
                                                    setBool("FoundHealthPack", Flagtoggle.No);
                                                }
                                            }
                                        } else {
                                            if (isPickupAtWaypoint("CENTERHP", Ownenemy.OWN_TEAM)) {
                                                log("GETTING CENTERHP", "", "");
                                                selectDestWaypoint("CENTERHP", Ownenemy.OWN_TEAM);
                                                setBool("FoundHealthPack", Flagtoggle.Yes);
                                            } else {
                                                setBool("FoundHealthPack", Flagtoggle.No);
                                            }
                                        }
                                    } else {
                                        if (isInNamedArea("AREAFIRST", Ownenemy.ENEMY_TEAM, Targetself.Self)||isInNamedArea("AREAHOME", Ownenemy.ENEMY_TEAM, Targetself.Self)) {
                                            if (isPickupAtWaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM)) {
                                                log("GETTING FIRSTHP", "", "");
                                                selectDestWaypoint("FIRSTHP", Ownenemy.ENEMY_TEAM);
                                                setBool("FoundHealthPack", Flagtoggle.Yes);
                                            } else {
                                                setBool("FoundHealthPack", Flagtoggle.No);
                                            }
                                        } else {
                                            setBool("FoundHealthPack", Flagtoggle.No);
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


package com.awesomescript;

import java.util.EnumSet;

public class DangerousNauts_Flawless
    extends Script
{


    public void onTick() {
        setBool("DangerousRaelynn", Flagtoggle.No);
        setBool("DangerousSentry", Flagtoggle.No);
        setBool("DangerousFroggy", Flagtoggle.No);
        setBool("DangerousAyla", Flagtoggle.No);
        setBool("DangerousClunk", Flagtoggle.No);
        setBool("DangerousYuri", Flagtoggle.No);
        setBool("DangerousDerpl", Flagtoggle.No);
        setBool("DangerousNaut", Flagtoggle.No);
        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Tank", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                // Explode
                if (hasUpgrade("Tank", Teamswithnumbers.ENEMY_TEAM, "TankExploding")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    setBool("DangerousClunk", Flagtoggle.Yes);
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Vampire", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.5D, 1.5D, Yesno.No)) {
                if (hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodThirstON")||hasUpgrade("Vampire", Teamswithnumbers.ENEMY_TEAM, "VampireBloodThirstSpeedON")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    setBool("DangerousAyla", Flagtoggle.Yes);
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Heavy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)||checkClass(Targetself.Target, "Heavy")) {
                if (hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "SIEGEMODEON")||hasUpgrade("Heavy", Teamswithnumbers.ENEMY_TEAM, "siegeshield")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    setBool("DangerousDerpl", Flagtoggle.Yes);
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Dasher", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)||checkClass(Targetself.Target, "Dasher")) {
                // Whilrwind
                if (hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    setBool("DangerousFroggy", Flagtoggle.Yes);
                }
            }
            if (checkClass(Targetself.Target, "Hunter")||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Hunter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                if (hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterPressSnipe")||hasUpgrade("Hunter", Teamswithnumbers.ENEMY_TEAM, "HunterSnipeReady")) {
                    setBool("DangerousNaut", Flagtoggle.Yes);
                    setBool("DangerousRaelynn", Flagtoggle.Yes);
                }
            }
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Spy", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 20.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)||checkClass(Targetself.Target, "Spy")) {
                // Absorb Shield
                if (hasUpgrade("Spy", Teamswithnumbers.ENEMY_TEAM, "SpyAbsorbStartOn")) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 10.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            } else {
                                setBool("DangerousNaut", Flagtoggle.Yes);
                                setBool("DangerousSentry", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        setBool("DangerousNaut", Flagtoggle.Yes);
                        setBool("DangerousSentry", Flagtoggle.Yes);
                    }
                }
            }
            if (checkClass(Targetself.Target, "Jetter")||isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Jetter", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 20.0D, "", 0.0D, 0.0D, 2.0D, 2.0D, Yesno.No)) {
                // Time Bubble
                if (hasUpgrade("Jetter", Teamswithnumbers.ENEMY_TEAM, "TimeBubble")) {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.GreaterOrEqual, 30.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes)) {
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 10.0D, Valuecompare.LessOrEqual, Targetself.Target)) {
                            } else {
                                setBool("DangerousNaut", Flagtoggle.Yes);
                                setBool("DangerousYuri", Flagtoggle.Yes);
                            }
                        }
                    } else {
                        setBool("DangerousNaut", Flagtoggle.Yes);
                        setBool("DangerousYuri", Flagtoggle.Yes);
                    }
                }
            }
        }
    }

}

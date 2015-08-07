
package com.awesomescript;

import java.util.EnumSet;

public class FN_HurleySwigsFindAndTargetEnemiesShortRange
    extends Script
{


    public void onTick() {
        setBool("EnemyFound", Flagtoggle.No);
        if (getBoolEquals("IgnoreEnemies", Yesno.No)) {
            removeTarget();
            // Any Enemies?
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.8D, 1.8D, Yesno.No)) {
                // Priority 1: Summoner
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.7D, 0.7D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                if (hasTarget(Yesno.No)) {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                        // Players + hidden area
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.8D, 1.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                        // Players with low health
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.1D, 1.1D, Valuecompare2 .LessOrEqual, 50.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                        // Players with critical health
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .LessOrEqual, 40.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                        // Players with critical health
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.7D, 0.7D, Valuecompare2 .LessOrEqual, 30.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                        // Players with critical health
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.5D, 0.5D, Valuecompare2 .LessOrEqual, 20.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
                    } else {
                        // Players, ignore hidden
                        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.8D, 1.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    }
                    if (hasTarget(Yesno.Yes)) {
                        if (checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Target)) {
                            sequence0();
                        }
                    }
                    if (hasTarget(Yesno.No)) {
                        // Priority 3: Creeps
                        selectTarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.5D, 1.5D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hasTarget(Yesno.Yes)) {
                            setBool("EnemyFound", Flagtoggle.Yes);
                            // chaseBattle (4)
                            adjustCounter("setState", "4", Valueadjust.Set);
                        }
                    } else {
                        setBool("EnemyFound", Flagtoggle.Yes);
                        // chaseBattle (4)
                        adjustCounter("setState", "4", Valueadjust.Set);
                    }
                } else {
                    setBool("EnemyFound", Flagtoggle.Yes);
                    // chaseBattle (4)
                    adjustCounter("setState", "4", Valueadjust.Set);
                }
            }
            if (hasTarget(Yesno.Yes)) {
                setBool("EnemyFound", Flagtoggle.Yes);
                // chaseBattle(4)
                adjustCounter("setState", "4", Valueadjust.Set);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        executeBehaviourTree("FN_HurleyDOTCheck");
        if ((((((checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Target)||checkCharacterFlag(Characterflags.IsSlowed, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsSilenced, Yesno.Yes, Targetself.Target))||checkCharacterFlag(Characterflags.IsStunned, Yesno.Yes, Targetself.Target))||getBoolEquals("targetHasDot", Yesno.Yes))||isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepCaptainChain", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.65D, 0.65D, Yesno.No))||checkCounter("stealthCheck", "15", Valuecompare.GreaterOrEqual)) {
            if (checkCounter("stealthCheck", "0", Valuecompare.Greater)) {
                adjustCounter("stealthCheck", "-1", Valueadjust.Add);
            }
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.59D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                sequence1();
            } else {
                removeTarget();
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        if (checkCounter("stealthCheck", "40", Valuecompare.Greater)) {
            adjustCounter("stealthCheck", "40", Valueadjust.Set);
        }
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.25D, 0.25D, Yesno.No, Yesno.Yes)) {
            adjustCounter("stealthCheck", "2", Valueadjust.Add);
        }
        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.Yes)) {
            adjustCounter("stealthCheck", "1", Valueadjust.Add);
        } else {
            adjustCounter("stealthCheck", "0", Valueadjust.Set);
        }
        removeTarget();
        if (checkCounter("stealthCheck", "30", Valuecompare.GreaterOrEqual)) {
            if (random("8")) {
                sequence2();
            }
        }
        // If touching swigs, target
        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.12D, 0.15D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
        if (hasTarget(Yesno.Yes)) {
        } else {
            // Players, ignore hidden
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.8D, 1.8D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
            // Players with low health
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 1.1D, 1.1D, Valuecompare2 .LessOrEqual, 50.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
            // Players with critical health
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.9D, 0.9D, Valuecompare2 .LessOrEqual, 40.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
            // Players with critical health
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.7D, 0.7D, Valuecompare2 .LessOrEqual, 30.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
            // Players with critical health
            selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.5D, 0.5D, Valuecompare2 .LessOrEqual, 20.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        // close stealthed players
        selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.Yes);
    }

}

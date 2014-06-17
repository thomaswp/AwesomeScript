
package com.awesomescript;

import java.util.EnumSet;

public class FN_FindAndTargetEnemiesShortRange
    extends Script
{


    public void onTick() {
        setbool("EnemyFound", Flagtoggle.No);
        if (getboolequals("IgnoreEnemies", Yesno.No)) {
            removetarget();
            // Any Enemies?
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS, TargetReceiveGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.No)) {
                // Priority 1: Summoner
                selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "Summoner", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                if (hastarget(Yesno.No)) {
                    // Priority 2: Players
                    selecttarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                    if (hastarget(Yesno.No)) {
                        // Priority 3: Creeps
                        selecttarget(EnumSet.of(TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 1.0D, 1.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
                        if (hastarget(Yesno.Yes)) {
                            setbool("EnemyFound", Flagtoggle.Yes);
                            // chaseBattle (4)
                            adjustcounter("setState", "4", Valueadjust.Set);
                        }
                    } else {
                        setbool("EnemyFound", Flagtoggle.Yes);
                        // chaseBattle (4)
                        adjustcounter("setState", "4", Valueadjust.Set);
                    }
                } else {
                    setbool("EnemyFound", Flagtoggle.Yes);
                    // chaseBattle (4)
                    adjustcounter("setState", "4", Valueadjust.Set);
                }
            }
            if (hastarget(Yesno.Yes)) {
                // chaseBattle(4)
                adjustcounter("setState", "4", Valueadjust.Set);
            }
        }
    }

}

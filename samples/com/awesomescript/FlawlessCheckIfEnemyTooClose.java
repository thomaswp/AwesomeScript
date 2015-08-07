
package com.awesomescript;

import java.util.EnumSet;

public class FlawlessCheckIfEnemyTooClose
    extends Script
{


    public void onTick() {
        setBool("EnemyIsTooClose", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Assassin")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.1D, 0.02D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Brute")) {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.25D, Valuecompare.Less, Targetself.Self)) {
                // too close
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.0D, 0.0D, Yesno.Yes, Yesno.No)) {
                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                }
            } else {
                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.PLAYERS))) {
                } else {
                    // too close
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.1D, 0.1D, Yesno.Yes, Yesno.No)) {
                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (checkClass(Targetself.Self, "Paladin")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.03D, 0.0D, 0.06D, 0.02D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Butterfly")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.15D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
    }

}

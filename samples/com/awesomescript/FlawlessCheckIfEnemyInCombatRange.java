
package com.awesomescript;


public class FlawlessCheckIfEnemyInCombatRange
    extends Script
{


    public void onTick() {
        setBool("EnemyIsInCombatRange", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Brute")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.1D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Assassin")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.08D, 0.0D, 0.16D, 0.08D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Paladin")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.08D, 0.0D, 0.16D, 0.08D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Butterfly")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
    }

}

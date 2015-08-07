
package com.awesomescript;


public class SuperFroggyCheckIfEnemyInCombatRange
    extends Script
{


    public void onTick() {
        setBool("EnemyIsInCombatRange", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Chameleon")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Cowboy")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.3D, 0.1D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Dasher")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Tank")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Vampire")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Maw")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Shaman")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Hunter")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
    }

}

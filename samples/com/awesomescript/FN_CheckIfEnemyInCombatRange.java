
package com.awesomescript;


public class FN_CheckIfEnemyInCombatRange
    extends Script
{


    public void onTick() {
        setbool("EnemyIsInCombatRange", Flagtoggle.No);
        if (checkclass(Targetself.Self, "Chameleon")) {
            // in range
            if (istargetinarea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                setbool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Cowboy")) {
            // in range
            if (istargetinarea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                setbool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Dasher")) {
            // in range
            if (istargetinarea(Yesno.Yes, 0.22D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setbool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Tank")) {
            // in range
            if (istargetinarea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setbool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
    }

}

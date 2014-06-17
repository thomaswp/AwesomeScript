
package com.awesomescript;


public class FN_CheckIfEnemyTooClose
    extends Script
{


    public void onTick() {
        setbool("EnemyIsTooClose", Flagtoggle.No);
        if (checkclass(Targetself.Self, "Chameleon")) {
            // too close
            if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setbool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Cowboy")) {
            // too close
            if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setbool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Dasher")) {
            // too close
            if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setbool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkclass(Targetself.Self, "Tank")) {
            // too close
            if (istargetinarea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setbool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
    }

}

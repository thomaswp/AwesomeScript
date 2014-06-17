
package com.awesomescript;

import java.util.EnumSet;

public class AISuperCreep
    extends Script
{


    public void onTick() {
        if (hastarget(Yesno.Yes)) {
            selecttarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.0D, 0.0D, 0.7D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, null, Yesno.No, Yesno.No);
            if (getboolequals("Shooting", Yesno.No)) {
                if (istargetposition(Yesno.Yes, Offsetposition.Back)) {
                    pressstick(Directions.BACKWARD, 0.0D);
                } else {
                    if (isoncreepturner(Yesno.Yes, Forwardbackward.BACKWARD)) {
                    } else {
                        pressstick(Directions.FORWARD, 0.1D);
                    }
                }
                sequence0();
            } else {
                aimstickattarget(2.0D, null);
                sequence1();
            }
        } else {
            if (isoncreepturner(Yesno.Yes, Forwardbackward.BACKWARD)) {
                if (hastarget(Yesno.No)) {
                    pressstick(Directions.BACKWARD, 0.0D);
                }
            } else {
                pressstick(Directions.FORWARD, 0.1D);
            }
            if (isinarea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, 0.0D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                selecttarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, 0.2D, 0.0D, 0.4D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, null, Yesno.No, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(2.0D);
        setbool("Shooting", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = true)
    void sequence1() {
        wait(1.0D);
        pressbutton(Buttons.FACE_LEFT, 0.0D);
        wait(1.0D);
        setbool("Shooting", Flagtoggle.Yes);
    }

}

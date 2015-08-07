
package com.awesomescript;

import java.util.EnumSet;

public class AISuperCreep
    extends Script
{


    public void onTick() {
        if (hasTarget(Yesno.Yes)) {
            selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.7D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            if (getBoolEquals("Shooting", Yesno.No)) {
                if (isTargetPosition(Yesno.Yes, Offsetposition.Back)) {
                    pressStick(Directions.BACKWARD, 0.0D);
                } else {
                    if (isOnCreepTurner(Yesno.Yes, Forwardbackward.BACKWARD)) {
                    } else {
                        pressStick(Directions.FORWARD, 0.1D);
                    }
                }
                sequence0();
            } else {
                aimStickAtTarget(2.0D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                sequence1();
            }
        } else {
            if (isOnCreepTurner(Yesno.Yes, Forwardbackward.BACKWARD)) {
                if (hasTarget(Yesno.No)) {
                    pressStick(Directions.BACKWARD, 0.0D);
                }
            } else {
                pressStick(Directions.FORWARD, 0.1D);
            }
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.2D, 0.0D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                selectTarget(EnumSet.of(TargetGroups.PLAYERS, TargetGroups.CREEPS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.No, 0.2D, 0.0D, 0.4D, 0.2D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(2.0D);
        setBool("Shooting", Flagtoggle.Yes);
    }

    @Script.Sequence(blocking = true)
    void sequence1() {
        wait(1.0D);
        pressButton(Buttons.FACE_LEFT, 0.0D);
        wait(1.0D);
        setBool("Shooting", Flagtoggle.Yes);
    }

}

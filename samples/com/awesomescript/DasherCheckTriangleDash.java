
package com.awesomescript;

import java.util.EnumSet;

public class DasherCheckTriangleDash
    extends Script
{


    public void onTick() {
        // we stop dash preparations after 4 seconds
        if (checkCounter("DashPrepareTimer", "40", Valuecompare.Greater)) {
            setBool("PrepareDash", Flagtoggle.No);
            log("tridash - cancel", "", "");
        }
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            // are we close?
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.No, Yesno.Yes)) {
                // check if we need to jump to get above target
                if (isTargetPosition(Yesno.No, Offsetposition.BELOW)) {
                    log("jump up to dash", "", "");
                    // jump
                    pressButton(Buttons.FACE_BOTTOM, 0.1D);
                } else {
                    log("dont jump for dash", "", "");
                }
            }
        }
        executeBehaviourTree("DasherCheckPlatformCollisions");
        if (isOnGround(Yesno.No, Targetself.Self)||checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.2D, 1.2D, Yesno.Yes, Yesno.Yes)||checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
                if (getBoolEquals("platformBlocksDash", Yesno.No)||checkCounter("botSkill", "2", Valuecompare.LessOrEqual)) {
                    // do the dash
                    sequence0();
                }
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        // okay lets do this
        aimStickAtTarget(0.2D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        setBool("cancelDash", Flagtoggle.No);
        setBool("doTornadoDash", Flagtoggle.No);
        if (checkCounter("botSkill", "1", Valuecompare.Equal)) {
            if (random("5")) {
                setBool("doTornadoDash", Flagtoggle.Yes);
            }
        }
        if (checkCounter("botSkill", "2", Valuecompare.Equal)) {
            if (random("3")) {
                setBool("doTornadoDash", Flagtoggle.Yes);
            }
        }
        if (checkCounter("botSkill", "3", Valuecompare.GreaterOrEqual)) {
            setBool("doTornadoDash", Flagtoggle.Yes);
        }
        // wait one frame
        wait(0.1D);
        // if we are facing enemy base
        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
            if (getBoolEquals("turretNear", Yesno.Yes)) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    setBool("cancelDash", Flagtoggle.Yes);
                }
            }
        }
        if (checkCounter("botSkill", "2", Valuecompare.LessOrEqual)) {
            wait(0.2D);
        }
        if (checkCounter("botSkill", "1", Valuecompare.LessOrEqual)) {
            wait(0.4D);
        }
        if (checkCounter("botSkill", "0", Valuecompare.LessOrEqual)) {
            wait(0.6D);
        }
        if (getBoolEquals("cancelDash", Yesno.No)) {
            // dash!
            pressButton(Buttons.FACE_RIGHT, 0.2D);
            // we just dashed :D
            adjustCounter("TimeSinceLastDash", "0", Valueadjust.Set);
            // if we do a tornado-dash combo
            if (getBoolEquals("doTornadoDash", Yesno.Yes)) {
                adjustCounter("TryTornado", "30", Valueadjust.Set);
                setBool("chase", Flagtoggle.Yes);
            }
            // tell others to help
            emitTargetInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), 0.0D, 0.0D, 1.5D, 1.5D);
        }
        setBool("PrepareDash", Flagtoggle.No);
    }

}

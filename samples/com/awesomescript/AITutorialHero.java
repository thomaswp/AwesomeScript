
package com.awesomescript;


public class AITutorialHero
    extends Script
{


    public void onTick() {
        if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            // Eigen torens
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
            }
            // Muren
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
            }
        }
        // Te dicht bij vijandelijke toren
        if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            setBool("", Flagtoggle.No);
            // Toren is voor mij
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                // Er zit een bevriende creep voor mij
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressButton(Buttons.FACE_BOTTOM, 0.0D);
                    // De bevriende creep is te ver weg
                    if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                        pressStick(Directions.UP, 0.0D);
                    }
                    log("", "", "");
                }
                // Er zit geen bevriende creep voor mij
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                log("", "", "");
            }
            // Toren is achter mij
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                // Er zit een creep tussen mij en de toren
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                // Er zit geen creep tussen mij en de toren
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                log("", "", "");
            }
            setBool("", Flagtoggle.No);
        }
        // Te dicht bij vijand
        if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
            setBool("", Flagtoggle.No);
            // Speler is voor mij
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                pressButton(Buttons.FACE_BOTTOM, 0.0D);
                // Er zit een bevriende creep voor mij
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    // De bevriende creep is te ver weg
                    if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                        pressStick(Directions.UP, 0.0D);
                    }
                    log("", "", "");
                }
                // Er zit geen bevriende creep voor mij
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                log("", "", "");
            }
            // Vijand is achter mij
            if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                // Er zit een creep tussen mij en de vijand
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                // Er zit geen creep tussen mij en de vijand
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    pressStick(Directions.UP, 0.0D);
                    log("", "", "");
                }
                log("", "", "");
            }
            pressButton(Buttons.FACE_BOTTOM, 0.0D);
            setBool("", Flagtoggle.No);
        }
        if (getBoolEquals("", Yesno.No)) {
            if (hasTarget(Yesno.Yes)) {
                selectTarget(null, null, "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                if (hasTarget(Yesno.Yes)) {
                    selectTarget(null, null, "", Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.NONE, Yesno.No, Yesno.No);
                }
            }
            if (hasTarget(Yesno.Yes)) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("", Flagtoggle.No);
                }
            }
        }
        if (getBoolEquals("", Yesno.No)) {
            if (getBoolEquals("", Yesno.No)) {
                if (isInArea(Yesno.Yes, null, Yesno.No, Yesno.Yes, null, "", 0.0D, 0.0D, 0.0D, 0.0D, Yesno.No, Yesno.No)) {
                    setBool("", Flagtoggle.No);
                    log("", "", "");
                }
                if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                    setBool("", Flagtoggle.No);
                    log("", "", "");
                }
            }
            if (getBoolEquals("", Yesno.No)) {
                sequence0();
            }
        }
        if (random("0")) {
            pressButton(Buttons.FACE_BOTTOM, 0.0D);
        }
        if (getBoolEquals("", Yesno.No)) {
            pressStick(Directions.UP, 0.0D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        pressStick(Directions.UP, 0.0D);
        wait(0.0D);
        setBool("", Flagtoggle.No);
    }

}

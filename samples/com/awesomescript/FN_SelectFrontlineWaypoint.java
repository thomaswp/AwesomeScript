
package com.awesomescript;


public class FN_SelectFrontlineWaypoint
    extends Script
{


    public void onTick() {
        if (getboolequals("BaseCanBeReached", Yesno.Yes)) {
            selectdestwaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
            setbool("IgnoreEnemies", Flagtoggle.Yes);
        } else {
            // set destination
            if (checkcounter("lane", "1", Valuecompare.Equal)) {
                if (getboolequals("enemyTower1Lane1", Yesno.Yes)) {
                    adjustcounter("positionInLane", "1", Valueadjust.Set);
                    log("GO TO UPPER LANE 1", "", "");
                    selectdestwaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                } else {
                    if (getboolequals("enemyTower2Lane1", Yesno.Yes)) {
                        adjustcounter("positionInLane", "2", Valueadjust.Set);
                        log("GO TO UPPER LANE 2", "", "");
                        selectdestwaypoint("UPPERLANESECOND", Ownenemy.ENEMY_TEAM);
                        if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                        } else {
                            adjustcounter("positionInLane", "1", Valueadjust.Set);
                            setbool("enemyTower1Lane1", Flagtoggle.Yes);
                            selectdestwaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                        }
                    } else {
                        if (getboolequals("enemyTower3", Yesno.Yes)) {
                            adjustcounter("positionInLane", "3", Valueadjust.Set);
                            log("GO TO UPPER LANE 3", "", "");
                            selectdestwaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                            setbool("IgnoreEnemies", Flagtoggle.Yes);
                            if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                adjustcounter("positionInLane", "2", Valueadjust.Set);
                                setbool("enemyTower2Lane1", Flagtoggle.Yes);
                                selectdestwaypoint("UPPERLANESECOND", Ownenemy.ENEMY_TEAM);
                            }
                            if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                setbool("enemyTower1Lane1", Flagtoggle.Yes);
                                selectdestwaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                            }
                        } else {
                            // default
                            adjustcounter("positionInLane", "1", Valueadjust.Set);
                            log("GO TO UPPER LANE 1", "", "");
                            selectdestwaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                        }
                    }
                }
            } else {
                if (checkcounter("lane", "2", Valuecompare.Equal)) {
                    if (getboolequals("enemyTower1Lane2", Yesno.Yes)) {
                        adjustcounter("positionInLane", "1", Valueadjust.Set);
                        log("GO TO BOTTOM LANE 1", "", "");
                        selectdestwaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                    } else {
                        if (getboolequals("enemyTower2Lane2", Yesno.Yes)) {
                            adjustcounter("positionInLane", "2", Valueadjust.Set);
                            log("GO TO BOTTOM LANE 2", "", "");
                            selectdestwaypoint("BOTTOMLANESECOND", Ownenemy.ENEMY_TEAM);
                            if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                adjustcounter("positionInLane", "1", Valueadjust.Set);
                                setbool("enemyTower1Lane2", Flagtoggle.Yes);
                                selectdestwaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                            }
                        } else {
                            if (getboolequals("enemyTower3", Yesno.Yes)) {
                                adjustcounter("positionInLane", "3", Valueadjust.Set);
                                log("GO TO BOTTOM LANE 3", "", "");
                                selectdestwaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                setbool("IgnoreEnemies", Flagtoggle.Yes);
                                if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                                } else {
                                    adjustcounter("positionInLane", "2", Valueadjust.Set);
                                    setbool("enemyTower2Lane2", Flagtoggle.Yes);
                                    selectdestwaypoint("BOTTOMLANESECOND", Ownenemy.ENEMY_TEAM);
                                }
                                if (isnextwaypointinarea(0.0D, 0.0D, 2.0D, 2.0D)) {
                                } else {
                                    setbool("enemyTower1Lane2", Flagtoggle.Yes);
                                    selectdestwaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                                }
                            } else {
                                // default
                                adjustcounter("positionInLane", "1", Valueadjust.Set);
                                log("GO TO BOTTOM LANE 1", "", "");
                                selectdestwaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                            }
                        }
                    }
                }
            }
        }
    }

}

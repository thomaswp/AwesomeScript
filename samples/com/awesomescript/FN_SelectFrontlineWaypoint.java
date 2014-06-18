
package com.awesomescript;


public class FN_SelectFrontlineWaypoint
    extends Script
{


    public void onTick() {
        if (getBoolEquals("BaseCanBeReached", Yesno.Yes)) {
            selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
            setBool("IgnoreEnemies", Flagtoggle.Yes);
        } else {
            // set destination
            if (checkCounter("lane", "1", Valuecompare.Equal)) {
                if (getBoolEquals("enemyTower1Lane1", Yesno.Yes)) {
                    adjustCounter("positionInLane", "1", Valueadjust.Set);
                    log("GO TO UPPER LANE 1", "", "");
                    selectDestWaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                } else {
                    if (getBoolEquals("enemyTower2Lane1", Yesno.Yes)) {
                        adjustCounter("positionInLane", "2", Valueadjust.Set);
                        log("GO TO UPPER LANE 2", "", "");
                        selectDestWaypoint("UPPERLANESECOND", Ownenemy.ENEMY_TEAM);
                        if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                        } else {
                            adjustCounter("positionInLane", "1", Valueadjust.Set);
                            setBool("enemyTower1Lane1", Flagtoggle.Yes);
                            selectDestWaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                        }
                    } else {
                        if (getBoolEquals("enemyTower3", Yesno.Yes)) {
                            adjustCounter("positionInLane", "3", Valueadjust.Set);
                            log("GO TO UPPER LANE 3", "", "");
                            selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                            setBool("IgnoreEnemies", Flagtoggle.Yes);
                            if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                adjustCounter("positionInLane", "2", Valueadjust.Set);
                                setBool("enemyTower2Lane1", Flagtoggle.Yes);
                                selectDestWaypoint("UPPERLANESECOND", Ownenemy.ENEMY_TEAM);
                            }
                            if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                setBool("enemyTower1Lane1", Flagtoggle.Yes);
                                selectDestWaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                            }
                        } else {
                            // default
                            adjustCounter("positionInLane", "1", Valueadjust.Set);
                            log("GO TO UPPER LANE 1", "", "");
                            selectDestWaypoint("UPPERLANE", Ownenemy.OWN_TEAM);
                        }
                    }
                }
            } else {
                if (checkCounter("lane", "2", Valuecompare.Equal)) {
                    if (getBoolEquals("enemyTower1Lane2", Yesno.Yes)) {
                        adjustCounter("positionInLane", "1", Valueadjust.Set);
                        log("GO TO BOTTOM LANE 1", "", "");
                        selectDestWaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                    } else {
                        if (getBoolEquals("enemyTower2Lane2", Yesno.Yes)) {
                            adjustCounter("positionInLane", "2", Valueadjust.Set);
                            log("GO TO BOTTOM LANE 2", "", "");
                            selectDestWaypoint("BOTTOMLANESECOND", Ownenemy.ENEMY_TEAM);
                            if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                            } else {
                                adjustCounter("positionInLane", "1", Valueadjust.Set);
                                setBool("enemyTower1Lane2", Flagtoggle.Yes);
                                selectDestWaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                            }
                        } else {
                            if (getBoolEquals("enemyTower3", Yesno.Yes)) {
                                adjustCounter("positionInLane", "3", Valueadjust.Set);
                                log("GO TO BOTTOM LANE 3", "", "");
                                selectDestWaypoint("FINALSTAND", Ownenemy.ENEMY_TEAM);
                                setBool("IgnoreEnemies", Flagtoggle.Yes);
                                if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                                } else {
                                    adjustCounter("positionInLane", "2", Valueadjust.Set);
                                    setBool("enemyTower2Lane2", Flagtoggle.Yes);
                                    selectDestWaypoint("BOTTOMLANESECOND", Ownenemy.ENEMY_TEAM);
                                }
                                if (isNextWaypointInArea(0.0D, 0.0D, 2.0D, 2.0D)) {
                                } else {
                                    setBool("enemyTower1Lane2", Flagtoggle.Yes);
                                    selectDestWaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                                }
                            } else {
                                // default
                                adjustCounter("positionInLane", "1", Valueadjust.Set);
                                log("GO TO BOTTOM LANE 1", "", "");
                                selectDestWaypoint("BOTTOMLANE", Ownenemy.OWN_TEAM);
                            }
                        }
                    }
                }
            }
        }
    }

}

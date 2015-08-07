
package com.awesomescript;

import java.util.EnumSet;

public class FN_HurleySwigsCheckIfEnemyTooClose
    extends Script
{


    public void onTick() {
        setBool("EnemyIsTooClose", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Chameleon")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Cowboy")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Dasher")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Tank")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Captain")) {
            if (getBoolEquals("wantAnchor", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                    if (checkClass(Targetself.Target, "Tank")) {
                        // too close
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.4D, 0.4D, Yesno.Yes, Yesno.No)) {
                            setBool("EnemyIsTooClose", Flagtoggle.Yes);
                        }
                    } else {
                        if (checkClass(Targetself.Target, "Vampire")) {
                            // too close
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.35D, 0.35D, Yesno.Yes, Yesno.No)) {
                                setBool("EnemyIsTooClose", Flagtoggle.Yes);
                            }
                        } else {
                            if (checkClass(Targetself.Target, "Heavy")) {
                                // too close
                                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.3D, Yesno.Yes, Yesno.No)) {
                                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                                }
                            } else {
                                if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))&&isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                                    // too close
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                                    }
                                } else {
                                    // too close
                                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.15D, 0.1D, Yesno.Yes, Yesno.No)) {
                                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // too close
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                    }
                }
            }
        }
    }

}

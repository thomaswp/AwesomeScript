
package com.awesomescript;

import java.util.EnumSet;

public class FN_HurleySwigsCheckIfEnemyInCombatRange
    extends Script
{


    public void onTick() {
        setBool("EnemyIsInCombatRange", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Chameleon")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Cowboy")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
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
        if (checkClass(Targetself.Self, "Captain")) {
            if (getBoolEquals("wantAnchor", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                    if (isTargetType(Yesno.Yes, EnumSet.of(TargetGroups.CREEPS))&&isFromTeam(Teamswithnumbers.NEUTRAL_TEAM, Targetself.Target)) {
                        // in range
                        if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                            setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                        }
                    } else {
                        if (getBoolEquals("lowerInkRange", Yesno.Yes)) {
                            // in range
                            if (isTargetInArea(Yesno.Yes, 0.16D, 0.0D, 0.32D, 0.5D, Yesno.No, Yesno.No)) {
                                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                            }
                        } else {
                            // in range
                            if (isTargetInArea(Yesno.Yes, 0.18D, 0.0D, 0.36D, 0.5D, Yesno.No, Yesno.No)) {
                                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                            }
                        }
                    }
                } else {
                    // in range
                    if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                        setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                    }
                }
            }
        }
    }

}

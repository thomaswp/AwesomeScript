
package com.awesomescript;


public class VeankoCheckIfEnemyTooClose
    extends Script
{


    public void onTick() {
        setBool("EnemyIsTooClose", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Chameleon")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.05D, Yesno.Yes, Yesno.No)) {
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
        if (checkClass(Targetself.Self, "Vampire")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Maw")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Shaman")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Hunter")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Heavy")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Spy")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Bird")) {
            if (isUpgradeEnabled(Yesno.Yes, "BirdShootRange1")) {
                // too close
                if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.35D, 0.2D, Yesno.Yes, Yesno.No)) {
                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                }
            } else {
                // too close
                if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.No)) {
                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                }
            }
        }
        if (checkClass(Targetself.Self, "Captain")) {
            if (getBoolEquals("wantAnchor", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                    // too close
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                    }
                } else {
                    // too close
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                        setBool("EnemyIsTooClose", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (checkClass(Targetself.Self, "Brute")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Assassin")) {
            if (isUpgradeEnabled(Yesno.Yes, "AssasinStrikeMaxChargeRangedActivate")) {
                // too close
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                }
            } else {
                // too close
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                    setBool("EnemyIsTooClose", Flagtoggle.Yes);
                }
            }
        }
        if (checkClass(Targetself.Self, "Summoner")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Blazer")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.05D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Jetter")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.3D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Butterfly")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Commando")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Paladin")) {
            // too close
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.07D, 0.05D, Yesno.Yes, Yesno.No)) {
                setBool("EnemyIsTooClose", Flagtoggle.Yes);
            }
        }
    }

}

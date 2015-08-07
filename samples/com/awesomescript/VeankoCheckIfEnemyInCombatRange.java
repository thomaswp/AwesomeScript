
package com.awesomescript;


public class VeankoCheckIfEnemyInCombatRange
    extends Script
{


    public void onTick() {
        setBool("EnemyIsInCombatRange", Flagtoggle.No);
        if (checkClass(Targetself.Self, "Chameleon")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.1D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Cowboy")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.3D, 0.1D, Yesno.No, Yesno.No)) {
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
        if (checkClass(Targetself.Self, "Vampire")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Maw")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Shaman")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Hunter")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Heavy")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Spy")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Bird")) {
            if (isUpgradeEnabled(Yesno.Yes, "BirdShootRange1")) {
                // in range
                if (isTargetInArea(Yesno.Yes, 0.4D, 0.0D, 0.3D, 0.1D, Yesno.No, Yesno.No)) {
                    setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                }
            } else {
                // in range
                if (isTargetInArea(Yesno.Yes, 0.2D, 0.0D, 0.3D, 0.1D, Yesno.No, Yesno.No)) {
                    setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                }
            }
        }
        if (checkClass(Targetself.Self, "Captain")) {
            if (getBoolEquals("wantAnchor", Yesno.No)) {
                if (isUpgradeEnabled(Yesno.Yes, "CaptainNoAnker")) {
                    // in range
                    if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                        setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                    }
                } else {
                    // in range
                    if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                        setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                    }
                }
            }
        }
        if (checkClass(Targetself.Self, "Brute")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.1D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Assassin")) {
            if (isUpgradeEnabled(Yesno.Yes, "AssasinStrikeMaxChargeRangedActivate")) {
                // in range
                if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.13D, Yesno.No, Yesno.No)) {
                    setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                }
            } else {
                // in range
                if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                    setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                }
            }
        }
        if (checkClass(Targetself.Self, "Summoner")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Blazer")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.05D, 0.0D, 0.08D, 0.13D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Jetter")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Butterfly")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.4D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
        if (checkClass(Targetself.Self, "Commando")) {
            if (isUpgradeEnabled(Yesno.Yes, "CommandoTransitionMachineGun")) {
                if (isUpgradeEnabled(Yesno.Yes, "CommandoShotRange1")) {
                    // in range
                    if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.3D, 0.2D, Yesno.No, Yesno.No)) {
                        setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                    }
                } else {
                    // in range
                    if (isTargetInArea(Yesno.Yes, 0.25D, 0.0D, 0.4D, 0.1D, Yesno.No, Yesno.No)) {
                        setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                    }
                }
            } else {
                // in range
                if (isTargetInArea(Yesno.Yes, 0.22D, 0.0D, 0.2D, 0.2D, Yesno.No, Yesno.No)) {
                    setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
                }
            }
        }
        if (checkClass(Targetself.Self, "Paladin")) {
            // in range
            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.22D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("EnemyIsInCombatRange", Flagtoggle.Yes);
            }
        }
    }

}

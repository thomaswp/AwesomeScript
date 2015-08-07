
package com.awesomescript;

import java.util.EnumSet;

public class DasherCheckPlatformCollisions
    extends Script
{


    public void onTick() {
        setBool("platformBlocksDash", Flagtoggle.No);
        if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.15D, 0.2D, Yesno.No, Yesno.No)) {
                setBool("platformBlocksDash", Flagtoggle.Yes);
            } else {
                if (isTargetInArea(Yesno.Yes, 0.0D, -0.3D, 1.2D, 0.6D, Yesno.Yes, Yesno.No)) {
                    if (isTargetInArea(Yesno.Yes, -0.52D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.52D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.38D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.52D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.38D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.52D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.38D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.38D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.38D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.38D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.22D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.22D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.08D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, -0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, -0.08D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.08D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.08D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.22D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.22D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.38D, -0.52D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.08D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.22D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.38D, -0.38D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.22D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                            setBool("platformBlocksDash", Flagtoggle.Yes);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.38D, -0.22D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                    if (isTargetInArea(Yesno.Yes, 0.38D, -0.08D, 0.15D, 0.15D, Yesno.No, Yesno.No)) {
                    }
                }
            }
        }
    }

}

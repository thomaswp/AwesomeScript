
package com.awesomescript;

import java.util.EnumSet;

public class TutorialHelper1
    extends Script
{


    public void onTick() {
        if (getBoolEquals("Frozen", Yesno.No)) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.08D, 0.0D, 0.16D, 0.3D, Yesno.No, Yesno.No)) {
                if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                    pressButton(Buttons.FACE_LEFT, 0.1D);
                }
            }
            if (getBoolEquals("HasSeenCowboy", Yesno.No)) {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                    setBool("HasSeenCowboy", Flagtoggle.Yes);
                }
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.28D, 0.0D, 0.55D, 0.1D, Yesno.No, Yesno.No)) {
                    if (getBoolEquals("ToldToStandBack", Yesno.No)) {
                        log("TellCowboyToWait!", "", "");
                        emitMessageInArea("StandBackCowboy", EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teamswithtarget.OWN_TEAM), 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No);
                        setBool("ToldToStandBack", Flagtoggle.Yes);
                    }
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.0D, 0.0D, 0.9D, 1.0D, Yesno.Yes, Yesno.No)) {
                        pressStick(Directions.RIGHT, 1.0D);
                    } else {
                        pressStick(Directions.LEFT, 1.0D);
                    }
                } else {
                    if (timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                        if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 1.9D, 0.0D, 4.0D, 2.0D, Yesno.Yes, Yesno.No)) {
                                pressStick(Directions.FORWARD, 1.0D);
                            } else {
                                pressStick(Directions.BACKWARD, 1.0D);
                            }
                        } else {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", -1.9D, 0.0D, 4.0D, 2.0D, Yesno.Yes, Yesno.No)) {
                                pressStick(Directions.BACKWARD, 1.0D);
                            } else {
                                pressStick(Directions.FORWARD, 1.0D);
                            }
                        }
                    }
                }
            }
        } else {
            if (receivedMessage("ImDoneTalking")) {
                enableUpgrade(Yesno.No, "TutorialListen");
                setBool("Frozen", Flagtoggle.No);
                enableUpgrade(Yesno.No, "TutorialTalk");
            }
        }
    }

}

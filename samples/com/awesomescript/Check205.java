
package com.awesomescript;

import java.util.EnumSet;

public class Check205
    extends Script
{


    public void onTick() {
        if (once()) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "HAZARDAREA", 8.3D, 0.5D, 1.5D, 0.5D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.NAMED_AREAS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "HAZARDAREA", -8.3D, 0.5D, 1.5D, 0.5D, Yesno.No, Yesno.No)) {
                setBool("on205", Flagtoggle.Yes);
            } else {
                setBool("on205", Flagtoggle.No);
            }
        }
    }

}

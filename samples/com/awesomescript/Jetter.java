
package com.awesomescript;


public class Jetter
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isupgradeenabled(Yesno.No, "GroundingOn")) {
            if (isinnamedarea("NoFlyZone", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getboolequals("JetOn", Yesno.Yes)) {
                    enableupgrade(Yesno.No, "JetterJet");
                    setbool("JetOn", Flagtoggle.No);
                }
            } else {
                if (getboolequals("JetOn", Yesno.No)) {
                    enableupgrade(Yesno.Yes, "JetterJet");
                    setbool("JetOn", Flagtoggle.Yes);
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "JetterTimebubbleSpeedup")) {
            if (isupgradeenabled(Yesno.Yes, "JetterTimebubbleDuration")) {
                if (isupgradeenabled(Yesno.No, "JetterTimebubbleSpeedupAndDuration1")) {
                    enableupgrade(Yesno.Yes, "JetterTimebubbleSpeedupAndDuration1");
                }
            }
            if (isupgradeenabled(Yesno.Yes, "JetterTimebubbleDuration2")) {
                if (isupgradeenabled(Yesno.No, "JetterTimebubbleSpeedupAndDuration2")) {
                    enableupgrade(Yesno.Yes, "JetterTimebubbleSpeedupAndDuration2");
                }
            }
        }
    }

}

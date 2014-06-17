
package com.awesomescript;


public class Brute
    extends Script
{


    public void onTick() {
        executebehaviourtree("StatusEffects");
        executebehaviourtree("HeroCode");
        if (isupgradeenabled(Yesno.Yes, "BruteStampReset")) {
            if (random("3")) {
                if (isupgradeenabled(Yesno.No, "BruteStampDoreset")) {
                    enableupgrade(Yesno.Yes, "BruteStampDoreset");
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "BruteStampDoreset")) {
                    enableupgrade(Yesno.No, "BruteStampDoreset");
                }
            }
        }
        if (isupgradeenabled(Yesno.Yes, "BruteStampIgnoreAir")) {
        } else {
            if (isonground(Yesno.Yes, Targetself.Self)) {
                if (isupgradeenabled(Yesno.Yes, "BruteStampInAir")) {
                    enableupgrade(Yesno.No, "BruteStampInAir");
                }
            } else {
                if (isupgradeenabled(Yesno.No, "BruteStampInAir")) {
                    enableupgrade(Yesno.Yes, "BruteStampInAir");
                }
            }
        }
    }

}

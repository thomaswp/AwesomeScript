
package com.awesomescript;


public class Heavy
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (getboolequals("siegemode", Yesno.Yes)) {
            if (isinnamedarea("SecretArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isupgradeenabled(Yesno.No, "EnableJumppad")) {
                    enableupgrade(Yesno.Yes, "EnableJumppad");
                }
            } else {
                if (isupgradeenabled(Yesno.Yes, "EnableJumppad")) {
                    enableupgrade(Yesno.No, "EnableJumppad");
                }
            }
        } else {
            if (isupgradeenabled(Yesno.Yes, "EnableJumppad")) {
                enableupgrade(Yesno.No, "EnableJumppad");
            }
        }
    }

}

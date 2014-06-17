
package com.awesomescript;


public class FN_CreepLevelling
    extends Script
{


    public void onTick() {
        if (once()) {
            if (checkgametime(360.0D, Valuecompare.Greater)) {
                enableupgrade(Yesno.Yes, "CreepLevel1");
                adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
            if (checkgametime(720.0D, Valuecompare.Greater)) {
                enableupgrade(Yesno.Yes, "CreepLevel2");
                adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
            if (checkgametime(1080.0D, Valuecompare.Greater)) {
                enableupgrade(Yesno.Yes, "CreepLevel3");
                adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
        }
    }

}

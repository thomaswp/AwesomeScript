
package com.awesomescript;


public class BlazerAchievements
    extends Script
{


    public void onTick() {
        // AchievmentSolarRace
        if (checkClass(Targetself.Self, "Blazer")) {
            if (isFromTeam(Teamswithnumbers.ZERO_TEAM, Targetself.Self)) {
                if (isInNamedArea("ATSOLARRACE1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("RaceON", Flagtoggle.Yes);
                    adjustCounter("ATSOLARRACETIMER", "0", Valueadjust.Set);
                }
                if (getBoolEquals("RaceON", Yesno.Yes)) {
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        adjustCounter("ATSOLARRACETIMER", "1", Valueadjust.Add);
                    }
                }
                if (checkCounter("ATSOLARRACETIMER", "11", Valuecompare.GreaterOrEqual)) {
                    setBool("RaceON", Flagtoggle.No);
                } else {
                    if (isInNamedArea("ATSOLARRACE2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        enableUpgrade(Yesno.Yes, "BlazerSolarRaceDone");
                    }
                }
            }
            if (isFromTeam(Teamswithnumbers.ONE_TEAM, Targetself.Self)) {
                if (isInNamedArea("ATSOLARRACE2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("RaceON", Flagtoggle.Yes);
                    adjustCounter("ATSOLARRACETIMER", "0", Valueadjust.Set);
                }
                if (getBoolEquals("RaceON", Yesno.Yes)) {
                    if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                        adjustCounter("ATSOLARRACETIMER", "1", Valueadjust.Add);
                    }
                }
                if (checkCounter("ATSOLARRACETIMER", "11", Valuecompare.GreaterOrEqual)) {
                    setBool("RaceON", Flagtoggle.No);
                } else {
                    if (isInNamedArea("ATSOLARRACE1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        enableUpgrade(Yesno.Yes, "BlazerSolarRaceDone");
                    }
                }
            }
        }
    }

}

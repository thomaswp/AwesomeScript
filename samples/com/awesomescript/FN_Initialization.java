
package com.awesomescript;


public class FN_Initialization
    extends Script
{


    public void onTick() {
        if (getboolequals("init", Yesno.Yes)) {
            if (checkcharactervalue(CharactervaluesCheckable.AISkill, 0.25D, Valuecompare.Less, Targetself.Self)) {
                if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                    if (checkcharactervalue(CharactervaluesCheckable.Gold, 100.0D, Valuecompare.Greater, Targetself.Self)) {
                        adjustcharactervalue(CharactervaluesAdjustable.Gold, -1.0D, Valueadjust.Add);
                    }
                }
            }
            if (isinnamedarea("StartArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getboolequals("StartHealthSet", Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                    setbool("StartHealthSet", Flagtoggle.Yes);
                }
            }
        }
        if (getboolequals("init", Yesno.No)) {
            if (directiontoenemybase(Forwardbackward.FORWARD)) {
                adjustcounter("TeamNo", "0", Valueadjust.Set);
            } else {
                adjustcounter("TeamNo", "1", Valueadjust.Set);
            }
            if (checkcharactervalue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "Coinregen1");
                if (checkcharactervalue(CharactervaluesCheckable.AISkill, 0.7D, Valuecompare.Greater, Targetself.Self)) {
                    if (checkcharactervalue(CharactervaluesCheckable.AISkill, 0.95D, Valuecompare.Greater, Targetself.Self)) {
                        if (isupgradeenabled(Yesno.Yes, "BotLevel0")) {
                            if (isupgradeenabled(Yesno.Yes, "BotLevel1")) {
                                if (isupgradeenabled(Yesno.Yes, "BotLevel2")) {
                                    if (isupgradeenabled(Yesno.Yes, "BotLevel3")) {
                                        if (isupgradeenabled(Yesno.Yes, "BotLevel4")) {
                                        } else {
                                            buyupgrade("Botlevel4");
                                        }
                                    } else {
                                        buyupgrade("Botlevel3");
                                    }
                                } else {
                                    buyupgrade("Botlevel2");
                                }
                            } else {
                                buyupgrade("Botlevel1");
                            }
                        } else {
                            buyupgrade("Botlevel0");
                        }
                    }
                } else {
                    if (isupgradeenabled(Yesno.Yes, "BotLevel0")) {
                        if (isupgradeenabled(Yesno.Yes, "BotLevel1")) {
                            if (isupgradeenabled(Yesno.Yes, "BotLevel2")) {
                            } else {
                                buyupgrade("Botlevel2");
                            }
                        } else {
                            buyupgrade("Botlevel1");
                        }
                    } else {
                        buyupgrade("Botlevel0");
                    }
                }
            }
            setbool("init", Flagtoggle.Yes);
            adjustcounter("EnemiesChecked", "0", Valueadjust.Set);
            adjustcounter("KnownEnemies", "0", Valueadjust.Set);
            enableupgrade(Yesno.Yes, "Bot");
            if (checkcharactervalue(CharactervaluesCheckable.Gold, 0.0D, Valuecompare.Equal, Targetself.Self)) {
                adjustcharactervalue(CharactervaluesAdjustable.Health, 100.0D, Valueadjust.Set);
            }
            if (isinnamedarea("Startarea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                // returnToUpgrade (10)
                adjustcounter("setState", "10", Valueadjust.Set);
            } else {
                // advanceToFrontline(3)
                adjustcounter("setState", "3", Valueadjust.Set);
            }
            // set towers alive
            if (getboolequals("false", Yesno.No)) {
                if (isinnamedarea("DEURBLAUW3", Ownenemy.OWN_TEAM, Targetself.Self)||isinnamedarea("DEURROOD3", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setbool("enemyTower1Lane1", Flagtoggle.No);
                } else {
                    setbool("enemyTower1Lane1", Flagtoggle.Yes);
                }
                if (isinnamedarea("DEURBLAUW2", Ownenemy.OWN_TEAM, Targetself.Self)||isinnamedarea("DEURROOD2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setbool("enemyTower2Lane1", Flagtoggle.No);
                } else {
                    setbool("enemyTower2Lane1", Flagtoggle.Yes);
                }
                if (isinnamedarea("DEURBLAUW1", Ownenemy.OWN_TEAM, Targetself.Self)||isinnamedarea("DEURROOD1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setbool("enemyTower2Lane2", Flagtoggle.No);
                } else {
                    setbool("enemyTower2Lane2", Flagtoggle.Yes);
                }
                if (isinnamedarea("DEURBLAUW4", Ownenemy.OWN_TEAM, Targetself.Self)||isinnamedarea("DEURROOD4", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setbool("enemyTower1Lane2", Flagtoggle.No);
                } else {
                    setbool("enemyTower1Lane2", Flagtoggle.Yes);
                }
                setbool("enemyTower3", Flagtoggle.Yes);
            }
            setbool("SupportMode", Flagtoggle.No);
            if ((getboolequals("Jetter", Yesno.Yes)||getboolequals("Summoner", Yesno.Yes))||random("2")) {
                setbool("SupportMode", Flagtoggle.Yes);
                adjustcounter("SupportBuild", "4", Valueadjust.Set);
            } else {
                adjustcounter("SupportBuild", "0", Valueadjust.Set);
            }
            if (getboolequals("SupportMode", Yesno.No)) {
                if (random("1")) {
                    setbool("PushMode", Flagtoggle.Yes);
                }
            }
        }
    }

}

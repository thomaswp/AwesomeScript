
package com.awesomescript;


public class Butterfly
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
    }

}

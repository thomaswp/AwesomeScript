
package com.awesomescript;


public class Butterfly
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
    }

}


package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;

/**
 * Class Sheep
 * @author Anthony
 */
public class Sheep extends Animal{
    Model m;
    
    Sheep(int x, int y, Model mParam){
        lifeTime    = SHEEP_LIFETIME;
        hunger      = SHEEP_HUNGER;
        alive       = true;
        m           = mParam;
        behaviorMove        = new RandomMove(m);
        this.setPosX(x);
        this.setPosY(y);
        this.setSex();
    }

    @Override
    public void eat() {
        hunger = SHEEP_HUNGER;
    }
    
    
}

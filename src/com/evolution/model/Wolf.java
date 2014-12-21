
package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;
import com.evolution.strategy.WolfMove;

/**
 *
 * @author Anthony
 */
public class Wolf extends Animal{
    Model m;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    Wolf(int x, int y, Model mParam){
        alive       = true;
        lifeTime    = WOLF_LIFETIME;
        hunger      = WOLF_HUNGER;
        m = mParam;
        behaviorMove = new WolfMove(m);
        this.setPosX(x);
        this.setPosY(y);
        this.setSex();
        
    }

    
    
    
    
    //**************************************************************************
    // METHODS
    //**************************************************************************
    @Override
    public void eat() {
        hunger = WOLF_HUNGER;
    }

}

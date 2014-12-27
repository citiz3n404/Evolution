
package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;
import com.evolution.strategy.WolfEat;
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
        behaviorEat = new WolfEat(m);
        this.setPosX(x);
        this.setPosY(y);
        this.setSex();
        
    }

    
    
    
    
    //**************************************************************************
    // METHODS
    //**************************************************************************

    
    public void resetHunger(){
        hunger = WOLF_HUNGER;
    }

    @Override
    public void makeAMove() {
        behaviorMove.move(this);
    }

    @Override
    public void haveAMeal() {
        behaviorEat.eat(this);
    }

}

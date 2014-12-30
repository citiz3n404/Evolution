
package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;
import com.evolution.strategy.WolfEat;
import com.evolution.strategy.WolfMove;
import com.evolution.strategy.WolfReproduce;
import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public class Wolf extends Animal implements Serializable{
    Model m;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Wolf(int x, int y, Model mParam){
        alive       = true;
        lifeTime    = WOLF_LIFETIME;
        hunger      = WOLF_HUNGER;
        reproductivity = 0;
        m = mParam;
        behaviorMove = new WolfMove(m);
        behaviorEat = new WolfEat(m);
        behaviorReproduce = new  WolfReproduce(m);
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

    @Override
    public void makeABaby() {
        behaviorReproduce.reproduce(this);
    }

    @Override
    public void resetReproductivity() {
        reproductivity = WOLF_REPRODUCTIVITY;
    }

}

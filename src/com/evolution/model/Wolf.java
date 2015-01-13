
package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;
import com.evolution.strategy.WolfEat;
import com.evolution.strategy.WolfMove;
import com.evolution.strategy.WolfReproduce;
import java.io.Serializable;

/**
 * Class Wolf
 * @author Anthony
 */
public class Wolf extends Animal implements Serializable{
    Model m;
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    /**
     * Constructor of the wolf
     * @param x int Position X of the wolf
     * @param y int Position Y of the Wolf
     * @param mParam Model
     */
    public Wolf(int x, int y, Model mParam){
        alive               = true;
        lifeTime            = WOLF_LIFETIME;
        hunger              = WOLF_HUNGER;
        reproductivity      = 0;
        m                   = mParam;
        behaviorMove        = new WolfMove(m);
        behaviorEat         = new WolfEat(m);
        behaviorReproduce   = new  WolfReproduce(m);
        this.setPosX(x);
        this.setPosY(y);
        this.setSex();
        
    }

    
    
    
    
    //**************************************************************************
    // METHODS
    //**************************************************************************

    /**
     * Reset the hunger to the value contained in the Constant interface
     */
    public void resetHunger(){
        hunger = WOLF_HUNGER;
    }

    /**
     * Use the move method corresponding to his behaviorMove
     */
    @Override
    public void makeAMove() {
        behaviorMove.move(this);
    }

    /**
     * Use the method eat corrsponding to his behaviorEat
     */
    @Override
    public void haveAMeal() {
        behaviorEat.eat(this);
    }

    /**
     * Use the method reproduce corresponding to his behaviorReproduce
     */
    @Override
    public void makeABaby() {
        behaviorReproduce.reproduce(this);
    }

    /**
     * Reset the reproductivity the value contained in the Constants interface
     */
    @Override
    public void resetReproductivity() {
        reproductivity = WOLF_REPRODUCTIVITY;
    }

}

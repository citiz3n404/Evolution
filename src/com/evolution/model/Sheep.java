
package com.evolution.model;

import com.evolution.strategy.RandomM;
import com.evolution.strategy.RandomMove;
import com.evolution.strategy.SheepEat;
import com.evolution.strategy.SheepMove;
import com.evolution.strategy.SheepReproduce;
import java.io.Serializable;

/**
 * Class Sheep
 * @author Anthony
 */
public class Sheep extends Animal{
    Model m;
    
    /**
     * Constructor of the Sheep
     * @param x int position X of the Sheep
     * @param y int position Y of the animal
     * @param mParam Model
     */
    public Sheep(int x, int y, Model mParam){
        lifeTime    = SHEEP_LIFETIME;
        hunger      = SHEEP_HUNGER;
        reproductivity = 0;
        alive       = true;
        m           = mParam;
        behaviorMove  = new SheepMove(m);
        behaviorEat   = new SheepEat(m);
        behaviorReproduce = new SheepReproduce(m);
        this.setPosX(x);
        this.setPosY(y);
        this.setSex();
    }



    /**
     * Use the method move corresponding to his behaviorMove
     */
    @Override
    public void makeAMove() {
        behaviorMove.move(this);
    }

    /**
     * Use the method eat corresponding to his behaviorEat
     */
    @Override
    public void haveAMeal() {
        behaviorEat.eat(this);
    }

    /**
     * Reset the hunger the value contained in the Constant interface
     */
    @Override
    public void resetHunger() {
        hunger = SHEEP_HUNGER;
    }

    /**
     * Use the method reproduce corresponding his behaviorReproduce
     */
    @Override
    public void makeABaby() {
        behaviorReproduce.reproduce(this);
    }

    /**
     * Reset the reproductivity the value contained in the Constant interface
     */
    @Override
    public void resetReproductivity() {
        reproductivity = SHEEP_REPRODUCTIVITY;
    }

}

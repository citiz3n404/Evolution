
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
public class Sheep extends Animal implements Serializable{
    Model m;
    
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



    @Override
    public void makeAMove() {
        behaviorMove.move(this);
    }

    @Override
    public void haveAMeal() {
        behaviorEat.eat(this);
    }

    @Override
    public void resetHunger() {
        hunger = SHEEP_HUNGER;
    }

    @Override
    public void makeABaby() {
        behaviorReproduce.reproduce(this);
    }

    @Override
    public void resetReproductivity() {
        reproductivity = SHEEP_REPRODUCTIVITY;
    }

}

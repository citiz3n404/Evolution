
package com.evolution.model;

import com.evolution.strategy.BehaviorEat;
import com.evolution.strategy.BehaviorMove;
import com.evolution.strategy.BehaviorReproduce;
import java.io.Serializable;

/**
 * Abstract class of Animal
 * @author Anthony
 */
public abstract class Animal implements CONSTANTS{
    protected     int         lifeTime;
    protected     int         hunger;
    protected     boolean     alive;
    protected     int         posX;
    protected     int         posY;
    protected     boolean     sex;
    protected     int         reproductivity;
    
    protected     BehaviorMove behaviorMove;
    protected     BehaviorEat  behaviorEat;
    protected     BehaviorReproduce behaviorReproduce;
    
    public abstract void makeAMove();
    public abstract void haveAMeal();
    public abstract void resetHunger();
    public abstract void makeABaby();
    public abstract void resetReproductivity();

    /**
     * Return the position X of the animal on the universe
     * @return int
     */
    public int getPosX(){
        return this.posX;
    }
    
    /**
     * Return the position Y of the animal on the universe
     * @return int
     */
    public int getPosY(){
        return this.posY;
    }
    
    /**
     * Return the reproductivity : a number that deacrease on each birthday 
     * and if it's zero then he can have baby
     * @return int
     */
    public int getReproductivity(){
        return reproductivity;
    }
    
    /**
     * Return the sex of the animal true for male false for female
     * @return Boolean
     */
    public boolean getSex(){
        return this.sex;
    }
    
    /**
     * Set the position X of the animal
     * @param x int
     */
    public void setPosX(int x){
        this.posX = x;
    }
    
    /**
     * Set the position Y of the animal
     * @param y int
     */
    public void setPosY(int y){
        this.posY = y;
    }    
    
    /**
     * Set the set of the animal randomly
     */
    public void setSex(){
        int rand = ((int)(Math.random() *2) + 1);
        
        this.sex = (rand != 1);
    }
    
    /**
     * Set the move behavior of the animal
     * @param bm BehaviorMove
     * @deprecated Never used
     */
    public void setBehavior(BehaviorMove bm){
        behaviorMove = bm;
    }

    /**
     * Birthday : Decrease the hunger by 1 and the reproductivity by 1 up to 0
     */
    public void birthday() {
        hunger --;
        
        if(reproductivity != 0){
            reproductivity --;
        }

        if(hunger ==0){
            alive = false;
        }
    }
}

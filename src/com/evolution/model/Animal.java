
package com.evolution.model;

import com.evolution.strategy.BehaviorEat;
import com.evolution.strategy.BehaviorMove;

/**
 *
 * @author Anthony
 */
public abstract class Animal implements CONSTANTS{
    protected     int         lifeTime;
    protected     int         hunger;
    protected     boolean     alive;
    protected     int         posX;
    protected     int         posY;
    protected     boolean     sex;
    protected     BehaviorMove behaviorMove;
    protected     BehaviorEat  behaviorEat;
    
    public abstract void makeAMove();
    public abstract void haveAMeal();
    public abstract void resetHunger();

    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public boolean getSex(){
        return this.sex;
    }
    
    public void setPosX(int x){
        this.posX = x;
    }
    
    public void setPosY(int y){
        this.posY = y;
    }    
    
    public void setSex(){
        int rand = ((int)(Math.random() *2) + 1);
        
        this.sex = (rand != 1);
    }
    
    public void setBehavior(BehaviorMove bm){
        behaviorMove = bm;
    }

    
    public void birthday() {
        hunger --;

        if(hunger ==0){
            alive = false;
            System.out.println("Mort de faim");
        }
    }
}


package com.evolution.model;

import java.io.Serializable;

/**
 * Class Square
 * @author Anthony
 */
public class Square implements Serializable{
    private     int         X;
    private     int         Y;
    private     int         numberOfAnimals;
    private     boolean     grass;
    private     boolean     minerals;
    private     int         danger;
    
    /**
     * Constructor of the square
     * @param x int Position X
     * @param y int Position Y
     */
    public Square(int x, int y){
        this.X = x;
        this.Y = y;
        this.numberOfAnimals = 0;
        this.grass = false;
        this.minerals = false;
        this.danger = 0;
    }
    
    /**
     * Return the position X of the square
     * @return int X
     */
    public int getX(){
        return this.X;
    }
    
    /**
     * Return the position Y of the square
     * @return int Y
     */
    public int getY(){
        return this.Y;
    }
    
    /**
     * Return the number of animals on the square
     * @return int Number of animals on the square
     */
    public int getNumberOfAnimals(){
        return numberOfAnimals;
    }
    
    /**
     * Return true if the square has grass
     * @return boolean
     */
    public boolean getGrass(){
        return this.grass;
    }
    
    /**
     * Return the value of the danger "Mainly used for the move of the sheep"
     * @return int
     */
    public int getDanger(){
        return danger;
    }
    
    /**
     * Return true if the square has minerals
     * @return boolean
     */
    public boolean getMinerals(){
        return this.minerals;
    }

    /**
     * Set the position X of the Square
     * @param x int X
     */
    public void setX(int x){
        this.X = x;
    }
    
    /**
     * Set the danger of the square
     * @param x int Danger
     */
    public void setDanger(int x){
        danger = x;
    }
    
    /**
     * Set the position Y of the square
     * @param y int Y
     */
    public void setY(int y){
        this.Y = y;
    }
    
    /**
     * Set the number of animals on the square
     * @param n int 
     */
    public void setNumberOfAnimals(int n){
        numberOfAnimals = n;
    }
    
    /**
     * Set true to put grass
     * @param bool boolean
     */
    public void setGrass(boolean bool){
        this.grass = bool;
    }
    
    /**
     * Set true to put minerals
     * @param bool boolean
     */
    public void setMinerals(boolean bool){
        this.minerals = bool;
    }
    
    /**
     * Add grass and remove minerals
     */
    public void addGrass(){
        setGrass(true);
        setMinerals(false);
    }
    
    /**
     * Add minerals if there is not grass
     */
    public void addMinerals(){
        if(!this.grass == true){
           setMinerals(true); 
        }
    }
    
    /**
     * Remove grass
     */
    public void removeGrass(){
        setGrass(false);
    }
    
}

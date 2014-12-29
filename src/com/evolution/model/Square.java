
package com.evolution.model;

/**
 *
 * @author Anthony
 */
public class Square {
    private     int         X;
    private     int         Y;
    private     int         numberOfAnimals;
    private     boolean     grass;
    private     boolean     minerals;
    private     int         danger;
    
    public Square(int x, int y){
        this.X = x;
        this.Y = y;
        this.numberOfAnimals = 0;
        this.grass = false;
        this.minerals = false;
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
    public int getNumberOfAnimals(){
        return numberOfAnimals;
    }
    public boolean getGrass(){
        return this.grass;
    }
    
    public boolean getMinerals(){
        return this.minerals;
    }

    public void setX(int x){
        this.X = x;
    }
    
    public void setY(int y){
        this.Y = y;
    }
    public void setNumberOfAnimals(int n){
        numberOfAnimals = n;
    }
    
    public void setGrass(boolean bool){
        this.grass = bool;
    }
    
    public void setMinerals(boolean bool){
        this.minerals = bool;
    }
    
    public void addGrass(){
        setGrass(true);
        setMinerals(false);
    }
    
    public void addMinerals(){
        if(!this.grass == true){
           setMinerals(true); 
        }
    }
    
    public void removeGrass(){
        setGrass(false);
    }
    
}

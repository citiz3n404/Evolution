
package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Sheep;

/**
 *
 * @author Anthony
 */
public class WolfEat implements BehaviorEat{
    Model m;
    
    public WolfEat(Model mParam){
        m = mParam;
    }
    
    @Override
    public void eat(Animal animal) {
        int x, y;
        
        x = animal.getPosX();
        y = animal.getPosY();
        
        if(m.world[x][y].getNumberOfAnimals() == 2){
            for(int i =0; i<m.getSizeAnimal(); i++){
                if(m.getAnimal(i) instanceof Sheep){
                    m.removeAnimal(m.getAnimal(i));
                    m.setNbSheep(m.getNbSheeps()-1);
                    animal.resetHunger();
                }
            }
        }
    }
    
}

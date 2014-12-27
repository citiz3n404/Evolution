
package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;

/**
 *
 * @author Anthony
 */
public class SheepEat implements BehaviorEat{
    Model m;
    
    public SheepEat(Model mParam){
        m = mParam;
    }

    @Override
    public void eat(Animal animal) {
        int x, y;
        
        x = animal.getPosX();
        y = animal.getPosY();
        
        if(m.world[x][y].getGrass()){
            m.setNbGrass(m.getNbGrass()-1);
            m.world[x][y].removeGrass();
            animal.resetHunger();
        }
        
    }
}

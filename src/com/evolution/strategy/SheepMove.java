
package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;

/**
 *
 * @author Anthony
 */
public class SheepMove implements BehaviorMove{
    
    Model m;
    
    public SheepMove(Model mParam){
        m = mParam;
    }

    @Override
    public void move(Animal animal) {
        // Implementer la recherche d'herbe
    }
    
}

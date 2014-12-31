
package com.evolution.strategy;

import com.evolution.model.Animal;

/**
 * Interface BehaviorMove / Pattern Strategy
 * @author Anthony
 */
public interface BehaviorMove {
    /**
     * Move the animal
     * @param animal Animal
     */
    public void move(Animal animal);
}

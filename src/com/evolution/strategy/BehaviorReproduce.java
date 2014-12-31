
package com.evolution.strategy;

import com.evolution.model.Animal;

/**
 * Interface BehaviorReproduce / Pattern Strategy
 * @author Anthony
 */
public interface BehaviorReproduce{
    /**
     * The animal reproduce himself
     * @param animal Animal
     */
    public void reproduce(Animal animal);
}


package com.evolution.strategy;

import com.evolution.model.Animal;

/**
 * Interface BehaviorEat / Pattern Strategy
 * @author Anthony
 */
public interface BehaviorEat{
    /**
     * The animal eat
     * @param animal Animal
     */
    public void eat(Animal animal);
}

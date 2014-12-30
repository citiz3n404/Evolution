
package com.evolution.observer;

import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public interface Observer extends Serializable{
    /**
     * Fonction qui met à jour 
     */
    public void update();
}

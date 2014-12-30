
package com.evolution.observer;

import java.io.Serializable;

/**
 *
 * @author Anthony
 */
public interface Observable extends Serializable{
    /**
     * Ajoute un sujet à la liste des objets à notifier
     * @param o 
     */
    public void registerObserver(Observer o);
    
    /**
     * Supprime un sujet de la liste des objets à notifier
     * @param o 
     */
    public void deleteObserver(Observer o);
    
    /**
     * Fonction de notification.
     */
    public void notifyObserver();
    
}

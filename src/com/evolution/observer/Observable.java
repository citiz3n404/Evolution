
package com.evolution.observer;

/**
 *
 * @author Anthony
 */
public interface Observable {
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

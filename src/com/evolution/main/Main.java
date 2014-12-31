
package com.evolution.main;

import com.evolution.controller.Controller;
import com.evolution.model.Model;
import com.evolution.observer.Observer;
import com.evolution.view.View;

/**
 * Main class that execute the MVC program
 * @author Anthony
 */
public class Main {

    public Model m;
    public Controller c;
    public View v;
    
    /**
     * Constructor of the main class
     */
    public Main(){
        m = new Model();
        c = new Controller(m);
        v = new View(c);
    }
    
    /**
     * Main function that execute the program
     * @param args 
     */
    public static void main(String[] args){
        Main program = new Main();
    }
}

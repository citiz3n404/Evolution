
package com.evolution.main;

import com.evolution.controller.Controller;
import com.evolution.model.Model;
import com.evolution.observer.Observer;
import com.evolution.view.View;

/**
 * Class principale contenant la fonction main
 * @author Anthony
 */
public class Main {

    public Model m;
    public Controller c;
    public View v;
    
    public Main(){
        m = new Model();
        c = new Controller(m);
        v = new View(c);
    }
    
    public static void main(String[] args){
        Main program = new Main();
    }
}

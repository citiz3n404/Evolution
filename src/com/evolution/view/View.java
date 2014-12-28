package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import com.evolution.model.Model;
import com.evolution.observer.Observable;
import com.evolution.observer.Observer;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Anthony
 */
public class View extends JFrame implements CONSTANTS, Observer {

    JPanel buttonBar;
    JPanel world;
    JPanel counters;
    Controller c;

    public View(Controller cParam) {
        c = cParam;
        buttonBar = new JPanelButtonBar(c);
        counters = new JPanelCounters(c);
        world = new JPanelWorld(c);
        
        c.m.registerObserver((Observer) buttonBar);
        c.m.registerObserver((Observer) counters);
        c.m.registerObserver((Observer) world);

        this.pack();
        this.setSize(FRAME_SIZE_L, FRAME_SIZE_H);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(FRAME_TITLE);
        this.setLayout(new BorderLayout());

        this.getContentPane().add(buttonBar, BorderLayout.NORTH);
        this.getContentPane().add(counters, BorderLayout.WEST);
        this.getContentPane().add(world, BorderLayout.CENTER);
    }

    @Override
    public void update() {
   
    }
}


package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import com.evolution.observer.Observer;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Anthony
 */
public class JPanelCounters extends JPanel implements CONSTANTS, Observer{
    JLabel laps             = new JLabel("LAPS", SwingConstants.CENTER);
    JLabel wolfs            = new JLabel("WOLFS", SwingConstants.CENTER);
    JLabel sheeps           = new JLabel("SHEEPS", SwingConstants.CENTER);
    JLabel grass            = new JLabel("GRASS", SwingConstants.CENTER);
    JLabel minerals         = new JLabel("MINERALS", SwingConstants.CENTER);
    
    JLabel nbLaps           = new JLabel("0", SwingConstants.CENTER);;
    JLabel nbWolfs;          
    JLabel nbSheeps;
    JLabel nbGrass;
    JLabel nbMinerals;
    
    GridBagConstraints c    = new GridBagConstraints();
    Controller controller;
    
    public JPanelCounters(Controller cParam){
        controller = cParam;
        
        nbWolfs = new JLabel(String.valueOf(controller.m.getNbWolfs()), SwingConstants.CENTER);
        nbSheeps = new JLabel(String.valueOf(controller.m.getNbSheeps()), SwingConstants.CENTER);
        nbGrass = new JLabel(String.valueOf(controller.m.getNbGrass()), SwingConstants.CENTER);
        nbMinerals = new JLabel(String.valueOf(controller.m.getNbMinerals()), SwingConstants.CENTER);
        
        this.setBackground(new Color(20,20,20));
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        laps.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_SIZE));
        laps.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,0,10);
        c.gridx = 0;
        c.gridy = 0;
        this.add(laps, c);
        
        nbLaps.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_NUMBERS));
        nbLaps.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 1;
        this.add(nbLaps, c);
        
        wolfs.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_SIZE));
        wolfs.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,0,10);
        c.gridx = 0;
        c.gridy = 2;
        this.add(wolfs, c);
        
        
        nbWolfs.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_NUMBERS));
        nbWolfs.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 3;
        this.add(nbWolfs, c);
        
        sheeps.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_SIZE));
        sheeps.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,0,10);
        c.gridx = 0;
        c.gridy = 4;
        this.add(sheeps, c);
        
        nbSheeps.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_NUMBERS));
        nbSheeps.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 5;
        this.add(nbSheeps, c);
        
        grass.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_SIZE));
        grass.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,0,10);
        c.gridx = 0;
        c.gridy = 6;
        this.add(grass, c);
        
        nbGrass.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_NUMBERS));
        nbGrass.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 7;
        this.add(nbGrass, c);
        
        minerals.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_SIZE));
        minerals.setForeground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,0,10);
        c.gridx = 0;
        c.gridy = 8;
        this.add(minerals,c);
        
        nbMinerals.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,FONT_COUNTERS_NUMBERS));
        nbMinerals.setForeground(Color.WHITE);
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 9;
        this.add(nbMinerals, c);
    }

    @Override
    public void update() {
        //JLabel test = new JLabel(String.valueOf(controller.m.getNbWolfs()), SwingConstants.CENTER);
       
        nbLaps.setText(String.valueOf(controller.m.getNbLaps()));
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 1;
        this.add(nbLaps, c);
        
        nbWolfs.setText(String.valueOf(controller.m.getNbWolfs()));
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 3;
        this.add(nbWolfs, c);
        
        nbSheeps.setText(String.valueOf(controller.m.getNbSheeps()));
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 5;
        this.add(nbSheeps, c);
        
        nbGrass.setText(String.valueOf(controller.m.getNbGrass()));
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 7;
        this.add(nbGrass, c);
        
        nbMinerals.setText(String.valueOf(controller.m.getNbMinerals()));
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,20,10);
        c.gridx = 0;
        c.gridy = 9;
        this.add(nbMinerals, c);

    }

}

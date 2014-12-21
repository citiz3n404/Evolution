/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.Animal;
import com.evolution.model.CONSTANTS;
import static com.evolution.model.CONSTANTS.FONT_COUNTERS_SIZE;
import com.evolution.model.Model;
import com.evolution.model.Sheep;
import com.evolution.model.Wolf;
import com.evolution.observer.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Anthony
 */
public class JPanelWorld extends JPanel implements CONSTANTS, Observer {
    GridBagConstraints c      = new GridBagConstraints();
    Controller  controller;
    JPanel      pan           = new JPanel();
    ImageIcon   imgBack       = new ImageIcon(PATH_IMG + "groundg.png");
    ImageIcon   imgGrass      = new ImageIcon(PATH_IMG + "grass.png");
    ImageIcon   imgWolf       = new ImageIcon(PATH_IMG + "mwolf.png");
    ImageIcon   imgWolf2      = new ImageIcon(PATH_IMG + "wolf.png");
    ImageIcon   imgSheep      = new ImageIcon(PATH_IMG + "msheep.png");
    ImageIcon   imgSheep2     = new ImageIcon(PATH_IMG + "sheep.png");
    ImageIcon   imgMinerals   = new ImageIcon(PATH_IMG + "minerals.png");
    ImageIcon   imgTreeTop    = new ImageIcon(PATH_IMG + "treetop.png");
    ImageIcon   imgTreeSide   = new ImageIcon(PATH_IMG + "treeside.png");
    ImageIcon   imgTreeDown   = new ImageIcon(PATH_IMG + "treedown.png");

    public JPanelWorld(Controller cParam) {
        controller = cParam;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
    }

    public void printWorld() {

        pan.setLayout(new GridBagLayout());
        pan.setBackground(Color.BLACK);
        Animal animal;

        for (int z = 0; z < controller.m.getSizeAnimal(); z++) {
            c.fill = GridBagConstraints.HORIZONTAL;
            c.fill = GridBagConstraints.VERTICAL;
            //c.insets = new Insets(1, 1, 1, 1);

            animal = controller.m.getAnimal(z);
            c.gridx = animal.getPosX()+1;
            c.gridy = animal.getPosY()+1;

            if (animal instanceof Wolf) {
                if(animal.getSex()){
                    pan.add(new JLabel(imgWolf), c);
                }
                else{
                    pan.add(new JLabel(imgWolf2), c);
                }
            } else if (animal instanceof Sheep) {
                if(animal.getSex()){
                    pan.add(new JLabel(imgSheep), c);
                }
                else{
                    pan.add(new JLabel(imgSheep2), c);
                }
            } else {
                pan.add(new JLabel(imgGrass), c);
            }

        }

        for (int i = 0; i < controller.m.getSizeX(); i++) {

            for (int j = 0; j < controller.m.getSizeY(); j++) {
                c.fill = GridBagConstraints.HORIZONTAL;
                c.fill = GridBagConstraints.VERTICAL;
                //c.insets = new Insets(1, 1, 1, 1);
                c.gridx = i+1;
                c.gridy = j+1;
                
                if (controller.m.world[i][j].getGrass()) {
                    pan.add(new JLabel(imgGrass), c);
                }
                
                if (controller.m.world[i][j].getMinerals()) {
                    pan.add(new JLabel(imgMinerals), c);
                }

            }
        }
        
        for (int i = 0; i < controller.m.getSizeX()+2; i++) {

            for (int j = 0; j < controller.m.getSizeY()+2; j++) {
                c.fill = GridBagConstraints.HORIZONTAL;
                c.fill = GridBagConstraints.VERTICAL;
                //c.insets = new Insets(1, 1, 1, 1);
                c.gridx = i;
                c.gridy = j;
     
                if(i ==0 || i== controller.m.getSizeX()+1){
                    pan.add(new JLabel(imgTreeSide), c);
                }
                if(j ==0){
                    pan.add(new JLabel(imgTreeTop), c);
                }
                if(j == controller.m.getSizeY() +1){
                    pan.add(new JLabel(imgTreeDown), c);
                }
                else{
                    pan.add(new JLabel(imgBack), c);
                }
                

            }
        }

        this.add(pan, BorderLayout.CENTER);

    }

    @Override
    public void update() {

        if (controller.m.validWorld) {
            this.remove(pan);
            pan = new JPanel();
            printWorld();
            this.add(pan);
        }
    }
}

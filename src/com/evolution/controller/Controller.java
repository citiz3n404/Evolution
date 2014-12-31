package com.evolution.controller;

import com.evolution.model.CONSTANTS;
import com.evolution.model.Model;
import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * Controller of the MVC
 * @author Anthony
 */
public class Controller implements CONSTANTS, Serializable {

    public Model m;
    private int[] tempTab;

    /**
     * Constructor of the controller
     * @param mParam Model
     */
    public Controller(Model mParam) {
        m = mParam;
        tempTab = new int[10];

    }

    /**
     * Quit the program
     */
    public void endWindow() {
        System.exit(0);
    }

    /**
     * Open a JFileChooser and use a save method to save the model
     */
    public void saveWorld() {
        String txt = new String();
        JFileChooser chooser = new JFileChooser();
        chooser.setPreferredSize (new java.awt.Dimension (JFILECHOOSER_SIZE_L, JFILECHOOSER_SIZE_H));
        chooser.setApproveButtonText("Enregistrer");
        chooser.setDialogTitle("SAVE");
        chooser.setCurrentDirectory(null);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selection = chooser.getSelectedFile();
            txt = selection.getPath();
            System.out.println(txt);
            m.saveModel(txt);
        }

        
    }

    /**
     * Open a JFileChooser to load a saved world
     */
    public void loadWorld() {

        String txt = new String();
        JFileChooser chooser = new JFileChooser();
        chooser.setPreferredSize (new java.awt.Dimension (JFILECHOOSER_SIZE_L, JFILECHOOSER_SIZE_H));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selection = chooser.getSelectedFile();
            txt = selection.getPath();
            
            System.out.println(txt);

            m.loadModel(txt);
        }

    }

    /**
     * Initalize the parameters of the model with Optimal parameters in the 
     * Constants interface
     */
    public void initOptimal() {

        /*
         0 -> SIZEX  1 -> SIZEY  2 -> WOLF  3 -> SHEEP  4 -> GRASS
         5 -> MINERALS  6 -> NB CASES  7 -> NB ANIMALS 8 -> NB GRASS + MINERALS
         */
        tempTab[0] = NB_COLUMN_OPTIMAL;
        tempTab[1] = NB_LINE_OPTIMAL;
        tempTab[2] = NB_WOLFS_OPTIMAL;
        tempTab[3] = NB_SHEEPS_OPTIMAL;
        tempTab[4] = NB_GRASS_OPTIMAL;
        tempTab[5] = NB_MINERALS_OPTIMAL;
        tempTab[6] = tempTab[0] * tempTab[1];
        tempTab[7] = tempTab[2] + tempTab[3];
        tempTab[8] = tempTab[4] + tempTab[5];
        m.notifyObserver();
    }

    /**
     * Initialize the parameters of the model with random values
     */
    public void initRandom() {
        tempTab[0] = (int) (Math.random() * (30 - 10)) + 10;
        tempTab[1] = (int) (Math.random() * (30 - 10)) + 10;
        tempTab[2] = (int) (Math.random() * (20 - 5)) + 5;
        tempTab[3] = (int) (Math.random() * (30 - 10)) + 10;
        tempTab[4] = (int) (Math.random() * (50 - 10)) + 10;
        tempTab[5] = (int) (Math.random() * (50 - 10)) + 10;
        tempTab[6] = tempTab[0] * tempTab[1];
        tempTab[7] = tempTab[2] + tempTab[3];
        tempTab[8] = tempTab[4] + tempTab[5];
        m.notifyObserver();
    }

    /**
     * Set the values from the controller to the model
     */
    public void setValues() {
        m.setSizeX(tempTab[0]);
        m.setSizeY(tempTab[1]);
        m.setNbWolfs(tempTab[2]);
        m.setNbSheep(tempTab[3]);
        m.setNbGrass(tempTab[4]);
        m.setNbMinerals(tempTab[5]);
        m.setNbSquare(tempTab[6]);
        m.setNbAnimals(tempTab[7]);
        m.setNbElements(tempTab[8]);
    }

    /**
     * If the values in the JDialog are correct, it returns true, else false
     * @return boolean
     */
    public boolean fieldValidation() {
        if (((tempTab[0] * tempTab[1]) >= (tempTab[3] + tempTab[2])) && ((tempTab[0] * tempTab[1]) >= (tempTab[4] + tempTab[5])) && tempTab[0] > 0 && tempTab[1] > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return a value of the tempArray of the controller contained in the index
     * @param index int
     * @return int
     */
    public int getValueTempTab(int index) {
        return tempTab[index];
    }

    /**
     * Set the value of the tempArray contained in the index by v and notify observers
     * @param index int
     * @param v int
     */
    public void setTempTab(int index, int v) {
        this.tempTab[index] = v;

        if (index == 0 || index == 1) {
            this.tempTab[6] = tempTab[0] * tempTab[1];
        } else if (index == 2 || index == 3) {
            this.tempTab[7] = tempTab[2] + tempTab[3];
        } else if (index == 4 || index == 5) {
            this.tempTab[8] = tempTab[4] + tempTab[5];
        }
        m.notifyObserver();

    }

    /**
     * Initialize the simulation, creating squares, animals, grass and minerals
     * then notify observers
     */
    public void initSimulation() {
        m.initUniverse(); // Crée les cases
        m.initAnimals(); // Crée les animaux
        m.initElements(); // herbe et mineraux
        m.notifyObserver(); // Actualise

        m.playSimulation();

    }

}

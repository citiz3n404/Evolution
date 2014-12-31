package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import com.evolution.observer.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Open a JDialog with differents field and option for building the world
 * @author Anthony
 */
public class JDialogParameters extends JDialog implements CONSTANTS, Observer{

    //**************************************************************************
    // VARIABLES
    //**************************************************************************
    private JLabel icon;
    private JLabel messageLabel;
    private JButton validateButton, cancelButton;
    JButton randomButton = new JButton("Paramètres Aléatoires");
    JButton definedButton = new JButton("Paramètres Optimaux");
    Controller c;
    JPanel control = new JPanel();
    JPanel areaMessage = new JPanel();

    JFormattedTextField nbWolfs = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField nbSheeps = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField nbGrass = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField nbMinerals = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField speedField = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField sizeX = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JFormattedTextField sizeY = new JFormattedTextField(NumberFormat.getIntegerInstance());
    JLabel messageHeadLabel = new JLabel("Attention, tous les champs doivent être remplis");

    
    
    
    
    
    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    /**
     * Constructor of the JDialog
     * @param cParam Controller
     */
    public JDialogParameters(Controller cParam) {
        c = cParam;
        c.m.registerObserver((Observer) this);

        this.pack();
        this.setTitle(JDIALOG_TITLE);
        this.setSize(JDIALOG_SIZE_L, JDIALOG_SIZE_H);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        this.initComponents();

    }

    
    
    
    
    
    //**************************************************************************
    // METHODS
    //**************************************************************************
    /**
     * Initalize all components of the JDialog
     */
    private void initComponents() {

        // VARIABLES -----------------------------------------------------------
        icon = new JLabel(new ImageIcon(PATH_IMG + "worldbuilder.png"));

        validateButton = new JButton("Validate");
        cancelButton = new JButton("Cancel");
        JPanel panIcon = new JPanel();

        JPanel numberAnimals = new JPanel();
        JPanel numberGrass = new JPanel();
        JPanel sizeField = new JPanel();
        JPanel buttons = new JPanel();
        JPanel speed = new JPanel();

        JPanel content = new JPanel();

        JLabel nbWolfsLabel = new JLabel("Nombre de Loups :");
        JLabel nbSheepsLabel = new JLabel("Nombre de Moutons :");
        JLabel nbGrassLabel = new JLabel("Nombre d'Herbe :");
        JLabel nbMineralsLabel = new JLabel("Nombre de Minéraux :");

        JLabel sizeXLabel = new JLabel("Nombre de Colones :");
        JLabel sizeYLabel = new JLabel("Nombre de Lignes :");
        JLabel speedLabel = new JLabel("Temps de visualisation par tour :");


        /*
         0 -> SIZEX  1 -> SIZEY  2 -> WOLF  3 -> SHEEP  4 -> GRASS
         5 -> MINERALS  6 -> NB CASES  7 -> NB ANIMALS 8 -> NB GRASS + MINERALS
         */
        nbWolfs.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(nbWolfs.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(2, i);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        nbSheeps.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(nbSheeps.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(3, i);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        nbGrass.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(nbGrass.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(4, i);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        nbMinerals.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(nbMinerals.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(5, i);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        sizeX.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(sizeX.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(0, i);;

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        sizeY.getDocument().addDocumentListener(new DocumentListener() {
            private void updateData() {
                int i = 0;

                try {
                    i = Integer.parseInt(sizeY.getText());
                    System.out.println("Nombre calculé : " + i);
                } catch (NumberFormatException e) {
                    //System.out.println("Error : "+e.getMessage());
                }

                //On envoit la valeur du champ au controler qui modifie le model
                c.setTempTab(1, i);

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateData();
            }
        });

        //Image
        panIcon.setLayout(new BorderLayout());
        panIcon.add(icon);

        // Champ animaux
        numberAnimals.setPreferredSize(new Dimension(380, 60));
        sizeField.setPreferredSize(new Dimension(380, 60));
        numberGrass.setPreferredSize(new Dimension(380, 60));
        speed.setPreferredSize(new Dimension(380, 60));

        nbWolfs.setPreferredSize(new Dimension(50, 25));
        nbSheeps.setPreferredSize(new Dimension(50, 25));
        nbGrass.setPreferredSize(new Dimension(50, 25));
        nbMinerals.setPreferredSize(new Dimension(50, 25));
        sizeX.setPreferredSize(new Dimension(50, 25));
        sizeY.setPreferredSize(new Dimension(50, 25));
        speedField.setPreferredSize(new Dimension(50, 25));

        numberAnimals.setBorder(BorderFactory.createTitledBorder("Paramètres animaux"));
        numberGrass.setBorder(BorderFactory.createTitledBorder("Paramètres du Terrain"));
        sizeField.setBorder(BorderFactory.createTitledBorder("Taille du Terrain"));
        speed.setBorder(BorderFactory.createTitledBorder("Vitesse de Simulation"));

        sizeField.add(sizeXLabel);
        sizeField.add(sizeX);
        sizeField.add(sizeYLabel);
        sizeField.add(sizeY);

        numberAnimals.add(nbWolfsLabel);
        numberAnimals.add(nbWolfs);
        numberAnimals.add(nbSheepsLabel);
        numberAnimals.add(nbSheeps);

        numberGrass.add(nbGrassLabel);
        numberGrass.add(nbGrass);
        numberGrass.add(nbMineralsLabel);
        numberGrass.add(nbMinerals);

        speed.add(speedLabel);
        speed.add(speedField);

        buttons.add(randomButton);
        buttons.add(definedButton);

        content.add(sizeField);
        content.add(numberAnimals);
        content.add(numberGrass);
        content.add(speed);
        content.add(buttons);

        control.setBackground(Color.lightGray);
        control.add(validateButton);
        control.add(cancelButton);

        validateButton.setEnabled(false);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                setVisible(false);
            }
        });

        definedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                c.initOptimal();
                updateFields();
            }
        });

        randomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                c.initRandom();
                updateFields();
            }
        });

        validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                c.m.resetModel();
                setVisible(false);
                c.setValues();
                c.m.validWorld = true;
                c.initSimulation();
                
                c.m.setBtn(1, false);
                c.m.setBtn(2, false);
                c.m.setBtn(3, false);
                
            }
        });

        areaMessage.add(messageHeadLabel);
        areaMessage.setBackground(Color.lightGray);
        this.getContentPane().add(areaMessage, BorderLayout.NORTH);
        this.getContentPane().add(panIcon, BorderLayout.WEST);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }

    /**
     * Update the values of an Array in the controller with le current values 
     * of the fields
     */
    public void updateFields() {
        sizeX.setText(String.valueOf(c.getValueTempTab(0)));
        sizeY.setText(String.valueOf(c.getValueTempTab(1)));
        nbWolfs.setText(String.valueOf(c.getValueTempTab(2)));
        nbSheeps.setText(String.valueOf(c.getValueTempTab(3)));
        nbGrass.setText(String.valueOf(c.getValueTempTab(4)));
        nbMinerals.setText(String.valueOf(c.getValueTempTab(5)));

        //speedField.setText(String.valueOf(c.m.getSpeed()));
    }

    /**
     * Pattern Observer, update buttons saying if is enabled of not and if
     * values are correct or not
     */
    @Override
    public void update() {
        if (c.fieldValidation()) {
            validateButton.setEnabled(true);
            areaMessage.setBackground(new Color(0, 160, 0));
            messageHeadLabel.setForeground(Color.WHITE);
            messageHeadLabel.setText("LES INFORMATIONS SONT VALIDES");
        } else {
            validateButton.setEnabled(false);
            areaMessage.setBackground(Color.RED);
            messageHeadLabel.setForeground(Color.WHITE);
            messageHeadLabel.setText("/!\\ WARNING ! Certaines informations sont absurdes /!\\");
        }

    }

}

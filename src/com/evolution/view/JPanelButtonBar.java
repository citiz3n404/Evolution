package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import com.evolution.observer.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Anthony
 */
public class JPanelButtonBar extends JPanel implements CONSTANTS, Observer {

    private JButton startBtn;
    private JButton stopBtn;
    private JButton saveBtn;

    public Controller c;

    ActionButton a = new ActionButton();

    public JPanelButtonBar(Controller cParam) {
        c = cParam;

        startBtn = new JButton(new ImageIcon(PATH_IMG + "start.png"));
        startBtn.setActionCommand("START");
        startBtn.addActionListener(a);
        startBtn.setPreferredSize(new Dimension(40, 40));

        stopBtn = new JButton(new ImageIcon(PATH_IMG + "pause.png"));
        stopBtn.setActionCommand("STOP");
        stopBtn.addActionListener(a);
        stopBtn.setPreferredSize(new Dimension(40, 40));

        saveBtn = new JButton(new ImageIcon(PATH_IMG + "save.png"));
        saveBtn.setActionCommand("SAVE");
        saveBtn.addActionListener(a);
        saveBtn.setPreferredSize(new Dimension(40, 40));

        this.add(startBtn);
        this.add(stopBtn);
        this.add(saveBtn);
    }

    @Override
    public void update() {

    }

    class ActionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("START")) {
                JDialogParameters param = new JDialogParameters(c);
                //startBtn.setEnabled(false); 
                // On entre une fonction du controler qui met à jour le model et
                // dit à la vue de se mettre à jour sur le model
            }

            if (e.getActionCommand().equals("STOP")) {
                c.endWindow();
            }
            
            if (e.getActionCommand().equals("SAVE")) {
                
                c.m.playATurn();
            }
        }

    }
}

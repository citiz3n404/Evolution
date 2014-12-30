package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import static com.evolution.model.CONSTANTS.PATH_IMG;
import com.evolution.observer.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Anthony
 */
public class JPanelButtonBar extends JPanel implements CONSTANTS, Observer, Serializable {

    private JButton initBtn;
    private JButton quitBtn;
    private JButton playBtn;
    private JButton saveBtn;
    private JButton resetBtn;
    private JButton loadBtn;

    public Controller c;

    ActionButton a = new ActionButton();

    public JPanelButtonBar(Controller cParam) {
        c = cParam;

        initBtn = new JButton(new ImageIcon(PATH_IMG + "init.png"));
        initBtn.setActionCommand("INIT");
        initBtn.addActionListener(a);
        initBtn.setPreferredSize(new Dimension(40, 40));

        quitBtn = new JButton(new ImageIcon(PATH_IMG + "quit.png"));
        quitBtn.setActionCommand("QUIT");
        quitBtn.addActionListener(a);
        quitBtn.setPreferredSize(new Dimension(40, 40));

        playBtn = new JButton(new ImageIcon(PATH_IMG + "play.png"));
        playBtn.setActionCommand("PLAY");
        playBtn.addActionListener(a);
        playBtn.setPreferredSize(new Dimension(40, 40));
        
        loadBtn = new JButton(new ImageIcon(PATH_IMG + "load.png"));
        loadBtn.setActionCommand("LOAD");
        loadBtn.addActionListener(a);
        loadBtn.setPreferredSize(new Dimension(40, 40));
        
        resetBtn = new JButton(new ImageIcon(PATH_IMG + "reset.png"));
        resetBtn.setActionCommand("RESET");
        resetBtn.addActionListener(a);
        resetBtn.setPreferredSize(new Dimension(40, 40));
        
        saveBtn = new JButton(new ImageIcon(PATH_IMG + "save.png"));
        saveBtn.setActionCommand("SAVE");
        saveBtn.addActionListener(a);
        saveBtn.setPreferredSize(new Dimension(40, 40));

        this.add(initBtn);
        this.add(playBtn);
        this.add(saveBtn);
        this.add(loadBtn);
        this.add(resetBtn);
        this.add(quitBtn);
        
        playBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        //loadBtn.setEnabled(false);
    }

    @Override
    public void update() {
         /**
         * 0-init / 1-play /2-save /3-reset /4-quit
         */
        initBtn.setEnabled(!c.m.validBtn[0]);
        playBtn.setEnabled(!c.m.validBtn[1]);
        saveBtn.setEnabled(!c.m.validBtn[2]);
        resetBtn.setEnabled(!c.m.validBtn[3]);
        quitBtn.setEnabled(!c.m.validBtn[4]);
    }

    class ActionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("INIT")) {
                JDialogParameters param = new JDialogParameters(c);
            }

            if (e.getActionCommand().equals("LOAD")) {
                
                c.loadWorld();
            }
            
            if (e.getActionCommand().equals("PLAY")) {
                
                c.m.playATurn();
            }
            
            if (e.getActionCommand().equals("SAVE")) {

                c.m.saveModel(PATH_IMG);
              
            }
            
            if (e.getActionCommand().equals("QUIT")) {
                
                c.endWindow();
              
            }
            
            if (e.getActionCommand().equals("RESET")) {
                
                c.m.resetModel();
                c.m.setBtn(0, false);
                c.m.setBtn(1, true);
                c.m.setBtn(2, true);
                c.m.setBtn(3, true);
            }
        }

    }
}

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

    private JButton initBtn;
    private JButton stopBtn;
    private JButton playBtn;
    private JButton saveBtn;
    private JButton resetBtn;

    public Controller c;

    ActionButton a = new ActionButton();

    public JPanelButtonBar(Controller cParam) {
        c = cParam;

        initBtn = new JButton(new ImageIcon(PATH_IMG + "init.png"));
        initBtn.setActionCommand("INIT");
        initBtn.addActionListener(a);
        initBtn.setPreferredSize(new Dimension(40, 40));

        stopBtn = new JButton(new ImageIcon(PATH_IMG + "quit.png"));
        stopBtn.setActionCommand("STOP");
        stopBtn.addActionListener(a);
        stopBtn.setPreferredSize(new Dimension(40, 40));

        playBtn = new JButton(new ImageIcon(PATH_IMG + "play.png"));
        playBtn.setActionCommand("PLAY");
        playBtn.addActionListener(a);
        playBtn.setPreferredSize(new Dimension(40, 40));
        
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
        this.add(resetBtn);
        this.add(stopBtn);
        
        playBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        resetBtn.setEnabled(false);
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
        stopBtn.setEnabled(!c.m.validBtn[4]);
    }

    class ActionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("INIT")) {
                JDialogParameters param = new JDialogParameters(c);
                //playBtn.setEnabled(true); 
                // On entre une fonction du controler qui met à jour le model et
                // dit à la vue de se mettre à jour sur le model
            }

            if (e.getActionCommand().equals("STOP")) {
                c.endWindow();
            }
            
            if (e.getActionCommand().equals("PLAY")) {
                
                c.m.playATurn();
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

package rpg.java.swing.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import rpg.java.swing.MainFrame;

public class GameOverButtons extends JPanel{
    private final JButton RESTART = new JButton("Restart");
    private final JButton NEW_PLAYER = new JButton("New Player");
    private final JButton EXIT = new JButton("Exit");

    public void beginFrame(){
        this.setLayout(new FlowLayout());
        this.initButtons();
        this.add(RESTART);
        this.add(NEW_PLAYER);
        this.add(EXIT);
    }

    private void initButtons(){
        this.RESTART.addActionListener(e -> MainFrame.exitGame());
    }
}

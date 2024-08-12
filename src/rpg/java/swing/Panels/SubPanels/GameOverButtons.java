package rpg.java.swing.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.swing.MainFrame;

public class GameOverButtons extends JPanel{
    private final JButton RESTART = new JButton("Restart");
    private final JButton NEW_PLAYER = new JButton("New Player");
    private final JButton EXIT = new JButton("Exit");
    private final JButton SHOW_ALL = new JButton("Show All");
    public void beginFrame(){
        this.setLayout(new FlowLayout());
        this.initButtons();
        this.add(RESTART);
        this.add(NEW_PLAYER);
        this.add(EXIT);
        this.add(SHOW_ALL);
    }

    private void initButtons(){
        this.EXIT.addActionListener(e -> MainFrame.exitGame());
        this.NEW_PLAYER.addActionListener(e -> Main.resetAll());
        this.SHOW_ALL.addActionListener(e -> Main.showAllScores());
    }
}

package rpg.java.swing.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import rpg.java.Difficulty;
import rpg.java.Main;
import rpg.java.swing.MainFrame;

public class GameOverButtons extends JPanel{
    private final JButton REPLAY = new JButton("Replay");
    private final JButton NEW_PLAYER = new JButton("New Player");
    private final JButton EXIT = new JButton("Exit");
    private final JComboBox<String> DIFFICULTY_COMBO = new JComboBox<String>();  
    public GameOverButtons(){
        DIFFICULTY_COMBO.addItem("Easy");
        DIFFICULTY_COMBO.addItem("Normal");
        DIFFICULTY_COMBO.addItem("Hard");
        DIFFICULTY_COMBO.addItem("All");
    }
    public void beginFrame(){
        this.setLayout(new FlowLayout());
        this.initButtons();
        this.add(REPLAY);
        this.add(NEW_PLAYER);
        this.add(EXIT);
        this.add(DIFFICULTY_COMBO);
        switch (Main.difficulty) {
            case EASY:
                DIFFICULTY_COMBO.setSelectedItem("Easy");
                break;
            case NORMAL:
                DIFFICULTY_COMBO.setSelectedItem("Normal");
                break;
            case HARD:
                DIFFICULTY_COMBO.setSelectedItem("Hard");
                break;
            default:
                break;
        }
    }

    private void initButtons(){
        this.EXIT.addActionListener(e -> MainFrame.exitGame());
        this.NEW_PLAYER.addActionListener(e -> Main.resetAll());
        this.DIFFICULTY_COMBO.addActionListener(e -> {
            if(DIFFICULTY_COMBO.getSelectedItem().toString().equals("All")){
                Main.showAllScores();
                return;
            }
            Main.difficulty = Difficulty.valueOf(DIFFICULTY_COMBO.getSelectedItem().toString().toUpperCase());
            Main.showFilteredScores(Main.difficulty);
        });
        this.REPLAY.addActionListener(e -> Main.replay());
    }
}

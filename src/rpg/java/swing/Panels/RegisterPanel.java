package rpg.java.swing.Panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rpg.java.Difficulty;
import rpg.java.Main;
import rpg.java.characters.PlayerCharacter;
import rpg.java.swing.Panels.SubPanels.ColorPanel;

public class RegisterPanel extends JPanel{
    public final JButton submitButton = new JButton("Submit");
    public final JTextArea nameArea = new JTextArea("Player");
    public final ColorPanel colorPanel = new ColorPanel();
    public final JComboBox<String> difficulty = new JComboBox<String>();
    private final GridBagConstraints c = new GridBagConstraints();

    public RegisterPanel(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setLayout(new GridBagLayout());
        this.c.gridy = 0;
        this.add(this.colorPanel, this.c);
        this.c.gridy++;
        this.nameArea.setSize(100,this.nameArea.getHeight());
        this.add(this.nameArea, this.c);
        this.c.gridy++;
        this.submitButton.addActionListener((e -> this.submit()));
        this.add(this.submitButton, this.c);

        
        this.difficulty.addItem("Easy");
        this.difficulty.addItem("Normal");
        this.difficulty.addItem("Hard");
        this.add(this.difficulty);


    }
    public void submit(){
        Main.player = new PlayerCharacter(this.nameArea.getText());
        Main.player.color = this.colorPanel.getColor();
        this.setBackground(Main.player.color);
        System.out.println("Added Player");

        switch (this.difficulty.getSelectedIndex()) {
            case 0:
                Main.difficulty = Difficulty.EASY;
                break;
            case 1:
                Main.difficulty = Difficulty.NORMAL;
                break;
            case 2:
                Main.difficulty = Difficulty.HARD;
                break;
            default:
                Main.difficulty = Difficulty.NORMAL;
                break;
        }
        Main.FRAME.beginGame();
    }
}

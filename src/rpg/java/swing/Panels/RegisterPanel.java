package rpg.java.swing.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rpg.java.DefaultColors;
import rpg.java.Difficulty;
import rpg.java.Fonts;
import rpg.java.Main;
import rpg.java.Interfaces.iGradient;
import rpg.java.characters.PlayerCharacter;
import rpg.java.swing.Panels.SubPanels.ColorPanel;

public class RegisterPanel extends JPanel implements iGradient{
    public final JButton submitButton = new JButton("Submit");
    public final JTextArea nameArea = new JTextArea("Player");
    public final ColorPanel colorPanel = new ColorPanel();
    public final JComboBox<String> difficulty = new JComboBox<String>();

    // Labels
    private final JLabel header = new JLabel("Register");
    private final JLabel playerLabel = new JLabel("Player Name: ");

    private final GridBagConstraints c = new GridBagConstraints();

    public RegisterPanel(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setFonts();
        this.setLayout(new GridBagLayout());
        this.c.gridy = 0;
        this.addGridY(this.header);
        this.addGridY(this.colorPanel);
        this.nameArea.setSize(100,this.nameArea.getHeight());
        this.addGridY(this.playerLabel);
        this.addGridY(this.nameArea);
        this.submitButton.addActionListener((e -> this.submit()));
        this.addGridY(this.submitButton);

        
        this.difficulty.addItem("Easy");
        this.difficulty.addItem("Normal");
        this.difficulty.addItem("Hard");
        this.addGridY(this.difficulty);


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
    private void setFonts(){
        this.header.setFont(Fonts.HEADER);
        this.playerLabel.setFont(Fonts.NORMAL);
    }
    private void addGridY(Component component){
        this.add(component, this.c);
        this.c.gridy++;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.makeGradient(g, Color.BLUE, DefaultColors.PURPLE);
    }
}   

package rpg.java.swing.Panels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rpg.java.Main;
import rpg.java.characters.PlayerCharacter;
import rpg.java.swing.Panels.SubPanels.ColorPanel;

public class RegisterPanel extends JPanel{
    public final JButton submitButton = new JButton("Submit");
    public final JTextArea nameArea = new JTextArea("Player");
    public final ColorPanel colorPanel = new ColorPanel();

    public RegisterPanel(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setVisible(true);
        this.add(this.colorPanel);
        this.nameArea.setSize(100,this.nameArea.getHeight());
        this.add(this.nameArea);
        this.submitButton.addActionListener((e -> this.submit()));
        this.add(this.submitButton);

        this.setLayout(new FlowLayout());
    }
    public void submit(){
        Main.player = new PlayerCharacter(this.nameArea.getText());
        Main.player.color = this.colorPanel.getColor();
        this.setBackground(Main.player.color);
        System.out.println("Added Player");
        Main.FRAME.beginGame();
    }
}

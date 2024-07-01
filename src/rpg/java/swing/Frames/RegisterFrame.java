package rpg.java.swing.Frames;

import javax.swing.JButton;
import javax.swing.JFrame;

import rpg.java.Main;

public class RegisterFrame extends JFrame{
    public JButton colorButton = new JButton();
    public RegisterFrame(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setVisible(true);
        this.colorButton.addActionListener((e -> this.openColorPanel()));
        this.colorButton.setText("Chose Color");
        this.add(this.colorButton);
    }
    public void openColorPanel(){
        new ColorFrame().setVisible(true);

    }
}

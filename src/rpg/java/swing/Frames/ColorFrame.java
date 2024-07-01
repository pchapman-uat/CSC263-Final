package rpg.java.swing.Frames;


import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import rpg.java.Main;

public class ColorFrame extends JFrame {
    private JColorChooser colorChooser = new JColorChooser();

    public ColorFrame(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.add(this.colorChooser);
    }
}

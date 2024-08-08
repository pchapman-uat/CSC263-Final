package rpg.java.swing.Panels.SubPanels;


import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {
    private final JColorChooser colorChooser = new JColorChooser();

    public ColorPanel(){
        this.add(this.colorChooser);
    }
    public Color getColor(){
        return this.colorChooser.getColor();
    }
    public void reset(){
        this.colorChooser.setColor(Color.WHITE);
    }
}

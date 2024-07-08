package rpg.java.swing.Panels.SubPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.characters.BaseCharacter;
import rpg.java.characters.BaseEnemy;

public class CharacterPannel extends JPanel {
    public final BaseCharacter character;
    private final JLabel health = new JLabel();
    private final JLabel name = new JLabel();
    private final GridBagConstraints c = new GridBagConstraints();
    public CharacterPannel(BaseCharacter _character){
        character = _character;
        this.setLayout(new GridBagLayout());
        this.c.gridy = 0;
        this.add(this.health, c);
        this.c.gridy+=1;
        this.add(this.name,c);
        this.updatePanel();
    }
    public void updatePanel(){
        System.out.println("Updating Pannel");
        this.health.setText(character.getHealthRatio());
        this.name.setText(character.name);
        this.setBackground(character.color);
        Color textColor;
        // Check if color is dark or light
        if(character.color.getRed() + character.color.getGreen() + character.color.getBlue() > 382){
            textColor = Color.BLACK;
        }else{
            textColor = Color.WHITE;
        }
        this.name.setForeground(textColor);
        this.health.setForeground(textColor);
        this.repaint();
    }
    public void resetPan(BaseEnemy _character){
        this.character.resetFrom(_character);
        this.updatePanel();
    }
}

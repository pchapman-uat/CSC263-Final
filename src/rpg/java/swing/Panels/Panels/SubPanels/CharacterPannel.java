package rpg.java.swing.Panels.Panels.SubPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.characters.BaseCharacter;

public class CharacterPannel extends JPanel {
    public BaseCharacter character;
    private JLabel health = new JLabel();
    private JLabel name = new JLabel();
    private GridBagConstraints c = new GridBagConstraints();
    public CharacterPannel(BaseCharacter character){
        this.character = character;
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
    }
}
package rpg.java.swing.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.characters.BaseCharacter;

public class CharacterPannel extends JPanel {
    public BaseCharacter character;
    private JLabel health = new JLabel();
    private JLabel name = new JLabel();
    public CharacterPannel(BaseCharacter character){
        this.character = character;
        this.add(this.health);
        this.add(this.name);
        this.updatePanel();
    }
    public void updatePanel(){
        System.out.println("Updating Pannel");
        this.health.setText(character.getHealthRatio());
        this.name.setText(character.name);
        this.setBackground(character.color);
    }
}

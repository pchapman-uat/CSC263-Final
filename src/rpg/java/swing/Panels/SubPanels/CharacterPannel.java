package rpg.java.swing.Panels.SubPanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import rpg.java.DefaultColors;
import rpg.java.characters.BaseCharacter;
import rpg.java.characters.BaseEnemy;

public class CharacterPannel extends JPanel {
    public BaseCharacter character;
    private final JLabel health = new JLabel();
    private final JLabel name = new JLabel();
    private final GridBagConstraints c = new GridBagConstraints();
    private final JProgressBar healthBar = new JProgressBar();

    private final Color fullhealth = Color.GREEN;
    private final Color midHealth = Color.YELLOW;
    private final Color noHealth = Color.RED;
    public CharacterPannel(BaseCharacter _character){
        character = _character;
        this.setLayout(new GridBagLayout());
        this.c.gridy = 0;
        this.updateHealth();
        this.healthBar.setForeground(this.healthBarColor());
        this.add(this.healthBar, c);
        this.c.gridy++;
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
        this.updateHealth();
        this.repaint();
    }
    public void resetPan(BaseEnemy _character){
        this.character.resetFrom(_character);
        this.updatePanel();
    }
    private void updateHealth(){
        this.healthBar.setMaximum((int) this.character.maxHealth);
        this.healthBar.setValue((int) this.character.health);
        this.healthBar.setForeground(this.healthBarColor());
    }

    private Color healthBarColor(){
        return DefaultColors.ThreeColorRange(this.noHealth, this.midHealth, this.fullhealth, this.character.getHealthPercent());
    }
}

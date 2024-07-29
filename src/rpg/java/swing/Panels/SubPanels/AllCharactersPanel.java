package rpg.java.swing.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.characters.BaseEnemy;

public class AllCharactersPanel extends JPanel{
    public CharacterPannel enemy;
    public CharacterPannel player;
    public AllCharactersPanel(){
        this.setLayout(new FlowLayout());
    }
    public void setPannels(){
        this.removeAll();
        this.player = new CharacterPannel(Main.player);
        Main.enemy = new BaseEnemy();
        this.enemy = new CharacterPannel(Main.enemy);
        this.add(this.player);
        this.add(this.enemy);
        this.repaint();
    }
}

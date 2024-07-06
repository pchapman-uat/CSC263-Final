package rpg.java.swing.Panels.Panels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.characters.BaseEnemy;
import rpg.java.swing.Panels.Panels.SubPanels.ActionPannel;
import rpg.java.swing.Panels.Panels.SubPanels.CharacterPannel;

public class GamePanel extends JPanel {
    private CharacterPannel enemy;
    private CharacterPannel player;

    private ActionPannel actions = new ActionPannel();
    public GamePanel(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setLayout(new FlowLayout());
        this.player = new CharacterPannel(Main.player);
        this.enemy = new CharacterPannel(BaseEnemy.getRandomEnemy());
        this.add(this.player);
        this.add(this.enemy);
        this.add(this.actions);
        this.setVisible(true);
    }
}

package rpg.java.swing.Panels.Panels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.characters.BaseEnemy;
import rpg.java.swing.Panels.Panels.SubPanels.ActionPannel;
import rpg.java.swing.Panels.Panels.SubPanels.CharacterPannel;

public class GamePanel extends JPanel {
    public static CharacterPannel enemy;
    public static CharacterPannel player;

    private ActionPannel actions = new ActionPannel();
    public GamePanel(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setLayout(new FlowLayout());
        player = new CharacterPannel(Main.player);
        Main.enemy = BaseEnemy.getRandomEnemy();
        enemy = new CharacterPannel(Main.enemy);
        this.add(player);
        this.add(enemy);
        this.add(this.actions);
        this.setVisible(true);
    }
}

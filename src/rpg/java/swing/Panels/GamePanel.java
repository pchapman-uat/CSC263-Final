package rpg.java.swing.Panels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.characters.BaseEnemy;
import rpg.java.swing.Panels.SubPanels.ActionPannel;
import rpg.java.swing.Panels.SubPanels.CharacterPannel;

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
    public static void doTurn(){
        Main.enemy.attack(Main.player);
        Main.player.stopDefending();
        if(Main.player.health <= 0){
            System.out.println("You died");
            System.exit(0);
        }
        if(Main.enemy.health <= 0){
            Main.enemy = BaseEnemy.getRandomEnemy();
            enemy.resetPan(Main.enemy);
            Main.damageMultiplier += 0.1;
        }
        GamePanel.enemy.updatePanel();
        GamePanel.player.updatePanel();
    }
}
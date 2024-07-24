package rpg.java.swing.Panels;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.Interfaces.iGradient;
import rpg.java.characters.BaseEnemy;
import rpg.java.characters.BossEnemy;
import rpg.java.swing.Panels.SubPanels.ActionPannel;
import rpg.java.swing.Panels.SubPanels.CharacterPannel;

public class GamePanel extends JPanel implements iGradient {
    public static CharacterPannel enemy;
    public static CharacterPannel player;

    private ActionPannel actions = new ActionPannel();
    public void beginGame(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setLayout(new FlowLayout());
        player = new CharacterPannel(Main.player);
        Main.enemy = new BaseEnemy();
        enemy = new CharacterPannel(Main.enemy);
        this.add(player);
        this.add(enemy);
        this.add(this.actions);
        this.setVisible(true);
    }
    public void doTurn(){
        Main.enemy.attack(Main.player);
        Main.player.stopDefending();
        if(Main.player.health <= 0){
            System.out.println("You died");
            System.exit(0);
        }
        if(Main.enemy.health <= 0){
            Main.currentWave+=1;
            if(Main.currentWave % Main.bossWaves == 0){
                System.out.println("Boss Wave!");
                Main.enemy = new BossEnemy();
                enemy.resetPan(Main.enemy);
                GamePanel.enemy.character = Main.enemy;
            } else {
                Main.enemy.resetRandon();
                enemy.resetPan(Main.enemy);
            }
            this.updateGradient();
            Main.damageMultiplier += 0.1;
            
        }
        GamePanel.enemy.updatePanel();
        GamePanel.player.updatePanel();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.updateGradient(g);
    }
    private void updateGradient(Graphics g){
        this.makeGradient(g, Main.player.color, Main.enemy.color, true);
    }
    private void updateGradient(){
        this.update(getGraphics());
    }
}

package rpg.java.swing.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import rpg.java.DefaultColors;
import rpg.java.Main;
import rpg.java.Interfaces.iGradient;
import rpg.java.characters.BaseEnemy;
import rpg.java.characters.BossEnemy;
import rpg.java.swing.Panels.SubPanels.ActionPannel;
import rpg.java.swing.Panels.SubPanels.AllCharactersPanel;

public class GamePanel extends JPanel implements iGradient {

    public final AllCharactersPanel characters = new AllCharactersPanel();

    private ActionPannel actions = new ActionPannel();
    
    private final GridBagConstraints c = new GridBagConstraints();
    
    public final GameOverPanel gameOverPanel = new GameOverPanel();

    private float preveHealAmt;

    public void beginGame(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.characters.setPannels();
        this.setLayout(new GridBagLayout());
        c.gridy = 0;
        this.add(this.characters,c);
        c.gridy++;
        this.add(this.actions, c);
        c.gridy++;
        this.setVisible(true);
    }
    public void doTurn(){
        Main.enemy.attack(Main.player);
        Main.player.stopDefending();
        this.setHealBackground();
        if(Main.player.health <= 0){
            System.out.println("You died");
            Main.FRAME.gameOver();
        }
        if(Main.enemy.health <= 0){
            Main.currentWave+=1;
            if(Main.currentWave % Main.bossWaves == 0){
                System.out.println("Boss Wave!");
                Main.enemy = new BossEnemy();
                this.characters.enemy.resetPan(Main.enemy);
                this.characters.enemy.character = Main.enemy;
            } else {
                if((Main.currentWave - 1) % Main.bossWaves == 0 && Main.currentWave != 1){
                    Main.enemy = new BaseEnemy();
                    this.characters.enemy.resetPan(Main.enemy);
                    this.characters.enemy.character = Main.enemy;
                } else {
                    Main.enemy.resetRandon();
                }

                this.characters.enemy.resetPan(Main.enemy);
            }
            this.updateGradient();
            Main.damageMultiplier += 0.1;
            
        }
        this.characters.enemy.updatePanel();
        this.characters.player.updatePanel();
    }
    private void setHealBackground(){
        float remaining = (float) Main.player.getFullHeals();
        if(remaining == preveHealAmt) return;
        Color color;
        if(remaining <= 0) {
            color = this.actions.getDefaultHealColor();
        } else {
            preveHealAmt = remaining;
            float max = (float) Main.player.getMaxHeals();
            float percent =  remaining / max;
            color = DefaultColors.ThreeColorRange(Color.RED, Color.YELLOW, Color.GREEN, percent);
        }
        this.actions.setHealBackground(color);
    }
    public float calcDmgMult(){
        float total = Main.damageMultiplier;
        switch (Main.difficulty) {
            case EASY:
                return total -= 0.5;
            case HARD:
                return total += 0.5;
            default:
                return total;
        }
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
    public void reset(){
        this.removeAll();
    }
}

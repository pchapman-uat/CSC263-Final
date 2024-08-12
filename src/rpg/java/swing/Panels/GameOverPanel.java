package rpg.java.swing.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.Interfaces.iGradient;
import rpg.java.swing.Panels.SubPanels.GameOverButtons;
import rpg.java.swing.Panels.SubPanels.GameOverStats;

public class GameOverPanel extends JPanel implements iGradient{
    public final GameOverStats gameOverStats = new GameOverStats();
    private final GameOverButtons gameOverButtons = new GameOverButtons();

    private final GridBagConstraints c = new GridBagConstraints();
    public void beginPannel(){
        this.setLayout(new GridBagLayout());
        gameOverStats.beginPannel();
        c.gridy = 0;
        this.add(this.gameOverStats, c);
        c.gridy++;
        this.gameOverButtons.beginFrame();
        this.add(this.gameOverButtons, c);
        this.repaint();

    }
    public void refresh(){
        this.gameOverStats.resetLeaderboard();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.makeGradient(g, Main.player.color, new Color(180,50,50));
    }
}

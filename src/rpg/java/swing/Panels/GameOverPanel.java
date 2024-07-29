package rpg.java.swing.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.Interfaces.iGradient;
import rpg.java.swing.Panels.SubPanels.GameOverStats;

public class GameOverPanel extends JPanel implements iGradient{
    private final GameOverStats gameOverStats = new GameOverStats();

    private final GridBagConstraints c = new GridBagConstraints();
    public void beginPannel(){
        this.setLayout(new GridBagLayout());
        gameOverStats.beginPannel();
        c.gridy = 0;
        this.add(this.gameOverStats, c);
        this.repaint();

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.makeGradient(g, Main.player.color, new Color(180,50,50));
    }
}

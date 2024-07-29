package rpg.java.swing.Panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.Main;

public class GameOverPanel extends JPanel{
    private JLabel nameLabel = new JLabel();
    private JLabel wavesLabel = new JLabel();

    private final GridBagConstraints c = new GridBagConstraints();
    public void beginPannel(){
        this.setLayout(new GridBagLayout());
        this.nameLabel.setText(Main.player.name);
        this.wavesLabel.setText(this.getScoreText(Main.currentWave));
        this.c.gridy = 0;
        this.add(this.nameLabel, c);
        this.c.gridy++;
        this.add(this.wavesLabel, c);
        this.repaint();

    }
    private String getScoreText(int score){
        return "Score: "+score;
    }
}

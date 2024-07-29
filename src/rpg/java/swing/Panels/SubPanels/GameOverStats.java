package rpg.java.swing.Panels.SubPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rpg.java.Main;

public class GameOverStats extends JPanel{
    private JLabel nameLabel = new JLabel();
    private JLabel wavesLabel = new JLabel();

    private final GridBagConstraints c = new GridBagConstraints();
    public void beginPannel(){
        this.setLayout(new GridBagLayout());
        this.nameLabel.setText(Main.player.name);
        this.wavesLabel.setText(this.getScoreText(Main.currentWave));
        c.gridy = 0;
        this.add(nameLabel, c);
        c.gridy++;
        this.add(wavesLabel, c);
    }
    private String getScoreText(int score){
        return "Score: "+score;
    }
}

package rpg.java.swing.Panels.SubPanels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rpg.java.Main;

public class GameOverStats extends JPanel{
    private JLabel nameLabel = new JLabel();
    private JLabel wavesLabel = new JLabel();
    private JLabel placementLabel = new JLabel();
    private JTextArea highScoresLabel = new JTextArea();

    private final GridBagConstraints c = new GridBagConstraints();
    public void beginPannel(){
        this.setLayout(new GridBagLayout());
        this.nameLabel.setText(Main.player.name + "| id:" + Main.player.id);
        this.wavesLabel.setText(this.getScoreText(Main.currentWave));
        c.gridy = 0;
        this.add(nameLabel, c);
        c.gridy++;
        this.add(wavesLabel, c);
        c.gridy++;
        this.placementLabel.setText(this.getPlacementString(this.getPlacement()));
        this.add(this.placementLabel, c);
        c.gridy++;

        this.highScoresLabel.setColumns(Main.highScores.getLenght());
        this.highScoresLabel.setText(Main.highScores.toString());
        this.add(this.highScoresLabel, c);
    }
    public void resetLeaderboard(){
        this.highScoresLabel.setText(Main.highScores.toString());
        this.repaint();
    }
    private String getScoreText(int score){
        return "Score: "+score;
    }
    private int getPlacement(){
        return Main.sqlManager.getUserPlacement(Main.player.id);
    }
    private String getPlacementString(int placement){
        return "Placement: "+placement;
    }
}

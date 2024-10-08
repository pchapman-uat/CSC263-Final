package rpg.java.swing.Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import rpg.java.DefaultColors;
import rpg.java.Fonts;
import rpg.java.Main;
import rpg.java.Interfaces.iGradient;

public class AboutPanel extends JPanel implements iGradient{
    private final JLabel aboutLabel = new JLabel("About");
    private final JLabel authorLabel = new JLabel("Author: Preston Chapman");
    private final JLabel descriptionLabel = new JLabel("This is a simple RPG game simulating a battle between two characters");
    public final JButton startButton = new JButton("Start");

    private final GridBagConstraints c = new GridBagConstraints();
    
    public AboutPanel(){
        this.aboutLabel.setFont(Fonts.HEADER);
        this.authorLabel.setFont(Fonts.SUBHEADER);
        this.aboutLabel.setForeground(Color.WHITE);
        this.authorLabel.setForeground(Color.WHITE);
        this.descriptionLabel.setForeground(Color.WHITE);

        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setLayout(new GridBagLayout());
        this.c.gridy = 0;
        this.add(this.aboutLabel, c);
        this.c.gridy+=1;
        this.add(this.authorLabel, c);
        this.c.gridy+=1;
        this.add(this.descriptionLabel, c);
        this.c.gridy+=1;
        this.add(this.startButton, c);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.makeGradient(g, Color.BLUE, DefaultColors.PURPLE);
    }
}

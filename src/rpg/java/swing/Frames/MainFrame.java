package rpg.java.swing.Frames;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import rpg.java.characters.BaseCharacter;
import rpg.java.swing.Panels.CharacterPannel;

public class MainFrame extends JFrame {
    private CharacterPannel enemy;
    private CharacterPannel player;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public MainFrame(){
        this.setSize(WIDTH,HEIGHT);
        this.setTitle("RPG | Preston C");
        this.setLayout(new FlowLayout());
        this.player = new CharacterPannel(new BaseCharacter("Player", 10, 10));
        this.enemy = new CharacterPannel(new BaseCharacter("Enemy", 10, 10));
        this.add(this.player);
        this.add(this.enemy);

        this.setVisible(true);
    }
}

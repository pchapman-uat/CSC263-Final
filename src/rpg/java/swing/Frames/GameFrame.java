package rpg.java.swing.Frames;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import rpg.java.Main;
import rpg.java.characters.BaseCharacter;
import rpg.java.characters.BaseEnemy;
import rpg.java.swing.Panels.CharacterPannel;

public class GameFrame extends JFrame {
    private CharacterPannel enemy;
    private CharacterPannel player;

    public GameFrame(){
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.setTitle("RPG | Preston C");
        this.setLayout(new FlowLayout());
        this.player = new CharacterPannel(new BaseCharacter("Player", 10, 10));
        this.enemy = new CharacterPannel(new BaseEnemy("Enemy", 10, 10));
        this.add(this.player);
        this.add(this.enemy);
        this.setVisible(true);
    }
}

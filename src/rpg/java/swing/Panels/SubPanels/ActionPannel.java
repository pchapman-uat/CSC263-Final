package rpg.java.swing.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.swing.Panels.GamePanel;

public class ActionPannel extends JPanel {
    public final JButton attack = new JButton("Attack");
    public final JButton defend = new JButton("Defend");
    public final JButton heal = new JButton("Heal");

    public ActionPannel(){
        this.setLayout(new FlowLayout());
        this.attack.addActionListener(e -> this.attack());
        this.defend.addActionListener(e -> this.defend());
        this.heal.addActionListener(e -> this.heal());
        
        this.add(attack);
        this.add(defend);
        this.add(heal);
    }

    private void attack(){
        Main.player.attack(Main.enemy);
        GamePanel.doTurn();
    }
    private void defend(){
        System.out.println("Defend");
        Main.player.startDefending();
        GamePanel.doTurn();
    }
    private void heal(){
        Main.player.heal(5);
        GamePanel.doTurn();
    }
}

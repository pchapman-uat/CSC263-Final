package rpg.java.swing.Panels.SubPanels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import rpg.java.Main;
import rpg.java.swing.MainFrame;

public class ActionPannel extends JPanel {
    public final JButton attack = new JButton("Attack");
    public final JButton defend = new JButton("Defend");
    public final JButton heal = new JButton("Heal");

    private final Color healColor;

    public ActionPannel(){
        this.setLayout(new FlowLayout());
        this.attack.addActionListener(e -> this.attack());
        this.defend.addActionListener(e -> this.defend());
        this.heal.addActionListener(e -> this.heal());
        
        this.add(attack);
        this.add(defend);
        this.add(heal);
        this.healColor = heal.getBackground();
        this.heal.setBackground(Color.GREEN);
    }

    private void attack(){
        Main.player.attack(Main.enemy);
        MainFrame.GAME_PANEL.doTurn();
    }
    private void defend(){
        System.out.println("Defend");
        Main.player.startDefending();
        MainFrame.GAME_PANEL.doTurn();
    }
    private void heal(){
        Main.player.heal(5);
        MainFrame.GAME_PANEL.doTurn();
    }
    public void setHealBackground(Color color){
        this.heal.setBackground(color);
    }
    public Color getDefaultHealColor(){
        return healColor;
    }
}

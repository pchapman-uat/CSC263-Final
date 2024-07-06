package rpg.java.swing.Panels.Panels.SubPanels;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPannel extends JPanel {
    public JButton attack = new JButton("Attack");
    public JButton defend = new JButton("Defend");
    public JButton heal = new JButton("Heal");

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
        System.out.println("Attack");
    }
    private void defend(){
        System.out.println("Defend");
    }
    private void heal(){
        System.out.println("Heal");
    }
}

package rpg.java.swing.Panels.SubPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rpg.java.Main;
import rpg.java.User;
import rpg.java.Interfaces.iFormat;

public class GameOverLookup extends JPanel implements iFormat{
    private final JButton LOOKUP = new JButton("Lookup");
    private final JTextArea LOOKUP_ID = new JTextArea("Please Enter a User ID");
    private final JTextArea RESULT = new JTextArea();
    public void beginPannel(){
        this.add(LOOKUP);
        this.add(LOOKUP_ID);
        this.LOOKUP.addActionListener(e -> this.lookup());
        this.RESULT.setEditable(false);
        this.add(RESULT);
    }

    private void lookup(){
        int id = Integer.parseInt(LOOKUP_ID.getText());
        int placement = Main.sqlManager.getUserPlacement(id);
        if(placement == -1){
            this.RESULT.setText("User not found");
            return;
        }
        User user = Main.sqlManager.getUser(id);
        this.RESULT.setText(user.name + " placed " + ordinal(placement) + " with a score of " + user.score);
    }

}   
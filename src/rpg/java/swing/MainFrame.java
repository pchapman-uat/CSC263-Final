package rpg.java.swing;

import javax.swing.JFrame;

import rpg.java.Main;
import rpg.java.swing.Panels.Panels.GamePanel;
import rpg.java.swing.Panels.Panels.RegisterPanel;

public class MainFrame extends JFrame{
    private final RegisterPanel REGISTER_PANEL = new RegisterPanel();
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.add(this.REGISTER_PANEL);
        this.setVisible(true);
    }
    public void beginGame(){
        this.remove(this.REGISTER_PANEL);
        this.add(new GamePanel());
        this.forceRefresh();

    }
    public void forceRefresh(){
        this.invalidate();
        this.validate();
        this.repaint();
    }
}

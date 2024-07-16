package rpg.java.swing;

import javax.swing.JFrame;

import rpg.java.Main;
import rpg.java.swing.Panels.AboutPanel;
import rpg.java.swing.Panels.GamePanel;
import rpg.java.swing.Panels.RegisterPanel;

public class MainFrame extends JFrame{
    private final RegisterPanel REGISTER_PANEL = new RegisterPanel();
    private final AboutPanel ABOUT_PANEL = new AboutPanel();
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Main.WIDTH, Main.HEIGHT);
        this.add(this.ABOUT_PANEL);
        this.ABOUT_PANEL.startButton.addActionListener(e -> this.beginRegister());
        //this.add(this.REGISTER_PANEL);
        this.setVisible(true);
    }
    public void beginRegister(){
        this.remove(this.ABOUT_PANEL);
        this.add(this.REGISTER_PANEL);
        this.forceRefresh();
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

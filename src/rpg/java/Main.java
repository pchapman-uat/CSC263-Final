package rpg.java;


import rpg.java.characters.BaseEnemy;
import rpg.java.characters.PlayerCharacter;
import rpg.java.swing.MainFrame;

public class Main {
    public static final boolean DEBUG = false;
    public static final int WIDTH = 16*150;
    public static final int HEIGHT = 9*150;
    public static PlayerCharacter player;
    public static BaseEnemy enemy = new BaseEnemy();
    public static float damageMultiplier = 1;
    public static final MainFrame FRAME= new MainFrame();
    public static int currentWave = 0;
    public static final int bossWaves = 10;
    public static Difficulty difficulty;
    public static final HighScores highScores = new HighScores();
    public final static SQLManager sqlManager = new SQLManager();
    public static void main(String[] args){

    }
    public static void resetAll(){
        player = null;
        enemy = new BaseEnemy();
        damageMultiplier = 1;
        currentWave = 0;
        difficulty = null;
        FRAME.beginNewPlayer();
    }
    public static void showAllScores(){
        highScores.reset();
        sqlManager.getUsers();
        FRAME.GAME_OVER_PANEL.refresh();
    }
    public static void showFilteredScores(Difficulty difficulty){
        highScores.reset();
        sqlManager.getUsers(difficulty);
        FRAME.GAME_OVER_PANEL.refresh();
    }
    public static void replay(){
        player.health = player.maxHealth;
        Main.enemy = new BaseEnemy();
        Main.currentWave = 0;
        Main.damageMultiplier = 1;
        Main.player.id = null;
        MainFrame.GAME_PANEL.reset();
        FRAME.remove(FRAME.GAME_OVER_PANEL);
        FRAME.beginGame();
        FRAME.repaint();
    }
}
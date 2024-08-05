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
}
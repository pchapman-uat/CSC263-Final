package rpg.java;

import rpg.java.characters.BaseEnemy;
import rpg.java.characters.PlayerCharacter;
import rpg.java.swing.MainFrame;

public class Main {
    public static final boolean DEBUG = false;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static PlayerCharacter player;
    public static BaseEnemy enemy = new BaseEnemy();
    public static float damageMultiplier = 1;
    public static final MainFrame FRAME= new MainFrame();
    public static int currentWave = 0;
    public static final int bossWaves = 1;
    public static Difficulty difficulty;
    public static void main(String[] args){

    }

}
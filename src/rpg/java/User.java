package rpg.java;

import rpg.java.characters.PlayerCharacter;

public class User {
    public String name;
    private int id;
    public int score;

    User(String name, int id, int score){
        this.name = name;
        this.id = id;
        this.score = score;
    }
    User(PlayerCharacter player){
        this.name = player.name;
        this.score = Main.currentWave;
    }
}
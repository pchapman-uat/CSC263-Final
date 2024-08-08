package rpg.java;

import rpg.java.characters.PlayerCharacter;

public class User {
    public String name;
    public int id;
    public int score;

    public User(String name, int id, int score){
        this.name = name;
        this.id = id;
        this.score = score;
    }
    public User(PlayerCharacter player){
        this.name = player.name;
        this.score = Main.currentWave;
    }
}
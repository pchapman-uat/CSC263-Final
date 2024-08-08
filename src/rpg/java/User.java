package rpg.java;

import java.sql.Date;

import rpg.java.characters.PlayerCharacter;

public class User {
    public String name;
    public int id;
    public int score;
    public Date date;

    public User(String name, int id, int score, Date date){
        this.name = name;
        this.id = id;
        this.score = score;
        this.date = date;
    }
    public User(PlayerCharacter player){
        this.name = player.name;
        this.score = Main.currentWave;
    }
}
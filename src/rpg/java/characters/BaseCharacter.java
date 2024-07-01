package rpg.java.characters;

import java.awt.Color;

public class BaseCharacter {
    public float health;
    public float maxHealth;
    public String name;
    public Color color;

    public BaseCharacter(String name, float health, float maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.color = Color.WHITE;
    }
    public BaseCharacter(String name, float health, float maxHealth, Color color){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.color = color;
    }
}

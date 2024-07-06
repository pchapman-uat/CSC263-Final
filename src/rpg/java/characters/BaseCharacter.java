package rpg.java.characters;

import java.awt.Color;

public class BaseCharacter {
    public float health;
    public float maxHealth;
    public String name;
    public Color color;

    public int damage;

    public BaseCharacter(String name, float health, float maxHealth, int damage){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damage = damage;
        this.color = Color.WHITE;
    }
    public BaseCharacter(String name, float health, float maxHealth, int damage, Color color){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.damage = damage;
        this.color = color;
    }
    public String getHealth(){
        return String.valueOf(this.health);
    }
    public String getMaxHealth(){
        return String.valueOf(this.maxHealth);
    }
    public String getHealthRatio(){
        return this.getHealth() + "/" + this.getMaxHealth();
    }
    public void attack(BaseCharacter enemy){
        enemy.reciveDamage(this.damage);
    }
    public void reciveDamage(int ammount){
        this.health -= ammount;
        if(this.health <= 0){
            this.health = 0;
        }
    }
}

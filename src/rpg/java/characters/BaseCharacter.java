package rpg.java.characters;

import java.awt.Color;

public class BaseCharacter {
    public float health;
    public float maxHealth;
    public String name;
    public Color color;

    public int damage;

    public Boolean defending = false;
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
    public BaseCharacter(BaseCharacter other) {
        this.name = other.name;
        this.maxHealth = other.maxHealth;
        this.health = other.health;
        this.damage = other.damage;
        this.color = other.color;
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
    public void reciveDamage(float ammount){
        if(this.defending) ammount /= 2;
        this.health -= ammount;
        if(this.health <= 0){
            this.health = 0;
        }
    }
    public void startDefending(){
        this.defending = true;
    }
    public void stopDefending(){
        this.defending = false;
    }
}

package rpg.java.characters;

public class BaseCharacter {
    public float health;
    public float maxHealth;
    public String name;

    public BaseCharacter(String name, float health, float maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
    }
}

package rpg.java.characters;

import java.awt.Color;

public class BaseEnemy extends BaseCharacter{
    public BaseEnemy(String name, float health, float maxHealth){
        super(name, health, maxHealth, Color.RED);
    }
}

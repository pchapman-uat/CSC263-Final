package rpg.java.characters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseEnemy extends BaseCharacter{
    public BaseEnemy(String name, float health, float maxHealth){
        super(name, health, maxHealth, Color.RED);
    }
    public BaseEnemy(String name, float health, float maxHealth, Color color){
        super(name, health, maxHealth, color);
    }

    public static final ArrayList<BaseEnemy> ENEMIES = new ArrayList<>(Arrays.asList(
        new BaseEnemy("Goblin", 10, 10, Color.GREEN),
        new BaseEnemy("Orc", 15, 15, Color.RED),
        new BaseEnemy("Dragon", 50, 30, Color.BLUE),
        new BaseEnemy("Skeleton", 12, 8, Color.LIGHT_GRAY),
        new BaseEnemy("Troll", 20, 18, Color.DARK_GRAY),
        new BaseEnemy("Witch", 18, 12, Color.MAGENTA),
        new BaseEnemy("Vampire", 25, 20, Color.BLACK),
        new BaseEnemy("Werewolf", 22, 16, Color.GRAY),
        new BaseEnemy("Slime", 8, 5, Color.YELLOW),
        new BaseEnemy("Ghost", 15, 10, Color.WHITE)
    ));
    public static BaseEnemy getRandomEnemy(){
        return ENEMIES.get((int)Math.round(Math.random()*ENEMIES.size()));
    }
}

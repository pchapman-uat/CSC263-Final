package rpg.java.characters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import rpg.java.swing.MainFrame;

public class BaseEnemy extends BaseCharacter{
    public BaseEnemy(String name, float health, float maxHealth, int damage){
        super(name, health, maxHealth, damage, Color.RED);
    }
    public BaseEnemy(String name, float health, float maxHealth, int damage, Color color){
        super(name, health, maxHealth, damage, color);
    }
    public BaseEnemy(BaseEnemy other) {
        super(other);
    }
    public BaseEnemy(){
        super();
        this.resetRandon();
    }
    @Override
    public void attack(BaseCharacter enemy){
        enemy.reciveDamage(this.damage * MainFrame.GAME_PANEL.calcDmgMult());
    }

    public static final ArrayList<BaseEnemy> ENEMIES = new ArrayList<>(Arrays.asList(
        new BaseEnemy("Goblin", 10, 10, 5, Color.GREEN),
        new BaseEnemy("Orc", 15, 15,3, Color.RED),
        new BaseEnemy("Skeleton", 12, 12, 2, Color.LIGHT_GRAY),
        new BaseEnemy("Troll", 20, 20,4, Color.DARK_GRAY),
        new BaseEnemy("Witch", 18, 18,2, Color.MAGENTA),
        new BaseEnemy("Vampire", 25, 25,4, Color.BLACK),
        new BaseEnemy("Werewolf", 22, 22,4, Color.GRAY),
        new BaseEnemy("Slime", 8, 8,2, Color.YELLOW),
        new BaseEnemy("Ghost", 15, 15, 2, Color.WHITE)
    ));
    public ArrayList<BaseEnemy> getEnemies(){
        return ENEMIES;
    }
    public void resetRandon(){
        this.resetFrom(this.getEnemies().get((int)Math.round(Math.random()*(this.getEnemies().size()-1))));
    }
}

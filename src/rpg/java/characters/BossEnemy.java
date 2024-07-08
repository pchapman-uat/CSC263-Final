package rpg.java.characters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class BossEnemy extends BaseEnemy {

    public static final ArrayList<BaseEnemy> ENEMIES = new ArrayList<>(Arrays.asList(
        new BaseEnemy("Dragon", 50, 50, 10, Color.BLUE)
    ));
    public BossEnemy(BaseEnemy other) {
        super(other);
    }
    public BossEnemy(){
        super();
    }
    @Override
    public ArrayList<BaseEnemy> getEnemies(){
        return ENEMIES;
    }
}


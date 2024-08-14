package rpg.java.characters;

public class PlayerCharacter extends BaseCharacter{
    public Integer id;
    private final int maxHeals = 5;
    private int fullHeals;

    public PlayerCharacter(String name){
        super(name, 100,100, 10);
        this.fullHeals = maxHeals;
    }
    public void setID(int id){
        this.id = id;
    }
    public int getFullHeals() {
        return fullHeals;
    }
    public int getMaxHeals(){
        return maxHeals;
    }
    @Override
    public void heal(int ammount){
        if(this.getFullHeals() > 0) {
            this.health = this.maxHealth;
            this.fullHeals--;
        }
    }   
}

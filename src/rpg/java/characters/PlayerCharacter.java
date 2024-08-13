package rpg.java.characters;

public class PlayerCharacter extends BaseCharacter{
    public Integer id;
    public PlayerCharacter(String name){
        super(name, 100,100, 10);
    }
    public void setID(int id){
        this.id = id;
    }
}

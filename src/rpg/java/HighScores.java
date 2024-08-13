package rpg.java;

import rpg.java.Interfaces.iFormat;
import rpg.java.characters.PlayerCharacter;

public class HighScores implements iFormat {
    public static final int MAX_USERS = 5;
    private User[] allUsers;

    public HighScores(){
        allUsers = new User[MAX_USERS];
    }
    
    public void addUser(User newUser){
        int i = 0;
        for (User _user : allUsers) {
            if(_user == null) {
                allUsers[i] = newUser;
                return;
            }
            if(_user.id == newUser.id){
                return;
            }
            if(newUser.score > _user.score){
                User tmp = allUsers[i];
                allUsers[i] = newUser;
                addUser(tmp);
                break;
            }
            i++;
        }
    }
    public void reset(){
        this.allUsers = new User[MAX_USERS];
    }
    public void addUser(PlayerCharacter player){
        this.addUser(new User(player));
    }

    public int getLenght(){
        System.out.println(allUsers.length);
        return allUsers.length;
    }
    public String toString(){
        System.out.println(this.allUsers);
        String result = "";
        for(int i = 0; i< this.getLenght(); i++){
            System.out.println(this.allUsers[i]);
            result += getPlacementString(this.allUsers[i], i);
        }
        return result;
    }
    private String getPlacementString(User user, int index){
        String result = "";
        if(user == null) result = (index+1)+". N/A";
        else result = ordinal(index+1)+". "+user.name + " - " + user.score + " | "+ user.date.toString() + " | "+ difficultyStars(user.difficulty);
        if(index < this.getLenght()-1) result+= System.getProperty("line.separator");
        return result;
    }
}
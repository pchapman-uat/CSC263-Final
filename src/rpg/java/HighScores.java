package rpg.java;


public class HighScores {
    private User[] allUsers = new User[3];
    
    public void addUser(User newUser){
        int i = 0;
        for (User _user : allUsers) {
            if(newUser.score > _user.score){
                allUsers[i] = newUser;
            }
        }
    }

    public int getLenght(){
        System.out.println(allUsers.length);
        return allUsers.length;
    }
    public String toString(){
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
        else result = (index+1)+". "+this.allUsers[index].name;
        if(index < this.getLenght()-1) result+= System.getProperty("line.separator");
        return result;
    }
}
class User {
    public String name;
    private int id;
    public int score;

    User(String name, int id, int score){
        this.name = name;
        this.id = id;
        this.score = score;
    }
}
package rpg.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager {

    private Connection connection;
    private Statement statement;

    public SQLManager() {
        try {
            String createTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date TEXT, score INTEGER, difficulty STRING)";            
            String url = "jdbc:sqlite:src/db/data.sqlite3";            
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.execute(createTable);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void getUsers(){
        try {
            String select = "SELECT * FROM users ORDER BY score DESC LIMIT " + HighScores.MAX_USERS;           
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                String dateStr = resultSet.getString("date");
                Date date = Date.valueOf(dateStr);
                String diffStr = resultSet.getString("difficulty");
                User user = new User(name, id, score, date, diffStr);
                Main.highScores.addUser(user);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void addUser(User user){
        Main.highScores.addUser(user);
        Date date = new Date(System.currentTimeMillis());
        try {
            String insert = "INSERT INTO users (name, date, score, difficulty) VALUES ('" + user.name + "', '" +  date.toString() + "', '" + user.score + "','"+user.difficulty.toString() +"')";
            System.out.println(insert);
            statement.execute(insert);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

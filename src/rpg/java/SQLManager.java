package rpg.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager {

    private Connection connection;
    private Statement statement;

    public SQLManager() {
        try {
            String createTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, date TEXT, score INTEGER)";
            String url = "jdbc:sqlite:src/db/data.sqlite3";            
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.execute(createTable);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

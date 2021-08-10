package jm.task.core.jdbc.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/taskjdbc?";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root-123";

    public Connection getConnection(){
        Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            return connection;
    }

}

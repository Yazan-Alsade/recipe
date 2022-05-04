package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        String server = "localhost";
        String database = "my_db";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + "/" + database + "?verifyServerCertificate=true&useSSL=false", user, password);
    }

    public Connection getConnection() {
        return connection;
    }
}

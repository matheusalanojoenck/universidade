package persistencia;
import java.sql.*;


public class DBConnection {
    private static Connection connection = null;

    static public Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/universidade";
            String username = "postgres";
            String password = "postgres";
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
            catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //if(connection == null) System.out.println("connection null");
        return connection;
    }
}

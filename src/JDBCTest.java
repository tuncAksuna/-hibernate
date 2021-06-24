import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/'YOUR DATABASE NAME '?useSSL=false&serverTimezone=UTC";
        String user = "YOUR USERNAME";
        String pass = "YOUR PASSWORD";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("SUCCESFUL");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

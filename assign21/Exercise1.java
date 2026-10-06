import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/librarydb";
        String username = "root";
        String password = "0536373438";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Database connected successfully.");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
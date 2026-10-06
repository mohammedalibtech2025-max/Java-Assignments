import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "0536373438";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Student database connected successfully.");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Student database connection failed.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
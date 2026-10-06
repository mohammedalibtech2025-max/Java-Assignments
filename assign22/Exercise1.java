import java.sql.*;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/logindb";
        String username = "root";
        String password = "0536373438";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, user);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful.");
                System.out.println("Welcome, " + user + "!");
            } else {
                System.out.println("Invalid username or password.");
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
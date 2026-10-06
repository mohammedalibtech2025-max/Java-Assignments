import java.sql.*;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hospitaldb";
        String username = "root";
        String password = "0536373438";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, loginId);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                System.out.println("Authentication successful.");
                System.out.println("Welcome, " + role + "!");
                System.out.println("Access granted to hospital system.");
            } else {
                System.out.println("Authentication failed.");
                System.out.println("Access denied.");
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
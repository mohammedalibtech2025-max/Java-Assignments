import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "0536373438";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            String query = "SELECT * FROM student";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records:");
            System.out.println("-----------------------------");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("-----------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
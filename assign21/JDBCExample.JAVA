import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Establish connection using DriverManager
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/librarydb",
                "root",
                "0536373438"
            );

            // Create Statement object
            Statement stmt = con.createStatement();

            // Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Books");

            // Display records
            System.out.println("Books Details:");
            System.out.println("------------------------------");

            while (rs.next()) {
                System.out.println(
                    "Book ID: " + rs.getInt(1) +
                    ", Book Name: " + rs.getString(2)
                );
            }

            // Close connection
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
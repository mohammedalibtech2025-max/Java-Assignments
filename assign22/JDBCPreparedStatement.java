import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCPreparedStatement {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/librarydb";
        String username = "root";
        String password = "0536373438";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Books WHERE bid = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);

            // Search for Book ID 201
            pstmt.setInt(1, 201);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("bid"));
                System.out.println("Book Name: " + rs.getString("bname"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Publisher ID: " + rs.getInt("publisher_id"));
            } else {
                System.out.println("No book found.");
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
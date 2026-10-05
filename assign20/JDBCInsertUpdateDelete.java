import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertUpdateDelete {

    static final String URL = "jdbc:mysql://localhost:3306/cardb";
    static final String USER = "root";
    static final String PASSWORD = "0536373438";

    public static void main(String[] args) {

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully.");

            // ================= INSERT =================
            String insertQuery =
                    "INSERT INTO cars (car_id, brand, model, price) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = con.prepareStatement(insertQuery);

            insertStmt.setInt(1, 105);
            insertStmt.setString(2, "Honda");
            insertStmt.setString(3, "Civic");
            insertStmt.setDouble(4, 28000.00);

            int insertResult = insertStmt.executeUpdate();

            if (insertResult > 0) {
                System.out.println("INSERT operation successful.");
            }

            // ================= UPDATE =================
            String updateQuery =
                    "UPDATE cars SET brand = ?, model = ?, price = ? WHERE car_id = ?";

            PreparedStatement updateStmt = con.prepareStatement(updateQuery);

            updateStmt.setString(1, "Honda");
            updateStmt.setString(2, "Civic Type R");
            updateStmt.setDouble(3, 32000.00);
            updateStmt.setInt(4, 105);

            int updateResult = updateStmt.executeUpdate();

            if (updateResult > 0) {
                System.out.println("UPDATE operation successful.");
            }

            // ================= DELETE =================
            String deleteQuery =
                    "DELETE FROM cars WHERE car_id = ?";

            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 105);

            int deleteResult = deleteStmt.executeUpdate();

            if (deleteResult > 0) {
                System.out.println("DELETE operation successful.");
            }

            // Close resources
            insertStmt.close();
            updateStmt.close();
            deleteStmt.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
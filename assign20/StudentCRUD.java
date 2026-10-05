import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "0536373438";

    public static void main(String[] args) {

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully.");

            // =================================================
            // CREATE OPERATION
            // =================================================

            String insertQuery =
                    "INSERT INTO students (roll_no, name, course, marks) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = con.prepareStatement(insertQuery);

            insertStmt.setInt(1, 104);
            insertStmt.setString(2, "Mohammed");
            insertStmt.setString(3, "BTech CSE");
            insertStmt.setDouble(4, 88);

            int insertResult = insertStmt.executeUpdate();

            if (insertResult > 0) {
                System.out.println("CREATE operation successful.");
            }

            // =================================================
            // READ OPERATION
            // =================================================

            String selectQuery = "SELECT * FROM students";

            PreparedStatement selectStmt = con.prepareStatement(selectQuery);

            ResultSet rs = selectStmt.executeQuery();

            System.out.println();
            System.out.println("Student Records");
            System.out.println("------------------------------------------------");
            System.out.println("Roll No\tName\tCourse\t\tMarks");
            System.out.println("------------------------------------------------");

            while (rs.next()) {

                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");

                System.out.println(
                        rollNo + "\t" +
                        name + "\t" +
                        course + "\t" +
                        marks
                );
            }

            // =================================================
            // UPDATE OPERATION
            // =================================================

            String updateQuery =
                    "UPDATE students SET course = ?, marks = ? WHERE roll_no = ?";

            PreparedStatement updateStmt = con.prepareStatement(updateQuery);

            updateStmt.setString(1, "BTech IT");
            updateStmt.setDouble(2, 91);
            updateStmt.setInt(3, 104);

            int updateResult = updateStmt.executeUpdate();

            if (updateResult > 0) {
                System.out.println();
                System.out.println("UPDATE operation successful.");
            }

            // =================================================
            // DELETE OPERATION
            // =================================================

            String deleteQuery =
                    "DELETE FROM students WHERE roll_no = ?";

            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 104);

            int deleteResult = deleteStmt.executeUpdate();

            if (deleteResult > 0) {
                System.out.println("DELETE operation successful.");
            }

            // Close resources
            rs.close();
            insertStmt.close();
            selectStmt.close();
            updateStmt.close();
            deleteStmt.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
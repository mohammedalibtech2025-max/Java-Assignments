import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    static final String USER = "root";
    static final String PASSWORD = "0536373438";

    public static void main(String[] args) {

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully.");

            // =================================================
            // CREATE OPERATION
            // =================================================

            String insertQuery =
                    "INSERT INTO employees (emp_id, name, department, salary) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = con.prepareStatement(insertQuery);

            insertStmt.setInt(1, 4);
            insertStmt.setString(2, "Mohammed");
            insertStmt.setString(3, "IT");
            insertStmt.setDouble(4, 60000.00);

            int insertResult = insertStmt.executeUpdate();

            if (insertResult > 0) {
                System.out.println("CREATE operation successful.");
            }

            // =================================================
            // READ OPERATION
            // =================================================

            String selectQuery = "SELECT * FROM employees";

            PreparedStatement selectStmt = con.prepareStatement(selectQuery);

            ResultSet rs = selectStmt.executeQuery();

            System.out.println();
            System.out.println("Employee Records");
            System.out.println("-----------------------------------------------");
            System.out.println("ID\tName\tDepartment\tSalary");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("emp_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.println(
                        id + "\t" +
                        name + "\t" +
                        department + "\t\t" +
                        salary
                );
            }

            // =================================================
            // UPDATE OPERATION
            // =================================================

            String updateQuery =
                    "UPDATE employees SET department = ?, salary = ? WHERE emp_id = ?";

            PreparedStatement updateStmt = con.prepareStatement(updateQuery);

            updateStmt.setString(1, "Software Development");
            updateStmt.setDouble(2, 65000.00);
            updateStmt.setInt(3, 4);

            int updateResult = updateStmt.executeUpdate();

            if (updateResult > 0) {
                System.out.println();
                System.out.println("UPDATE operation successful.");
            }

            // =================================================
            // DELETE OPERATION
            // =================================================

            String deleteQuery =
                    "DELETE FROM employees WHERE emp_id = ?";

            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 4);

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
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeFile {

    public static void main(String[] args) {

        try {
            // Writing employee details to file
            FileWriter writer = new FileWriter("employee.txt");

            writer.write("Employee ID: 101\n");
            writer.write("Employee Name: Amit\n");
            writer.write("Department: IT\n");
            writer.write("Salary: Rs.50000\n");

            writer.close();

            System.out.println("Employee details written successfully.");

            // Reading employee details from file
            FileReader reader = new FileReader("employee.txt");

            int ch;

            System.out.println("\nEmployee Details:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
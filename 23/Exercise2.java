
import java.sql.*;

public class Exercise2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "0536373438"
            );

            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            if (rs.first()) {
                System.out.println("First Employee: " + rs.getString("name"));
            }

            if (rs.last()) {
                System.out.println("Last Employee: " + rs.getString("name"));
            }

            if (rs.absolute(2)) {
                System.out.println("Second Employee: " + rs.getString("name"));
            }

            if (rs.previous()) {
                System.out.println("Previous Employee: " + rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


import java.sql.*;

public class main {
    public static void main(String[] args) {

        // Mohammed Tawfik
        // PRN: 25070122112

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "0536373438";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery("SELECT * FROM student");

            System.out.println("All Student Records:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age")
                );
            }

            System.out.println("\nFirst Record:");
            if (rs.first()) {
                System.out.println(rs.getString("name"));
            }

            System.out.println("\nLast Record:");
            if (rs.last()) {
                System.out.println(rs.getString("name"));
            }

            System.out.println("\nSecond Record:");
            if (rs.absolute(2)) {
                System.out.println(rs.getString("name"));
            }

            System.out.println("\nPrevious Record:");
            if (rs.previous()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

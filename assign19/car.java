import java.sql.*;

public class car {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cardb",
                "root",
                "0536373438"
            );

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM cars";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Car Records");
            System.out.println("==========================================");
            System.out.println("ID\tBrand\t\tModel\t\tPrice");
            System.out.println("==========================================");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("car_id") + "\t" +
                    rs.getString("brand") + "\t\t" +
                    rs.getString("model") + "\t\t" +
                    rs.getDouble("price")
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
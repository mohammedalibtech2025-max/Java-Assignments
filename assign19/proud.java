import java.sql.*;

public class proud {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/productdb",
                "root",
                "0536373438"
            );

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM products";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Product Details");
            System.out.println("==============================================");
            System.out.println("ID\tProduct Name\tQuantity\tPrice");
            System.out.println("==============================================");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("product_id") + "\t" +
                    rs.getString("product_name") + "\t\t" +
                    rs.getInt("quantity") + "\t\t" +
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
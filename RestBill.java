class Restaurant {

    // Static variable to count total orders
    static int totalOrders = 0;

    // Method for dine-in order
    double calculateBill(double amount) {
        totalOrders++;
        return amount;
    }

    // Method for takeaway order (with packaging charge)
    double calculateBill(double amount, double packagingCharge) {
        totalOrders++;
        return amount + packagingCharge;
    }

    // Method for delivery order (with delivery charge and tax)
    double calculateBill(double amount, double deliveryCharge, double tax) {
        totalOrders++;
        return amount + deliveryCharge + tax;
    }

    // Display total number of orders
    static void showTotalOrders() {
        System.out.println("Total Orders: " + totalOrders);
    }
}

public class RestBill {

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        // Dine-in bill
        double dineIn = r.calculateBill(500);
        System.out.println("Dine-in Bill: Rs. " + dineIn);

        // Takeaway bill
        double takeaway = r.calculateBill(400, 30);
        System.out.println("Takeaway Bill: Rs. " + takeaway);

        // Delivery bill
        double delivery = r.calculateBill(600, 50, 40);
        System.out.println("Delivery Bill: Rs. " + delivery);

        // Display total orders
        Restaurant.showTotalOrders();
    }
}
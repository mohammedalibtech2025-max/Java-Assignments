interface Payment {
    void makePayment();
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void displayName() {
        System.out.println("Customer Name: " + name);
    }
}

class Customer extends Person implements Payment {
    double amount;

    Customer(String name, double amount) {
        super(name);
        this.amount = amount;
    }

    public void makePayment() {
        System.out.println("Payment Amount: Rs. " + amount);
        System.out.println("Payment Successful");
    }
}

public class assign7 {
    public static void main(String[] args) {

        Customer customer = new Customer("Mohammed", 1500);

        customer.displayName();
        customer.makePayment();
    }
}
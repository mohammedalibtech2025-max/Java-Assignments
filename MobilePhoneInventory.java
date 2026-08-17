class MobilePhone {
    String brand;
    String model;
    double price;
    int storage;

    // Default constructor
    MobilePhone() {
        brand = "Unknown";
        model = "Unknown";
        price = 0;
        storage = 0;
    }

    // Parameterized constructor
    MobilePhone(String b, String m, double p, int s) {
        brand = b;
        model = m;
        price = p;
        storage = s;
    }

    // Copy constructor to create duplicate object
    MobilePhone(MobilePhone phone) {
        brand = phone.brand;
        model = phone.model;
        price = phone.price;
        storage = phone.storage;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Storage: " + storage + " GB");
        System.out.println();
    }
}

public class MobilePhoneInventory {
    public static void main(String[] args) {

        // Using default constructor
        MobilePhone phone1 = new MobilePhone();

        // Using parameterized constructor
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S25", 79999, 256);

        // Creating duplicate object using copy constructor
        MobilePhone phone3 = new MobilePhone(phone2);

        System.out.println("Mobile Phone 1:");
        phone1.display();

        System.out.println("Mobile Phone 2:");
        phone2.display();

        System.out.println("Duplicate Mobile Phone Record:");
        phone3.display();
    }
}
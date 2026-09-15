public class assign2 {
    String name;
    int age;

    // Default Constructor
    assign2() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    assign2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    assign2(assign2 s) {
        this.name = s.name;
        this.age = s.age;
    }

    // Display Method
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        assign2 s1 = new assign2();
        assign2 s2 = new assign2("Mohammed Tawfik", 20);
        assign2 s3 = new assign2(s2);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("Parameterized Constructor:");
        s2.display();

        System.out.println("Copy Constructor:");
        s3.display();
    }
}
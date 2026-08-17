class Student {
    String name;
    int rollNumber;

    // Default constructor
    Student() {
        name = "Unknown";
        rollNumber = 0;
    }

    // Parameterized constructor
    Student(String n, int r) {
        name = n;
        rollNumber = r;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

public class studentsclass {
    public static void main(String[] args) {

        // Using default constructor
        Student s1 = new Student();

        // Using parameterized constructor
        Student s2 = new Student("Mohammed", 112);

        System.out.println("Student 1:");
        s1.display();

        System.out.println();

        System.out.println("Student 2:");
        s2.display();
    }
}
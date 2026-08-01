class Student
{
    String name;
    int age;

    // Default Constructor
    Student()
    {
        name = "Unknown";
        age = 0;
    }

    // Parameterized Constructor
    Student(String n, int a)
    {
        name = n;
        age = a;
    }

    // Copy Constructor
    Student(Student s)
    {
        name = s.name;
        age = s.age;
    }

    // Method to display details
    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println();
    }

    public static void main(String args[])
    {
        // Default Constructor
        Student s1 = new Student();

        // Parameterized Constructor
        Student s2 = new Student("Mohammed Tawfik", 20);

        // Copy Constructor
        Student s3 = new Student(s2);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("Parameterized Constructor:");
        s2.display();

        System.out.println("Copy Constructor:");
        s3.display();
    }
}
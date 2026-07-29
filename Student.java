class Student
{
    String name;
    int age;

    // Default Constructor
    Student()
    {
        name = "Mohammed";
        age = 20;
    }

    // Method
    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public static void main(String args[])
    {
        Student s = new Student();
        s.display();
    }
}
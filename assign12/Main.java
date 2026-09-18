import Student.Student;
import faculty.faculty;

public class Main {

    public static void main(String[] args) {

        Student s = new Student("Amit", 101, "B.Tech CSE");

        faculty f = new faculty(
            "Dr. Sharma",
            "Java Programming",
            "Computer Science"
        );

        System.out.println("----- Student Details -----");
        s.display();

        System.out.println();

        System.out.println("----- Faculty Details -----");
        f.display();
    }
}
package faculty;

public class faculty {

    String name;
    String subject;
    String department;

    public faculty(String name, String subject, String department) {
        this.name = name;
        this.subject = subject;
        this.department = department;
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + department);
    }
}
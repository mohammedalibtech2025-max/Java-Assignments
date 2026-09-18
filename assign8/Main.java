class Employee { String name; double salary; 

 

Employee(String name, double salary) { this.name = name; 

this.salary = salary; 

} 

 

void display() { 

System.out.println("Employee Name: " + name); System.out.println("Salary: Rs." + salary); 

} 

} 

 

class Manager extends Employee { String department; 

 

Manager(String name, double salary, String department) { super(name, salary); 

this.department = department; 

} 

 

void displayManager() { super.display(); 

System.out.println("Department: " + department); 

} 

} 

 

public class Main { 

public static void main(String[] args) { 

Manager m = new Manager("Amit", 50000, "IT"); m.displayManager(); 

} 

} 
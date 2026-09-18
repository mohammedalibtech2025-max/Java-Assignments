import java.util.Scanner; 

 

public class em { 

public static void main(String[] args) { Scanner sc = new Scanner(System.in); 

 

System.out.print("Enter Employee ID: "); Integer id = Integer.valueOf(sc.nextLine()); 

 

System.out.print("Enter Basic Salary: "); Double salary = Double.valueOf(sc.nextLine()); 

 

System.out.print("Enter Bonus: "); 

Double bonus = Double.valueOf(sc.nextLine()); 

 

if (salary < 0 || bonus < 0) { System.out.println("Invalid salary or bonus"); 

} else { 

Double netSalary = salary + bonus;
System.out.println("Employee ID: " + id); System.out.println("Basic Salary: Rs." + salary); System.out.println("Bonus: Rs." + bonus); System.out.println("Net Salary: Rs." + netSalary); 

} 

 

sc.close(); 

} 

} 
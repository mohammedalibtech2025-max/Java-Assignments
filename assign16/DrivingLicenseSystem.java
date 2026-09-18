import java.util.Scanner; 

 

// Custom Exception 

class InvalidDrivingAgeException extends Exception { public InvalidDrivingAgeException(String message) { 

super(message); 

} 

} 

 

public class DrivingLicenseSystem { 

 

static void checkLicenseEligibility(int age) throws InvalidDrivingAgeException 

{ 

if (age < 18) { 

throw new InvalidDrivingAgeException( 

"You are not eligible for a driving license. Age must be 18 or above." 

 

); 

} else { 

System.out.println("You are eligible for a driving license."); 
} 

} 

 

public static void main(String[] args) { Scanner sc = new Scanner(System.in); 

 

System.out.print("Enter your age: "); int age = sc.nextInt(); 

 

try { checkLicenseEligibility(age); 

} catch (InvalidDrivingAgeException e) { System.out.println("Exception: " + e.getMessage()); 

} 

 

sc.close(); 

} 

}
import java.util.Scanner; 

 

// Custom Exception 

class InvalidPasswordException extends Exception { public InvalidPasswordException(String message) { 

super(message); 

} 

} 

 

public class LoginProgram { 

 

static void login(String password) throws InvalidPasswordException { String correctPassword = "12345"; 

 

if (!password.equals(correctPassword)) { 

throw new InvalidPasswordException("Invalid password!"); 

} else { 

System.out.println("Login successful."); 

} 

} 

 

public static void main(String[] args) { Scanner sc = new Scanner(System.in); 

 

System.out.print("Enter password: "); String password = sc.nextLine(); 

 

try { login(password); 

} catch (InvalidPasswordException e) { System.out.println("Exception: " + e.getMessage()); 

} finally { 

System.out.println("Login process completed."); 

} 

 

sc.close(); 

} 
}
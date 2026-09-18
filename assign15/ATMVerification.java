import java.util.Scanner; 

 

// Custom Exception 

class InvalidPINException extends Exception { public InvalidPINException(String message) { 

super(message); 

} 

} 

 

public class ATMVerification { 

 

static void verifyPIN(int pin) throws InvalidPINException { int correctPIN = 1234; 

 

if (pin != correctPIN) { 

throw new InvalidPINException("Invalid PIN entered!"); 

} else { 

System.out.println("PIN verified successfully."); 

} 

} 

 

public static void main(String[] args) { Scanner sc = new Scanner(System.in); 

 

System.out.print("Enter ATM PIN: "); int pin = sc.nextInt(); 

 

try { verifyPIN(pin); 

} catch (InvalidPINException e) { System.out.println("Exception: " + e.getMessage()); 

} finally { 

System.out.println("PIN verification process completed."); 

} 

 

sc.close(); 

} 

} 
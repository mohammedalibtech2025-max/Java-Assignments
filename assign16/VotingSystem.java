import java.util.Scanner; 

 

// Custom Exception 

class InvalidVotingAgeException extends Exception { public InvalidVotingAgeException(String message) { 

super(message); 

} 

} 

 

public class VotingSystem { 

 

static void checkVotingEligibility(int age) throws InvalidVotingAgeException { if (age < 18) { 

throw new InvalidVotingAgeException( 

"You are not eligible to vote. Age must be 18 or above." 

); 

} else { 

System.out.println("You are eligible to vote."); 

} 

} 

 

public static void main(String[] args) { Scanner sc = new Scanner(System.in); 

 

System.out.print("Enter your age: "); int age = sc.nextInt(); 

 

try { checkVotingEligibility(age); 

} catch (InvalidVotingAgeException e) { System.out.println("Exception: " + e.getMessage()); 

} 

 

sc.close(); 

} 

} 
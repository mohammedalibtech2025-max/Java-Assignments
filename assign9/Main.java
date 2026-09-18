class BankAccount { 

final int accountNumber; String name; 

double balance; 

 

BankAccount(int accountNumber, String name, double balance) { this.accountNumber = accountNumber; 

this.name = name; this.balance = balance; 

} 

 

void display() { 

System.out.println("Account Number: " + accountNumber); System.out.println("Name: " + name); System.out.println("Balance: Rs." + balance); 

} 

} 

 

public class Main { 

public static void main(String[] args) { BankAccount account = 

new BankAccount(12345, "Rahul", 25000); account.display(); 

} 

}
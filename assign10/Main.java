abstract class Payment { 

abstract void pay(double amount); 

} 

 

class CreditCard extends Payment { void pay(double amount) { 

System.out.println("Paid Rs." + amount + " using Credit Card"); 

} 

} 

 

class UPI extends Payment { void pay(double amount) { 

System.out.println("Paid Rs." + amount + " using UPI"); 

} 

} 

 

public class Main { 

public static void main(String[] args) { Payment p1 = new CreditCard(); Payment p2 = new UPI(); 

 

p1.pay(1500); 

p2.pay(750); 

} 

}
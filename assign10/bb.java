abstract class FoodOrder { double amount; 

 

FoodOrder(double amount) { this.amount = amount; 

} 

 

abstract void calculateBill(); 

} 

 

class DineInOrder extends FoodOrder { DineInOrder(double amount) { 

super(amount); 

} 

 

void calculateBill() { 
    double bill = amount + (amount * 0.05); System.out.println("Dine-In Bill: Rs." + bill); 

} 

} 

 

class TakeAwayOrder extends FoodOrder { TakeAwayOrder(double amount) { 

super(amount); 

} 

 

void calculateBill() { 

double bill = amount + 30; System.out.println("Take-Away Bill: Rs." + bill); 

} 

} 

 

public class bb { 

public static void main(String[] args) { FoodOrder d = new DineInOrder(1000); FoodOrder t = new TakeAwayOrder(1000); 

 

d.calculateBill(); t.calculateBill(); 

} 

} 
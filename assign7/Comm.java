interface Product { 

void displayProduct(); 

} 

 

class Electronic implements Product { String name; 

double price; 

 

Electronic(String name, double price) { this.name = name; 

this.price = price; 

} 

 

public void displayProduct() { System.out.println("Electronic: " + name + 

", Rs." + price); 

} 

} 

 

class Clothing implements Product { String name; 

double price; 

 

Clothing(String name, double price) { this.name = name; 

this.price = price; 

} 

 

public void displayProduct() { System.out.println("Clothing: " + name + 

", Rs." + price); 

} 

} 

 

class Grocery implements Product { String name; 

double price; 

 

Grocery(String name, double price) { this.name = name; 

this.price = price; 

} 

 

public void displayProduct() { System.out.println("Grocery: " + name + 

", Rs." + price); 

} 

}
public class Comm { 

public static void main(String[] args) { 

Product p1 = new Electronic("Laptop", 50000); Product p2 = new Clothing("Shirt", 1200); Product p3 = new Grocery("Rice", 800); 

 

p1.displayProduct(); p2.displayProduct(); p3.displayProduct(); 

} 

}
class Vehicle { 

String brand = "Toyota"; String model = "Fortuner"; 

 

class Details { void display() { 

System.out.println("Brand: " + brand); System.out.println("Model: " + model); 

} 

} 

 

void action() { 

Runnable r = new Runnable() { public void run() { 

System.out.println("Vehicle is moving"); 

} 

}; 

 

r.run(); 

} 

} 

 

public class Main { 

public static void main(String[] args) { Vehicle v = new Vehicle(); 

 

Vehicle.Details d = v.new Details(); d.display(); 

 

v.action(); 

} 

} 

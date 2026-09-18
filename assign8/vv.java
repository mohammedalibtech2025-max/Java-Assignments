class Vehicle { 

String vehicleNumber; String vehicleType; 

 

Vehicle(String vehicleNumber, String vehicleType) { this.vehicleNumber = vehicleNumber; this.vehicleType = vehicleType; 

} 

 

void displayVehicle() { 

System.out.println("Vehicle Number: " + vehicleNumber); System.out.println("Vehicle Type: " + vehicleType); 

} 

} 

class CarInsurance extends Vehicle { double premium; 

 

CarInsurance(String number, double premium) { super(number, "Car"); 

this.premium = premium; 

} 

 

void display() { super.displayVehicle(); 

System.out.println("Insurance Premium: Rs." + premium); 

} 

} 

class BikeInsurance extends Vehicle { double premium; 

 

BikeInsurance(String number, double premium) { super(number, "Bike"); 

this.premium = premium; 

} 

 

void display() { super.displayVehicle(); 

System.out.println("Insurance Premium: Rs." + premium); 

} 

} 

public class vv { 

public static void main(String[] args) { 

CarInsurance c = new CarInsurance("MH12AB1234", 12000); BikeInsurance b = new BikeInsurance("MH14XY5678", 5000); 

 

c.display(); System.out.println(); b.display(); 

} 
}
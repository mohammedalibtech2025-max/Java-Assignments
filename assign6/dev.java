class FoodDelivery { String foodName; int quantity; 

 

FoodDelivery(String foodName, int quantity) { this.foodName = foodName; 

this.quantity = quantity; 

} 

 

class OrderDetails { void display() { 

System.out.println("Food: " + foodName); System.out.println("Quantity: " + quantity); 

} 

} 

 

void deliveryStatus() { 

Runnable status = new Runnable() { public void run() { 

System.out.println("Order is out for delivery"); 

} 

}; 

 

status.run(); 

} 

} 

 

public class dev { 

public static void main(String[] args) { FoodDelivery order = 

new FoodDelivery("Pizza", 2); 

 

FoodDelivery.OrderDetails details = order.new OrderDetails(); 

 

details.display(); order.deliveryStatus(); 

} 

}
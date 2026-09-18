abstract class Shape { abstract void area(); 

} 

 

class Circle extends Shape { double radius; 

 

Circle(double radius) { this.radius = radius; 

} 

 

void area() { 

System.out.println("Area of Circle: " + (Math.PI * radius * radius)); 

} 

} 

 

class Rectangle extends Shape { double length, width; 

 

Rectangle(double length, double width) { this.length = length; 

this.width = width; 

} 

 

void area() { 

System.out.println("Area of Rectangle: " + (length * width)); 

} 

} 

 

public class Main { 

public static void main(String[] args) { Shape c = new Circle(5); 

Shape r = new Rectangle(10, 5); 

 

c.area(); 

r.area(); 

} 

}
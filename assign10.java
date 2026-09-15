abstract class Shape {
    abstract void area();
}

class Circle extends Shape {
    void area() {
        double r = 5;
        double result = 3.14 * r * r;
        System.out.println("Area of Circle: " + result);
    }
}

class Rectangle extends Shape {
    void area() {
        int length = 10;
        int width = 5;
        int result = length * width;
        System.out.println("Area of Rectangle: " + result);
    }
}

public class assign10 {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.area();
        s2.area();
    }
}
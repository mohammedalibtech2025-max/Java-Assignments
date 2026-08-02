class Calculator {

    // Static variable
    static int calculationCount = 0;

    // Method Overloading - Addition of two integers
    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    // Method Overloading - Addition of three integers
    int add(int a, int b, int c) {
        calculationCount++;
        return a + b + c;
    }

    // Method Overloading - Addition of two double values
    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    // Static method
    static void displayCount() {
        System.out.println("Total Calculations Performed: " + calculationCount);
    }
}

public class assign3 {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Addition of 10 and 20 = " + calc.add(10, 20));
        System.out.println("Addition of 5, 10 and 15 = " + calc.add(5, 10, 15));
        System.out.println("Addition of 12.5 and 7.5 = " + calc.add(12.5, 7.5));

        // Calling static method
        Calculator.displayCount();
    }
}
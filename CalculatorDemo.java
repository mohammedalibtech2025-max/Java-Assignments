class Calculator {

    // Static variable to count calculations
    static int count = 0;

    // Method for adding integers
    int add(int a, int b) {
        count++;
        return a + b;
    }

    // Overloaded method for adding decimals
    double add(double a, double b) {
        count++;
        return a + b;
    }

    // Display total calculations
    static void displayCount() {
        System.out.println("Total Calculations: " + count);
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {

        Calculator cal = new Calculator();

        // Addition of integers
        int result1 = cal.add(10, 20);
        System.out.println("Addition of integers: " + result1);

        // Addition of decimals
        double result2 = cal.add(10.5, 20.5);
        System.out.println("Addition of decimals: " + result2);

        // Another calculation
        int result3 = cal.add(5, 15);
        System.out.println("Addition of integers: " + result3);

        // Display calculation count
        Calculator.displayCount();
    }
}

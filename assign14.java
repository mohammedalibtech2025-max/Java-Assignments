import java.util.Scanner;

public class assign14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Multiple catch blocks
        try {
            System.out.print("Enter a number: ");
            int a = sc.nextInt();

            System.out.print("Enter another number: ");
            int b = sc.nextInt();

            System.out.println("Division: " + (a / b));

            // Nested try-catch
            try {
                int[] arr = {10, 20, 30};
                System.out.println("Array element: " + arr[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Nested catch: Array index is out of bounds.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Catch: Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("Catch: Invalid input.");
        }

        sc.close();
    }
}
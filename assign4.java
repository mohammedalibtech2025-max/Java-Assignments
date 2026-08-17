public class assign4 {

    public static void main(String[] args) {

        // Primitive data types
        int num = 25;
        double price = 99.99;

        // Primitive to Wrapper Object (Autoboxing)
        Integer intObj = num;
        Double doubleObj = price;

        System.out.println("Wrapper Integer Object: " + intObj);
        System.out.println("Wrapper Double Object: " + doubleObj);

        // Wrapper Object to Primitive (Unboxing)
        int newNum = intObj;
        double newPrice = doubleObj;

        System.out.println("Primitive Integer: " + newNum);
        System.out.println("Primitive Double: " + newPrice);

        // Basic operations on wrapped values
        int sum = intObj + 15;
        double totalPrice = doubleObj * 2;

        System.out.println("Sum = " + sum);
        System.out.println("Total Price = " + totalPrice);

        // String to Wrapper Object
        String str = "100";
        Integer value = Integer.parseInt(str);

        System.out.println("Converted String to Integer: " + value);

        // Wrapper Object to String
        String result = value.toString();

        System.out.println("Converted Integer to String: " + result);
    }
}
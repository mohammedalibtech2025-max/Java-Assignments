public class MarkConvert {

    public static void main(String[] args) {

        // Marks stored in String format
        String mark1 = "85";
        String mark2 = "90";
        String mark3 = "78";

        // Convert String to Integer
        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);
        int m3 = Integer.parseInt(mark3);

        // Calculate total marks
        int total = m1 + m2 + m3;

        // Display marks and total
        System.out.println("Mark 1: " + m1);
        System.out.println("Mark 2: " + m2);
        System.out.println("Mark 3: " + m3);

        System.out.println("Total Marks: " + total);
    }
}
final class Constants {
    final int MAX_MARKS = 100;

    final void displayMessage() {
        System.out.println("This is a final method.");
    }
}

// A final class cannot be inherited
final class FinalClass {
    void show() {
        System.out.println("This is a final class.");
    }
}

public class assign9 {
    public static void main(String[] args) {

        // Final variable
        final int marks = 95;
        System.out.println("Final variable marks: " + marks);

        // Final method
        Constants obj = new Constants();
        obj.displayMessage();

        // Final class
        FinalClass fc = new FinalClass();
        fc.show();

        System.out.println("Final keyword demonstrated successfully.");
    }
}
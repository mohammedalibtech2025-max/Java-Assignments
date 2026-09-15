class OuterClass {

    private String message = "Hello from Outer Class";

    // Inner class
    class InnerClass {

        void display() {
            System.out.println("Inner Class:");
            System.out.println(message);
        }
    }

    public static void main(String[] args) {

        // Creating object of Outer Class
        OuterClass outer = new OuterClass();

        // Creating object of Inner Class
        OuterClass.InnerClass inner = outer.new InnerClass();

        // Calling Inner Class method
        inner.display();

        // Anonymous Class
        Greeting greeting = new Greeting() {
            @Override
            public void showMessage() {
                System.out.println("\nAnonymous Class:");
                System.out.println("Hello from Anonymous Class");
            }
        };

        // Calling Anonymous Class method
        greeting.showMessage();
    }
}

// Interface for Anonymous Class
interface Greeting {
    void showMessage();
}
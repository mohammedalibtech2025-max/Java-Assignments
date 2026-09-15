class Parent {
    int number = 10;

    void display() {
        System.out.println("This is the Parent class.");
    }
}

class Child extends Parent {
    int number = 20;

    void show() {
        System.out.println("Parent class variable: " + super.number);
        super.display();
        System.out.println("Child class variable: " + number);
    }
}

public class SuperKeywordDemo {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}
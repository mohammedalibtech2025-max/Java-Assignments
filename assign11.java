interface Animal {
    void sound();
}

interface Pet {
    void activity();
}

class Dog implements Animal, Pet {
    public void sound() {
        System.out.println("Dog makes a sound: Bark");
    }

    public void activity() {
        System.out.println("Dog is playing");
    }
}

public class assign11 {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.sound();
        d.activity();
    }
}
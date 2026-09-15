class Animal{
    void sound(){
        System.out.println("Animal makes a sound");
    }
}

public class InnerAnon{
    public static void main(String[]args){
        Animal a = new Animal(){
            void sound(){
                System.out.println("dog barks");
            }
        };
        a.sound();
    }
}
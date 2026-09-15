class Outer {
    private String message = "hello from outer Class";

    class Inner{
        void display(){
            System.out.println("message:"+message);
        }
    }
}

public class InnerAnonymousDemo{
    public static void main(String[]args){

        Outer obj = new Outer();
        Outer.Inner in= obj.new Inner();
        in.display();
    }

}
 
import library.Library;

public class LibraryMain {

    public static void main(String[] args) {

        Library b = new Library(
            101,
            "Java Programming",
            "James Gosling",
            599
        );

        System.out.println("----- Book Details -----");
        b.display();
    }
}
class Book { 

final String isbn; String title; String author; double price; 

 

Book(String isbn, String title, String author, double price) { this.isbn = isbn; 

this.title = title; this.author = author; this.price = price; 

} 

 void display() { System.out.println("ISBN: " + isbn); System.out.println("Title: " + title); 

System.out.println("Author: " + author); System.out.println("Price: Rs." + price); 

} 

} 

 

public class boo { 

public static void main(String[] args) { Book b = new Book( 

"9781234567890", 

"Java Programming", "James", 

599 

); 

 

b.display(); 

} 

} 
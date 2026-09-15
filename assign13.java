import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class assign13 {
    public static void main(String[] args) {
        try {
            // Writing to the file
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello, this is Java File Handling.\n");
            writer.write("This file contains sample text.");
            writer.close();

            // Reading from the file
            FileReader reader = new FileReader("sample.txt");
            int ch;

            System.out.println("File Content:");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
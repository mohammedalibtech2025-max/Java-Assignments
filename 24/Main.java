
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {

    JTextField studentField, bookField;
    Connection con;

    Main() {
        setTitle("Library Book Management System");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student ID:"));
        studentField = new JTextField();
        add(studentField);

        add(new JLabel("Book ID:"));
        bookField = new JTextField();
        add(bookField);

        JButton issueButton = new JButton("Issue Book");
        JButton returnButton = new JButton("Return Book");

        add(issueButton);
        add(returnButton);

        issueButton.addActionListener(e -> issueBook());
        returnButton.addActionListener(e -> returnBook());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db",
                "root",
                "0536373438"
            );

            JOptionPane.showMessageDialog(
                this, "Database Connected Successfully!"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Database Error: " + e.getMessage()
            );
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void issueBook() {
        if (con == null) {
            JOptionPane.showMessageDialog(
                this, "Database is not connected!"
            );
            return;
        }

        try {
            int studentId = Integer.parseInt(
                studentField.getText().trim()
            );
            int bookId = Integer.parseInt(
                bookField.getText().trim()
            );

            String sql =
                "INSERT INTO book_issue " +
                "(student_id, book_id, status) VALUES (?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, studentId);
                ps.setInt(2, bookId);
                ps.setString(3, "Issued");

                ps.executeUpdate();

                JOptionPane.showMessageDialog(
                    this, "Book Issued Successfully!"
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error Issuing Book: " + e.getMessage()
            );
        }
    }

    void returnBook() {
        if (con == null) {
            JOptionPane.showMessageDialog(
                this, "Database is not connected!"
            );
            return;
        }

        try {
            int studentId = Integer.parseInt(
                studentField.getText().trim()
            );
            int bookId = Integer.parseInt(
                bookField.getText().trim()
            );

            String sql =
                "UPDATE book_issue SET status = 'Returned' " +
                "WHERE student_id = ? AND book_id = ? " +
                "AND status = 'Issued'";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, studentId);
                ps.setInt(2, bookId);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(
                        this, "Book Returned Successfully!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        this, "No matching issued book found!"
                    );
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Error Returning Book: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}


import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class exr1 extends JFrame {

    JTextField idField, nameField, authorField;
    JTextArea output;
    Connection con;

    exr1() {
        setTitle("Library Management System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));

        form.add(new JLabel("Book ID:"));
        idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Book Name:"));
        nameField = new JTextField();
        form.add(nameField);

        form.add(new JLabel("Author:"));
        authorField = new JTextField();
        form.add(authorField);

        JPanel buttons = new JPanel(new GridLayout(1, 4, 5, 5));

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton updateButton = new JButton("Update Book");
        JButton deleteButton = new JButton("Delete Book");

        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);

        output = new JTextArea(12, 40);
        output.setEditable(false);

        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);

        connectDatabase();

        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());

        setLocationRelativeTo(null);
        setVisible(true);

        if (con != null) {
            viewBooks();
        }
    }

    void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library_db",
                "root",
                "0536373438"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Database Error: " + e.getMessage()
            );
        }
    }

    boolean validInput(boolean requireAll) {
        if (con == null) {
            JOptionPane.showMessageDialog(
                this, "Database is not connected."
            );
            return false;
        }

        if (idField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Book ID.");
            return false;
        }

        try {
            if (Integer.parseInt(idField.getText().trim()) <= 0) {
                JOptionPane.showMessageDialog(
                    this, "Book ID must be positive."
                );
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this, "Book ID must be a number."
            );
            return false;
        }

        if (requireAll &&
            (nameField.getText().trim().isEmpty() ||
             authorField.getText().trim().isEmpty())) {

            JOptionPane.showMessageDialog(
                this, "Enter both Book Name and Author."
            );
            return false;
        }

        return true;
    }

    void addBook() {
        if (!validInput(true)) return;

        String sql =
            "INSERT INTO books (book_id, book_name, author) " +
            "VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(idField.getText().trim()));
            ps.setString(2, nameField.getText().trim());
            ps.setString(3, authorField.getText().trim());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Book added successfully!"
            );

            viewBooks();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to add book: " + e.getMessage()
            );
        }
    }

    void viewBooks() {
        if (con == null) return;

        output.setText("LIBRARY BOOK RECORDS\n\n");

        String sql = "SELECT * FROM books ORDER BY book_id";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    "\nBook Name: " + rs.getString("book_name") +
                    "\nAuthor: " + rs.getString("author") +
                    "\n------------------------------\n"
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to view books: " + e.getMessage()
            );
        }
    }

    void updateBook() {
        if (!validInput(true)) return;

        String sql =
            "UPDATE books SET book_name = ?, author = ? " +
            "WHERE book_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nameField.getText().trim());
            ps.setString(2, authorField.getText().trim());
            ps.setInt(3, Integer.parseInt(idField.getText().trim()));

            int rows = ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                rows > 0
                    ? "Book updated successfully!"
                    : "Book ID not found."
            );

            viewBooks();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to update book: " + e.getMessage()
            );
        }
    }

    void deleteBook() {
        if (!validInput(false)) return;

        String sql = "DELETE FROM books WHERE book_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(idField.getText().trim()));

            int rows = ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                rows > 0
                    ? "Book deleted successfully!"
                    : "Book ID not found."
            );

            viewBooks();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to delete book: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new exr1());
    }
}

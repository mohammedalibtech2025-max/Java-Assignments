
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class exr2 extends JFrame {

    JTextField bookField, studentField, issueField, returnField;
    JTextArea output;
    Connection con;

    exr2() {
        setTitle("Book Issue Tracking System");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        form.add(new JLabel("Book ID:"));
        bookField = new JTextField();
        form.add(bookField);

        form.add(new JLabel("Student Name:"));
        studentField = new JTextField();
        form.add(studentField);

        form.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueField = new JTextField();
        form.add(issueField);

        form.add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnField = new JTextField();
        form.add(returnField);

        JPanel buttons = new JPanel(new GridLayout(1, 4, 5, 5));

        JButton addButton = new JButton("Add Record");
        JButton viewButton = new JButton("View Records");
        JButton updateButton = new JButton("Update Record");
        JButton deleteButton = new JButton("Delete Record");

        buttons.add(addButton);
        buttons.add(viewButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);

        output = new JTextArea(15, 45);
        output.setEditable(false);

        JPanel top = new JPanel(new BorderLayout(5, 5));
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);

        connectDatabase();

        addButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        updateButton.addActionListener(e -> updateRecord());
        deleteButton.addActionListener(e -> deleteRecord());

        setLocationRelativeTo(null);
        setVisible(true);

        if (con != null) {
            viewRecords();
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

    boolean validInput(boolean requireReturnDate) {
        if (con == null) {
            JOptionPane.showMessageDialog(
                this, "Database is not connected."
            );
            return false;
        }

        if (bookField.getText().trim().isEmpty()
                || studentField.getText().trim().isEmpty()
                || issueField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Enter Book ID, Student Name and Issue Date."
            );
            return false;
        }

        try {
            if (Integer.parseInt(bookField.getText().trim()) <= 0) {
                JOptionPane.showMessageDialog(
                    this, "Book ID must be positive."
                );
                return false;
            }

            Date issueDate = Date.valueOf(
                issueField.getText().trim()
            );

            String returnText = returnField.getText().trim();

            if (requireReturnDate && returnText.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, "Enter the Return Date."
                );
                return false;
            }

            if (!returnText.isEmpty()) {
                Date returnDate = Date.valueOf(returnText);

                if (returnDate.before(issueDate)) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Return Date cannot be before Issue Date."
                    );
                    return false;
                }
            }

            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this, "Book ID must be a number."
            );
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                this,
                "Enter valid dates in YYYY-MM-DD format."
            );
        }

        return false;
    }

    void addRecord() {
        if (!validInput(false)) return;

        String sql =
            "INSERT INTO book_tracking " +
            "(book_id, student_name, issue_date, return_date) " +
            "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(
                1, Integer.parseInt(bookField.getText().trim())
            );
            ps.setString(2, studentField.getText().trim());
            ps.setDate(
                3, Date.valueOf(issueField.getText().trim())
            );

            String returnText = returnField.getText().trim();

            if (returnText.isEmpty()) {
                ps.setNull(4, Types.DATE);
            } else {
                ps.setDate(4, Date.valueOf(returnText));
            }

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Book issue record added successfully!"
            );

            viewRecords();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to add record: " + e.getMessage()
            );
        }
    }

    void viewRecords() {
        if (con == null) return;

        output.setText("BOOK ISSUE TRACKING RECORDS\n\n");

        String sql =
            "SELECT * FROM book_tracking " +
            "ORDER BY issue_date, book_id";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Date returnDate = rs.getDate("return_date");

                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    "\nStudent Name: " + rs.getString("student_name") +
                    "\nIssue Date: " + rs.getDate("issue_date") +
                    "\nReturn Date: " +
                    (returnDate == null
                        ? "Not returned yet"
                        : returnDate) +
                    "\n------------------------------\n"
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to view records: " + e.getMessage()
            );
        }
    }

    void updateRecord() {
        if (!validInput(false)) return;

        String sql =
            "UPDATE book_tracking SET return_date = ? " +
            "WHERE book_id = ? AND student_name = ? " +
            "AND issue_date = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            String returnText = returnField.getText().trim();

            if (returnText.isEmpty()) {
                ps.setNull(1, Types.DATE);
            } else {
                ps.setDate(1, Date.valueOf(returnText));
            }

            ps.setInt(
                2, Integer.parseInt(bookField.getText().trim())
            );
            ps.setString(3, studentField.getText().trim());
            ps.setDate(
                4, Date.valueOf(issueField.getText().trim())
            );

            int rows = ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                rows > 0
                    ? "Record updated successfully!"
                    : "Matching record not found."
            );

            viewRecords();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to update record: " + e.getMessage()
            );
        }
    }

    void deleteRecord() {
        if (!validInput(false)) return;

        String sql =
            "DELETE FROM book_tracking " +
            "WHERE book_id = ? AND student_name = ? " +
            "AND issue_date = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(
                1, Integer.parseInt(bookField.getText().trim())
            );
            ps.setString(2, studentField.getText().trim());
            ps.setDate(
                3, Date.valueOf(issueField.getText().trim())
            );

            int rows = ps.executeUpdate();

            JOptionPane.showMessageDialog(
                this,
                rows > 0
                    ? "Record deleted successfully!"
                    : "Matching record not found."
            );

            viewRecords();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Unable to delete record: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new exr1());
    }
}

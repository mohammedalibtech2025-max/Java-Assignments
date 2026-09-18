import java.awt.*; 
 import java.awt.event.*;
 import javax.swing.*; 

public class EmployeeRegistration extends JFrame implements ActionListener { JTextField employeeId, name, department, salary; 

JButton submit; 

 

EmployeeRegistration() { 

 

setTitle("Employee Registration Form"); setSize(450, 300); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new GridLayout(5, 2, 10, 10)); 

 

// Employee ID 

add(new JLabel("Employee ID:")); employeeId = new JTextField(); add(employeeId); 

 

// Name 

add(new JLabel("Employee Name:")); name = new JTextField(); add(name); 

 

// Department 

add(new JLabel("Department:")); department = new JTextField(); add(department); 

 

// Salary 

add(new JLabel("Salary:")); salary = new JTextField(); add(salary); 

 

// Submit Button 

submit = new JButton("Register"); add(submit); 

 

submit.addActionListener(this); 

 

setLocationRelativeTo(null); setVisible(true); 

} 

 

public void actionPerformed(ActionEvent e) { 
    String id = employeeId.getText(); String employeeName = name.getText(); String dept = department.getText(); String empSalary = salary.getText(); 

 

JOptionPane.showMessageDialog( this, 

"Employee Registration Details\n\n" + "Employee ID: " + id + "\n" + 

"Name: " + employeeName + "\n" + "Department: " + dept + "\n" + "Salary: " + empSalary 

); 

} 

 

public static void main(String[] args) { new EmployeeRegistration(); 

} 

} 

 
import java.awt.*; 
 import java.awt.event.*;
 import javax.swing.*; 

public class StudentRegistration extends JFrame implements ActionListener { JTextField name, rollNo, course; 

JButton submit; 

 

StudentRegistration() { 

 

setTitle("Student Registration Form"); setSize(400, 300); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new GridLayout(4, 2, 10, 10)); 

 

// Name 

add(new JLabel("Student Name:")); name = new JTextField(); add(name); 

 

// Roll Number 

add(new JLabel("Roll Number:")); rollNo = new JTextField(); add(rollNo); 

 

// Course 

add(new JLabel("Course:")); course = new JTextField(); add(course); 

 

// Submit Button 

submit = new JButton("Register"); add(submit); 

 

submit.addActionListener(this); 

 

setLocationRelativeTo(null); setVisible(true); 

} 

 

public void actionPerformed(ActionEvent e) { 

 

String studentName = name.getText(); String studentRollNo = rollNo.getText(); String studentCourse = course.getText(); 

 

JOptionPane.showMessageDialog( 
    this, 

"Student Registered Successfully!\n\n" + "Name: " + studentName + "\n" + 

"Roll Number: " + studentRollNo + "\n" + "Course: " + studentCourse 

); 

} 

 

public static void main(String[] args) { new StudentRegistration(); 

} 

}
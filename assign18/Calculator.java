import javax.swing.*; import java.awt.*; import java.awt.event.*; 

public class Calculator extends JFrame implements ActionListener { JTextField num1, num2, result; 

JButton add, subtract; 

 

Calculator() { 

setTitle("Simple Calculator"); setSize(350, 250); 

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new GridLayout(4, 2, 10, 10)); 

 

// Input fields 

add(new JLabel("First Number:")); num1 = new JTextField(); add(num1); 

 

add(new JLabel("Second Number:")); num2 = new JTextField(); add(num2); 

 

// Buttons 

add = new JButton("Addition (+)"); subtract = new JButton("Subtraction (-)"); 

 

add(add); add(subtract); 

 

// Result 

add(new JLabel("Result:")); result = new JTextField(); result.setEditable(false); add(result); 

 

// Button listeners add.addActionListener(this); subtract.addActionListener(this); 

 

setLocationRelativeTo(null); setVisible(true); 

} 

 

public void actionPerformed(ActionEvent e) { try { 

double a = Double.parseDouble(num1.getText()); 

 double b = Double.parseDouble(num2.getText()); 

 

if (e.getSource() == add) { result.setText(String.valueOf(a + b)); 

} else if (e.getSource() == subtract) { result.setText(String.valueOf(a - b)); 

} 

} catch (NumberFormatException ex) { JOptionPane.showMessageDialog( 

this, 

"Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE 

); 

} 

} 

 

public static void main(String[] args) { new Calculator(); 

} 

} 
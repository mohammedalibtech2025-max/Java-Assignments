import java.awt.*; 
 import java.awt.event.*;
 import javax.swing.*; 

public class BankBalanceCalculator extends JFrame implements ActionListener { JTextField initialBalance, transactionAmount, updatedBalance; 

JButton deposit, withdraw; 

 

BankBalanceCalculator() { 

 

setTitle("Bank Balance Calculator"); setSize(400, 300); 

 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new GridLayout(4, 2, 10, 10)); 

 

// Initial Balance 

add(new JLabel("Initial Balance:")); initialBalance = new JTextField(); add(initialBalance); 

 

// Transaction Amount 

add(new JLabel("Transaction Amount:")); transactionAmount = new JTextField(); add(transactionAmount); 

 

// Buttons 

deposit = new JButton("Deposit (+)"); withdraw = new JButton("Withdraw (-)"); 

 

add(deposit); add(withdraw); 

 

// Updated Balance 

add(new JLabel("Updated Balance:")); updatedBalance = new JTextField(); updatedBalance.setEditable(false); add(updatedBalance); 

 

// Add action listeners deposit.addActionListener(this); withdraw.addActionListener(this); 

 

setLocationRelativeTo(null); setVisible(true); 

} 

 

@Override 

public void actionPerformed(ActionEvent e) { 

 

try { 

double balance = Double.parseDouble(initialBalance.getText()); double amount = Double.parseDouble(transactionAmount.getText()); 

 

if (amount < 0) { JOptionPane.showMessageDialog( 

this, 

"Transaction amount cannot be negative." 

); 

return; 

} 

 

// Deposit 

if (e.getSource() == deposit) { 

 balance = balance + amount; 

} 

 

// Withdrawal 

else if (e.getSource() == withdraw) { 

 

if (amount > balance) { JOptionPane.showMessageDialog( 

this, 

"Insufficient balance!" 

); 

return; 

} 

 

balance = balance - amount; 

} 

 

updatedBalance.setText(String.format("%.2f", balance)); 

 

} catch (NumberFormatException ex) { JOptionPane.showMessageDialog( 

this, 

"Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE 

); 

} 

} 

 

public static void main(String[] args) { new BankBalanceCalculator(); 

} 

}
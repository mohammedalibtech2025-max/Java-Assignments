
import javax.swing.*;

public class SwingExample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Example");

        JLabel label = new JLabel("Welcome to Java Swing!");
        label.setBounds(80, 50, 250, 30);

        JButton button = new JButton("Click Me");
        button.setBounds(100, 100, 120, 40);

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Button Clicked!");
        });

        frame.add(label);
        frame.add(button);

        frame.setSize(350, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


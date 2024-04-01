import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Main() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);
        panel.add(clearButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("123")) {
                dispose();
                new WelcomeForm();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getActionCommand().equals("Clear")) {
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

class WelcomeForm extends JFrame implements ActionListener {
    public WelcomeForm() {
        setTitle("Welcome Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome, admin!");
        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(welcomeLabel);
        panel.add(logoutButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new Main();
    }
}

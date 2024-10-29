package gui;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
	LoginForm lgForm;

	private JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPanel lgPanel;

    public LoginForm() {
        // Set the title of the window
        setTitle("Member Login");
        // Set the size of the window
        setSize(600, 300);
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the window
        setLocationRelativeTo(null);
        
        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using absolute layout

        // Create and set the logo image
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("Java_basic\\image\\—Pngtree—user vector avatar_4830521.png"));
        logoLabel.setBounds(50, 50, 100, 100);
        panel.add(logoLabel);

        // Create the email label and text field
        JLabel UsernameLabel = new JLabel("Username:");
        UsernameLabel.setBounds(200, 50, 80, 25);
        panel.add(UsernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(290, 50, 200, 25);
        panel.add(usernameField);

        // Create the password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 90, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(290, 90, 200, 25);
        panel.add(passwordField);

        // Create the login button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(290, 130, 200, 35);
        loginButton.setBackground(new Color(0, 204, 0)); // Green color
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> Login());
        panel.add(loginButton);

        // Create the forgot password link
        JLabel forgotPasswordLabel = new JLabel("Forgot Username / Password?");
        forgotPasswordLabel.setBounds(290, 170, 200, 25);
        forgotPasswordLabel.setForeground(new Color(100, 100, 100));
        panel.add(forgotPasswordLabel);

        // Create the create account link
        JLabel createAccountLabel = new JLabel("Create your Account →");
        createAccountLabel.setBounds(290, 200, 200, 25);
        createAccountLabel.setForeground(new Color(100, 100, 100));
        panel.add(createAccountLabel);

        // Add the panel to the frame
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        // Create an instance of the LoginForm class
        LoginForm loginForm = new LoginForm();
        // Make the frame visible
        loginForm.setVisible(true);
    }
    public void Login( ) {
		objects.Login a = new objects.Login();
		if(this.usernameField.getText().equals(a.getUsername()) && this.passwordField.getText().equals(a.getPass())) {
			JOptionPane.showConfirmDialog(this.lgPanel, "Đăng nhập thành công", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
			new Home().setVisible(true);
            this.setVisible(false);
		} else {
			JOptionPane.showConfirmDialog(this.lgPanel, "Đăng nhập không thành công", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
}

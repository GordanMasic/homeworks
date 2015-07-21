package ba.bitcamp.task03;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {

	private static final long serialVersionUID = 5170943761256434479L;

	//Declaring variables
	private JPanel empty = new JPanel();
	private JLabel username = new JLabel("Username: ");
	private JLabel password = new JLabel("Password: ");
	private JTextField usernameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();

	
	
	public Login(int width, int height) {
		
		
		//Panel settings
		empty.setPreferredSize(new Dimension(width, height / 3));
		
		//Username field settings
		usernameField.setPreferredSize(new Dimension(width / 2, height / 10));
		
		//Password field settings
		passwordField.setPreferredSize(new Dimension(width / 2, height / 10));
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				String s = "Mujo";
				String correct = "1234";
				String pass = String.valueOf(passwordField.getPassword());
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (usernameField.getText().equals(s)
							&& pass.equals(correct)) {
						System.exit(0);
					} else if (!pass.equals(correct)) {
						JOptionPane.showMessageDialog(null,
								"Inccorect Username or Password");
					} else if (!usernameField.getText().equals(s)) {
						JOptionPane.showMessageDialog(null,
								"Inccorect Username or Password");
					}
				}
			}
		});

		
		//Adding components on panel
		add(empty);
		add(username);
		add(usernameField);
		add(password);
		add(passwordField);

	}

	public static void main(String[] args) {

		//Declaring width and height
		int width = 300;
		int height = 200;

		//Creating window and panel
		JFrame window = new JFrame();
		JPanel container = new Login(width, height);

		//Adding panel to window
		window.add(container);

		//Window settings
		window.setTitle("Login");
		window.setSize(width, height);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}

package ba.bitcamp.task08;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1788825113584408633L;

	//Declaring variables
	private JPanel panel = new JPanel();
	private JPanel panelOne = new JPanel();
	private JPanel panelTwo = new JPanel();

	private JButton buttonOne = new JButton("Clear");
	private JButton buttonTwo = new JButton("Submit");

	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField passwordRetype = new JPasswordField();

	public RegisterForm() {

		//Panel settings
		panel.setBorder(BorderFactory.createTitledBorder("Register"));
		panel.setLayout(new BorderLayout());

		//Adding first panel to main panel
		panel.add(panelOne, BorderLayout.CENTER);

		//First panel settings
		panelOne.setLayout(new GridLayout(3, 2));
		panelOne.add(new JLabel("Username: "));
		panelOne.add(username);
		panelOne.add(new JLabel("Password: "));
		panelOne.add(password);
		panelOne.add(new JLabel("Retype password: "));
		panelOne.add(passwordRetype);

		//Second panel setting
		panel.add(panelTwo, BorderLayout.SOUTH);

		//Adding first button to second panel
		panelTwo.add(buttonOne);
		
		//Adding ActionListener to first button
		buttonOne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOne) {
					username.setText("");
					password.setText("");
					passwordRetype.setText("");
				}
			}
		});

		//Adding second button to second panel
		panelTwo.add(buttonTwo);
		
		//Adding ActionListener to second button
		buttonTwo.addActionListener(new Action());

		//Adding main panel to window
		add(panel);

		//Window settings
		setSize(300, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 8");
		setVisible(true);
	}

	public static void main(String[] args) {
		new RegisterForm();
	}

	/**
	 * 
	 *Private Inner class for setting ActionListener
	 *
	 */
	private class Action implements ActionListener {

		//Declaring variables
		int counterOne = 0;
		int counterTwo = 0;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonTwo) {
				
				//Turning password into string
				String passwordText = String.valueOf(password.getPassword());
				String passwordRetypeText = String.valueOf(passwordRetype
						.getPassword());
				
				//Checking password for special characters from ! to / in ASCII table
				for (int i = 0; i < passwordText.length(); i++) {
					for (int j = 33; j < 48; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterOne++;
						}
					}
					
					//Checking password for number characters from 0 to 9 in ASCII table
					for (int j = 48; j < 58; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterTwo++;
						}
					}
					//Checking password for special characters from : to @ in ASCII table
					for (int j = 58; j < 65; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterOne++;
						}
					}
				}
				
				//Username must have at least 6 characters
				if (username.getText().length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Username has less than 6 characters!");
					username.setText("");
					password.setText("");
					passwordRetype.setText("");
					
				//Password must have at least 6 characters
				} else if (passwordText.length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Password has less than 6 characters!");
					password.setText("");
					passwordRetype.setText("");
					
				//Password must have at least one special character and at least one number	
				} else if (counterOne == 0 && counterTwo == 0) {
					JOptionPane
							.showMessageDialog(null,
									"Password does not have special characters or numbers!");
					password.setText("");
					passwordRetype.setText("");
				} else if (counterOne == 0) {
					JOptionPane.showMessageDialog(null,
							"Password does not have special characters!");
					password.setText("");
					passwordRetype.setText("");
				} else if (counterTwo == 0) {
					JOptionPane.showMessageDialog(null,
							"Password does not have numbers!");
					password.setText("");
					passwordRetype.setText("");
					
				//Retyped password must match with password
				} else if (!passwordText.equals(passwordRetypeText)) {
					JOptionPane.showMessageDialog(null,
							"Passwords are not same!");
					password.setText("");
					passwordRetype.setText("");
				} else {
					JOptionPane.showMessageDialog(null,
							"You have successfully registered!");
					System.exit(0);
				}

			}

		}

	}
}
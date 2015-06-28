package ba.bitcamp.homeworkWeekend6.task02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {

	private static final long serialVersionUID = 4250920874456022561L;

	// Creating buttons
	private JButton nameButton = new JButton("Name");
	private JButton lastNameButton = new JButton("Last name");
	
	//Setting default name and last name
	private String name = "A";
	private String lastName = "A";
	
	//Creating label
	private JLabel label1 = new JLabel();
	
	//Two default counters
	private int counterName = 0;
	private int counterLastName = 0;

	//Array of names
	String[] names = new String[3];

	/**
	 * Constructor for creating JFrame window
	 */
	public Task2() {
		
		//Setting layout
		setLayout(new BorderLayout());

		//Making array of names. In this case name is one letter
		for (int i = 0; i < names.length; i++) {
			names[i] = "" + (char) (i + 65);
		}
		
		//Label settings
		label1.setText("Name " + name + " Last name " + lastName);
		label1.setHorizontalAlignment(JLabel.CENTER);
		add(label1);
		
		//Setting buttons
		nameButton.addActionListener(new generateName());
		lastNameButton.addActionListener(new generateLastName());
		add(nameButton, BorderLayout.WEST);
		add(lastNameButton, BorderLayout.EAST);
		
		//Window default settings
		setTitle("Generator for name and last name");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//ActionListener for "Name" button
	private class generateName implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Button "Name" settings
			if (counterName <= 2) {
				if (e.getSource() == nameButton) {
					counterName++;
					if (counterName == 3) {
						counterName = 0;
					}
					name = names[counterName];

					label1.setText("Name " + name + " Last name " + lastName);
				}

			}

		}

	}

	//ActionListener for "Last name" button
	private class generateLastName implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Button "Last name" settings
			if (counterLastName <= 2) {
				if (e.getSource() == lastNameButton) {
					counterLastName++;
					if (counterLastName == 3) {
						counterLastName = 0;
					}
					lastName = names[counterLastName];

					label1.setText("Name " + name + " Last name " + lastName);
				}

			}

		}

	}

	public static void main(String[] args) {
		new Task2();
	}
}

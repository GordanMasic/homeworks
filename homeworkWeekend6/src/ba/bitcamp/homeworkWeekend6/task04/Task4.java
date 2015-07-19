package ba.bitcamp.homeworkWeekend6.task04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	private static final long serialVersionUID = -4752987736569773758L;

	// Creating buttons left and right
	JButton leftButton = new JButton("<");
	JButton rightButton = new JButton(">");

	// Creating default character
	private char letter = 'a';

	// Creating buttons for insert and generating characters
	JButton characterButton = new JButton("Char: " + letter);
	JButton insertButton = new JButton("Insert character");

	// Creating label
	JLabel label = new JLabel("_");

	public Task4() {

		// Creating layout
		setLayout(new BorderLayout());

		// Adding label
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		// Adding buttons
		add(rightButton, BorderLayout.EAST);
		add(leftButton, BorderLayout.WEST);
		add(characterButton, BorderLayout.NORTH);
		add(insertButton, BorderLayout.SOUTH);

		rightButton.addActionListener(new Action());
		leftButton.addActionListener(new Action1());
		insertButton.addActionListener(new Action2());
		characterButton.addActionListener(new Action3());

		// Window default settings
		setLocationRelativeTo(null);
		setTitle("Task4");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	// Listener for generating random character
	private class Action3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			int numC = (int) ((Math.random() * 25) + 97);
			letter = (char) (numC);
			characterButton.setText("Char: " + letter);
		}

	}

	// Listener for inserting character
	private class Action2 implements ActionListener {
		private int counter = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < label.getText().length(); i++) {
				if (label.getText().charAt(i) == '_') {
					counter = i;
				}
			}

			if (counter > 0) {
				label.setText(label.getText().substring(0, counter)
						+ characterButton.getText().charAt(6)
						+ "_"
						+ label.getText().substring(counter + 1,
								label.getText().length()));
			} else {
				label.setText(characterButton.getText().charAt(6)
						+ "_"
						+ label.getText().substring(counter + 1,
								label.getText().length()));

			}
		}
	}

	// Listener for moving cursor left
	private class Action1 implements ActionListener {
		private char cursor = '_';

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = label.getText().length() - 1; i > 0; i--) {
				if (label.getText().charAt(i) == cursor) {
					if (i == label.getText().length() - 1) {
						label.setText(label.getText().substring(0, i - 1)
								+ cursor + label.getText().charAt(i - 1));
						break;
					} else {
						label.setText(label.getText().substring(0, i - 1)
								+ cursor
								+ label.getText().charAt(i - 1)
								+ label.getText().substring(i + 1,
										label.getText().length()));
						break;
					}
				}
			}
		}

	}

	// Listener for moving cursor right
	private class Action implements ActionListener {
		private char cursor = '_';

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < label.getText().length() - 1; i++) {
				if (label.getText().charAt(i) == cursor) {
					if (i == 0) {
						label.setText(""
								+ label.getText().charAt(i + 1)
								+ cursor
								+ label.getText().substring(i + 2,
										label.getText().length()));
						break;
					} else {
						label.setText(label.getText().substring(0, i)
								+ label.getText().charAt(i + 1)
								+ cursor
								+ label.getText().substring(i + 2,
										label.getText().length()));
						break;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new Task4();
	}
}

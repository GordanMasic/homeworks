package ba.bitcamp.homeworkWeekend6.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {

	private static final long serialVersionUID = -6063906903551659677L;

	// Creating array of buttons
	private JButton[] buttons = new JButton[9];

	// Creating variables
	private Integer sum = 0;
	private Integer base = 100;
	private Integer counter = 0;

	/**
	 * Constructor for making JFrame window
	 */
	public Task1() {
		// >>>>>>Creating window<<<<<<<

		// Creating window with grid of buttons 9X1
		setLayout(new GridLayout(9, 1, 5, 5));

		// Creating buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(i + 1 + "");
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		// Window configuration
		setTitle("Generator for three digit number");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (counter <= 2) {
				// Checking which button is pressed and adding his value to the
				// sum
				// Value from button is multiplied with base
				for (int j = 0; j < buttons.length; j++) {
					if (e.getSource() == buttons[j]) {
						sum += Integer.parseInt(buttons[j].getText()) * base;
					}
				}

				counter++;

				// Base is divided with 10 every iteration
				base /= 10;
			}
			if (counter == 3) {

				// When counter has value equals 3, number is printed and every
				// variable is set to default value
				JOptionPane.showMessageDialog(null, "Number is: " + sum);
				counter = 0;
				base = 100;
				sum = 0;
			}
		}

	}

	public static void main(String[] args) {
		new Task1();
	}
}
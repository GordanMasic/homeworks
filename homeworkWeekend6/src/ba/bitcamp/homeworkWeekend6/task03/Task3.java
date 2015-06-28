package ba.bitcamp.homeworkWeekend6.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task3 extends JFrame {

	private static final long serialVersionUID = -8870748513752457769L;

	// Creating array of buttons
	private JButton[] buttons = new JButton[10];

	// Creating array of numbers
	private int[] numbers = new int[5];

	// Default counter
	private int counter = 0;

	public Task3() {
		// >>>>>>Creating window<<<<<<<

		// Creating window with grid of buttons 9X1
		setLayout(new GridLayout(2, 5, 5, 5));

		// Creating buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(i + "");
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
			/*
			 * If we chose one number from the certain column, we put him in
			 * array and automatically we can't chose other number from the same
			 * column
			 */
			for (int i = 0; i < buttons.length; i++) {
				if (i < buttons.length / 2) {
					if (e.getSource() == buttons[i]) {
						numbers[counter] = i;
						buttons[i].setEnabled(false);
						buttons[i + 5] = null;
						counter++;
					}

				}
				if (i > buttons.length / 2) {
					if (e.getSource() == buttons[i]) {
						numbers[counter] = i;
						buttons[i].setEnabled(false);
						buttons[i - 5] = null;
						counter++;
					}
				}
			}

			// When counter reaches 5 another window appears with array of
			// numbers we created
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(numbers));

				System.exit(0);

			}
		}
	}

	public static void main(String[] args) {
		new Task3();
	}
}

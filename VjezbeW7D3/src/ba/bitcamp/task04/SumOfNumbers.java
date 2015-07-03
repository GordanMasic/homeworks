package ba.bitcamp.task04;


import javax.swing.JOptionPane;

public class SumOfNumbers {

	
	public static void main(String[] args) {
		
		//Declaring variables
		int sum = 0;
		String num;

		//Getting users respond for the first time on dialog message
		num = JOptionPane.showInputDialog("Input number");
		if (num == null) {
			System.exit(0);
		}
		try {
			sum += Integer.parseInt(num);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input", null,
					JOptionPane.ERROR_MESSAGE);
		}
		
		//Asking user if he wants another number to input
		int a = JOptionPane.showConfirmDialog(null,
				"Do you want to input another number?");
		if (a == JOptionPane.CANCEL_OPTION) {
			System.exit(0);
			
		} else {
			
			//Repeating until user wants it
			while (a == JOptionPane.YES_OPTION) {
				num = JOptionPane.showInputDialog("Input number");
				if (num == null) {
					System.exit(0);
				}
				try {
					sum += Integer.parseInt(num);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid input", null,
							JOptionPane.ERROR_MESSAGE);
				}
				a = JOptionPane.showConfirmDialog(null,
						"Do you want to input another number?");
			}
			if (a == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null,
						"Sum of inputed numbers is: " + sum);
			} else if (a == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}

	}

}

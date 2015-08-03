package ba.bitcamp.homewirkWeekend9.InterruptingAThread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Gordan
 *
 *         This class represents one JFrame window that contains one JLabel and
 *         one JButton. When main method is started starts a thread that writes
 *         each alphabet letter repeatedly until button is clicked. When button
 *         is clicked thread stops.
 */
public class MyWindow extends JFrame {

	// Constants
	private static final int LETTER_A = 97;
	private static final int LETTER_Z = 123;
	private static final int LETTER_Y = 122;
	private static final int DELAY = 1000;

	private static final long serialVersionUID = 5470208897265147168L;

	// Window components
	private JLabel label;
	private JButton buttonStop;

	// Thread
	private Thread thread;

	// Variables
	String labelText;
	private boolean run;

	public MyWindow() {

		// Creating JLabel
		label = new JLabel();
		// Creating JButton
		buttonStop = new JButton("Stop");
		// Initializing variables
		run = true;
		labelText = "";

		// Setting window layout
		setLayout(new BorderLayout());

		// Adding label to window
		add(label, BorderLayout.CENTER);

		// Setting horizontal alignment on label
		label.setHorizontalAlignment(SwingConstants.CENTER);

		// Adding button to window
		add(buttonStop, BorderLayout.SOUTH);

		// Initializing thread
		thread = new MyThread();

		// Starting thread
		thread.start();

		// Adding ActionListener to button that will stop thread
		buttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				run = false;

			}
		});

		// Window default settings
		setTitle("TestThread");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * 
	 * @author Gordan
	 *
	 *         Class that extends Thread. Contains run method that writes
	 *         alphabet letters on label every second repeatedly.
	 */
	private class MyThread extends Thread {

		@Override
		public void run() {

			// ASCII code for letter "a"
			int i = LETTER_A;

			// Writing alphabet letters on label repeatedly
			while (i < LETTER_Z && run == true) {
				if (i != LETTER_Y) {
					labelText += "" + (char) i;
					label.setText(labelText);
					i++;
				} else {
					labelText += "" + (char) i;
					label.setText(labelText);
					i = LETTER_A;
				}
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new MyWindow();
	}
}

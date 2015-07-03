package ba.bitcamp.task06;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Countdown extends JFrame {

	private static final long serialVersionUID = 8452084029598572981L;

	// Declaring variables
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private JTextField text = new JTextField();
	private JButton start = new JButton("Start");
	private int value;
	private Timer timer;

	public Countdown() {

		// Timer settings
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				value--;
				label.setText("" + value);
				panel.repaint();
				if (value == 0) {
					timer.stop();
				}

			}
		});

		// Panel settings
		panel.setLayout(new GridLayout(3, 1));

		// TextField settings
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setFont(new Font("SanSerif", Font.PLAIN, 15));

		// Label Settings
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("SanSerif", Font.BOLD, 15));

		// Button settings
		start.setFont(new Font("SanSerif", Font.BOLD, 15));
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == start) {
					value = Integer.parseInt(text.getText());
					label.setText("" + value);
					timer.start();
				}

			}
		});

		//Adding components to panel
		panel.add(label);
		panel.add(text);
		panel.add(start);

		//Adding panel to window
		add(panel);

		//Window settings
		setTitle("Countdown");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Countdown();

	}

}

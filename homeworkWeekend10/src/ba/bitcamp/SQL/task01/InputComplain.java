package ba.bitcamp.SQL.task01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Represents GUI application that has one JFrame in which user can input
 * complaint. It contains field where user can input text of the complaint and
 * the button to input written complaint.
 * 
 * @author Gordan
 *
 */
public class InputComplain extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6423356304952908586L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private JTextArea area = new JTextArea();
	private JButton insert = new JButton("Insert");

	/**
	 * Constructor.
	 */
	public InputComplain() {

		// Adding action listener to the button.
		insert.addActionListener(this);

		// Setting the border of the text area and adding elements on the panel.
		area.setBorder(BorderFactory.createTitledBorder("Write complaint"));
		panel.setLayout(new BorderLayout());
		panel.add(area, BorderLayout.CENTER);
		panel.add(insert, BorderLayout.SOUTH);

		// Adding panel on the frame.
		add(panel);

		// Setting the appearance of the frame.
		setSize(600, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Complaint Book");
		setVisible(true);
	}

	/**
	 * Inputs the complaint into the database.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insert) {
			// Calling method inputComplaint() from SQLConnection class and
			// forwarding the text of the text area as the
			// parameter.
			SQLConnection.inputComplaint(area.getText());
			JOptionPane.showMessageDialog(null, "Your complaint is saved.");
			area.setText("");
		}
	}

	public static void main(String[] args) {
		// Connecting to the database.
		SQLConnection.connectToDB();
		// Calling constructor.
		new InputComplain();
	}
}

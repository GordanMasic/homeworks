package ba.bitcamp.SQL.task02andtask03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represents GUI application that has one JFrame in which user can input new
 * product. It contains three fields where user can input code of the product,
 * name of the product and the price of the inputed product. It also contains
 * the button to input inputed product. The inputed product can not be already
 * in the database. That means that in the database can not be the product with
 * the equal code. The code need to have 10 digits, and only digits. If the
 * inputed code contains characters it opens WARNING frame, also if the product
 * with inputed code exist in database it opens WARNING frame.
 * 
 * @author Gordan
 *
 */
public class InputProduct extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1737620667081865709L;

	// Declaring main elements.
	private JPanel main = new JPanel();
	private JPanel labelField = new JPanel();
	private JLabel codeLabel = new JLabel("Code");
	private JLabel nameLabel = new JLabel("Name");
	private JLabel priceLabel = new JLabel("Price");
	private JTextField codeField = new JTextField();
	private JTextField nameField = new JTextField();
	private JTextField priceField = new JTextField();
	private JButton input = new JButton("Input");

	/**
	 * Constructor.
	 */
	public InputProduct() {

		// Adding action listener to the button.
		input.addActionListener(this);

		// Setting the appearance of the labels and the textfields and adding
		// them on the panel.
		codeLabel.setPreferredSize(new Dimension(100, 25));
		codeField.setPreferredSize(new Dimension(200, 25));
		nameLabel.setPreferredSize(new Dimension(100, 25));
		nameField.setPreferredSize(new Dimension(200, 25));
		priceLabel.setPreferredSize(new Dimension(100, 25));
		priceField.setPreferredSize(new Dimension(200, 25));
		labelField.add(codeLabel);
		labelField.add(codeField);
		labelField.add(nameLabel);
		labelField.add(nameField);
		labelField.add(priceLabel);
		labelField.add(priceField);
		labelField.setBorder(BorderFactory.createTitledBorder("New Product"));

		// Adding the panel with elements on main panel.
		main.setLayout(new BorderLayout());
		main.add(labelField, BorderLayout.CENTER);

		// Adding the button on the main panel.
		input.setPreferredSize(new Dimension(100, 50));
		main.add(input, BorderLayout.SOUTH);

		// Adding the main panel on the frame.
		add(main);

		// Setting the appearance of the frame.
		setSize(400, 230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Input Product");
		setVisible(true);
	}

	/**
	 * Inputs the new product into database.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			try {
				// Calling method insertProduct() from SQLConnection and
				// forwarding the values from the text fields as
				// the parameters.
				SQLConnection.insertProduct(codeField.getText(), nameField.getText(), Double.parseDouble(priceField.getText()));
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please insert correct price format.");
				return;
			}
			// If the product is successfully inputed clearing text from the
			// text fields.
			if (SQLConnection.isInputed) {
				clearArea();
			}
		}
	}

	/**
	 * Clears the text from the text fields.
	 */
	public void clearArea() {
		codeField.setText("");
		nameField.setText("");
		priceField.setText("");
	}

	public static void main(String[] args) {
		// Connecting to the database.
		SQLConnection.connectToDB();
		// Calling constructor.
		new InputProduct();
	}
}

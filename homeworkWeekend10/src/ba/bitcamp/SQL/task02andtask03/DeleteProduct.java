package ba.bitcamp.SQL.task02andtask03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Represents GUI application that has one JFrame in which user can select
 * products and delete them. The products are contained in the combo box.
 * 
 * @author Gordan
 *
 */
public class DeleteProduct extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7438362877535308598L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private ArrayList<Product> products = SQLConnection.selectProducts();
	private DefaultComboBoxModel model = new DefaultComboBoxModel(products.toArray());
	private JComboBox<Product> box = new JComboBox<>();
	private JButton delete = new JButton("Delete");

	/**
	 * Constructor.
	 */
	public DeleteProduct() {

		// Setting the products from the database on the combo box and
		// appearance of the combo box.
		box.setModel(model);
		box.setSelectedIndex(0);
		box.setPreferredSize(new Dimension(250, 30));

		// Adding the action listener on the button and setting the appearance
		// of the button.
		delete.addActionListener(this);
		delete.setPreferredSize(new Dimension(300, 50));

		// Adding the combo box on the panel.
		panel.setBorder(BorderFactory.createTitledBorder("Delete Product"));
		panel.add(box);

		// Setting the layout of the frame and adding the panel and the button
		// on the frame.
		setLayout(new BorderLayout());
		add(delete, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);

		// Setting the appearance of the frame.
		setSize(300, 175);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Delete Product");
		setVisible(true);
	}

	/**
	 * Deletes the selected product from the database.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delete) {
			// Calling method deleteProduct from SQLConnection class and
			// forwarding the selected product as the
			// parameter.
			SQLConnection.deleteProduct((Product) box.getSelectedItem());
			// Updating the list of the products.
			products = SQLConnection.selectProducts();
			// Setting the list of the products on the combo box.
			box.setModel(new DefaultComboBoxModel(products.toArray()));
		}
	}

	public static void main(String[] args) {
		// Connecting to the database.
		SQLConnection.connectToDB();
		// Calling constructor.
		new DeleteProduct();
	}
}

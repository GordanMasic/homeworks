package ba.bitcamp.SQL.task01;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Represents GUI application that has one JFrame where owner can view
 * complaints of the guests.
 * 
 * @author Gordan
 *
 */
public class ViewComplain extends JFrame {

	private static final long serialVersionUID = 8626229069394564876L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private JEditorPane area = new JEditorPane();
	private JScrollPane scroll = new JScrollPane(area);

	/**
	 * Constructor.
	 */
	public ViewComplain() {

		// Adding focus listener to the text area.
		area.addFocusListener(new WriteComplaints());

		// Setting the panel and adding elements on the panel.
		panel.setLayout(new BorderLayout());
		scroll.setBorder(BorderFactory.createTitledBorder("Complaints"));
		area.setEditable(false);
		panel.add(scroll, BorderLayout.CENTER);

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
	 * Represents the class that extends FocusAdapter class and that enables
	 * focus on the area when the application is started. When the focus is
	 * gained it writes all from database on the text area.
	 * 
	 * @author Gordan
	 *
	 */
	private class WriteComplaints extends FocusAdapter {

		/**
		 * Gains the focus on the text area and writes all from database on the
		 * text area.
		 */
		public void focusGained(FocusEvent arg0) {
			area.setText(SQLConnection.selectComplaints());
		}
	}

	public static void main(String[] args) {
		// Connecting to the database.
		SQLConnection.connectToDB();
		// Calling constructor.
		new ViewComplain();
	}
}

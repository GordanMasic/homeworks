package ba.bitcamp.Files;

import javax.swing.JFrame;

/**
 * @author Gordan.Masic
 *
 * Making TextEditor window with options to open,save and create new txt file
 */
public class TextEditor extends JFrame {

	private static final long serialVersionUID = 2379373691303860516L;

	//Creating private object from class MyPanel
	private MyPanel panel = new MyPanel();
	
	/**
	 * Constructor for creating TextEditor object. TextEditor object extends JFrame and
	 * represents main window used for creating and editing text files
	 */
	public TextEditor() {
		
		//Adding panel to the window
		add(panel);
		
		//Window's standard default settings
		setTitle("My TextEditor");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextEditor();
	}
}

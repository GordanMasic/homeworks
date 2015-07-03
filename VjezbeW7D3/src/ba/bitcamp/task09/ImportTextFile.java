package ba.bitcamp.task09;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ImportTextFile extends JFrame {

	private static final long serialVersionUID = 6593323572099469297L;

	//Declaring variables
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Open file: ");
	private JTextField fileName = new JTextField(40);
	private JTextArea textArea = new JTextArea();

	public ImportTextFile() {

		
		
		//Setting text field line wrap
		textArea.setLineWrap(true);

		//Adding label and text field to panel
		panel.add(label);
		panel.add(fileName);

		//Adding KeyListener to text field
		fileName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				String str = "";
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					TextIO.readFile(fileName.getText());
					while (!TextIO.eof()) {
						str += TextIO.getln() + "\n";
					}
					textArea.setText(str);
					repaint();
				}
			}
		});
		
		//Window settings
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Text from File");
		setVisible(true);
	}

	public static void main(String[] args) {
		new ImportTextFile();

	}

}

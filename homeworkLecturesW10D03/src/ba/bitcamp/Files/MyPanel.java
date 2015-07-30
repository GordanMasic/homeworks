package ba.bitcamp.Files;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Gordan
 *
 *         Making MyPanel that has next specifications: JTextArea used for
 *         writing some text JMenuBar that contains JManu with tree JMenuItems:
 *         New,Open and Save As JScrollPane with horizontal and vertical
 *         scrollbars
 *
 *         Every JMenuItem has a specific ActionListener: New creates new empty
 *         text area Open is used to open choosed text file Save As is used to
 *         save text file at choosed location and under choosed name
 */
public class MyPanel extends JPanel {

	private static final long serialVersionUID = -3466550005830151593L;

	// Creating private objects used for developing MyPanel object

	// Creating text area
	private JTextArea textArea = new JTextArea();

	// Creating menu
	private JMenu menu = new JMenu("File");

	// Creating menu bar
	private JMenuBar menuBar = new JMenuBar();

	// Creating menu items
	private JMenuItem newFile = new JMenuItem("New...");
	private JMenuItem open = new JMenuItem("Open...");
	private JMenuItem save = new JMenuItem("Save As");

	// Creating scroll pane
	private JScrollPane scrollPane = new JScrollPane(textArea,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	/**
	 * Constructor for creating MyPanel object with text area, menu bar and
	 * scroll pane
	 */
	public MyPanel() {

		// Seting panel's layout
		setLayout(new BorderLayout());

		// Adding menu bar to the north of panel
		add(menuBar, BorderLayout.NORTH);

		// Adding menu to the menu bar
		menuBar.add(menu);

		// Adding menu items to the menu
		menu.add(newFile);
		menu.add(open);
		menu.add(save);

		// Making text area
		textArea.setLineWrap(true);

		// Adding scroll pane to the center of the panel
		add(scrollPane, BorderLayout.CENTER);

		/*
		 * ActionListener for creating empty text file
		 */
		newFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		/*
		 * ActionListener for opening existing text file
		 */
		open.addActionListener(new ActionListener() {

			private BufferedReader br;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				JFileChooser openFile = new JFileChooser();
				int action = openFile.showOpenDialog(open);
				if (action == JFileChooser.OPEN_DIALOG) {
					File file = openFile.getSelectedFile();
					try {
						FileReader fr = new FileReader(file);
						br = new BufferedReader(fr);
						String line = br.readLine();
						String text = line + "\n";
						while (line != null) {
							line = br.readLine();
							text += line + "\n";
						}
						textArea.setText(text);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		/*
		 * ActionListener for saving text file
		 */
		save.addActionListener(new ActionListener() {

			private BufferedWriter bwr;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				JFileChooser saveFile = new JFileChooser();
				FileNameExtensionFilter ext = new FileNameExtensionFilter(
						".txt File", "txt");
				saveFile.setFileFilter(ext);
				int action = saveFile.showSaveDialog(save);

				if (action == JFileChooser.APPROVE_OPTION) {
					String text = textArea.getText();
					text = text.replaceAll("(?!\\r)\\n", "\r\n");
					try {
						bwr = new BufferedWriter(
								new FileWriter(new File(saveFile
										.getCurrentDirectory(), saveFile
										.getSelectedFile().getName()
										+ ext.getDescription().substring(0, 5))));
						bwr.write(text);
						bwr.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

}

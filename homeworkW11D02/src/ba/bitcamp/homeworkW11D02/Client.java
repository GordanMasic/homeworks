package ba.bitcamp.homeworkW11D02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Gordan
 *
 *         This class represents chat client. Client contains one JFrame window
 *         with tree panels on it. Upper panel contains JTextArea where chat
 *         between client and server is shown, lower panel contains JTextField
 *         where client user writes his messages and main panel contains upper
 *         and lower panels. There is also one JScrollPane on the text area.
 */
public class Client extends JFrame {

	private static final long serialVersionUID = -9064374516802806515L;
	// Window components
	private JPanel mainPanel = new JPanel();
	private JPanel downPanel = new JPanel();
	private JPanel upPanel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JTextField textField = new JTextField();
	private JScrollPane scrollPane = new JScrollPane(textArea,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	// Regular socket
	private Socket client;

	// List of directories
	private ArrayList<String> listOfDirectories;

	/**
	 * Constructor for creating Client chat
	 */
	public Client() {

		/*
		 * If client (user) types ENTER key on the keyboard and if the text
		 * field is not empty, written message will be sent to a server
		 */
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& !textField.getText().equals("")) {
					try {

						BufferedWriter writer = new BufferedWriter(
								new OutputStreamWriter(client.getOutputStream()));
						writer.write("Client: " + textField.getText());
						writer.newLine();
						writer.flush();
						textArea.append("Client: " + textField.getText() + "\n");
						textArea.setCaretPosition(textArea.getDocument()
								.getLength());
						textField.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		/*
		 * Configuring and adding components to lower panel
		 */
		downPanel.setBorder(BorderFactory.createTitledBorder("Write Message"));
		downPanel.setLayout(new BorderLayout());
		downPanel.add(textField, BorderLayout.CENTER);

		/*
		 * Configuring and adding components to upper panel
		 */
		upPanel.setBorder(BorderFactory.createTitledBorder("Chat room"));
		upPanel.setLayout(new BorderLayout());
		upPanel.add(scrollPane, BorderLayout.CENTER);

		/*
		 * Configuring text area
		 */
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setForeground(Color.RED);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Serif", Font.BOLD, 15));

		/*
		 * Configuring and adding components to main panel
		 */
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(upPanel, BorderLayout.CENTER);
		mainPanel.add(downPanel, BorderLayout.SOUTH);

		// Adding main panel to the window
		add(mainPanel);

		/*
		 * Configuring window
		 */
		setTitle("Client chat");
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		/*
		 * Starting client
		 */
		try {
			client = new Socket("localhost", 6699);

			/*
			 * Reading messages from server
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			boolean end = false;
			while (!end) {
				String readText = "";
				String line = reader.readLine();

				/*
				 * If message starts with "/list" followed with file path, it is
				 * command to find all subdirectories in certain directory on
				 * client's PC and put them in to a list. After that list shows
				 * in both server's and client's chat room.
				 */
				if (line.indexOf("/list") != -1) {
					listOfDirectories = new ArrayList<String>();
					File currentDirectory = new File(line.substring(
							line.indexOf("/list") + 6, line.length()));
					if (currentDirectory.isDirectory()) {
						File[] files = currentDirectory.listFiles();
						for (File file : files) {
							if (file.isDirectory()) {
								listOfDirectories.add(file.getName());
							}
						}
					}
					textArea.append("Client: " + listOfDirectories.toString()
							+ "\n");
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
					writer.write("Client: " + listOfDirectories.toString()
							+ "\n");
					writer.flush();

					/*
					 * If message from server starts with "/web" followed with
					 * web link, it is a command to open certain web page in
					 * local browser on client's PC
					 */
				} else if (line.indexOf("/web") != -1) {
					Desktop.getDesktop().browse(
							new URI(line.substring(line.indexOf("/web") + 5,
									line.length())));

					/*
					 * If message from server starts with "/delete" followed
					 * with file path, it is a command to delete certain file
					 * from client's PC
					 */
				} else if (line.indexOf("/delete") != -1) {
					File file = new File(line.substring(
							line.indexOf("/delete") + 8, line.length()));
					file.delete();

					/*
					 * If message from server starts with "/open" followed with
					 * file path, it is a command to open certain file from
					 * client's PC
					 */
				} else if (line.indexOf("/open") != -1) {
					Desktop.getDesktop().open(
							new File(line.substring(line.indexOf("/open") + 6,
									line.length())));
				} else {
					readText += line;
					textArea.append(readText + "\n");
				}
			}
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new Client();
	}
}

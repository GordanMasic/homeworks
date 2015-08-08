package ba.bitcamp.homeworkW12D03.task02;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Gordan
 * 
 *         Represents main panel that contains image in positive form and
 *         button. By clicking on the button image is changed in negative form.
 *         And by clicking again image is returned to the positive form.
 */
public class PicChangerGUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = -1592269176478889092L;

	// Declaring main elements.
	private JPanel panel = new MyPanel();
	private JButton button = new JButton("Negative image");

	// Declaring list of tasks and list of consumers.
	private LinkedBlockingQueue<Producer> tasks = new LinkedBlockingQueue<>();
	private ArrayList<Consumer> consumers = new ArrayList<>();

	// Declaring variable that will read image.
	private BufferedImage image;

	public PicChangerGUI() {

		// Setting the look of panel according to system look.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}
		// Reading image.
		try {
			image = ImageIO.read(new File("picture.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Adding action listener to the button and setting the font of the
		// button text.
		button.addActionListener(this);
		button.setFont(new Font("Serif", Font.BOLD, 20));

		// Setting the layout of the main panel and adding elements.
		setLayout(new BorderLayout());
		add(panel);
		add(button, BorderLayout.SOUTH);
	}

	/**
	 * Divides the tasks into parts and starts consumers.
	 */
	public void actionPerformed(ActionEvent e) {
		// Allocating one row of pixels to one producer and adding producer to
		// the list.
		for (int i = 0; i < image.getHeight(); i++) {
			Producer p = new Producer(image.getWidth(), i);
			tasks.add(p);
		}
		// Creating, starting and adding consumers to the list.
		for (int i = 0; i < 4; i++) {
			Consumer con = new Consumer();
			con.start();
			consumers.add(con);
		}
		// Changing the text of the button depending on the state of the image.
		if (button.getText().equals("Negative image")) {
			button.setText("Positive image");
		} else {
			button.setText("Negative image");
		}
	}

	/**
	 * Returns the imported image.
	 * 
	 * @return Image that is imported.
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * 
	 * @author Gordan
	 *
	 *         Inner class represents JPanel that draws imported image.
	 */
	private class MyPanel extends JPanel {

		private static final long serialVersionUID = 3873896819533186187L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
			repaint();
		}
	}

	/**
	 * 
	 * @author Gordan
	 * 
	 *         Inner class that represents task that is need to be executed.
	 *
	 */
	private class Producer implements Runnable {

		// Properties of the producer.
		private int row;
		private int column;

		/**
		 * Constructor that creates new producer.
		 * 
		 * @param row
		 *            - Number of rows.
		 * @param column
		 *            - Number of columns.
		 */
		public Producer(int row, int column) {
			this.row = row;
			this.column = column;
		}

		/**
		 * Subtracts all pixels in row for 255.
		 */
		public void run() {
			for (int i = 0; i < row; i++) {
				image.setRGB(i, column, 255 - image.getRGB(i, column));
			}
		}
	}

	/**
	 * 
	 * @author Gordan
	 *
	 *         Inner class that represents thread that will execute tasks.
	 */
	private class Consumer extends Thread {

		/**
		 * While there is tasks on task list thread needs to be alive and to
		 * execute tasks.
		 */
		public void run() {
			while (!tasks.isEmpty()) {
				try {
					Producer job = tasks.take();
					job.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
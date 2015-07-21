package ba.bitcamp.task01;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AdjustableFont extends JFrame {

	private static final long serialVersionUID = 4524260100516624973L;

	// Declaring variables
	private int font = 10;

	public AdjustableFont(int width, int height) {

		// Creating new panel
		JPanel container = new MyPanel(width, height);
		add(container);

		// Window default settings
		setTitle("Font adjusting");
		setResizable(false);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Inner class for custom panels
	private class MyPanel extends JPanel {

		private static final long serialVersionUID = -5513719733259752110L;

		// Declaring variables
		private JLabel text = new JLabel("Font size example");

		/**
		 * Constructor for creating custom panels
		 * 
		 * @param width
		 *            width value
		 * @param height
		 *            height value
		 */
		public MyPanel(int width, int height) {

			// Label settings
			text.setHorizontalAlignment(JLabel.CENTER);
			text.setPreferredSize(new Dimension(width, height / 2));
			text.setFont(new Font("Serif", Font.BOLD, font));
			add(text);

			// Creating slider
			int sliderHeight = height / 2;
			Dimension sliderDimension = new Dimension(width, sliderHeight);
			JSlider fontSize = new JSlider(10, 35);
			initSlider(fontSize, sliderDimension);
			add(fontSize);
		}

		/**
		 * Method for defining slider settings
		 * 
		 * @param s
		 *            slider
		 * @param d
		 *            dimensions of slider
		 */
		public void initSlider(JSlider s, Dimension d) {
			s.setValue(0);
			s.setSize(d);
			s.setPaintTicks(true);
			s.setMajorTickSpacing(5);
			s.setPaintLabels(true);
			s.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					font = s.getValue();
					text.setFont(new Font("Serif", Font.BOLD, font));
				}
			});

		}
	}

	public static void main(String[] args) {
		new AdjustableFont(300, 300);
	}
}

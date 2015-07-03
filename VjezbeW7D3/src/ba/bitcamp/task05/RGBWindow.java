package ba.bitcamp.task05;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGBWindow extends JFrame {

	private static final long serialVersionUID = 3390524776447019837L;

	// Declaring variables
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JLabel redLabel = new JLabel("Red");
	private JLabel greenLabel = new JLabel("Green");
	private JLabel blueLabel = new JLabel("Blue");

	JSlider redSlider;
	JSlider greenSlider;
	JSlider blueSlider;

	private int red;
	private int green;
	private int blue;

	public RGBWindow() {

		/*
		 * Panel settings
		 */
		panel.setLayout(new GridLayout(1, 2));

		/*
		 * Panel1 settings
		 */
		panel1.setLayout(new GridLayout(3, 2));

		/*
		 * Label settings
		 */
		redLabel.setHorizontalAlignment(JLabel.CENTER);
		greenLabel.setHorizontalAlignment(JLabel.CENTER);
		blueLabel.setHorizontalAlignment(JLabel.CENTER);

		// Creating sliders
		redSlider = new JSlider(0, 255, red);
		initSlider(redSlider, "Red");
		greenSlider = new JSlider(0, 255, green);
		initSlider(greenSlider, "Green");
		blueSlider = new JSlider(0, 255, blue);
		initSlider(blueSlider, "Blue");

		/*
		 * Panel2
		 */
		panel2.setBackground(new Color(red, green, blue));

		// Adding components to Panel 1
		panel1.add(redLabel);
		panel1.add(redSlider);

		panel1.add(greenLabel);
		panel1.add(greenSlider);

		panel1.add(blueLabel);
		panel1.add(blueSlider);

		// Adding components to panel
		panel.add(panel1);
		panel.add(panel2);

		// Adding panel to window
		add(panel);

		// Window settings
		setTitle("RGB Window");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	/**
	 * Method for initializing slider
	 * 
	 * @param slider
	 *            slider
	 * @param name
	 *            name of slider
	 */
	private void initSlider(JSlider slider, String name) {
		slider.setName(name);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();

				switch (name) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updatePanel2();
			}
		});
	}

	/**
	 * Method for updating Panel 2
	 */
	private void updatePanel2() {
		panel2.setBackground(new Color(red, green, blue));
	}

	public static void main(String[] args) {

		new RGBWindow();
	}

}

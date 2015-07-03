package ba.bitcamp.task07;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CircleDrawer extends JFrame {

	private static final long serialVersionUID = 7599656446076786632L;

	// Declaring variables
	private int size = 0;
	private JPanel panel = new MyPanel();
	private int coordX;
	private int coordY;
	private JSlider slider = new JSlider(0, 100, size);

	public CircleDrawer() {

		// Ading MouseListener to Panel
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				coordX = e.getX();
				coordY = e.getY();
			}
		});

		// Adding slider to Panel
		panel.add(slider);

		// Adding ChangeListener to slider
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				size = slider.getValue();

			}
		});

		// Adding Panel to window
		add(panel);

		// Window settings
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Circle Drawer");
		setVisible(true);
	}

	public static void main(String[] args) {
		new CircleDrawer();
	}

	/**
	 * 
	 * Private inner class for creating custom panels
	 *
	 */
	private class MyPanel extends JPanel {

		private static final long serialVersionUID = 9085362739042066760L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawOval(coordX - size / 2, coordY - size / 2, size, size);
			repaint();
		}
	}

}
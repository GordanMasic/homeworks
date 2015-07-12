package ba.bitcamp.homeworkLecturesW08D01.task06;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int x = 100;
	private static int y = 100;
	private JPanel panel = new MyPanel();

	public Window6() {
		add(panel);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y >= 5) {
						y -= 5;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y <= 515) {
						y += 5;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x >= 5) {
						x -= 5;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x <= 740) {
						x += 5;
					}
				}
				panel.repaint();
			}
		});

		setTitle("Moving circle");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private class MyPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.fillOval(x, y, 50, 50);

		}
	}

	public static void main(String[] args) {
		new Window6();

	}

}

package ba.bitcamp.homeworkLecturesW08D01.task01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel {

	private static final long serialVersionUID = 837342773230097434L;


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillOval(Window.x, Window.y, 50, 50);

	}

}

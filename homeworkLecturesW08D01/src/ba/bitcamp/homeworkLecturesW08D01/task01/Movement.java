package ba.bitcamp.homeworkLecturesW08D01.task01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (Window.y >= 5) {
				Window.y -= 5;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (Window.y <= 515) {
				Window.y += 5;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Window.x >= 5) {
				Window.x -= 5;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (Window.x <= 740) {
				Window.x += 5;
			}
		}
		Window.panel.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}

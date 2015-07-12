package ba.bitcamp.homeworkLecturesW08D01.task01;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 7944904853494243568L;

	static int x = 100;
	static int y = 100;
	static JPanel panel = new Circle();
	public Window() {

		add(panel);
		addKeyListener(new Movement());
		

		setTitle("Moving circle");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Window();

	}

}

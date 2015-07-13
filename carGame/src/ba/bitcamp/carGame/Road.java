package ba.bitcamp.carGame;

import java.awt.Color;
import java.awt.Graphics;

public class Road implements AnimatedGameArtifact {
	private int left;
	private int middle;
	private int right;
	private int speed;
	private int height;

	public static int ROAD_SIDE = 100;
	public static int LINE_WIDTH = 10;

	private int lineHeight = 50;
	private int lineSpace = 20;
	private int totalLineHeight = lineHeight + lineSpace;

	private int start;

	public Road(int width, int height, int speed) {
		this.height = height;
		this.speed = speed;
		this.left = ROAD_SIDE - LINE_WIDTH;
		this.right = width - ROAD_SIDE;
		this.middle = (right+left)/2;
	}

	@Override
	public void animateFrame(long frameNumber) {
		start = (int) (frameNumber % totalLineHeight) * speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		drawLine(graphics, left);
		drawLine(graphics, middle);
		drawLine(graphics, middle-150);
		drawLine(graphics, middle+150);
		drawLine(graphics, right);
	}

	private void drawLine(Graphics graphics, int position) {
		int y = start - speed * totalLineHeight;
		while (y < height + totalLineHeight) {
			graphics.setColor(Color.WHITE);
			graphics.fillRect(position, y, LINE_WIDTH, lineHeight);
			y += 70;
			graphics.setColor(Color.GREEN);
			graphics.fillRect(0, 0,ROAD_SIDE-LINE_WIDTH-5 , 1000);
			graphics.fillRect(right+LINE_WIDTH+5, 0,100 , 1000);
		}

	}
}

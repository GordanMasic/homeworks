package ba.bitcamp.carGame;

import java.awt.Color;
import java.awt.Graphics;

public class Vehicle implements GameArtifact {
	public static int WIDTH = 40;
	public static int HEIGHT = 60;

	public static int WIDTH_HALF = WIDTH / 2;
	public static int HEIGHT_HALF = HEIGHT / 2;

	protected int x;
	protected int y;

	private int crashFrame;

	public Vehicle(int x, int y) {
		setPosition(x, y);
	}

	public void setPosition(int x, int y) {
		this.x = x - WIDTH_HALF;
		this.y = y - HEIGHT_HALF;
	}

	public void setX(int x) {
		this.x = x - WIDTH_HALF;
	}

	@Override
	public void draw(Graphics graphics) {
		if (crashFrame > 0) {
			drawCar(graphics, Color.RED);
			crashFrame--;
		} else {
			drawCar(graphics, Color.BLUE);
		}

	}

	protected void drawCar(Graphics graphics, Color c) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x-5, y+5, WIDTH+10, 10);
		graphics.fillRect(x-5, y+50, WIDTH+10, 10);
		graphics.setColor(c);
		graphics.fillRect(x, y, WIDTH, HEIGHT);
	}

	public boolean colade(Vehicle v) {
		return Math.abs(x - v.x) < WIDTH && Math.abs(y - v.y) < HEIGHT;
	}
	
	public boolean oilColade(OilStain o){
		return Math.abs(x - o.x) < WIDTH && Math.abs(y - o.y) < HEIGHT;
	}

	public void crash() {
		crashFrame = 20;
	}

	public boolean isCrashed() {
		return crashFrame > 0;
	}
}
package ba.bitcamp.carGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OilStain extends Vehicle implements AnimatedGameArtifact {

	private int speed;
	private int roadHeight;
	private int minX;
	private int maxX;
	private BufferedImage img1;
	private int imageX;

	public OilStain(int minX, int maxX, int roadHeight, int speed) {
		super(0, 0);
		try {
			this.img1 = ImageIO.read(new File("src/oil_stain.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.minX = minX;
		this.maxX = maxX;
		this.roadHeight = roadHeight;
		this.imageX = (int) (Math.random() * 500 + 150);
		setSpeed(speed);
		resetPosition();
	}

	public void resetPosition() {
		setPosition((int) (minX + Math.random() * (maxX - minX)),
				(int) (-HEIGHT * Math.random() * 10));
	}

	public void setSpeed(int speed) {
		this.speed = speed / 2;
	}

	public void animateFrame(long frameNumber) {
		// move down or reset position if passed
		if (y < roadHeight) {
			y += speed;
		} else {
			resetPosition();
		}
	}

	@Override
	public void draw(Graphics graphics) {
		// draw car only if in visible area
		if (y > -HEIGHT && y < roadHeight + 100) {
			graphics.drawImage(img1, imageX, y, null, null);
		}
	}
}

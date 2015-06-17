package ba.bitcamp.homeworkClassesPractice.train;

public class Locomotive {

	private Rectangle platform;
	private Circle wheel;
	private Circle window;
	private Square cabin;
	private Rectangle chimney;
	private double surface = 0;
	private double perimeter = 0;

	/**
	 * Constructor for creating Locomotive objects
	 * 
	 * @param platform
	 * @param wheel
	 * @param cabin
	 * @param chimney
	 * @param window
	 */
	public Locomotive(Rectangle platform, Circle wheel, Square cabin,
			Rectangle chimney, Circle window) {
		this.platform = platform;
		this.wheel = wheel;
		this.cabin = cabin;
		this.chimney = chimney;
		this.window = window;
	}

	/**
	 * Returns locomotive's perimeter
	 * 
	 * @return perimeter
	 */
	public double getLokomotivePerimeter() {
		perimeter = 2 * wheel.getCirclePerimeter()
				+ platform.getRectanglePerimeter() + cabin.getSquarePerimeter()
				+ chimney.getRectanglePerimeter() + 2
				* window.getCirclePerimeter();

		return perimeter;
	}

	/**
	 * Returns locomotive's surface
	 * 
	 * @return surface
	 */
	public double getLokomotiveSurface() {
		surface = 2 * wheel.getCircleSurface() + platform.getRectangleSurface()
				+ cabin.getSquareAreaSurface() + chimney.getRectangleSurface()
				- 2 * window.getCircleSurface();

		return surface;
	}
}

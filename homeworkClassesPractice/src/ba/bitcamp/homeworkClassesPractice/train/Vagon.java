package ba.bitcamp.homeworkClassesPractice.train;

public class Vagon {

	private Circle wheel;
	private Rectangle platform;
	private double surface = 0;
	private double perimeter = 0;

	/**
	 * Constructor for creating Vagon objects
	 * 
	 * @param wheel
	 * @param platform
	 */
	public Vagon(Circle wheel, Rectangle platform) {
		this.wheel = wheel;
		this.platform = platform;
	}

	/**
	 * Returns vagon's surface
	 * 
	 * @return surface
	 */
	public double getVagonSurface() {
		surface = 2 * wheel.getCircleSurface() + platform.getRectangleSurface();
		return surface;
	}

	/**
	 * Returns vagon's perimeter
	 * 
	 * @return perimeter
	 */
	public double getVagonPerimeter() {
		perimeter = 2 * wheel.getCirclePerimeter()
				+ platform.getRectanglePerimeter();

		return perimeter;
	}
}

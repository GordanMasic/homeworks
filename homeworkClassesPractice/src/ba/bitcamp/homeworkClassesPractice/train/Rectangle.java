package ba.bitcamp.homeworkClassesPractice.train;
public class Rectangle {

	private double sideA;
	private double sideB;
	private double surface;
	private double perimeter;

	/**
	 * Constructor for creating Rectangle objects
	 * 
	 * @param sideA
	 * @param sideB
	 * 
	 * @throws IllegalArgumentException
	 */
	public Rectangle(double sideA, double sideB) {
		if (sideA <= 0 || sideB <= 0) {
			throw new IllegalArgumentException(
					"Side of rectangle must be positive and greater than zero");
		}
		this.sideA = sideA;
		this.sideB = sideB;
	}

	/**
	 * Returns rectangle's surface
	 * 
	 * @return surface
	 */
	public double getRectangleSurface() {
		surface = sideA * sideB;
		return surface;
	}

	/**
	 * Returns rectangle's perimeter
	 * 
	 * @return perimeter
	 */
	public double getRectanglePerimeter() {
		perimeter = 2 * sideA + 2 * sideB;
		return perimeter;
	}
}

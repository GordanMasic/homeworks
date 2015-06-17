package ba.bitcamp.homeworkClassesPractice.train;
public class Circle {

	private double radius;
	private double surface;
	private double perimeter;

	/**
	 * Constructor for creating Circle objects
	 * 
	 * @param radius
	 *            circle radius
	 * 
	 * @throws IllegalArgumentException
	 */
	public Circle(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException(
					"Radius can't be negative or equal to zero!");
		}
		this.radius = radius;
	}

	/**
	 * Returns circle's surface
	 * 
	 * @return surface
	 */
	public double getCircleSurface() {
		surface = radius * radius * Math.PI;
		return surface;
	}

	/**
	 * Returns circle's perimeter
	 * 
	 * @return perimeter
	 */
	public double getCirclePerimeter() {
		perimeter = 2 * radius * Math.PI;
		return perimeter;
	}
}

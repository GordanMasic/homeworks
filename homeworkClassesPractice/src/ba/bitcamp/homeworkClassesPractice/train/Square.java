package ba.bitcamp.homeworkClassesPractice.train;
public class Square {

	private double sideA;
	private double surface;
	private double perimeter;

	/**
	 * Constructor for creating Square objects
	 * 
	 * @param sideA
	 * 
	 * @throws IllegalArgumentException
	 */
	public Square(double sideA) {
		if (sideA <= 0) {
			throw new IllegalArgumentException(
					"Side of square can't be negative or equal to zero!");
		}
		this.sideA = sideA;
	}

	/**
	 * Returns square's surface
	 * 
	 * @return surface
	 */
	public double getSquareAreaSurface() {
		surface = sideA * sideA;
		return surface;
	}

	/**
	 * Returns square's perimeter
	 * 
	 * @return perimeter
	 */
	public double getSquarePerimeter() {
		perimeter = 4 * sideA;
		return perimeter;
	}
}

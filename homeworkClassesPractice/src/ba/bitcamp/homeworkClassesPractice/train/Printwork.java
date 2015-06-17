package ba.bitcamp.homeworkClassesPractice.train;


public class Printwork {

	public static void main(String[] args) {

		// Defining how much paint we use for painting one meter
		double paintPerMeter = 0.01;

		// Defining how much paint we use for painting one meter
		double paintPerSquareMeter = 0.15;

		// Creating wheel
		Circle wheel = new Circle(1.5);

		// Creating window
		Circle window = new Circle(0.5);

		// Creating platform
		Rectangle platform = new Rectangle(10, 4);

		// Creating chimney
		Rectangle chimney = new Rectangle(0.5, 1);

		// Creating cabin
		Square cabin = new Square(4);

		// Creating locomotive
		Locomotive l1 = new Locomotive(platform, wheel, cabin, chimney, window);

		// Creating vagons
		Vagon v1 = new Vagon(wheel, platform);
		Vagon v2 = new Vagon(wheel, platform);

		// Creating composition of vagons
		Vagon[] nVagons = new Vagon[2];
		nVagons[0] = v1;
		nVagons[1] = v2;

		// Creating train
		Train express = new Train(l1, nVagons);

		// Calculating train's surface and perimeter
		double surface = express.getTrainSurface();
		double perimeter = express.getTrainPerimeter();

		// Calling methods to calculate how much paint we need for our train
		System.out
				.printf("We need %.2f liters of paint to paint surface of train\n and %.2f liters to paint border lines.",
						howMuchPaintForTrainSurface(surface,
								paintPerSquareMeter),
						howMuchPaintForLines(perimeter, paintPerMeter));
	}

	/**
	 * Returns how much paint we need per square meter to paint the train's
	 * surface
	 * 
	 * @param surface
	 * @param paintPerSquareMeter
	 * @return paint
	 */
	public static double howMuchPaintForTrainSurface(double surface,
			double paintPerSquareMeter) {
		double paint = surface * paintPerSquareMeter;
		return paint;
	}

	/**
	 * Returns how much paint we need per meter to print the train's perimeter
	 * 
	 * @param perimeter
	 * @param paintPerMeter
	 * @return paint
	 */
	public static double howMuchPaintForLines(double perimeter,
			double paintPerMeter) {
		double paint = perimeter * paintPerMeter;
		return paint;
	}

}

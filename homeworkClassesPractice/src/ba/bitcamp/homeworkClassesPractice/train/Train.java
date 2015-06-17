package ba.bitcamp.homeworkClassesPractice.train;


public class Train {

	private Locomotive locomotive;
	private Vagon[] vagons;
	private double surface;
	private double perimeter;

	/**
	 * Constructor for creating Train object
	 * 
	 * @param locomotive
	 * @param vagons
	 * @param surface
	 * @param perimeter
	 */
	public Train(Locomotive locomotive, Vagon[] vagons) {
		super();
		this.locomotive = locomotive;
		this.vagons = vagons;
	}

	/**
	 * Returns train's surface
	 * 
	 * @return surface
	 */
	public double getTrainSurface() {
		surface = locomotive.getLokomotiveSurface();
		for (int i = 0; i < vagons.length; i++) {
			surface += vagons[i].getVagonSurface();

		}

		return surface;

	}

	/**
	 * Returns train's perimeter
	 * 
	 * @return perimeter
	 */
	public double getTrainPerimeter() {
		perimeter = locomotive.getLokomotivePerimeter();
		for (int i = 0; i < vagons.length; i++) {
			perimeter += vagons[i].getVagonPerimeter();
		}

		return perimeter;
	}
}

package ba.bitcamp.homeworkLectures2.task06;

public class Cat extends Pet {

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param age
	 * @param species
	 */
	public Cat(String name, int age, String species) {
		super(name, age, species);
	}

	/**
	 * Prints go away human.
	 */
	public String toString() {
		return "Go away human";
	}

}

package ba.bitcamp.homeworkLectures2.task06;

public class Pet {

	/*
	 * Declaring properties of pet
	 */
	private String name;
	private int age;
	private String species;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of a pet.
	 * @param age
	 *            - Age of a pet.
	 * @param species
	 *            - Species of a pet.
	 */
	public Pet(String name, int age, String species) {
		super();
		this.name = name;
		this.age = age;
		this.species = species;
	}

	/**
	 * Prints information about pet.
	 */
	public String toString() {
		return String.format("Name: %s\nAge: %d\nSpecies: %s\n", name, age,
				species);
	}

	/**
	 * Checks if the two pets are equal.
	 * 
	 * @param p
	 *            - Pet with whom user compares first pet.
	 * @return True if pets are equal and false if not.
	 */
	public boolean equals(Pet p) {
		return this.name.equals(p.name) && this.age == p.age
				&& this.species.equals(p.species);
	}

	/*
	 * Get and set methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}

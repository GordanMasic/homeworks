package ba.bitcamp.homeworkWeekend5.task01;

public abstract class StoryElement {

	protected String name;

	/**
	 * Constructor for creating StoryElement object by inputing parameter name
	 * 
	 * @param name
	 *            name of story element
	 */
	public StoryElement(String name) {
		this.name = name;
	}

	/**
	 * Default constructor for creating StoryElement objects
	 */
	public StoryElement() {
		this("STElement");
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "Name: " + name + "\n";
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

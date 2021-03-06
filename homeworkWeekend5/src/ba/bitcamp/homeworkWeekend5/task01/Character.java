package ba.bitcamp.homeworkWeekend5.task01;

public class Character extends StoryElement {

	private String characterGender;
	private boolean isAlive;
	private boolean isFit;

	/**
	 * Constructor for creating Character objects by inputing parameters
	 * name,gender and is he fit.
	 * 
	 * @param name
	 *            name of character
	 * @param characterGender
	 *            character's gender
	 * @param isFit
	 *            is character fit
	 */
	public Character(String name, String characterGender, boolean isFit) {
		super(name);
		this.characterGender = characterGender;
		this.setAlive(true);
		this.setFit(isFit);
	}

	/**
	 * toString method
	 */
	public String toString() {
		return String.format("Name: %s\nGender: %s Alive? %s\nFit? %s\n", name,
				characterGender, isAlive(), isFit());
	}

	/**
	 * Method to kill character
	 */
	public void killCharacter() {
		setAlive(false);
	}
	
	/**
	 * Method to make character fit
	 */
	public void makeCharacterFit(){
		setFit(true);
	}

	//Getter and Setters
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isFit() {
		return isFit;
	}

	public void setFit(boolean isFit) {
		this.isFit = isFit;
	}
	
}

package ba.bitcamp.homeworkWeekend5.task03;

import ba.bitcamp.homeworkWeekend5.task01.Character;
import ba.bitcamp.homeworkWeekend5.task02.Goal;

public class Protagonist extends Character {

	private Goal goal;
	public Character[] friends = { null, null, null };
	public Character enemy;

	/**
	 * Constructor for creating main actor in story using parameters name,
	 * characterGender, isFit and goal
	 * 
	 * @param name
	 *            name of character
	 * @param characterGender
	 *            character's gender
	 * @param isFit
	 *            is character fit
	 * @param goal
	 *            character's goal
	 */
	public Protagonist(String name, String characterGender, boolean isFit,
			Goal goal) {
		super(name, characterGender, isFit);
		this.goal = goal;
	}

	// Setter
	public void setGoal(Goal g) {
		this.goal = g;
	}

	/**
	 * Creating main enemy
	 * 
	 * @param enemy
	 *            character
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	public static final int COUNTER = 3;

	int counter = -1;

	/**
	 * Method for adding allies of main character
	 * 
	 * @param c
	 *            ally character
	 */
	public void addFriend(Character c) {
		counter++;
		if (counter >= COUNTER) {
			throw new IndexOutOfBoundsException(
					"Main character has already enough allies!");
		}
		for (int i = counter; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = c;
				break;
			}
		}
	}

	/**
	 * Method that calculates chances for succeed of ma
	 */
	public void attainGoal() {
		// Set chances to 0
		int chances = 0;
		// Method will work if main character is alive
		if (this.isAlive() == true) {
			// If main character is fit chances for succeed increase for 40%
			if (this.isFit() == true) {
				chances += 40;
			}
			// For every ally that is fit chances for succeed increase for 20%
			for (int i = 0; i < friends.length; i++) {
				if (friends[i].isFit() == true) {
					chances += 20;
				}
			}
			// If enemy is fit chances for succeed decrease for 30%
			if (enemy.isFit() == false) {
				chances -= 30;
			}
			// If level of goal is hard chances for succeed decrease for 100%
			if (goal.getLevel() == Goal.HARD) {
				chances -= 100;
			}
			// If level of goal is normal chances for succeed decrease for 20%
			if (goal.getLevel() == Goal.NORMAL) {
				chances -= 20;
			}

			if (chances < 0) {
				chances = 0;
			}

			// If chances are 50% or higher main character will succeed
			if (chances >= 50) {
				System.out.println("He succeeded to defeat enemy in "
						+ goal.getName() + ".");
				for (int i = 0; i < friends.length; i++) {
					if (friends[i].isFit() == false) {
						friends[i].makeCharacterFit();
						break;
					}
				}
				// If chances are less than 50% hero won't succeed
			} else {
				System.out.println("He didn't succeed to defeat enemy in "
						+ goal.getName() + ".");
				friends[(int) (Math.random() * 2)].killCharacter();
				System.out.println(Math.random() * 2);
				for (int i = 0; i < friends.length; i++) {
					if (friends[i].isFit() == false) {
						if (friends[i].isAlive() == true) {
							friends[i].makeCharacterFit();
							break;
						}
					}
				}
			}
		}
	}

	// Getter
	public Character[] getFriends() {
		return friends;
	}
}

package ba.bitcamp.homeworkLectures2.task01;

import java.util.Arrays;

public class CampStringBuilder {

	/*
	 * Declaring properties
	 */
	private char[] characters;

	/**
	 * Constructor
	 * 
	 * @param characters
	 *            - An array of characters.
	 */
	public CampStringBuilder(char[] characters) {
		super();
		this.characters = characters;
	}

	/**
	 * Converts the inputed string into an array of characters and puts it on
	 * the end of CampStringBuilder array of characters.
	 * 
	 * @param o
	 *            - Inputed string.
	 */
	public void append(Object o) {

		// Creating an empty array that has number that is equal to sum of
		// elements number of CampStringBuilder array and the character number
		// of inputed string.
		char[] strChar = new char[characters.length + o.toString().length()];

		// Putting the elements into the empty array.
		for (int i = 0; i < strChar.length; i++) {
			// Putting from the beginning elements of CampStringBuilder array
			for (int j = 0; j < characters.length; j++) {
				if (i == j) {
					strChar[i] = characters[j];
				}
			}
			// Continuing putting the characters of the inputed string into the
			// empty array.
			for (int j = 0; j < o.toString().length(); j++) {
				if (i == j + characters.length) {
					strChar[i] = o.toString().charAt(j);
				}
			}
		}
		// Printing an array of characters
		System.out.println(Arrays.toString(strChar));
	}

	/**
	 * Converts the inputed string into an array of characters and puts it on
	 * the beginning of CampStringBuilder array of characters.
	 * 
	 * @param o
	 *            - Inputed string.
	 */
	public void prepend(Object o) {

		// Creating an empty array that has number that is equal to sum of
		// elements number of CampStringBuilder array and the character number
		// of inputed string.
		char[] strChar = new char[characters.length + o.toString().length()];

		// Putting the elements into the empty array.
		for (int i = 0; i < strChar.length; i++) {
			// Putting from the beginning the characters of the inputed string
			// into the empty array.
			for (int j = 0; j < o.toString().length(); j++) {
				if (i == j) {
					strChar[i] = o.toString().charAt(j);
				}
			}
			// Continuing putting elements of CampStringBuilder array
			for (int j = 0; j < characters.length; j++) {
				if (i == j + o.toString().length()) {
					strChar[i] = characters[j];
				}

			}
		}
		// Printing an array of characters
		System.out.println(Arrays.toString(strChar));
	}

	/**
	 * Converts an array of characters into the string of characters.
	 */
	public String toString() {

		String s = "";

		for (int i = 0; i < characters.length; i++) {
			s += characters[i];
		}

		return s;
	}
}


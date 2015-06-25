package ba.bitcamp.homeworkLectures2.task01;

public class Main {

	public static void main(String[] args) {

		// Declaring an array of characters
		char[] characters = { 'p', 'o', 'i', 'n', 't' };

		CampStringBuilder cp = new CampStringBuilder(characters);

		// Calling method append which puts an inputed string on the end of a
		// array.
		cp.append(" is equal to zero");

		// Calling method prepend which puts an inputed string on at the
		// beginning of a array.
		cp.prepend("number of ");

		// Printing an array of characters as a string
		System.out.println(characters);

	}

}

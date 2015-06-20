package ba.bitcamp.homeworkLectures2.task05;

public class Main {

	public static void main(String[] args) {

		// Creating date with only days inputed
		Date d = new Date(10);
		d.setDay(31);
		d.setMonth(3);
		// Printing date 10.01.01
		System.out.println(d);

		// Creating date with days and month inputed
		Date d1 = new Date(31, 6);

		// If user tries to input wrong date, prints message
		d1.setDay(31);

		// Printing date 25.06.01
		System.out.println(d1);

		// Creating date with all elements inputed
		Date d2 = new Date(30, 12, 1999);

		// Printing date 30.12.1999
		System.out.println(d2);

		// Adding two days
		d2.dayPassed();
		d2.dayPassed();

		// Printing date 01.01.2000
		System.out.println(d2);
	}

}

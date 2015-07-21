package homeworkLecturesW08D02;

public class Main {

	public static void main(String[] args) {

		DynamicDouble arrayDoubleOne = new DynamicDouble(5, 2.0);

		System.out.println(arrayDoubleOne.toString());

		arrayDoubleOne.addElement(5);
		System.out.println(arrayDoubleOne.toString());

		arrayDoubleOne.removeQuick(0);
		System.out.println(arrayDoubleOne.toString());

		arrayDoubleOne.removeQuick(0);
		System.out.println(arrayDoubleOne.toString());

		arrayDoubleOne.removeQuick(0);
		System.out.println(arrayDoubleOne.toString());

		arrayDoubleOne.removeQuick(0);
		System.out.println(arrayDoubleOne.toString());

		System.out.println();

		DynamicDouble arrayDoubleTwo = new DynamicDouble(5, 2.0);

		System.out.println(arrayDoubleTwo.toString());

		arrayDoubleTwo.addElement(5);
		System.out.println(arrayDoubleTwo.toString());

		arrayDoubleTwo.removeSlow(0);
		System.out.println(arrayDoubleTwo.toString());

		arrayDoubleTwo.removeSlow(0);
		System.out.println(arrayDoubleTwo.toString());

		arrayDoubleTwo.removeSlow(0);
		System.out.println(arrayDoubleTwo.toString());

		System.out.println();

		DynamicString arrayStringOne = new DynamicString(5, "Bit");

		System.out.println(arrayStringOne.toString());

		arrayStringOne.addElement("Camp");
		System.out.println(arrayStringOne.toString());

		arrayStringOne.removeQuick(0);
		System.out.println(arrayStringOne.toString());

		arrayStringOne.removeQuick(0);
		System.out.println(arrayStringOne.toString());

		arrayStringOne.removeQuick(0);
		System.out.println(arrayStringOne.toString());

		arrayStringOne.removeQuick(0);
		System.out.println(arrayStringOne.toString());

		System.out.println();

		DynamicString arrayStringTwo = new DynamicString(5, "Camp");

		System.out.println(arrayStringTwo.toString());

		arrayStringTwo.addElement("Bit");
		System.out.println(arrayStringTwo.toString());

		arrayStringTwo.removeSlow(0);
		System.out.println(arrayStringTwo.toString());

		arrayStringTwo.removeSlow(0);
		System.out.println(arrayStringTwo.toString());

		arrayStringTwo.removeSlow(0);
		System.out.println(arrayStringTwo.toString());

	}
}
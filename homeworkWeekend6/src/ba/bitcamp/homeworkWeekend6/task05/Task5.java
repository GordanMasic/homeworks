package ba.bitcamp.homeworkWeekend6.task05;

public class Task5 {

	/**
	 * Recursive method that calculates number exponent. Method works no matter
	 * if the number(exponent) is positive or negative.
	 * 
	 * @param number
	 *            number whose exponent method calculates
	 * @param exponent
	 *            exponent method searches for.
	 * @return value of number's exponent
	 */
	public static double getPower(double number, int exponent) {
		if (exponent > 0) {
			if (exponent == 1) {
				return number;
			}
			return number * getPower(number, exponent - 1);
		}
		if (exponent < 0) {
			if (exponent == -1) {
				return 1 / number;
			}
			return (1 / number * getPower(number, exponent + 1));
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {

		System.out.println(getPower(-3, -4));
	}

}

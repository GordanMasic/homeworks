package ba.bitcamp.homeworkLectures2.task05;

public class Date {

	/*
	 * Declaring properties of date
	 */
	private int day;
	private int month;
	private int year;

	/**
	 * Constructor that has one parameter and two default one.
	 * 
	 * @param day
	 */
	public Date(int day) {
		if (day < 1 || day > 31) {
			System.out.println("You have tried to input wrong date format!");
		} else {
			this.day = day;
		}
		this.month = 1;
		this.year = 1;
	}

	/**
	 * Constructor that has two parameters and one default.
	 * 
	 * @param day
	 * @param month
	 */
	public Date(int day, int month) {
		this(day);
		if (month < 1 || month > 12) {
			System.out.println("You have tried to input wrong date format!");
		} else {
			this.month = month;
		}
		this.year = 1;
	}

	/**
	 * Constructor that has three parameters.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		this(day, month);
		this.year = year;
	}

	/**
	 * Prints date in format day.month.year
	 */
	public String toString() {
		String s = "";
		if (day < 10) {
			s += "0" + day + ".";
		} else {
			s += day + ".";
		}
		if (month < 10) {
			s += "0" + month + ".";
		} else {
			s += month + ".";
		}
		if (year < 10) {
			s += "0" + year;
		} else {
			s += year;
		}
		return s;

	}

	/**
	 * Checks if two dates are same.
	 * 
	 * @param d
	 * @return True if they are equal and false if not.
	 */
	public boolean equal(Date d) {
		return this.day == d.day && this.month == d.month
				&& this.year == d.year;
	}

	/*
	 * Get and set methods
	 */
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Changes the day in the date.
	 * 
	 * @param day
	 *            - Day that user want to set.
	 */
	public void setDay(int day) {
		try {
			// Calling method daysOfMonth and checking if the inputed day is in
			// the right range.
			daysOfMonth(day, month);

			this.day = day;
		} catch (NumberFormatException e) {
			System.out.println("You have tried to input wrong date format!");
		}
	}

	/**
	 * Changes the month in the date.
	 * 
	 * @param month
	 *            - Month that user want to set.
	 */
	public void setMonth(int month) {
		// try {
		// Checking if the inputed month is in the right range
		if (month < 1 || month > 12) {
			throw new NumberFormatException();
		}

		// Calling method daysOfMonth and checking if the inputed month
		// corresponds to days in date.
		daysOfMonth(day, month);

		this.month = month;
		// } catch (NumberFormatException e) {
		// System.out.println("You have tried to input wrong date format!");
		// }
	}

	/**
	 * Calculates if the year is leap year.
	 * 
	 * @return True if the year is leap year and false if the year is not leap
	 *         year.
	 */
	public boolean isLeapYear() {
		return ((this.year % 4 == 0) && (this.year % 100 != 0))
				|| (this.year % 400 == 0);
	}

	/**
	 * Calculating which month has 31, which 30 and which 28/29 days.
	 * 
	 * @param day
	 *            - Days that are checked.
	 * @param month
	 *            - Month that is checked.
	 */
	public void daysOfMonth(int day, int month) {
		// These months have 31 days
		if (isThirtyOneDayMonth() && (day < 1 || day > 31)) {
			throw new NumberFormatException();
			// These months have 30 days
		} else if (isThirtyDayMonth() && (day < 1 || day > 30)) {
			throw new NumberFormatException();
			// These month has 28/29 days
		} else if (month == 2) {
			if (isLeapYear() && (day < 1 || day > 29)) {
				throw new NumberFormatException();
			} else if (!isLeapYear() && (day < 1 || day > 28)) {
				throw new NumberFormatException();
			}
		}
	}

	/**
	 * Increases a day in the date for one.
	 * <p>
	 * If the month has thirty days and the day is equal to thirty, or if the
	 * month has thirty one day and the day is equal to thirty one, it increases
	 * month for one and sets day to one.
	 * <p>
	 * If the month is equal to twelve and the day is equal to the thirty one,
	 * it increases the year for one and sets month and day to one.
	 * <p>
	 * If the year is leap year, the month is equal to two and the days are
	 * equal to twenty nine it increases a month for one and sets days to one.
	 * Otherwise if the year is not leap year, the month is equal to two and the
	 * days are equal to twenty eight it increases a month for one and sets days
	 * to one.
	 * <p>
	 */
	public void dayPassed() {

		if (day == 31 && month == 12) {
			day = 1;
			month = 1;
			year++;
		} else if (day == 31 && (isThirtyOneDayMonth())) {
			day = 1;
			month++;

		} else if (day == 30 && (isThirtyDayMonth())) {
			day = 1;
			month++;
		} else if (month == 2) {
			if (isLeapYear() && day == 29) {
				day = 1;
				month++;
			} else if (!isLeapYear() && day == 28) {
				day = 1;
				month++;
			} else {
				day++;
			}
		} else {
			day++;
		}

	}

	/**
	 * Increases a month in the date for one.
	 * <p>
	 * If the month is equal to 12 it increases year for one and sets month to
	 * 1.
	 */
	public void monthPassed() {
		if (month == 12) {
			month = 1;
			year++;
		} else {
			month++;
		}
	}

	/**
	 * Checking if the month has thirty days.
	 * 
	 * @return True if month has thirty days and false if not.
	 */
	public boolean isThirtyDayMonth() {
		return month == 4 || month == 6 || month == 9 || month == 11;
	}

	/**
	 * Checking if the month has thirty one day.
	 * 
	 * @return True if month has thirty one day and false if not.
	 */
	public boolean isThirtyOneDayMonth() {
		return month == 1 || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12;
	}
}

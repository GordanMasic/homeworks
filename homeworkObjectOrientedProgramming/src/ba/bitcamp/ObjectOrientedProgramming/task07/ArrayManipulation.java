package ba.bitcamp.ObjectOrientedProgramming.task07;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;

public class ArrayManipulation {

	/**
	 * Method that extends array for one element
	 * 
	 * @param computers
	 *            array of computers
	 * @return extended array
	 */
	public static Computer[] extendArray(Computer[] computers) {

		Computer[] array = new Computer[computers.length + 1];
		System.arraycopy(computers, 0, array, 0, computers.length);
		computers = array;
		return computers;
	}

	/**
	 * Method that removes one element from array at the inputed index
	 * 
	 * @param computers
	 *            array of computers
	 * @param index
	 *            index of element that has to be removed
	 * @return shrinked array
	 */
	public static Computer[] shrinkArray(Computer[] computers, int index) {
		if (index >= computers.length || index < 0) {
			throw new IndexOutOfBoundsException(
					"Index must be from zero to array length-1!");
		}
		Computer[] array = new Computer[computers.length - 1];
		for (int i = 0; i < index; i++) {
			array[i] = computers[i];
		}
		for (int i = index + 1; i < array.length; i++) {
			array[i] = computers[i];
		}

		return array;
	}
}
package ba.bitcamp.Stacks;

import java.util.Arrays;

public class StringArrayStack {

	private String[] array;

	/**
	 * Constructor
	 */
	public StringArrayStack() {
		this.array = new String[0];
	}

	/**
	 * Method for adding new element
	 * 
	 * @param s
	 *            element
	 * @return value of added element
	 */
	public String push(String s) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = s;
		return s;

	}

	/**
	 * Method for removing last added element
	 * 
	 * @return element value
	 */
	public String pop() {
		String s = array[array.length - 1];
		array = Arrays.copyOf(array, array.length - 1);
		return s;
	}

	/**
	 * Shows which element is next for removing from stack
	 * 
	 * @return element value
	 */
	public String peek() {
		return array[array.length - 1];
	}

	/**
	 * Shows element's index in order to remove
	 * 
	 * @param s
	 *            element
	 * @return index
	 */
	public int search(String s) {
		for (int i = 0; i < array.length; i++) {
			if (s.equals(array[i])) {
				return array.length - i;
			}
		}
		return -1;
	}

	/**
	 * Checks if stack is empty
	 * 
	 * @return true if queue is empty, else returns false
	 */
	public boolean isEmpty() {
		return array.length == 0;
	}

	/**
	 * toString method
	 */
	public String toString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) {

		StringArrayStack stack = new StringArrayStack();

		System.out.println(stack.isEmpty());
		double startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			stack.push("" + i);
		}
		double endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time: " + (endTime - startTime));
		System.out.println();
		System.out.println(stack.isEmpty());
		System.out.println(stack);

		System.out.println(stack.search("9"));
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack);

	}

}

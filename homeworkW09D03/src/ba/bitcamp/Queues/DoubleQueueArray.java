package ba.bitcamp.Queues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DoubleQueueArray {

	private Double[] array;

	/**
	 * Constructor
	 */
	public DoubleQueueArray() {
		this.array = new Double[0];
	}

	/**
	 * Method for adding new number
	 * 
	 * @param s
	 *            number
	 * @return true if number is added else false
	 */
	public boolean add(Double s) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = s;
		return true;

	}

	/**
	 * Method for removing first added number
	 * 
	 * @return number value
	 */
	public Double poll() {
		Double s = array[0];
		array = Arrays.copyOf(Arrays.copyOfRange(array, 1, array.length),
				array.length - 1);
		return s;
	}

	/**
	 * Shows which number is next for removing from queue
	 * 
	 * @return number value
	 */
	public Double peek() {
		return array[0];
	}

	/**
	 * Shows nuber's index in order to remove
	 * 
	 * @param s
	 * @return
	 */
	public int search(Double s) {
		for (int i = 0; i < array.length; i++) {
			if (s.compareTo(array[i]) == 0) {
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * Method for adding new number
	 * 
	 * @param s
	 *            number
	 * @return true if number is added else false
	 */
	public boolean offer(Double s) {
		try {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = s;
			return true;
		} catch (NullPointerException e1) {
			return false;
		} catch (ClassCastException e2) {
			return false;
		} catch (IllegalArgumentException e3) {
			return false;
		}
	}

	/**
	 * Method for removing first added number
	 * 
	 * @return number value
	 */
	public Double remove() {
		try {
			Double s = array[0];
			array = Arrays.copyOf(Arrays.copyOfRange(array, 1, array.length),
					array.length - 1);
			return s;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Shows which number is next for removing from queue
	 * 
	 * @return number value
	 */
	public Double element() {
		if (array == null) {
			throw new NoSuchElementException();
		} else {
			return array[0];
		}
	}

	/**
	 * Checks if queue is empty
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

		DoubleQueueArray que = new DoubleQueueArray();
		System.out.println(que.isEmpty());
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			que.add(i * 1.0);
		}
		long end = System.currentTimeMillis();
		System.out.println("" + (end - start));
		System.out.println(que.isEmpty());
		System.out.println(que);
		System.out.println(que.poll());
		System.out.println(que);
		System.out.println(que.search(19.0));
		System.out.println(que);

	}
}

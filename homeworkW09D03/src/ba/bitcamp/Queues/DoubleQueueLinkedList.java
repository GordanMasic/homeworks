package ba.bitcamp.Queues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class DoubleQueueLinkedList {

	private Node start;
	private Node last;

	/**
	 * Constructor
	 */
	public DoubleQueueLinkedList() {
		this.start = null;
		this.last = null;
	}

	/**
	 * Method for adding new number
	 * 
	 * @param s
	 *            number
	 * @return true if number is added else false
	 */
	public boolean add(Double s) {
		if (start == null && last == null) {
			start = last = new Node(s);
		} else {
			Node temp = new Node(s);
			temp.setPrevious(last);
			last.next = temp;
			last = temp;
		}
		return true;

	}

	/**
	 * Method for removing first added number
	 * 
	 * @return number value
	 */
	public Double poll() {
		Double s = start.number;
		start = start.next;
		start.setPrevious(null);
		return s;
	}

	/**
	 * Shows which number is next for removing from queue
	 * 
	 * @return number value
	 */
	public Double peek() {
		return start.number;
	}

	/**
	 * Shows number's
	 * 
	 * @param s
	 * @return
	 */
	public int search(Double s) {
		if (start == null) {
			throw new EmptyStackException();
		}
		Node temp = start;
		int index = 1;
		do {
			if (temp.number == s) {
				return index;
			}
			index++;
			temp = temp.next;

		} while (temp != null);
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
			if (start == null && last == null) {
				start = last = new Node(s);
			} else {
				Node temp = new Node(s);
				temp.setPrevious(last);
				last.next = temp;
				last = temp;
			}
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
			Double s = start.number;
			start = start.next;
			start.setPrevious(null);
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
		if (start == null) {
			throw new NoSuchElementException();
		} else {
			return start.number;
		}
	}

	/**
	 * Checks if queue is empty
	 * 
	 * @return true if queue is empty, else returns false
	 */
	public boolean isEmpty() {
		if (start == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {
		return start.toString();
	}

	private class Node {

		Double number;
		Node next;
		private Node previous;

		/**
		 * Constructor
		 * 
		 * @param number
		 */
		public Node(Double number) {
			this.number = number;
		}

		/**
		 * toString
		 */
		public String toString() {
			if (next == null) {
				return number + "";
			}
			return number + " " + next.toString();
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}

	public static void main(String[] args) {

		DoubleQueueLinkedList list = new DoubleQueueLinkedList();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			list.add(i * 1.0);
		}
		long end = System.currentTimeMillis();

		System.out.println(list);
		System.out.println(list.poll());
		System.out.println(list);
		System.out.println(list.peek());
	}

}

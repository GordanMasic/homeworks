package ba.bitcamp.Stacks;

import java.util.EmptyStackException;

public class StringLinkedListStack {

	private Node start;

	/**
	 * Constructor
	 */
	public StringLinkedListStack() {
		this.start = null;
	}

	/**
	 * Method for adding new element
	 * 
	 * @param s
	 *            element
	 * @return value of added element
	 */
	public String push(String word) {
		if (start == null) {
			start = new Node(word);
		} else {
			Node temp = new Node(word);
			temp.next = start;
			start = temp;
		}
		return word;
	}

	/**
	 * Method for removing last added element
	 * 
	 * @return element value
	 */
	public String pop() {
		if (start == null) {
			return null;
		} else {

			String s = start.word;
			start = start.next;
			return s;
		}
	}

	/**
	 * Checks if stack is empty
	 * 
	 * @return true if queue is empty, else returns false
	 */
	public boolean isEmpty() {
		return start == null;
	}

	/**
	 * Shows which element is next for removing from stack
	 * 
	 * @return element value
	 */
	public String peek() {
		if (start == null) {
			return null;
		} else {

			return start.word;
		}
	}

	/**
	 * Shows element's index in order to remove
	 * 
	 * @param s
	 *            element
	 * @return index
	 */
	public int search(String word) {
		if (start == null) {
			throw new EmptyStackException();
		}
		Node temp = start;
		int index = 1;
		do {
			if (temp.word.equals(word)) {
				return index;
			}
			index++;
			temp = temp.next;

		} while (temp != null);
		return -1;
	}

	/**
	 * toString method
	 */
	public String toString() {
		return start.toString();
	}

	private class Node {

		String word;
		Node next;

		/**
		 * Constructor
		 */
		public Node(String word) {
			this.word = word;
		}

		/**
		 * toString method
		 */
		public String toString() {
			if (next == null) {
				return word;
			}
			return word + " " + next.toString();
		}

	}

	public static void main(String[] args) {

		StringLinkedListStack stack = new StringLinkedListStack();

		System.out.println(stack.isEmpty());

		double startTime = System.currentTimeMillis();
		for (int i = 1; i <= 10; i++) {
			stack.push("" + i);
		}
		double endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("Time: " + (endTime - startTime));
		System.out.println(stack.isEmpty());
		System.out.println(stack.search("10"));
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.peek());
	}
}

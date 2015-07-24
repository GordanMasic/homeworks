package ba.bitcamp.homework21;

public class LinkedListDouble {

	// Start node
	private Node start;

	/**
	 * Empty constructor
	 */
	public LinkedListDouble() {
		this.start = null;
	}

	/**
	 * Constructor for creating LinkedListDouble objects by using other
	 * LinkedListDouble objects (something like copying one into other).
	 * 
	 * @param other
	 *            other LinkedListDouble object
	 */
	public LinkedListDouble(LinkedListDouble other) {
		this.start = other.start;
	}

	/**
	 * Adding new double number into linked list of double numbers
	 * 
	 * @param number
	 *            new number (<b>double</b>)
	 */
	public void add(Double number) {
		if (start == null) {
			start = new Node(number);
		} else {
			Node last = getLastNode();
			last.setNext(new Node(number));
		}
	}

	/**
	 * Method for getting last node in linked list
	 * 
	 * @return last node in linked list
	 */
	public Node getLastNode() {
		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Method for removing node from linked list at certain index
	 * 
	 * @param index
	 *            index of node that we want to remove
	 */
	public void remove(int index) {

		if (index == 0) {
			start = start.getNext();
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			Node previous = getPreviousNode(temp);

			previous.setNext(temp.getNext());
		}
	}

	/**
	 * Method for removing certain node from linked list
	 * 
	 * @param n
	 *            node that we want to remove
	 */
	public void remove(Node n) {
		Node temp = start;
		int index = 0;
		while (temp.getNext() != n) {
			index++;
		}

		remove(index + 1);
	}

	/**
	 * Deleting first node from linked list
	 */
	public void deleteFirst() {
		start = start.getNext();
	}

	/**
	 * Deleting last node from linked list
	 */
	public void deleteLast() {
		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		Node previous = getPreviousNode(temp);
		previous.setNext(null);
	}

	/**
	 * Method finds previous node of certain node
	 * 
	 * @param n
	 *            node whose previous node we want to get
	 * @return node that is before certain node
	 */
	public Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != n) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Method for reading number from certain index
	 * 
	 * @param index
	 *            index of number
	 * @return value of number
	 */
	public double get(int index) {
		if (start == null) {
			throw new NullPointerException();
		}
		if (index == 0) {
			return start.number;
		}
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.number;
	}

	/**
	 * Method finds how many elements has list
	 * 
	 * @return number of elements
	 */
	public int size() {
		int counter = 0;
		Node temp = start;
		while (temp.getNext() != null) {
			counter++;
			temp = temp.getNext();
		}
		return counter;
	}

	/**
	 * Method returns first element in list
	 */
	public double getFirst() {
		return start.number;
	}

	/**
	 * Method returns last element in list
	 */
	public double getLast() {
		Node temp = start;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.number;
	}

	/**
	 * Method for adding number on certain index
	 * 
	 * @param d
	 *            number
	 * @param index
	 *            index
	 */
	public void add(Double d, int index) {
		Node temp = start;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		Node temp2 = temp.getNext();
		Node temp3 = new Node(d);
		temp.setNext(temp3);
		temp3.setNext(temp2);
	}

	/**
	 * Returns middle number in list
	 */
	public Double miiddle() {
		int length = size();
		if (length % 2 == 0) {
			length /= 2;
		} else {
			length /= 2;
			length++;
		}
		Node temp = start;
		for (int i = 0; i < length; i++) {
			temp = temp.getNext();
		}
		return temp.getNumber();
	}

	@Override
	public String toString() {
		return String.format("%s", start);
	}

	private class Node {
		private Double number;
		private Node next;

		public Node(Double number) {
			this.number = number;
		}

		public double getNumber() {
			return number;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return String.format("%s, %s", number, next);
		}

	}
}

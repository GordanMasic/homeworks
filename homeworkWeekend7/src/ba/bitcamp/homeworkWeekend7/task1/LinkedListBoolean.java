package ba.bitcamp.homeworkWeekend7.task1;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class LinkedListBoolean {

	private Node start;

	public LinkedListBoolean() {
		this.start = null;
	}

	/**
	 * Add boolean type element to the list
	 * 
	 * @param b
	 *            boolean true or false
	 */
	public void add(Boolean b) {
		Node newNode = new Node(b);
		if (start == null) {
			start = newNode;
		} else {
			Node last = getLast();
			last.next = newNode;
		}
	}

	/**
	 * Remove boolean type element from list
	 * 
	 * @param b
	 *            boolean true or false
	 */
	public void remove(Boolean b) {
		Node temp = start;
		if (start == null) {
			throw new EmptyStackException();
		} else if (start.value.equals(b)) {
			start = start.next;
		} else {
			while (temp != null) {
				if (temp.next.value.equals(b)) {
					break;
				} else {
					temp = temp.next;
				}
			}
			if (temp == null) {
				throw new NoSuchElementException();
			} else {
				temp.next = temp.next.next;
			}
		}

	}

	/**
	 * Remove first boolean type element that you chose starting from certain
	 * index and going till the end of list.
	 * 
	 * @param index
	 *            starting index
	 * @param b
	 *            boolean true or false
	 */
	public void remove(int index, Boolean b) {
		Node temp = start;
		if (index > getLength() - 1) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			throw new NoSuchElementException();
		} else {
			while (!temp.next.value.equals(b)) {
				temp = temp.next;
				if (temp.next == null) {
					throw new NoSuchElementException();
				}
			}
			if (temp.next.next != null) {
				temp.next = temp.next.next;
			} else {
				temp.next = null;
			}
		}

	}

	/**
	 * Finds last node in list.
	 * 
	 * @return last node
	 */
	public Node getLast() {
		Node temp = start;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Calculates length of list
	 * 
	 * @return list length
	 */
	public int getLength() {
		return getLength(start);

	}

	/**
	 * Recursive method for getLength() method.
	 * 
	 * @param node
	 *            starting node
	 * @return length of list
	 */
	private int getLength(Node node) {
		if (node.next == null) {
			return 1;
		}
		return getLength(node.next) + 1;

	}

	/**
	 * Checks if list contains certain boolean type element.
	 * 
	 * @param b
	 *            boolean true or false
	 * @return boolean true or false
	 */
	public Boolean contains(Boolean b) {
		Node temp = start;
		for (int i = 0; i < getLength(); i++) {
			if (temp.value.equals(b)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * Checks if list is alternating. List is alternating if there are no two
	 * same elements standing one next to other.
	 * 
	 * @return boolean true or false
	 */
	public Boolean isAlternating() {
		Node temp = start;
		for (int i = 0; i < getLength() - 1; i++) {
			if (temp.value == temp.next.value) {
				return false;
			} else {
				temp = temp.next;
			}
		}
		return true;
	}

	/**
	 * toString method
	 */
	public String toString() {
		Node temp = start;
		String s = "";
		while (temp != null) {
			s += temp.toString();
			temp = temp.next;
		}
		return s;
	}

	private class Node {
		Boolean value;
		Node next;

		public Node(Boolean value) {
			this.value = value;
		}

		public String toString() {
			return value + " ";
		}
	}

	public static void main(String[] args) {

		LinkedListBoolean list = new LinkedListBoolean();
		list.add(true);
		list.add(true);
		list.add(false);
		list.add(false);
		list.add(true);

		System.out.println("Before remove: \n" + list);
		list.remove(true);
		list.remove(0, false);
		System.out.println("After remove: \n" + list);
		System.out.println("Does list contains false? ");
		System.out.println(list.contains(false));
		System.out.println("Is list alternating? ");
		System.out.println(list.isAlternating());
	}

}

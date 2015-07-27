package ba.bitcamp.homeworkWeekend7.task2;

import java.util.EmptyStackException;

public class UniqueStackInt {

	private Node start;
	private Node last;

	public UniqueStackInt() {
		this.start = null;
		this.last = null;
	}

	/**
	 * Add Integer type element in stack only if there is no same element in
	 * stack.
	 * 
	 * @param num
	 *            Integer type element
	 */
	public void push(Integer num) {
		Node newNode = new Node(num);
		boolean hasAlready = false;
		if (start == null) {
			last = start = newNode;
		} else {
			Node temp = start;
			while (temp != null) {
				if (temp.value.equals(num)) {
					hasAlready = true;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (hasAlready == false) {
				last.next = newNode;
				newNode.previous = last;
				last = newNode;
			}
		}
	}

	/**
	 * Removes last added element from list.
	 */
	public void pop() {
		if (start == null) {
			throw new EmptyStackException();
		} else {
			last = last.previous;
			last.next = null;
		}
	}

	/**
	 * Checks if elements of list are sorted from highest to lowest.
	 * 
	 * @return boolean true or false
	 */
	public Boolean isIncreasing() {
		if (start == null) {
			throw new EmptyStackException();
		} else {
			Node temp = start;
			while (temp.next != null) {
				System.out.println(temp.value);
				if (temp.value.compareTo(temp.next.value) < 0) {
					return false;
				} else {
					temp = temp.next;
				}
			}
			return true;
		}
	}

	public String toString() {
		return start.toString();
	}

	private class Node {

		Integer value;
		Node next;
		Node previous;

		public Node(Integer num) {
			this.value = num;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " " + next.toString();
		}
	}

	public static void main(String[] args) {

		UniqueStackInt stack = new UniqueStackInt();
		for (int i = 10; i > 0; i--) {
			stack.push(i);
		}

		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(11);
		System.out.println(stack);
		System.out.println(stack.isIncreasing());

	}

}

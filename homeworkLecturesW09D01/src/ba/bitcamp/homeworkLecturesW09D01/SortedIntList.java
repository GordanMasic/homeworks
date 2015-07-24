package ba.bitcamp.homeworkLecturesW09D01;

/**
 * Implementira interface za rad s listom integera koji su uvijek sortirani.
 */
public class SortedIntList {
	private Node start;

	public SortedIntList() {
		this.start = null;
	}

	/**
	 * Ubacuje broj u listu, èuvajuæi listu sortiranom.
	 * <p>
	 * TODO: Završiti implementaciju metode
	 * 
	 * @param n
	 *            broj koji ubacujemo u listu.
	 */
	public void add(int n) {
		Node newNode = new Node(n);

		if (start == null) {
			start = newNode;
		}  else if (start.getValue() >= n) {
			newNode.setNext(start);
			start = newNode;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				if (temp.getNext().getValue() < n) {
					temp = temp.getNext();
				} else {
					break;
				}
			}
			if (temp.getNext() == null) {
				temp.setNext(newNode);
			} else {
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
			}
		}
	}

	/**
	 * Adding new double number into linked list of double numbers
	 * 
	 * @param number
	 *            new number (<b>double</b>)
	 */
	public void addNum(int number) {
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
	 * Vraæa dužinu liste
	 * <p>
	 * TODO: prepisati ovu metodu tako da koristi rekurziju umjesto iteracije
	 * <p>
	 * Ako zapnete s rekurzijom pokušajte barem prepisati kôd koristeæi `for`
	 * petlju umjesto `while`.
	 * 
	 * @return dužina liste
	 */
	public int getLength() {
		return getLength(start);

	}

	public int getLength(Node node) {
		if (node.getNext() == null) {
			return 1;
		}
		return getLength(node.getNext()) + 1;

	}

	/**
	 * Pretvara linkanu listu u niz
	 * <p>
	 * TODO: završiti implementaciju
	 * 
	 * @return niz sa svim elementima iz liste
	 */
	public int[] toArray() {
		int n = getLength();
		int[] result = new int[n];
		Node temp = start;
		for (int i = 0; i < result.length; i++) {
			result[i] = temp.getValue();
			temp = temp.getNext();

		}

		return result;
	}

	public String toString() {
		if (start == null) {
			return "List is empty!";
		}
		return start.toString();
	}

	private class Node {

		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " " + next.toString();
		}
	}
}
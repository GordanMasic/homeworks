package homeworkLecturesW08D02;

public class DynamicString {

	// Declaring variables.
	private String myArray[];

	// Number of elements in array that have value.
	private int count;

	/**
	 * Constructor where needs to be inputed number of elements and value of
	 * elements.
	 * 
	 * @param n
	 *            - Number of elements.
	 * @param value
	 *            - Value of elements.
	 */
	public DynamicString(int n, String value) {
		super();
		myArray = new String[n];
		count = n;
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = value;
		}
	}

	/**
	 * Constructor where needs to be inputed number of elements and where value
	 * of elements is null.
	 * 
	 * @param n
	 *            - Number of elements.
	 */
	public DynamicString(int n) {
		this(n, null);
		count = 0;
	}

	/**
	 * Constructor where array is empty.
	 */
	public DynamicString() {
		this(8);
	}

	/**
	 * Adds new element in array.
	 * 
	 * @param element
	 *            - Element that needs to be added.
	 */
	public void addElement(String element) {
		// Checking if the number of elements that have value is equal to the
		// number of elements in the array, and if it is then it is needed to
		// increase array.
		if (count >= myArray.length) {
			String temp[] = myArray;
			myArray = new String[myArray.length * 2 + 1];

			for (int i = 0; i < temp.length; i++) {
				myArray[i] = temp[i];
			}

			myArray[count] = element;
			count++;
			// If the number of elements that have value is lower than number of
			// elements in the array then adding the element in the last
			// position.
		} else if (count < myArray.length) {
			myArray[count] = element;
			count++;
		}
	}

	/**
	 * Adds an array of elements to the array.
	 * 
	 * @param array
	 *            - Array that is needed to be add.
	 */
	public void addArrayOfElements(String[] array) {
		for (int i = 0; i < array.length; i++) {
			addElement(array[i]);
		}
	}

	/**
	 * Prints the number of elements in an array that have value.
	 * 
	 * @return - Number of elements in an array that have value.
	 */
	public int size() {
		return count;
	}

	/**
	 * Prints the number of elements in an array.
	 * 
	 * @return - Number of elements in an array.
	 */
	public int totalSize() {
		return myArray.length;
	}

	/**
	 * Prints the array.
	 */
	public String toString() {
		String str = "";
		if (count > 0) {
			str += size() + "\t[ ";
			for (int i = 0; i < count - 1; i++) {
				str += myArray[i] + ", ";
			}

			str += myArray[count - 1] + " ]\n" + totalSize() + "\t[ ";

			for (int i = 0; i < myArray.length - 1; i++) {
				str += myArray[i] + ", ";
			}
			str += myArray[myArray.length - 1] + " ]";
		} else {
			str += size() + "\t[]";
		}
		return str;
	}

	/**
	 * Removes the element with inputed index from the array and putting the
	 * last element that has value on place of removed element.
	 * 
	 * @param offset
	 *            - Number of index of element that is needed to be removed.
	 * @throws IndexOutOfBoundsException
	 *             If the inputed index does not exist in array throws
	 *             exception.
	 */
	public void removeQuick(int offset) throws IndexOutOfBoundsException {

		// If there is no elements in the array that have value throws
		// exception.
		if (count == 0) {
			throw new IndexOutOfBoundsException();
		}

		// If the inputed index does not exist in array throws exception.
		if (offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		// Putting the last element that has value on place of removed element.
		myArray[offset] = myArray[count - 1];
		count--;

		// If the number of elements in the array is three times larger than
		// number of elements that have value, than decreasing the number of
		// elements in the array for half.
		if (count <= myArray.length / 3) {
			String[] temp = new String[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = myArray[i];
			}
			myArray = temp;
		}
	}

	/**
	 * Removes the element with inputed index from the array and moving all
	 * elements in the array for one place.
	 * 
	 * @param offset
	 *            - Number of index of element that is needed to be removed.
	 * @throws IndexOutOfBoundsException
	 *             If the inputed index does not exist in array throws
	 *             exception.
	 */
	public void removeSlow(int offset) throws IndexOutOfBoundsException {

		// If there is no elements in the array that have value throws
		// exception.
		if (count == 0) {
			throw new IndexOutOfBoundsException();
		}

		// If the inputed index does not exist in array throws exception.
		if (offset >= count) {
			throw new IndexOutOfBoundsException();
		}

		// Creating new array.
		String[] tmp = new String[myArray.length];

		// Putting all elements of the array in the new array except the element
		// that is needed to be removed and decreasing number of elements for
		// one.
		for (int i = 0; i < tmp.length - 1; i++) {
			if (i == offset) {
				tmp[i] = myArray[++offset];
			} else {
				tmp[i] = myArray[offset];
			}
			offset++;
		}
		myArray = tmp;
		count--;
		myArray[count] = myArray[count - 1];

		// If the number of elements in the array is three times larger than
		// number of elements that have value, than decreasing the number of
		// elements in the array for half.
		if (count <= myArray.length / 3) {
			String[] temp = new String[totalSize() / 2];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = myArray[i];
			}
			myArray = temp;
		}
	}

	/*
	 * Get and set methods.
	 */
	public String[] getMyArray() {
		return myArray;
	}

	public void setMyArray(String[] myArray) {
		this.myArray = myArray;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
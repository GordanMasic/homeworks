package ba.bitcamp.homeworkWeekend7.task3;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListWithListIterator {

	public static void main(String[] args) {

		// Making a list of Integer type elements
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 7; i++) {
			list.add(i);
		}

		// Creating list iterator of Integer type
		ListIterator<Integer> it = list.listIterator();

		// Creating new list
		ArrayList<Integer> newList = new ArrayList<Integer>();

		// Filling new list with numbers with even indexes from the original
		// list
		int counter = 0;
		while (it.hasNext()) {
			Integer number = it.next();
			if (counter % 2 == 0) {
				newList.add(number);
			}
			counter++;
		}

		// Summing numbers from new list with numbers with odd indexes in
		// original list
		it = list.listIterator();
		counter = 0;
		int index = 0;
		while (it.hasNext()) {
			Integer number = it.next();
			if (counter % 2 != 0) {
				newList.set(index, number + newList.get(index));
				index++;
			}

			counter++;
		}
		System.out.println(list);
		System.out.println(newList);
	}

}

package ba.bitcamp.homeworkWeekend7.task4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Task4 {

	public static void main(String[] args) {
		// Making map that contains Integer key, and array list as value
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		Scanner in = new Scanner(System.in);
		// Inserting final key and value
		System.out.println("Insert final key: ");
		int key = in.nextInt();
		System.out.println("Insert final value: ");
		int value = in.nextInt();

		int counter = 0;
		// Passing values to list, and map
		for (int i = 1; i < key + 1; i++) {
			counter++;
			list = new ArrayList<Integer>();
			for (int j = 1; j < value + 1; j++) {
				list.add(j * counter);
			}

			map.put(i, list);

		}

		System.out.println(map);
		in.close();

	}

}

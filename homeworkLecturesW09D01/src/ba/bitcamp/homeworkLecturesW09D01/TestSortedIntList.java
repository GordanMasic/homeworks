package ba.bitcamp.homeworkLecturesW09D01;

import java.util.Scanner;

public class TestSortedIntList {
	 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SortedIntList list = new SortedIntList();
		
		System.out.println("Unesite proizvoljan broj pozitivnih brojeva:");
 
		while (true) {
			int n = s.nextInt();
 
			if (n > 0) {
				list.add(n);
			} else {
				break;
			}
		}
 
		System.out.printf("Unijeli ste %d pozitivnih brojeva\n", list.getLength());
		
		System.out.println("Poredani brojevi:");
		for (int currentN : list.toArray()) {
			System.out.println(currentN);
		}
	}
 
}

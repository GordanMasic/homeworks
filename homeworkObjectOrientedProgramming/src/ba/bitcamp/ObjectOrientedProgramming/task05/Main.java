package ba.bitcamp.ObjectOrientedProgramming.task05;

import java.util.Arrays;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;
import ba.bitcamp.ObjectOrientedProgramming.task02.Network;
import ba.bitcamp.ObjectOrientedProgramming.task03.Server;
import ba.bitcamp.ObjectOrientedProgramming.task04.Client;
import ba.bitcamp.ObjectOrientedProgramming.task07.ArrayManipulation;
import ba.bitcamp.ObjectOrientedProgramming.task08.BusNetwork;
import ba.bitcamp.ObjectOrientedProgramming.task09.StartNetwork;

public class Main {

	public static void main(String[] args) {

		char[] array1 = new char[] { '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b', 'c' };
		char[] array2 = new char[] { '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'd', 'e', 'f' };

		Client cl1 = new Client("PC1", array1);
		Client cl2 = new Client("PC2", array2);

		// System.out.println(cl1.getMacAddress());

		Server s1 = new Server("PC1", array1, 1);

		// cl2.connect(s1);

		// System.out.println(cl2);

		Computer[] computers = new Computer[2];
		computers[0] = cl1;
		computers[1] = cl2;

		computers = ArrayManipulation.extendArray(computers);
		computers = ArrayManipulation.extendArray(computers);
		computers = ArrayManipulation.shrinkArray(computers, 2);
		computers = ArrayManipulation.shrinkArray(computers, 2);
		System.out.println(Arrays.toString(computers));

		System.out.println();
		BusNetwork bn = new BusNetwork("Bus1");
		bn.addComputer(cl1);
		bn.addComputer(cl2);
		bn.removeComputer(cl2);
		
		System.out.println(bn.toString());
		System.out.println();
		StartNetwork sn = new StartNetwork("Start1", s1);
		sn.addComputer(cl1);
		sn.addComputer(cl2);
		
		System.out.println(sn);

	}

}

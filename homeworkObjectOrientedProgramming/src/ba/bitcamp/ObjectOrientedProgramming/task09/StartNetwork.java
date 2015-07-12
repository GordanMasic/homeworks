package ba.bitcamp.ObjectOrientedProgramming.task09;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;
import ba.bitcamp.ObjectOrientedProgramming.task02.Network;
import ba.bitcamp.ObjectOrientedProgramming.task03.Server;
import ba.bitcamp.ObjectOrientedProgramming.task04.Client;
import ba.bitcamp.ObjectOrientedProgramming.task06.Functionable;
import ba.bitcamp.ObjectOrientedProgramming.task07.ArrayManipulation;

public class StartNetwork extends Network implements Functionable {

	private Server server1;

	

	public StartNetwork(String networkName, Server server1) {
		super(networkName);
		this.server1 = server1;
	}

	@Override
	/**
	 * Checks if network is in function
	 */
	public boolean isFunctioning() {
		int counter = 0;
		for (int i = 0; i < getComputers().length; i++) {
			Client c = (Client) getComputers()[i];
			if (c.getComputer() == this.server1) {
				counter++;
			}
		}

		if (counter > server1.getAllowedComputers()) {
			return false;
		} else
			return true;
	}

	@Override
	/**
	 * Method first extend array of computers, then puts computer 
	 * into array and connects him with this network
	 */
	public void addComputer(Computer c) {
		Computer[] comps;
		comps = ArrayManipulation.extendArray(getComputers());
		comps[comps.length - 1] = c;
		Client k = (Client) c;
		k.connect(this.server1);
		setComputers(comps);

	}

	@Override
	/**
	 * Method finds computer in array, disconnects 
	 * him and removes him from an array
	 */
	public void removeComputer(Computer c) {
		int index = 0;
		int counter = 0;
		Computer[] comps;
		Client k = (Client) c;
		for (int i = 0; i < getComputers().length; i++) {
			if (getComputers()[i].equals(c)) {
				k.disconnected();
				getComputers()[i] = null;
				index = i;
			} else {
				counter++;
			}
		}
		if (counter == getComputers().length) {
			throw new NullPointerException("There's no such computer!");
		}
		comps = ArrayManipulation.shrinkArray(getComputers(), index);
		setComputers(comps);

	}

	/**
	 * toString method
	 */
	public String toString() {
		return String.format(
				"Number of computers: %s\nIs network functionable? %s\n",
				getComputers().length, isFunctioning());
	}
}
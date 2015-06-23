package ba.bitcamp.ObjectOrientedProgramming.task04;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;
import ba.bitcamp.ObjectOrientedProgramming.task02.Network;

public interface Connectable {

	/**
	 * Connects with certain computer
	 * 
	 * @param c
	 *            computer to be connected to
	 */
	public abstract void connect(Computer c);

	/**
	 * Connects with certain network
	 * 
	 * @param n
	 *            network to be connected to
	 */
	public abstract void connect(Network n);

	/**
	 * Disconnects computer and network
	 */
	public abstract void disconnected();
}

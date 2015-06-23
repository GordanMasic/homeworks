package ba.bitcamp.ObjectOrientedProgramming.task03;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;

public class Server extends Computer {

	private int allowedComputers;

	/**
	 * Constructor for creating Server objects
	 * 
	 * @param name
	 *            name of computer
	 * @param macAddress
	 *            mac address of computer
	 * @param allowedComputers
	 *            maximal number of computer allowed to be on server
	 */
	public Server(String name, char[] macAddress, int allowedComputers) {
		super(name, macAddress);
		this.allowedComputers = allowedComputers;
	}

	// Get method
	public int getAllowedComputers() {
		return allowedComputers;
	}

	/**
	 * . equals method for class Server
	 * 
	 * @param other
	 *            server
	 * @return true or false
	 */
	public boolean equals(Server other) {
		if (other == null) {
			return false;
		} else if (this.getName().equals(other.getName())
				&& this.getMacAddress().equals(other.getMacAddress())
				&& this.allowedComputers == other.allowedComputers) {
			return true;
		} else
			return false;
	}

	/**
	 * toString method for class Server
	 */
	public String toString() {
		return String.format("Name: %s\nMac address: %s\nMAX Computers: %d\n",
				this.getName(), this.getMacAddress(), allowedComputers);
	}
}
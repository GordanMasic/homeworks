package ba.bitcamp.ObjectOrientedProgramming.task02;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;

public abstract class Network {

	private String networkName;
	private Computer[] computers;

	/**
	 * Constructor for creating Network objects
	 * 
	 * @param networkName
	 *            name of network
	 * @param computers
	 *            array of computers
	 */
	public Network(String networkName) {
		this.setNetworkName(networkName);
		this.setComputers(new Computer[0]);
	}

	/**
	 * Method for adding computers in network
	 * 
	 * @param c
	 *            computer
	 */
	public abstract void addComputer(Computer c);

	/**
	 * Method for removing computer from network
	 * 
	 * @param c
	 *            computer
	 */
	public abstract void removeComputer(Computer c);

	// Getters and setters
	public Computer[] getComputers() {
		return computers;
	}

	public void setComputers(Computer[] computers) {
		this.computers = computers;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

}
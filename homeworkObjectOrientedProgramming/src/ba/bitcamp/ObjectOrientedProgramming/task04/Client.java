package ba.bitcamp.ObjectOrientedProgramming.task04;

import javax.management.OperationsException;

import ba.bitcamp.ObjectOrientedProgramming.task01.Computer;
import ba.bitcamp.ObjectOrientedProgramming.task02.Network;

public class Client extends Computer implements Connectable {

	private Computer computer;
	private Network network;

	/**
	 * Constructor for creating Client object
	 * 
	 * @param name
	 *            name of computer
	 * @param macAddress
	 *            mac address of computer
	 * @param computer
	 *            computer to link to
	 * @param network
	 *            network to link to
	 */
	public Client(String name, char[] macAddress) {
		super(name, macAddress);
		this.computer = null;
		this.network = null;

	}

	public Client() {

	}

	// Getters
	public Computer getComputer() {
		return computer;
	}

	public Network getNetwork() {
		return network;
	}

	@Override
	public void connect(Computer c) {

		try {
			if (this.computer != null) {
				throw new OperationsException();
			} else {
				this.computer = c;
			}
		} catch (OperationsException e) {
			System.out.println("Computer is already linked!");
		}

	}

	@Override
	public void connect(Network n) {
		try {
			if (this.network != null) {
				throw new OperationsException();
			} else {
				this.network = n;
			}
		} catch (OperationsException e) {
			System.out.println("Network is already linked!");
		}
	}

	@Override
	public void disconnected() {

		this.computer = null;
		this.network = null;
	}

	@Override
	public String toString() {
		return String.format("Client [computer=%s, network=%s]", computer,
				network);
	}

	@Override
	public boolean equals(Computer other) {
		return super.equals(other);
	}
}
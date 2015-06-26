package ba.bitcamp.ObjectOrientedProgramming.task01;

import java.util.Arrays;

public abstract class Computer {

	private String name;
	private MACAddress macAddress;

	/**
	 * Constructor for creating Computer object
	 * 
	 * @param name
	 *            name of computer
	 * @param macAddress
	 *            mac address of computer
	 */
	public Computer(String name, char[] macAddress) {
		for (int i = 0; i < macAddress.length; i++) {
			if (macAddress[i] == ':') {
				throw new IllegalArgumentException(
						"MAC address must be inputed without \":\" character!");
			}
		}
		if (macAddress.length > 12) {
			throw new IndexOutOfBoundsException(
					"MAC address must have only 12 characters without \":\" characters!");
		}
		this.name = name;
		this.macAddress = new MACAddress(macAddress);
	}

	/**
	 * Default constructor for creating Computer objects
	 */
	public Computer() {
		this.name = "";
		this.macAddress = null;
	}

	// Getters and Setters for Computer class
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MACAddress getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(MACAddress macAddress) {
		this.macAddress = macAddress;
	}

	// Nested class MACAddress
	public class MACAddress {

		private char[] macAddress = new char[12];

		/**
		 * Constructor for creating MacAddress object
		 * 
		 * @param macAddress
		 *            mac address
		 */
		public MACAddress(char[] macAddress) {
			for (int i = 0; i < macAddress.length; i++) {
				if (macAddress[i] == ':') {
					throw new IllegalArgumentException(
							"MAC address must be inputed without \":\" character!");
				}
			}
			if (macAddress.length > 12) {
				throw new IndexOutOfBoundsException(
						"MAC address must have only 12 characters without \":\" characters!");
			}
			this.macAddress = macAddress;
		}

		// Getters and Setters for MacAddress class
		public char[] getMacAddress() {
			return macAddress;
		}

		public void setMacAddress(char[] macAddress) {
			this.macAddress = macAddress;
		}

		/**
		 * toString method for MACAddress class
		 */
		public String toString() {
			return String.format("Mac adress: %s\n",
					Arrays.toString(macAddress));
		}

		/**
		 * equals method for MACAddress class
		 * 
		 * @param other
		 *            other mac address
		 * @return true or false
		 */
		public boolean equals(MACAddress other) {
			if (other == null) {
				return false;
			}
			for (int i = 0; i < macAddress.length; i++) {
				if (this.macAddress[i] != other.macAddress[i]) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * toString method for Computer class
	 */
	public String toString() {
		return String.format("Computer: %s\nMac address: %s\n", name,
				macAddress);
	}

	/**
	 * equals method for Computer class
	 * 
	 * @param other
	 *            other computer
	 * @return true or false
	 */
	public boolean equals(Computer other) {
		if (other == null) {
			return false;
		} else if (!this.name.equals(other.name)) {
			return false;
		} else if (!this.macAddress.equals(other.macAddress)) {
			return false;
		} else
			return true;
	}

}

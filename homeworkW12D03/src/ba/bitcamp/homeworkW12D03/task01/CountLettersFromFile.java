package ba.bitcamp.homeworkW12D03.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author Gordan
 *
 *         This class represents one program that counts how many time first
 *         letter from text file repeats in same text file.
 */
public class CountLettersFromFile {

	// Defining variables
	private static int counter = 1;
	private static LinkedBlockingQueue<Master> assignments;
	private static ArrayList<Worker> workers;
	private static Object lock = new Object();

	public static void main(String[] args) {

		// Initializing list and queue
		assignments = new LinkedBlockingQueue<>();
		workers = new ArrayList<>();

		try {

			// Creating reader for reading text file
			BufferedReader reader = new BufferedReader(new FileReader(new File("Text.txt")));
			// Taking first letter from file
			char firstChar = (char) reader.read();
			// Putting letter in low case
			firstChar = Character.toLowerCase(firstChar);
			// Printing first letter
			System.out.println(firstChar);

			String line = "";

			// Reading the rest of the text
			while (reader.ready()) {
				// Taking line and making it low case
				line = reader.readLine().toLowerCase();
				// Making master thread
				Master master = new Master(line, firstChar);
				// Adding master thread to queue of threads
				assignments.add(master);
			}

			reader.close();

			// Starting time
			long start = System.currentTimeMillis();

			// Creating four worker threads, starting and adding them to the
			// list of
			// workers
			for (int i = 0; i < 4; i++) {
				Worker worker = new Worker();
				worker.start();
				workers.add(worker);
			}

			// Making each of them wait for previous thread to finish
			for (Worker c : workers) {
				try {
					c.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Printing information of time necessary to finish and repeating
			// letter
			System.out.println("Time: " + (System.currentTimeMillis() - start) + " [ms]");
			System.out.printf("Letter '%s' repeats %d times.", firstChar, counter);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Gordan
	 * 
	 *         This is inner class that represents a working thread. It gets
	 *         assignment from master thread and finishes it.
	 */
	private static class Worker extends Thread {

		public void run() {
			while (!assignments.isEmpty()) {
				try {
					Master job = assignments.take();
					job.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @author Korisnik
	 *
	 *         Master thread that gives assignments to worker threads.
	 *         Assignment is to take a letter and one line of text. Letter is
	 *         being compared with all letters in line and counted it's
	 *         repetition.
	 */
	private static class Master implements Runnable {

		private String line;
		private Character letter;

		public Master(String line, Character letter) {
			this.line = line;
			this.letter = letter;
		}

		// Comparing letter with all letters in line and counting repeating of
		// the letter
		public void run() {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == letter) {
					synchronized (lock) {
						counter++;
					}
				}
			}
		}
	}
}
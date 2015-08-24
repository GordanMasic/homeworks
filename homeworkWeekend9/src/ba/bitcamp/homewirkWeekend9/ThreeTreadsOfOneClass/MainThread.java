package ba.bitcamp.homewirkWeekend9.ThreeTreadsOfOneClass;

/**
 * 
 * @author Gordan
 *
 *         This class shows how can three threads work together. All three
 *         threads are initialized with same inner class that extends Thread
 *         class. In constructor they are receiving two parameters. First one is
 *         time delay used for thread sleep, and the other one is message that
 *         user writes. Depending on message threads are doing different things.
 */
public class MainThread {

	// Constants
	public static final String NUMBERS_1_TO_10 = "numbers";
	public static final String BITCAMP = "BITCamp";
	public static final String RANDOM_NUMS_1_TO_5 = "random";

	public static void main(String[] args) {

		// Initializing threads
		MyThread t1 = new MyThread(1000, NUMBERS_1_TO_10);
		MyThread t2 = new MyThread(1000, BITCAMP);
		MyThread t3 = new MyThread(700, RANDOM_NUMS_1_TO_5);
		MyThread t4 = new MyThread(200, "Gordan");

		// Starting first thread
		t1.start();
		try {
			// Waiting first thread to finish
			t1.join();
			// Starting second thread
			t2.start();
			// Waiting second thread to finish
			t2.join();
			// Starting third thread
			t3.start();
			// Waiting third thread to finish
			t3.join();
			t4.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static class MyThread extends Thread {

		int delay; // Time for sleep method
		String message; // Message that user sends

		/**
		 * Creates Thread with certain parameters.
		 * 
		 * @param delay
		 *            - <b>int</b> number that determines time delay for
		 *            Thread.sleep(int delay) method
		 * @param message
		 *            - decides what this thread is going to do. If message
		 *            contains constant NUMBERS_1_TO_10 thread will write all
		 *            numbers from 1 to 10. If message contains constant BITCAMP
		 *            thread will write four times string "BITCamp".If message
		 *            contains constant RANDOM_NUMS_1_TO_5 thread will write
		 *            five random numbers between 1 and 5. Otherwise thread will
		 *            write four times any other message.
		 */
		public MyThread(int delay, String message) {
			this.delay = delay;
			this.message = message;
		}

		@Override
		public void run() {

			if (message.equals(NUMBERS_1_TO_10)) {
				for (int i = 1; i < 11; i++) {
					System.out.println("" + i);
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (message.equals(RANDOM_NUMS_1_TO_5)) {
				for (int i = 0; i < 5; i++) {
					System.out.println("" + (int) (Math.random() * 4 + 1));
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			} else if (message.equals(BITCAMP)) {
				for (int i = 0; i < 4; i++) {
					System.out.println(message);
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			} else {
				for (int i = 0; i < 4; i++) {
					System.out.println(message);
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}

	}
}

package ba.bitcamp.homeworkWeekend9.CheckIfFileExists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one client who connects on local host server
 *         and sends some file path. Server responds whether that file exists on
 *         his PC or not.
 */
public class Client {

	// Constants
	public static final int PORT = 6666;
	public static final String HOST = "localhost";

	public static void main(String[] args) {

		Socket client;
		try {

			// Connecting to server
			client = new Socket(HOST, PORT);
			System.out.println("You have been connected!");

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			Scanner in = new Scanner(System.in);

			System.out.println("Input file path(e.g. C:/Users/User/Desktop/txt.txt): ");

			// Client inputs file path through console and sends it to server
			writer.write(in.nextLine());
			writer.newLine();
			writer.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// Client gets response message from server as number 1 if file
			// exists or some other number if
			// file doesn't exists
			String serverResponse = reader.readLine();
			if (Integer.parseInt(serverResponse) == 1) {
				System.out.println("File exists on server's PC!");
			} else {
				System.out.println("File doesn't exist on server's PC!");
			}

			writer.close();
			reader.close();
			in.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

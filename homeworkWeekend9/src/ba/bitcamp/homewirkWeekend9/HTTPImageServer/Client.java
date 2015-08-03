package ba.bitcamp.homewirkWeekend9.HTTPImageServer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one client that connects to HTTP server and
 *         sends one picture to that server.
 */
public class Client {

	// Constants
	public static final int PORT = 8000;
	public static final String LOCALHOST = "localhost";
	private static final String INITIAL_MESSAGE = "PUT";

	public static void main(String[] args) {
		Socket client;
		try {
			// Connecting to server
			System.out.println("Connecting to server...");
			client = new Socket(LOCALHOST, PORT);
			System.out.println("Connected...");

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Sending first message so the server knows that this is not client
			// from browser
			bufferedWriter.write(INITIAL_MESSAGE);
			bufferedWriter.newLine();
			bufferedWriter.flush();

			FileInputStream fileInputStream = new FileInputStream(new File("/Users/Korisnik/Desktop/tropical-sunset.jpg"));
			OutputStream outputStream = client.getOutputStream();

			byte[] buffer = new byte[1024];
			int readBytes;

			// Reading picture bytes and sending to the server
			while ((readBytes = fileInputStream.read(buffer, 0, 1024)) > 0) {
				outputStream.write(buffer, 0, readBytes);
				outputStream.flush();
			}
			fileInputStream.close();
			bufferedWriter.close();
			outputStream.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package ba.bitcamp.homeworkWeekend9.CheckIfFileExists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Gordan
 *
 *         This class represents one server who gets some file path from client.
 *         If that file exists on server's PC server sends message to client
 *         that contains number 1, else it sends message that contains number 0.
 */
public class Server {

	// Constant
	public static final int PORT = 6666;

	public static void main(String[] args) {

		ServerSocket server;
		try {
			server = new ServerSocket(PORT);

			System.out.println("Server started...");
			// Connecting client to the server
			Socket client = server.accept();
			System.out.println("Client accepted!");

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			System.out.println("Receiving message from client...");

			// Reading message from client
			String filePath = reader.readLine();
			File clientAskedFile = new File(filePath);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Searching for received file path on server's PC
			if (clientAskedFile.exists()) {
				// If file exists on server's PC server sends number 1
				writer.write("1");
				writer.newLine();
				writer.flush();
			} else {
				// If file doesn't exists on server's PC server sends number 0
				writer.write("0");
				writer.newLine();
				writer.flush();

			}

			reader.close();
			writer.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

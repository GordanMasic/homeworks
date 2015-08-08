package ba.bitcamp.homeworkLecturesW11D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one server which reads lines from the text
 *         file. Creates one BitResponse (message) object that contains that
 *         line from file. Adds that object to an array list. Takes one random
 *         object from the list, converts it into JSON file and sends to client.
 */
public class Server {

	public static void main(String[] args) {

		// Creating mapper for reading and writing JSON file
		ObjectMapper mapper;

		// Creating server
		ServerSocket server;

		// Creating list of messages
		ArrayList<BitResponse> messages;
		try {

			// Initializing variables
			server = new ServerSocket(8000);
			mapper = new ObjectMapper();
			messages = new ArrayList<BitResponse>();

			// Waiting for client
			System.out.println("Waiting for client...");
			Socket client = server.accept();
			System.out.println("Client found");

			// Reader for reading lines from the file
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("file.txt")));

			// Reading all lines from text file
			while (bufferedReader.ready()) {
				// Making BitResponse object from each line
				BitResponse bitResponse = new BitResponse(bufferedReader.readLine());
				// Adding it to array list
				messages.add(bitResponse);
			}

			// Taking one random message from list
			BitResponse messageSent = messages.get((int) (Math.random() * (messages.size() - 1)));

			// Converting it into JSON file
			mapper.writeValue(new File("server.json"), messageSent);

			// Creating writer for sending JSON file to client
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Reinitializing reader to read JSON file
			bufferedReader = new BufferedReader(new FileReader(new File("server.json")));

			// Reading line from JSON file
			String line = bufferedReader.readLine();

			// Sending line to client
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			bufferedReader.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

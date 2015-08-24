package ba.bitcamp.homeworkLecturesW11D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author Gordan
 *
 *         This class represents one client connected to local server. Client
 *         receives one JSON file from server and saves it. After that client
 *         constructs object from that file.
 */
public class Client {

	public static void main(String[] args) {

		Socket client;

		try {

			// Connecting client to local host server
			client = new Socket("localhost", 8000);

			// Creating reader for reading message from server
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// Creating mapper for reading JSON file
			ObjectMapper mapper = new ObjectMapper();
			// Creating writer for saving received message from server into a
			// file
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("client.json")));

			// Reading message from server
			String line = bufferedReader.readLine();
			// Saving message into file
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.close();

			// Reading message from JSON file and constructing object
			BitResponse response = mapper.readValue(new File("client.json"), BitResponse.class);
			System.out.println(response.toString());
			bufferedReader.close();
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

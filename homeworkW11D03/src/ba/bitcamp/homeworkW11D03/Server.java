package ba.bitcamp.homeworkW11D03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one localhost server who gets one message from
 *         client. Message should contain one web site address and the web
 *         site's name. Afterwards that address and web site's name will be
 *         saved in one links.txt file which is used by HTTP localhost server.
 *
 */
public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(6666);
			System.out.println("Server started...");

			// Waiting for client to connect
			Socket client = server.accept();
			System.out.println("Client found!");

			FileWriter writer = new FileWriter(new File(
					"src/ba/bitcamp/homeworkW11D03/links.txt"), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			// Reading message from client and saving into a file
			writer.write(reader.readLine() + "\n");
			writer.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

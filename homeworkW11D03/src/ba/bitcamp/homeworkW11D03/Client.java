package ba.bitcamp.homeworkW11D03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one client who connects on localhost server
 *         with port 6666 and through console sends one link to specific web
 *         page (e.g. https://www.google.com and name of that address (e.g.
 *         Google). That link will show on localhost web page.
 *
 */
public class Client {

	public static void main(String[] args) {

		try {

			// Connecting client to localhost server

			Socket client = new Socket("localhost", 6666);

			Scanner in = new Scanner(System.in);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			while (true) {
				try {
					System.out
							.println("Please input web adress(eg. https://www.google.com or http://www.github.com)");

					URL address = new URL(in.nextLine());
					// Inputing first web site address and sending to server
					writer.write(address + " ");
					System.out.println("Please input name of web page: ");
					// Inputing name of web site and sending to server
					writer.write(in.nextLine());
					break;
				} catch (MalformedURLException e) {
					System.out.println("Wrong link address format!");
				}
			}
			writer.newLine();
			writer.close();
			in.close();
			client.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

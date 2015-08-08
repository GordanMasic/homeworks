package ba.bitcamp.homeworkW11D03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Gordan
 *
 *         This class represents one HTTP server who reads all web sites links
 *         from certain file and creates links on localhost web site.
 */
public class HTTPServer {

	public static void main(String[] args) {

		ServerSocket server;
		try {
			// Creating server
			server = new ServerSocket(6699);

			while (true) {
				// Waiting for clients
				Socket client = server.accept();

				// Reading HTML code from index.html file
				BufferedReader readerHtml = new BufferedReader(new FileReader(
						new File("src/ba/bitcamp/homeworkW11D03/index.html")));

				String htmlText = "";
				while (readerHtml.ready()) {
					htmlText += readerHtml.readLine();
				}

				BufferedWriter writeHtml = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				// Reading web sites links with names of web sites from
				// links.txt file
				BufferedReader readTextFile = new BufferedReader(
						new FileReader(new File(
								"src/ba/bitcamp/homeworkW11D03/links.txt")));
				String fileText = "";
				// First writing HTML code
				writeHtml.write(htmlText);
				writeHtml.newLine();
				while (readTextFile.ready()) {
					fileText = readTextFile.readLine();
					// Second writing web sites links
					writeHtml.write("<a href= " + fileText.split(" ")[0] + ">"
							+ fileText.split(" ")[1] + "<br>");
					writeHtml.newLine();
				}

				writeHtml.close();
				readerHtml.close();
				readTextFile.close();
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

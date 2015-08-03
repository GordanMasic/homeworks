package ba.bitcamp.homewirkWeekend9.HTTPImageServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 
 * @author Gordan
 *
 *         This class represents one HTTP server that receives one picture from
 *         non browser client and posts that picture on web site. It enables
 *         browser client to choose random link for random picture. After that
 *         it opens new web page with that picture in it.
 */
public class HTTPServer {

	// Constant
	public static final int PORT = 8000;
	private static final String INITIAL_MESSAGE = "PUT";

	// Counter for counting number of received pictures
	public static int counter = 1;

	public static void main(String[] args) {
		// Creating list of pictures received from non browser clients
		ArrayList<File> listOfFiles = new ArrayList<File>();

		ServerSocket server;
		try {
			server = new ServerSocket(PORT);
			while (true) {

				// Accepting client
				System.out.println("Witing for client...");
				Socket client = server.accept();
				System.out.println("Client accepted!");

				BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));

				try {
					// Reading first message from client to recognize whether
					// client is non browser client or not or it ties to open
					// certin link
					String initialMessage = read.readLine();
					String[] initialMessageParts = initialMessage.split(" ");

					/*
					 * If user is non browser user, server receives one picture
					 * from it and saves it in folder images
					 */
					if (initialMessage.indexOf(INITIAL_MESSAGE) == 0) {

						// Giving name to the picture
						String name = "image" + counter + ".jpg";
						counter++;

						InputStream readStream = client.getInputStream();
						File picture = new File("images/" + name);
						FileOutputStream fileOut = new FileOutputStream(picture);

						byte[] buffer = new byte[1024];
						int readBytes;

						// Writing picture into folder images
						while ((readBytes = readStream.read(buffer, 0, buffer.length)) > 0) {
							fileOut.write(buffer, 0, readBytes);
							fileOut.flush();
						}
						fileOut.close();
						listOfFiles.add(picture);

						/*
						 * If initial message is "/" or "/favicon.ico" that
						 * means the client is browser client and server creates
						 * web site with links for pictures from base.
						 */
					} else if (initialMessageParts[1].equals("/") || initialMessageParts[1].equals("/favicon.ico")) {

						// Reading HTML code from index.html file
						BufferedReader readerHtml = new BufferedReader(new FileReader(new File("src/index.html")));

						String htmlText = "";
						while (readerHtml.ready()) {
							htmlText += readerHtml.readLine();
						}

						BufferedWriter writeHtml = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

						// Writing HTML code
						writeHtml.write(htmlText);
						writeHtml.newLine();

						// Adding links for each picture from list
						for (File picture : listOfFiles) {
							String pictureName = picture.getName().split("\\.")[0];
							writeHtml.write("<a href=/" + pictureName + ">" + pictureName + "<br>");
							writeHtml.newLine();
							writeHtml.flush();
						}

						writeHtml.write("</body></html>");
						writeHtml.close();
						readerHtml.close();

						/*
						 * Opening link from picture that browser client chooses
						 * and creating new web page with that picture on it
						 */
					} else {

						String pictureName = initialMessageParts[1].substring(1) + ".jpg";

						OutputStream outputStream = client.getOutputStream();
						FileInputStream fileInputStream = new FileInputStream("images/" + pictureName);

						byte[] buffer = new byte[1024];
						int readBytes;

						// Sending certain picture to her local web page
						while ((readBytes = fileInputStream.read(buffer, 0, buffer.length)) > 0) {
							outputStream.write(buffer, 0, readBytes);
							outputStream.flush();
						}

						fileInputStream.close();
						outputStream.close();

					}
				} catch (NullPointerException e) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package ba.bitcamp.homeworkLecturesW11D5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Gordan
 * 
 *         This class represents one message that server reads from file and
 *         converts into JSON format. After that it's been put into JSON file
 *         which server sends to client.
 *
 */
public class BitResponse {

	private String message;
	private String timeStamp;

	/**
	 * Message that is used for creating JSON file.
	 * 
	 * @param message
	 *            String message
	 * @param timeStamp
	 *            Date time stamp of the message
	 */
	public BitResponse(String message) {
		this.message = message;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.timeStamp = dateFormat.format(new Date());
	}

	public BitResponse() {
	}

	public String toString() {
		return String.format("Message: %s Date: %s\n", message, timeStamp);

	}

	//Getters and setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}

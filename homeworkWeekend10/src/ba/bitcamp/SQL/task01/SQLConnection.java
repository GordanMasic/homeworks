package ba.bitcamp.SQL.task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Represents the class that contains method that enables loading JDBC library,
 * and method that enables creation and connection with the database. Also it
 * contains methods which enables inputing new complaints into database, and
 * viewing all inputed complaints.
 * 
 * @author Gordan
 *
 */
public class SQLConnection {

	// Declaring variable that enables connection with database.
	private static Connection conn = null;

	/**
	 * Loads JDBC library.
	 */
	private static void loadLibrary() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load the library.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Creates the connection with database, after the library is loaded. If the
	 * database does not exist it creates new database.
	 */
	public static void connectToDB() {
		loadLibrary();
		try {
			// Connecting with database.
			conn = DriverManager.getConnection("jdbc:sqlite:complaints.db");
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.err.println("Could not connect to database.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Inputs the complaint that user has wrote in the application into
	 * database. When the complaint is inputed it saves the date and the time of
	 * the complaint in the database.
	 * 
	 * @param complaint
	 *            - The text of the complaint.
	 */
	public static void inputComplaint(String complaint) {
		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO complaint VALUES (null, '" + complaint + "', CURRENT_TIMESTAMP)");
			System.out.println("Query executed.");
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Reads all complaints from the database and saves them into string
	 * variable. The complaint contains id, date and time of the complaint and
	 * text of the complaint.
	 * 
	 * @return - All complaints from the database that are loaded in string
	 *         variable.
	 */
	public static String selectComplaints() {
		// Declaring string variable.
		StringBuilder sb = new StringBuilder();
		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM complaint");

			// Reading from database and saving into string variable.
			while (result.next()) {
				sb.append("(" + result.getString(1) + ") " + result.getString(3) + "\n" + result.getString(2) + "\n");
			}
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
		// Returning string variable that contains all from database.
		return sb.toString();
	}

}

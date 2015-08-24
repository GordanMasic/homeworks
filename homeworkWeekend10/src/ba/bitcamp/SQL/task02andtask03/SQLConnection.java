package ba.bitcamp.SQL.task02andtask03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Represents the class that contains method that enables loading JDBC library,
 * and method that enables creation and connection with the database. Also it
 * contains methods which enables inputing new products into database, and
 * deleting products from the database.
 * 
 * @author Gordan
 *
 */
public class SQLConnection {

	// Declaring variable that enables connection with database.
	private static Connection conn = null;
	// Declaring variable that marks if the product is successfully inputed.
	public static boolean isInputed = false;

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
			conn = DriverManager.getConnection("jdbc:sqlite:product.db");
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.err.println("Could not connect to database.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Inputs the new product into the database. The product needs to have code
	 * with 10 digits, name and the price.
	 * 
	 * @param code
	 *            - Unique code of the product.
	 * @param name
	 *            - Name of the product.
	 * @param price
	 *            - Price of the product.
	 */
	public static void insertProduct(String code, String name, Double price) {
		// Checking does the inputed code have 10 characters.
		if (code.length() != 10) {
			JOptionPane.showMessageDialog(null, "Inputed code does not have 10 digits.");
			isInputed = false;
			return;
		}
		// Checking if the all characters of the code are digits.
		for (int i = 0; i < code.length(); i++) {
			if (!Character.isDigit(code.charAt(i))) {
				JOptionPane.showMessageDialog(null, "Please for code input only digits.");
				isInputed = false;
				return;
			}
		}
		// Calling method checkProduct and checking if there is the product in
		// the database with the same name.
		if (!checkProduct(name).equals("")) {
			int option = JOptionPane.showConfirmDialog(null, "The product already exists in database. Do you want to continue?", "", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.NO_OPTION) {
				isInputed = false;
				return;
			}
		}

		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO product VALUES ('" + code + "', '" + name + "', " + price + ")");
			JOptionPane.showMessageDialog(null, "You have successfully inputed the product.");
			System.out.println("Query executed.");
			isInputed = true;
		} catch (SQLException e) {
			// If in the database already exists product with inputed code
			// opening WARNING message.
			JOptionPane.showMessageDialog(null, "The product with inputed code " + code + " already exist in database.");
			return;
		}
	}

	/**
	 * Checks if there is the product with the same name in the database.
	 * 
	 * @param product
	 *            - Name of the product.
	 * @return - The empty string if there is no products with same name.
	 */
	public static String checkProduct(String product) {
		// Declaring string variable.
		StringBuilder sb = new StringBuilder();
		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT name FROM product WHERE name = '" + product + "'");

			// Reading from database and saving into string variable.
			while (result.next()) {
				sb.append(result.getString(1) + "\n");
			}
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
		// Returning string variable.
		return sb.toString();
	}

	/**
	 * Reads the product from the database and saves them into the list of
	 * products.
	 * 
	 * @return - The list of the products from database.
	 */
	public static ArrayList<Product> selectProducts() {
		// Declaring the list of the products.
		ArrayList<Product> array = new ArrayList<>();
		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM product");

			// Reading from the database and inputing products into the list.
			while (result.next()) {
				array.add(new Product(result.getInt(1), result.getString(2), result.getDouble(3)));
			}
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
		// Returning the list of the products.
		return array;
	}

	/**
	 * Deletes inputed product from the database.
	 * 
	 * @param product
	 *            - The product that needs to be deleted.
	 */
	public static void deleteProduct(Product product) {
		try {
			// Declaring and executing query.
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM product WHERE code = " + product.getCode());
			// If the product is successfully deleted opening the JOptionpane.
			JOptionPane.showMessageDialog(null, "You have successfully deleted the product.");
			System.out.println("Query executed.");
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}
}

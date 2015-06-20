package ba.bitcamp.homeworkLectures2.task04;

import ba.bitcamp.homeworkLectures2.task02.Author;
import ba.bitcamp.homeworkLectures2.task03.Book;

public class BookShop {

	/*
	 * Declaring properties of book-shop
	 */
	private String name;
	private Book[] books;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the book-shop.
	 * @param books
	 *            - An array of books in the book-shop.
	 */
	public BookShop(String name, Book[] books) {
		super();
		this.name = name;
		this.books = books;
	}

	/*
	 * Get and set method
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds new book in the book-shop
	 * 
	 * @param b
	 *            - Book that user wants to add.
	 */
	public void addBook(Book b) {

		int counter = 0;

		for (int i = 0; i < books.length; i++) {
			// If the book exist in the book-shop increases its status for one.
			if (books[i] != null && books[i].equal(b)
					&& b.getStatus() < Book.MAX_BOOKS) {
				b.setStatus(1);
				break;
				// If the status of the book is max prints message.
			} else if (books[i] != null && books[i].equal(b)
					&& b.getStatus() == Book.MAX_BOOKS) {
				System.out.println("Can't add more books!");
				break;
				// If there is no same book in the book-shop adds it to new
				// place and increases its status.
			} else if (books[i] == null) {
				books[i] = b;
				b.setStatus(1);
				break;
			}
			if (books[i] != null) {
				counter++;
			}
		}

		// If the book-shop is full prints message.
		if (counter == books.length) {
			System.out.println("There is no more place in the book-shop!");
		}
	}

	/**
	 * Sells book from the book-shop
	 * 
	 * @param b
	 *            - Book that user wants to sell.
	 */
	public void sellBook(Book b) {
		// Checks the status of the book and if it is zero, there is no book n
		// the book-shop.
		if (b.getStatus() == 0) {
			System.out
					.println("There is no copies of that book in the book-shop!");
		}
		// If the status is higher than zero, finds the book and lowers its
		// status for one.
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null && books[i].equal(b)) {
				books[i] = null;
				b.setStatus(-1);
				break;
			}
		}
	}

	/**
	 * Prints all books that are in shop.
	 */
	public void printBooks() {
		int counter = 0;

		// Finds all books in the book-shop array and prints them.
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				System.out.println(books[i] + " ");
				counter++;
			}
		}

		// If there is no books in the book-shop, prints message.
		if (counter == 0) {
			System.out.println("There are no books in the shop!");
		}
	}

	/**
	 * Prints all books from inputed author.
	 * 
	 * @param a
	 *            - Author whose books user wants to print.
	 */
	public void printBookFromAuthor(Author a) {
		for (int i = 0; i < books.length; i++) {
			// Comparing name of book author and the name of inputed author.
			if (books[i] != null
					&& books[i].getAuthor().getName().equals(a.getName())) {
				System.out.println(books[i] + " ");
			}
		}
	}
}

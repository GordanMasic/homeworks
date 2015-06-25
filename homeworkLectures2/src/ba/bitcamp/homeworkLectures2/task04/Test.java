package ba.bitcamp.homeworkLectures2.task04;

import ba.bitcamp.homeworkLectures2.task02.Author;
import ba.bitcamp.homeworkLectures2.task03.Book;

public class Test {

	public static void main(String[] args) {

		// Creating an array of books
		Book[] books = new Book[5];

		// Creating authors
		Author authorOne = new Author("Mesa Selimovic", "mesa@bitcam.ba", true);
		Author authorTwo = new Author("Ivo Andric", "ivo@bitcamp.ba", true);
		Author authorThree = new Author("Joanne Kathleen Rowling",
				"joanne@bitcamp.ba", false);
		Author authorFour = new Author("George R. R. Martin",
				"george@bitcamp.ba", true);

		// Creating books
		Book bookOne = new Book("Fortress", 15.5, 0, authorOne);
		Book bookTwo = new Book("The Bridge on the Drina", 12.60, 0, authorTwo);
		Book bookThree = new Book("Harry Potter", 20, 0, authorThree);
		Book bookFour = new Book("Game of thrones", 50, 0, authorFour);
		Book bookFive = new Book("Death and the Dervish", 35, 0, authorOne);

		// Creating book-shop
		BookShop bs = new BookShop("Bicamp", books);

		// Adding books in the book-shop
		bs.addBook(bookOne);
		bs.addBook(bookThree);
		bs.addBook(bookTwo);
		bs.addBook(bookFour);
		bs.addBook(bookFive);

		// Selling books from the book-shop
		bs.sellBook(bookThree);
		bs.sellBook(bookOne);
		bs.sellBook(bookTwo);

		// If there is no copy of the book in the book-shop, prints message
		bs.sellBook(bookOne);

		// Printing all books from the book-shop
		bs.printBooks();

		// Prints all books from inputed author
		bs.printBookFromAuthor(authorOne);

	}

}

package library;
import java.util.*;
public class LibraryService {
	 private BookDAO bookDAO = new BookDAO();
	    private Scanner sc = new Scanner(System.in);

	    public void addBook() {
	        System.out.print("Enter title: ");
	        String title = sc.nextLine();

	        System.out.print("Enter author: ");
	        String author = sc.nextLine();

	        System.out.print("Enter price: ");
	        double price = sc.nextDouble();
	        sc.nextLine();
	        
	        Book book = new Book(title, author, price);
	        bookDAO.addBook(book);
	    }

	    public void viewBooks() {
	        bookDAO.viewBooks();
	    }
}

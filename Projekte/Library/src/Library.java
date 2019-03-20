import java.util.HashMap;
import java.util.Map;

public class Library {

	Map<String, Book> books;
	Map<String, Boolean> reservations;
	
	public Library()
	{
		books = new HashMap<String, Book>();
		reservations = new HashMap<String, Boolean>();
	}
	
	public int getNumBooks()
	{
		return books.size();
	}
	
	public void addBook(Book book)
	{
		books.put(book.isbn, book);
	}
	
	public Book getBook(String isbn)
	{
		return books.get(isbn);
	}
	
	public Book getBookByAuthorTitle(String author, String title)
	{
		String isbn = LibraryUtils.generateIsbn(author, title);
		return getBook(isbn);
	}
	
	public void removeBook(String isbn) throws Exception
	{
		if (books.get(isbn) != null)
			books.remove(isbn);
		else
			throw new Exception("Buch mit angegebener ISBN existiert nicht");
	}
	
	public void setReserved(String isbn) throws Exception
	{
		if (books.get(isbn) != null)
		{
			reservations.put(isbn, true);
			getBook(isbn).reserved = true;
		}else
		{
			throw new Exception("Buch mit angegebener ISBN existiert nicht");
		}
				
	}
	
	public void clearReservation(String isbn) throws Exception
	{
		if (books.get(isbn) != null)
		{
			getBook(isbn).reserved = false;
		}else
			throw new Exception("Buch mit angegebener ISBN existiert nicht");
			
	}
	
	public Boolean getReserationStatus(String isbn) throws Exception
	{
		if (books.get(isbn) != null)
		{
			Boolean status_reservation =  reservations.get(isbn);
			Boolean status_book = getBook(isbn).reserved;
			
			if (status_reservation != status_book)
					throw new Exception("error in reservation system");
			else
				return status_reservation;
		}else
			throw new Exception("Buch mit angegebener ISBN existiert nicht");
	}
	
}

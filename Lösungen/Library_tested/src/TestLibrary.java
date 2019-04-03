import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class TestLibrary {

	private static Library lib;
	
	@BeforeAll
	public static void create()
	{
		lib = new Library();
	}
	
	@Test
	public void testAddBook() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
	}
	
	@Test
	public void testgetBook() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		
		lib.addBook(book);
		
		Book fromLib = lib.getBook(book.isbn);
		assertEquals(fromLib, book);
	}
	
	@Test
	public void testNumBooks() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		assertEquals(1,lib.getNumBooks());
	}
	
	@Test
	public void testGetBookByAuthorTitle() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		String isbn = book.isbn;
		
		book = null;
		
		Book actual = lib.getBookByAuthorTitle("Hallo", "Heinz Kunz");
		Book expected = lib.getBook(isbn);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testRemoveBook() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		String isbn = book.isbn;
		book = null;
		
		lib.removeBook(isbn);
		
		assertNull(lib.getBook(isbn));
	}
	
	@Test
	public void testRemoveBookNotExisting() throws Exception
	{
		Throwable exception = assertThrows(Exception.class, () -> {
			lib.removeBook("Hallo");
			});
		
		assertEquals(exception.getMessage(), "Buch mit angegebener ISBN existiert nicht");
	}
	
	@Test
	public void testSetReserved() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		lib.setReserved(book.isbn);
		
		assertNotNull(lib.reservations.get(book.isbn));
		assertTrue(lib.getBook(book.isbn).reserved);
	}
	
	@Test
	public void testSetReservedBookNotExisting() throws Exception
	{	
		Throwable exception = assertThrows(Exception.class, () -> {
			lib.setReserved("Hallo");
			});
		
		assertEquals(exception.getMessage(), "Buch mit angegebener ISBN existiert nicht");
	}
	
	@Test
	public void testClearReservationBookNotExisting() throws Exception
	{	
		Throwable exception = assertThrows(Exception.class, () -> {
			lib.clearReservation("Hallo");
			});
		
		assertEquals(exception.getMessage(), "Buch mit angegebener ISBN existiert nicht");
	}
	
	@Test
	public void testGetReservationStatusBookNotExisting() throws Exception
	{	
		Throwable exception = assertThrows(Exception.class, () -> {
			lib.getReservationStatus("Hallo");
			});
		
		assertEquals(exception.getMessage(), "Buch mit angegebener ISBN existiert nicht");
	}
	
	@Test
	public void testClearReservation() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		//ohne set reserved vorher wird fehler nicht deutlich
		lib.setReserved(book.isbn);
		lib.clearReservation(book.isbn);
		
		assertFalse(lib.getBook(book.isbn).reserved);
		assertNull(lib.reservations.get(book.isbn));
	}
	
	@Test
	public void testGetReservationStatus() throws Exception
	{

		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		//ohne set reserved vorher wird fehler nicht deutlich
		lib.setReserved(book.isbn);
		
		assertTrue(lib.getReservationStatus(book.isbn));
	}
	
	@Test
	public void testGetReservationException() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		lib.addBook(book);
		
		//ohne set reserved vorher wird fehler nicht deutlich
		lib.setReserved(book.isbn);
		book.reserved = false;
		Throwable exception = assertThrows(Exception.class,() ->{
			lib.getReservationStatus(book.isbn);
		});
		
		assertEquals("error in reservation system", exception.getMessage());
	}
	
}

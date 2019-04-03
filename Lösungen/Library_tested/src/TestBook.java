import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestBook {

	@Test
	public void testCreateBookEmptyTitle()
	{
		Throwable exception = assertThrows(Exception.class, () -> {
			Book book = new Book("", "Heinz Kunz");
			});
		
		assertEquals(exception.getMessage(), "Titel ist leer");
	}
	
	@Test
	public void testCreateBook() throws Exception
	{
		Book book = new Book("Hallo", "Heinz Kunz");
		assertNotNull(book);
	}
	
	@Test
	public void testCreateBookEmptyAuthor()
	{
		Throwable exception = assertThrows(Exception.class, () -> {
			Book book = new Book("Hallo", "");
			});
		
		assertEquals(exception.getMessage(), "Author ist leer");
	}
}

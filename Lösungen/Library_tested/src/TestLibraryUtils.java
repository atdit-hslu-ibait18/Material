import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class TestLibraryUtils {

	@Test
	public void testeStringToAsciiSum()
	{
		int sum = LibraryUtils.stringToAsciiSum("Hallo");
		int value = (72 + 97 + 108 + 108 + 111);
		
		assertEquals(sum, value);
	}
	
	@Test
	public void testGenerateISBN()
	{
		int sum_title = LibraryUtils.stringToAsciiSum("Hallo");
		int sum_Author = LibraryUtils.stringToAsciiSum("Kunz");
		
		String expected = "HaKu" + String.valueOf(sum_title) + String.valueOf(sum_Author);
		
		String isbn = LibraryUtils.generateIsbn("Hallo", "Kunz");
		
		assertEquals(expected, isbn);
	}
	
	
}

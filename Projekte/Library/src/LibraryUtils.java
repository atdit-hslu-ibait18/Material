
public class LibraryUtils {

	public static int stringToAsciiSum(String string)
	{
		int sum_title = 0;
		for (char ch: string.toCharArray()) {
			sum_title += ch;
		}
		
		return sum_title;
	}
	
	public static String generateIsbn(String title, String author)
	{
		int sum_title = stringToAsciiSum(title);
		int sum_author = stringToAsciiSum(author);	
		
		String isbn = title.substring(0, 2) + author.substring(0,  2);
		isbn += String.valueOf(sum_title) + String.valueOf(sum_author);
		
		return isbn;
	}
}

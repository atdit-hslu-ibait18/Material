
public class Book {
	
	String title;
	String isbn;
	String author;
	Boolean reserved;

	public Book(String title, String author) throws Exception
	{
		this.author = author;
		this.reserved = false;
		this.title = title;
		
		if (title.length() <= 0)
			throw new Exception("Titel ist leer");
			
		if (author.length() <= 0)
			throw new Exception("Author ist leer");
		
		this.isbn = LibraryUtils.generateIsbn(title, author);
	}
}

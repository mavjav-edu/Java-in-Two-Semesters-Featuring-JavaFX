
import java.util.Comparator;

public class Book implements Comparable <Book> 
{ 
    private String isbn; 
    private String title;
    private String author;

    public Book(String isbnIn, String titleIn, String authorIn) 
    { 
		isbn = isbnIn; 
		title = titleIn; 
		author = authorIn; 
    }

    public String getISBN() 
    { 
		return isbn; 
    }

    public String getTitle() 
    { 
		return title; 
    }

    public String getAuthor() 
    { 
		return author; 
    } 
    
    @Override
    public String toString() 
    { 
        return "(" + isbn +", " + title + ", " + author +  ")"; 
    }
    
    @Override
    public boolean equals (Object objIn) 
    {
		Book bookIn = (Book) objIn; 
		return  isbn.equals(bookIn.isbn); 
    }
    
    @Override
    public int hashCode() 
    { 
        return isbn.hashCode(); 
    }

    @Override
    public int compareTo(Book bIn)
    {
         return isbn.compareTo(bIn.isbn);
    }

    // three Comparator<Book> implementations provided via static methods

   	// compare via isbns 
	public static Comparator<Book> ISBNCompare = 
                (book1, book2) -> {return book1.getISBN().compareTo(book2.getISBN());};
	// compare via titles
    public static Comparator<Book> TitleCompare = 
                (book1, book2) -> {return book1.getTitle().compareTo(book2.getTitle());};
	// compare via authors
    public static Comparator<Book> AuthorCompare = 
                (book1, book2) -> {return book1.getAuthor().compareTo(book2.getAuthor());};    

}


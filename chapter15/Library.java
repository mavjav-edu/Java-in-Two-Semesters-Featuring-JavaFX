
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class Library 
{
	Map <String, Book> books; // declare map collection
	// create empty map 
	public Library() 
	{ 
		books = new HashMap<> (); 
	}

	// add the given book into the collection 
	public boolean addBook(Book bookIn) 
	{
		String keyIn = bookIn.getISBN(); // isbn will be key of map 
		if (books.containsKey(keyIn)) // check if isbn already in use
		{ 
			return false; // indicate error
		} 
		else // ok to add this book
		{ 
			books.put(keyIn, bookIn); // add key and book pair into map 
			return true; 
		} 
	}

	// remove the book with the given isbn 
	public boolean removeBook(String isbnIn) 
	{ 
		if (books.remove(isbnIn)!= null) // check if item was removed 
		{ 
			return true; 
		} 
		else // when item is not removed
		{ 
			return false; 
		} 
	}

	// return the number of books in the collection
	public int getTotalNumberOfBooks()
	{
		return books.size();
	}

	// return the book with the given isbn or null if no such book
	public Book getBook (String isbnIn)
	{
		return books.get(isbnIn);
	}

	// return the set of books in the collection
	public Set<Book> getAllBooks ()
	{
		Set<Book> bookSet = new HashSet<>(); // to store the set of books
		books.forEach((key,book) -> bookSet.add(book)); // use forEach loop to add books
		return bookSet; // return the set of books	
	}
}

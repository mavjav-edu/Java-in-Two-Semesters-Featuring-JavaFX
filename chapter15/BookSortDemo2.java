
import java.util.List;
import java.util.ArrayList;

public class BookSortDemo2 
{
    public static void main(String[] args) 
    {        
       // create three Book objects
       Book b1 = new Book("9999999999", "Clowning Around", "Joe King"); 
       Book b2 = new Book("2222222222", "Travel With Me", "Sandy Beach");
       Book b3 = new Book("4444444444", "Interior Design", "Anita Room");
       // create an empty list of books
       List<Book> bookList = new ArrayList<>();
       // add the three Book ojects
       bookList.add(b1);
       bookList.add(b2);
       bookList.add(b3);
       // display list before and after sorting
       System.out.println("***COMPARATOR DEMO***");
       System.out.println("\nBefore Sort\n"+bookList);
       // sort list using sort method of List and a Comparator implementation using lambda
       bookList.sort((book1,book2) -> {return book1.getAuthor().compareTo(book2.getAuthor());});       		System.out.println("\nAfter Author sort\n"+ bookList);    
	}
}

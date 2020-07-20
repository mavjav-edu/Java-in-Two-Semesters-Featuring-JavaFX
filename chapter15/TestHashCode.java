public class TestHashCode 
{ 
public static void main (String[] args) 
{
// create two "equal" books
Book b1 = new Book("9999999999", "Clowning Around", "Joe King"); 
Book b2 = new Book("9999999999", "Clowning Around", "Joe King");
// check their hashCode numbers
System.out.println(b1.hashCode()); 
System.out.println(b2.hashCode()); 
} 
}

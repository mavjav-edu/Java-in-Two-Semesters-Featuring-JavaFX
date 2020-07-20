
import java.io.IOException;
public class AptitudeTest
{
// this main method will throw out any IOExceptions
public static void main (String[] args) throws IOException
{
	int score;
	System.out.print("Enter aptitude test score: ");
	// the 'getInteger' method may throw an IOException
	score = TestException.getInteger();
	if (score >= 50)
	{
		  System.out.println("You have a place on the course!");
	}
	else
	{
	   System.out.println("Sorry, you failed your test");
	}
}
}


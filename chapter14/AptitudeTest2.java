
import java.io.IOException;

public class AptitudeTest2
{
    public static void main (String[] args)
    {
	try
	{
	int score;
	System.out.print("Enter aptitude test score: ");
	// getInteger may throw IOException or NumberFomatException
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
	// if something does goes wrong!
	catch (NumberFormatException e)
	{
		System.out.println("You entered an invalid number!");
	}
	catch (IOException e)
	{
		System.out.println(e); // calls toString method
	}
	// even if no exception thrown/caught, this line will be executed
	System.out.println("Goodbye");
   }
}


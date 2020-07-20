
public class DisplayEven
{
	public static void main(String[] args)
	{
		System.out.println("*** Even numbers from 10 to 1 ***");
		System.out.println();
		for(int i=10; i >= 1; i--) // loop through the numbers 10 down to 1
		{
			// body of the loop contains in ‘if’ statement
			if (i%2 == 0) // check if number is even
			{
				System.out.println(i); // number displayed only when it is checked to be even
			}
		}
	}
}



public class DisplayEven2
{
	public static void main(String[] args)
	{
		System.out.println("*** Even numbers from 10 to 1 ***");
		System.out.println();
		for(int i=10; i>=1; i--) 
		{
			if (i%2 != 0) // check if number is NOT even
			{
				continue; // skips the rest of this iteration and moves to the next iteration
			}
			System.out.println(i); // even number only displayed if we have not skipped this iteration
		}
	}
}


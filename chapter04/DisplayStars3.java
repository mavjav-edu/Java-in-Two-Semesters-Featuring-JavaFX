public class DisplayStars3
{
	public static void main (String[] args)
	{
		for(int i = 1; i <= 5; i++) // outer loop as before
		{
			for (int j = 1; j <= 5; j++) // inner loop to display one row of stars
			{
				System.out.print("*");
			} 	// inner loop ends here
			System.out.println(); // necessary to start next row on a new line
		} // outer loop ends here
	}
}

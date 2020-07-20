
public class DisplayShape
{
	public static void main (String[] args)
	{
		for(int i = 1; i <= 5; i++) // outer loop controlling the number of rows 
		{
			for (int j = 1; j <= i; j++) // inner loop controlling the number of stars in one row
			{
			System.out.print("*");
			} 
			System.out.println(); 
		} 
	}
}


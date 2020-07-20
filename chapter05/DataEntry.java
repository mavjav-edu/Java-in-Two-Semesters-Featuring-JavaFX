
import java.util.Scanner;

public class DataEntry
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int year, month, day;
		
		// prompt for year of birth
		System.out.println("Please enter the year of your birth");
		
		// display confidentiality message
		System.out.println("Please note that all information supplied is confidential");
		System.out.println("No personal details will be shared with any third party");
		
		// get year from user
		year = keyboard.nextInt();
		
		// prompt for month of birth
		System.out.println("Please enter the month of your birth as a number from 1 to 12");
		
		// display confidentiality message
		System.out.println("Please note that all information supplied is confidential");
		System.out.println("No personal details will be shared with any third party");
		
		// get month from user
		month = keyboard.nextInt();
		
		// prompt for day of birth
		System.out.println("Please enter the day of your birth as a number from 1 to 31");
		
		// display confidentiality message
		System.out.println("Please note that all information supplied is confidential");
		System.out.println("No personal details will be shared with any third party");
		
		// get day from user
		day = keyboard.nextInt();
		
		// more code here
	}
}


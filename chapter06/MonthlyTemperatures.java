
import java.util.Scanner;

public class MonthlyTemperatures
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner (System.in);
		char choice;
		
		double[][] temperature = new double[4][7]; // create 2D array
		// offer menu
		do
		{
			System.out.println();
			System.out.println("[1] Enter temperatures");
			System.out.println("[2] Display all");
			System.out.println("[3] Display one week");
			System.out.println("[4] Display day of the week");
			System.out.println("[5] Exit");
			System.out.print("Enter choice [1-5]: "); 
			choice = keyboard.next().charAt(0);
			System.out.println();
			// process choice by calling additional methods 
			switch(choice)
			{
				case '1': 	enterTemps(temperature); 
							break; 
				case '2': 	displayAllTemps(temperature); 
							break; 
				case '3': 	displayWeek(temperature); 
							break; 
				case '4': 	displayDays(temperature); 
							break; 
				case '5': 	System.out.println ("Goodbye");
							break;
				default: 	System.out.println("ERROR: options 1-5 only!"); 
			}
		} while (choice != '5');
	}
		
		
	// method to enter temperatures into the 2D array requires a nested loop 
	static void enterTemps(double[][] temperatureIn)
	{
		Scanner keyboard = new Scanner (System.in);
		// the outer loop controls the week number
		for (int week = 1; week <= temperatureIn.length; week++)
		{
			// the inner loop controls the day number
			for (int day = 1; day <= temperatureIn[0].length; day++)
			{
				System.out.println("enter temperature for week " + week + " and day " + day);
				temperatureIn[week-1][day-1] = keyboard.nextDouble();
			}
		}
	}

	// method to display all temperatures in the 2D array requires a nested loop 
	static void displayAllTemps(double[][] temperatureIn)
	{
		System.out.println();
		System.out.println("***TEMPERATURES ENTERED***"); 
		// the outer loop controls the week number
		for (int week = 1; week <= temperatureIn.length; week++)
		{
			// the inner loop controls the day number
			for (int day = 1; day <= temperatureIn[0].length; day++)
			{
					System.out.println("week " +week+" day "+day+": "+ temperatureIn[week-1][day-1]);
			}
		}
	}

	// method to display temperatures for a single week requires a single loop  
	static void displayWeek(double[][] temperatureIn)
	{
		Scanner keyboard = new Scanner (System.in);
		int week;
		// enter week number
		System.out.print("Enter week number (1-4): ");
		week = keyboard.nextInt();
		// input validation: week number should be between 1 and 4
		while (week<1 || week > 4)
		{
			System.out.println("Inavlid week number!!");
			System.out.print("Enter again (1-4 only): ");
			week = keyboard.nextInt();
		}
		// display temperatures for given week
		System.out.println();
		System.out.println("***TEMPERATURES ENTERED FOR WEEK "+week+"***"); 
		System.out.println();
		// week number is fixed so loop required to process day numbers only
		for (int day = 1; day <= temperatureIn[0].length; day++)
		{
				System.out.println("week "+week+" day "+day+": "+ temperatureIn[week-1][day-1]);
		}
	}

	// method to display temperatures for a single day of each week requires a single loop 
	static void displayDays(double[][] temperatureIn)
	{
		Scanner keyboard = new Scanner (System.in);
		int day;
		// enter day number
		System.out.print("Enter day number (1-7): ");
		day = keyboard.nextInt();
		// input validation: day number should be between 1 and 7
		while (day<1 || day > 7)
		{
			System.out.println("Inavlid day number!!");
			System.out.print("Enter again (1-7 only): ");
			day = keyboard.nextInt();
		}
		// display temperatures for given day of the week
		System.out.println();
		System.out.println("***TEMPERATURES ENTERED FOR DAY "+day+"***"); 
		System.out.println();
		// day number is fixed so loop required to process week numbers only
		for (int week = 1; week <= temperatureIn.length; week++)
		{
				System.out.println("week "+week+" day "+day+": " + temperatureIn[week-1][day-1]);
		}
	}
}



import java.util.Scanner;

public class RectangleCalculations
{
		public static void main(String[] args)
		{
			double length, height, area, perimeter;
			Scanner keyboard = new Scanner(System.in);
			System.out.print("What is the length of the rectangle? "); // prompt for length
			length = keyboard.nextDouble(); // get length from user
			System.out.print("What is the height of the rectangle? "); // prompt for height
			height = keyboard.nextDouble(); // get height from user
			area = calculateArea(length, height); // call calculateArea method
			perimeter = calculatePerimeter(length, height); // call calculatePerimeter method
			System.out.println("The area of the rectangle is " + area); // display area
			System.out.println("The perimeter of the rectangle is " + perimeter); // display perimeter
		}
				
		// method to calculate area 
		static double calculateArea(double lengthIn, double heightIn)
		{
			return lengthIn * heightIn;
		}
		
		// method to calculate perimeter
		static double calculatePerimeter(double lengthIn, double heightIn)
		{
			return 2 * (lengthIn + heightIn);
		}
}


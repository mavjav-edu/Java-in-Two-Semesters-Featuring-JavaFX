
import java.util.Scanner;

public class Tester
{
	public static void main(String[] args)
	{
		char ans;
		Scanner keyboard = new Scanner (System.in);
		Oblong object; // reference to object created here 
		do
		{
			System.out.print("Enter length: "); 
			double length = keyboard.nextDouble();
			System.out.print("Enter height: "); 
			double height = keyboard.nextDouble();
			// new object created each time we go around the loop 
			object = new Oblong(length, height);
			System.out.println("area = "+ object.calculateArea());
			System.out.println("perimeter = "+ object.calculatePerimeter());
			System.out.print("Do you want another go? "); 
			ans = keyboard.next().charAt(0);
		} 	while (ans == 'y' || ans == 'Y');
	}
}

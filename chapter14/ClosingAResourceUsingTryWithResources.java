
import java.util.Scanner;

public class ClosingAResourceUsingTryWithResources
{
	public static void main(String[] args)
	{
		try (Scanner keyboard = new Scanner (System.in)) // open a Scanner resource here
		{
            System.out.println("START TRY");
            String[] colours = {"RED","BLUE","GREEN"}; // initialize array
            System.out.print("Which colour? (1,2,3): ");
            String pos = keyboard.next(); 
            // next line could throw NumberFormatException
            int i = Integer.parseInt(pos);
            // next line could throw ArrayIndexOutOfBoundsException
            System.out.println(colours[i-1]);
            System.out.println("END TRY");
        }
		// include a catch only for ArrayIndexOutOfBoundsException
		catch(ArrayIndexOutOfBoundsException e)
		{
            System.out.println("ENTER CATCH ");
            System.out.println(e);
		}
		// we have removed the finally clause
		System.out.println("Goodbye");

	}
}


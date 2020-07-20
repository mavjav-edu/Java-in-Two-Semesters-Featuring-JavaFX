
import java.util.Scanner;

public class ClosingAResourceUsingFinally
{
    public static void main(String[] args)
    {
	Scanner keyboard = new Scanner (System.in); // open a Scanner resource
	try
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
	// this block will always be executed
	finally
	{
            System.out.println("ENTER FINALLY");
            keyboard.close(); // Scanner resource closed
            System.out.println("Scanner CLOSED");
	}
	System.out.println("Goodbye");

    }
}



import java.util.Scanner;

public class RollerCoaster
{
    public static void main(String[] args)
    {
	       // declare variables
        int age;  
        Scanner keyboard = new Scanner (System.in);

        // four instructions to process information
	       System.out.println("How old are you?");
        age = keyboard.nextInt();
        System.out.println("Hello Junior!");
        System.out.println("Enjoy your ride");
    }
}


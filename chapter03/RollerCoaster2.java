
import java.util.Scanner;

// This program is an example of the use of selection in a Java program

public class RollerCoaster2
{
    public static void main(String[] args)
    {
      int age;  
      Scanner keyboard = new Scanner (System.in);
      System.out.println("How old are you?");
      age = keyboard.nextInt();
	     if (age < 13) // test controls if the next instruction is executed
      {
      		System.out.println("Hello Junior!");
      }
      System.out.println("Enjoy your ride");
    }
}



// demonstration of the console class for keyboard input

import java.io.Console;  

public class ConsoleTester
{
    public static void main(String[] args)
    {
    		System.out.println();
		System.out.println("Console Tester"); 
		System.out.println();
		Console con = System.console();
        	String name; // declaration of a String
        	name = con.readLine("Please enter your name: "); // allow user to enter name
        	System.out.println("Hello " + name); // display a message to the user
   	 }
}

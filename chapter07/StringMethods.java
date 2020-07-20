
import java.util.Scanner;

public class StringMethods
{
public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);
    // create a new string
    String str;
    // get the user to enter a string
    System.out.print("Enter a string without spaces: ");
    str = keyboard.next();
    // display the length of the user's string
    System.out.println("The length of the string is " + str.length());
    // display the third character of the user's string
    System.out.println("The character at position 3 is " + str.charAt(2));
    // display a selected part of the user's string
    System.out.println("Characters 2 to 4 are " + str.substring(1,4));
    // display the user's string joined with another string
    System.out.println(str.concat(" was the string entered"));
    // display the user's string in upper case
    System.out.println("This is upper case: " + str.toUpperCase());
    // display the user's string in lower case
    System.out.println("This is lower case: " + str.toLowerCase());
    }
}




import java.util.Scanner; // import the Scanner class from the util package

// a program to input the initial price of a product and then calculate and display its cost after tax has been added 

public class FindCost3
{
     public static void main(String[] args )
     {
          Scanner keyboard = new Scanner(System.in); // create Scanner object 
          double price, tax;
          System.out.println("*** Product Price Check ***");
          System.out.print("Enter initial price: "); // prompt for input 
          price = keyboard.nextDouble(); // input method called 
          System.out.print("Enter tax rate: "); // prompt for input 
          tax = keyboard.nextDouble(); // input method called 
          price = price * (1 + tax/100); // perform the calculation 
          System.out.println("Cost after tax = " + price);
     }
}


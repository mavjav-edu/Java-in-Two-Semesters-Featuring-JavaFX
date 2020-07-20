import java.util.Scanner;

public class FindCost4
{
    public static void main(String[] args )
    {
        double price, tax;
        char reply;
        Scanner keyboard = new Scanner(System.in);
        do
        {
            // these instructions as before
            System.out.println("*** Product Price Check ***");
            System.out.print("Enter initial price: ");
            price = keyboard.nextDouble();
            System.out.print("Enter tax rate: ");
            tax = keyboard.nextDouble();
            price = price * (1 + tax/100);
            System.out.println("Cost after tax = " + price);
            // now see if user wants another go
            System.out.println();
            System.out.print("Would you like to enter another product(y/n)?: ");
            reply = keyboard.next().charAt(0);
            System.out.println();
        } while (reply == 'y' || reply == 'Y');
    }
}

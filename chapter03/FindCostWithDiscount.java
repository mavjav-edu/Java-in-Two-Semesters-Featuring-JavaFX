
import java.util.Scanner;
public class FindCostWithDiscount
{
    public static void main(String[] args )
    {
        double price, tax;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("*** Product Price Check ***");
        System.out.print("Enter initial price: ");
        price = keyboard.nextDouble();
        System.out.print("Enter tax rate: ");
        tax = keyboard.nextDouble();
        // the following 'if' statement allows a selection to take place
        if (price > 100) // test the price to see if a discount applies
        {
          // these two instructions executed only when the test is true
          System.out.println("Special Promotion: We pay half your tax!");
          tax = tax * 0.5;
        }
        // the remaining instructions are always executed
        price = price * (1 + tax/100);
        System.out.println("Cost after tax = " + price);
    }
}

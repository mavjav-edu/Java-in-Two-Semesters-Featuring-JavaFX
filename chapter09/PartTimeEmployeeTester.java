
import java.util.Scanner;
public class PartTimeEmployeeTester
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboardString = new Scanner(System.in);
        String number, name;
        double pay; 
        int hours;
        PartTimeEmployee emp;

        // get the details from the user
        System.out.print("Employee Number? ");
        number = keyboardString.nextLine();
        System.out.print("Employee's Name? ");
        name = keyboardString.nextLine();
        System.out.print("Hourly Pay? ");
        pay = keyboard.nextDouble();
        System.out.print("Hours worked this week? ");
        hours = keyboard.nextInt();

        // create a new part-time employee
        emp = new PartTimeEmployee(number, name, pay);

        // display part-time employee's details, including the weekly pay
        System.out.println();

        // the next two methods have been inhreted from the Employee class
        System.out.println(emp.getName());
        System.out.println(emp.getNumber());

        System.out.println(emp.calculateWeeklyPay(hours));
    }
}


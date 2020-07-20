import java.util.Scanner;

public class SecretAgents
{
    public static void main(String[] args)
    {
        int security;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("***Secret Agents***");
        System.out.println("Enter security level (1,2,3)");
        security = keyboard.nextInt();
        switch(security) // check level of security
        {
            case 1: System.out.println("The code to access the safe is 007."); // level 3 security
            case 2: System.out.println("Jim Kitt is really a double agent."); // level 2 security
            case 3: System.out.println("Martinis in the hotel bar may be poisoned."); // level 1 security
            break; // necessary to avoid error message below
            default: System.out.println("No such security level.");
        } 
    }
}

import java.util.Scanner;

public class StringCheckWithSwitch
{
    public static void main(String[] args)
    {
       Scanner keyboard = new Scanner (System.in);
       String symbol;
       // get symbol from user
       System.out.println("Enter the symbol(square/circle/triangle)");
       symbol = keyboard.next();
       // use String object in switch
       switch(symbol)
       {
            case "square": System.out.println("ATTACK"); break;
            case "circle": System.out.println("BLOCK"); break;
            case "triangle": System.out.println("JUMP"); break;
            default: System.out.println("Invalid Choice");
       }
    }
}

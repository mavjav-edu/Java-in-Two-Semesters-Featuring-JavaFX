
import java.util.Scanner;

public class TimetableVersion2
{
    public static void main(String[] args)
    {
          char group; // to store the tutorial group
          Scanner keyboard = new Scanner(System.in);
          System.out.println("***Lab Times***"); // display header
          System.out.println("Enter your group (A,B,C)");
          group = keyboard.next().charAt(0);

          if (group == 'A')
          {
                System.out.println("10.00 a.m");
          }
          else if (group == 'B')
          {
                System.out.println("1.00 p.m");
          }
          else if(group == 'C')
          {
                System.out.println("11.00 a.m");
          }
          else
          {
                System.out.println("No such group");
          }
    }
}

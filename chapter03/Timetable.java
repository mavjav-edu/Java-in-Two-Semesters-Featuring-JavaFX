
import java.util.Scanner;

public class Timetable
{
    public static void main(String[] args)
    {
          char group; // to store the tutorial group
          Scanner keyboard = new Scanner(System.in);
          System.out.println("***Lab Times***"); // display header
          System.out.println("Enter your group (A,B,C)");
          group = keyboard.next().charAt(0);
          // check tutorial group and display appropriate time
          if (group == 'A')
          {
              System.out.print("10.00 a.m"); // lab time for group A
          }
          else
          {
              if (group == 'B')
              {
                  System.out.print("1.00 p.m"); // lab time for group B
              }
              else
              {
                  if (group == 'C')
                  {
                      System.out.print("11.00 a.m"); // lab time for group C
                  }
                  else
                  {
                      System.out.print("No such group"); // invalid group
                  }
              }
          }
    }
}



import java.util.Scanner;
public class DisplayResult2
{
    public static void main(String[] args)
    {
        int mark;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What exam mark did you get?");
        mark = keyboard.nextInt();
        // input validation
        while (mark < 0 || mark > 100) // check if mark is invalid
        {
            // display error message
            System.out.println("Invalid mark: please re-enter");
            // mark must be re-entered
            mark = keyboard.nextInt();
        }
        // by this point loop is finished and mark will be valid
        if (mark >= 40)
        {
            System.out.println("Congratulations, you passed");
        }
        else
        {
            System.out.println("I'm sorry, but you failed");
        }
        System.out.println("Good luck with your other exams");
    }
}

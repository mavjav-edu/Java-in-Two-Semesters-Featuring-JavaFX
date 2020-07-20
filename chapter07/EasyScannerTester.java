public class EasyScannerTester
{
    public static void main(String[] args)
    {
        System.out.print("Enter a double: ");
        double d = EasyScanner.nextDouble(); // to read a double
        System.out.println("You entered: " + d);
        System.out.println();

        System.out.print("Enter an integer: ");
        int i = EasyScanner.nextInt(); // to read an int
        System.out.println("You entered: " + i);
        System.out.println();

        System.out.print("Enter a string: ");
        String s = EasyScanner.nextString(); // to read a string
        System.out.println("You entered: " + s);
        System.out.println();

        System.out.print("Enter a character: ");
        char c = EasyScanner.nextChar(); // to read a character
        System.out.println("You entered: " + c);
        System.out.println();
    }
}

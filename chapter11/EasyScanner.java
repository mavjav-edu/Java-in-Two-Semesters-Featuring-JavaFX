import java.util.Scanner;

public class EasyScanner
{
	public static int nextInt()
	{
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		return i;
	}
	
	public static double nextDouble()
	{
		Scanner sc = new Scanner(System.in);
		double d = sc.nextDouble();
		return d;
	}
	
	public static String nextString()
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	public static char nextChar()
	{
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		return c;
	}
}

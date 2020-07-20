
import java.util.Scanner;

public class BankAccountTester
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		double amount;
		boolean ok;
		
		BankAccount account1 = new BankAccount("99786754","Susan Richards");
		
		System.out.print("Enter amount to deposit: ");
		amount = keyboard.nextDouble();
		account1.deposit(amount);
		System.out.println("Deposit was made");
		System.out.println("Balance  = " + account1.getBalance());
		System.out.println();
		
		
		System.out.print("Enter amount to withdraw: ");
		amount = keyboard.nextDouble();
		ok = account1.withdraw(amount);  // get the return value of the withdraw method
		if(ok)
		{
			System.out.println("Withdrawal made");
		}
		else
		{
			System.out.println("Insufficient funds");
		}
		System.out.println("Balance  = " + account1.getBalance());
		System.out.println();
	}
}


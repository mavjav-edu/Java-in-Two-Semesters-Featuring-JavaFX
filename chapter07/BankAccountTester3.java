
import java.util.ArrayList;

public class BankAccountTester3
{
    public static void main(String[] args)
    {
        // create an array of references
        ArrayList<BankAccount> accountList = new ArrayList<>();
        
        // create three new accounts, referenced by each element in the array
        accountList.add(new BankAccount("99786754","Susan Richards"));
        accountList.add(new BankAccount("44567109","Delroy Jacobs"));
        accountList.add(new BankAccount("46376205","Sumana Khan"));
        
        // make various deposits and withdrawals
        accountList.get(0).deposit(1000);
        accountList.get(2).deposit(150);
        accountList.get(0).withdraw(500);
        
        // print details of all three accounts
        for(BankAccount item : accountList)
        {
            System.out.println("Account number: " + item.getAccountNumber());
            System.out.println("Account name: " + item.getAccountName());
            System.out.println("Current balance: " + item.getBalance());
            System.out.println();
        }
    }
}


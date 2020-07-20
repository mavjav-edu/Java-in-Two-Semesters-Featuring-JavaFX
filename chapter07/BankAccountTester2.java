
public class BankAccountTester2
{
    public static void main(String[] args)
    {
        // create an array of references
        BankAccount[] accountList = new BankAccount[3];
        // create three new accounts, referenced by each element in the array
        accountList[0] = new BankAccount("99786754","Susan Richards");
        accountList[1] = new BankAccount("44567109","Delroy Jacobs");
        accountList[2] = new BankAccount("46376205","Sumana Khan");
        
        // make various deposits and withdrawals
        accountList[0].deposit(1000);
        accountList[2].deposit(150);
        accountList[0].withdraw(500);
        
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


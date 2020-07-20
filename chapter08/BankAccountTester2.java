
public class BankAccountTester2
{
    public static void main(String[] args)
    {
        // create a bank account
        BankAccount2 account1 = new BankAccount2("99786754","Gayle Forcewind");
        // create another bank account
        BankAccount2 account2 = new BankAccount2("99887776","Stan Dandy-Liver");
        // make a deposit into the first account
        account1.deposit(1000);
        // make a deposit into the second account
        account2.deposit(2000);
        // set the interest rate
        BankAccount2.setInterestRate(10);
        // add interest to accounts
        account1.addInterest();
        account2.addInterest();
        // display the account details
        System.out.println("Account number: " + account1.getAccountNumber());
        System.out.println("Account name: " + account1.getAccountName());
        System.out.println("Interest Rate " + BankAccount2.getInterestRate());
        System.out.println("Current balance: " + account1.getBalance());
        System.out.println(); // blank line
        System.out.println("Account number: " + account2.getAccountNumber());
        System.out.println("Account name: " + account2.getAccountName());
        System.out.println("Interest Rate " + BankAccount2.getInterestRate());
        System.out.println("Current balance: " + account2.getBalance());
    }
}


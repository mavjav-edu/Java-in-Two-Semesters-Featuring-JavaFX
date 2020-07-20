
public class BankAccount
{
    // the attributes
    private String accountNumber;
    private String accountName;
    private double balance;

    // the methods

    // the constructor
    public BankAccount(String numberIn, String nameIn)
    {
        accountNumber = numberIn;
        accountName = nameIn;
        balance = 0;
    }

    
    // the copy constructor
       public BankAccount(BankAccount accIn)
        {
            accountNumber = accIn.accountNumber; // copy account number
            accountName = accIn.accountName; // copy account name
            balance = accIn.balance; // copy account balance
        }
    
    // methods to read the attributes
    public String getAccountName()
    {
        return accountName;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    // methods to deposit and withdraw money
    public void deposit(double amountIn)
    {
        balance = balance + amountIn;
    }
    
    public boolean withdraw(double amountIn)
    {
        if(amountIn > balance)
        {
            return false; // no withdrawal was made
        }
        else
        {
            balance = balance - amountIn;
            return true; // money was withdrawn successfully
        }
    }
    
    @Override
    public String toString()
    {
        return accountNumber + ", " + accountName + ", " + balance;
    }
}


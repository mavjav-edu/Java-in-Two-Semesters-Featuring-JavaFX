public class ParameterTest
{
    public static void main(String[] args)
    {
        // create new bank account
        BankAccount testAccount = new BankAccount("1", "Ann T Dote");
        test(testAccount); // send the account to the test method
        System.out.println("Account Number: " + testAccount.getAccountNumber());
        System.out.println("Account Name: " + testAccount.getAccountName());
        System.out.println("Balance: " + testAccount.getBalance());
    }

    // a method that makes a deposit in the bank account
    static void test(BankAccount accountIn)
    {
        accountIn.deposit(2500);
    }
}

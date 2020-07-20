
public class CopyConstructorDemo 
{
    public static void main(String[] args) 
    {
        BankAccount b1 = new BankAccount ("001", "Justin Thyme"); // balance zero
        b1.deposit(100); // balance 100
        System.out.println("first object "+b1); 
        BankAccount b2 = new BankAccount(b1); // create copy via copy constructor
        System.out.println("second object "+b2);// display copy
        b1.withdraw(50);// modify original object
        System.out.println("first object "+b1);
        System.out.println("second object "+b2);// second object untouched
    }
}


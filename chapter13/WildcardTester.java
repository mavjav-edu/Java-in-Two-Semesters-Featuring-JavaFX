public class WildcardTester
{
    public static void main(String[] args)
    {
                
               SimpleGenericClass<BankAccount> object1 = new SimpleGenericClass<>();
               SimpleGenericClass<CheckableBankAccount> object2 = new SimpleGenericClass<>();
               
               object1.setValue(new BankAccount("12345678", "Smith"));
               object2.setValue(new CheckableBankAccount("87654321", "Jones"));
                
               helper(object1);
               helper(object2);
    }
    
    public static void helper(SimpleGenericClass<? extends BankAccount> objectIn) // uses a wildcard
    {
        System.out.println(objectIn.getValue().getAccountName());
    }   
}


public class RuntimeExceptionDemo 
{
    public static void main(String[] args) 
    {
        try
        {
            System.out.print("Enter size of list: ");
            int size = EasyScanner.nextInt();  // we are using our EasyScanner here
            PaymentList p = new PaymentList(size); // can now throw RuntimeException
        }
        catch(RuntimeException e) // catch exception from PaymentList constructor
        {
            System.out.println(e); // display exception object
        }
	 System.out.println("END OF DEMO");   
	     
    }
} 


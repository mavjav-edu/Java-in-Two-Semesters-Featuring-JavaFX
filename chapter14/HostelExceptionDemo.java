public class HostelExceptionDemo 
{
    public static void main(String[] args) 
    {
        try
        {
            System.out.print("Enter size of list: ");
            int size = EasyScanner.nextInt();
            PaymentList p = new PaymentList(size); // can now throw HostelException
        }
        catch(HostelException e) // catch exception from PaymentList constructor
        {
            System.out.println(e); // display exception object
        }
	 catch (Exception e) // note general catch caluse added 
        {
            System.out.println("Some unforseen error"); 
            e.printStackTrace();
        }
	 System.out.println("END OF DEMO"); 	     
    }
} 

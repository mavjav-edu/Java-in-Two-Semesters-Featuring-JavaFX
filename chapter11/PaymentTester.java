// a very simple driver program that makes use of the toString method

public class PaymentTester
{
	
	public static void main(String[ ] args)
	{
		Payment p1 = new Payment ("January", 175); // create object to test
				
		System.out.println(p1); // this will call the toString method in our Payment class 
	}	
}

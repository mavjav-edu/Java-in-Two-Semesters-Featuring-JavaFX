
import java.util.ArrayList;

/** Collection class to hold a list of Payment objects
 *  @author Charatan and Kans
 *  @version 4th April 2018
 */
public class PaymentList  
{
   // attributes
   private ArrayList<Payment> pList;
   public final int MAX;
        
   /** Constructor initialises the empty payment list and sets the maximum list size 
    *  @param   maxIn: The maximum number of payments in the list
    */
	public PaymentList(int maxIn)
	{  
            pList = new ArrayList<>();	
            MAX = maxIn;
	}
	
   /** Checks if the payment list is full
    *  @return Returns true if the list is full and false otherwise 
    */	
	public boolean isFull()
	{
            return pList.size()== MAX;
	}
        
   /** Gets the total number of payments 
    *  @return Returns the total number of payments currently in the list 
    */
    public int getTotal()
	{       
            return pList.size();
	}        
       	    
   /** Adds a new payment to the end of the list
	 *  @param  pIn: The payment to add
	 *  @return Returns true if the object was added successfully and false otherwise
	 */
    public boolean addPayment(Payment pIn)
	{
		if(!isFull())
		{
              pList.add(pIn);
              return true;
		}
		else
		{
              return false;
		}
	}      
     
   /** Reads the payment at the given position in the list
	 *  @param     positionIn: The logical position of the payment in the list
	 *  @return    Returns the payment at the given logical position in the list
	 *             or null if no payment at that logical position
	 */
    public Payment getPayment(int positionIn)
	{   
    	//check for valid logical position
       if (positionIn <1 || positionIn > getTotal())
       {
				// no object found at given position
				return null;
       }
       else
       {
				// take one off logical position to get ArrayList position
			   return pList.get(positionIn - 1);
       }
	}        
	
	/** Calculates the total payments made by the tenant 
    *  @return  Returns the total value of payments recorded 
    */
	public double calculateTotalPaid()
	{
       double totalPaid = 0; // initialize totalPaid
       // loop through all payments
       for (Payment p: pList)
       {  
       		// add current payment to running total
			 	totalPaid = totalPaid + p.getAmount();
       }
       return totalPaid;
	}
                   
   @Override
	public String toString()
   {
            return pList.toString();
   }
}


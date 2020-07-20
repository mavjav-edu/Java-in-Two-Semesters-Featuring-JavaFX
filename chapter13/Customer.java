
public class Customer 
{
	private String customerId;
        private String name;
        private double creditLimit;
	
       
	public Customer(String IdIn, String nameIn, double limitIn)
	{
		customerId = IdIn;
                name = nameIn;
                creditLimit = limitIn;   
	}
	
	public String getCustomerId()
	{
		return customerId;
	}
		
        public String getName()
	{
		return name;
	}
        
        public double getCreditLimit()
	{
		return creditLimit;
	}
        
        public void setCreditLimit(double limitIn)
	{
		creditLimit = limitIn;
	}

}


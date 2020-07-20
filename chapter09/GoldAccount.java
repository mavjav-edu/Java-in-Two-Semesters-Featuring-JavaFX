public class GoldAccount extends BankAccount
{
	private double overdraftLimit;
	
	public GoldAccount(String numberIn, String nameIn, double limitIn)
	{		
		super(numberIn, nameIn);
		overdraftLimit = limitIn;
	}
	
	public void setLimit(double limitIn)
	{
		overdraftLimit = limitIn;
	}
	
	
	public double getLimit()
	{
		return overdraftLimit;
	}

	@Override
	public boolean withdraw(double amountIn)
	{
		if(amountIn > balance + overdraftLimit) // the customer can withdraw up to the overdraft limit
		{
			return false; // no withdrawal was made
		}
		else
		{
			balance = balance - amountIn; // balance is protected so we have direct access to it
			return true; // money was withdrawn successfully
		}
	}
}
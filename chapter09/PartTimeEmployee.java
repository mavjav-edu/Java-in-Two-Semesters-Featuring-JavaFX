public class PartTimeEmployee extends Employee // this class is a subclass of Employee 
{
	private double hourlyPay; // this attribute is unique to the subclass

	// the constructor
	public PartTimeEmployee(String numberIn, String nameIn, double hourlyPayIn)
	{
		super(numberIn, nameIn); // call the constructor of the superclass
		hourlyPay = hourlyPayIn;
	}

	// these methods are also unique to the subclass
	public double getHourlyPay()
	{
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPayIn)
	{
		hourlyPay = hourlyPayIn;
	}

	public double calculateWeeklyPay(int noOfHoursIn)
	{
		return noOfHoursIn * hourlyPay;
	}
        
        @Override
        public String getStatus()
        {
            return "Part-Time";
        }

}

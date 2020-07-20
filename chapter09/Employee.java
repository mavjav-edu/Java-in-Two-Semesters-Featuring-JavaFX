public abstract class Employee
{
	private String number;
	private String name;
        
	public Employee(String numberIn, String nameIn)
	{
		number = numberIn;
		name = nameIn;
	}

	public void setName(String nameIn)
	{
		name = nameIn;
	}

	public String getNumber()
	{
		return number;
	}

	public String getName()
	{
		return name;
	}
        
        public abstract String getStatus();
}

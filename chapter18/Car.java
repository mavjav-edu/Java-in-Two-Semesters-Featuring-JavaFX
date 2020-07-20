
import java.io.Serializable;


public class Car implements Serializable
{
	private String registration;
	private String make;
	private double price;
	
	public Car(String registrationIn, String makeIn, double priceIn)
	{
		registration = registrationIn;
		make = makeIn;
		price = priceIn;
	}
	
	public String getRegistration()
	{
		return registration;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public double getPrice()
	{
		return price;
	}
}


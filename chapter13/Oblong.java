public class Oblong 
{

	private double length;
	private double height;
        
   
	public Oblong(double lengthIn, double heightIn)
	{
		length = lengthIn;
		height = heightIn;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setLength(double lengthIn)
	{
		length = lengthIn;
	}
	
	public void setHeight(double heightIn)
	{
		height = heightIn;
	}
	
	public double calculateArea()
	{
		return length * height;
	}
	
	public double calculatePerimeter()
	{
		return 2 * (length + height);
	}	
}

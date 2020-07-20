
public class Ball implements Calculatable
{
    private double radius;
    
    public Ball (double radiusIn)
    {
        radius = radiusIn;
    }
    
    @Override    
    public double calculateVolume()
    {
        // uses the constant PI and the method pow from the Java.Math package
        return (4 * Math.PI * Math.pow(radius, 3))/3;
    }       
}


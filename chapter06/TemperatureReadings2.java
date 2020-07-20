
import java.util.Scanner; 
public class TemperatureReadings2
{
    public static void main(String[] args)
    {
        double[] temperature;
        temperature = new double[7]; 
        enterTemps(temperature); // call method 
        displayTemps(temperature); // call method
    }
    // method to enter temperatures 
    static void enterTemps(double[] temperatureIn)
    {
        Scanner keyboard = new Scanner(System.in); 
        for (int i = 0; i < temperatureIn.length; i++)
        {
            System.out.println("enter max temperature for day " + (i+1)); 
            temperatureIn[i] = keyboard.nextDouble();
        }
    }

    // method to display temperatures 
    static void displayTemps(double[] temperatureIn)
    {
        System.out.println();
        System.out.println("***TEMPERATURES ENTERED***"); 
        System.out.println(); 
        for (int i = 0; i < temperatureIn.length; i++)
        {
            System.out.println("day "+(i+1)+" "+ temperatureIn[i]);
        }
    }
}


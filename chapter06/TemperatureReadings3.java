import java.util.Scanner; 
public class TemperatureReadings3
{
    public static void main(String[] args)
    {
        double[] temperature ; 
        temperature = enterTemps(); // call new version of this method 
        displayTemps(temperature);
    }

    // method to enter temperatures returns an array 
    static double[] enterTemps()
    { 
        Scanner keyboard = new Scanner(System.in); 
        double[] temperatureOut = new double[7]; 
        for (int i = 0; i < temperatureOut.length; i++)
        {
            System.out.println("enter max temperature for day " + (i+1)); 
            temperatureOut[i] = keyboard.nextDouble();
        }
        return temperatureOut;
    }

    // this method is unchanged 
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

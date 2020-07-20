
public class DisplayTemperaturesWithVarargs
{
    public static void main(String[] args)
    {
       double[] temperature = {7.5, 8.2, 7.7, 11.3, 10.75}; // create array with 5 readings
       System.out.println("Sending Array");
       displayTemps(temperature); // call method with a single array
		System.out.println();
		System.out.println("Sending individual items");
		displayTemps(7.5, 8.2, 7.7, 11.3, 10.75); // call method with 5 individual readings
		displayTemps(9.9); // call method with 1 value only
		displayTemps( ); // call method with no values
    }
    
    // method to display temperatures using varargs
    static void displayTemps(double... temperatureIn)
    {
        System.out.println();
        System.out.println("***TEMPERATURES***"); 
        System.out.println("Number of temperatures: "+ temperatureIn.length); // count items
        // display temperatures
        for (int i = 0; i < temperatureIn.length; i++)
        {
            System.out.println(temperatureIn[i]+ "  ");
        }
    }
}


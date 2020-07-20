
import  java.util.Scanner;  

public  class  TemperatureReadings
{
    public  static  void  main(String[]  args)
    {
        Scanner  keyboard  =  new  Scanner(System.in);
        // create array 
        double[]  temperature;
        temperature  =  new  double[7];
        // enter temperatures 
        for  (int  i  =  0;  i  <  temperature.length;  i++)
        {
            System.out.println("enter  max  temperature  for  day  "  +  (i+1));  
            temperature[i]  =  keyboard.nextDouble();
        }
        // display temperatures 
        System.out.println();  // blank line 
        System.out.println("***TEMPERATURES  ENTERED***");  
        System.out.println();  // blank line 
        for  (int  i  =  0;  i  <  temperature.length;  i++)
        {
            System.out.println("day  "+(i+1)+"  "+  temperature[i]);
        }
    }
}


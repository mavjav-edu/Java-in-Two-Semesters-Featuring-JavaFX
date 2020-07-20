
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextFileTester
{
	public static void main(String[] args)
	{
		char choice;

		// create an empty list to hold Cars
		List<Car> carList = new ArrayList<>();

		// read the list from file when the program starts
		readList(carList);

		// menu options
		do
		{
			System.out.println("\nText File Tester");
			System.out.println("1. Add a car");
			System.out.println("2. Remove a car");
			System.out.println("3. List all cars");
			System.out.println("4. Quit\n");
			choice = EasyScanner.nextChar();
			System.out.println(); switch(choice)
			{
				case '1' :	addCar(carList);
							break;
				case '2' :	removeCar(carList);
							break;
				case '3' :	listAll(carList);
							break;
				case '4' :	writeList(carList); // write to the file
							break;
				default : System.out.print("\nPlease choose a number from 1 - 4 only\n ");
			}
		}while(choice != '4');
	}
	
	// method for adding a new car to the list
	static void addCar(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		
		System.out.print("Please enter the registration number: ");
		tempReg = EasyScanner.nextString();
		System.out.print("Please enter the make: ");
		tempMake = EasyScanner.nextString();
		System.out.print("Please enter the price: ");
		tempPrice = EasyScanner.nextDouble();
		carListIn.add(new Car(tempReg, tempMake, tempPrice));
	}
	
	/* method for removing a car from the list - in a real application this would need to include 
      some validation */
	static void removeCar(List<Car> carListIn)
	{
		int pos;
		System.out.print("Enter the position of the car to be removed: ");
		pos = EasyScanner.nextInt();
		carListIn.remove(pos - 1);
	}
	
	// method for listing details of all cars in the list
	static void listAll(List<Car> carListIn)
	{
		for(Car item : carListIn)
		{
			System.out.println(item.getRegistration()
			+ " "
			+ item.getMake()
			+ " "
			+ item.getPrice());
		}
	}
	
	// method for writing the file
	static void writeList(List<Car> carListIn)
	{
       // use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, carFile, that handles the low-level details of writing 
              the list to a file which we have called "Cars.txt" */
			    FileWriter carFile = new FileWriter("Cars.txt");
			    /* now create a PrintWriter object to wrap around carFile; this allows us to user 
              high-level functions such as println */
			    PrintWriter carWriter = new PrintWriter(carFile);
		   )
		{	
			// write each element of the list to the file 
			for(Car item : carListIn)
			{
			   carWriter.println(item.getRegistration());
			   carWriter.println(item.getMake());
			   carWriter.println(item.getPrice()); // println can accept a double, and write it as a string
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		}
	}
	
	// method for reading the file
	static void readList(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		String tempStringPrice;
		double tempDoublePrice;

		// use try-with-resources to ensure file is closed safely
		try(
					/* create a FileReader object, carFile, that handles the lowlevel details of reading
                 the list from the "Cars.txt" file */
			       FileReader carFile = new FileReader("Cars.txt");
			       /* now create a BufferedReader object to wrap around carFile; this allows us to user 
                 high-level functions such as readLine */
                 BufferedReader carStream = new BufferedReader(carFile);
			)
		{
			// read the first line of the file 
			tempReg = carStream.readLine();
			/* read the rest of the first record, then all the rest of the records until the end of 
             the file is reached */
			while(tempReg != null) // a null string indicates end of file
			{
				tempMake = carStream.readLine();
				tempStringPrice = carStream.readLine();
				// as this is a text file we have to convert the price to double
				tempDoublePrice = Double.parseDouble(tempStringPrice);
				carListIn.add(new Car(tempReg, tempMake, tempDoublePrice));
				tempReg = carStream.readLine();
			}
		}
		
		// handle the exception that is thrown by the FileReader constructor if the file is not found
		catch(FileNotFoundException e)
		{
			System.out.println("\nNo file was read");
		}
		
		// handle the exception thrown by the FileReader methods
		catch(IOException e)
		{
			System.out.println("\nThere was a problem reading the file");
		}
	}
}


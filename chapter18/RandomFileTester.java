
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileTester
{
	static final int CAR_SIZE = 32; // each record will be 32 bytes
	
	public static void main(String[] args)
	{
		char choice;
		do
		{
			System.out.println("\nRandom File Tester");
			System.out.println("1. Add a car");
			System.out.println("2. Display a car");
			System.out.println("3. Quit\n");
			choice = EasyScanner.nextChar();
			System.out.println();
			switch(choice)
			{
				case '1' :	addCar();
							break;
				case '2' :	displayCar();
							break;
				case '3' :	break;
				default : System.out.print("\nChoose 1 - 3 only please\n ");
			}
		}while(choice != '3');
	}
	
    static void addCar()
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		System.out.print("Please enter the registration number: ");
		tempReg = EasyScanner.nextString();
		
		if(tempReg.length() > 10) //limit the registration number to 10 characters
		{
			System.out.print("Ten characters only - please re-enter: ");
			tempReg = EasyScanner.nextString();
		}
		// pad the string with spaces to make it exactly 10 characters long 
		for(int i = tempReg.length() + 1 ; i <= 10 ; i++)
		{
			tempReg = tempReg.concat(" ");
		}
	
		// get the make of the car from the user
		System.out.print("Please enter the make: ");
		tempMake = EasyScanner.nextString();
		
		// limit the make number to 10 characters
		if(tempMake.length() > 10)
		{
			System.out.print("Ten characters only - please re-enter: ");
			tempMake = EasyScanner.nextString();
		}
		// pad the string with spaces to make it exactly 10 characters long
		for(int i = tempMake.length() + 1; i <= 10; i++)
		{
			tempMake = tempMake.concat(" ");
		}
		
		// get the price of the car from the user 
		System.out.print("Please enter the price: ");
		tempPrice = EasyScanner.nextDouble();
		
		// write the record to the file
		writeRecord(new Car(tempReg, tempMake, tempPrice));
	}
	
	static void displayCar()
	{
		int pos;
		// get the position of the item to be read from the user
		System.out.print("Enter the car's position in the list: ");
		pos = EasyScanner.nextInt(); // read the record requested from file
		Car tempCar = readRecord(pos);
		if(tempCar != null)
		{
			System.out.println(tempCar.getRegistration().trim()
			+ " "
			+ tempCar.getMake().trim()
			+ " "
			+ tempCar.getPrice());
		}
		else
		{
			System.out.println("Invalid postion") ;
		}
	}
		
  	static void writeRecord(Car tempCar)
	{
       // use try-with-resources to ensure file is closed safely
		try(			
              // open a RandomAccessFile in read-write mode
			    RandomAccessFile carFile = new RandomAccessFile("Cars.rand", "rw");
          )
		{

			// move the pointer to the end of the file
			carFile.seek(carFile.length());
			// write the three fields of the record to the file
			carFile.writeUTF(tempCar.getRegistration());
			carFile.writeUTF(tempCar.getMake());
			carFile.writeDouble(tempCar.getPrice());
		}
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		}
	}
	
   	static Car readRecord(int pos)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		Car tempCar = null; // a null value is returned if there is a problem reading the record 
                
       // use try-with-resources to ensure file is closed safely
		try(
             // open a RandomAccessFile in read-only mode
			   RandomAccessFile carFile = new RandomAccessFile("Cars.rand","r");
          )
		{
			
			// move the pointer to the start of the required record
			carFile.seek((pos-1) * CAR_SIZE);
			// read the three fields of the record from the file
			tempReg = carFile.readUTF();
			tempMake = carFile.readUTF();
			tempPrice = carFile.readDouble();
			// use the data just read to create a new Car object
			tempCar = new Car(tempReg, tempMake, tempPrice);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("\nNo file was read");
		}
		
		catch(IOException e)
		{
			System.out.println("There was a problem reading the file");
		}
		// return the record that was read
		return tempCar;
	}
}


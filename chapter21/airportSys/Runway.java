
package airportSys; // add class to package
import java.io.Serializable;

/**
* This class is used to store details of a single runway.
*
* @author Charatan and Kans
* @version 1st August 2018
*/
public class Runway implements Serializable
{
// attributes
private int number;
private boolean allocated;

/**
 * Constructor sets the runway number
 * @param 	numberIn 	Used to set the runway number
 * @throws 	AirportException 	When the runway number is less than 1
 */
public Runway (int numberIn) 
{
if (numberIn <1)
	{
	throw new AirportException ("invalid runway number "+numberIn);
	}
number = numberIn;
allocated = false; // runway vacant initially
}

/**
* Returns the runway number
*/
public int getNumber()
{
return number;
}

/**
* Checks if the runway has been allocated
* @return 	Returns true if the runway has been allocated and false otherwise
*/
public boolean isAllocated()
{
return allocated;
}

/**
* Records the runway as being booked
*/
public void book()
{
	allocated = true;
}

/**
 * Records the runway as being vacant
 */
public void vacate()
{
allocated = false;
}
}


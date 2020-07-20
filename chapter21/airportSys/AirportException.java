
package airportSys; // add to package

/**
* Application Specific Exception
*
* @author Charatan and Kans
* @version 1st August 2018
*/
public class AirportException extends RuntimeException
{
/**
* Default Constructor
*/
public AirportException ()
{
super("Error: Airport System Violation");
}

/**
* Constructor that accepts an error message
*/
public AirportException (String msg)
{
super(msg);
}
}


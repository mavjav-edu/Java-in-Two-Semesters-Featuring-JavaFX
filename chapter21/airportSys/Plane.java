package airportSys;

import java.io.Serializable;

/**
 * This class stores the details of a single plane
 * 
 * @author Charatan and Kans 
 * @version 2nd August 2018
 */
public class Plane implements Serializable
{
  
  // attributes
  private String flightNumber;
  private String city;
  private PlaneStatus status;
  private Runway theRunway; // to implement Runway association

  // methods

  /**
   * Constructor sets initial flight details of the plane requesting registration
   *
   * @param	flightIn		The flight number of the plane to register
   * @param	cityOfOrigin	The city of origin of the plane to register
   */
  public Plane(String flightIn, String cityOfOrigin)
  {
    flightNumber = flightIn;
    city = cityOfOrigin;
    status = PlaneStatus.DUE; // initial plane status set to DUE
    theRunway = null; // indicates no runway allocated
  }

  /**
   * Returns the plane's flight number
   */
  public String getFlightNumber()
  {
    return flightNumber;
  }

  /**
   * Returns the city associated with the flight
   */
  public String getCity()
  {
    return city;
  }

  /** 
   * Returns the current status of the plane
   */
  public PlaneStatus getStatus()
  {
    return  status;
  }

  /** 
   * Returns the runway allocated to this plane or null if no runway allocated
   */
  public Runway getRunway()
  {
    return  theRunway;
  }

  /**
   * Returns the runway number allocated to this plane
   * @throws    AirportException if no runway allocated
   */
  public int getRunwayNumber() 
  {
    if (theRunway == null)
    {
      throw new AirportException ("flight "+flightNumber+" has not been allocated a runway");
    }
    return theRunway.getNumber();
  }

  /**
   * Checks if the plane is allocated a runway
   * @return    Returns true if the plane has been allocated a runway 
   *            and false otherwise
   */
  public boolean isAllocatedARunway()
  {
    return theRunway!=null;
  }

  /**
   * Allocates the given runway to the plane
   *
   * @throws    	AirportException if runway parameter is null or runway already allocated
   */
  public void allocateRunway(Runway runwayIn)throws AirportException
  {
    if (runwayIn == null) // check runway has been sent
    {
      throw new AirportException ("no runway to allocate");
    }
    if (runwayIn.isAllocated())
    {
        throw new AirportException ("runway already allocate");
    }
    theRunway = runwayIn;
    theRunway.book();
  }

  /**
   * De-allocates the current runway
   *
   * @throws    AirportException if no runway allocated
   */
  public void vacateRunway()  
  {
    if (theRunway==null)
    {
    	throw new AirportException ("no runway allocated");
    }
    theRunway.vacate();
  }

  /**
   * Returns the String representation of the plane's status
   */  
  public String getStatusName()
  {
      return status.toString();
  }


  /**
   * Upgrades the status of the plane.
   */   
  public void upgradeStatus()  
  {
    switch(status)
    {
    	case DUE: status =PlaneStatus.WAITING; break;
    	case WAITING: status =PlaneStatus.LANDED; break;
    	case LANDED: status =PlaneStatus.DEPARTING; break;
    	case DEPARTING: throw new AirportException("Cannot upgrade DEPARTING status");
    }
  }

  /**
   * Changes the city associated with the plane
   */
  public void changeCity (String destination)
  {
    city = destination;
  }
  
  /**
  * Returns a string representation of a plane
  */ 
  @Override
  public String toString()
  {
  	String out =    "number: "+flightNumber+	"\tcity: "+city+	"\tstatus: "+status;
  	if (theRunway!=null)
  	{
            out = out +"\trunway: "+theRunway;
  	}
  	return out;
  }
  
  
  /**
   * Checks whether the plane is equal to the given object
   */ 
  @Override
  public boolean equals(Object objIn)
  {
  	if (objIn!=null)
  	{
            Plane p = (Plane)objIn;
            return p.flightNumber.equals(flightNumber);
  	}
  	else
  	{
            return false;
  	}
 } 
  
  /**
   * Returns a hashcode value 
   */ 
  @Override
  public int hashCode()
  {
  	return flightNumber.hashCode();
  }
}  
  

package airportSys;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException; 
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Class to provide the functionality of the airport system
 * 
 * @author Charatan and Kans
 * @version 4th August 2018
 */
public class Airport 
{

  // attributes
  private Map<String, Plane> planes;  // registered planes
  private List<String> circlingQ; //flight numbers of circling planes
  private Runway []runway; // runways allocated to the airport

  // methods

  /**
   * This Constructor allows airport data to be loaded from a file
   *
   * @param	filenameIn The name of the file
   * @throws 	IOException if problems with opening and loading given file
   * @throws 	ClassNotFoundException if objects in file not of the right type
   */
  public Airport(String filenameIn)throws IOException, ClassNotFoundException
  {
      load(filenameIn);
  }
  

  /**
   * This Constructor creates an empty collection of planes, 
   * and allocates runways to the airport
   *
   * @param	numIn The number of runways
   * @throws 	AirportException if negative runway number used
   */
  public Airport (int numIn)  
  {
    try
    {
        // intialise runways
        runway = new Runway [numIn]; 
        for (int i = 0; i<numIn; i++)
        {
          runway[i] = new Runway (i+1);
        }
        // initially no planes allocated to airport
        planes = new HashMap<>();
    	 circlingQ = new ArrayList<>();
    }
    catch (Exception e)
    {
        // notice throwing an excpetion from a catch clause  
		 throw new AirportException("Invalid Runway Number set, application closing");
    }
  }

  /**  
   * Registers a plane with the airport
   *
   * @param 	flightIn The plane's flight number 
   * @param	cityOfOrigin The plane's city of origin
   * @throws	AirportException if flight number already registered. 
   */
  public void registerFlight (String flightIn, String cityOfOrigin) 
  {
     if (planes.containsKey(flightIn))
     {
        throw new AirportException ("flight "+flightIn+" already registered");
     }
     Plane newPlane = new Plane (flightIn, cityOfOrigin);
     planes.put(flightIn, newPlane);
  }

   /**  
   * Records a plane arriving at the airport
   *
   * @param 	flightIn The plane's flight number
   * @throws	AirportException if plane not previously registered 
   *            or if plane already arrived at airport
   */
  public int arriveAtAirport (String flightIn) 
  {
     Runway vacantRunway = nextFreeRunway(); // get next free runway
     if (vacantRunway != null) // check if runway available
     {
        descend(flightIn, vacantRunway); // allow plane to descend on this runway
        return vacantRunway.getNumber(); // return booked runway number
     }
     else // no runway available
     {
        circle(flightIn); // plane must join circling queue
        return 0; // indicates no runway available to land
     }
  }

  /** 
   * Records a plane landing on a runway
   *
   * @param 	flightIn The plane's flight number
   * @param	runwayNumberIn The runway number the plane is landing on 	
   * @throws 	AirportException if plane not previously registered 
   *								or if the runway is not allocated to this plane
   *   							or if plane has not yet signalled its arrival at the aiport
   *								or if plane is already recorded as having landed.
   */
  public void landAtAirport (String flightIn, int runwayNumberIn)  
  {
    Plane thisPlane = getPlane(flightIn); // throws AirportException if not registered
    if (thisPlane.getRunwayNumber()!= runwayNumberIn)
    {
      throw new AirportException ("flight "+flightIn+" should not be on this runway");
    }
    if (thisPlane.getStatus()== PlaneStatus.DUE)
    {
      throw new AirportException ("flight "+flightIn+" not signalled its arrival");
    }
    if (thisPlane.getStatus().compareTo(PlaneStatus.WAITING)>0)
    {
      throw new AirportException ("flight "+flightIn+" already landed");
    }
    thisPlane.upgradeStatus(); // upgrade status from WAITING to LANDED
  }

  /** 
   * Records a plane boarding for take off
   *
   * @param 	flightIn The plane's flight number
   * @param	destination The city of destination 	
   * @throws 	AirportException 	 if plane not previously registered 
   *                            or if plane not yet recorded as landed 
   *                            or if plane already recorded as ready for take off
   */
  public void readyForBoarding(String flightIn, String destination)  
  {
    Plane thisPlane = getPlane(flightIn);// throws AirportException if not registered
    if (thisPlane.getStatus().compareTo(PlaneStatus.LANDED)<0)
    {
      throw new AirportException ("flight "+flightIn+" not landed");
    }
    if (thisPlane.getStatus()== PlaneStatus.DEPARTING)
    {
      throw new AirportException ("flight "+flightIn+" already registered to depart");
    }
    thisPlane.upgradeStatus(); // upgrade status from LANDED to DEPARTING
    thisPlane.changeCity(destination); // change city of origin to city of destination
  }

  /** 
   * Records a plane taking off from the aiprort
   *
   * @param 	flightIn The plane's flight number
   * @throws 	AirportException    	if plane not previously registered 
   *                              	or if plane not yet recorded as landed 
   *                              	or if the plane not previously recorded as taken off
   */
  public Plane takeOff (String flightIn)  
  {
    leave(flightIn); // remove from plane register
    Plane nextFlight = nextToLand(); // return next circling plane to land
    if (nextFlight != null) // check circling flight exists
    {
      Runway vacantRunway = nextFreeRunway(); 
      descend(nextFlight.getFlightNumber(), vacantRunway); // allocate runway to circling plane
      return nextFlight; // send back details of next plane to land
    }
    else // no circling planes
    {
      return null;
    }
  }


  /**
   * Returns the set of planes due for arrival
   */
  public Set<Plane> getArrivals()
  {
      Set<Plane> planesOut = new HashSet<>();
      Set<String> items = planes.keySet();
      for(String thisFlight: items)
      {
        Plane thisPlane = planes.get(thisFlight);
        if (thisPlane.getStatus() != PlaneStatus.DEPARTING)
        {
              planesOut.add(thisPlane); //add to set
        }
      }
      return planesOut;
  }

  /**
   * Returns the set of planes due for departure
   */
  public Set<Plane> getDepartures()
  {
      Set<Plane> planesOut = new HashSet<>();
      Set<String> items = planes.keySet();
      for(String thisFlight: items)
      {
        Plane thisPlane = planes.get(thisFlight);
        if (thisPlane.getStatus()==PlaneStatus.DEPARTING)
        {
              planesOut.add(thisPlane); // add to set
        }
      }
      return planesOut;
  }

  /**
   * Returns the number of runways
   */
  public int getNumberOfRunways()
  {
  	return runway.length;
  }  
  
  /** 
   * Saves airport object to file
   *
   * @param 	fileIn The name of the file
   * @throws 	IOException if problems with opening and saving to given file
   */
  public void save(String fileIn)throws IOException
  {
      // notice try-with-resources to ensure file closes safely
      try ( FileOutputStream fileOut = new FileOutputStream(fileIn);
            ObjectOutputStream objOut = new ObjectOutputStream (fileOut))
      {
          objOut.writeObject(planes);
          objOut.writeObject(circlingQ);
          objOut.writeObject(runway);
      }
  }

  /** 
   * Loads airport object from file
   *
   * @param 	fileName The name of the file
   * @throws 	IOException if problems with opening and loading given file
   * @throws 	ClassNotFoundException if objects in file not of the right type
   */
  public void load (String fileName) throws IOException, ClassNotFoundException
  {
      // notice try-with-resources to ensure file closes safely
      try ( FileInputStream fileInput = new FileInputStream(fileName);
            ObjectInputStream objInput = new ObjectInputStream (fileInput))
      {
          planes = (Map<String, Plane>) objInput.readObject();
          circlingQ = (List<String>) objInput.readObject();
          runway = (Runway[])objInput.readObject();
      }
  }


   // helper method to find next free runway
   private Runway nextFreeRunway()
   {
      for (Runway nextRunway : runway)
      {
          if (!nextRunway.isAllocated())
          {
              return nextRunway;
          }
      }
      return null;
   }

  /**  
   * Returns the registered plane with the given flight number
   *
   * @throws	AirportException if flight number not yet registered. 
   */
   private Plane getPlane(String flightIn)  
   {
   		if (!planes.containsKey(flightIn))
       {
          throw new AirportException ("flight "+flightIn+" has not yet registered");
       }
       return planes.get(flightIn);
    }
    
  /** 
   * Records a plane descending on a runway
   *
   * @param 	flightIn The plane's flight number
   * @param	runwayIn The runway the plane will be landing on 	
   * @throws 	AirportException    if plane not previously registered 
   *                              or if plane already arrived at airport
   *                              or if plane already allocated a runway 
   */
   private void descend (String flightIn, Runway runwayIn)  
   {
    Plane thisPlane = getPlane(flightIn);// throws AirportException if not registered
    if (thisPlane.getStatus().compareTo(PlaneStatus.WAITING)>0)
    {
        throw new AirportException 
			("flight "+flightIn+" already at airport has status of "+thisPlane.getStatusName());
    }
    if (thisPlane.isAllocatedARunway())
    {
    	throw new AirportException 
			("flight "+flightIn+" has already been allocated runway "+thisPlane.getRunwayNumber());
    }
    thisPlane.allocateRunway(runwayIn);
    if (thisPlane.getStatus()==PlaneStatus.DUE) // updraged status from DUE to WAITING
    {
        thisPlane.upgradeStatus();
    }
  }
  
  /**  
   * Records a plane joining the planes circling the airport
   *
   * @param 	flightIn The plane's flight number
   * @throws	AirportException if plane not previously registered 
   *								or if plane already arrived
   */
  private void circle (String flightIn)  
  {
    Plane thisPlane = getPlane(flightIn); // throws AirportException if not registered
    if (thisPlane.getStatus()!= PlaneStatus.DUE)
    {
      throw new AirportException ("flight "+flightIn+" already at airport");
    }
    thisPlane.upgradeStatus(); // updraged status from DUE to WAITING
    circlingQ.add(flightIn);
  }
  
  
  /** 
   * Records a plane taking off from the aiprort
   *
   * @param 	flightIn The plane's flight number
   * @throws 	AirportException if plane not plane not not previously registered
   *            		or if plane not yet recorded as landed 
   *					or if the plane has not previously been recorded as ready for take off
   */
  private void leave (String flightIn)  
  {
    // get plane associated with given flight number
    Plane thisPlane = getPlane(flightIn);// throws AirportException if not registered
    // throw exceptions if plane is not ready to leave airport
    if (thisPlane.getStatus().compareTo(PlaneStatus.LANDED)<0)
    {
      throw new AirportException ("flight "+flightIn+" not yet landed");
    }
    if (thisPlane.getStatus()==PlaneStatus.LANDED)
    {
        throw new AirportException ("flight "+flightIn+" must register to board");
    }
    // process plane leaving airport
    thisPlane.vacateRunway(); // runway now free
    planes.remove(flightIn); // remove plane from list
  }

  /**
   * Locates next circling plane to land
   *
   * @return    	Returns the next circling plane to land 
   *				or null if no planes
   */
  private Plane nextToLand() 
  {
    if (!circlingQ.isEmpty()) // check circling plane exists
    {
      String flight =  circlingQ.get(0);
      circlingQ.remove(flight);
      return getPlane(flight); // could throw exception of not in list
    }
    else // no circling plane
    {
      return null;
    }
  } 

}

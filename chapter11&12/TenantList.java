
import java.util.ArrayList;

/** Collection class to hold a list of tenants
 *  @author Charatan and Kans
 *  @version 6th April 2018
 */
public class TenantList  
{
    private ArrayList<Tenant> tList;
    public final int MAX;
        
    /** Constructor initialises the empty tenant list and sets the maximum list size 
     *  @param   maxIn The maximum number of tenants in the list
     */
    public TenantList(int maxIn)
    {
        tList = new ArrayList<>();
        MAX = maxIn;
    }
	
    /** Adds a new Tenant to the list
     *  @param  tIn The Tenant to add
     *  @return Returns true if the tenant was added successfully and false otherwise
     */
    public boolean addTenant(Tenant tIn)
    {
        if(!isFull())
        {
            tList.add(tIn);
            return true;
        }
        else
        {
            return false;
        }
    }
        
    /** Removes the tenant in the given room number
     *  @param roomIn The room number to of the tenant to remove
     *  @return Returns true if the tenant is removed successfully or false otherwise
     */
    public boolean removeTenant(int roomIn)
    {
        Tenant findT = search(roomIn); // call search method
        if (findT != null) // check tenant is found at given room
        {
            tList.remove(findT); // remove given tenant
            return true;
        }
        else
        {
            return false; // no tenant in given room
        }
    }       
       
    /** Searches for the tenant in the given room number
     *  @param roomIn The room number to search for
     *  @return Returns the tenant in the given room or null if no tenant in the given room
     */
    public Tenant search(int roomIn)
    {
        for(Tenant currentTenant: tList)
        {  
            // find tenant with given room number
            if(currentTenant.getRoom() == roomIn)
            {
                return currentTenant;
            }
        }
        return null; // no tenant found with given room number
    }
        
    /** Reads the tenant at the given position in the list
     *  @param      positionIn The logical position of the tenant in the list
     *  @return     Returns the tenant at the given logical position in the list
     *              or null if no tenant at that logical position
     */
    public Tenant getTenant(int positionIn)
    {
        if (positionIn<1 || positionIn>getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical poition to get ArrayList position
            return tList.get(positionIn -1);
        }
    }
 

	/** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return tList.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isFull()
    {
        return tList.size()== MAX;
    }
        
    /** Gets the total number of tenants 
     *  @return Returns the total number of tenants currently in the list 
     */
    public int getTotal()
    {       
        return tList.size();
    }
        
    @Override
    public String toString()
    {
        return tList.toString();
    }
}



import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo 
{
    public static void main(String[] args) 
    {
        Set<String> regNums = new HashSet<>();
        regNums.add("V53PLS"); 
        regNums.add("X85ADZ"); 
        regNums.add("L22SBG"); 
        regNums.add("W79TRV");
		 regNums.add("E16UEL");
        System.out.println("items before removing: " + regNums);
        // create an Iterator object
        Iterator<String> elements = regNums.iterator();
        // repeatedly retrieve items as long as there are items to be retrieved 
        while (elements.hasNext()) 
        { 
            String item = elements.next(); // retrieve next element from set 
            if (item.charAt(0) <= 'T') // check first letter of registration
            { 
                elements.remove(); // call Iterator method to remove registration
            }
        }
        System.out.println("items after removing: " + regNums);
    }
}


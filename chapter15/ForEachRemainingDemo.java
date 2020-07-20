
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ForEachRemainingDemo 
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
        Iterator<String> elements = regNums.iterator();
        // the lambda expression is applied to each remaining item in the collection
        elements.forEachRemaining ( item ->  
                                    {   
                                        if(item.charAt(0) <= 'T')
                                        {
                                            elements.remove();
                                        }
                                    } );
        System.out.println(regNums);
    }
}


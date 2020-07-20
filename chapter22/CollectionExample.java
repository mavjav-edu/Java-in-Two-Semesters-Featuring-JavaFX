
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionExample
{
    public static void main(String[] args)
    {
        // create an ArrayList of strings
        List<String> countryList = new ArrayList<>();
    
        countryList.add("Germany");
        countryList.add("France");
        countryList.add("Nigeria");
        countryList.add("Canada");
        countryList.add("India");
       
        // create a stream from the ArrayList
        Stream<String> countryStream = countryList.stream();
     
        // sort the stream data and save the result in a new ArrayList
       List<String> sortedList =  countryStream.sorted().collect(Collectors.toList());
    // Set<String> sortedList =  countryStream.sorted().collect(Collectors.toSet());
     //  Map<Character, String> map =  countryStream.sorted().collect(Collectors.toMap(s -> s.charAt(0), s -> s));
        
  //     System.out.println(map);       
      
        // display the sorted list        
      for(String item : sortedList)
        {
            System.out.println(item);
        } 
    }
}
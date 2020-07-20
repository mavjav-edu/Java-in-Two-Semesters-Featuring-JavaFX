
import java.util.Collections; 
import java.util.Arrays;
import java.util.List;

public class StringSortDemo 
{
    public static void main(String[] args) 
    {
        // create array of strings
        String[] citysArray = {"London", "Birmingham", "Manchester", "Liverpool"};
        // display array using Arrays.toString
        System.out.println("Original Array " + Arrays.toString(citysArray));
        // convert array to List using Arrays.asList
        List<String> citysList = Arrays.asList(citysArray);
        // display List
        System.out.println("Original List " + citysList);
        // sort array 
        Arrays.sort(citysArray);
        // display array 
        System.out.println("Sorted Array " + Arrays.toString(citysArray));
        // sort List 
        Collections.sort(citysList);
        // display List 
        System.out.println("Sorted List " + citysList);
     }
}


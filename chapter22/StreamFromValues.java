
import java.util.stream.Stream;

public class StreamFromValues
{
    public static void main(String[] args)
    {
        // create stream from values
        Stream<String> colours = Stream.of("Purple", "Blue", "Red", "Yellow", "Green");
        
        // filter the list and display strings of length 5 or more
        colours.filter(c -> c.length() >= 5).forEach(System.out::println);  
	 }
}



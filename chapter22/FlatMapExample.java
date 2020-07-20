

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapExample
{
    public static void main(String[] args)
    { 
        Stream<String> fileStream = Stream.empty(); // create empty stream
        
        try
        {
            fileStream = Files.lines(Paths.get("Poem.txt")); // file in current directory
        } 
        
        catch (IOException ex)
        {
        }
        
        // create a stream of individual words
        fileStream.flatMap(s -> Arrays.stream(s.split(" "))).forEach(System.out::println);
    }
}

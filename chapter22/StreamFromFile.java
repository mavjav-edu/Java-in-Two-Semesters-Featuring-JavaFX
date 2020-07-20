
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class StreamFromFile
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
           
        fileStream.forEach(System.out::println);
    }
}


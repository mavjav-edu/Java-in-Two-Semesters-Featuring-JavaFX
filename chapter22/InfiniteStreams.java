import java.util.stream.Stream;

public class InfiniteStreams
{
    public static void main(String[] args)
    {
        // an infinite stream of strings
        Stream<String> echo = Stream.generate(() -> "Hello world");
        echo.limit(10).forEach(s -> System.out.println(s));
        
        // an infinite stream of random numbers
        Stream<Double> randomNumbers = Stream.generate(() -> Math.random());
        randomNumbers.limit(10).forEach(System.out::println);
  
        // an infinite sequence
        Stream<Integer> sequence = Stream.iterate(1, n -> n+2);
        sequence.limit(5).forEach(System.out::println);
    }
}

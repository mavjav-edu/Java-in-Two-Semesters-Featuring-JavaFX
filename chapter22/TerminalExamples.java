
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;


public class TerminalExamples
{
    public static void main(String[] args)
    {
        // find the maximum of a stream of integers
        Optional<Integer>  maximumInt =  Stream.of(1, 2, 3, 11, 7, 8, 10).max(Comparator.naturalOrder());
        System.out.println("The maximum integer is " + maximumInt.get());

        // find the "minimum" of a stream of strings
        Optional<String>  minimumString =
                                Stream.of("banana", "apple", "apple", "orange").min(Comparator.naturalOrder());
        System.out.println("The first string alphabetically is " + minimumString.get());

        // find cheapest product from a stream of products
        Optional<Product> cheapestProduct =  
                                Stream.of(                                    
                                               new Product("1076543", "Acme", "Vacuum Cleaner", 180.11),
                                               new Product("3756354", "Nadir", "Washing Machine", 178.97),
                                               new Product("1234567", "Zenith", "Fridge", 151.98),
                                               new Product("7643210", "Wizz", "Dish Washer", 219.99)
                                          ).min(Comparator.comparingDouble(Product::getUnitPrice));
        System.out.println("The cheapest product is " + cheapestProduct.get());
                  
        // find the first in the list in a stream of doubles
        Optional<Double>  firstDouble =  Stream.of(1.6, 2.7, 6.8).findFirst();
        System.out.println("The first double in the list is " + firstDouble.get());  
        
        // find the sum of a stream of integers
        Optional<Integer>  sumOfIntegers =  Stream.of(1, 2, 3, 4, 5).reduce((x, y) -> x + y);     
        System.out.println("The sum of the integers is " + sumOfIntegers.get());  
        
        // find if a specific item is in the stream
        boolean  appleExists =  Stream.of("banana", "pear", "apple", "orange").anyMatch(s -> s.equals("apple"));
        if(appleExists)
        {
                System.out.println("apple is in the list");
        }
                        
    }
}

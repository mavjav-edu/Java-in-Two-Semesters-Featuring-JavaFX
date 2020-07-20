
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArray
{
    public static void main(String[] args)
    {
        // create an array of Products
        Product[] productList = { 
                                    new Product("1076543", "Acme", "Vacuum Cleaner", 180.11),
                                    new Product("3756354", "Nadir", "Washing Machine", 178.97),
                                    new Product("1234567", "Zenith", "Fridge", 151.98)
                                };
        
        // create a stream from the array
        Stream<Product> products = Arrays.stream(productList);
        
        products.forEach(System.out::println);   
    }
}  



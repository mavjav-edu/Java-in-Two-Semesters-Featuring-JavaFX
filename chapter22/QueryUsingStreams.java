
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class QueryUsingStreams
{
    public static void main(String[] args)
    {
        List<Product> productList = new ArrayList<>(); // create a list of products
  
        // add four products to the list
        productList.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
        productList.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
        productList.add(new Product("1234567", "Zenith", "Fridge", 151.98));
        productList.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));
   
        // display all items
        System.out.println("ALL ITEMS");
        Stream<Product>  stream = productList.stream();
      
        productList.stream().forEach(System.out::println);
           // productList.stream().forEach(pr -> System.out.println(pr));
        System.out.println();

        // filter the list and display items costing less than 170 
       // System.out.println("ITEMS UNDER 170");
      //  productList.stream().filter(pr -> pr.getUnitPrice() < 170).forEach(pr -> System.out.println(pr));    
          
        // count items costing less than 170
      //  long count = productList.stream().peek(s -> System.out.println(s)).filter(pr -> pr.getUnitPrice() < 170).count();
            
     //   System.out.println();
     //   System.out.println("There are " + count + " items costing less then 170");        
    }
}

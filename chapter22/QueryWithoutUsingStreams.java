
import java.util.ArrayList;
import java.util.List;


public class QueryWithoutUsingStreams
{
    public static void main(String[] args)
    {
     
        List<Product> productList = new ArrayList<>(); // create a list of products
        int count = 0;

        // add four products to the list
        productList.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
        productList.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
        productList.add(new Product("1234567", "Zenith", "Fridge", 151.98));
        productList.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));
   
        System.out.println("ALL ITEMS");
             
        // display all items
        for(Product pr : productList)
        {
            System.out.println(pr);
        }
     
        System.out.println();
        
        System.out.println("ITEMS COSTING LESS THAN 170");
        
        // display items costing less than 170
        for(Product pr : productList)
        {
            if(pr.getUnitPrice() < 170)
            {
                System.out.println(pr);
                count++;
            }
        }
            
        System.out.println();
        System.out.println("There are " + count + " items costing less then 170");
               
    }
}


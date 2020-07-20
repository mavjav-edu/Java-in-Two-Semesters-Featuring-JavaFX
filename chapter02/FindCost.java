/* a program to calculate the cost of a product after a sales tax has been added */

public class FindCost
{
     public static void main(String[] args)
     {
          double price, tax; 
          price = 500; 
          tax = 17.5; 
          price = price * (1 + tax/100);
     }
}

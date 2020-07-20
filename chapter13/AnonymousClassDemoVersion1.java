
public class AnonymousClassDemoVersion1
{
    public static void main(String[] args)
    {
       // create a test oblong      
       Oblong testOblong = new Oblong (8,8); 
          
       /* declare an object of an anonymous class that checks that an oblong's length
          and height are greater than zero */
       
       Checkable checkableObject1 = new Checkable()
          {
             @Override
             public boolean check()
             {
                   return testOblong.getLength() > 0 && testOblong.getHeight() > 0;
             }  
          };
       
      /* declare an object of an anonymous class that checks that an oblong's length
         and height are not equal */

      Checkable checkableObject2 = new Checkable()
         {
             @Override
             public boolean check()
             {
                   return testOblong.getLength() != testOblong.getHeight();
             }
               
         };

       // this checks that the sides are greater than zero
       System.out.println("checkableObject1 is " + checkValidity(checkableObject1));  

       // this checks that the length and height are not equal
       System.out.println("checkableObject2 is " + checkValidity(checkableObject2));    
    }
    
    private static String checkValidity(Checkable objectIn)
    {
        if(objectIn.check())
        {
            return "valid";
        }
        else
        {
            return "invalid";
        }
    }
}

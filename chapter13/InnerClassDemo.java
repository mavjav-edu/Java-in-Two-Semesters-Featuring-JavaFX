
public class InnerClassDemo
{
    public static void main(String[] args)
    {
       // inner class
       class CheckableOblong extends Oblong implements Checkable
       {
           public CheckableOblong(double lengthIn, double heightIn)
            {
                 super(lengthIn, heightIn);
            }

           @Override
            public boolean check() 
            {
		return getLength() > 0 && getHeight() > 0;
            }
       }
              
       Checkable oblong1 = new CheckableOblong(5, 0);  //invalid
       Checkable oblong2 = new CheckableOblong(5, 6);  // valid
       
       System.out.println("oblong1 is " + checkValidity(oblong1));
       System.out.println("oblong2 is " + checkValidity(oblong2));
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

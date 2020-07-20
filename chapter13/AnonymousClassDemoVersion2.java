
public class AnonymousClassDemoVersion2
{
    public static void main(String[] args)
    {
      
       // create a test oblong  
       Oblong oblong = new Oblong (8,8); 
          
       // this checks that the sides are greater than zero
       System.out.println("oblong is " + checkValidity(new Checkable()
                                    {
                                        @Override
                                        public boolean check()
                                        {
                                            return oblong.getLength() > 0 && oblong.getHeight() > 0; 
                                        }
                                    }
                                                            ));

       // this checks that the length and height are not equal
       System.out.println("oblong is " + checkValidity(new Checkable()
                                    {
                                        @Override
                                        public boolean check()
                                        {
                                            return oblong.getLength() != oblong.getHeight();
                                        }
                                    }
                                                           ));
       
   
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


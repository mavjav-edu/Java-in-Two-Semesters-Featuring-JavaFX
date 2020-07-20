
public class DoubleColonDemo 
{
    public static void main(String[] args)
    {
       // testMethod(System.out::println);
      //  testMethod(i -> Math.sqrt(i));
        testMethod(Math::sqrt);
    }
    
    private static void testMethod(DoubleColonInterface testObjectIn)
    {
        // testObjectIn.test("Hello world");
        System.out.println(testObjectIn.test(25));
    }
}




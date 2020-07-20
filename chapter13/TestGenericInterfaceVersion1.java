
import java.util.function.Function;

public class TestGenericInterfaceVersion1
{
    public static void main(String[] args)
    {
        Function<Integer, String> t = new Function <Integer, String>()
                                                {
                                                    @Override
                                                    public String apply(Integer i)
                                                    {  
                                                        return "You entered " + i;
                                                    }      
                                                 };
        System.out.println(t.apply(10));     
    }
}

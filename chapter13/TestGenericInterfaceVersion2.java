import java.util.function.Function;

public class TestGenericInterfaceVersion2
{
    public static void main(String[] args)
    {
        Function<Integer, String> str =  i -> "You entered " + i ;
        
        System.out.println(str.apply(10));     
    }
}

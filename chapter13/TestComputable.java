
public class TestComputable
{
    public static void main(String[] args)
    {
        Computable comp = (x, y) -> x + y ;
        printResult(comp);
    }
    
    public static void printResult(Computable compIn)
    {
        System.out.println(compIn.compute(10, 5));
    }
    
}


public class ParameterDemo
{
    public static void main(String[] args)
    {
        int x = 10; 
        demoMethod(x);
        System.out.println(x);
    }

    static void demoMethod(int xIn)
    {
        xIn = 25;
        System.out.println(xIn);
    }
}

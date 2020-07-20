public class TestGenericClass
{
    public static void main(String[] args)
    {
        SimpleGenericClass<Double> example1 = new SimpleGenericClass<>();
        SimpleGenericClass<String> example2 = new SimpleGenericClass<>();
        SimpleGenericClass<Oblong> example3 = new SimpleGenericClass<>();
       
        example1.setValue(10.0);
        example2.setValue("Hello");
        example3.setValue(new Oblong(5, 3));
        
        System.out.println(example1.getValue());
        System.out.println(example2.getValue());
        System.out.println(example3.getValue().calculateArea());     
    }
}

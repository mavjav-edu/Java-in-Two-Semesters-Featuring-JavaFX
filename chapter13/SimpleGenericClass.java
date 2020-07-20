
public class SimpleGenericClass<T> // the angle brackets indicate that this is a generic class
{
    private T value;
    
    public void setValue(T valueIn)
    {
        value = valueIn;
    }
    
    public T getValue()
    {
        return value;
    }
}

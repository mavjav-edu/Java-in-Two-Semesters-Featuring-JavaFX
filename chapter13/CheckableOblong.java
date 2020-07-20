
public class CheckableOblong extends Oblong implements Checkable
{
    //override the constructor
    public CheckableOblong(double lengthIn, double heightIn)
    {
        super(lengthIn, heightIn);
    }
    
    @Override
    public boolean check() // the check method of Checkable must be overridden
    {
        // the length and height must both be greater than zero
	 return getLength() > 0 && getHeight() > 0;
    }
}



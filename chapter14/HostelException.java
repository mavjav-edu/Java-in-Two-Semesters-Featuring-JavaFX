
public class HostelException extends RuntimeException
{
	public HostelException () // constructor without parameter
	{
		super("error in Hostel application");
	}

	public HostelException (String message)// constructor with parameter
	{
		super (message);
	}
}


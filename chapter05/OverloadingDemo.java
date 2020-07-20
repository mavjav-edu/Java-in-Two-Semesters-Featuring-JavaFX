public class OverloadingDemo
{
	public static void main(String[] args)
	{
		int maxOfTwo, maxOfThree;
		maxOfTwo = max(2, 10);      // call the first version of max
		maxOfThree = max(-5, 5, 3); // call the second version of max
		System.out.println(maxOfTwo);
		System.out.println(maxOfThree);
	}

	// this version of max accepts two integers and returns the greater of the two 
	static int max(int firstIn, int secondIn)
	{
		if(firstIn > secondIn)
		{
			return firstIn;
		}
		else
		{
			return secondIn;
		}
	}

	// this version of max accepts three integers and returns the greatest of the three 
	static int max(int firstIn, int secondIn, int thirdIn)
	{
		int result;
		result = firstIn;
		if(secondIn > result)
		{
			result = secondIn;
		}
		if(thirdIn > result)
		{
			result = thirdIn;
		}
		return result;
	}
}

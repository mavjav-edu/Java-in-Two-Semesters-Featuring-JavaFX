public class RaggedArray
{
	public static void main(String[] args)
	{
		// initialize ragged array
		char[][] animals = new char[][]
						{
							{'M', 'O', 'N', 'K', 'E', 'Y'}, // 6 columns
							{'C', 'A', 'T' }, // 3 columns
							{'B', 'I', 'R', 'D'} // 4 columns
						};
						
		for (int row = 0; row < animals.length; row++) //row number is fixed
		{
			for (int col = 0; col < animals[row].length; col++) // column number is variable
			{
				System.out.print(animals[row][col]); // display one character
			}
			System.out.println(); // new line after one row displayed
		}
	}	
}

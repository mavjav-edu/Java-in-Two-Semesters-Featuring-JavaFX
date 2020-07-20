
import java.io.IOException;

public class TestException
{
      public static int getInteger() throws IOException
   {
		byte [] buffer = new byte[512];
		System.in.read(buffer);
		String s = new String (buffer);
		s = s.trim();
		int num = Integer.parseInt(s);
		return num; // send back the integer value
   }
}

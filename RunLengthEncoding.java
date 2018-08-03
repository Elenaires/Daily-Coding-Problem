import java.util.*;
import java.lang.StringBuilder;

public class RunLengthEncoding
{
	public static void main(String[] args)
	{
		String input = "AAAABBBCCDAA";
		String encodedString = runLengthEncoding(input);

		System.out.println(encodedString);		
	}
	
	public static String runLengthEncoding(String input)
	{
		StringBuilder builder = new StringBuilder();
		
		int i = 0;
		int j = 1;
		int count = 1;

		while (j < input.length())
		{
			if(input.charAt(i) == input.charAt(j))
			{
				count++;
			}
			else
			{
				builder.append(count + String.valueOf(input.charAt(i)));
				count = 1;
				i = j;
			}
				
			j++;
		}

		builder.append(count + String.valueOf(input.charAt(i)));

		String encodedString  = builder.toString();

		return encodedString;
	}
}
					
								
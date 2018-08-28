import java.util.*;

public class BreakStringIntoTexts
{
	public static void main(String[] args)
	{
		String s = "I beautiful you are singing excessivel peculiar";
		int k = 18;
		List<String> myList = breakStringIntoTexts(s, k);
		
		if(myList == null)
		{
			System.out.println("Unable to break text");
		}
		
		else
		{
			for (String text : myList)
			{
				System.out.println(text);
			}
		}		
	}

	public static List<String> breakStringIntoTexts(String s, int k)
	{
		List<String> list = new ArrayList<>();

		String[] sArray = s.split(" ");

		/* if there is any word whose length is greater than k then
			we are unable to break the string up into k length text
			so we break out of the function */
		for(int i = 0; i < sArray.length; i++)
		{
			if(sArray[i].length() > k)
			{
				list = null;
				return list;
			}
		}

		StringBuilder builder = new StringBuilder();
		builder.append(sArray[0]);

		int i = 1;
		String text;

		while(i < sArray.length)
		{
			if(builder.length() + sArray[i].length() + 1 <= k)
			{
				builder.append(" ");
				builder.append(sArray[i]);
			}
			else
			{
				text = builder.toString();
				list.add(text);
				builder = new StringBuilder();
				builder.append(sArray[i]);
			}
			i++;
		}
			
		text = builder.toString();
		list.add(text);		
	
		return list;
	}
}

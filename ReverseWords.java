/* daily coding problem #113 */

/* Given a string of words delimited by spaces,
* reverse the words in string. For example, given
* "hello world here", return "here world hello"
*/

import java.lang.StringBuilder;

public class ReverseWords
{
	public static void main(String[] args)
	{
		String s = "hello world here";
		String result = reverseWords(s);
		System.out.println(result);
	}

	public static String reverseWords(String s)
	{
		if(s == null | s.length == 0)
		{
			return "";
		}

		String[] arr = s.split(" ");
		int i = 0;
		int j = arr.length - 1;

		while(i < j)
		{
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++; 
			j--;
		}

		// or skip the above while loop
		// append to builder from arr.length-1
		StringBuilder builder = new StringBuilder();
		for(i = 0; i < arr.length; i++)
		{
			String word = arr[i] + " ";
			builder.append(word);
		}
		
		String result = builder.toString();
		result = result.substring(0, result.length() - 1);

		return result;
	}
}

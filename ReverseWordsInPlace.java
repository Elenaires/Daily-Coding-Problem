/* daily coding problem #113 */

/* Given a string of words delimited by spaces, 
* reverse the words in string. For example,
* given "hello world here", return "here world hello"
* no extra space allowed 
*/

public class ReverseWordsInPlace
{
	public static void main(String[] args)
	{
		char[] arr = new char[]{'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
		reverseWords(arr);

		System.out.println(String.valueOf(arr));
	}
	
	public static void reverseWords(char[] arr)
	{		
		int i = 0;

		// reverse the char sequence of every single word
		// hello world --> olleh dlrow
		for(int j = 0; j < arr.length; j++)
		{
			if(arr[j] == ' ')
			{
				reverse(arr, i, j-1);
				i = j+1;
			}
		}

		// perform reverse for the last word
		reverse(arr, i, arr.length-1);

		// reverse the entire char array
		// example: olleh dlrow --> world hello
		reverse(arr, 0, arr.length-1);
		
	}

	public static void reverse(char[] arr, int start, int end)
	{
		while(start < end)
		{
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
